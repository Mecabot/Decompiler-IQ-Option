package com.neovisionaries.ws.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ListenerManager */
class o {
    private boolean dZP = true;
    private List<al> dZQ;
    private final af dpy;
    private final List<al> mListeners = new ArrayList();

    public o(af afVar) {
        this.dpy = afVar;
    }

    public void a(al alVar) {
        if (alVar != null) {
            synchronized (this.mListeners) {
                this.mListeners.add(alVar);
                this.dZP = true;
            }
        }
    }

    private List<al> aQo() {
        synchronized (this.mListeners) {
            List<al> arrayList;
            if (this.dZP) {
                arrayList = new ArrayList(this.mListeners.size());
                for (al add : this.mListeners) {
                    arrayList.add(add);
                }
                this.dZQ = arrayList;
                this.dZP = false;
                return arrayList;
            }
            arrayList = this.dZQ;
            return arrayList;
        }
    }

    public void a(WebSocketState webSocketState) {
        for (al alVar : aQo()) {
            try {
                alVar.a(this.dpy, webSocketState);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void I(Map<String, List<String>> map) {
        for (al alVar : aQo()) {
            try {
                alVar.a(this.dpy, (Map) map);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void a(aj ajVar, aj ajVar2, boolean z) {
        for (al alVar : aQo()) {
            try {
                alVar.a(this.dpy, ajVar, ajVar2, z);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void a(aj ajVar) {
        for (al alVar : aQo()) {
            try {
                alVar.a(this.dpy, ajVar);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void b(aj ajVar) {
        for (al alVar : aQo()) {
            try {
                alVar.b(this.dpy, ajVar);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void c(aj ajVar) {
        for (al alVar : aQo()) {
            try {
                alVar.c(this.dpy, ajVar);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void d(aj ajVar) {
        for (al alVar : aQo()) {
            try {
                alVar.d(this.dpy, ajVar);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void e(aj ajVar) {
        for (al alVar : aQo()) {
            try {
                alVar.e(this.dpy, ajVar);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void f(aj ajVar) {
        for (al alVar : aQo()) {
            try {
                alVar.f(this.dpy, ajVar);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void g(aj ajVar) {
        for (al alVar : aQo()) {
            try {
                alVar.g(this.dpy, ajVar);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void kJ(String str) {
        for (al alVar : aQo()) {
            try {
                alVar.a(this.dpy, str);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void u(byte[] bArr) {
        for (al alVar : aQo()) {
            try {
                alVar.a(this.dpy, bArr);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void h(aj ajVar) {
        for (al alVar : aQo()) {
            try {
                alVar.h(this.dpy, ajVar);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void i(aj ajVar) {
        for (al alVar : aQo()) {
            try {
                alVar.i(this.dpy, ajVar);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void j(aj ajVar) {
        for (al alVar : aQo()) {
            try {
                alVar.j(this.dpy, ajVar);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void a(ThreadType threadType, Thread thread) {
        for (al alVar : aQo()) {
            try {
                alVar.a(this.dpy, threadType, thread);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void b(ThreadType threadType, Thread thread) {
        for (al alVar : aQo()) {
            try {
                alVar.b(this.dpy, threadType, thread);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void c(ThreadType threadType, Thread thread) {
        for (al alVar : aQo()) {
            try {
                alVar.c(this.dpy, threadType, thread);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void a(WebSocketException webSocketException) {
        for (al alVar : aQo()) {
            try {
                alVar.a(this.dpy, webSocketException);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void a(WebSocketException webSocketException, aj ajVar) {
        for (al alVar : aQo()) {
            try {
                alVar.b(this.dpy, webSocketException, ajVar);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void a(WebSocketException webSocketException, List<aj> list) {
        for (al alVar : aQo()) {
            try {
                alVar.a(this.dpy, webSocketException, (List) list);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void a(WebSocketException webSocketException, byte[] bArr) {
        for (al alVar : aQo()) {
            try {
                alVar.b(this.dpy, webSocketException, bArr);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void b(WebSocketException webSocketException, byte[] bArr) {
        for (al alVar : aQo()) {
            try {
                alVar.a(this.dpy, webSocketException, bArr);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void b(WebSocketException webSocketException, aj ajVar) {
        for (al alVar : aQo()) {
            try {
                alVar.a(this.dpy, webSocketException, ajVar);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    public void b(WebSocketException webSocketException) {
        for (al alVar : aQo()) {
            try {
                alVar.b(this.dpy, webSocketException);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }

    private void a(al alVar, Throwable th) {
        try {
            alVar.a(this.dpy, th);
        } catch (Throwable unused) {
        }
    }

    public void e(String str, List<String[]> list) {
        for (al alVar : aQo()) {
            try {
                alVar.a(this.dpy, str, (List) list);
            } catch (Throwable th) {
                a(alVar, th);
            }
        }
    }
}
