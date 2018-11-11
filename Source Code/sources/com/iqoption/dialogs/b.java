package com.iqoption.dialogs;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.iqoption.dialogs.a.f;
import com.iqoption.dialogs.a.h;
import com.iqoption.dialogs.a.j;
import com.iqoption.dialogs.c.d;

/* compiled from: DataBinderMapperImpl */
public class b extends DataBinderMapper {
    private static final SparseIntArray pc = new SparseIntArray(5);

    /* compiled from: DataBinderMapperImpl */
    private static class a {
        static final SparseArray<String> pd = new SparseArray(1);

        static {
            pd.put(a.pb, "_all");
        }
    }

    static {
        pc.put(d.fragment_menu_list, 1);
        pc.put(d.fragment_menu_list_light, 2);
        pc.put(d.dialog_rate_us, 3);
        pc.put(d.fragment_bottom_sheet, 4);
        pc.put(d.dialog_simple, 5);
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
                    if ("layout/fragment_menu_list_0".equals(tag)) {
                        return new h(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_menu_list is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 2:
                    if ("layout/fragment_menu_list_light_0".equals(tag)) {
                        return new j(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_menu_list_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 3:
                    if ("layout/dialog_rate_us_0".equals(tag)) {
                        return new com.iqoption.dialogs.a.b(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for dialog_rate_us is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 4:
                    if ("layout/fragment_bottom_sheet_0".equals(tag)) {
                        return new f(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_bottom_sheet is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 5:
                    if ("layout/dialog_simple_0".equals(tag)) {
                        return new com.iqoption.dialogs.a.d(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for dialog_simple is invalid. Received: ");
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dialogs.b.getDataBinder(android.databinding.DataBindingComponent, android.view.View[], int):android.databinding.ViewDataBinding");
    }

    public int getLayoutId(String str) {
        if (str == null) {
            return 0;
        }
        switch (str.hashCode()) {
            case -1481137956:
                if (str.equals("layout/dialog_rate_us_0")) {
                    return d.dialog_rate_us;
                }
                break;
            case -1027950244:
                if (str.equals("layout/fragment_menu_list_light_0")) {
                    return d.fragment_menu_list_light;
                }
                break;
            case 1335094566:
                if (str.equals("layout/fragment_bottom_sheet_0")) {
                    return d.fragment_bottom_sheet;
                }
                break;
            case 1400725781:
                if (str.equals("layout/dialog_simple_0")) {
                    return d.dialog_simple;
                }
                break;
            case 1846008325:
                if (str.equals("layout/fragment_menu_list_0")) {
                    return d.fragment_menu_list;
                }
                break;
        }
        return 0;
    }

    public String convertBrIdToString(int i) {
        return (String) a.pd.get(i);
    }
}
