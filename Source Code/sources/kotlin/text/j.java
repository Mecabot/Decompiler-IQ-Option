package kotlin.text;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.f.f;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, aXE = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "kotlin.jvm.PlatformType", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"})
/* compiled from: Regex.kt */
final class j implements i {
    private final CharSequence eZm;
    private final MatchResult eZu = this.eZx.toMatchResult();
    private final g eZv = new b(this);
    private List<String> eZw;
    private final Matcher eZx;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, aXE = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"})
    /* compiled from: Regex.kt */
    public static final class a extends kotlin.collections.b<String> {
        final /* synthetic */ j eZy;

        a(j jVar) {
            this.eZy = jVar;
        }

        public final /* bridge */ boolean contains(Object obj) {
            return obj instanceof String ? contains((String) obj) : false;
        }

        public /* bridge */ boolean contains(String str) {
            return super.contains(str);
        }

        public final /* bridge */ int indexOf(Object obj) {
            return obj instanceof String ? indexOf((String) obj) : -1;
        }

        public /* bridge */ int indexOf(String str) {
            return super.indexOf(str);
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            return obj instanceof String ? lastIndexOf((String) obj) : -1;
        }

        public /* bridge */ int lastIndexOf(String str) {
            return super.lastIndexOf(str);
        }

        public int getSize() {
            return this.eZy.eZu.groupCount() + 1;
        }

        public String get(int i) {
            String group = this.eZy.eZu.group(i);
            return group != null ? group : "";
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, aXE = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"})
    /* compiled from: Regex.kt */
    public static final class b extends kotlin.collections.a<f> implements h {
        final /* synthetic */ j eZy;

        public boolean isEmpty() {
            return false;
        }

        b(j jVar) {
            this.eZy = jVar;
        }

        public boolean a(f fVar) {
            return super.contains(fVar);
        }

        public final boolean contains(Object obj) {
            return obj != null ? obj instanceof f : true ? a((f) obj) : false;
        }

        public int getSize() {
            return this.eZy.eZu.groupCount() + 1;
        }

        public Iterator<f> iterator() {
            return m.f(u.ac(m.L(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
        }

        public f mk(int i) {
            MatchResult a = this.eZy.eZu;
            h.d(a, "matchResult");
            f b = k.a(a, i);
            if (b.aYj().intValue() < 0) {
                return null;
            }
            String group = this.eZy.eZu.group(i);
            h.d(group, "matchResult.group(index)");
            return new f(group, b);
        }
    }

    public j(Matcher matcher, CharSequence charSequence) {
        h.e(matcher, "matcher");
        h.e(charSequence, "input");
        this.eZx = matcher;
        this.eZm = charSequence;
    }

    public kotlin.text.i.b bAk() {
        return kotlin.text.i.a.a(this);
    }

    public List<String> bAj() {
        if (this.eZw == null) {
            this.eZw = new a(this);
        }
        List<String> list = this.eZw;
        if (list == null) {
            h.aXZ();
        }
        return list;
    }
}
