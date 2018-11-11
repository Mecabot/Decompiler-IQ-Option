package androidx.work;

import android.net.Uri;
import android.support.annotation.NonNull;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ContentUriTriggers */
public final class c implements Iterable<a> {
    private final Set<a> dQ = new HashSet();

    /* compiled from: ContentUriTriggers */
    public static final class a {
        private final boolean dR;
        @NonNull
        private final Uri mUri;

        a(@NonNull Uri uri, boolean z) {
            this.mUri = uri;
            this.dR = z;
        }

        @NonNull
        public Uri getUri() {
            return this.mUri;
        }

        public boolean aP() {
            return this.dR;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!(this.dR == aVar.dR && this.mUri.equals(aVar.mUri))) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (this.mUri.hashCode() * 31) + this.dR;
        }
    }

    public void a(@NonNull Uri uri, boolean z) {
        this.dQ.add(new a(uri, z));
    }

    @NonNull
    public Iterator<a> iterator() {
        return this.dQ.iterator();
    }

    public int size() {
        return this.dQ.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.dQ.equals(((c) obj).dQ);
    }

    public int hashCode() {
        return this.dQ.hashCode();
    }
}
