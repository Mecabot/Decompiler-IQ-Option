package com.iqoption.core.microservices.feed.response;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.internal.h;

@JsonAdapter(Deserializer.class)
@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, aXE = {"Lcom/iqoption/core/microservices/feed/response/FeedPriority;", "", "serverValue", "", "(Ljava/lang/String;II)V", "getServerValue", "()I", "NORMAL", "PROMOTED", "BREAKING_NEWS", "Companion", "Deserializer", "core_release"})
/* compiled from: FeedResponses.kt */
public enum FeedPriority {
    NORMAL(0),
    PROMOTED(1),
    BREAKING_NEWS(2);
    
    public static final a Companion = null;
    private final int serverValue;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/core/microservices/feed/response/FeedPriority$Companion;", "", "()V", "fromServerValue", "Lcom/iqoption/core/microservices/feed/response/FeedPriority;", "value", "", "(Ljava/lang/Integer;)Lcom/iqoption/core/microservices/feed/response/FeedPriority;", "core_release"})
    /* compiled from: FeedResponses.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final FeedPriority fromServerValue(Integer num) {
            for (FeedPriority feedPriority : FeedPriority.values()) {
                Object obj = (num != null && feedPriority.getServerValue() == num.intValue()) ? 1 : null;
                if (obj != null) {
                    break;
                }
            }
            FeedPriority feedPriority2 = null;
            return feedPriority2 != null ? feedPriority2 : FeedPriority.NORMAL;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, aXE = {"Lcom/iqoption/core/microservices/feed/response/FeedPriority$Deserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/iqoption/core/microservices/feed/response/FeedPriority;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "core_release"})
    /* compiled from: FeedResponses.kt */
    public static final class Deserializer implements JsonDeserializer<FeedPriority> {
        /* renamed from: d */
        public FeedPriority deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            h.e(jsonElement, "json");
            h.e(type, "typeOfT");
            h.e(jsonDeserializationContext, "context");
            return FeedPriority.Companion.fromServerValue(Integer.valueOf(jsonElement.getAsInt()));
        }
    }

    public static final FeedPriority fromServerValue(Integer num) {
        return Companion.fromServerValue(num);
    }

    protected FeedPriority(int i) {
        this.serverValue = i;
    }

    public final int getServerValue() {
        return this.serverValue;
    }

    static {
        Companion = new a();
    }
}
