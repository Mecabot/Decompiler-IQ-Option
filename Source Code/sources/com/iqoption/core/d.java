package com.iqoption.core;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.iqoption.core.b.b;
import com.iqoption.core.j.f;

/* compiled from: DataBinderMapperImpl */
public class d extends DataBinderMapper {
    private static final SparseIntArray pc = new SparseIntArray(2);

    /* compiled from: DataBinderMapperImpl */
    private static class a {
        static final SparseArray<String> pd = new SparseArray(1);

        static {
            pd.put(a.pb, "_all");
        }
    }

    static {
        pc.put(f.terms_fragment, 1);
        pc.put(f.layout_toolbar_black, 2);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        i = pc.get(i);
        if (i > 0) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            }
            StringBuilder stringBuilder;
            switch (i) {
                case 1:
                    if ("layout/terms_fragment_0".equals(tag)) {
                        return new com.iqoption.core.b.d(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for terms_fragment is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 2:
                    if ("layout/layout_toolbar_black_0".equals(tag)) {
                        return new b(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for layout_toolbar_black is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return null;
    }

    /* JADX WARNING: Missing block: B:11:0x0022, code:
            return null;
     */
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent r2, android.view.View[] r3, int r4) {
        /*
        r1 = this;
        r2 = 0;
        if (r3 == 0) goto L_0x0022;
    L_0x0003:
        r0 = r3.length;
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        goto L_0x0022;
    L_0x0007:
        r0 = pc;
        r4 = r0.get(r4);
        if (r4 <= 0) goto L_0x0021;
    L_0x000f:
        r4 = 0;
        r3 = r3[r4];
        r3 = r3.getTag();
        if (r3 != 0) goto L_0x0021;
    L_0x0018:
        r2 = new java.lang.RuntimeException;
        r3 = "view must have a tag";
        r2.<init>(r3);
        throw r2;
    L_0x0021:
        return r2;
    L_0x0022:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.d.getDataBinder(android.databinding.DataBindingComponent, android.view.View[], int):android.databinding.ViewDataBinding");
    }

    public int getLayoutId(String str) {
        if (str == null) {
            return 0;
        }
        int hashCode = str.hashCode();
        if (hashCode != -2087644004) {
            if (hashCode == -879789058 && str.equals("layout/terms_fragment_0")) {
                return f.terms_fragment;
            }
        } else if (str.equals("layout/layout_toolbar_black_0")) {
            return f.layout_toolbar_black;
        }
        return 0;
    }

    public String convertBrIdToString(int i) {
        return (String) a.pd.get(i);
    }
}
