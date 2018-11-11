package jumio.nv.ocr;

import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;

/* compiled from: TemplateMatcherExtractionUpdate */
public class c extends ExtractionUpdate<a> {
    private float a;

    public c(int i, a aVar, float f) {
        super(i, aVar);
        this.a = f;
    }

    public c(int i) {
        super(i, null);
    }

    public float a() {
        return this.a;
    }
}
