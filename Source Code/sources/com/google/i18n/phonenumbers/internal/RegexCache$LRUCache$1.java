package com.google.i18n.phonenumbers.internal;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class RegexCache$LRUCache$1 extends LinkedHashMap<K, V> {
    final /* synthetic */ a this$0;

    RegexCache$LRUCache$1(a aVar, int i, float f, boolean z) {
        this.this$0 = aVar;
        super(i, f, z);
    }

    protected boolean removeEldestEntry(Entry<K, V> entry) {
        return size() > this.this$0.size;
    }
}
