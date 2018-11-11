package com.pro100svitlo.creditCardNfcReader.parser.apdu.a;

import com.pro100svitlo.creditCardNfcReader.iso7816emv.ITag;
import com.pro100svitlo.creditCardNfcReader.iso7816emv.b;
import java.lang.reflect.Field;

/* compiled from: AnnotationData */
public class a implements Cloneable, Comparable<a> {
    private boolean aGw;
    private String aZP;
    private boolean egQ;
    private int egR;
    private ITag egx;
    private Field field;
    private int index;
    private int size;

    /* renamed from: a */
    public int compareTo(a aVar) {
        return Integer.valueOf(this.index).compareTo(Integer.valueOf(aVar.getIndex()));
    }

    public boolean equals(Object obj) {
        if ((obj instanceof a) && this.index == ((a) obj).getIndex()) {
            return true;
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean aSa() {
        return this.egQ;
    }

    public Field getField() {
        return this.field;
    }

    public int aSb() {
        return this.egR;
    }

    public String getFormat() {
        return this.aZP;
    }

    public void a(Field field) {
        this.field = field;
    }

    public ITag aRJ() {
        return this.egx;
    }

    public void a(c cVar) {
        this.egR = cVar.aSi();
        this.aZP = cVar.aSh();
        this.index = cVar.index();
        this.egQ = cVar.aSj();
        this.size = cVar.size();
        if (cVar.aSk() != null) {
            this.egx = b.J(b.a.a.b.lj(cVar.aSk()));
        }
    }

    protected Object clone() {
        a aVar = new a();
        aVar.egR = this.egR;
        aVar.field = this.field;
        aVar.aZP = new String(this.aZP);
        aVar.index = this.index;
        aVar.egQ = this.egQ;
        aVar.size = this.size;
        aVar.egx = this.egx;
        return aVar;
    }

    public boolean aSc() {
        return this.aGw;
    }

    public void gd(boolean z) {
        this.aGw = z;
    }
}
