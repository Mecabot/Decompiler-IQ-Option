package com.iqoption.view.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.text.AllCapsTransformationMethod;
import android.support.v7.widget.AppCompatTextView;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class FormattedTextView extends AppCompatTextView {
    private TransformationMethod dJn;
    private com.iqoption.view.c.a dJo;
    private a dJp;

    private enum Capitalize {
        none,
        firstLetter,
        allCaps,
        allLowerCase,
        phoneNumber,
        hiddenPhoneNumber,
        creditCard,
        camelSpace
    }

    public interface a {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    private static class b implements TransformationMethod {
        private List<TransformationMethod> transformations;

        public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
        }

        private b() {
            this.transformations = new ArrayList();
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            for (TransformationMethod transformation : this.transformations) {
                charSequence = transformation.getTransformation(charSequence, view);
            }
            return charSequence;
        }

        public b b(TransformationMethod transformationMethod) {
            this.transformations.add(transformationMethod);
            return this;
        }

        public TransformationMethod C(Class<?> cls) {
            for (TransformationMethod transformationMethod : this.transformations) {
                if (cls.isInstance(transformationMethod)) {
                    return transformationMethod;
                }
            }
            return null;
        }
    }

    public FormattedTextView(Context context) {
        super(context);
    }

    public FormattedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public FormattedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }

    public void setOnSizeChangedListener(a aVar) {
        this.dJp = aVar;
    }

    public void setFrameTopGapSize(float f) {
        if (this.dJo == null) {
            throw new RuntimeException("frame should be enabled, use FormattedTextView_isDrawFrame attribute");
        }
        this.dJo.setFrameTopGapSize(f);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.iqoption.b.b.FormattedTextView, 0, 0);
        try {
            this.dJn = getTransformationMethod();
            setCapitalize(Capitalize.values()[obtainStyledAttributes.getInt(0, 0)]);
            setTextLines(obtainStyledAttributes.getInt(6, 0));
            if (this.dJn != null) {
                setTransformationMethod(this.dJn);
            }
            c(obtainStyledAttributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void c(TypedArray typedArray) {
        if (typedArray.getBoolean(5, false)) {
            this.dJo = new com.iqoption.view.c.a(typedArray.getDimension(2, 0.0f), typedArray.getColor(1, -1), typedArray.getDimension(3, 1.0f), typedArray.getDimension(4, 0.0f));
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.dJo != null) {
            this.dJo.onDraw(canvas);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.dJp != null) {
            this.dJp.onSizeChanged(i, i2, i3, i4);
        }
    }

    private void setCapitalize(Capitalize capitalize) {
        switch (capitalize) {
            case firstLetter:
                a(new j(getContext()));
                return;
            case allCaps:
                a(new AllCapsTransformationMethod(getContext()));
                return;
            case allLowerCase:
                a(new b(getContext()));
                return;
            case phoneNumber:
                if (!isInEditMode()) {
                    a(new u(getContext()));
                    return;
                }
                return;
            case hiddenPhoneNumber:
                if (!isInEditMode()) {
                    a(new k(getContext()));
                    return;
                }
                return;
            case creditCard:
                if (!isInEditMode()) {
                    a(new g());
                    return;
                }
                return;
            case camelSpace:
                a(new d(getContext()));
                return;
            default:
                return;
        }
    }

    public void setTextLines(int i) {
        if (i > 0) {
            v vVar = (v) C(v.class);
            if (vVar == null) {
                a(new v(i));
            } else {
                vVar.setLines(i);
            }
        }
    }

    private TransformationMethod C(Class<?> cls) {
        if (this.dJn == null) {
            return null;
        }
        if (this.dJn instanceof b) {
            ((b) this.dJn).C(cls);
        } else if (cls.isInstance(this.dJn)) {
            return this.dJn;
        }
        return null;
    }

    private void a(TransformationMethod transformationMethod) {
        if (this.dJn == null) {
            this.dJn = transformationMethod;
        } else if (this.dJn instanceof b) {
            ((b) this.dJn).b(transformationMethod);
        } else {
            TransformationMethod bVar = new b();
            bVar.b(this.dJn);
            bVar.b(transformationMethod);
            this.dJn = bVar;
        }
    }
}
