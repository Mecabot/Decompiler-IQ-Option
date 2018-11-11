package org.yaml.snakeyaml;

import java.io.InputStream;
import org.yaml.snakeyaml.b.a;
import org.yaml.snakeyaml.constructor.b;
import org.yaml.snakeyaml.constructor.d;
import org.yaml.snakeyaml.error.YAMLException;

/* compiled from: Yaml */
public class c {
    protected final a fhC;
    protected b fhD;
    protected org.yaml.snakeyaml.representer.c fhE;
    protected DumperOptions fhF;
    protected a fhG;
    private String name;

    public c() {
        this(new d(), new org.yaml.snakeyaml.representer.c(), new DumperOptions(), new a(), new a());
    }

    public c(b bVar) {
        this(bVar, new org.yaml.snakeyaml.representer.c());
    }

    public c(b bVar, org.yaml.snakeyaml.representer.c cVar) {
        this(bVar, cVar, a(cVar));
    }

    private static DumperOptions a(org.yaml.snakeyaml.representer.c cVar) {
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.a(cVar.bDG());
        dumperOptions.a(cVar.bDE());
        dumperOptions.hu(cVar.bDQ().bDH());
        dumperOptions.setTimeZone(cVar.getTimeZone());
        return dumperOptions;
    }

    public c(b bVar, org.yaml.snakeyaml.representer.c cVar, DumperOptions dumperOptions) {
        this(bVar, cVar, dumperOptions, new a(), new a());
    }

    public c(b bVar, org.yaml.snakeyaml.representer.c cVar, DumperOptions dumperOptions, a aVar, a aVar2) {
        if (!bVar.bDR()) {
            bVar.a(cVar.bDQ());
        } else if (!cVar.bDR()) {
            cVar.a(bVar.bDQ());
        }
        this.fhD = bVar;
        this.fhD.hv(aVar.bDI());
        if (dumperOptions.getIndent() <= dumperOptions.bDF()) {
            throw new YAMLException("Indicator indent must be smaller then indent.");
        }
        cVar.a(dumperOptions.bDG());
        cVar.a(dumperOptions.bDE());
        cVar.bDQ().hu(dumperOptions.bDH());
        cVar.setTimeZone(dumperOptions.getTimeZone());
        this.fhE = cVar;
        this.fhF = dumperOptions;
        this.fhG = aVar;
        this.fhC = aVar2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Yaml:");
        stringBuilder.append(System.identityHashCode(this));
        this.name = stringBuilder.toString();
    }

    public <T> T v(InputStream inputStream) {
        return a(new org.yaml.snakeyaml.reader.a(new org.yaml.snakeyaml.reader.b(inputStream)), Object.class);
    }

    private Object a(org.yaml.snakeyaml.reader.a aVar, Class<?> cls) {
        this.fhD.a(new org.yaml.snakeyaml.composer.a(new org.yaml.snakeyaml.parser.b(aVar), this.fhC));
        return this.fhD.ab(cls);
    }

    public String toString() {
        return this.name;
    }
}
