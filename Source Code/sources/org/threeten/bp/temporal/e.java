package org.threeten.bp.temporal;

/* compiled from: TemporalField */
public interface e {
    <R extends a> R adjustInto(R r, long j);

    long getFrom(b bVar);

    boolean isDateBased();

    boolean isSupportedBy(b bVar);

    boolean isTimeBased();

    ValueRange range();

    ValueRange rangeRefinedBy(b bVar);
}
