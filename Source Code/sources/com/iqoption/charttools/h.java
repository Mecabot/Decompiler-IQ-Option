package com.iqoption.charttools;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.iqoption.charttools.b.ab;
import com.iqoption.charttools.b.b;
import com.iqoption.charttools.b.c;
import com.iqoption.charttools.b.e;
import com.iqoption.charttools.b.f;
import com.iqoption.charttools.b.j;
import com.iqoption.charttools.b.l;
import com.iqoption.charttools.b.n;
import com.iqoption.charttools.b.p;
import com.iqoption.charttools.b.r;
import com.iqoption.charttools.b.t;
import com.iqoption.charttools.b.v;
import com.iqoption.charttools.b.x;
import com.iqoption.charttools.b.z;

/* compiled from: DataBinderMapperImpl */
public class h extends DataBinderMapper {
    private static final SparseIntArray pc = new SparseIntArray(13);

    /* compiled from: DataBinderMapperImpl */
    private static class a {
        static final SparseArray<String> pd = new SparseArray(1);

        static {
            pd.put(g.pb, "_all");
        }
    }

    static {
        pc.put(com.iqoption.charttools.o.h.indicator_constructor_input_select, 1);
        pc.put(com.iqoption.charttools.o.h.fragment_template, 2);
        pc.put(com.iqoption.charttools.o.h.templates_figure_item, 3);
        pc.put(com.iqoption.charttools.o.h.templates_indicator_item, 4);
        pc.put(com.iqoption.charttools.o.h.fragment_indicator_settings, 5);
        pc.put(com.iqoption.charttools.o.h.indicator_constructor_input_field, 6);
        pc.put(com.iqoption.charttools.o.h.indicator_constructor_input_bool, 7);
        pc.put(com.iqoption.charttools.o.h.indicator_constructor_bottom_sheet_input_select, 8);
        pc.put(com.iqoption.charttools.o.h.indicator_constructor_input_line_width, 9);
        pc.put(com.iqoption.charttools.o.h.indicator_constructor_input_step_field, 10);
        pc.put(com.iqoption.charttools.o.h.indicator_constructor_group_description_item, 11);
        pc.put(com.iqoption.charttools.o.h.indicator_constructor_group_title_item, 12);
        pc.put(com.iqoption.charttools.o.h.indicator_constructor_input_color, 13);
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
                    if ("layout/indicator_constructor_input_select_0".equals(tag)) {
                        return new v(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for indicator_constructor_input_select is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 2:
                    if ("layout/fragment_template_0".equals(tag)) {
                        return new e(dataBindingComponent, view);
                    }
                    if ("layout-land/fragment_template_0".equals(tag)) {
                        return new f(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_template is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 3:
                    if ("layout/templates_figure_item_0".equals(tag)) {
                        return new z(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for templates_figure_item is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 4:
                    if ("layout/templates_indicator_item_0".equals(tag)) {
                        return new ab(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for templates_indicator_item is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 5:
                    if ("layout/fragment_indicator_settings_0".equals(tag)) {
                        return new b(dataBindingComponent, view);
                    }
                    if ("layout-land/fragment_indicator_settings_0".equals(tag)) {
                        return new c(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_indicator_settings is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 6:
                    if ("layout/indicator_constructor_input_field_0".equals(tag)) {
                        return new r(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for indicator_constructor_input_field is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 7:
                    if ("layout/indicator_constructor_input_bool_0".equals(tag)) {
                        return new n(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for indicator_constructor_input_bool is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 8:
                    if ("layout/indicator_constructor_bottom_sheet_input_select_0".equals(tag)) {
                        return new com.iqoption.charttools.b.h(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for indicator_constructor_bottom_sheet_input_select is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 9:
                    if ("layout/indicator_constructor_input_line_width_0".equals(tag)) {
                        return new t(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for indicator_constructor_input_line_width is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 10:
                    if ("layout/indicator_constructor_input_step_field_0".equals(tag)) {
                        return new x(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for indicator_constructor_input_step_field is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 11:
                    if ("layout/indicator_constructor_group_description_item_0".equals(tag)) {
                        return new j(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for indicator_constructor_group_description_item is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 12:
                    if ("layout/indicator_constructor_group_title_item_0".equals(tag)) {
                        return new l(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for indicator_constructor_group_title_item is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 13:
                    if ("layout/indicator_constructor_input_color_0".equals(tag)) {
                        return new p(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for indicator_constructor_input_color is invalid. Received: ");
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.charttools.h.getDataBinder(android.databinding.DataBindingComponent, android.view.View[], int):android.databinding.ViewDataBinding");
    }

    public int getLayoutId(String str) {
        if (str == null) {
            return 0;
        }
        switch (str.hashCode()) {
            case -1959033125:
                if (str.equals("layout/indicator_constructor_input_line_width_0")) {
                    return com.iqoption.charttools.o.h.indicator_constructor_input_line_width;
                }
                break;
            case -1869242219:
                if (str.equals("layout/fragment_template_0")) {
                    return com.iqoption.charttools.o.h.fragment_template;
                }
                break;
            case -1487227474:
                if (str.equals("layout/fragment_indicator_settings_0")) {
                    return com.iqoption.charttools.o.h.fragment_indicator_settings;
                }
                break;
            case -1432232423:
                if (str.equals("layout-land/fragment_template_0")) {
                    return com.iqoption.charttools.o.h.fragment_template;
                }
                break;
            case -762204004:
                if (str.equals("layout/indicator_constructor_input_field_0")) {
                    return com.iqoption.charttools.o.h.indicator_constructor_input_field;
                }
                break;
            case -687454326:
                if (str.equals("layout/indicator_constructor_input_bool_0")) {
                    return com.iqoption.charttools.o.h.indicator_constructor_input_bool;
                }
                break;
            case -420815310:
                if (str.equals("layout-land/fragment_indicator_settings_0")) {
                    return com.iqoption.charttools.o.h.fragment_indicator_settings;
                }
                break;
            case -32905892:
                if (str.equals("layout/indicator_constructor_input_select_0")) {
                    return com.iqoption.charttools.o.h.indicator_constructor_input_select;
                }
                break;
            case 426446164:
                if (str.equals("layout/templates_figure_item_0")) {
                    return com.iqoption.charttools.o.h.templates_figure_item;
                }
                break;
            case 529549916:
                if (str.equals("layout/indicator_constructor_bottom_sheet_input_select_0")) {
                    return com.iqoption.charttools.o.h.indicator_constructor_bottom_sheet_input_select;
                }
                break;
            case 753988735:
                if (str.equals("layout/templates_indicator_item_0")) {
                    return com.iqoption.charttools.o.h.templates_indicator_item;
                }
                break;
            case 1048594629:
                if (str.equals("layout/indicator_constructor_input_color_0")) {
                    return com.iqoption.charttools.o.h.indicator_constructor_input_color;
                }
                break;
            case 1533495653:
                if (str.equals("layout/indicator_constructor_group_title_item_0")) {
                    return com.iqoption.charttools.o.h.indicator_constructor_group_title_item;
                }
                break;
            case 1626663873:
                if (str.equals("layout/indicator_constructor_group_description_item_0")) {
                    return com.iqoption.charttools.o.h.indicator_constructor_group_description_item;
                }
                break;
            case 1812397031:
                if (str.equals("layout/indicator_constructor_input_step_field_0")) {
                    return com.iqoption.charttools.o.h.indicator_constructor_input_step_field;
                }
                break;
        }
        return 0;
    }

    public String convertBrIdToString(int i) {
        return (String) a.pd.get(i);
    }
}
