package android.support.design.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.TextView;

public class IQTextInputLayout extends TextInputLayout {
    public IQTextInputLayout(Context context) {
        super(context);
    }

    public IQTextInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IQTextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @NonNull
    public TextView getErrorView() {
        return this.mErrorView;
    }
}
