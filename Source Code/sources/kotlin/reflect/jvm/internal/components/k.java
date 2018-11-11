package kotlin.reflect.jvm.internal.components;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.kotlin.t;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R6\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b`\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, aXE = {"Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider;", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/PackagePartProvider;", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "packageParts", "Ljava/util/HashMap;", "", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/HashMap;", "visitedModules", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "findPackageParts", "", "packageFqName", "getAnnotationsOnBinaryModule", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "moduleName", "registerModule", "", "EmptyEnumeration", "descriptors.runtime"})
/* compiled from: RuntimePackagePartProvider.kt */
public final class k implements t {
    private final ClassLoader classLoader;
    private final HashSet<String> ewU = new HashSet();
    private final HashMap<String, LinkedHashSet<String>> ewV = new HashMap();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, aXE = {"Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider$EmptyEnumeration;", "Ljava/util/Enumeration;", "", "()V", "hasMoreElements", "", "nextElement", "descriptors.runtime"})
    /* compiled from: RuntimePackagePartProvider.kt */
    private static final class a implements Enumeration {
        public static final a ewW = new a();

        public boolean hasMoreElements() {
            return false;
        }

        private a() {
        }

        /* renamed from: bau */
        public Void nextElement() {
            throw new NoSuchElementException();
        }
    }

    public k(ClassLoader classLoader) {
        h.e(classLoader, "classLoader");
        this.classLoader = classLoader;
    }

    /* JADX WARNING: Can't wrap try/catch for R(5:15|16|17|(10:19|20|21|(4:24|(2:26|56)(1:57)|27|22)|55|28|29|30|31|54)(1:52)|13) */
    /* JADX WARNING: Missing block: B:14:0x003e, code:
            if (r0.hasNext() != false) goto L_0x0040;
     */
    /* JADX WARNING: Missing block: B:17:?, code:
            r1 = ((java.net.URL) r0.next()).openStream();
     */
    /* JADX WARNING: Missing block: B:18:0x004a, code:
            if (r1 != null) goto L_0x004c;
     */
    /* JADX WARNING: Missing block: B:19:0x004c, code:
            r1 = r1;
            r3 = (java.lang.Throwable) null;
     */
    /* JADX WARNING: Missing block: B:21:?, code:
            r2 = kotlin.reflect.jvm.internal.impl.load.kotlin.s.a(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.k.eMW, kotlin.c.a.a((java.io.InputStream) r1, 0, 1, null), r9, kotlin.reflect.jvm.internal.impl.serialization.deserialization.i.a.eSX, kotlin.reflect.jvm.internal.components.RuntimePackagePartProvider$registerModule$1$mapping$1.ewX).btE().entrySet().iterator();
     */
    /* JADX WARNING: Missing block: B:23:0x0079, code:
            if (r2.hasNext() != false) goto L_0x007b;
     */
    /* JADX WARNING: Missing block: B:24:0x007b, code:
            r4 = (java.util.Map.Entry) r2.next();
            r5 = (java.lang.String) r4.getKey();
            r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.m) r4.getValue();
            r6 = r8.ewV;
            r7 = r6.get(r5);
     */
    /* JADX WARNING: Missing block: B:25:0x0095, code:
            if (r7 == null) goto L_0x0097;
     */
    /* JADX WARNING: Missing block: B:26:0x0097, code:
            r7 = new java.util.LinkedHashSet();
            r6.put(r5, r7);
     */
    /* JADX WARNING: Missing block: B:27:0x009f, code:
            r7.addAll(r4.btF());
     */
    /* JADX WARNING: Missing block: B:28:0x00ab, code:
            r2 = kotlin.l.etX;
     */
    /* JADX WARNING: Missing block: B:29:0x00ad, code:
            continue;
     */
    /* JADX WARNING: Missing block: B:30:?, code:
            kotlin.c.b.a(r1, r3);
     */
    /* JADX WARNING: Missing block: B:33:0x00b3, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:37:0x00b6, code:
            continue;
     */
    /* JADX WARNING: Missing block: B:38:?, code:
            kotlin.c.b.a(r1, r2);
     */
    /* JADX WARNING: Missing block: B:40:0x00ba, code:
            r9 = move-exception;
     */
    /* JADX WARNING: Missing block: B:43:0x00bd, code:
            throw r9;
     */
    /* JADX WARNING: Missing block: B:45:0x00bf, code:
            return;
     */
    /* JADX WARNING: Missing block: B:52:0x003a, code:
            continue;
     */
    public final synchronized void lY(java.lang.String r9) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = "moduleName";
        kotlin.jvm.internal.h.e(r9, r0);	 Catch:{ all -> 0x00c0 }
        r0 = r8.ewU;	 Catch:{ all -> 0x00c0 }
        r0 = r0.add(r9);	 Catch:{ all -> 0x00c0 }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r8);
        return;
    L_0x0010:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c0 }
        r0.<init>();	 Catch:{ all -> 0x00c0 }
        r1 = "META-INF/";
        r0.append(r1);	 Catch:{ all -> 0x00c0 }
        r0.append(r9);	 Catch:{ all -> 0x00c0 }
        r9 = ".kotlin_module";
        r0.append(r9);	 Catch:{ all -> 0x00c0 }
        r9 = r0.toString();	 Catch:{ all -> 0x00c0 }
        r0 = r8.classLoader;	 Catch:{ IOException -> 0x002d }
        r0 = r0.getResources(r9);	 Catch:{ IOException -> 0x002d }
        goto L_0x0031;
    L_0x002d:
        r0 = kotlin.reflect.jvm.internal.components.k.a.ewW;	 Catch:{ all -> 0x00c0 }
        r0 = (java.util.Enumeration) r0;	 Catch:{ all -> 0x00c0 }
    L_0x0031:
        r1 = "resources";
        kotlin.jvm.internal.h.d(r0, r1);	 Catch:{ all -> 0x00c0 }
        r0 = kotlin.collections.o.a(r0);	 Catch:{ all -> 0x00c0 }
    L_0x003a:
        r1 = r0.hasNext();	 Catch:{ all -> 0x00c0 }
        if (r1 == 0) goto L_0x00be;
    L_0x0040:
        r1 = r0.next();	 Catch:{ all -> 0x00c0 }
        r1 = (java.net.URL) r1;	 Catch:{ all -> 0x00c0 }
        r1 = r1.openStream();	 Catch:{ UnsupportedOperationException -> 0x00ba, Exception -> 0x003a }
        if (r1 == 0) goto L_0x003a;
    L_0x004c:
        r1 = (java.io.Closeable) r1;	 Catch:{ UnsupportedOperationException -> 0x00ba, Exception -> 0x003a }
        r2 = 0;
        r3 = r2;
        r3 = (java.lang.Throwable) r3;	 Catch:{ UnsupportedOperationException -> 0x00ba, Exception -> 0x003a }
        r4 = r1;
        r4 = (java.io.InputStream) r4;	 Catch:{ Throwable -> 0x00b3 }
        r5 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.k.eMW;	 Catch:{ Throwable -> 0x00b3 }
        r6 = 0;
        r7 = 1;
        r2 = kotlin.c.a.a(r4, r6, r7, r2);	 Catch:{ Throwable -> 0x00b3 }
        r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.i.a.eSX;	 Catch:{ Throwable -> 0x00b3 }
        r4 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.i) r4;	 Catch:{ Throwable -> 0x00b3 }
        r6 = kotlin.reflect.jvm.internal.components.RuntimePackagePartProvider$registerModule$1$mapping$1.ewX;	 Catch:{ Throwable -> 0x00b3 }
        r6 = (kotlin.jvm.a.b) r6;	 Catch:{ Throwable -> 0x00b3 }
        r2 = kotlin.reflect.jvm.internal.impl.load.kotlin.s.a(r5, r2, r9, r4, r6);	 Catch:{ Throwable -> 0x00b3 }
        r2 = r2.btE();	 Catch:{ Throwable -> 0x00b3 }
        r2 = r2.entrySet();	 Catch:{ Throwable -> 0x00b3 }
        r2 = r2.iterator();	 Catch:{ Throwable -> 0x00b3 }
    L_0x0075:
        r4 = r2.hasNext();	 Catch:{ Throwable -> 0x00b3 }
        if (r4 == 0) goto L_0x00ab;
    L_0x007b:
        r4 = r2.next();	 Catch:{ Throwable -> 0x00b3 }
        r4 = (java.util.Map.Entry) r4;	 Catch:{ Throwable -> 0x00b3 }
        r5 = r4.getKey();	 Catch:{ Throwable -> 0x00b3 }
        r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x00b3 }
        r4 = r4.getValue();	 Catch:{ Throwable -> 0x00b3 }
        r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.m) r4;	 Catch:{ Throwable -> 0x00b3 }
        r6 = r8.ewV;	 Catch:{ Throwable -> 0x00b3 }
        r6 = (java.util.Map) r6;	 Catch:{ Throwable -> 0x00b3 }
        r7 = r6.get(r5);	 Catch:{ Throwable -> 0x00b3 }
        if (r7 != 0) goto L_0x009f;
    L_0x0097:
        r7 = new java.util.LinkedHashSet;	 Catch:{ Throwable -> 0x00b3 }
        r7.<init>();	 Catch:{ Throwable -> 0x00b3 }
        r6.put(r5, r7);	 Catch:{ Throwable -> 0x00b3 }
    L_0x009f:
        r7 = (java.util.LinkedHashSet) r7;	 Catch:{ Throwable -> 0x00b3 }
        r4 = r4.btF();	 Catch:{ Throwable -> 0x00b3 }
        r4 = (java.util.Collection) r4;	 Catch:{ Throwable -> 0x00b3 }
        r7.addAll(r4);	 Catch:{ Throwable -> 0x00b3 }
        goto L_0x0075;
    L_0x00ab:
        r2 = kotlin.l.etX;	 Catch:{ Throwable -> 0x00b3 }
        kotlin.c.b.a(r1, r3);	 Catch:{ UnsupportedOperationException -> 0x00ba, Exception -> 0x003a }
        goto L_0x003a;
    L_0x00b1:
        r2 = move-exception;
        goto L_0x00b6;
    L_0x00b3:
        r2 = move-exception;
        r3 = r2;
        throw r3;	 Catch:{ all -> 0x00b1 }
    L_0x00b6:
        kotlin.c.b.a(r1, r3);	 Catch:{ UnsupportedOperationException -> 0x00ba, Exception -> 0x003a }
        throw r2;	 Catch:{ UnsupportedOperationException -> 0x00ba, Exception -> 0x003a }
    L_0x00ba:
        r9 = move-exception;
        r9 = (java.lang.Throwable) r9;	 Catch:{ all -> 0x00c0 }
        throw r9;	 Catch:{ all -> 0x00c0 }
    L_0x00be:
        monitor-exit(r8);
        return;
    L_0x00c0:
        r9 = move-exception;
        monitor-exit(r8);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.components.k.lY(java.lang.String):void");
    }

    public synchronized List<String> lZ(String str) {
        List<String> W;
        h.e(str, "packageFqName");
        LinkedHashSet linkedHashSet = (LinkedHashSet) this.ewV.get(str);
        W = linkedHashSet != null ? u.W(linkedHashSet) : null;
        if (W == null) {
            W = m.emptyList();
        }
        return W;
    }
}
