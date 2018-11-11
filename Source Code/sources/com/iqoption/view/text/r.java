package com.iqoption.view.text;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.iqoption.view.d.e;

/* compiled from: LongTouchHandler */
public class r {
    private Runnable dJA;
    private long dJw;
    private OnTouchListener dJx;
    private boolean dJy;
    private b dJz;
    final Handler handler;
    private View mView;

    /* compiled from: LongTouchHandler */
    public static final class a {
        private long dJw = 150;
        private OnTouchListener dJx = null;
        private b dJz;
        private View view;

        public a ck(View view) {
            this.view = view;
            return this;
        }

        public a a(OnTouchListener onTouchListener) {
            this.dJx = onTouchListener;
            return this;
        }

        public a a(b bVar) {
            this.dJz = bVar;
            return this;
        }

        public r aJN() {
            return new r(this, null);
        }
    }

    /* compiled from: LongTouchHandler */
    public interface b {
        void aQ(View view);
    }

    /* synthetic */ r(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private r(a aVar) {
        this.handler = new Handler();
        this.dJw = 150;
        this.dJx = null;
        this.dJy = false;
        this.dJA = new Runnable() {
            public void run() {
                if (r.this.dJy) {
                    r.this.perform();
                    r.this.handler.postDelayed(r.this.dJA, r.this.dJw);
                }
            }
        };
        this.mView = aVar.view;
        this.dJw = aVar.dJw;
        this.dJx = aVar.dJx;
        this.dJz = aVar.dJz;
        init();
    }

    private void init() {
        this.mView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                r.this.perform();
            }
        });
        this.mView.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View view) {
                r.this.dJy = true;
                r.this.handler.postDelayed(r.this.dJA, r.this.dJw);
                return false;
            }
        });
        this.mView.setOnTouchListener(new e(this.dJx) {
            public boolean f(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1 && r.this.dJy) {
                    r.this.dJy = false;
                    r.this.handler.removeCallbacks(r.this.dJA);
                }
                return false;
            }
        });
    }

    private void perform() {
        if (this.dJz != null) {
            this.dJz.aQ(this.mView);
        }
    }
}
