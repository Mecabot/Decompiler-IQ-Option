package com.jumio.commons.validation;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlValidator implements Serializable {
    public static final long ALLOW_2_SLASHES = 2;
    public static final long ALLOW_ALL_SCHEMES = 1;
    public static final long ALLOW_LOCAL_URLS = 8;
    private static final String AUTHORITY_CHARS_REGEX = "\\p{Alnum}\\-\\.";
    private static final Pattern AUTHORITY_PATTERN = Pattern.compile(AUTHORITY_REGEX);
    private static final String AUTHORITY_REGEX = "(?:\\[([0-9a-fA-F:]+)\\]|(?:(?:[a-zA-Z0-9%-._~!$&'()*+,;=]+(?::[a-zA-Z0-9%-._~!$&'()*+,;=]*)?@)?([\\p{Alnum}\\-\\.]*)))(?::(\\d*))?(.*)?";
    private static final String[] DEFAULT_SCHEMES = new String[]{"http", "https", "ftp"};
    private static final UrlValidator DEFAULT_URL_VALIDATOR = new UrlValidator();
    private static final String IPV6_REGEX = "[0-9a-fA-F:]+";
    private static final int MAX_UNSIGNED_16_BIT_INT = 65535;
    public static final long NO_FRAGMENTS = 4;
    private static final int PARSE_AUTHORITY_EXTRA = 4;
    private static final int PARSE_AUTHORITY_HOST_IP = 2;
    private static final int PARSE_AUTHORITY_IPV6 = 1;
    private static final int PARSE_AUTHORITY_PORT = 3;
    private static final int PARSE_URL_AUTHORITY = 4;
    private static final int PARSE_URL_FRAGMENT = 9;
    private static final int PARSE_URL_PATH = 5;
    private static final int PARSE_URL_QUERY = 7;
    private static final int PARSE_URL_SCHEME = 2;
    private static final Pattern PATH_PATTERN = Pattern.compile(PATH_REGEX);
    private static final String PATH_REGEX = "^(/[-\\w:@&?=+,.!/~*'%$_;\\(\\)]*)?$";
    private static final Pattern QUERY_PATTERN = Pattern.compile(QUERY_REGEX);
    private static final String QUERY_REGEX = "^(\\S*)$";
    private static final Pattern SCHEME_PATTERN = Pattern.compile(SCHEME_REGEX);
    private static final String SCHEME_REGEX = "^\\p{Alpha}[\\p{Alnum}\\+\\-\\.]*";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    private static final String URL_REGEX = "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?";
    private static final String USERINFO_CHARS_REGEX = "[a-zA-Z0-9%-._~!$&'()*+,;=]";
    private static final String USERINFO_FIELD_REGEX = "[a-zA-Z0-9%-._~!$&'()*+,;=]+(?::[a-zA-Z0-9%-._~!$&'()*+,;=]*)?@";
    private static final long serialVersionUID = 7557161713937335013L;
    private final Set<String> allowedSchemes;
    private final RegexValidator authorityValidator;
    private final long options;

    public static UrlValidator getInstance() {
        return DEFAULT_URL_VALIDATOR;
    }

    public UrlValidator() {
        this(null);
    }

    public UrlValidator(String[] strArr) {
        this(strArr, 0);
    }

    public UrlValidator(long j) {
        this(null, null, j);
    }

    public UrlValidator(String[] strArr, long j) {
        this(strArr, null, j);
    }

    public UrlValidator(RegexValidator regexValidator, long j) {
        this(null, regexValidator, j);
    }

    public UrlValidator(String[] strArr, RegexValidator regexValidator, long j) {
        this.options = j;
        if (isOn(1)) {
            this.allowedSchemes = Collections.emptySet();
        } else {
            if (strArr == null) {
                strArr = DEFAULT_SCHEMES;
            }
            this.allowedSchemes = new HashSet(strArr.length);
            for (String toLowerCase : strArr) {
                this.allowedSchemes.add(toLowerCase.toLowerCase(Locale.ENGLISH));
            }
        }
        this.authorityValidator = regexValidator;
    }

    public boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = URL_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        String group = matcher.group(2);
        if (!isValidScheme(group)) {
            return false;
        }
        String group2 = matcher.group(4);
        if ("file".equals(group)) {
            if (group2 != null && group2.contains(":")) {
                return false;
            }
        } else if (!isValidAuthority(group2)) {
            return false;
        }
        if (isValidPath(matcher.group(5)) && isValidQuery(matcher.group(7)) && isValidFragment(matcher.group(9))) {
            return true;
        }
        return false;
    }

    protected boolean isValidScheme(String str) {
        if (str == null || !SCHEME_PATTERN.matcher(str).matches()) {
            return false;
        }
        if (!isOff(1) || this.allowedSchemes.contains(str.toLowerCase(Locale.ENGLISH))) {
            return true;
        }
        return false;
    }

    protected boolean isValidAuthority(String str) {
        if (str == null) {
            return false;
        }
        if (this.authorityValidator != null && this.authorityValidator.isValid(str)) {
            return true;
        }
        Matcher matcher = AUTHORITY_PATTERN.matcher(DomainValidator.unicodeToASCII(str));
        if (!matcher.matches()) {
            return false;
        }
        String group = matcher.group(1);
        if (group == null) {
            group = matcher.group(2);
            if (!DomainValidator.getInstance(isOn(8)).isValid(group) && !InetAddressValidator.getInstance().isValidInet4Address(group)) {
                return false;
            }
            group = matcher.group(3);
            if (group != null && group.length() > 0) {
                try {
                    int parseInt = Integer.parseInt(group);
                    if (parseInt < 0 || parseInt > 65535) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                    return false;
                }
            }
        } else if (!InetAddressValidator.getInstance().isValidInet6Address(group)) {
            return false;
        }
        str = matcher.group(4);
        return str == null || str.trim().length() <= 0;
    }

    protected boolean isValidPath(String str) {
        if (str == null || !PATH_PATTERN.matcher(str).matches()) {
            return false;
        }
        try {
            String path = new URI(null, null, str, null).normalize().getPath();
            if (path.startsWith("/../") || path.equals("/..")) {
                return false;
            }
            int countToken = countToken("//", str);
            if (!isOff(2) || countToken <= 0) {
                return true;
            }
            return false;
        } catch (URISyntaxException unused) {
            return false;
        }
    }

    protected boolean isValidQuery(String str) {
        return str == null ? true : QUERY_PATTERN.matcher(str).matches();
    }

    protected boolean isValidFragment(String str) {
        return str == null ? true : isOff(4);
    }

    protected int countToken(String str, String str2) {
        int i = 0;
        int i2 = 0;
        while (i != -1) {
            i = str2.indexOf(str, i);
            if (i > -1) {
                i++;
                i2++;
            }
        }
        return i2;
    }

    private boolean isOn(long j) {
        return (this.options & j) > 0;
    }

    private boolean isOff(long j) {
        return (this.options & j) == 0;
    }

    Matcher matchURL(String str) {
        return URL_PATTERN.matcher(str);
    }
}
