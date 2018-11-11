package com.iqoption.util.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.telephony.PhoneNumberUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: QRCodeEncoder */
public final class b {
    private int dxb = Integer.MIN_VALUE;
    private String dxc = null;
    private String dxd = null;
    private BarcodeFormat dxe = null;
    private boolean dxf = false;
    private String title = null;

    public b(String str, Bundle bundle, String str2, String str3, int i) {
        this.dxb = i;
        this.dxf = a(str, bundle, str2, str3);
    }

    private boolean a(String str, Bundle bundle, String str2, String str3) {
        this.dxe = null;
        if (str3 != null) {
            try {
                this.dxe = BarcodeFormat.valueOf(str3);
            } catch (IllegalArgumentException unused) {
                if (this.dxe == null || this.dxe == BarcodeFormat.QR_CODE) {
                    this.dxe = BarcodeFormat.QR_CODE;
                    a(str, bundle, str2);
                } else if (str != null && str.length() > 0) {
                    this.dxc = str;
                    this.dxd = str;
                    this.title = "Text";
                }
                return this.dxc != null && this.dxc.length() > 0;
            }
        }
    }

    private void a(String str, Bundle bundle, String str2) {
        StringBuilder stringBuilder;
        if (str2.equals("TEXT_TYPE")) {
            if (str != null && str.length() > 0) {
                this.dxc = str;
                this.dxd = str;
                this.title = "Text";
            }
        } else if (str2.equals("EMAIL_TYPE")) {
            str = trim(str);
            if (str != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("mailto:");
                stringBuilder.append(str);
                this.dxc = stringBuilder.toString();
                this.dxd = str;
                this.title = "E-Mail";
            }
        } else if (str2.equals("PHONE_TYPE")) {
            str = trim(str);
            if (str != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("tel:");
                stringBuilder.append(str);
                this.dxc = stringBuilder.toString();
                this.dxd = PhoneNumberUtils.formatNumber(str);
                this.title = "Phone";
            }
        } else if (str2.equals("SMS_TYPE")) {
            str = trim(str);
            if (str != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("sms:");
                stringBuilder.append(str);
                this.dxc = stringBuilder.toString();
                this.dxd = PhoneNumberUtils.formatNumber(str);
                this.title = "SMS";
            }
        } else if (str2.equals("CONTACT_TYPE")) {
            if (bundle != null) {
                String trim;
                StringBuilder stringBuilder2 = new StringBuilder(100);
                StringBuilder stringBuilder3 = new StringBuilder(100);
                stringBuilder2.append("MECARD:");
                str2 = trim(bundle.getString("name"));
                if (str2 != null) {
                    stringBuilder2.append("N:");
                    stringBuilder2.append(jQ(str2));
                    stringBuilder2.append(';');
                    stringBuilder3.append(str2);
                }
                str2 = trim(bundle.getString("postal"));
                if (str2 != null) {
                    stringBuilder2.append("ADR:");
                    stringBuilder2.append(jQ(str2));
                    stringBuilder2.append(';');
                    stringBuilder3.append(10);
                    stringBuilder3.append(str2);
                }
                Collection<String> hashSet = new HashSet(a.dwX.length);
                for (String string : a.dwX) {
                    String string2 = trim(bundle.getString(string2));
                    if (string2 != null) {
                        hashSet.add(string2);
                    }
                }
                for (String trim2 : hashSet) {
                    stringBuilder2.append("TEL:");
                    stringBuilder2.append(jQ(trim2));
                    stringBuilder2.append(';');
                    stringBuilder3.append(10);
                    stringBuilder3.append(PhoneNumberUtils.formatNumber(trim2));
                }
                hashSet = new HashSet(a.dwZ.length);
                for (String trim22 : a.dwZ) {
                    trim22 = trim(bundle.getString(trim22));
                    if (trim22 != null) {
                        hashSet.add(trim22);
                    }
                }
                for (String str3 : hashSet) {
                    stringBuilder2.append("EMAIL:");
                    stringBuilder2.append(jQ(str3));
                    stringBuilder2.append(';');
                    stringBuilder3.append(10);
                    stringBuilder3.append(str3);
                }
                str2 = trim(bundle.getString("URL_KEY"));
                if (str2 != null) {
                    stringBuilder2.append("URL:");
                    stringBuilder2.append(str2);
                    stringBuilder2.append(';');
                    stringBuilder3.append(10);
                    stringBuilder3.append(str2);
                }
                String trim3 = trim(bundle.getString("NOTE_KEY"));
                if (trim3 != null) {
                    stringBuilder2.append("NOTE:");
                    stringBuilder2.append(jQ(trim3));
                    stringBuilder2.append(';');
                    stringBuilder3.append(10);
                    stringBuilder3.append(trim3);
                }
                if (stringBuilder3.length() > 0) {
                    stringBuilder2.append(';');
                    this.dxc = stringBuilder2.toString();
                    this.dxd = stringBuilder3.toString();
                    this.title = "Contact";
                    return;
                }
                this.dxc = null;
                this.dxd = null;
            }
        } else if (str2.equals("LOCATION_TYPE") && bundle != null) {
            float f = bundle.getFloat("LAT", Float.MAX_VALUE);
            float f2 = bundle.getFloat("LONG", Float.MAX_VALUE);
            if (f != Float.MAX_VALUE && f2 != Float.MAX_VALUE) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("geo:");
                stringBuilder4.append(f);
                stringBuilder4.append(',');
                stringBuilder4.append(f2);
                this.dxc = stringBuilder4.toString();
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(f);
                stringBuilder4.append(",");
                stringBuilder4.append(f2);
                this.dxd = stringBuilder4.toString();
                this.title = "Location";
            }
        }
    }

    public Bitmap aGJ() {
        if (!this.dxf) {
            return null;
        }
        Map enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put(EncodeHintType.MARGIN, Integer.valueOf(0));
        String C = C(this.dxc);
        if (C != null) {
            enumMap.put(EncodeHintType.CHARACTER_SET, C);
        }
        com.google.zxing.common.b a = new com.google.zxing.b().a(this.dxc, this.dxe, this.dxb, this.dxb, enumMap);
        int width = a.getWidth();
        int height = a.getHeight();
        int[] iArr = new int[(width * height)];
        for (int i = 0; i < height; i++) {
            int i2 = i * width;
            for (int i3 = 0; i3 < width; i3++) {
                iArr[i2 + i3] = a.L(i3, i) ? ViewCompat.MEASURED_STATE_MASK : -1;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    private static String C(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) > 255) {
                return "UTF-8";
            }
        }
        return null;
    }

    private static String trim(String str) {
        if (str == null) {
            return null;
        }
        str = str.trim();
        if (str.length() == 0) {
            str = null;
        }
        return str;
    }

    private static String jQ(String str) {
        if (str == null || (str.indexOf(58) < 0 && str.indexOf(59) < 0)) {
            return str;
        }
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == ':' || charAt == ';') {
                stringBuilder.append('\\');
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }
}
