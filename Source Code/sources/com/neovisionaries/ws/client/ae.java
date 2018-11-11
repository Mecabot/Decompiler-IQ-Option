package com.neovisionaries.ws.client;

/* compiled from: Token */
class ae {
    public static boolean isSeparator(char c) {
        if (!(c == 9 || c == ' ' || c == '\"' || c == ',' || c == '/' || c == '{' || c == '}')) {
            switch (c) {
                case '(':
                case ')':
                    break;
                default:
                    switch (c) {
                        case ':':
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                        case '?':
                        case '@':
                            break;
                        default:
                            switch (c) {
                                case '[':
                                case '\\':
                                case ']':
                                    break;
                                default:
                                    return false;
                            }
                    }
            }
        }
        return true;
    }

    public static boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (isSeparator(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String unquote(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length >= 2 && str.charAt(0) == '\"') {
            length--;
            if (str.charAt(length) == '\"') {
                return unescape(str.substring(1, length));
            }
        }
        return str;
    }

    public static String unescape(String str) {
        if (str == null) {
            return null;
        }
        if (str.indexOf(92) < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = null;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\\' && obj == null) {
                obj = 1;
            } else {
                stringBuilder.append(charAt);
                obj = null;
            }
        }
        return stringBuilder.toString();
    }
}
