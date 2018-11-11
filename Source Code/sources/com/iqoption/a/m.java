package com.iqoption.a;

import android.arch.core.util.Function;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: IndexedFilter */
public class m<T, I> extends Filter {
    private final ImmutableList<T> ahk;
    private final b ahl;
    private final d<T, I> ahm;
    private final c<T, I> ahn;
    private I aho;
    private Bundle args = new Bundle();

    /* compiled from: IndexedFilter */
    public static final class a<T, I> {
        private final ImmutableList<T> ahk;
        private b<T> ahl;
        private d<T, I> ahm;
        private c<T, I> ahn;

        private a(ImmutableList<T> immutableList) {
            this.ahk = immutableList;
        }

        public a<T, I> a(b<T> bVar) {
            this.ahl = bVar;
            return this;
        }

        public a<T, I> a(d<T, I> dVar) {
            this.ahm = dVar;
            return this;
        }

        public a<T, I> a(c<T, I> cVar) {
            this.ahn = cVar;
            return this;
        }

        public m<T, I> AW() {
            return new m(this);
        }
    }

    /* compiled from: IndexedFilter */
    public interface b<T> {
        void a(CharSequence charSequence, ImmutableList<T> immutableList);
    }

    /* compiled from: IndexedFilter */
    public interface c<T, I> {
        ImmutableList<T> a(I i, CharSequence charSequence);
    }

    /* compiled from: IndexedFilter */
    public interface d<T, I> {
        I a(ImmutableList<T> immutableList);
    }

    public static <T, I> a<T, I> w(@NonNull Collection<T> collection) {
        return new a(ImmutableList.m(collection));
    }

    public static <T> Map<Character, List<T>> a(List<T> list, Function<T, String> function) {
        Map<Character, List<T>> us = Maps.us();
        for (Object next : list) {
            for (String charAt : ((String) function.apply(next)).split(" ")) {
                Character valueOf = Character.valueOf(Character.toLowerCase(charAt.charAt(0)));
                List list2 = (List) us.get(valueOf);
                if (list2 == null) {
                    list2 = Lists.tM();
                    us.put(valueOf, list2);
                }
                if (!list2.contains(next)) {
                    list2.add(next);
                }
            }
        }
        us.put(null, list);
        return us;
    }

    public m(@NonNull a<T, I> aVar) {
        this.ahk = aVar.ahk;
        this.ahl = aVar.ahl;
        this.ahm = aVar.ahm;
        this.ahn = aVar.ahn;
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        ImmutableList dT = dT(i(charSequence));
        FilterResults filterResults = new FilterResults();
        filterResults.values = dT;
        filterResults.count = dT.size();
        return filterResults;
    }

    private ImmutableList<T> dT(String str) {
        if (this.aho == null) {
            this.aho = this.ahm.a(ImmutableList.m(this.ahk));
        }
        return this.ahn.a(this.aho, str);
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        this.ahl.a(i(charSequence), (ImmutableList) filterResults.values);
    }

    private static String i(CharSequence charSequence) {
        return charSequence != null ? charSequence.toString() : "";
    }
}
