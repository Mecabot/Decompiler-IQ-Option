package com.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import com.airbnb.lottie.model.content.j;
import java.util.List;

@RestrictTo({Scope.LIBRARY})
/* compiled from: FontCharacter */
public class d {
    private final char character;
    private final double me;
    private final String ml;
    private final List<j> mm;
    private final String mn;
    private final double width;

    public static int a(char c, String str, String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public d(List<j> list, char c, double d, double d2, String str, String str2) {
        this.mm = list;
        this.character = c;
        this.me = d;
        this.width = d2;
        this.ml = str;
        this.mn = str2;
    }

    public List<j> dT() {
        return this.mm;
    }

    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        return a(this.character, this.mn, this.ml);
    }
}
