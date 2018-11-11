package com.jumio.clientlib.impl.templatematcher;

public class Uint8Array {
    private transient long a;
    protected transient boolean swigCMemOwn;

    protected Uint8Array(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(Uint8Array uint8Array) {
        return uint8Array == null ? 0 : uint8Array.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniTemplateMatcherJNI.delete_Uint8Array(this.a);
            }
            this.a = 0;
        }
    }

    public Uint8Array(int i) {
        this(jniTemplateMatcherJNI.new_Uint8Array(i), true);
    }

    public short getitem(int i) {
        return jniTemplateMatcherJNI.Uint8Array_getitem(this.a, this, i);
    }

    public void setitem(int i, short s) {
        jniTemplateMatcherJNI.Uint8Array_setitem(this.a, this, i, s);
    }

    public SWIGTYPE_p_unsigned_char cast() {
        long Uint8Array_cast = jniTemplateMatcherJNI.Uint8Array_cast(this.a, this);
        if (Uint8Array_cast == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(Uint8Array_cast, false);
    }

    public static Uint8Array frompointer(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char) {
        long Uint8Array_frompointer = jniTemplateMatcherJNI.Uint8Array_frompointer(SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char));
        if (Uint8Array_frompointer == 0) {
            return null;
        }
        return new Uint8Array(Uint8Array_frompointer, false);
    }
}
