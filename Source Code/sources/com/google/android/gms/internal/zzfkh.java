package com.google.android.gms.internal;

final class zzfkh {
    static String zzbd(zzfgs zzfgs) {
        zzfkj zzfki = new zzfki(zzfgs);
        StringBuilder stringBuilder = new StringBuilder(zzfki.size());
        for (int i = 0; i < zzfki.size(); i++) {
            String str;
            int zzld = zzfki.zzld(i);
            if (zzld == 34) {
                str = "\\\"";
            } else if (zzld == 39) {
                str = "\\'";
            } else if (zzld != 92) {
                switch (zzld) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (zzld < 32 || zzld > 126) {
                            stringBuilder.append('\\');
                            stringBuilder.append((char) (((zzld >>> 6) & 3) + 48));
                            stringBuilder.append((char) (((zzld >>> 3) & 7) + 48));
                            zzld = (zzld & 7) + 48;
                        }
                        stringBuilder.append((char) zzld);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
