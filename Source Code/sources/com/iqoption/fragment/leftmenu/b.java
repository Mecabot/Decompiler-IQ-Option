package com.iqoption.fragment.leftmenu;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.google.common.base.f;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.i;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.core.microservices.avatar.d;
import com.iqoption.d.xi;
import com.iqoption.d.xo;
import com.iqoption.d.xq;
import com.iqoption.d.xs;
import com.iqoption.d.xw;
import com.iqoption.d.xy;
import com.iqoption.d.ya;
import com.iqoption.d.ye;
import com.iqoption.d.yg;
import com.iqoption.dto.Event;
import com.iqoption.fragment.leftmenu.content.HistoryMenu;
import com.iqoption.fragment.leftmenu.content.MainMenu;
import com.iqoption.fragment.leftmenu.content.SettingsMenu;
import com.iqoption.fragment.leftmenu.content.VipMangerMenu;
import com.iqoption.fragment.leftmenu.content.e;
import com.iqoption.util.bg;
import com.iqoption.view.RobotoTextView;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: LeftMenuAdapter */
public class b extends Adapter<c> {
    private static final String TAG = "com.iqoption.fragment.leftmenu.b";
    private static final ImmutableMap<com.iqoption.fragment.leftmenu.content.a, String> cCh = new com.google.common.collect.ImmutableMap.a().r(MainMenu.Debug, "Debug").r(MainMenu.Deposit, "Deposit").r(MainMenu.History, "History").r(HistoryMenu.Operations, "OperationHistory").r(HistoryMenu.Trading, "TradingHistory").r(MainMenu.VipManager, "VipManager").r(VipMangerMenu.about, "About").r(VipMangerMenu.request_call, "RequestCall").r(VipMangerMenu.education, "Education").r(MainMenu.Settings, "Settings").r(SettingsMenu.General, "General").r(SettingsMenu.Security, "Security").r(SettingsMenu.PushNotifications, "PushNotifications").r(SettingsMenu.NewsAndUpdates, "NewsAndUpdates").r(SettingsMenu.TechnicalLog, "TechnicalLog").r(MainMenu.LogOut, "LogOut").r(MainMenu.Support, "Support").r(MainMenu.RateUs, "RateApp").r(MainMenu.Quiz, "Quiz").r(MainMenu.TermsAndConditions, "TermsAndConditions").tc();
    private final com.iqoption.core.ui.picasso.a aDH = new com.iqoption.core.ui.picasso.a();
    private final Set<com.iqoption.fragment.leftmenu.content.a> cCi = Sets.uI();
    private final Set<com.iqoption.fragment.leftmenu.content.a> cCj = Sets.uI();
    private a cCk;
    private ImmutableList<com.iqoption.fragment.leftmenu.content.a> cCl = i.d(MainMenu.values()).c(com.iqoption.fragment.leftmenu.content.a.cDc).c(com.iqoption.fragment.leftmenu.content.a.cDd).sA();
    private final b cCm;
    private final com.iqoption.fragment.leftmenu.i.a cCn;

    /* compiled from: LeftMenuAdapter */
    private static class a {
        private final Map<com.iqoption.fragment.leftmenu.content.a, Drawable> cCr;
        private final Map<com.iqoption.fragment.leftmenu.content.a, Drawable> cCs;
        private final Context context;

        /* synthetic */ a(Context context, AnonymousClass1 anonymousClass1) {
            this(context);
        }

        private a(@NonNull Context context) {
            this.cCr = Maps.us();
            this.cCs = Maps.us();
            this.context = context;
        }

        private Drawable a(@NonNull com.iqoption.fragment.leftmenu.content.a aVar, boolean z) {
            Drawable drawable;
            if (z) {
                drawable = (Drawable) this.cCr.get(aVar);
                if (drawable != null) {
                    return drawable;
                }
                drawable = AppCompatResources.getDrawable(this.context, aVar.getExpandIcon());
                this.cCr.put(aVar, drawable);
                return drawable;
            }
            drawable = (Drawable) this.cCs.get(aVar);
            if (drawable != null) {
                return drawable;
            }
            drawable = AppCompatResources.getDrawable(this.context, aVar.getCollapseIcon());
            this.cCs.put(aVar, drawable);
            return drawable;
        }

