package com.iqoption.deposit;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.iqoption.deposit.a.ab;
import com.iqoption.deposit.a.ad;
import com.iqoption.deposit.a.af;
import com.iqoption.deposit.a.ah;
import com.iqoption.deposit.a.aj;
import com.iqoption.deposit.a.al;
import com.iqoption.deposit.a.an;
import com.iqoption.deposit.a.ap;
import com.iqoption.deposit.a.ar;
import com.iqoption.deposit.a.at;
import com.iqoption.deposit.a.av;
import com.iqoption.deposit.a.ax;
import com.iqoption.deposit.a.az;
import com.iqoption.deposit.a.b;
import com.iqoption.deposit.a.bb;
import com.iqoption.deposit.a.bd;
import com.iqoption.deposit.a.bf;
import com.iqoption.deposit.a.bh;
import com.iqoption.deposit.a.bj;
import com.iqoption.deposit.a.bl;
import com.iqoption.deposit.a.bn;
import com.iqoption.deposit.a.bp;
import com.iqoption.deposit.a.br;
import com.iqoption.deposit.a.bt;
import com.iqoption.deposit.a.bv;
import com.iqoption.deposit.a.bw;
import com.iqoption.deposit.a.by;
import com.iqoption.deposit.a.ca;
import com.iqoption.deposit.a.cb;
import com.iqoption.deposit.a.cd;
import com.iqoption.deposit.a.cf;
import com.iqoption.deposit.a.d;
import com.iqoption.deposit.a.f;
import com.iqoption.deposit.a.h;
import com.iqoption.deposit.a.j;
import com.iqoption.deposit.a.l;
import com.iqoption.deposit.a.n;
import com.iqoption.deposit.a.p;
import com.iqoption.deposit.a.r;
import com.iqoption.deposit.a.t;
import com.iqoption.deposit.a.v;
import com.iqoption.deposit.a.x;
import com.iqoption.deposit.a.z;
import com.iqoption.deposit.r.g;

/* compiled from: DataBinderMapperImpl */
public class e extends DataBinderMapper {
    private static final SparseIntArray pc = new SparseIntArray(41);

    /* compiled from: DataBinderMapperImpl */
    private static class a {
        static final SparseArray<String> pd = new SparseArray(1);

        static {
            pd.put(a.pb, "_all");
        }
    }

