package pl.droidsonroids.gif;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

public class GifImageView extends ImageView {
    private boolean fkL;

    public GifImageView(Context context) {
        super(context);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(e.a(this, attributeSet, 0, 0));
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(e.a(this, attributeSet, i, 0));
    }

    @RequiresApi(21)
    public GifImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(e.a(this, attributeSet, i, i2));
    }

    private void a(a aVar) {
        this.fkL = aVar.fkR;
        if (aVar.fkQ > 0) {
            super.setImageResource(aVar.fkQ);
        }
        if (aVar.mBackgroundResId > 0) {
            super.setBackgroundResource(aVar.mBackgroundResId);
        }
    }

    public void setImageURI(Uri uri) {
        if (!e.a((ImageView) this, uri)) {
            super.setImageURI(uri);
        }
    }

    public void setImageResource(int i) {
        if (!e.a(this, true, i)) {
            super.setImageResource(i);
        }
    }

    public void setBackgroundResource(int i) {
        if (!e.a(this, false, i)) {
            super.setBackgroundResource(i);
        }
    }

    public Parcelable onSaveInstanceState() {
        Drawable drawable = null;
        Drawable drawable2 = this.fkL ? getDrawable() : null;
        if (this.fkL) {
            drawable = getBackground();
        }
        return new d(super.onSaveInstanceState(), drawable2, drawable);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            d dVar = (d) parcelable;
            super.onRestoreInstanceState(dVar.getSuperState());
            dVar.d(getDrawable(), 0);
            dVar.d(getBackground(), 1);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setFreezesAnimation(boolean z) {
        this.fkL = z;
    }
}