        public void a(@NonNull ImageView imageView, @NonNull com.iqoption.fragment.leftmenu.content.a aVar, boolean z) {
            Drawable a = a(aVar, z);
            Object obj = a != imageView.getDrawable() ? 1 : null;
            imageView.setImageDrawable(a);
            if (a != null && (a instanceof Animatable) && obj != null) {
                Animatable animatable = (Animatable) a;
                if (animatable.isRunning()) {
                    animatable.stop();
                }
                animatable.start();
            }
        }

        public void b(@NonNull ImageView imageView, @NonNull com.iqoption.fragment.leftmenu.content.a aVar, boolean z) {
            imageView.setImageDrawable(a(aVar, z));
        }
    }

    /* compiled from: LeftMenuAdapter */
    public interface b {
        void b(com.iqoption.fragment.leftmenu.content.a aVar);
    }

    /* compiled from: LeftMenuAdapter */
    public static class c extends ViewHolder {
        private final ViewDataBinding ahp;
        com.iqoption.fragment.leftmenu.content.a cCt;
        final int cqA;

        public c(ViewDataBinding viewDataBinding, int i) {
            super(viewDataBinding.getRoot());
            this.ahp = viewDataBinding;
            this.cqA = i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append(" '");
            stringBuilder.append(this.ahp);
            return stringBuilder.toString();
        }
    }

    public b(b bVar, com.iqoption.fragment.leftmenu.i.a aVar) {
        this.cCm = bVar;
        this.cCn = aVar;
        setHasStableIds(true);
    }

    public void aF(List<com.iqoption.fragment.leftmenu.content.a> list) {
        this.cCl = i.d(MainMenu.values()).c(com.iqoption.fragment.leftmenu.content.a.cDc).c(com.iqoption.fragment.leftmenu.content.a.cDd).e((Iterable) list).a(c.$instance);
        notifyDataSetChanged();
    }

    public long getItemId(int i) {
        com.iqoption.fragment.leftmenu.content.a eV = eV(i);
        return (long) (eV.layoutResId() << (eV.hashCode() + 32));
    }

    public int getItemViewType(int i) {
        return eV(i).layoutResId();
    }

