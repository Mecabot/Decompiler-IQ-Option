package android.support.v7.widget;

import java.util.List;

class OpReorderer {
    final Callback mCallback;

    interface Callback {
        UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj);

        void recycleUpdateOp(UpdateOp updateOp);
    }

    OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    void reorderOps(List<UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder != -1) {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            } else {
                return;
            }
        }
    }

    private void swapMoveOp(List<UpdateOp> list, int i, int i2) {
        UpdateOp updateOp = (UpdateOp) list.get(i);
        UpdateOp updateOp2 = (UpdateOp) list.get(i2);
        int i3 = updateOp2.cmd;
        if (i3 != 4) {
            switch (i3) {
                case 1:
                    swapMoveAdd(list, i, updateOp, i2, updateOp2);
                    return;
                case 2:
                    swapMoveRemove(list, i, updateOp, i2, updateOp2);
                    return;
                default:
                    return;
            }
        }
        swapMoveUpdate(list, i, updateOp, i2, updateOp2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0097  */
    void swapMoveRemove(java.util.List<android.support.v7.widget.AdapterHelper.UpdateOp> r9, int r10, android.support.v7.widget.AdapterHelper.UpdateOp r11, int r12, android.support.v7.widget.AdapterHelper.UpdateOp r13) {
        /*
        r8 = this;
        r0 = r11.positionStart;
        r1 = r11.itemCount;
        r2 = 0;
        r3 = 1;
        if (r0 >= r1) goto L_0x001c;
    L_0x0008:
        r0 = r13.positionStart;
        r1 = r11.positionStart;
        if (r0 != r1) goto L_0x001a;
    L_0x000e:
        r0 = r13.itemCount;
        r1 = r11.itemCount;
        r4 = r11.positionStart;
        r1 = r1 - r4;
        if (r0 != r1) goto L_0x001a;
    L_0x0017:
        r0 = 0;
    L_0x0018:
        r2 = 1;
        goto L_0x002f;
    L_0x001a:
        r0 = 0;
        goto L_0x002f;
    L_0x001c:
        r0 = r13.positionStart;
        r1 = r11.itemCount;
        r1 = r1 + r3;
        if (r0 != r1) goto L_0x002e;
    L_0x0023:
        r0 = r13.itemCount;
        r1 = r11.positionStart;
        r4 = r11.itemCount;
        r1 = r1 - r4;
        if (r0 != r1) goto L_0x002e;
    L_0x002c:
        r0 = 1;
        goto L_0x0018;
    L_0x002e:
        r0 = 1;
    L_0x002f:
        r1 = r11.itemCount;
        r4 = r13.positionStart;
        r5 = 2;
        if (r1 >= r4) goto L_0x003c;
    L_0x0036:
        r1 = r13.positionStart;
        r1 = r1 - r3;
        r13.positionStart = r1;
        goto L_0x005b;
    L_0x003c:
        r1 = r11.itemCount;
        r4 = r13.positionStart;
        r6 = r13.itemCount;
        r4 = r4 + r6;
        if (r1 >= r4) goto L_0x005b;
    L_0x0045:
        r10 = r13.itemCount;
        r10 = r10 - r3;
        r13.itemCount = r10;
        r11.cmd = r5;
        r11.itemCount = r3;
        r10 = r13.itemCount;
        if (r10 != 0) goto L_0x005a;
    L_0x0052:
        r9.remove(r12);
        r9 = r8.mCallback;
        r9.recycleUpdateOp(r13);
    L_0x005a:
        return;
    L_0x005b:
        r1 = r11.positionStart;
        r4 = r13.positionStart;
        r6 = 0;
        if (r1 > r4) goto L_0x0068;
    L_0x0062:
        r1 = r13.positionStart;
        r1 = r1 + r3;
        r13.positionStart = r1;
        goto L_0x0089;
    L_0x0068:
        r1 = r11.positionStart;
        r4 = r13.positionStart;
        r7 = r13.itemCount;
        r4 = r4 + r7;
        if (r1 >= r4) goto L_0x0089;
    L_0x0071:
        r1 = r13.positionStart;
        r4 = r13.itemCount;
        r1 = r1 + r4;
        r4 = r11.positionStart;
        r1 = r1 - r4;
        r4 = r8.mCallback;
        r7 = r11.positionStart;
        r7 = r7 + r3;
        r6 = r4.obtainUpdateOp(r5, r7, r1, r6);
        r1 = r11.positionStart;
        r3 = r13.positionStart;
        r1 = r1 - r3;
        r13.itemCount = r1;
    L_0x0089:
        if (r2 == 0) goto L_0x0097;
    L_0x008b:
        r9.set(r10, r13);
        r9.remove(r12);
        r9 = r8.mCallback;
        r9.recycleUpdateOp(r11);
        return;
    L_0x0097:
        if (r0 == 0) goto L_0x00d0;
    L_0x0099:
        if (r6 == 0) goto L_0x00b5;
    L_0x009b:
        r0 = r11.positionStart;
        r1 = r6.positionStart;
        if (r0 <= r1) goto L_0x00a8;
    L_0x00a1:
        r0 = r11.positionStart;
        r1 = r6.itemCount;
        r0 = r0 - r1;
        r11.positionStart = r0;
    L_0x00a8:
        r0 = r11.itemCount;
        r1 = r6.positionStart;
        if (r0 <= r1) goto L_0x00b5;
    L_0x00ae:
        r0 = r11.itemCount;
        r1 = r6.itemCount;
        r0 = r0 - r1;
        r11.itemCount = r0;
    L_0x00b5:
        r0 = r11.positionStart;
        r1 = r13.positionStart;
        if (r0 <= r1) goto L_0x00c2;
    L_0x00bb:
        r0 = r11.positionStart;
        r1 = r13.itemCount;
        r0 = r0 - r1;
        r11.positionStart = r0;
    L_0x00c2:
        r0 = r11.itemCount;
        r1 = r13.positionStart;
        if (r0 <= r1) goto L_0x0106;
    L_0x00c8:
        r0 = r11.itemCount;
        r1 = r13.itemCount;
        r0 = r0 - r1;
        r11.itemCount = r0;
        goto L_0x0106;
    L_0x00d0:
        if (r6 == 0) goto L_0x00ec;
    L_0x00d2:
        r0 = r11.positionStart;
        r1 = r6.positionStart;
        if (r0 < r1) goto L_0x00df;
    L_0x00d8:
        r0 = r11.positionStart;
        r1 = r6.itemCount;
        r0 = r0 - r1;
        r11.positionStart = r0;
    L_0x00df:
        r0 = r11.itemCount;
        r1 = r6.positionStart;
        if (r0 < r1) goto L_0x00ec;
    L_0x00e5:
        r0 = r11.itemCount;
        r1 = r6.itemCount;
        r0 = r0 - r1;
        r11.itemCount = r0;
    L_0x00ec:
        r0 = r11.positionStart;
        r1 = r13.positionStart;
        if (r0 < r1) goto L_0x00f9;
    L_0x00f2:
        r0 = r11.positionStart;
        r1 = r13.itemCount;
        r0 = r0 - r1;
        r11.positionStart = r0;
    L_0x00f9:
        r0 = r11.itemCount;
        r1 = r13.positionStart;
        if (r0 < r1) goto L_0x0106;
    L_0x00ff:
        r0 = r11.itemCount;
        r1 = r13.itemCount;
        r0 = r0 - r1;
        r11.itemCount = r0;
    L_0x0106:
        r9.set(r10, r13);
        r13 = r11.positionStart;
        r0 = r11.itemCount;
        if (r13 == r0) goto L_0x0113;
    L_0x010f:
        r9.set(r12, r11);
        goto L_0x0116;
    L_0x0113:
        r9.remove(r12);
    L_0x0116:
        if (r6 == 0) goto L_0x011b;
    L_0x0118:
        r9.add(r10, r6);
    L_0x011b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.OpReorderer.swapMoveRemove(java.util.List, int, android.support.v7.widget.AdapterHelper$UpdateOp, int, android.support.v7.widget.AdapterHelper$UpdateOp):void");
    }

    private void swapMoveAdd(List<UpdateOp> list, int i, UpdateOp updateOp, int i2, UpdateOp updateOp2) {
        int i3 = updateOp.itemCount < updateOp2.positionStart ? -1 : 0;
        if (updateOp.positionStart < updateOp2.positionStart) {
            i3++;
        }
        if (updateOp2.positionStart <= updateOp.positionStart) {
            updateOp.positionStart += updateOp2.itemCount;
        }
        if (updateOp2.positionStart <= updateOp.itemCount) {
            updateOp.itemCount += updateOp2.itemCount;
        }
        updateOp2.positionStart += i3;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    void swapMoveUpdate(java.util.List<android.support.v7.widget.AdapterHelper.UpdateOp> r8, int r9, android.support.v7.widget.AdapterHelper.UpdateOp r10, int r11, android.support.v7.widget.AdapterHelper.UpdateOp r12) {
        /*
        r7 = this;
        r0 = r10.itemCount;
        r1 = r12.positionStart;
        r2 = 4;
        r3 = 0;
        r4 = 1;
        if (r0 >= r1) goto L_0x000f;
    L_0x0009:
        r0 = r12.positionStart;
        r0 = r0 - r4;
        r12.positionStart = r0;
        goto L_0x0028;
    L_0x000f:
        r0 = r10.itemCount;
        r1 = r12.positionStart;
        r5 = r12.itemCount;
        r1 = r1 + r5;
        if (r0 >= r1) goto L_0x0028;
    L_0x0018:
        r0 = r12.itemCount;
        r0 = r0 - r4;
        r12.itemCount = r0;
        r0 = r7.mCallback;
        r1 = r10.positionStart;
        r5 = r12.payload;
        r0 = r0.obtainUpdateOp(r2, r1, r4, r5);
        goto L_0x0029;
    L_0x0028:
        r0 = r3;
    L_0x0029:
        r1 = r10.positionStart;
        r5 = r12.positionStart;
        if (r1 > r5) goto L_0x0035;
    L_0x002f:
        r1 = r12.positionStart;
        r1 = r1 + r4;
        r12.positionStart = r1;
        goto L_0x0056;
    L_0x0035:
        r1 = r10.positionStart;
        r5 = r12.positionStart;
        r6 = r12.itemCount;
        r5 = r5 + r6;
        if (r1 >= r5) goto L_0x0056;
    L_0x003e:
        r1 = r12.positionStart;
        r3 = r12.itemCount;
        r1 = r1 + r3;
        r3 = r10.positionStart;
        r1 = r1 - r3;
        r3 = r7.mCallback;
        r5 = r10.positionStart;
        r5 = r5 + r4;
        r4 = r12.payload;
        r3 = r3.obtainUpdateOp(r2, r5, r1, r4);
        r2 = r12.itemCount;
        r2 = r2 - r1;
        r12.itemCount = r2;
    L_0x0056:
        r8.set(r11, r10);
        r10 = r12.itemCount;
        if (r10 <= 0) goto L_0x0061;
    L_0x005d:
        r8.set(r9, r12);
        goto L_0x0069;
    L_0x0061:
        r8.remove(r9);
        r10 = r7.mCallback;
        r10.recycleUpdateOp(r12);
    L_0x0069:
        if (r0 == 0) goto L_0x006e;
    L_0x006b:
        r8.add(r9, r0);
    L_0x006e:
        if (r3 == 0) goto L_0x0073;
    L_0x0070:
        r8.add(r9, r3);
    L_0x0073:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.OpReorderer.swapMoveUpdate(java.util.List, int, android.support.v7.widget.AdapterHelper$UpdateOp, int, android.support.v7.widget.AdapterHelper$UpdateOp):void");
    }

    private int getLastMoveOutOfOrder(List<UpdateOp> list) {
        Object obj = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((UpdateOp) list.get(size)).cmd != 8) {
                obj = 1;
            } else if (obj != null) {
                return size;
            }
        }
        return -1;
    }
}
