package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: GraphRequestBatch */
public class k extends AbstractList<i> {
    private static AtomicInteger yu = new AtomicInteger();
    private List<a> cc;
    private final String id;
    private Handler yv;
    private List<i> yw;
    private int yx;
    private String yy;

    /* compiled from: GraphRequestBatch */
    public interface a {
        void a(k kVar);
    }

    /* compiled from: GraphRequestBatch */
    public interface b extends a {
        void a(k kVar, long j, long j2);
    }

    public k() {
        this.yw = new ArrayList();
        this.yx = 0;
        this.id = Integer.valueOf(yu.incrementAndGet()).toString();
        this.cc = new ArrayList();
        this.yw = new ArrayList();
    }

    public k(Collection<i> collection) {
        this.yw = new ArrayList();
        this.yx = 0;
        this.id = Integer.valueOf(yu.incrementAndGet()).toString();
        this.cc = new ArrayList();
        this.yw = new ArrayList(collection);
    }

    public k(i... iVarArr) {
        this.yw = new ArrayList();
        this.yx = 0;
        this.id = Integer.valueOf(yu.incrementAndGet()).toString();
        this.cc = new ArrayList();
        this.yw = Arrays.asList(iVarArr);
    }

    public int getTimeout() {
        return this.yx;
    }

    public void a(a aVar) {
        if (!this.cc.contains(aVar)) {
            this.cc.add(aVar);
        }
    }

    /* renamed from: c */
    public final boolean add(i iVar) {
        return this.yw.add(iVar);
    }

    /* renamed from: a */
    public final void add(int i, i iVar) {
        this.yw.add(i, iVar);
    }

    public final void clear() {
        this.yw.clear();
    }

    /* renamed from: L */
    public final i get(int i) {
        return (i) this.yw.get(i);
    }

    /* renamed from: M */
    public final i remove(int i) {
        return (i) this.yw.remove(i);
    }

    /* renamed from: b */
    public final i set(int i, i iVar) {
        return (i) this.yw.set(i, iVar);
    }

    public final int size() {
        return this.yw.size();
    }

    final String getId() {
        return this.id;
    }

    final Handler jD() {
        return this.yv;
    }

    final void a(Handler handler) {
        this.yv = handler;
    }

    final List<i> jE() {
        return this.yw;
    }

    final List<a> getCallbacks() {
        return this.cc;
    }

    public final String jF() {
        return this.yy;
    }

    public final List<l> jG() {
        return jH();
    }

    public final j jr() {
        return jI();
    }

    List<l> jH() {
        return i.c(this);
    }

    j jI() {
        return i.d(this);
    }
}
