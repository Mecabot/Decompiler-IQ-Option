package com.google.common.collect;

/* compiled from: Hashing */
final class r {
    static int aO(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * -862048943), 15)) * 461845907);
    }

    static int ac(Object obj) {
        return aO(obj == null ? 0 : obj.hashCode());
    }

    static int a(int i, double d) {
        i = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(i);
        if (i <= ((int) (d * ((double) highestOneBit)))) {
            return highestOneBit;
        }
        i = highestOneBit << 1;
        if (i <= 0) {
            i = 1073741824;
        }
        return i;
    }
}
