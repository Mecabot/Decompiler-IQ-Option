package d;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.c;
import org.yaml.snakeyaml.constructor.e;

/* compiled from: Parser */
public class f {
    private h flm;
    private e fln;
    private c flo;

    public f() {
        this(f.class.getResourceAsStream("/ua_parser/regexes.yaml"));
    }

    public f(InputStream inputStream) {
        w(inputStream);
    }

    public a oh(String str) {
        return new a(oi(str), oj(str), this.flo.oa(str));
    }

    public g oi(String str) {
        return this.flm.ok(str);
    }

    public d oj(String str) {
        return this.fln.od(str);
    }

    private void w(InputStream inputStream) {
        Map map = (Map) new c(new e()).v(inputStream);
        List list = (List) map.get("user_agent_parsers");
        if (list == null) {
            throw new IllegalArgumentException("user_agent_parsers is missing from yaml");
        }
        this.flm = h.cv(list);
        list = (List) map.get("os_parsers");
        if (list == null) {
            throw new IllegalArgumentException("os_parsers is missing from yaml");
        }
        this.fln = e.cu(list);
        List list2 = (List) map.get("device_parsers");
        if (list2 == null) {
            throw new IllegalArgumentException("device_parsers is missing from yaml");
        }
        this.flo = c.ct(list2);
    }
}
