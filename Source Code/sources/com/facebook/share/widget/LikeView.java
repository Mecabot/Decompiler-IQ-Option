package com.facebook.share.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.common.a.h;
import com.facebook.internal.n;
import com.facebook.internal.s;
import com.facebook.internal.w;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition;

@Deprecated
public class LikeView extends FrameLayout {
    private String HL;
    private ObjectType HO;
    private int JA;
    private boolean JB = true;
    private LinearLayout Jo;
    private com.facebook.share.internal.c Jp;
    private LikeBoxCountView Jq;
    private TextView Jr;
    private com.facebook.share.internal.b Js;
    private c Jt;
    private BroadcastReceiver Ju;
    private a Jv;
    private Style Jw = Style.DEFAULT;
    private HorizontalAlignment Jx = HorizontalAlignment.DEFAULT;
    private AuxiliaryViewPosition Jy = AuxiliaryViewPosition.DEFAULT;
    private int Jz;
    private int foregroundColor = -1;
    private n xm;

    @Deprecated
    public enum AuxiliaryViewPosition {
        BOTTOM("bottom", 0),
        INLINE("inline", 1),
        TOP("top", 2);
        
        static AuxiliaryViewPosition DEFAULT;
        private int intValue;
        private String stringValue;

        static {
            DEFAULT = BOTTOM;
        }

        static AuxiliaryViewPosition fromInt(int i) {
            for (AuxiliaryViewPosition auxiliaryViewPosition : values()) {
                if (auxiliaryViewPosition.getValue() == i) {
                    return auxiliaryViewPosition;
                }
            }
            return null;
        }

        private AuxiliaryViewPosition(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public String toString() {
            return this.stringValue;
        }

        private int getValue() {
            return this.intValue;
        }
    }

    @Deprecated
    public enum HorizontalAlignment {
        CENTER("center", 0),
        LEFT("left", 1),
        RIGHT("right", 2);
        
        static HorizontalAlignment DEFAULT;
        private int intValue;
        private String stringValue;

        static {
            DEFAULT = CENTER;
        }

        static HorizontalAlignment fromInt(int i) {
            for (HorizontalAlignment horizontalAlignment : values()) {
                if (horizontalAlignment.getValue() == i) {
                    return horizontalAlignment;
                }
            }
            return null;
        }

        private HorizontalAlignment(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public String toString() {
            return this.stringValue;
        }

        private int getValue() {
            return this.intValue;
        }
    }

    @Deprecated
    public enum ObjectType {
        UNKNOWN("unknown", 0),
        OPEN_GRAPH("open_graph", 1),
        PAGE("page", 2);
        
        public static ObjectType DEFAULT;
        private int intValue;
        private String stringValue;

        static {
            DEFAULT = UNKNOWN;
        }

        public static ObjectType fromInt(int i) {
            for (ObjectType objectType : values()) {
                if (objectType.getValue() == i) {
                    return objectType;
                }
            }
            return null;
        }

        private ObjectType(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public String toString() {
            return this.stringValue;
        }

        public int getValue() {
            return this.intValue;
        }
    }

    @Deprecated
    public enum Style {
        STANDARD("standard", 0),
        BUTTON("button", 1),
        BOX_COUNT("box_count", 2);
        
        static Style DEFAULT;
        private int intValue;
        private String stringValue;

        static {
            DEFAULT = STANDARD;
        }

        static Style fromInt(int i) {
            for (Style style : values()) {
                if (style.getValue() == i) {
                    return style;
                }
            }
            return null;
        }

        private Style(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public String toString() {
            return this.stringValue;
        }

        private int getValue() {
            return this.intValue;
        }
    }

