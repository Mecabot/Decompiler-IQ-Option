package com.crashlytics.android.core;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import io.fabric.sdk.android.services.settings.o;
import java.util.concurrent.CountDownLatch;

/* compiled from: CrashPromptDialog */
class h {
    private final b tA;
    private final Builder tB;

    /* compiled from: CrashPromptDialog */
    interface a {
        void F(boolean z);
    }

    /* compiled from: CrashPromptDialog */
    private static class b {
        private boolean tE;
        private final CountDownLatch tF;

        private b() {
            this.tE = false;
            this.tF = new CountDownLatch(1);
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        void G(boolean z) {
            this.tE = z;
            this.tF.countDown();
        }

        boolean gS() {
            return this.tE;
        }

        void await() {
            try {
                this.tF.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    private static int a(float f, int i) {
        return (int) (f * ((float) i));
    }

    public static h a(Activity activity, o oVar, final a aVar) {
        final b bVar = new b();
        x xVar = new x(activity, oVar);
        Builder builder = new Builder(activity);
        View a = a(activity, xVar.getMessage());
        builder.setView(a).setTitle(xVar.getTitle()).setCancelable(false).setNeutralButton(xVar.hL(), new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                bVar.G(true);
                dialogInterface.dismiss();
            }
        });
        if (oVar.epw) {
            builder.setNegativeButton(xVar.hN(), new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    bVar.G(false);
                    dialogInterface.dismiss();
                }
            });
        }
        if (oVar.epy) {
            builder.setPositiveButton(xVar.hM(), new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    aVar.F(true);
                    bVar.G(true);
                    dialogInterface.dismiss();
                }
            });
        }
        return new h(builder, bVar);
    }

    private static ScrollView a(Activity activity, String str) {
        float f = activity.getResources().getDisplayMetrics().density;
        int a = a(f, 5);
        View textView = new TextView(activity);
        textView.setAutoLinkMask(15);
        textView.setText(str);
        textView.setTextAppearance(activity, 16973892);
        textView.setPadding(a, a, a, a);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setPadding(a(f, 14), a(f, 2), a(f, 10), a(f, 12));
        scrollView.addView(textView);
        return scrollView;
    }

    private h(Builder builder, b bVar) {
        this.tA = bVar;
        this.tB = builder;
    }

    public void show() {
        this.tB.show();
    }

    public void await() {
        this.tA.await();
    }

    public boolean gS() {
        return this.tA.gS();
    }
}
