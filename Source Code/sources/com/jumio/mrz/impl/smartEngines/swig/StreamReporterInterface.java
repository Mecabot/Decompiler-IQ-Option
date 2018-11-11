package com.jumio.mrz.impl.smartEngines.swig;

public class StreamReporterInterface {
    private long a;
    protected boolean swigCMemOwn;

    protected StreamReporterInterface(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(StreamReporterInterface streamReporterInterface) {
        return streamReporterInterface == null ? 0 : streamReporterInterface.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_StreamReporterInterface(this.a);
            }
            this.a = 0;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        mrzjniInterfaceJNI.StreamReporterInterface_change_ownership(this, this.a, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        mrzjniInterfaceJNI.StreamReporterInterface_change_ownership(this, this.a, true);
    }

    public void SymbolRectsFound(MrzRectMatrix mrzRectMatrix) {
        if (getClass() == StreamReporterInterface.class) {
            mrzjniInterfaceJNI.StreamReporterInterface_SymbolRectsFound(this.a, this, MrzRectMatrix.getCPtr(mrzRectMatrix), mrzRectMatrix);
            return;
        }
        mrzjniInterfaceJNI.StreamReporterInterface_SymbolRectsFoundSwigExplicitStreamReporterInterface(this.a, this, MrzRectMatrix.getCPtr(mrzRectMatrix), mrzRectMatrix);
    }

    public void SymbolRectsFoundAfterSnapshotProcessed(MrzRectMatrix mrzRectMatrix) {
        if (getClass() == StreamReporterInterface.class) {
            mrzjniInterfaceJNI.StreamReporterInterface_SymbolRectsFoundAfterSnapshotProcessed(this.a, this, MrzRectMatrix.getCPtr(mrzRectMatrix), mrzRectMatrix);
            return;
        }
        mrzjniInterfaceJNI.StreamReporterInterface_SymbolRectsFoundAfterSnapshotProcessedSwigExplicitStreamReporterInterface(this.a, this, MrzRectMatrix.getCPtr(mrzRectMatrix), mrzRectMatrix);
    }

    public void SnapshotRejected() {
        if (getClass() == StreamReporterInterface.class) {
            mrzjniInterfaceJNI.StreamReporterInterface_SnapshotRejected__SWIG_0(this.a, this);
        } else {
            mrzjniInterfaceJNI.StreamReporterInterface_SnapshotRejectedSwigExplicitStreamReporterInterface__SWIG_0(this.a, this);
        }
    }

    public void SnapshotRejected(String str) {
        if (getClass() == StreamReporterInterface.class) {
            mrzjniInterfaceJNI.StreamReporterInterface_SnapshotRejected__SWIG_1(this.a, this, str);
        } else {
            mrzjniInterfaceJNI.StreamReporterInterface_SnapshotRejectedSwigExplicitStreamReporterInterface__SWIG_1(this.a, this, str);
        }
    }

    public void SnapshotProcessed(MrzResult mrzResult, boolean z) {
        mrzjniInterfaceJNI.StreamReporterInterface_SnapshotProcessed(this.a, this, MrzResult.getCPtr(mrzResult), mrzResult, z);
    }

    public StreamReporterInterface() {
        this(mrzjniInterfaceJNI.new_StreamReporterInterface(), true);
        mrzjniInterfaceJNI.StreamReporterInterface_director_connect(this, this.a, this.swigCMemOwn, true);
    }
}
