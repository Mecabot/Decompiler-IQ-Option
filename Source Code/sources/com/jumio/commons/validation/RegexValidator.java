package com.jumio.commons.validation;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator implements Serializable {
    private static final long serialVersionUID = -8832409930574867162L;
    private final Pattern[] patterns;

    public RegexValidator(String str) {
        this(str, true);
    }

    public RegexValidator(String str, boolean z) {
        this(new String[]{str}, z);
    }

    public RegexValidator(String[] strArr) {
        this(strArr, true);
    }

    public RegexValidator(String[] strArr, boolean z) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("Regular expressions are missing");
        }
        this.patterns = new Pattern[strArr.length];
        int i = 0;
        int i2 = z ? 0 : 2;
        while (i < strArr.length) {
            if (strArr[i] == null || strArr[i].length() == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Regular expression[");
                stringBuilder.append(i);
                stringBuilder.append("] is missing");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.patterns[i] = Pattern.compile(strArr[i], i2);
            i++;
        }
    }

    public boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        for (Pattern matcher : this.patterns) {
            if (matcher.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    public String[] match(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int i2;
        for (Pattern matcher : this.patterns) {
            Matcher matcher2 = matcher.matcher(str);
            if (matcher2.matches()) {
                int groupCount = matcher2.groupCount();
                String[] strArr = new String[groupCount];
                while (i < groupCount) {
                    i2 = i + 1;
                    strArr[i] = matcher2.group(i2);
                    i = i2;
                }
                return strArr;
            }
        }
        return null;
    }

    public String validate(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        for (Pattern matcher : this.patterns) {
            Matcher matcher2 = matcher.matcher(str);
            if (matcher2.matches()) {
                int groupCount = matcher2.groupCount();
                if (groupCount == 1) {
                    return matcher2.group(1);
                }
                StringBuilder stringBuilder = new StringBuilder();
                while (i < groupCount) {
                    i++;
                    String group = matcher2.group(i);
                    if (group != null) {
                        stringBuilder.append(group);
                    }
                }
                return stringBuilder.toString();
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RegexValidator{");
        for (int i = 0; i < this.patterns.length; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(this.patterns[i].pattern());
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
