package com.iqoption.fragment.leftpanel;

import android.support.annotation.DrawableRes;
import com.iqoption.x.R;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u000b\f\r\u000e\u000f\u0010\u0011B\u0019\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0001\u0007\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelSection;", "", "icon", "", "eventName", "", "(ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "getIcon", "()I", "Chats", "OTN", "Portfolio", "Quiz", "Signals", "SmartFeed", "VideoEducation", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection$Portfolio;", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection$SmartFeed;", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection$Quiz;", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection$Signals;", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection$VideoEducation;", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection$Chats;", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection$OTN;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LeftPanelSection.kt */
public abstract class b {
    private final int icon;
    private final String sD;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelSection$Chats;", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection;", "()V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftPanelSection.kt */
    public static final class a extends b {
        public static final a cDN = new a();

        private a() {
            super(R.drawable.ic_chat, "left-bar_chat", null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelSection$OTN;", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection;", "()V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftPanelSection.kt */
    public static final class b extends b {
        public static final b cDO = new b();

        private b() {
            super(R.drawable.ic_otn, "left-bar_otn", null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelSection$Portfolio;", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection;", "()V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftPanelSection.kt */
    public static final class c extends b {
        public static final c cDP = new c();

        private c() {
            super(R.drawable.ic_portfolio, "left-bar_portfolio", null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelSection$Quiz;", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection;", "()V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftPanelSection.kt */
    public static final class d extends b {
        public static final d cDQ = new d();

        private d() {
            super(R.drawable.ic_quiz_left_panel_white_30dp, "left-bar_iq-quiz", null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelSection$Signals;", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection;", "()V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftPanelSection.kt */
    public static final class e extends b {
        public static final e cDR = new e();

        private e() {
            super(R.drawable.ic_signals, "left-bar_signals", null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelSection$SmartFeed;", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection;", "()V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftPanelSection.kt */
    public static final class f extends b {
        public static final f cDS = new f();

        private f() {
            super(R.drawable.ic_feed_white_dp30, "left-bar_smart-feed", null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, aXE = {"Lcom/iqoption/fragment/leftpanel/LeftPanelSection$VideoEducation;", "Lcom/iqoption/fragment/leftpanel/LeftPanelSection;", "()V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: LeftPanelSection.kt */
    public static final class g extends b {
        public static final g cDT = new g();

        private g() {
            super(R.drawable.ic_video_education, "left-bar_video-tutorials", null);
        }
    }

    private b(@DrawableRes int i, String str) {
        this.icon = i;
        this.sD = str;
    }

    public /* synthetic */ b(@DrawableRes int i, String str, f fVar) {
        this(i, str);
    }

    public final String gF() {
        return this.sD;
    }
}
