package com.google.common.base;

import java.util.Iterator;

/* compiled from: Splitter */
public final class k {
    private final b Nl;
    private final boolean Nm;
    private final b Nn;
    private final int limit;

    /* compiled from: Splitter */
    private interface b {
        Iterator<String> c(k kVar, CharSequence charSequence);
    }

    /* compiled from: Splitter */
    private static abstract class a extends AbstractIterator<String> {
        final b Nl;
        final boolean Nm;
        final CharSequence Ns;
        int limit;
        int offset = 0;

        abstract int aw(int i);

        abstract int ax(int i);

        protected a(k kVar, CharSequence charSequence) {
            this.Nl = kVar.Nl;
            this.Nm = kVar.Nm;
            this.limit = kVar.limit;
            this.Ns = charSequence;
        }

        /* renamed from: pV */
        protected String pr() {
            int i = this.offset;
            while (this.offset != -1) {
                int aw = aw(this.offset);
                if (aw == -1) {
                    aw = this.Ns.length();
                    this.offset = -1;
                } else {
                    this.offset = ax(aw);
                }
                if (this.offset == i) {
                    this.offset++;
                    if (this.offset > this.Ns.length()) {
                        this.offset = -1;
                    }
                } else {
                    while (i < aw && this.Nl.b(this.Ns.charAt(i))) {
                        i++;
                    }
                    while (aw > i && this.Nl.b(this.Ns.charAt(aw - 1))) {
                        aw--;
                    }
                    if (this.Nm && i == aw) {
                        i = this.offset;
                    } else {
                        if (this.limit == 1) {
                            aw = this.Ns.length();
                            this.offset = -1;
                            while (aw > i && this.Nl.b(this.Ns.charAt(aw - 1))) {
                                aw--;
                            }
                        } else {
                            this.limit--;
                        }
                        return this.Ns.subSequence(i, aw).toString();
                    }
                }
            }
            return (String) ps();
        }
    }

    private k(b bVar) {
        this(bVar, false, b.pv(), ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    private k(b bVar, boolean z, b bVar2, int i) {
        this.Nn = bVar;
        this.Nm = z;
        this.Nl = bVar2;
        this.limit = i;
    }

    public static k f(char c) {
        return a(b.a(c));
    }

    public static k a(final b bVar) {
        i.checkNotNull(bVar);
        return new k(new b() {
            /* renamed from: b */
            public a c(k kVar, CharSequence charSequence) {
                return new a(kVar, charSequence) {
                    int ax(int i) {
                        return i + 1;
                    }

                    int aw(int i) {
                        return bVar.a(this.Ns, i);
                    }
                };
            }
        });
    }

    public k pT() {
        return new k(this.Nn, true, this.Nl, this.limit);
    }

    public k pU() {
        return b(b.pw());
    }

    public k b(b bVar) {
        i.checkNotNull(bVar);
        return new k(this.Nn, this.Nm, bVar, this.limit);
    }

    public Iterable<String> b(final CharSequence charSequence) {
        i.checkNotNull(charSequence);
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return k.this.c(charSequence);
            }

            public String toString() {
                Joiner on = Joiner.on(", ");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('[');
                StringBuilder a = on.a(stringBuilder, (Iterable) this);
                a.append(']');
                return a.toString();
            }
        };
    }

    private Iterator<String> c(CharSequence charSequence) {
        return this.Nn.c(this, charSequence);
    }
}
