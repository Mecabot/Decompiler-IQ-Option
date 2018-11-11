package com.iqoption.charttools.constructor.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.List;

@SuppressLint({"ViewConstructor"})
/* compiled from: ColorPresetsView */
final class g extends RecyclerView {
    private static final int awq = com.iqoption.charttools.o.d.dp42;
    private static final int awr = com.iqoption.charttools.o.d.dp20;
    private static final int aws = com.iqoption.charttools.o.d.dp12;
    private static final int awt = com.iqoption.charttools.o.d.dp5;
    private final int[] awu;
    private final d awv;
    private a aww;
    private int lineHeight;

    /* compiled from: ColorPresetsView */
    interface a {
        void dn(int i);
    }

    /* compiled from: ColorPresetsView */
    static final class b extends View {
        private final f awA;
        private final float awB;

        b(Context context) {
            super(context);
            this.awB = com.iqoption.core.ext.a.j(context, g.awq);
            this.awA = new f(com.iqoption.core.ext.a.j(context, g.awr), com.iqoption.core.ext.a.j(context, g.aws), com.iqoption.core.ext.a.a(context, 1.0f));
            this.awA.setCallback(this);
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            i = com.iqoption.core.ext.a.s(this.awB);
            this.awA.setBounds(0, 0, i, i);
            setMeasuredDimension(i, i);
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.awA.draw(canvas);
        }

        protected boolean verifyDrawable(@NonNull Drawable drawable) {
            return this.awA == drawable || super.verifyDrawable(drawable);
        }

        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (this.awA.isStateful() && this.awA.setState(drawableState)) {
                invalidate();
            }
        }

        void setColor(int i) {
            this.awA.setColor(i);
        }

        public void setSelected(boolean z) {
            super.setSelected(z);
            this.awA.jumpToCurrentState();
        }

        void bO(boolean z) {
            super.setSelected(z);
        }
    }

    /* compiled from: ColorPresetsView */
    static final class c extends ViewHolder {
        final b awC = ((b) this.itemView);

        c(@NonNull Context context, @NonNull OnClickListener onClickListener) {
            super(new b(context));
            this.awC.setOnClickListener(onClickListener);
        }

        void bind(int i, boolean z) {
            this.awC.setColor(i);
            this.awC.setSelected(z);
            this.awC.setTag(Integer.valueOf(i));
        }

        void bP(boolean z) {
            this.awC.bO(z);
        }
    }

    /* compiled from: ColorPresetsView */
    static final class d extends Adapter<c> {
        private static final Object awD = new Object();
        private int auq = -1;
        private final OnClickListener awE;
        private int[] mF;

        d(@NonNull OnClickListener onClickListener) {
            this.awE = onClickListener;
        }

        void setColors(int[] iArr) {
            if (!Arrays.equals(this.mF, iArr)) {
                this.mF = iArr;
                notifyDataSetChanged();
            }
        }

        void setSelected(int i) {
            int i2;
            int length = this.mF.length;
            if (i != 0) {
                i2 = 0;
                while (i2 < length) {
                    if (this.mF[i2] == i) {
                        break;
                    }
                    i2++;
                }
            }
            i2 = -1;
            if (this.auq != i2) {
                i = this.auq;
                this.auq = i2;
                if (i != -1) {
                    notifyItemChanged(i, awD);
                }
                if (i2 != -1) {
                    notifyItemChanged(i2, awD);
                }
            }
        }

        @NonNull
        /* renamed from: g */
        public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new c(viewGroup.getContext(), this.awE);
        }

        /* renamed from: a */
        public void onBindViewHolder(@NonNull c cVar, int i) {
            cVar.bind(this.mF[i], this.auq == i);
        }

        /* renamed from: a */
        public void onBindViewHolder(@NonNull c cVar, int i, @NonNull List<Object> list) {
            if (list.size() > 0) {
                boolean z = false;
                if (list.get(0) == awD) {
                    if (this.auq == i) {
                        z = true;
                    }
                    cVar.bP(z);
                    return;
                }
            }
            super.onBindViewHolder(cVar, i, list);
        }

        public int getItemCount() {
            if (this.mF == null) {
                return 0;
            }
            return this.mF.length;
        }

        public long getItemId(int i) {
            return (long) this.mF[i];
        }
    }

    private int getSpan() {
        return 4;
    }

    g(Context context, int[] iArr) {
        super(context);
        if (iArr.length == 12) {
            this.awu = iArr;
        } else {
            Object obj = new int[12];
            System.arraycopy(iArr, 0, obj, 0, obj.length);
            this.awu = obj;
        }
        super.setLayoutManager(new GridLayoutManager(context, getSpan()));
        this.awv = new d(new h(this));
        this.awv.setColors(this.awu);
        super.setAdapter(this.awv);
        super.setItemAnimator(null);
        final int k = com.iqoption.core.ext.a.k(context, awt);
        this.lineHeight = com.iqoption.core.ext.a.k(context, awq);
        super.addItemDecoration(new ItemDecoration() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
                if (recyclerView.getChildAdapterPosition(view) / g.this.getSpan() != 0) {
                    rect.top = k;
                }
            }
        });
        setHasFixedSize(true);
        setOverScrollMode(2);
        setNestedScrollingEnabled(false);
        setFocusableInTouchMode(false);
    }

    final /* synthetic */ void y(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (this.aww != null) {
            this.aww.dn(intValue);
        }
    }

    void a(a aVar) {
        this.aww = aVar;
    }

    int getLineHeight() {
        return this.lineHeight;
    }

    void setSelected(int i) {
        this.awv.setSelected(i);
    }

    public void setAdapter(Adapter adapter) {
        throw new UnsupportedOperationException();
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        throw new UnsupportedOperationException();
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        throw new UnsupportedOperationException();
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        throw new UnsupportedOperationException();
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        throw new UnsupportedOperationException();
    }

    public void removeItemDecorationAt(int i) {
        throw new UnsupportedOperationException();
    }
}
