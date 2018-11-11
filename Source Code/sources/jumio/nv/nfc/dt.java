package jumio.nv.nfc;

import java.util.Enumeration;
import java.util.Properties;

/* compiled from: ParameterList */
public class dt extends Properties {
    public dt(dt dtVar) {
        super(dtVar);
    }

    public dt a() {
        return (dt) this.defaults;
    }

    public String a(String str) {
        String str2 = (String) get(str);
        return (str2 != null || this.defaults == null) ? str2 : this.defaults.getProperty(str);
    }

    public boolean b(String str) {
        String a = a(str);
        if (a == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No parameter with name ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (a.equals("on")) {
            return true;
        } else {
            if (a.equals("off")) {
                return false;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Parameter \"");
            stringBuilder2.append(str);
            stringBuilder2.append("\" is not boolean: ");
            stringBuilder2.append(a);
            throw new du(stringBuilder2.toString());
        }
    }

    public int c(String str) {
        String a = a(str);
        if (a == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No parameter with name ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        try {
            return Integer.parseInt(a);
        } catch (NumberFormatException e) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Parameter \"");
            stringBuilder2.append(str);
            stringBuilder2.append("\" is not integer: ");
            stringBuilder2.append(e.getMessage());
            throw new NumberFormatException(stringBuilder2.toString());
        }
    }

    public float d(String str) {
        String a = a(str);
        if (a == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No parameter with name ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        try {
            return new Float(a).floatValue();
        } catch (NumberFormatException e) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Parameter \"");
            stringBuilder2.append(str);
            stringBuilder2.append("\" is not floating-point: ");
            stringBuilder2.append(e.getMessage());
            throw new NumberFormatException(stringBuilder2.toString());
        }
    }

    public void a(char c, String[] strArr) {
        Enumeration propertyNames = propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            if (str.length() > 0) {
                int i = 0;
                if (str.charAt(0) != c) {
                    continue;
                } else {
                    if (strArr != null) {
                        for (int length = strArr.length - 1; length >= 0; length--) {
                            if (str.equals(strArr[length])) {
                                i = 1;
                                break;
                            }
                        }
                    }
                    if (i == 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Option '");
                        stringBuilder.append(str);
                        stringBuilder.append("' is ");
                        stringBuilder.append("not a valid one.");
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
            }
        }
    }

    public void a(char[] cArr, String[] strArr) {
        Enumeration propertyNames = propertyNames();
        String str = new String(cArr);
        while (propertyNames.hasMoreElements()) {
            String str2 = (String) propertyNames.nextElement();
            if (str2.length() > 0) {
                int i = 0;
                if (str.indexOf(str2.charAt(0)) != -1) {
                    continue;
                } else {
                    if (strArr != null) {
                        for (int length = strArr.length - 1; length >= 0; length--) {
                            if (str2.equals(strArr[length])) {
                                i = 1;
                                break;
                            }
                        }
                    }
                    if (i == 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Option '");
                        stringBuilder.append(str2);
                        stringBuilder.append("' is ");
                        stringBuilder.append("not a valid one.");
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
            }
        }
    }

    public static String[] a(String[][] strArr) {
        if (strArr == null) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        for (int length = strArr.length - 1; length >= 0; length--) {
            strArr2[length] = strArr[length][0];
        }
        return strArr2;
    }
}
