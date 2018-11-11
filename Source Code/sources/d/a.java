package d;

/* compiled from: Client */
public class a {
    public final g fkY;
    public final d fkZ;
    public final b fla;

    public a(g gVar, d dVar, b bVar) {
        this.fkY = gVar;
        this.fkZ = dVar;
        this.fla = bVar;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (((this.fkY == null || !this.fkY.equals(aVar.fkY)) && this.fkY != aVar.fkY) || (((this.fkZ == null || !this.fkZ.equals(aVar.fkZ)) && this.fkZ != aVar.fkZ) || ((this.fla == null || !this.fla.equals(aVar.fla)) && this.fla != aVar.fla))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.fkY == null ? 0 : this.fkY.hashCode()) + (this.fkZ == null ? 0 : this.fkZ.hashCode());
        if (this.fla != null) {
            i = this.fla.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return String.format("{\"user_agent\": %s, \"os\": %s, \"device\": %s}", new Object[]{this.fkY, this.fkZ, this.fla});
    }
}
