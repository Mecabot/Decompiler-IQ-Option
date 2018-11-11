package com.android.a.a.a;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;

/* compiled from: DataBinderMapperImpl */
public class b extends DataBinderMapper {
    private static final SparseIntArray pc = new SparseIntArray(0);

    /* compiled from: DataBinderMapperImpl */
    private static class a {
        static final SparseArray<String> pd = new SparseArray(1);

        static {
            pd.put(a.pb, "_all");
        }
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        if (pc.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    /* JADX WARNING: Missing block: B:11:0x0021, code:
            return null;
     */
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent r2, android.view.View[] r3, int r4) {
        /*
        r1 = this;
        r2 = 0;
        if (r3 == 0) goto L_0x0021;
    L_0x0003:
        r0 = r3.length;
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        goto L_0x0021;
    L_0x0007:
        r0 = pc;
        r4 = r0.get(r4);
        if (r4 <= 0) goto L_0x0020;
    L_0x000f:
        r4 = 0;
        r3 = r3[r4];
        r3 = r3.getTag();
        if (r3 != 0) goto L_0x0020;
    L_0x0018:
        r2 = new java.lang.RuntimeException;
        r3 = "view must have a tag";
        r2.<init>(r3);
        throw r2;
    L_0x0020:
        return r2;
    L_0x0021:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.a.a.a.b.getDataBinder(android.databinding.DataBindingComponent, android.view.View[], int):android.databinding.ViewDataBinding");
    }

    public int getLayoutId(String str) {
        if (str == null) {
            return 0;
        }
        str.hashCode();
        return 0;
    }

    public String convertBrIdToString(int i) {
        return (String) a.pd.get(i);
    }
}