    private class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(LikeView likeView, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            Object obj = 1;
            if (extras != null) {
                Object string = extras.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
                if (!(w.bc(string) || w.d(LikeView.this.HL, string))) {
                    obj = null;
                }
            }
            if (obj != null) {
                if ("com.facebook.sdk.LikeActionController.UPDATED".equals(action)) {
                    LikeView.this.ow();
                } else if ("com.facebook.sdk.LikeActionController.DID_ERROR".equals(action)) {
                    if (LikeView.this.Jt != null) {
                        LikeView.this.Jt.b(s.i(extras));
                    }
                } else if ("com.facebook.sdk.LikeActionController.DID_RESET".equals(action)) {
                    LikeView.this.b(LikeView.this.HL, LikeView.this.HO);
                    LikeView.this.ow();
                }
            }
        }
    }

    public interface c {
        void b(FacebookException facebookException);
    }

    private class a implements com.facebook.share.internal.b.c {
        private boolean JF;

        private a() {
        }

        /* synthetic */ a(LikeView likeView, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void cancel() {
            this.JF = true;
        }

        public void a(com.facebook.share.internal.b bVar, FacebookException facebookException) {
            if (!this.JF) {
                if (bVar != null) {
                    if (!bVar.nY()) {
                        facebookException = new FacebookException("Cannot use LikeView. The device may not be supported.");
                    }
                    LikeView.this.n(bVar);
                    LikeView.this.ow();
                }
                if (!(facebookException == null || LikeView.this.Jt == null)) {
                    LikeView.this.Jt.b(facebookException);
                }
                LikeView.this.Jv = null;
            }
        }
    }

    @Deprecated
    public LikeView(Context context) {
        super(context);
        initialize(context);
    }

    @Deprecated
    public LikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
        initialize(context);
    }

    @Deprecated
    public void a(String str, ObjectType objectType) {
        Object C = w.C(str, null);
        if (objectType == null) {
            objectType = ObjectType.DEFAULT;
        }
        if (!w.d(C, this.HL) || objectType != this.HO) {
            b(C, objectType);
            ow();
        }
    }

    @Deprecated
    public void setLikeViewStyle(Style style) {
        if (style == null) {
            style = Style.DEFAULT;
        }
        if (this.Jw != style) {
            this.Jw = style;
            ox();
        }
    }

    @Deprecated
    public void setAuxiliaryViewPosition(AuxiliaryViewPosition auxiliaryViewPosition) {
        if (auxiliaryViewPosition == null) {
            auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
        }
        if (this.Jy != auxiliaryViewPosition) {
            this.Jy = auxiliaryViewPosition;
            ox();
        }
    }

    @Deprecated
    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        if (horizontalAlignment == null) {
            horizontalAlignment = HorizontalAlignment.DEFAULT;
        }
        if (this.Jx != horizontalAlignment) {
            this.Jx = horizontalAlignment;
            ox();
        }
    }

    @Deprecated
    public void setForegroundColor(int i) {
        if (this.foregroundColor != i) {
            this.Jr.setTextColor(i);
        }
    }

    @Deprecated
    public void setOnErrorListener(c cVar) {
        this.Jt = cVar;
    }

    @Deprecated
    public c getOnErrorListener() {
        return this.Jt;
    }

    @Deprecated
    public void setFragment(Fragment fragment) {
        this.xm = new n(fragment);
    }

    @Deprecated
    public void setFragment(android.app.Fragment fragment) {
        this.xm = new n(fragment);
    }

    @Deprecated
    public void setEnabled(boolean z) {
        this.JB = true;
        ow();
    }

