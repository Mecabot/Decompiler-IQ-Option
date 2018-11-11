package com.iqoption.chat.viewmodel;

import com.iqoption.chat.component.aa;
import com.iqoption.chat.component.am;
import com.iqoption.chat.component.u;
import com.iqoption.chat.component.w;
import com.iqoption.chat.component.y;
import com.iqoption.chat.fragment.e;
import com.iqoption.microservice.chat.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 #2\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001j\u0002`\u0005:\u0001#B/\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\fJ\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0002J,\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00022\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J$\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0003H\u0002J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, aXE = {"Lcom/iqoption/chat/viewmodel/SupportMessagesConverter;", "Lkotlin/Function1;", "", "Lcom/iqoption/microservice/chat/ChatMessage;", "Lcom/iqoption/chat/component/MessageAdapterItem;", "Lcom/iqoption/chat/viewmodel/MessagesConverter;", "s", "Lcom/iqoption/core/microservices/chat/response/ChatSuggestion;", "canLoadMore", "Lkotlin/Function0;", "", "isLoading", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "dateComparator", "Lcom/iqoption/chat/fragment/DateComparator;", "suggestionTime", "", "suggestions", "", "compareSenderAndDate", "m1", "m2", "convertAttachments", "attachments", "Lcom/iqoption/microservice/chat/ChatAttachment;", "msg", "bubble", "", "findSuggestions", "messages", "getBubble", "currentMsg", "prevMsg", "nextMsg", "invoke", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SupportMessagesConverter.kt */
public final class h implements b<List<? extends g>, List<? extends y>> {
    public static final a aLN = new a();
    private final e aFV;
    private final kotlin.jvm.a.a<Boolean> aKh;
    private final kotlin.jvm.a.a<Boolean> aKi;
    private long aLL = -1;
    private final List<com.iqoption.core.microservices.b.a.a> aLM;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/chat/viewmodel/SupportMessagesConverter$Companion;", "", "()V", "DEPTH_MAX", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: SupportMessagesConverter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public h(List<com.iqoption.core.microservices.b.a.a> list, kotlin.jvm.a.a<Boolean> aVar, kotlin.jvm.a.a<Boolean> aVar2) {
        kotlin.jvm.internal.h.e(list, "s");
        kotlin.jvm.internal.h.e(aVar, "canLoadMore");
        kotlin.jvm.internal.h.e(aVar2, "isLoading");
        this.aKh = aVar;
        this.aKi = aVar2;
        this.aLM = u.O((Collection) list);
        this.aFV = new e();
    }

    /* renamed from: V */
    public synchronized List<y> invoke(List<g> list) {
        List<y> arrayList;
        kotlin.jvm.internal.h.e(list, "messages");
        arrayList = new ArrayList();
        g gVar = (g) null;
        g gVar2 = gVar;
        int i = 0;
        for (g gVar3 : list) {
            i++;
            int a = a(gVar3, gVar2, (g) u.h(list, i));
            List attachments = gVar3.getAttachments();
            if (attachments == null) {
                attachments = m.emptyList();
            }
            if (attachments.isEmpty()) {
                arrayList.add(new aa(gVar3, a));
            } else {
                arrayList.addAll(a(attachments, gVar3, a));
            }
            gVar2 = gVar3;
        }
        if (((Boolean) this.aKh.invoke()).booleanValue()) {
            arrayList.add(new u());
        }
        if (arrayList.isEmpty() && this.aLM.isEmpty()) {
            if (((Boolean) this.aKi.invoke()).booleanValue()) {
                arrayList.add(new w());
            } else {
                arrayList.add(new com.iqoption.chat.component.e());
            }
        } else if ((arrayList.isEmpty() ^ 1) != 0) {
            List ad = ad(list);
            if ((ad.isEmpty() ^ 1) != 0) {
                Iterable<com.iqoption.core.microservices.b.a.a> iterable = ad;
                Collection arrayList2 = new ArrayList(n.e(iterable, 10));
                for (com.iqoption.core.microservices.b.a.a amVar : iterable) {
                    arrayList2.add(new am(amVar));
                }
                arrayList.addAll(0, s.bS((List) arrayList2));
                this.aLM.clear();
            }
        }
        if ((this.aLM.isEmpty() ^ 1) != 0) {
            g gVar4 = (g) u.bV(list);
            long j = 0;
            if (this.aLL == -1) {
                if (gVar4 != null) {
                    j = gVar4.getDate();
                }
                this.aLL = j;
                Iterable<com.iqoption.core.microservices.b.a.a> iterable2 = this.aLM;
                Collection arrayList3 = new ArrayList(n.e(iterable2, 10));
                for (com.iqoption.core.microservices.b.a.a amVar2 : iterable2) {
                    arrayList3.add(new am(amVar2));
                }
                arrayList.addAll(0, s.bS((List) arrayList3));
            } else {
                long j2 = this.aLL;
                if (gVar4 != null) {
                    j = gVar4.getDate();
                }
                if (j2 < j) {
                    this.aLM.clear();
                }
            }
        }
        return arrayList;
    }

    private final List<com.iqoption.core.microservices.b.a.a> ad(List<g> list) {
        int i = 0;
        for (g gVar : list) {
            if (i == 3 || gVar.arg()) {
                return m.emptyList();
            }
            List<com.iqoption.core.microservices.b.a.a> Vz = gVar.ari().Vz();
            if (Vz != null && (Vz.isEmpty() ^ 1) != 0) {
                return Vz;
            }
            i++;
        }
        return m.emptyList();
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
