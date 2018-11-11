package kotlin.reflect.jvm.internal.impl.metadata.a;

import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable;

/* compiled from: NameResolverImpl.kt */
public final class d implements c {
    private final StringTable eLT;
    private final QualifiedNameTable eLU;

    public d(StringTable stringTable, QualifiedNameTable qualifiedNameTable) {
        h.e(stringTable, "strings");
        h.e(qualifiedNameTable, "qualifiedNames");
        this.eLT = stringTable;
        this.eLU = qualifiedNameTable;
    }

    public String getString(int i) {
        String string = this.eLT.getString(i);
        h.d(string, "strings.getString(index)");
        return string;
    }

    public String le(int i) {
        Triple lg = lg(i);
        List list = (List) lg.aXG();
        String a = u.a((List) lg.aXH(), ".", null, null, 0, null, null, 62, null);
        if (list.isEmpty()) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(u.a(list, "/", null, null, 0, null, null, 62, null));
        stringBuilder.append('/');
        stringBuilder.append(a);
        return stringBuilder.toString();
    }

    public boolean lf(int i) {
        return ((Boolean) lg(i).aXI()).booleanValue();
    }

    private final Triple<List<String>, List<String>, Boolean> lg(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i != -1) {
            QualifiedName kq = this.eLU.kq(i);
            StringTable stringTable = this.eLT;
            h.d(kq, "proto");
            String string = stringTable.getString(kq.bnO());
            Kind bnP = kq.bnP();
            if (bnP == null) {
                h.aXZ();
            }
            switch (bnP) {
                case CLASS:
                    linkedList2.addFirst(string);
                    break;
                case PACKAGE:
                    linkedList.addFirst(string);
                    break;
                case LOCAL:
                    linkedList2.addFirst(string);
                    z = true;
                    break;
                default:
                    break;
            }
            i = kq.bnM();
        }
        return new Triple(linkedList, linkedList2, Boolean.valueOf(z));
    }
}
