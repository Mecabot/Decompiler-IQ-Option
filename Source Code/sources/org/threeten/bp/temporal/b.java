package org.threeten.bp.temporal;

/* compiled from: TemporalAccessor */
public interface b {
    int get(e eVar);

    long getLong(e eVar);

    boolean isSupported(e eVar);

    <R> R query(g<R> gVar);

    ValueRange range(e eVar);
}
