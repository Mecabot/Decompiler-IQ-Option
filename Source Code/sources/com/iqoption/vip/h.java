package com.iqoption.vip;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.analytics.r;
import com.iqoption.d.alu;
import com.iqoption.d.alw;
import com.iqoption.util.bf;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0016R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, aXE = {"Lcom/iqoption/vip/VipEducationAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "vipManager", "Lcom/iqoption/microservice/vip/VipManager;", "(Lcom/iqoption/microservice/vip/VipManager;)V", "categorySessionsMap", "", "", "", "Lcom/iqoption/vip/VipEducationAdapter$ItemWrapper;", "items", "", "getItemCount", "", "getItemId", "position", "getItemViewType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "EducationItemViewHolder", "EducationSessionItemViewHolder", "ItemWrapper", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VipEducationAdapter.kt */
public final class h extends Adapter<ViewHolder> {
    public static final a dLi = new a();
    private final com.iqoption.microservice.vip.d dLe;
    private final Map<Long, List<d>> dLh = new LinkedHashMap();
    private final List<d> nj = new ArrayList();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/vip/VipEducationAdapter$Companion;", "", "()V", "VIEW_TYPE_CATEGORY", "", "VIEW_TYPE_SESSION", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VipEducationAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, aXE = {"Lcom/iqoption/vip/VipEducationAdapter$ItemWrapper;", "", "viewType", "", "sessionBg", "category", "Lcom/iqoption/microservice/vip/TrainingSessionCategory;", "session", "Lcom/iqoption/microservice/vip/TrainingSession;", "(IILcom/iqoption/microservice/vip/TrainingSessionCategory;Lcom/iqoption/microservice/vip/TrainingSession;)V", "getCategory", "()Lcom/iqoption/microservice/vip/TrainingSessionCategory;", "getSession", "()Lcom/iqoption/microservice/vip/TrainingSession;", "getSessionBg", "()I", "getViewType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VipEducationAdapter.kt */
    public static final class d {
        public static final a dLt = new a();
        private final int cqA;
        private final int dLq;
        private final com.iqoption.microservice.vip.c dLr;
        private final com.iqoption.microservice.vip.b dLs;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, aXE = {"Lcom/iqoption/vip/VipEducationAdapter$ItemWrapper$Companion;", "", "()V", "fromCategory", "Lcom/iqoption/vip/VipEducationAdapter$ItemWrapper;", "category", "Lcom/iqoption/microservice/vip/TrainingSessionCategory;", "fromSession", "session", "Lcom/iqoption/microservice/vip/TrainingSession;", "bgResource", "", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: VipEducationAdapter.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }

            public final d b(com.iqoption.microservice.vip.b bVar, int i) {
                kotlin.jvm.internal.h.e(bVar, "session");
                return new d(2, i, null, bVar);
            }

            public final d a(com.iqoption.microservice.vip.c cVar) {
                kotlin.jvm.internal.h.e(cVar, "category");
                return new d(1, 0, cVar, null);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                if ((this.cqA == dVar.cqA ? 1 : null) != null) {
                    return (this.dLq == dVar.dLq ? 1 : null) != null && kotlin.jvm.internal.h.E(this.dLr, dVar.dLr) && kotlin.jvm.internal.h.E(this.dLs, dVar.dLs);
                }
            }
        }

        public int hashCode() {
            int i = ((this.cqA * 31) + this.dLq) * 31;
            com.iqoption.microservice.vip.c cVar = this.dLr;
            int i2 = 0;
            i = (i + (cVar != null ? cVar.hashCode() : 0)) * 31;
            com.iqoption.microservice.vip.b bVar = this.dLs;
            if (bVar != null) {
                i2 = bVar.hashCode();
            }
            return i + i2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ItemWrapper(viewType=");
            stringBuilder.append(this.cqA);
            stringBuilder.append(", sessionBg=");
            stringBuilder.append(this.dLq);
            stringBuilder.append(", category=");
            stringBuilder.append(this.dLr);
            stringBuilder.append(", session=");
            stringBuilder.append(this.dLs);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public d(int i, int i2, com.iqoption.microservice.vip.c cVar, com.iqoption.microservice.vip.b bVar) {
            this.cqA = i;
            this.dLq = i2;
            this.dLr = cVar;
            this.dLs = bVar;
        }

        public final int aKs() {
            return this.dLq;
        }

        public final com.iqoption.microservice.vip.c aKt() {
            return this.dLr;
        }

        public final com.iqoption.microservice.vip.b aKu() {
            return this.dLs;
        }

        public final int getViewType() {
            return this.cqA;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u001e\u0010\u0012\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, aXE = {"Lcom/iqoption/vip/VipEducationAdapter$EducationItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/VipEducationItemViewBinding;", "adapter", "Lcom/iqoption/vip/VipEducationAdapter;", "(Lcom/iqoption/databinding/VipEducationItemViewBinding;Lcom/iqoption/vip/VipEducationAdapter;)V", "getAdapter", "()Lcom/iqoption/vip/VipEducationAdapter;", "getBinding", "()Lcom/iqoption/databinding/VipEducationItemViewBinding;", "bind", "", "trainingCategory", "Lcom/iqoption/microservice/vip/TrainingSessionCategory;", "sessions", "", "Lcom/iqoption/vip/VipEducationAdapter$ItemWrapper;", "handleOpenClose", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VipEducationAdapter.kt */
    public static final class b extends ViewHolder {
        private final alu dLj;
        private final h dLk;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* compiled from: VipEducationAdapter.kt */
        static final class a implements OnClickListener {
            final /* synthetic */ b dLl;
            final /* synthetic */ com.iqoption.microservice.vip.c dLm;
            final /* synthetic */ List dqR;

            a(b bVar, com.iqoption.microservice.vip.c cVar, List list) {
                this.dLl = bVar;
                this.dLm = cVar;
                this.dqR = list;
            }

            public final void onClick(View view) {
                r.ajo.U(this.dLm.getId());
                this.dLl.a(this.dqR, this.dLm);
            }
        }

        public b(alu alu, h hVar) {
            kotlin.jvm.internal.h.e(alu, "binding");
            kotlin.jvm.internal.h.e(hVar, "adapter");
            super(alu.getRoot());
            this.dLj = alu;
            this.dLk = hVar;
        }

        public final void a(com.iqoption.microservice.vip.c cVar, List<d> list) {
            kotlin.jvm.internal.h.e(cVar, "trainingCategory");
            kotlin.jvm.internal.h.e(list, "sessions");
            TextView textView = this.dLj.agA;
            kotlin.jvm.internal.h.d(textView, "binding.title");
            textView.setText(cVar.getTitle());
            textView = this.dLj.bmE;
            kotlin.jvm.internal.h.d(textView, "binding.subtitle");
            View view = this.itemView;
            kotlin.jvm.internal.h.d(view, "itemView");
            textView.setText(view.getResources().getQuantityString(R.plurals.sessions, list.size(), new Object[]{Integer.valueOf(list.size())}));
            boolean containsAll = this.dLk.nj.containsAll(list);
            ImageView imageView = this.dLj.bUw;
            kotlin.jvm.internal.h.d(imageView, "binding.downIcon");
            imageView.setRotation(containsAll ? 180.0f : 0.0f);
            this.dLj.getRoot().setBackgroundResource(containsAll ? R.drawable.vip_education_item_bg_top : R.drawable.vip_education_item_bg);
            this.dLj.bUw.setOnClickListener(new a(this, cVar, list));
            View view2 = this.itemView;
            kotlin.jvm.internal.h.d(view2, "itemView");
            Picasso.with(view2.getContext()).load(cVar.atd()).into(this.dLj.bUv);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x007e A:{LOOP_END, LOOP:0: B:4:0x0050->B:16:0x007e} */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0082 A:{SYNTHETIC, EDGE_INSN: B:25:0x0082->B:18:0x0082 ?: BREAK  } */
        private final void a(java.util.List<com.iqoption.vip.h.d> r10, com.iqoption.microservice.vip.c r11) {
            /*
            r9 = this;
            r0 = r9.dLk;
            r0 = r0.nj;
            r10 = (java.util.Collection) r10;
            r0 = r0.containsAll(r10);
            r1 = 50;
            if (r0 == 0) goto L_0x002f;
        L_0x0010:
            r11 = r9.dLj;
            r11 = r11.bUw;
            r11 = r11.animate();
            r0 = 0;
            r11 = r11.rotation(r0);
            r11 = r11.setDuration(r1);
            r11.start();
            r11 = r9.dLk;
            r11 = r11.nj;
            r11.removeAll(r10);
            goto L_0x00a3;
        L_0x002f:
            r0 = r9.dLj;
            r0 = r0.bUw;
            r0 = r0.animate();
            r3 = 1127481344; // 0x43340000 float:180.0 double:5.570497984E-315;
            r0 = r0.rotation(r3);
            r0 = r0.setDuration(r1);
            r0.start();
            r0 = r9.dLk;
            r0 = r0.nj;
            r0 = r0.iterator();
            r1 = 0;
            r2 = 0;
        L_0x0050:
            r3 = r0.hasNext();
            r4 = 1;
            if (r3 == 0) goto L_0x0081;
        L_0x0057:
            r3 = r0.next();
            r3 = (com.iqoption.vip.h.d) r3;
            r5 = r3.getViewType();
            if (r5 != r4) goto L_0x007a;
        L_0x0063:
            r3 = r3.aKt();
            if (r3 != 0) goto L_0x006c;
        L_0x0069:
            kotlin.jvm.internal.h.aXZ();
        L_0x006c:
            r5 = r3.getId();
            r7 = r11.getId();
            r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
            if (r3 != 0) goto L_0x007a;
        L_0x0078:
            r3 = 1;
            goto L_0x007b;
        L_0x007a:
            r3 = 0;
        L_0x007b:
            if (r3 == 0) goto L_0x007e;
        L_0x007d:
            goto L_0x0082;
        L_0x007e:
            r2 = r2 + 1;
            goto L_0x0050;
        L_0x0081:
            r2 = -1;
        L_0x0082:
            r11 = r9.dLk;
            r11 = r11.nj;
            r11 = r11.size();
            r11 = r11 - r4;
            if (r2 >= r11) goto L_0x009a;
        L_0x008f:
            r11 = r9.dLk;
            r11 = r11.nj;
            r2 = r2 + r4;
            r11.addAll(r2, r10);
            goto L_0x00a3;
        L_0x009a:
            r11 = r9.dLk;
            r11 = r11.nj;
            r11.addAll(r10);
        L_0x00a3:
            r10 = r9.dLk;
            r10.notifyDataSetChanged();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.vip.h.b.a(java.util.List, com.iqoption.microservice.vip.c):void");
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, aXE = {"Lcom/iqoption/vip/VipEducationAdapter$EducationSessionItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/VipEducationSessionItemBinding;", "(Lcom/iqoption/databinding/VipEducationSessionItemBinding;)V", "getBinding", "()Lcom/iqoption/databinding/VipEducationSessionItemBinding;", "bind", "", "session", "Lcom/iqoption/microservice/vip/TrainingSession;", "bgResource", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VipEducationAdapter.kt */
    public static final class c extends ViewHolder {
        private final alw dLn;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* compiled from: VipEducationAdapter.kt */
        static final class a implements OnClickListener {
            final /* synthetic */ c dLo;
            final /* synthetic */ com.iqoption.microservice.vip.b dLp;

            a(c cVar, com.iqoption.microservice.vip.b bVar) {
                this.dLo = cVar;
                this.dLp = bVar;
            }

            public final void onClick(View view) {
                r.ajo.j(this.dLp.atc(), this.dLp.getId());
                com.iqoption.vip.e.a aVar = e.dLc;
                view = this.dLo.itemView;
                kotlin.jvm.internal.h.d(view, "itemView");
                Context context = view.getContext();
                if (context == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
                }
                com.iqoption.vip.e.a.a(aVar, (FragmentActivity) context, this.dLp.getId(), false, 4, null);
            }
        }

        public c(alw alw) {
            kotlin.jvm.internal.h.e(alw, "binding");
            super(alw.getRoot());
            this.dLn = alw;
        }

        public final void a(com.iqoption.microservice.vip.b bVar, int i) {
            kotlin.jvm.internal.h.e(bVar, "session");
            TextView textView = this.dLn.agA;
            kotlin.jvm.internal.h.d(textView, "binding.title");
            textView.setText(bVar.getTitle());
            textView = this.dLn.bmE;
            kotlin.jvm.internal.h.d(textView, "binding.subtitle");
            textView.setText(bf.cj(bVar.getDuration()));
            this.dLn.getRoot().setBackgroundResource(i);
            this.dLn.getRoot().setOnClickListener(new a(this, bVar));
        }
    }

    public h(com.iqoption.microservice.vip.d dVar) {
        kotlin.jvm.internal.h.e(dVar, "vipManager");
        this.dLe = dVar;
        setHasStableIds(true);
        for (com.iqoption.microservice.vip.c cVar : this.dLe.atm()) {
            int i;
            this.nj.add(d.dLt.a(cVar));
            Collection arrayList = new ArrayList();
            Iterator it = this.dLe.atn().iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((com.iqoption.microservice.vip.b) next).atc() == cVar.getId()) {
                    i = 1;
                }
                if (i != 0) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            int size = list.size();
            Iterable<com.iqoption.microservice.vip.b> iterable = list;
            Collection arrayList2 = new ArrayList(n.e(iterable, 10));
            for (com.iqoption.microservice.vip.b b : iterable) {
                int i2 = i + 1;
                arrayList2.add(d.dLt.b(b, size + -1 == i ? R.drawable.vip_education_item_bottom : R.drawable.vip_education_item_middle));
                i = i2;
            }
            this.dLh.put(Long.valueOf(cVar.getId()), (List) arrayList2);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        kotlin.jvm.internal.h.e(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding inflate;
        if (i == 1) {
            inflate = DataBindingUtil.inflate(from, R.layout.vip_education_item_view, viewGroup, false);
            kotlin.jvm.internal.h.d(inflate, "DataBindingUtil.inflate(…item_view, parent, false)");
            return new b((alu) inflate, this);
        }
        inflate = DataBindingUtil.inflate(from, R.layout.vip_education_session_item, viewGroup, false);
        kotlin.jvm.internal.h.d(inflate, "DataBindingUtil\n        …sion_item, parent, false)");
        return new c((alw) inflate);
    }

    public int getItemViewType(int i) {
        return ((d) this.nj.get(i)).getViewType();
    }

    public int getItemCount() {
        return this.nj.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        kotlin.jvm.internal.h.e(viewHolder, "holder");
        d dVar = (d) this.nj.get(i);
        if (dVar.getViewType() == 1) {
            b bVar = (b) viewHolder;
            com.iqoption.microservice.vip.c aKt = dVar.aKt();
            if (aKt == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            Object obj = this.dLh.get(Long.valueOf(dVar.aKt().getId()));
            if (obj == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            bVar.a(aKt, (List) obj);
            return;
        }
        c cVar = (c) viewHolder;
        com.iqoption.microservice.vip.b aKu = dVar.aKu();
        if (aKu == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        cVar.a(aKu, dVar.aKs());
    }

    public long getItemId(int i) {
        d dVar = (d) this.nj.get(i);
        if (dVar.getViewType() == 1) {
            com.iqoption.microservice.vip.c aKt = dVar.aKt();
            if (aKt == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            return aKt.getId();
        }
        com.iqoption.microservice.vip.b aKu = dVar.aKu();
        if (aKu == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        return -aKu.getId();
    }
}
