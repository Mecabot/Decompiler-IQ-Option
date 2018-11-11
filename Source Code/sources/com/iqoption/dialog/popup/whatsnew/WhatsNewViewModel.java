package com.iqoption.dialog.popup.whatsnew;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.ViewModelStores;
import android.support.v4.app.Fragment;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.core.data.model.InstrumentType;
import java.util.Map;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0003\u0018\u0019\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, aXE = {"Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel;", "Landroid/arch/lifecycle/ViewModel;", "popup", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "(Lcom/iqoption/core/microservices/popupserver/response/Popup;)V", "action", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action;", "getAction", "()Landroid/arch/lifecycle/LiveData;", "actionData", "Lcom/iqoption/core/data/livedata/IQLiveEvent;", "isInvalid", "", "()Z", "getPopup", "()Lcom/iqoption/core/microservices/popupserver/response/Popup;", "state", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$State;", "getState", "()Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$State;", "onNegativeAction", "", "onPositiveAction", "Action", "Companion", "State", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WhatsNewViewModel.kt */
public final class WhatsNewViewModel extends ViewModel {
    private static com.iqoption.core.microservices.popupserver.response.a cjL;
    public static final b cjM = new b();
    private final c cjH = new c(this.cjK.Ws());
    private final com.iqoption.core.data.b.b<a> cjI = new com.iqoption.core.data.b.b();
    private final LiveData<a> cjJ = this.cjI;
    private final com.iqoption.core.microservices.popupserver.response.a cjK;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, aXE = {"Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action;", "", "id", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "Close", "Empty", "OpenAsset", "OpenIndicatorsLibrary", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action$Empty;", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action$Close;", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action$OpenIndicatorsLibrary;", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action$OpenAsset;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WhatsNewViewModel.kt */
    public static abstract class a {
        private final String id;
        private final String title;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, aXE = {"Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action$Close;", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action;", "title", "", "(Ljava/lang/String;)V", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: WhatsNewViewModel.kt */
        public static final class a extends a {
            public a(String str) {
                h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
                super("close", str, null);
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, aXE = {"Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action$Empty;", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action;", "()V", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: WhatsNewViewModel.kt */
        public static final class b extends a {
            public static final b cjN = new b();

            private b() {
                super("close", "", null);
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, aXE = {"Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action$OpenAsset;", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action;", "title", "", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "activeId", "", "(Ljava/lang/String;Lcom/iqoption/core/data/model/InstrumentType;I)V", "getActiveId", "()I", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: WhatsNewViewModel.kt */
        public static final class c extends a {
            private final int activeId;
            private final InstrumentType instrumentType;

            public c(String str, InstrumentType instrumentType, int i) {
                h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
                h.e(instrumentType, "instrumentType");
                super("open_asset", str, null);
                this.instrumentType = instrumentType;
                this.activeId = i;
            }

            public final int getActiveId() {
                return this.activeId;
            }

            public final InstrumentType getInstrumentType() {
                return this.instrumentType;
            }
        }

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, aXE = {"Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action$OpenIndicatorsLibrary;", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action;", "title", "", "(Ljava/lang/String;)V", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: WhatsNewViewModel.kt */
        public static final class d extends a {
            public d(String str) {
                h.e(str, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
                super("open_indicators_library", str, null);
            }
        }

        private a(String str, String str2) {
            this.id = str;
            this.title = str2;
        }

        public /* synthetic */ a(String str, String str2, f fVar) {
            this(str, str2);
        }

        public final String getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J$\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J.\u0010\"\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010!\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0002R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\b¨\u0006%"}, aXE = {"Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$State;", "", "map", "", "", "(Ljava/util/Map;)V", "header", "getHeader", "()Ljava/lang/String;", "image", "getImage", "isInvalid", "", "()Z", "setInvalid", "(Z)V", "link", "Lcom/iqoption/core/util/link/Link;", "getLink", "()Lcom/iqoption/core/util/link/Link;", "message", "getMessage", "negativeAction", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action;", "getNegativeAction", "()Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action;", "positiveAction", "getPositiveAction", "title", "getTitle", "video", "getVideo", "parseAction", "buttonKey", "parseActionParameter", "index", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WhatsNewViewModel.kt */
    public static final class c {
        private final String cjO;
        private final String cjP;
        private final com.iqoption.core.util.a.a cjQ;
        private final a cjR;
        private final a cjS;
        private boolean cjT;
        private final String image;
        private final String message;
        private final String title;

        public c(Map<String, String> map) {
            h.e(map, "map");
            String str = (String) map.get("popup_title_header");
            if (str == null) {
                str = "";
                this.cjT = true;
            }
            this.cjO = str;
            this.image = (String) map.get("popup_image");
            this.cjP = (String) map.get("popup_video");
            boolean z = this.cjT || ((this.cjP == null && this.image == null) || (this.cjP != null && this.image == null));
            this.cjT = z;
            str = (String) map.get("popup_title_message");
            if (str == null) {
                str = "";
                this.cjT = true;
            }
            this.title = str;
            str = (String) map.get("popup_message.text");
            if (str == null) {
                str = "";
            }
            this.message = str;
            str = (String) map.get("popup_message.link");
            String str2 = (String) map.get("popup_message.highlighted_text");
            com.iqoption.core.util.a.a aVar = (str == null || str2 == null) ? null : new com.iqoption.core.util.a.a(str2, str);
            this.cjQ = aVar;
            a b = b("popup_button_negative", map);
            this.cjT = h.E(b, b.cjN);
            this.cjR = b;
            a b2 = b("popup_button_positive", map);
            this.cjT = h.E(b2, b.cjN);
            this.cjS = b2;
        }

        public final String aeW() {
            return this.cjO;
        }

        public final String getImage() {
            return this.image;
        }

        public final String aeX() {
            return this.cjP;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getMessage() {
            return this.message;
        }

        public final com.iqoption.core.util.a.a aeY() {
            return this.cjQ;
        }

        public final a aeZ() {
            return this.cjR;
        }

        public final a afa() {
            return this.cjS;
        }

        public final boolean isInvalid() {
            return this.cjT;
        }

        /* JADX WARNING: Missing block: B:25:0x007c, code:
            if ((r8 != com.iqoption.core.data.model.InstrumentType.UNKNOWN ? 1 : null) != null) goto L_0x0080;
     */
        private final com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a b(java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12) {
            /*
            r10 = this;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r0.append(r11);
            r1 = ".action";
            r0.append(r1);
            r0 = r0.toString();
            r0 = r12.get(r0);
            r0 = (java.lang.String) r0;
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r1.append(r11);
            r2 = ".title";
            r1.append(r2);
            r1 = r1.toString();
            r1 = r12.get(r1);
            r1 = (java.lang.String) r1;
            if (r0 == 0) goto L_0x00dd;
        L_0x0030:
            if (r1 != 0) goto L_0x0034;
        L_0x0032:
            goto L_0x00dd;
        L_0x0034:
            r2 = r0.hashCode();
            r3 = -689331243; // 0xffffffffd6e9a3d5 float:-1.28444931E14 double:NaN;
            if (r2 == r3) goto L_0x00c6;
        L_0x003d:
            r3 = 94756344; // 0x5a5ddf8 float:1.5598064E-35 double:4.68158543E-316;
            if (r2 == r3) goto L_0x00b5;
        L_0x0042:
            r3 = 674632891; // 0x283614bb float:1.0107525E-14 double:3.33312935E-315;
            if (r2 == r3) goto L_0x0049;
        L_0x0047:
            goto L_0x00d7;
        L_0x0049:
            r2 = "open_asset";
            r0 = r0.equals(r2);
            if (r0 == 0) goto L_0x00d7;
        L_0x0051:
            r0 = 1;
            r2 = r10.a(r12, r11, r0);
            if (r2 == 0) goto L_0x00b0;
        L_0x0058:
            r3 = com.iqoption.core.data.model.InstrumentType.values();
            r4 = r3.length;
            r5 = 0;
            r6 = 0;
        L_0x005f:
            r7 = 0;
            if (r6 >= r4) goto L_0x0072;
        L_0x0062:
            r8 = r3[r6];
            r9 = r8.getServerValue();
            r9 = kotlin.jvm.internal.h.E(r9, r2);
            if (r9 == 0) goto L_0x006f;
        L_0x006e:
            goto L_0x0073;
        L_0x006f:
            r6 = r6 + 1;
            goto L_0x005f;
        L_0x0072:
            r8 = r7;
        L_0x0073:
            if (r8 == 0) goto L_0x007f;
        L_0x0075:
            r2 = com.iqoption.core.data.model.InstrumentType.UNKNOWN;
            if (r8 == r2) goto L_0x007b;
        L_0x0079:
            r2 = 1;
            goto L_0x007c;
        L_0x007b:
            r2 = 0;
        L_0x007c:
            if (r2 == 0) goto L_0x007f;
        L_0x007e:
            goto L_0x0080;
        L_0x007f:
            r8 = r7;
        L_0x0080:
            if (r8 == 0) goto L_0x00b0;
        L_0x0082:
            r2 = 2;
            r11 = r10.a(r12, r11, r2);
            if (r11 == 0) goto L_0x00ab;
        L_0x0089:
            r11 = kotlin.text.t.nf(r11);
            if (r11 == 0) goto L_0x009d;
        L_0x008f:
            r12 = r11;
            r12 = (java.lang.Number) r12;
            r12 = r12.intValue();
            if (r12 <= 0) goto L_0x0099;
        L_0x0098:
            goto L_0x009a;
        L_0x0099:
            r0 = 0;
        L_0x009a:
            if (r0 == 0) goto L_0x009d;
        L_0x009c:
            r7 = r11;
        L_0x009d:
            if (r7 == 0) goto L_0x00ab;
        L_0x009f:
            r11 = r7.intValue();
            r12 = new com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel$a$c;
            r12.<init>(r1, r8, r11);
            r12 = (com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a) r12;
            goto L_0x00dc;
        L_0x00ab:
            r11 = com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a.b.cjN;
            r11 = (com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a) r11;
            return r11;
        L_0x00b0:
            r11 = com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a.b.cjN;
            r11 = (com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a) r11;
            return r11;
        L_0x00b5:
            r11 = "close";
            r11 = r0.equals(r11);
            if (r11 == 0) goto L_0x00d7;
        L_0x00bd:
            r11 = new com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel$a$a;
            r11.<init>(r1);
            r12 = r11;
            r12 = (com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a) r12;
            goto L_0x00dc;
        L_0x00c6:
            r11 = "open_indicators_library";
            r11 = r0.equals(r11);
            if (r11 == 0) goto L_0x00d7;
        L_0x00ce:
            r11 = new com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel$a$d;
            r11.<init>(r1);
            r12 = r11;
            r12 = (com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a) r12;
            goto L_0x00dc;
        L_0x00d7:
            r11 = com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a.b.cjN;
            r12 = r11;
            r12 = (com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a) r12;
        L_0x00dc:
            return r12;
        L_0x00dd:
            r11 = com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a.b.cjN;
            r11 = (com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a) r11;
            return r11;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.c.b(java.lang.String, java.util.Map):com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel$a");
        }

        private final String a(Map<String, String> map, String str, int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".action_param");
            stringBuilder.append(i);
            return (String) map.get(stringBuilder.toString());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\t\u001a\u0002H\n\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Companion;", "Landroid/arch/lifecycle/ViewModelProvider$Factory;", "()V", "ACTION_CLOSE", "", "ACTION_OPEN_ASSET", "ACTION_OPEN_INDICATORS_LIBRARY", "POPUP", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "get", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel;", "f", "Landroid/support/v4/app/Fragment;", "popup", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WhatsNewViewModel.kt */
    public static final class b implements Factory {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            h.e(cls, "modelClass");
            return new WhatsNewViewModel(WhatsNewViewModel.aeV());
        }

        public final WhatsNewViewModel a(Fragment fragment, com.iqoption.core.microservices.popupserver.response.a aVar) {
            ViewModelProvider viewModelProvider;
            h.e(fragment, "f");
            h.e(aVar, "popup");
            b bVar = this;
            WhatsNewViewModel.cjL = aVar;
            Factory factory = this;
            if (factory != null) {
                viewModelProvider = new ViewModelProvider(ViewModelStores.e(fragment), factory);
            } else {
                viewModelProvider = ViewModelProviders.d(fragment);
                h.d(viewModelProvider, "ViewModelProviders.of(f)");
            }
            ViewModel h = viewModelProvider.h(WhatsNewViewModel.class);
            h.d(h, "if (factory != null) {\n …f(f)\n    }[T::class.java]");
            return (WhatsNewViewModel) h;
        }
    }

    public WhatsNewViewModel(com.iqoption.core.microservices.popupserver.response.a aVar) {
        h.e(aVar, "popup");
        this.cjK = aVar;
    }

    public static final /* synthetic */ com.iqoption.core.microservices.popupserver.response.a aeV() {
        com.iqoption.core.microservices.popupserver.response.a aVar = cjL;
        if (aVar == null) {
            h.lS("POPUP");
        }
        return aVar;
    }

    public final c aeR() {
        return this.cjH;
    }

    public final LiveData<a> aeS() {
        return this.cjJ;
    }

    public final boolean isInvalid() {
        return this.cjH.isInvalid();
    }

    public final void aeT() {
        this.cjI.setValue(this.cjH.aeZ());
    }

    public final void aeU() {
        this.cjI.setValue(this.cjH.afa());
    }
}