    static {
        pc.put(g.item_scan_card, 1);
        pc.put(g.constructor_spinner_field_light, 2);
        pc.put(g.item_preset_light, 3);
        pc.put(g.item_payment_method_title_light, 4);
        pc.put(g.fragment_payment_fields_light, 5);
        pc.put(g.layout_deposit_toolbar, 6);
        pc.put(g.fragment_payment_completed_light, 7);
        pc.put(g.item_preset_with_badge, 8);
        pc.put(g.nfc_scan_fragment, 9);
        pc.put(g.fragment_redirect_web_payment, 10);
        pc.put(g.layout_pay_method_selector, 11);
        pc.put(g.layout_currency_selector, 12);
        pc.put(g.item_preset, 13);
        pc.put(g.item_currency_light, 14);
        pc.put(g.item_constructor_spinner_light, 15);
        pc.put(g.fragment_deposit, 16);
        pc.put(g.constructor_text_edit_field_light, 17);
        pc.put(g.fragment_card_payment_light, 18);
        pc.put(g.fragment_card_payment, 19);
        pc.put(g.layout_navigator_content, 20);
        pc.put(g.layout_deposit_button, 21);
        pc.put(g.layout_currency_selector_light, 22);
        pc.put(g.fragment_deposit_perform_light, 23);
        pc.put(g.layout_preset_amount, 24);
        pc.put(g.fragment_deposit_navigator, 25);
        pc.put(g.layout_deposit_content, 26);
        pc.put(g.item_payment_method, 27);
        pc.put(g.constructor_text_edit_field, 28);
        pc.put(g.item_scan_card_light, 29);
        pc.put(g.layout_deposit_protected_light, 30);
        pc.put(g.fragment_redirect_web_payment_light, 31);
        pc.put(g.layout_perform_toolbar_title_light, 32);
        pc.put(g.layout_deposit_button_light, 33);
        pc.put(g.constructor_spinner_field, 34);
        pc.put(g.fragment_payment_fields, 35);
        pc.put(g.item_constructor_spinner, 36);
        pc.put(g.item_currency, 37);
        pc.put(g.item_payment_method_light, 38);
        pc.put(g.fragment_deposit_methods_light, 39);
        pc.put(g.fragment_payment_completed, 40);
        pc.put(g.layout_deposit_protected, 41);
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
                    if ("layout/item_scan_card_0".equals(tag)) {
                        return new bb(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for item_scan_card is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 2:
                    if ("layout/constructor_spinner_field_light_0".equals(tag)) {
                        return new d(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for constructor_spinner_field_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 3:
                    if ("layout/item_preset_light_0".equals(tag)) {
                        return new ax(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for item_preset_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 4:
                    if ("layout/item_payment_method_title_light_0".equals(tag)) {
                        return new at(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for item_payment_method_title_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 5:
                    if ("layout/fragment_payment_fields_light_0".equals(tag)) {
                        return new ab(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_payment_fields_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 6:
                    if ("layout/layout_deposit_toolbar_0".equals(tag)) {
                        return new bt(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for layout_deposit_toolbar is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 7:
                    if ("layout/fragment_payment_completed_light_0".equals(tag)) {
                        return new x(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_payment_completed_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 8:
                    if ("layout/item_preset_with_badge_0".equals(tag)) {
                        return new az(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for item_preset_with_badge is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 9:
                    if ("layout/nfc_scan_fragment_0".equals(tag)) {
                        return new cf(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for nfc_scan_fragment is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 10:
                    if ("layout/fragment_redirect_web_payment_0".equals(tag)) {
                        return new ad(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_redirect_web_payment is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 11:
                    if ("layout/layout_pay_method_selector_0".equals(tag)) {
                        return new by(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for layout_pay_method_selector is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 12:
                    if ("layout/layout_currency_selector_0".equals(tag)) {
                        return new bf(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for layout_currency_selector is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 13:
                    if ("layout/item_preset_0".equals(tag)) {
                        return new av(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for item_preset is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 14:
                    if ("layout/item_currency_light_0".equals(tag)) {
                        return new an(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for item_currency_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 15:
                    if ("layout/item_constructor_spinner_light_0".equals(tag)) {
                        return new aj(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for item_constructor_spinner_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 16:
                    if ("layout/fragment_deposit_0".equals(tag)) {
                        return new n(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_deposit is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 17:
                    if ("layout/constructor_text_edit_field_light_0".equals(tag)) {
                        return new h(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for constructor_text_edit_field_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 18:
                    if ("layout/fragment_card_payment_light_0".equals(tag)) {
                        return new l(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_card_payment_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 19:
                    if ("layout/fragment_card_payment_0".equals(tag)) {
                        return new j(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_card_payment is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 20:
                    if ("layout/layout_navigator_content_0".equals(tag)) {
                        return new bv(dataBindingComponent, view);
                    }
                    if ("layout-land/layout_navigator_content_0".equals(tag)) {
                        return new bw(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for layout_navigator_content is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 21:
                    if ("layout/layout_deposit_button_0".equals(tag)) {
                        return new bj(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for layout_deposit_button is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 22:
                    if ("layout/layout_currency_selector_light_0".equals(tag)) {
                        return new bh(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for layout_currency_selector_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 23:
                    if ("layout/fragment_deposit_perform_light_0".equals(tag)) {
                        return new t(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_deposit_perform_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 24:
                    if ("layout/layout_preset_amount_0".equals(tag)) {
                        return new cd(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for layout_preset_amount is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 25:
                    if ("layout/fragment_deposit_navigator_0".equals(tag)) {
                        return new r(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_deposit_navigator is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 26:
                    if ("layout/layout_deposit_content_0".equals(tag)) {
                        return new bn(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for layout_deposit_content is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 27:
                    if ("layout/item_payment_method_0".equals(tag)) {
                        return new ap(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for item_payment_method is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 28:
                    if ("layout/constructor_text_edit_field_0".equals(tag)) {
                        return new f(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for constructor_text_edit_field is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 29:
                    if ("layout/item_scan_card_light_0".equals(tag)) {
                        return new bd(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for item_scan_card_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 30:
                    if ("layout/layout_deposit_protected_light_0".equals(tag)) {
                        return new br(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for layout_deposit_protected_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 31:
                    if ("layout/fragment_redirect_web_payment_light_0".equals(tag)) {
                        return new af(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_redirect_web_payment_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 32:
                    if ("layout/layout_perform_toolbar_title_light_0".equals(tag)) {
                        return new ca(dataBindingComponent, view);
                    }
                    if ("layout-land/layout_perform_toolbar_title_light_0".equals(tag)) {
                        return new cb(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for layout_perform_toolbar_title_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 33:
                    if ("layout/layout_deposit_button_light_0".equals(tag)) {
                        return new bl(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for layout_deposit_button_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 34:
                    if ("layout/constructor_spinner_field_0".equals(tag)) {
                        return new b(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for constructor_spinner_field is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 35:
                    if ("layout/fragment_payment_fields_0".equals(tag)) {
                        return new z(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_payment_fields is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 36:
                    if ("layout/item_constructor_spinner_0".equals(tag)) {
                        return new ah(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for item_constructor_spinner is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 37:
                    if ("layout/item_currency_0".equals(tag)) {
                        return new al(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for item_currency is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 38:
                    if ("layout/item_payment_method_light_0".equals(tag)) {
                        return new ar(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for item_payment_method_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 39:
                    if ("layout/fragment_deposit_methods_light_0".equals(tag)) {
                        return new p(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_deposit_methods_light is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 40:
                    if ("layout/fragment_payment_completed_0".equals(tag)) {
                        return new v(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for fragment_payment_completed is invalid. Received: ");
                    stringBuilder.append(tag);
                    throw new IllegalArgumentException(stringBuilder.toString());
                case 41:
                    if ("layout/layout_deposit_protected_0".equals(tag)) {
                        return new bp(dataBindingComponent, view);
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The tag for layout_deposit_protected is invalid. Received: ");
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.e.getDataBinder(android.databinding.DataBindingComponent, android.view.View[], int):android.databinding.ViewDataBinding");
    }

    public int getLayoutId(String str) {
        if (str == null) {
            return 0;
        }
        switch (str.hashCode()) {
            case -2030332246:
                if (str.equals("layout/fragment_redirect_web_payment_light_0")) {
                    return g.fragment_redirect_web_payment_light;
                }
                break;
            case -1897053966:
                if (str.equals("layout/item_payment_method_0")) {
                    return g.item_payment_method;
                }
                break;
            case -1880318135:
                if (str.equals("layout/item_currency_0")) {
                    return g.item_currency;
                }
                break;
            case -1829122300:
                if (str.equals("layout/fragment_payment_fields_light_0")) {
                    return g.fragment_payment_fields_light;
                }
                break;
            case -1738314960:
                if (str.equals("layout/fragment_payment_completed_light_0")) {
                    return g.fragment_payment_completed_light;
                }
                break;
            case -1734313335:
                if (str.equals("layout/item_payment_method_light_0")) {
                    return g.item_payment_method_light;
                }
                break;
            case -1706533801:
                if (str.equals("layout/item_preset_0")) {
                    return g.item_preset;
                }
                break;
            case -1697597906:
                if (str.equals("layout/item_preset_light_0")) {
                    return g.item_preset_light;
                }
                break;
            case -1607363131:
                if (str.equals("layout/layout_deposit_protected_light_0")) {
                    return g.layout_deposit_protected_light;
                }
                break;
            case -1586776871:
                if (str.equals("layout/layout_preset_amount_0")) {
                    return g.layout_preset_amount;
                }
                break;
            case -1575328885:
                if (str.equals("layout/layout_deposit_button_light_0")) {
                    return g.layout_deposit_button_light;
                }
                break;
            case -1394302418:
                if (str.equals("layout/layout_currency_selector_0")) {
                    return g.layout_currency_selector;
                }
                break;
            case -1231695468:
                if (str.equals("layout/item_preset_with_badge_0")) {
                    return g.item_preset_with_badge;
                }
                break;
            case -1010762043:
                if (str.equals("layout/layout_currency_selector_light_0")) {
                    return g.layout_currency_selector_light;
                }
                break;
            case -965838884:
                if (str.equals("layout/item_scan_card_0")) {
                    return g.item_scan_card;
                }
                break;
            case -904770131:
                if (str.equals("layout/fragment_payment_fields_0")) {
                    return g.fragment_payment_fields;
                }
                break;
            case -618098678:
                if (str.equals("layout/nfc_scan_fragment_0")) {
                    return g.nfc_scan_fragment;
                }
                break;
            case -558505605:
                if (str.equals("layout/layout_deposit_toolbar_0")) {
                    return g.layout_deposit_toolbar;
                }
                break;
            case -551861511:
                if (str.equals("layout/layout_deposit_content_0")) {
                    return g.layout_deposit_content;
                }
                break;
            case -446480395:
                if (str.equals("layout/item_constructor_spinner_light_0")) {
                    return g.item_constructor_spinner_light;
                }
                break;
            case -336956894:
                if (str.equals("layout/item_payment_method_title_light_0")) {
                    return g.item_payment_method_title_light;
                }
                break;
            case 21426543:
                if (str.equals("layout/fragment_deposit_methods_light_0")) {
                    return g.fragment_deposit_methods_light;
                }
                break;
            case 81358366:
                if (str.equals("layout/fragment_deposit_perform_light_0")) {
                    return g.fragment_deposit_perform_light;
                }
                break;
            case 272798580:
                if (str.equals("layout/layout_deposit_button_0")) {
                    return g.layout_deposit_button;
                }
                break;
            case 315019867:
                if (str.equals("layout/constructor_spinner_field_0")) {
                    return g.constructor_spinner_field;
                }
                break;
            case 356481753:
                if (str.equals("layout/fragment_payment_completed_0")) {
                    return g.fragment_payment_completed;
                }
                break;
            case 576682912:
                if (str.equals("layout/item_currency_light_0")) {
                    return g.item_currency_light;
                }
                break;
            case 800561458:
                if (str.equals("layout/constructor_spinner_field_light_0")) {
                    return g.constructor_spinner_field_light;
                }
                break;
            case 911493587:
                if (str.equals("layout/fragment_redirect_web_payment_0")) {
                    return g.fragment_redirect_web_payment;
                }
                break;
            case 946629998:
                if (str.equals("layout-land/layout_navigator_content_0")) {
                    return g.layout_navigator_content;
                }
                break;
            case 1076635506:
                if (str.equals("layout/layout_navigator_content_0")) {
                    return g.layout_navigator_content;
                }
                break;
            case 1088128862:
                if (str.equals("layout/item_constructor_spinner_0")) {
                    return g.item_constructor_spinner;
                }
                break;
            case 1204044679:
                if (str.equals("layout/layout_pay_method_selector_0")) {
                    return g.layout_pay_method_selector;
                }
                break;
            case 1260262570:
                if (str.equals("layout-land/layout_perform_toolbar_title_light_0")) {
                    return g.layout_perform_toolbar_title_light;
                }
                break;
            case 1260493949:
                if (str.equals("layout/fragment_deposit_navigator_0")) {
                    return g.fragment_deposit_navigator;
                }
                break;
            case 1412979017:
                if (str.equals("layout/fragment_card_payment_light_0")) {
                    return g.fragment_card_payment_light;
                }
                break;
            case 1414333854:
                if (str.equals("layout/constructor_text_edit_field_0")) {
                    return g.constructor_text_edit_field;
                }
                break;
            case 1448303091:
                if (str.equals("layout/item_scan_card_light_0")) {
                    return g.item_scan_card_light;
                }
                break;
            case 1451438002:
                if (str.equals("layout/fragment_card_payment_0")) {
                    return g.fragment_card_payment;
                }
                break;
            case 1791823413:
                if (str.equals("layout/constructor_text_edit_field_light_0")) {
                    return g.constructor_text_edit_field_light;
                }
                break;
            case 1838160302:
                if (str.equals("layout/layout_perform_toolbar_title_light_0")) {
                    return g.layout_perform_toolbar_title_light;
                }
                break;
            case 1934784814:
                if (str.equals("layout/layout_deposit_protected_0")) {
                    return g.layout_deposit_protected;
                }
                break;
            case 2127523493:
                if (str.equals("layout/fragment_deposit_0")) {
                    return g.fragment_deposit;
                }
                break;
        }
        return 0;
    }

    public String convertBrIdToString(int i) {
        return (String) a.pd.get(i);
    }
}
