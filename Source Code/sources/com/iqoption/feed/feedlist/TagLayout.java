package com.iqoption.feed.feedlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iqoption.app.IQApp;
import com.iqoption.dto.Currencies;
import com.iqoption.x.R;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.CRC32;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 +2\u00020\u0001:\u0002+,B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u0014\u0010\u001a\u001a\u00020\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001cJ\b\u0010\u001d\u001a\u00020\u0016H\u0002J0\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014J\u0018\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0014J\u001a\u0010(\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0013R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, aXE = {"Lcom/iqoption/feed/feedlist/TagLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allTags", "", "", "expandItem", "Landroid/widget/TextView;", "horizontalPadding", "offset", "textItemSize", "", "topicClickListener", "Lcom/iqoption/feed/feedlist/TagLayout$TopicClickListener;", "verticalPadding", "addTag", "", "inflater", "Landroid/view/LayoutInflater;", "topic", "bindTags", "tags", "", "expand", "onLayout", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "processAttributes", "setTopicClickListener", "listener", "Companion", "TopicClickListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TagLayout.kt */
public final class TagLayout extends ViewGroup {
    private static final LruCache<String, Integer> cmM = new LruCache(128);
    private static final Map<String, Integer> cmN = ad.a(new Pair("ETC", Integer.valueOf(cmO.et(R.color.feed_bch_etc_neo))), new Pair("BCH", Integer.valueOf(cmO.et(R.color.feed_bch_etc_neo))), new Pair("NEO", Integer.valueOf(cmO.et(R.color.feed_bch_etc_neo))), new Pair(Currencies.BTC_CURRENCY, Integer.valueOf(cmO.et(R.color.feed_btc))), new Pair(Currencies.ETH_CURRENCY, Integer.valueOf(cmO.et(R.color.feed_eth_lth))), new Pair("LTH", Integer.valueOf(cmO.et(R.color.feed_eth_lth))), new Pair(Currencies.OTN_CURRENCY, Integer.valueOf(cmO.et(R.color.feed_otn))), new Pair("XRP", Integer.valueOf(cmO.et(R.color.feed_dash_xrp_qtm))), new Pair("DASH", Integer.valueOf(cmO.et(R.color.feed_dash_xrp_qtm))));
    public static final a cmO = new a();
    private static final CRC32 crc = new CRC32();
    private static int[] mF;
    private int bbT;
    private int bbU;
    private float cmI;
    private final List<String> cmJ;
    private final TextView cmK;
    private b cmL;
    private final int offset;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: TagLayout.kt */
    /* renamed from: com.iqoption.feed.feedlist.TagLayout$1 */
    static final class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ TagLayout cmP;

        AnonymousClass1(TagLayout tagLayout) {
            this.cmP = tagLayout;
        }

        public final void onClick(View view) {
            this.cmP.expand();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, aXE = {"Lcom/iqoption/feed/feedlist/TagLayout$Companion;", "", "()V", "COLOR_CACHE", "Landroid/util/LruCache;", "", "", "PREVIEW_COUNT", "colors", "", "crc", "Ljava/util/zip/CRC32;", "tagPallete", "", "colorForTag", "tag", "getUnsignedCrc", "", "value", "resolveColor", "colorRes", "resolveTagColor", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TagLayout.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        private final int et(int i) {
            return ContextCompat.getColor(IQApp.Dk(), i);
        }

        private final long hv(String str) {
            CRC32 agt = TagLayout.crc;
            Charset forName = Charset.forName("UTF-8");
            h.d(forName, "Charset.forName(\"UTF-8\")");
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Object bytes = str.getBytes(forName);
            h.d(bytes, "(this as java.lang.String).getBytes(charset)");
            agt.update(bytes);
            long value = TagLayout.crc.getValue();
            TagLayout.crc.reset();
            return value & 4294967295L;
        }

        private final int hw(String str) {
            Integer num = (Integer) TagLayout.cmM.get(str);
            if (num != null) {
                return num.intValue();
            }
            long hv = hv(str);
            if (TagLayout.mF == null) {
                IQApp Dk = IQApp.Dk();
                h.d(Dk, "IQApp.instance()");
                TypedArray obtainTypedArray = Dk.getResources().obtainTypedArray(R.array.default_feed);
                TagLayout.mF = new int[obtainTypedArray.length()];
                int length = obtainTypedArray.length();
                for (int i = 0; i < length; i++) {
                    int[] agv = TagLayout.mF;
                    if (agv == null) {
                        h.aXZ();
                    }
                    agv[i] = obtainTypedArray.getColor(i, 0);
                }
                obtainTypedArray.recycle();
            }
            int[] agv2 = TagLayout.mF;
            if (agv2 == null) {
                h.aXZ();
            }
            int length2 = (int) (hv % ((long) agv2.length));
            int[] agv3 = TagLayout.mF;
            if (agv3 == null) {
                h.aXZ();
            }
            length2 = agv3[length2];
            TagLayout.cmM.put(str, Integer.valueOf(length2));
            return length2;
        }

        private final int hx(String str) {
            Locale locale = Locale.US;
            h.d(locale, "Locale.US");
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            str = str.toUpperCase(locale);
            h.d(str, "(this as java.lang.String).toUpperCase(locale)");
            Integer num = (Integer) TagLayout.cmN.get(str);
            return num != null ? num.intValue() : hw(str);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/feed/feedlist/TagLayout$TopicClickListener;", "", "onTopicClick", "", "topic", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TagLayout.kt */
    public interface b {
        void hs(String str);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: TagLayout.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ TagLayout cmP;
        final /* synthetic */ String cmQ;

        c(TagLayout tagLayout, String str) {
            this.cmP = tagLayout;
            this.cmQ = str;
        }

        public final void onClick(View view) {
            b a = this.cmP.cmL;
            if (a != null) {
                a.hs(this.cmQ);
            }
        }
    }

    public TagLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public TagLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ TagLayout(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        if ((i2 & 2) != 0) {
            attributeSet = (AttributeSet) null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public TagLayout(Context context, AttributeSet attributeSet, int i) {
        h.e(context, "context");
        super(context, attributeSet, i);
        this.offset = context.getResources().getDimensionPixelOffset(R.dimen.dp6);
        this.cmJ = new ArrayList();
        c(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.layout.expand_tag_item, this, false);
        if (inflate == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        this.cmK = (TextView) inflate;
        this.cmK.setPadding(this.bbT, this.bbU, this.bbT, this.bbU);
        this.cmK.setTextSize(0, this.cmI);
        this.cmK.setOnClickListener(new AnonymousClass1(this));
    }

    private final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.iqoption.b.b.TagLayout, 0, 0);
        try {
            this.bbT = (int) obtainStyledAttributes.getDimension(0, (float) context.getResources().getDimensionPixelOffset(R.dimen.dp8));
            this.bbU = (int) obtainStyledAttributes.getDimension(2, (float) context.getResources().getDimensionPixelOffset(R.dimen.dp3));
            this.cmI = obtainStyledAttributes.getDimension(1, (float) context.getResources().getDimensionPixelOffset(R.dimen.sp10));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingStart = getPaddingStart();
        i = getPaddingTop();
        i2 = getMeasuredWidth() - getPaddingEnd();
        i4 = i2 - paddingStart;
        i3 = (getMeasuredHeight() - getPaddingBottom()) - i;
        int childCount = getChildCount();
        int i5 = i;
        int i6 = 0;
        i = paddingStart;
        for (paddingStart = 0; paddingStart < childCount; paddingStart++) {
            View childAt = getChildAt(paddingStart);
            h.d(childAt, "child");
            if (childAt.getVisibility() != 8) {
                childAt.measure(MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE));
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (i + measuredWidth >= i2) {
                    i5 += i6 + this.offset;
                    i = 0;
                    i6 = 0;
                }
                childAt.layout(i, i5, i + measuredWidth, i5 + measuredHeight);
                if (i6 < measuredHeight) {
                    i6 = measuredHeight;
                }
                i += measuredWidth + this.offset;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            h.d(childAt, "child");
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                if (childAt.getMeasuredWidth() + i5 > getMeasuredWidth()) {
                    i3 += childAt.getMeasuredHeight() + this.offset;
                    i5 = 0;
                } else {
                    i3 = Math.max(i3, childAt.getMeasuredHeight());
                }
                i4 = View.combineMeasuredStates(i4, childAt.getMeasuredState());
                i5 += childAt.getMeasuredWidth() + this.offset;
            }
        }
        setMeasuredDimension(getMeasuredWidth(), View.resolveSizeAndState(Math.max(i3, getSuggestedMinimumHeight()), i2, i4 << 16));
    }

    public final void setTopicClickListener(b bVar) {
        h.e(bVar, "listener");
        this.cmL = bVar;
    }

    public final void aA(List<String> list) {
        h.e(list, "tags");
        if (getChildCount() != 0) {
            removeAllViews();
        }
        this.cmJ.clear();
        this.cmJ.addAll(list);
        LayoutInflater from = LayoutInflater.from(getContext());
        for (String str : u.g(list, 3)) {
            h.d(from, "inflater");
            a(from, str);
        }
        if (this.cmJ.size() > 3) {
            TextView textView = this.cmK;
            m mVar = m.euz;
            Locale locale = Locale.US;
            h.d(locale, "Locale.US");
            Object[] objArr = new Object[]{Integer.valueOf(this.cmJ.size() - 3)};
            String format = String.format(locale, "+%d", Arrays.copyOf(objArr, objArr.length));
            h.d(format, "java.lang.String.format(locale, format, *args)");
            textView.setText(format);
            addView(this.cmK);
        }
    }

    private final void expand() {
        removeView(this.cmK);
        LayoutInflater from = LayoutInflater.from(getContext());
        for (String str : u.j(this.cmJ, this.cmJ.size() - 3)) {
            h.d(from, "inflater");
            a(from, str);
        }
    }

    private final void a(LayoutInflater layoutInflater, String str) {
        View inflate = layoutInflater.inflate(R.layout.tag_item, this, false);
        if (inflate == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        TextView textView = (TextView) inflate;
        textView.setText(str);
        textView.getBackground().setColorFilter(cmO.hx(str), Mode.SRC_ATOP);
        textView.setPadding(this.bbT, this.bbU, this.bbT, this.bbU);
        textView.setTextSize(0, this.cmI);
        textView.setOnClickListener(new c(this, str));
        addView(textView);
    }
}
