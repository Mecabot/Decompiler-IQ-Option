package com.iqoption.quiz.d;

import android.arch.lifecycle.Observer;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;
import com.iqoption.core.ui.c;
import com.iqoption.fragment.cashbox.deppage.b;
import com.iqoption.quiz.ae.a;
import com.iqoption.quiz.b.aa;
import com.iqoption.quiz.c.g;
import com.iqoption.quiz.model.TriviaSocketViewModel;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/quiz/winners/WinnersDelegate;", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "b", "Lcom/iqoption/quiz/databinding/WinnersLayoutBinding;", "(Landroid/support/v4/app/FragmentActivity;Lcom/iqoption/quiz/databinding/WinnersLayoutBinding;)V", "diffCallback", "Lcom/iqoption/quiz/winners/WinnerDiffCallback;", "viewModel", "Lcom/iqoption/quiz/model/TriviaSocketViewModel;", "quiz_release"})
/* compiled from: WinnersDelegate.kt */
public final class f {
    private final TriviaSocketViewModel dfY;
    private final a dps = new a();

    public f(FragmentActivity fragmentActivity, aa aaVar) {
        h.e(fragmentActivity, "activity");
        h.e(aaVar, b.TAG);
        this.dfY = TriviaSocketViewModel.dmB.x(fragmentActivity);
        RecyclerView recyclerView = aaVar.dlg;
        h.d(recyclerView, "b.winnersList");
        final e eVar = new e(recyclerView);
        final d dVar = new d();
        recyclerView = aaVar.dlg;
        h.d(recyclerView, "b.winnersList");
        recyclerView.setAdapter(dVar);
        aaVar.dlg.addItemDecoration(new g(fragmentActivity.getResources().getDimensionPixelSize(a.dp24)));
        recyclerView = aaVar.dlg;
        h.d(recyclerView, "b.winnersList");
        recyclerView.setItemAnimator((ItemAnimator) null);
        aaVar.dlg.addOnItemTouchListener(new OnItemTouchListener() {
            public void onRequestDisallowInterceptTouchEvent(boolean z) {
            }

            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            }

            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                eVar.stop();
                return false;
            }
        });
        final aa aaVar2 = aaVar;
        final FragmentActivity fragmentActivity2 = fragmentActivity;
        this.dfY.aBH().observe(fragmentActivity, new Observer<c<List<? extends b>>>(this) {
            final /* synthetic */ f dpu;

            /* JADX WARNING: Missing block: B:9:0x007b, code:
            if (r7 != null) goto L_0x0080;
     */
            /* renamed from: a */
            public final void onChanged(com.iqoption.core.ui.c<java.util.List<com.iqoption.quiz.d.b>> r7) {
                /*
                r6 = this;
                if (r7 == 0) goto L_0x0091;
            L_0x0002:
                r0 = r7.Yt();
                r1 = com.iqoption.core.ui.Status.SUCCESS;
                if (r0 == r1) goto L_0x000c;
            L_0x000a:
                goto L_0x0091;
            L_0x000c:
                r0 = r6.dpu;
                r0 = r0.dps;
                r1 = r3;
                r1 = r1.getItems();
                r0.aa(r1);
                r0 = r6.dpu;
                r0 = r0.dps;
                r1 = r7.getData();
                if (r1 != 0) goto L_0x002a;
            L_0x0027:
                kotlin.jvm.internal.h.aXZ();
            L_0x002a:
                r1 = (java.util.List) r1;
                r0.ab(r1);
                r0 = r6.dpu;
                r0 = r0.dps;
                r0 = (android.support.v7.util.DiffUtil.Callback) r0;
                r1 = 0;
                r0 = android.support.v7.util.DiffUtil.calculateDiff(r0, r1);
                r2 = r6.dpu;
                r2 = r2.dps;
                r2.reset();
                r2 = r3;
                r3 = r7.getData();
                r3 = (java.util.List) r3;
                r2.b(r3, r0);
                r0 = r4;
                r0 = r0.dlf;
                r2 = "b.winnersCount";
                kotlin.jvm.internal.h.d(r0, r2);
                r2 = r5;
                r3 = com.iqoption.quiz.ae.h.winners_n1;
                r4 = 1;
                r4 = new java.lang.Object[r4];
                r7 = r7.getData();
                r7 = (java.util.List) r7;
                if (r7 == 0) goto L_0x007e;
            L_0x0068:
                r7 = r7.size();
                r5 = 10;
                r5 = kotlin.text.b.mj(r5);
                r7 = java.lang.Integer.toString(r7, r5);
                r5 = "java.lang.Integer.toStri…(this, checkRadix(radix))";
                kotlin.jvm.internal.h.d(r7, r5);
                if (r7 == 0) goto L_0x007e;
            L_0x007d:
                goto L_0x0080;
            L_0x007e:
                r7 = "0";
            L_0x0080:
                r4[r1] = r7;
                r7 = r2.getString(r3, r4);
                r7 = (java.lang.CharSequence) r7;
                r0.setText(r7);
                r7 = r6;
                r7.start();
                return;
            L_0x0091:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iqoption.quiz.d.f.2.a(com.iqoption.core.ui.c):void");
            }
        });
    }
}
