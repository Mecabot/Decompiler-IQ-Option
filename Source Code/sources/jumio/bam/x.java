package jumio.bam;

import android.app.Activity;
import com.jumio.bam.enums.CreditCardType;
import com.jumio.commons.PersistWith;
import com.jumio.core.mvp.model.StaticModel;
import java.util.ArrayList;

@PersistWith("BamSettingsModel")
/* compiled from: BamSettingsModel */
public class x implements StaticModel {
    private transient Activity a;
    private boolean b = true;
    private boolean c = false;
    private boolean d = true;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean i = true;
    private boolean j = false;
    private int k = -1;
    private String l = "";
    private boolean m = false;
    private ArrayList<CreditCardType> n;
    private ArrayList<ac> o;

    public boolean a() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean b() {
        return this.c;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public boolean c() {
        return this.d;
    }

    public void c(boolean z) {
        this.d = z;
    }

    public boolean d() {
        return this.e;
    }

    public void d(boolean z) {
        this.e = z;
    }

    public boolean e() {
        return this.f;
    }

    public void e(boolean z) {
        this.f = z;
    }

    public boolean f() {
        return this.g;
    }

    public void f(boolean z) {
        this.g = z;
    }

    public boolean g() {
        return this.h;
    }

    public void g(boolean z) {
        this.h = z;
    }

    public boolean h() {
        return this.i;
    }

    public void h(boolean z) {
        this.i = z;
    }

    public boolean i() {
        return this.j;
    }

    public void i(boolean z) {
        this.j = z;
    }

    public int j() {
        return this.k;
    }

    public void a(int i) {
        this.k = i;
    }

    public String k() {
        return this.l;
    }

    public void a(String str) {
        this.l = str;
    }

    public boolean l() {
        return this.m;
    }

    public void j(boolean z) {
        this.m = z;
    }

    public ArrayList<CreditCardType> m() {
        return this.n;
    }

    public void a(ArrayList<CreditCardType> arrayList) {
        this.n = arrayList;
    }

    public ArrayList<ac> n() {
        return this.o;
    }

    public void b(ArrayList<ac> arrayList) {
        this.o = arrayList;
    }

    public void a(Activity activity) {
        this.a = activity;
    }
}
