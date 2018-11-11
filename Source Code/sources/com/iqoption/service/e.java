package com.iqoption.service;

import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.entity.TopFeedTrader.List;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: WebSocketEvents */
public interface e {

    /* compiled from: WebSocketEvents */
    public static class a implements e {
    }

    /* compiled from: WebSocketEvents */
    public static class c implements e {
    }

    /* compiled from: WebSocketEvents */
    public static class d implements e {
        public final String dpE;

        public d(String str) {
            this.dpE = str;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("front: ");
            stringBuilder.append(this.dpE);
            return stringBuilder.toString();
        }
    }

    /* compiled from: WebSocketEvents */
    public static class f implements e {
    }

    /* compiled from: WebSocketEvents */
    public static class h implements e {
        public final String reason;

        h(String str) {
            this.reason = str;
        }
    }

    /* compiled from: WebSocketEvents */
    public static class i implements e {
    }

    /* compiled from: WebSocketEvents */
    public static class j implements e {
        public String toString() {
            return "RECONNECT SOCKET";
        }
    }

    /* compiled from: WebSocketEvents */
    public static class k implements e {
        public final HashMap<Integer, List> aml;
        public final String dpF;
        public final long dpG;

        public k(HashMap<Integer, List> hashMap, String str, long j) {
            this.aml = hashMap;
            this.dpF = str;
            this.dpG = j;
        }
    }

    /* compiled from: WebSocketEvents */
    public static class l implements e {
    }

    /* compiled from: WebSocketEvents */
    public static class n implements e {
    }

    /* compiled from: WebSocketEvents */
    public static class o implements e {
    }

    /* compiled from: WebSocketEvents */
    public static class b extends com.iqoption.system.a.c<Boolean> implements e {
    }

    /* compiled from: WebSocketEvents */
    public static class e extends com.iqoption.system.a.c<InstrumentType> implements e {
    }

    /* compiled from: WebSocketEvents */
    public static class g extends com.iqoption.system.a.c<WeakReference<WebSocketHandler>> implements e {
    }

    /* compiled from: WebSocketEvents */
    public static class m extends com.iqoption.system.a.c<Boolean> implements e {
    }
}