    protected void onDetachedFromWindow() {
        a(null, ObjectType.UNKNOWN);
        super.onDetachedFromWindow();
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null && getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.com_facebook_like_view);
            if (obtainStyledAttributes != null) {
                this.HL = w.C(obtainStyledAttributes.getString(h.com_facebook_like_view_com_facebook_object_id), null);
                this.HO = ObjectType.fromInt(obtainStyledAttributes.getInt(h.com_facebook_like_view_com_facebook_object_type, ObjectType.DEFAULT.getValue()));
                this.Jw = Style.fromInt(obtainStyledAttributes.getInt(h.com_facebook_like_view_com_facebook_style, Style.DEFAULT.getValue()));
                if (this.Jw == null) {
                    throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
                }
                this.Jy = AuxiliaryViewPosition.fromInt(obtainStyledAttributes.getInt(h.com_facebook_like_view_com_facebook_auxiliary_view_position, AuxiliaryViewPosition.DEFAULT.getValue()));
                if (this.Jy == null) {
                    throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
                }
                this.Jx = HorizontalAlignment.fromInt(obtainStyledAttributes.getInt(h.com_facebook_like_view_com_facebook_horizontal_alignment, HorizontalAlignment.DEFAULT.getValue()));
                if (this.Jx == null) {
                    throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
                }
                this.foregroundColor = obtainStyledAttributes.getColor(h.com_facebook_like_view_com_facebook_foreground_color, -1);
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void initialize(Context context) {
        this.Jz = getResources().getDimensionPixelSize(com.facebook.common.a.b.com_facebook_likeview_edge_padding);
        this.JA = getResources().getDimensionPixelSize(com.facebook.common.a.b.com_facebook_likeview_internal_padding);
        if (this.foregroundColor == -1) {
            this.foregroundColor = getResources().getColor(com.facebook.common.a.a.com_facebook_likeview_text_color);
        }
        setBackgroundColor(0);
        this.Jo = new LinearLayout(context);
        this.Jo.setLayoutParams(new LayoutParams(-2, -2));
        ap(context);
        aq(context);
        ar(context);
        this.Jo.addView(this.Jp);
        this.Jo.addView(this.Jr);
        this.Jo.addView(this.Jq);
        addView(this.Jo);
        b(this.HL, this.HO);
        ow();
    }

    private void ap(Context context) {
        boolean z = this.Js != null && this.Js.nX();
        this.Jp = new com.facebook.share.internal.c(context, z);
        this.Jp.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LikeView.this.ou();
            }
        });
        this.Jp.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    private void aq(Context context) {
        this.Jr = new TextView(context);
        this.Jr.setTextSize(0, getResources().getDimension(com.facebook.common.a.b.com_facebook_likeview_text_size));
        this.Jr.setMaxLines(2);
        this.Jr.setTextColor(this.foregroundColor);
        this.Jr.setGravity(17);
        this.Jr.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    }

