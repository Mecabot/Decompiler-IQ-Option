package com.jumio.commons.validation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InetAddressValidator implements Serializable {
    private static final int BASE_16 = 16;
    private static final int IPV4_MAX_OCTET_VALUE = 255;
    private static final String IPV4_REGEX = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
    private static final int IPV6_MAX_HEX_DIGITS_PER_GROUP = 4;
    private static final int IPV6_MAX_HEX_GROUPS = 8;
    private static final int MAX_UNSIGNED_SHORT = 65535;
    private static final InetAddressValidator VALIDATOR = new InetAddressValidator();
    private static final long serialVersionUID = -919201640201914789L;
    private final RegexValidator ipv4Validator = new RegexValidator(IPV4_REGEX);

    public static InetAddressValidator getInstance() {
        return VALIDATOR;
    }

    public boolean isValid(String str) {
        return isValidInet4Address(str) || isValidInet6Address(str);
    }

    public boolean isValidInet4Address(String str) {
        String[] match = this.ipv4Validator.match(str);
        if (match == null) {
            return false;
        }
        int length = match.length;
        int i = 0;
        while (i < length) {
            String str2 = match[i];
            if (str2 == null || str2.length() == 0) {
                return false;
            }
            try {
                if (Integer.parseInt(str2) > 255) {
                    return false;
                }
                if (str2.length() > 1 && str2.startsWith("0")) {
                    return false;
                }
                i++;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidInet6Address(String str) {
        boolean contains = str.contains("::");
        if (contains && str.indexOf("::") != str.lastIndexOf("::")) {
            return false;
        }
        if ((str.startsWith(":") && !str.startsWith("::")) || (str.endsWith(":") && !str.endsWith("::"))) {
            return false;
        }
        String[] split = str.split(":");
        if (contains) {
            List arrayList = new ArrayList(Arrays.asList(split));
            if (str.endsWith("::")) {
                arrayList.add("");
            } else if (str.startsWith("::") && !arrayList.isEmpty()) {
                arrayList.remove(0);
            }
            split = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        if (split.length > 8) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < split.length; i3++) {
            String str2 = split[i3];
            if (str2.length() == 0) {
                i2++;
                if (i2 > 1) {
                    return false;
                }
            } else if (i3 == split.length - 1 && str2.contains(".")) {
                if (!isValidInet4Address(str2)) {
                    return false;
                }
                i += 2;
                i2 = 0;
            } else if (str2.length() > 4) {
                return false;
            } else {
                try {
                    i2 = Integer.parseInt(str2, 16);
                    if (i2 < 0 || i2 > 65535) {
                        return false;
                    }
                    i2 = 0;
                } catch (NumberFormatException unused) {
                    return false;
                }
            }
            i++;
        }
        if (i > 8 || (i < 8 && !contains)) {
            return false;
        }
        return true;
    }
}
