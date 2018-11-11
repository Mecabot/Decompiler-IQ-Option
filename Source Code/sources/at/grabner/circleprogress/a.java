package at.grabner.circleprogress;

import android.animation.TimeInterpolator;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.lang.ref.WeakReference;

/* compiled from: AnimationHandler */
public class a extends Handler {
    private final WeakReference<c> hj;
    private float hk;
    private long hl;
    private long hm;
    private TimeInterpolator hn = new DecelerateInterpolator();
    private double ho;
    private TimeInterpolator mInterpolator = new AccelerateDecelerateInterpolator();

    a(c cVar) {
        super(cVar.getContext().getMainLooper());
        this.hj = new WeakReference(cVar);
    }

    public void handleMessage(Message message) {
        c cVar = (c) this.hj.get();
        if (cVar != null) {
            jumio.nv.nfc.a aVar = jumio.nv.nfc.a.values()[message.what];
            if (aVar == jumio.nv.nfc.a.TICK) {
                removeMessages(jumio.nv.nfc.a.TICK.ordinal());
            }
            float f;
            switch (cVar.ik) {
                case IDLE:
                    switch (aVar) {
                        case START_SPINNING:
                            c(cVar);
                            break;
                        case SET_VALUE:
                            b(message, cVar);
                            break;
                        case SET_VALUE_ANIMATED:
                            a(message, cVar);
                            break;
                        case TICK:
                            removeMessages(jumio.nv.nfc.a.TICK.ordinal());
                            break;
                    }
                    break;
                case SPINNING:
                    switch (aVar) {
                        case STOP_SPINNING:
                            a(cVar);
                            break;
                        case SET_VALUE:
                            b(message, cVar);
                            break;
                        case SET_VALUE_ANIMATED:
                            a(cVar, message);
                            break;
                        case TICK:
                            f = cVar.ht - cVar.hu;
                            float currentTimeMillis = (float) (((double) (System.currentTimeMillis() - this.hm)) / this.ho);
                            if (currentTimeMillis > 1.0f) {
                                currentTimeMillis = 1.0f;
                            }
                            currentTimeMillis = this.hn.getInterpolation(currentTimeMillis);
                            if (Math.abs(f) < 1.0f) {
                                cVar.ht = cVar.hu;
                            } else if (cVar.ht < cVar.hu) {
                                cVar.ht = this.hk + ((cVar.hu - this.hk) * currentTimeMillis);
                            } else {
                                cVar.ht = this.hk - ((this.hk - cVar.hu) * currentTimeMillis);
                            }
                            cVar.hv += cVar.if;
                            if (cVar.hv > 360.0f) {
                                cVar.hv = 0.0f;
                            }
                            sendEmptyMessageDelayed(jumio.nv.nfc.a.TICK.ordinal(), (long) cVar.ih);
                            cVar.invalidate();
                            break;
                    }
                    break;
                case END_SPINNING:
                    switch (aVar) {
                        case START_SPINNING:
                            cVar.ik = AnimationState.SPINNING;
                            if (cVar.iz != null) {
                                cVar.iz.a(cVar.ik);
                            }
                            sendEmptyMessageDelayed(jumio.nv.nfc.a.TICK.ordinal(), (long) cVar.ih);
                            break;
                        case SET_VALUE:
                            b(message, cVar);
                            break;
                        case SET_VALUE_ANIMATED:
                            a(cVar, message);
                            break;
                        case TICK:
                            f = (float) (((double) (System.currentTimeMillis() - this.hm)) / this.ho);
                            if (f > 1.0f) {
                                f = 1.0f;
                            }
                            cVar.ht = this.hk * (1.0f - this.hn.getInterpolation(f));
                            cVar.hv += cVar.if;
                            if (cVar.ht < 0.01f) {
                                cVar.ik = AnimationState.IDLE;
                                if (cVar.iz != null) {
                                    cVar.iz.a(cVar.ik);
                                }
                            }
                            sendEmptyMessageDelayed(jumio.nv.nfc.a.TICK.ordinal(), (long) cVar.ih);
                            cVar.invalidate();
                            break;
                    }
                    break;
                case END_SPINNING_START_ANIMATING:
                    switch (aVar) {
                        case START_SPINNING:
                            cVar.ii = false;
                            c(cVar);
                            break;
                        case SET_VALUE:
                            cVar.ii = false;
                            b(message, cVar);
                            break;
                        case SET_VALUE_ANIMATED:
                            cVar.hr = 0.0f;
                            cVar.hq = ((float[]) message.obj)[1];
                            sendEmptyMessageDelayed(jumio.nv.nfc.a.TICK.ordinal(), (long) cVar.ih);
                            break;
                        case TICK:
                            if (cVar.ht > cVar.hu && !cVar.ii) {
                                f = (float) (((double) (System.currentTimeMillis() - this.hm)) / this.ho);
                                if (f > 1.0f) {
                                    f = 1.0f;
                                }
                                cVar.ht = this.hk * (1.0f - this.hn.getInterpolation(f));
                            }
                            cVar.hv += cVar.if;
                            if (cVar.hv > 360.0f && !cVar.ii) {
                                this.hl = System.currentTimeMillis();
                                cVar.ii = true;
                                b(cVar);
                                if (cVar.iz != null) {
                                    cVar.iz.a(AnimationState.START_ANIMATING_AFTER_SPINNING);
                                }
                            }
                            if (cVar.ii) {
                                cVar.hv = 360.0f;
                                cVar.ht -= cVar.if;
                                d(cVar);
                                f = (float) (((double) (System.currentTimeMillis() - this.hm)) / this.ho);
                                if (f > 1.0f) {
                                    f = 1.0f;
                                }
                                cVar.ht = this.hk * (1.0f - this.hn.getInterpolation(f));
                            }
                            if (((double) cVar.ht) < 0.1d) {
                                cVar.ik = AnimationState.ANIMATING;
                                if (cVar.iz != null) {
                                    cVar.iz.a(cVar.ik);
                                }
                                cVar.invalidate();
                                cVar.ii = false;
                                cVar.ht = cVar.hu;
                            } else {
                                cVar.invalidate();
                            }
                            sendEmptyMessageDelayed(jumio.nv.nfc.a.TICK.ordinal(), (long) cVar.ih);
                            break;
                    }
                    break;
                case ANIMATING:
                    switch (aVar) {
                        case START_SPINNING:
                            c(cVar);
                            break;
                        case SET_VALUE:
                            b(message, cVar);
                            break;
                        case SET_VALUE_ANIMATED:
                            this.hl = System.currentTimeMillis();
                            cVar.hr = cVar.hp;
                            cVar.hq = ((float[]) message.obj)[1];
                            break;
                        case TICK:
                            if (d(cVar)) {
                                cVar.ik = AnimationState.IDLE;
                                if (cVar.iz != null) {
                                    cVar.iz.a(cVar.ik);
                                }
                                cVar.hp = cVar.hq;
                            }
                            sendEmptyMessageDelayed(jumio.nv.nfc.a.TICK.ordinal(), (long) cVar.ih);
                            cVar.invalidate();
                            break;
                    }
                    break;
            }
        }
    }

