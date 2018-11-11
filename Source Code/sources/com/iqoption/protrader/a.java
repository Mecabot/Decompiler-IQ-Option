package com.iqoption.protrader;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, aXE = {"Lcom/iqoption/protrader/ClientCategory;", "", "categoryId", "", "(Ljava/lang/Integer;)V", "getCategoryId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Companion", "Lcom/iqoption/protrader/Retail;", "Lcom/iqoption/protrader/ProTrader;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ClientCategory.kt */
public abstract class a {
    public static final a ddL = new a();
    private final Integer ddK;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/protrader/ClientCategory$Companion;", "", "()V", "fromInt", "Lcom/iqoption/protrader/ClientCategory;", "categoryId", "", "(Ljava/lang/Integer;)Lcom/iqoption/protrader/ClientCategory;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: ClientCategory.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final a j(Integer num) {
            if (num != null && num.intValue() == 2) {
                return new b();
            }
            return new h(num);
        }
    }

    public static final a j(Integer num) {
        return ddL.j(num);
    }

    private a(Integer num) {
        this.ddK = num;
    }

    public /* synthetic */ a(Integer num, f fVar) {
        this(num);
    }

    public Integer ays() {
        return this.ddK;
    }
}
