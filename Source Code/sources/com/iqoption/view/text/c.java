package com.iqoption.view.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.iqoption.core.i;
import java.util.Calendar;

/* compiled from: AsYouTypeDateFormatter */
public class c implements w {
    private static final String TAG = "com.iqoption.view.text.c";
    private StringBuilder ZD = new StringBuilder();
    private StringBuilder ZE = new StringBuilder();
    private boolean ZF = true;
    private int ZV = 0;
    private int ZX = 0;
    private String Zz = "";
    @Nullable
    private z dJh;

    public void clear() {
        this.Zz = "";
        this.ZD.setLength(0);
        this.ZE.setLength(0);
        this.ZF = true;
        this.ZX = 0;
        this.ZV = 0;
    }

    public String i(char c) {
        this.Zz = a(c, false);
        return this.Zz;
    }

    public String j(char c) {
        this.Zz = a(c, true);
        return this.Zz;
    }

    private String a(char c, boolean z) {
        this.ZD.append(c);
        if (z) {
            this.ZV = this.ZD.length();
        }
        if (Character.isDigit(c)) {
            c(c, z);
        } else {
            this.ZF = false;
            if (this.dJh != null) {
                this.dJh.aqs();
            }
        }
        if (!this.ZF) {
            return this.ZD.toString();
        }
        if (this.ZE.length() >= 4) {
            if (Integer.parseInt(this.ZE.substring(0, 2)) > 31) {
                if (this.dJh != null) {
                    this.dJh.aqs();
                }
                return this.ZD.substring(0, 4);
            } else if (Integer.parseInt(this.ZE.substring(2, 4)) > 12) {
                if (this.dJh != null) {
                    this.dJh.aqs();
                }
                return this.ZD.substring(0, 5);
            }
        } else if (this.ZE.length() >= 2 && Integer.parseInt(this.ZE.substring(0, 2)) > 31) {
            if (this.dJh != null) {
                this.dJh.aqs();
            }
            return this.ZD.substring(0, 2);
        }
        int length = this.ZE.length();
        if (length == 3) {
            this.ZD.insert(2, '.');
            return this.ZD.toString();
        } else if (length != 5) {
            String substring;
            if (this.ZE.length() > 8) {
                substring = this.ZD.substring(0, Math.min(10, this.ZD.length()));
            } else {
                substring = this.ZD.toString();
            }
            if (this.dJh != null) {
                if (isCompleted()) {
                    this.dJh.p(getDay(), getMonth(), getYear());
                } else {
                    this.dJh.aqt();
                }
            }
            return substring;
        } else {
            this.ZD.insert(5, '.');
            return this.ZD.toString();
        }
    }

    public boolean isCompleted() {
        return this.ZE.length() >= 8;
    }

    public int xf() {
        if (!this.ZF) {
            return this.ZV;
        }
        int i = 0;
        int i2 = 0;
        while (i < this.ZX && i2 < this.Zz.length()) {
            if (this.ZE.charAt(i) == this.Zz.charAt(i2)) {
                i++;
            }
            i2++;
        }
        return i2;
    }

    public boolean isValid() {
        return aJE() && aJF() && aJG();
    }

    public boolean aJE() {
        boolean z = false;
        if (getYear() <= 0 || getMonth() <= 0 || getDay() <= 0) {
            int day = getDay();
            if (day > 0 && day <= 31) {
                z = true;
            }
            return z;
        }
        if (getDay() <= t(getYear(), getMonth(), getDay()).getActualMaximum(5)) {
            z = true;
        }
        return z;
    }

    public boolean aJF() {
        boolean z = false;
        if (getYear() <= 0 || getMonth() <= 0 || getDay() <= 0) {
            int month = getMonth();
            if (month > 0 && month <= 12) {
                z = true;
            }
            return z;
        }
        if (getMonth() <= t(getYear(), getMonth(), getDay()).getActualMaximum(2) + 1) {
            z = true;
        }
        return z;
    }

    public boolean aJG() {
        boolean z = false;
        if (getYear() > 0 && getMonth() > 0 && getDay() > 0) {
            if (getYear() > t(getYear(), getMonth(), getDay()).getActualMaximum(1)) {
                return false;
            }
        }
        int year = getYear();
        if (year > 1900 && year <= Calendar.getInstance().get(1)) {
            z = true;
        }
        return z;
    }

    public boolean aJH() {
        return this.ZE.length() >= 2;
    }

    public boolean aJI() {
        return this.ZE.length() >= 4;
    }

    public boolean aJJ() {
        return this.ZE.length() >= 8;
    }

    public int getDay() {
        int i = 0;
        try {
            if (this.ZE.length() >= 2) {
                i = Integer.valueOf(this.ZE.substring(0, 2)).intValue();
            }
            return i;
        } catch (Throwable e) {
            i.e(TAG, "unable to get day", e);
            return 0;
        }
    }

    public int getMonth() {
        int i = 0;
        try {
            if (this.ZE.length() >= 4) {
                i = Integer.valueOf(this.ZE.substring(2, 4)).intValue();
            }
            return i;
        } catch (Throwable e) {
            i.e(TAG, "unable to get month", e);
            return 0;
        }
    }

    public int getYear() {
        int i = 0;
        try {
            if (this.ZE.length() >= 8) {
                i = Integer.valueOf(this.ZE.substring(4, 8)).intValue();
            }
            return i;
        } catch (Throwable e) {
            i.e(TAG, "unable to get year", e);
            return 0;
        }
    }

    @NonNull
    private Calendar t(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2 - 1, i3);
        return instance;
    }

    public void setValidationListener(z zVar) {
        this.dJh = zVar;
    }

    private char c(char c, boolean z) {
        c = Character.forDigit(Character.digit(c, 10), 10);
        this.ZE.append(c);
        if (z) {
            this.ZX = this.ZE.length();
        }
        return c;
    }
}
