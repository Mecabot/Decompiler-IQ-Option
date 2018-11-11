package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.a;
import com.google.android.youtube.player.YouTubePlayer.c;
import com.google.android.youtube.player.YouTubePlayer.d;

public final class t implements YouTubePlayer {
    private d LE;
    private f LF;

    public t(d dVar, f fVar) {
        this.LE = (d) b.e(dVar, "connectionClient cannot be null");
        this.LF = (f) b.e(fVar, "embeddedPlayer cannot be null");
    }

    public final boolean H(Bundle bundle) {
        try {
            return this.LF.H(bundle);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void a(Configuration configuration) {
        try {
            this.LF.a(configuration);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void a(final a aVar) {
        try {
            this.LF.a(new g.a() {
                public final void a(boolean z) {
                    aVar.Z(z);
                }
            });
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void a(final c cVar) {
        try {
            this.LF.a(new h.a() {
                public final void a() {
                    cVar.oZ();
                }

                public final void a(int i) {
                    cVar.av(i);
                }

                public final void a(boolean z) {
                    cVar.aa(z);
                }

                public final void b() {
                    cVar.onPaused();
                }

                public final void c() {
                    cVar.onStopped();
                }
            });
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void a(final d dVar) {
        try {
            this.LF.a(new i.a() {
                public final void a() {
                    dVar.pa();
                }

                public final void a(String str) {
                    dVar.cz(str);
                }

                public final void b() {
                    dVar.pb();
                }

                public final void c() {
                    dVar.pc();
                }

                /* JADX WARNING: Removed duplicated region for block: B:2:0x0005 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.IllegalArgumentException (unused java.lang.IllegalArgumentException)} */
                /* JADX WARNING: Missing block: B:2:0x0005, code:
            r2 = com.google.android.youtube.player.YouTubePlayer.ErrorReason.UNKNOWN;
     */
                public final void cA(java.lang.String r2) {
                    /*
                    r1 = this;
                    r2 = com.google.android.youtube.player.YouTubePlayer.ErrorReason.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x0005, IllegalArgumentException -> 0x0005 }
                    goto L_0x0007;
                L_0x0005:
                    r2 = com.google.android.youtube.player.YouTubePlayer.ErrorReason.UNKNOWN;
                L_0x0007:
                    r0 = r3;
                    r0.a(r2);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.youtube.player.internal.t.2.cA(java.lang.String):void");
                }

                public final void d() {
                    dVar.pd();
                }
            });
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void a(boolean z) {
        try {
            this.LF.a(z);
            this.LE.a(z);
            this.LE.d();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final boolean a(int i, KeyEvent keyEvent) {
        try {
            return this.LF.a(i, keyEvent);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void au(int i) {
        try {
            this.LF.a(i);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void b() {
        try {
            this.LF.m();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void b(boolean z) {
        try {
            this.LF.e(z);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final boolean b(int i, KeyEvent keyEvent) {
        try {
            return this.LF.b(i, keyEvent);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void c() {
        try {
            this.LF.n();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void cy(String str) {
        m(str, 0);
    }

    public final void d() {
        try {
            this.LF.o();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void e() {
        try {
            this.LF.p();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void f() {
        try {
            this.LF.q();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void g() {
        try {
            this.LF.l();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final boolean isPlaying() {
        try {
            return this.LF.c();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void m(String str, int i) {
        try {
            this.LF.l(str, i);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final int oX() {
        try {
            return this.LF.h();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final int oY() {
        try {
            return this.LF.i();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void pause() {
        try {
            this.LF.b();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void play() {
        try {
            this.LF.a();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final View pn() {
        try {
            return (View) x.a(this.LF.pk());
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final Bundle po() {
        try {
            return this.LF.pj();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void setFullscreen(boolean z) {
        try {
            this.LF.b(z);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }
}
