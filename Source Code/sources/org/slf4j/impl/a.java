package org.slf4j.impl;

import com.noveogroup.android.log.c;
import org.slf4j.b;

/* compiled from: AndroidLoggerFactory */
public class a implements org.slf4j.a {
    public b nJ(String str) {
        return new AndroidLoggerAdapter(c.lb(str));
    }
}
