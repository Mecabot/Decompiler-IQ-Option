package androidx.work.impl.a;

/* compiled from: NetworkState */
public class b {
    private boolean fF;
    private boolean fG;
    private boolean fH;
    private boolean fI;

    public b(boolean z, boolean z2, boolean z3, boolean z4) {
        this.fF = z;
        this.fG = z2;
        this.fH = z3;
        this.fI = z4;
    }

    public boolean isConnected() {
        return this.fF;
    }

    public boolean cc() {
        return this.fG;
    }

    public boolean cd() {
        return this.fH;
    }

    public boolean ce() {
        return this.fI;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (!(this.fF == bVar.fF && this.fG == bVar.fG && this.fH == bVar.fH && this.fI == bVar.fI)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = this.fF ? 1 : 0;
        if (this.fG) {
            i += 16;
        }
        if (this.fH) {
            i += 256;
        }
        return this.fI ? i + 4096 : i;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", new Object[]{Boolean.valueOf(this.fF), Boolean.valueOf(this.fG), Boolean.valueOf(this.fH), Boolean.valueOf(this.fI)});
    }
}
