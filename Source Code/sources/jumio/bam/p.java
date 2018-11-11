package jumio.bam;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.text.Editable;
import android.util.TypedValue;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import com.jumio.bam.R;
import com.jumio.commons.utils.ScreenUtil;

/* compiled from: ManualEntryRow */
public abstract class p extends TableRow {
    protected int g;
    protected int h;
    protected int i;
    protected boolean j = true;
    protected boolean k = false;
    protected int l;
    protected int m;
    protected int n;
    protected int o;
    protected o p;

    public abstract boolean a();

    protected abstract void b();

    public abstract Editable getValueText();

    public p(Context context) {
        super(context);
        this.g = ScreenUtil.dpToPx(context, 12);
        this.h = ScreenUtil.dpToPx(context, 14);
        this.i = ScreenUtil.dpToPx(context, 14);
        setPadding(this.h, this.g, this.i, this.g);
        TypedValue typedValue = new TypedValue();
        Theme theme = context.getTheme();
        theme.resolveAttribute(R.attr.bam_manualEntryBackgroundColor, typedValue, true);
        this.l = typedValue.data;
        theme.resolveAttribute(R.attr.bam_manualEntryDefaultTextColor, typedValue, true);
        this.o = typedValue.data;
        theme.resolveAttribute(R.attr.bam_manualEntryFocusedTextColor, typedValue, true);
        this.n = typedValue.data;
        theme.resolveAttribute(R.attr.bam_manualEntryErrorTextColor, typedValue, true);
        this.m = typedValue.data;
    }

    public void a(int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        layoutParams.rightMargin = i3;
        layoutParams.bottomMargin = i4;
        setLayoutParams(layoutParams);
    }

    public void setAutoFocusNextView(boolean z) {
        this.j = z;
    }

    public boolean getAutoFocusNextView() {
        return this.j;
    }

    public void setAutoShowNextView(boolean z) {
        this.k = z;
    }

    public boolean getAutoShowNextView() {
        return this.k;
    }

    public void setValidationCallback(o oVar) {
        this.p = oVar;
    }
}