    private void ar(Context context) {
        this.Jq = new LikeBoxCountView(context);
        this.Jq.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    private void ou() {
        if (this.Js != null) {
            Activity activity = null;
            if (this.xm == null) {
                activity = getActivity();
            }
            this.Js.a(activity, this.xm, getAnalyticsParameters());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015  */
    private android.app.Activity getActivity() {
        /*
        r3 = this;
        r0 = r3.getContext();
    L_0x0004:
        r1 = r0 instanceof android.app.Activity;
        if (r1 != 0) goto L_0x0013;
    L_0x0008:
        r2 = r0 instanceof android.content.ContextWrapper;
        if (r2 == 0) goto L_0x0013;
    L_0x000c:
        r0 = (android.content.ContextWrapper) r0;
        r0 = r0.getBaseContext();
        goto L_0x0004;
    L_0x0013:
        if (r1 == 0) goto L_0x0018;
    L_0x0015:
        r0 = (android.app.Activity) r0;
        return r0;
    L_0x0018:
        r0 = new com.facebook.FacebookException;
        r1 = "Unable to get Activity.";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.LikeView.getActivity():android.app.Activity");
    }

    private Bundle getAnalyticsParameters() {
        Bundle bundle = new Bundle();
        bundle.putString("style", this.Jw.toString());
        bundle.putString("auxiliary_position", this.Jy.toString());
        bundle.putString("horizontal_alignment", this.Jx.toString());
        bundle.putString("object_id", w.C(this.HL, ""));
        bundle.putString("object_type", this.HO.toString());
        return bundle;
    }

    private void b(String str, ObjectType objectType) {
        ov();
        this.HL = str;
        this.HO = objectType;
        if (!w.bc(str)) {
            this.Jv = new a(this, null);
            if (!isInEditMode()) {
                com.facebook.share.internal.b.a(str, objectType, this.Jv);
            }
        }
    }

    private void n(com.facebook.share.internal.b bVar) {
        this.Js = bVar;
        this.Ju = new b(this, null);
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.LikeActionController.UPDATED");
        intentFilter.addAction("com.facebook.sdk.LikeActionController.DID_ERROR");
        intentFilter.addAction("com.facebook.sdk.LikeActionController.DID_RESET");
        instance.registerReceiver(this.Ju, intentFilter);
    }

    private void ov() {
        if (this.Ju != null) {
            LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.Ju);
            this.Ju = null;
        }
        if (this.Jv != null) {
            this.Jv.cancel();
            this.Jv = null;
        }
        this.Js = null;
    }

    private void ow() {
        boolean z = this.JB ^ 1;
        if (this.Js == null) {
            this.Jp.setSelected(false);
            this.Jr.setText(null);
            this.Jq.setText(null);
        } else {
            this.Jp.setSelected(this.Js.nX());
            this.Jr.setText(this.Js.nW());
            this.Jq.setText(this.Js.nV());
            z &= this.Js.nY();
        }
        super.setEnabled(z);
        this.Jp.setEnabled(z);
        ox();
    }

    private void ox() {
        View view;
        LayoutParams layoutParams = (LayoutParams) this.Jo.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.Jp.getLayoutParams();
        int i = this.Jx == HorizontalAlignment.LEFT ? 3 : this.Jx == HorizontalAlignment.CENTER ? 1 : 5;
        layoutParams.gravity = i | 48;
        layoutParams2.gravity = i;
        this.Jr.setVisibility(8);
        this.Jq.setVisibility(8);
        if (this.Jw == Style.STANDARD && this.Js != null && !w.bc(this.Js.nW())) {
            view = this.Jr;
        } else if (this.Jw == Style.BOX_COUNT && this.Js != null && !w.bc(this.Js.nV())) {
            oy();
            view = this.Jq;
        } else {
            return;
        }
        int i2 = 0;
        view.setVisibility(0);
        ((LinearLayout.LayoutParams) view.getLayoutParams()).gravity = i;
        LinearLayout linearLayout = this.Jo;
        if (this.Jy != AuxiliaryViewPosition.INLINE) {
            i2 = 1;
        }
        linearLayout.setOrientation(i2);
        if (this.Jy == AuxiliaryViewPosition.TOP || (this.Jy == AuxiliaryViewPosition.INLINE && this.Jx == HorizontalAlignment.RIGHT)) {
            this.Jo.removeView(this.Jp);
            this.Jo.addView(this.Jp);
        } else {
            this.Jo.removeView(view);
            this.Jo.addView(view);
        }
        switch (this.Jy) {
            case TOP:
                view.setPadding(this.Jz, this.Jz, this.Jz, this.JA);
                break;
            case BOTTOM:
                view.setPadding(this.Jz, this.JA, this.Jz, this.Jz);
                break;
            case INLINE:
                if (this.Jx != HorizontalAlignment.RIGHT) {
                    view.setPadding(this.JA, this.Jz, this.Jz, this.Jz);
                    break;
                } else {
                    view.setPadding(this.Jz, this.Jz, this.JA, this.Jz);
                    break;
                }
        }
    }

    private void oy() {
        switch (this.Jy) {
            case TOP:
                this.Jq.setCaretPosition(LikeBoxCountViewCaretPosition.BOTTOM);
                return;
            case BOTTOM:
                this.Jq.setCaretPosition(LikeBoxCountViewCaretPosition.TOP);
                return;
            case INLINE:
                this.Jq.setCaretPosition(this.Jx == HorizontalAlignment.RIGHT ? LikeBoxCountViewCaretPosition.RIGHT : LikeBoxCountViewCaretPosition.LEFT);
                return;
            default:
                return;
        }
    }
}
