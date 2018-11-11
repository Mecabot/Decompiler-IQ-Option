package com.iqoption.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.TextView;
import com.iqoption.b.b;
import com.iqoption.x.R;

/* compiled from: RobotoTextWidgetHelper */
class k {
    private static Typeface n(Context context, int i) {
        switch (i) {
            case 1:
                i = R.font.medium;
                break;
            case 2:
                i = R.font.bold;
                break;
            case 3:
                i = R.font.italic;
                break;
            default:
                i = R.font.regular;
                break;
        }
        return ResourcesCompat.getFont(context, i);
    }

    static void a(TextView textView, AttributeSet attributeSet) {
        Typeface n;
        Context context = textView.getContext();
        if (attributeSet != null) {
            Drawable drawable;
            Drawable drawable2;
            Drawable drawable3;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.RobotoTextView);
            int i = obtainStyledAttributes.getInt(4, -1);
            if (i != -1) {
                n = n(context, i);
            } else {
                n = n(context, obtainStyledAttributes.getInt(5, 0));
            }
            Drawable drawable4 = null;
            if (VERSION.SDK_INT >= 21) {
                Drawable drawable5 = obtainStyledAttributes.getDrawable(1);
                Drawable drawable6 = obtainStyledAttributes.getDrawable(2);
                drawable = obtainStyledAttributes.getDrawable(0);
                drawable4 = obtainStyledAttributes.getDrawable(3);
                drawable2 = drawable5;
                drawable3 = drawable6;
            } else {
                int resourceId = obtainStyledAttributes.getResourceId(1, -1);
                int resourceId2 = obtainStyledAttributes.getResourceId(2, -1);
                int resourceId3 = obtainStyledAttributes.getResourceId(0, -1);
                int resourceId4 = obtainStyledAttributes.getResourceId(3, -1);
                drawable2 = resourceId != -1 ? AppCompatResources.getDrawable(context, resourceId) : null;
                drawable3 = resourceId2 != -1 ? AppCompatResources.getDrawable(context, resourceId2) : null;
                drawable = resourceId3 != -1 ? AppCompatResources.getDrawable(context, resourceId3) : null;
                if (resourceId4 != -1) {
                    drawable4 = AppCompatResources.getDrawable(context, resourceId4);
                }
            }
            if (!(drawable2 == null && drawable == null && drawable3 == null && drawable4 == null)) {
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable4, drawable3, drawable);
            }
            obtainStyledAttributes.recycle();
        } else {
            n = n(context, 0);
        }
        textView.setTypeface(n);
    }
}