    /* renamed from: K */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), i, viewGroup, false);
        if (i == R.layout.left_menu_item_pro_trader) {
            return new i((xy) inflate, this.cCn);
        }
        return new c(inflate, i);
    }

    /* renamed from: a */
    public void onBindViewHolder(final c cVar, int i) {
        final com.iqoption.fragment.leftmenu.content.a eV = eV(i);
        cVar.cCt = eV;
        a(cVar, eV);
        if (eV.isClickable()) {
            cVar.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (cVar.cCt.getChildCount() > 0) {
                        b.this.a(cVar);
                    } else if (!TextUtils.isEmpty(eV.analyticsEventName())) {
                        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, eV.analyticsEventName()).build());
                    }
                    if (b.this.cCm != null) {
                        b.this.cCm.b(cVar.cCt);
                    }
                }
            });
        } else {
            cVar.itemView.setOnClickListener(null);
        }
        cVar.itemView.setTag(cCh.get(eV));
    }

    private void a(c cVar, com.iqoption.fragment.leftmenu.content.a aVar) {
        cVar.itemView.setEnabled(aVar.isEnabled());
        int i = 1;
        switch (cVar.cqA) {
            case R.layout.left_menu_item:
                xi xiVar = (xi) cVar.ahp;
                xiVar.bKs.setCompoundDrawablesWithIntrinsicBounds(aVar.getIcon(), 0, 0, 0);
                xiVar.bKs.setText(aVar.getNameToDisplay());
                return;
            case R.layout.left_menu_item_child:
                ((xo) cVar.ahp).bKs.setText(aVar.getNameToDisplay());
                return;
            case R.layout.left_menu_item_counter:
                xq xqVar = (xq) cVar.ahp;
                xqVar.bKs.setCompoundDrawablesWithIntrinsicBounds(aVar.getIcon(), 0, 0, 0);
                xqVar.bKs.setText(aVar.getNameToDisplay());
                int intValue = ((Integer) com.iqoption.app.a.aL(IQApp.Dk()).akv.getValue()).intValue();
                if (intValue > 0) {
                    xqVar.bKv.setVisibility(0);
                    xqVar.bKv.setText(String.valueOf(intValue));
                    return;
                }
                xqVar.bKv.setVisibility(8);
                return;
            case R.layout.left_menu_item_drop_down:
                xs xsVar = (xs) cVar.ahp;
                xsVar.bKs.setText(aVar.getNameToDisplay());
                boolean contains = this.cCi.contains(aVar);
                if (contains == this.cCj.contains(aVar)) {
                    i = 0;
                }
                if (this.cCk == null) {
                    this.cCk = new a(xsVar.getRoot().getContext(), null);
                }
                float f = 0.0f;
                if (i != 0) {
                    this.cCk.a(xsVar.bKx, aVar, contains);
                    ViewPropertyAnimator animate = xsVar.bKw.animate();
                    if (contains) {
                        f = 180.0f;
                    }
                    animate.rotation(f);
                    return;
                }
                this.cCk.b(xsVar.bKx, aVar, contains);
                ImageView imageView = xsVar.bKw;
                if (contains) {
                    f = 180.0f;
                }
                imageView.setRotation(f);
                return;
            case R.layout.left_menu_item_notification:
                xw xwVar = (xw) cVar.ahp;
                xwVar.bKx.setImageResource(aVar.getIcon());
                xwVar.bKs.setText(aVar.getNameToDisplay());
                return;
            case R.layout.left_menu_item_pro_trader:
                ((i) cVar).c(((e) aVar).alY());
                return;
            case R.layout.left_menu_item_profile:
                ya yaVar = (ya) cVar.ahp;
                Context context = cVar.itemView.getContext();
                com.iqoption.app.a aL = com.iqoption.app.a.aL(context);
                com.iqoption.core.microservices.avatar.a avatar = aL.getAvatar();
                d ai = avatar != null ? avatar.ai(yaVar.bAh.getMeasuredWidth(), yaVar.bAh.getMeasuredHeight()) : null;
                if (ai != null) {
                    RequestCreator load = Picasso.with(context).load(ai.getUrl());
                    Drawable drawable = AppCompatResources.getDrawable(context, R.drawable.ic_avatar_placeholder);
                    if (drawable != null) {
                        load.placeholder(drawable);
                    }
                    load.transform(this.aDH).fit().into(yaVar.bAh);
                } else {
                    yaVar.bAh.setImageResource(R.drawable.ic_avatar_placeholder);
                }
                CharSequence firstName = aL.getFirstName();
                CharSequence lastName = aL.getLastName();
                if (!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName)) {
                    RobotoTextView robotoTextView = yaVar.bKE;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(firstName);
                    stringBuilder.append(" ");
                    stringBuilder.append(lastName.substring(0, 1));
                    stringBuilder.append(".");
                    robotoTextView.setText(stringBuilder.toString());
                } else if (TextUtils.isEmpty(firstName)) {
                    yaVar.bKE.setText(lastName);
                } else if (TextUtils.isEmpty(lastName)) {
                    yaVar.bKE.setText(firstName);
                } else {
                    yaVar.bKE.setText(null);
                }
                if (aL.CZ()) {
                    yaVar.bKF.setText(null);
                    bg.p(yaVar.bKF);
                    yaVar.bKF.setTag(null);
                    return;
                } else if (aL.CU()) {
                    yaVar.bKF.setText(R.string.professional);
                    if (!f.equal(Integer.valueOf(R.drawable.ic_pro_badge), yaVar.bKF.getTag(R.id.iconTag))) {
                        bg.g(yaVar.bKF, R.drawable.ic_pro_badge);
                        yaVar.bKF.setTag(R.id.iconTag, Integer.valueOf(R.drawable.ic_pro_badge));
                        return;
                    }
                    return;
                } else if (aL.Dd()) {
                    yaVar.bKF.setText(R.string.profile1);
                    if (!f.equal(Integer.valueOf(R.drawable.ic_vip), yaVar.bKF.getTag(R.id.iconTag))) {
                        bg.g(yaVar.bKF, R.drawable.ic_vip);
                        yaVar.bKF.setTag(R.id.iconTag, Integer.valueOf(R.drawable.ic_vip));
                        return;
                    }
                    return;
                } else if (aL.isVerified()) {
                    yaVar.bKF.setText(R.string.verified);
                    if (!f.equal(Integer.valueOf(R.drawable.ic_verify), yaVar.bKF.getTag(R.id.iconTag))) {
                        bg.g(yaVar.bKF, R.drawable.ic_verify);
                        yaVar.bKF.setTag(R.id.iconTag, Integer.valueOf(R.drawable.ic_verify));
                        return;
                    }
                    return;
                } else {
                    yaVar.bKF.setText(R.string.non_verified);
                    if (!aL.Dh()) {
                        bg.p(yaVar.bKF);
                        yaVar.bKF.setTag(null);
                        return;
                    } else if (!f.equal(Integer.valueOf(R.drawable.ic_wtf_15dp), yaVar.bKF.getTag(R.id.iconTag))) {
                        bg.g(yaVar.bKF, R.drawable.ic_wtf_15dp);
                        yaVar.bKF.setTag(R.id.iconTag, Integer.valueOf(R.drawable.ic_wtf_15dp));
                        return;
                    } else {
                        return;
                    }
                }
            case R.layout.left_menu_item_terms_and_conditions:
                ((ye) cVar.ahp).bKs.setText(aVar.getNameToDisplay());
                return;
            case R.layout.left_menu_item_with_progress:
                yg ygVar = (yg) cVar.ahp;
                ygVar.bKs.setCompoundDrawablesWithIntrinsicBounds(aVar.getIcon(), 0, 0, 0);
                ygVar.bKs.setText(aVar.getNameToDisplay());
                if (aVar.isInProgress()) {
                    ygVar.bKG.setVisibility(0);
                    return;
                } else {
                    ygVar.bKG.setVisibility(8);
                    return;
                }
            default:
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Unknown menu item type. Item: ");
                stringBuilder2.append(aVar.name());
                String stringBuilder3 = stringBuilder2.toString();
                com.iqoption.core.i.e(TAG, stringBuilder3);
                throw new RuntimeException(stringBuilder3);
        }
    }

    private void a(c cVar) {
        com.iqoption.fragment.leftmenu.content.a aVar = cVar.cCt;
        String str;
        StringBuilder stringBuilder;
        if (this.cCi.contains(aVar)) {
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("menu, collapse group:");
            stringBuilder.append(aVar);
            com.iqoption.core.i.d(str, stringBuilder.toString());
            this.cCj.add(aVar);
            this.cCi.remove(aVar);
            if (!TextUtils.isEmpty(aVar.analyticsEventName())) {
                EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, aVar.analyticsEventName()).setValue(Double.valueOf(0.0d)).build());
            }
            notifyDataSetChanged();
            return;
        }
        str = TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("menu, expand group:");
        stringBuilder.append(aVar);
        com.iqoption.core.i.d(str, stringBuilder.toString());
        this.cCj.remove(aVar);
        this.cCi.add(aVar);
        if (!TextUtils.isEmpty(aVar.analyticsEventName())) {
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, aVar.analyticsEventName()).setValue(Double.valueOf(1.0d)).build());
        }
        notifyDataSetChanged();
    }

    private com.iqoption.fragment.leftmenu.content.a eV(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.cCl.size(); i3++) {
            com.iqoption.fragment.leftmenu.content.a aVar = (com.iqoption.fragment.leftmenu.content.a) this.cCl.get(i3);
            if (i2 == i) {
                return aVar;
            }
            if (this.cCi.contains(aVar)) {
                int childCount = aVar.getChildCount() + i2;
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getItem, groupEndPos=");
                stringBuilder.append(childCount);
                com.iqoption.core.i.v(str, stringBuilder.toString());
                if (childCount >= i) {
                    i2 = (i - i2) - 1;
                    String str2 = TAG;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("getItem for pos:");
                    stringBuilder2.append(i);
                    stringBuilder2.append(", parent pos:");
                    stringBuilder2.append(i3);
                    stringBuilder2.append(", child pos in group:");
                    stringBuilder2.append(i2);
                    com.iqoption.core.i.v(str2, stringBuilder2.toString());
                    return aVar.getChild(i2);
                }
                i2 += aVar.getChildCount() + 1;
            } else {
                i2++;
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("item not found for pos ");
        stringBuilder3.append(i);
        stringBuilder3.append(" of ");
        stringBuilder3.append(getItemCount());
        String stringBuilder4 = stringBuilder3.toString();
        com.iqoption.core.i.e(TAG, stringBuilder4);
        throw new RuntimeException(stringBuilder4);
    }

    public int getItemCount() {
        Iterator sI = this.cCl.iterator();
        int i = 0;
        while (sI.hasNext()) {
            com.iqoption.fragment.leftmenu.content.a aVar = (com.iqoption.fragment.leftmenu.content.a) sI.next();
            i = this.cCi.contains(aVar) ? i + aVar.getSize() : i + 1;
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("menu item count: ");
        stringBuilder.append(i);
        com.iqoption.core.i.v(str, stringBuilder.toString());
        return i;
    }
}
