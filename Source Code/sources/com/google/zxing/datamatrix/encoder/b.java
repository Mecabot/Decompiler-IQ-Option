package com.google.zxing.datamatrix.encoder;

import android.support.v4.view.InputDeviceCompat;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;

/* compiled from: Base256Encoder */
final class b implements g {
    public int yG() {
        return 5;
    }

    b() {
    }

    public void a(h hVar) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        stringBuilder.append(0);
        while (hVar.yN()) {
            stringBuilder.append(hVar.getCurrentChar());
            hVar.pos++;
            if (j.c(hVar.getMessage(), hVar.pos, yG()) != yG()) {
                hVar.cd(0);
                break;
            }
        }
        int length = stringBuilder.length() - 1;
        int yK = (hVar.yK() + length) + 1;
        hVar.ce(yK);
        Object obj = hVar.yQ().yZ() - yK > 0 ? 1 : null;
        if (hVar.yN() || obj != null) {
            if (length <= 249) {
                stringBuilder.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                stringBuilder.setCharAt(0, (char) ((length / Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + 249));
                stringBuilder.insert(1, (char) (length % Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
            } else {
                stringBuilder = new StringBuilder("Message length not in valid ranges: ");
                stringBuilder.append(length);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        length = stringBuilder.length();
        while (i < length) {
            hVar.m(a(stringBuilder.charAt(i), hVar.yK() + 1));
            i++;
        }
    }

    private static char a(char c, int i) {
        int i2 = c + (((i * 149) % 255) + 1);
        return i2 <= 255 ? (char) i2 : (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }
}
