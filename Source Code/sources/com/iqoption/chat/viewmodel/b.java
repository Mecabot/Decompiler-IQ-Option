package com.iqoption.chat.viewmodel;

import com.iqoption.chat.component.aa;
import com.iqoption.chat.component.u;
import com.iqoption.chat.component.w;
import com.iqoption.chat.component.y;
import com.iqoption.chat.fragment.e;
import com.iqoption.microservice.chat.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001j\u0002`\u0005B!\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nJ\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0002J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, aXE = {"Lcom/iqoption/chat/viewmodel/CommonMessagesConverter;", "Lkotlin/Function1;", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "Lcom/iqoption/chat/component/MessageAdapterItem;", "Lcom/iqoption/chat/viewmodel/MessagesConverter;", "canLoadMore", "Lkotlin/Function0;", "", "isLoading", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "dateComparator", "Lcom/iqoption/chat/fragment/DateComparator;", "compareSenderAndDate", "m1", "m2", "convertAttachments", "attachments", "Lcom/iqoption/microservice/chat/ChatAttachment;", "msg", "bubble", "", "getBubble", "currentMsg", "prevMsg", "nextMsg", "invoke", "messages", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CommonMessagesConverter.kt */
public final class b implements kotlin.jvm.a.b<List<? extends g>, List<? extends y>> {
    private final e aFV = new e();
    private final a<Boolean> aKh;
    private final a<Boolean> aKi;

    public b(a<Boolean> aVar, a<Boolean> aVar2) {
        h.e(aVar, "canLoadMore");
        h.e(aVar2, "isLoading");
        this.aKh = aVar;
        this.aKi = aVar2;
    }

    /* renamed from: V */
    public List<y> invoke(List<g> list) {
        h.e(list, "messages");
        List<y> arrayList = new ArrayList();
        g gVar = (g) null;
        int i = 0;
        for (g gVar2 : list) {
            i++;
            int a = a(gVar2, gVar, (g) u.h(list, i));
            List attachments = gVar2.getAttachments();
            if (attachments == null) {
                attachments = m.emptyList();
            }
            if (attachments.isEmpty()) {
                arrayList.add(new aa(gVar2, a));
            } else {
                arrayList.addAll(a(attachments, gVar2, a));
            }
            gVar = gVar2;
        }
        if (((Boolean) this.aKh.invoke()).booleanValue()) {
            arrayList.add(new u());
        }
        if (arrayList.isEmpty()) {
            if (((Boolean) this.aKi.invoke()).booleanValue()) {
                arrayList.add(new w());
            } else {
                arrayList.add(new com.iqoption.chat.component.e());
            }
        }
        return arrayList;
    }

    private final int a(g gVar, g gVar2, g gVar3) {
        return a(gVar, gVar2) ? a(gVar, gVar3) ? 2 : 1 : a(gVar, gVar3) ? 3 : 0;
    }

    private final boolean a(g gVar, g gVar2) {
        return gVar2 != null && gVar.aro() == gVar2.aro() && this.aFV.l(gVar.getDate(), gVar2.getDate());
    }

    private final List<y> a(List<com.iqoption.microservice.chat.a> list, g gVar, int i) {
        List arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 1;
        CharSequence text;
        Iterable<com.iqoption.microservice.chat.a> iterable;
        switch (i) {
            case 0:
                CharSequence text2 = gVar.getText();
                Object obj = (text2 == null || text2.length() == 0) ? 1 : null;
                if (obj != null) {
                    if (list.size() != 1) {
                        arrayList.add(new com.iqoption.chat.component.a(gVar, (com.iqoption.microservice.chat.a) u.bU(list), 1));
                        if (list.size() > 2) {
                            i = list.size() - 1;
                            while (i3 < i) {
                                arrayList.add(new com.iqoption.chat.component.a(gVar, (com.iqoption.microservice.chat.a) list.get(i3), 2));
                                i3++;
                            }
                        }
                        arrayList.add(new com.iqoption.chat.component.a(gVar, (com.iqoption.microservice.chat.a) u.bW(list), 3));
                        break;
                    }
                    arrayList.add(new com.iqoption.chat.component.a(gVar, (com.iqoption.microservice.chat.a) u.bU(list), 0));
                    break;
                }
                arrayList.add(new aa(gVar, 1));
                if (list.size() > 1) {
                    i = list.size() - 1;
                    while (i2 < i) {
                        arrayList.add(new com.iqoption.chat.component.a(gVar, (com.iqoption.microservice.chat.a) list.get(i2), 2));
                        i2++;
                    }
                }
                arrayList.add(new com.iqoption.chat.component.a(gVar, (com.iqoption.microservice.chat.a) u.bW(list), 3));
                break;
                break;
            case 1:
                text = gVar.getText();
                if (!(text == null || text.length() == 0)) {
                    i3 = 0;
                }
                if (i3 == 0) {
                    arrayList.add(new aa(gVar, i));
                    iterable = list;
                    Collection arrayList2 = new ArrayList(n.e(iterable, 10));
                    for (com.iqoption.microservice.chat.a aVar : iterable) {
                        arrayList2.add(new com.iqoption.chat.component.a(gVar, aVar, 2));
                    }
                    arrayList.addAll((List) arrayList2);
                    break;
                }
                iterable = list;
                Collection arrayList3 = new ArrayList(n.e(iterable, 10));
                for (com.iqoption.microservice.chat.a aVar2 : iterable) {
                    int i4 = i2 + 1;
                    arrayList3.add(new com.iqoption.chat.component.a(gVar, aVar2, i2 == 0 ? i : 2));
                    i2 = i4;
                }
                arrayList.addAll((List) arrayList3);
                break;
            case 2:
                CharSequence text3 = gVar.getText();
                if (text3 == null || text3.length() == 0) {
                    i2 = 1;
                }
                if (i2 == 0) {
                    arrayList.add(new aa(gVar, i));
                }
                iterable = list;
                Collection arrayList4 = new ArrayList(n.e(iterable, 10));
                for (com.iqoption.microservice.chat.a aVar22 : iterable) {
                    arrayList4.add(new com.iqoption.chat.component.a(gVar, aVar22, i));
                }
                arrayList.addAll((List) arrayList4);
                break;
            case 3:
                text = gVar.getText();
                if (!(text == null || text.length() == 0)) {
                    i3 = 0;
                }
                if (i3 == 0) {
                    arrayList.add(new aa(gVar, 2));
                }
                i3 = m.bQ(list);
                iterable = list;
                Collection arrayList5 = new ArrayList(n.e(iterable, 10));
                for (com.iqoption.microservice.chat.a aVar222 : iterable) {
                    int i5 = i2 + 1;
                    arrayList5.add(new com.iqoption.chat.component.a(gVar, aVar222, i2 == i3 ? i : 2));
                    i2 = i5;
                }
                arrayList.addAll((List) arrayList5);
                break;
        }
        return s.bT(arrayList);
    }
}
