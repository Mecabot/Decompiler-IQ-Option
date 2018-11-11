package io.reactivex.internal.util;

import io.reactivex.disposables.b;
import io.reactivex.m;
import java.io.Serializable;
import org.a.c;
import org.a.d;

public enum NotificationLite {
    COMPLETE;

    static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final b d;

        DisposableNotification(b bVar) {
            this.d = bVar;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NotificationLite.Disposable[");
            stringBuilder.append(this.d);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        final Throwable e;

        ErrorNotification(Throwable th) {
            this.e = th;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NotificationLite.Error[");
            stringBuilder.append(this.e);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        public int hashCode() {
            return this.e.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ErrorNotification)) {
                return false;
            }
            return io.reactivex.internal.a.b.equals(this.e, ((ErrorNotification) obj).e);
        }
    }

    static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final d s;

        SubscriptionNotification(d dVar) {
            this.s = dVar;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NotificationLite.Subscription[");
            stringBuilder.append(this.s);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public String toString() {
        return "NotificationLite.Complete";
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static Object subscription(d dVar) {
        return new SubscriptionNotification(dVar);
    }

    public static Object disposable(b bVar) {
        return new DisposableNotification(bVar);
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).e;
    }

    public static d getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).s;
    }

    public static b getDisposable(Object obj) {
        return ((DisposableNotification) obj).d;
    }

    public static <T> boolean accept(Object obj, c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            cVar.onError(((ErrorNotification) obj).e);
            return true;
        } else {
            cVar.e(obj);
            return false;
        }
    }

    public static <T> boolean accept(Object obj, m<? super T> mVar) {
        if (obj == COMPLETE) {
            mVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            mVar.onError(((ErrorNotification) obj).e);
            return true;
        } else {
            mVar.e(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            cVar.onError(((ErrorNotification) obj).e);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            cVar.a(((SubscriptionNotification) obj).s);
            return false;
        } else {
            cVar.e(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, m<? super T> mVar) {
        if (obj == COMPLETE) {
            mVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            mVar.onError(((ErrorNotification) obj).e);
            return true;
        } else if (obj instanceof DisposableNotification) {
            mVar.d(((DisposableNotification) obj).d);
            return false;
        } else {
            mVar.e(obj);
            return false;
        }
    }
}
