package com.jumio.core.util;

import com.jumio.commons.validation.InetAddressValidator;
import com.jumio.commons.validation.UrlValidator;
import java.util.regex.Pattern;

public class JumioUrlValidator extends UrlValidator {
    private static final Pattern PATH_PATTERN = Pattern.compile("^(([-/\\w:@&?=+,.!~*'$_;]|(%[0-9a-fA-F]{2}))*)?$");
    private static final Pattern QUERY_PATTERN = Pattern.compile("^(([-\\w:@&?=+,.!~*'$_;]|(%[0-9a-fA-F]{2}))*)?$");
    private static final String[] VALID_SCHEMES = new String[]{"https", "http"};
    private static final long serialVersionUID = 421988208904137814L;
    private boolean allowIPs;
    private boolean allowPorts;
    private boolean allowQuery;
    private boolean allowUnicode;

    public JumioUrlValidator() {
        this(VALID_SCHEMES, true, true, true, true);
    }

    public JumioUrlValidator(String[] strArr, boolean z, boolean z2, boolean z3, boolean z4) {
        super(strArr, 4);
        this.allowPorts = true;
        this.allowIPs = true;
        this.allowUnicode = true;
        this.allowQuery = true;
        this.allowUnicode = z;
        this.allowIPs = z2;
        this.allowPorts = z3;
        this.allowQuery = z4;
    }

    protected boolean isValidAuthority(String str) {
        boolean z = false;
        if (!this.allowIPs && InetAddressValidator.getInstance().isValid(str)) {
            return false;
        }
        if ((this.allowUnicode || isOnlyASCII(str)) && super.isValidAuthority(str) && (this.allowPorts || str.split(":").length < 2)) {
            z = true;
        }
        return z;
    }

    protected boolean isValidQuery(String str) {
        return str == null || (this.allowQuery && super.isValidQuery(str) && QUERY_PATTERN.matcher(str).matches());
    }

    protected boolean isValidPath(String str) {
        return str == null || (super.isValidPath(str) && PATH_PATTERN.matcher(str).matches());
    }

    private static boolean isOnlyASCII(String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }
}