    private void a(Message message, c cVar) {
        cVar.hr = ((float[]) message.obj)[0];
        cVar.hq = ((float[]) message.obj)[1];
        this.hl = System.currentTimeMillis();
        cVar.ik = AnimationState.ANIMATING;
        if (cVar.iz != null) {
            cVar.iz.a(cVar.ik);
        }
        sendEmptyMessageDelayed(jumio.nv.nfc.a.TICK.ordinal(), (long) cVar.ih);
    }

    private void a(c cVar, Message message) {
        cVar.ik = AnimationState.END_SPINNING_START_ANIMATING;
        if (cVar.iz != null) {
            cVar.iz.a(cVar.ik);
        }
        cVar.hr = 0.0f;
        cVar.hq = ((float[]) message.obj)[1];
        this.hm = System.currentTimeMillis();
        this.hk = cVar.ht;
        sendEmptyMessageDelayed(jumio.nv.nfc.a.TICK.ordinal(), (long) cVar.ih);
    }

    private void a(c cVar) {
        cVar.ik = AnimationState.END_SPINNING;
        b(cVar);
        if (cVar.iz != null) {
            cVar.iz.a(cVar.ik);
        }
        sendEmptyMessageDelayed(jumio.nv.nfc.a.TICK.ordinal(), (long) cVar.ih);
    }

    private void b(c cVar) {
        this.ho = (double) (((cVar.ht / cVar.if) * ((float) cVar.ih)) * 2.0f);
        this.hm = System.currentTimeMillis();
        this.hk = cVar.ht;
    }

    private void c(c cVar) {
        cVar.ik = AnimationState.SPINNING;
        if (cVar.iz != null) {
            cVar.iz.a(cVar.ik);
        }
        cVar.ht = (360.0f / cVar.hs) * cVar.hp;
        cVar.hv = (360.0f / cVar.hs) * cVar.hp;
        this.hm = System.currentTimeMillis();
        this.hk = cVar.ht;
        this.ho = (double) (((cVar.hu / cVar.if) * ((float) cVar.ih)) * 2.0f);
        sendEmptyMessageDelayed(jumio.nv.nfc.a.TICK.ordinal(), (long) cVar.ih);
    }

    private boolean d(c cVar) {
        float currentTimeMillis = (float) (((double) (System.currentTimeMillis() - this.hl)) / cVar.ig);
        if (currentTimeMillis > 1.0f) {
            currentTimeMillis = 1.0f;
        }
        cVar.hp = cVar.hr + ((cVar.hq - cVar.hr) * this.mInterpolator.getInterpolation(currentTimeMillis));
        return currentTimeMillis >= 1.0f;
    }

    private void b(Message message, c cVar) {
        cVar.hr = cVar.hq;
        float f = ((float[]) message.obj)[0];
        cVar.hq = f;
        cVar.hp = f;
        cVar.ik = AnimationState.IDLE;
        if (cVar.iz != null) {
            cVar.iz.a(cVar.ik);
        }
        cVar.invalidate();
    }
}
