package com.iqoption.util;

import android.text.SpannableStringBuilder;
import java.util.ArrayDeque;
import java.util.Deque;

/* compiled from: Spanner */
public final class bc {
    private final Deque<a> Ur = new ArrayDeque();
    private final SpannableStringBuilder dor = new SpannableStringBuilder();

    /* compiled from: Spanner */
    private static final class a {
        final Object dos;
        final int start;

        public a(int i, Object obj) {
            this.start = i;
            this.dos = obj;
        }
    }

    public bc jO(String str) {
        this.dor.append(str);
        return this;
    }

    public bc B(CharSequence charSequence) {
        this.dor.append(charSequence);
        return this;
    }

    public bc C(char c) {
        this.dor.append(c);
        return this;
    }

    public bc bM(Object obj) {
        this.Ur.addLast(new a(this.dor.length(), obj));
        return this;
    }

    public bc aGw() {
        a aVar = (a) this.Ur.removeLast();
        this.dor.setSpan(aVar.dos, aVar.start, this.dor.length(), 17);
        return this;
    }

    public CharSequence aCT() {
        while (!this.Ur.isEmpty()) {
            aGw();
        }
        return this.dor;
    }
}
