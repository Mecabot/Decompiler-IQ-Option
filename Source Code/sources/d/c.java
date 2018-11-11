package d;

import com.facebook.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: DeviceParser */
public class c {
    List<a> flb;

    /* compiled from: DeviceParser */
    protected static class a {
        private static final Pattern flc = Pattern.compile("\\$\\d");
        private final String fld;
        private final Pattern pattern;

        public a(Pattern pattern, String str) {
            this.pattern = pattern;
            this.fld = str;
        }

        public String ob(String str) {
            Matcher matcher = this.pattern.matcher(str);
            String str2 = null;
            if (!matcher.find()) {
                return null;
            }
            if (this.fld != null) {
                if (this.fld.contains("$")) {
                    String str3 = this.fld;
                    for (String str4 : oc(this.fld)) {
                        int intValue = Integer.valueOf(str4.substring(1)).intValue();
                        String quoteReplacement = (matcher.groupCount() < intValue || matcher.group(intValue) == null) ? "" : Matcher.quoteReplacement(matcher.group(intValue));
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("\\");
                        stringBuilder.append(str4);
                        str3 = str3.replaceFirst(stringBuilder.toString(), quoteReplacement);
                    }
                    str2 = str3.trim();
                } else {
                    str2 = this.fld;
                }
            } else if (matcher.groupCount() >= 1) {
                str2 = matcher.group(1);
            }
            return str2;
        }

        private List<String> oc(String str) {
            Matcher matcher = flc.matcher(str);
            List<String> arrayList = new ArrayList();
            while (matcher.find()) {
                arrayList.add(matcher.group());
            }
            return arrayList;
        }
    }

    public c(List<a> list) {
        this.flb = list;
    }

    public b oa(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        for (a ob : this.flb) {
            str2 = ob.ob(str);
            if (str2 != null) {
                break;
            }
        }
        if (str2 == null) {
            str2 = "Other";
        }
        return new b(str2);
    }

    public static c ct(List<Map<String, String>> list) {
        List arrayList = new ArrayList();
        for (Map Q : list) {
            arrayList.add(Q(Q));
        }
        return new c(arrayList);
    }

    protected static a Q(Map<String, String> map) {
        String str = (String) map.get("regex");
        if (str == null) {
            throw new IllegalArgumentException("Device is missing regex");
        }
        return new a(i.TAG.equals(map.get("regex_flag")) ? Pattern.compile(str, 2) : Pattern.compile(str), (String) map.get("device_replacement"));
    }
}
