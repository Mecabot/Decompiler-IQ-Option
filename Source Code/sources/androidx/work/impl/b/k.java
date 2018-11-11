package androidx.work.impl.b;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import androidx.work.Data;
import androidx.work.State;
import androidx.work.impl.b.j.a;
import androidx.work.impl.b.j.b;
import java.util.List;

/* compiled from: WorkSpecDao */
public interface k {
    j M(String str);

    List<a> N(String str);

    int O(String str);

    int P(String str);

    State Q(String str);

    List<Data> R(String str);

    List<String> S(@NonNull String str);

    int a(State state, String... strArr);

    void a(String str, Data data);

    void b(String str, long j);

    int c(@NonNull String str, long j);

    List<String> cw();

    int cx();

    void delete(String str);

    void k(j jVar);

    List<j> l(int i);

    LiveData<List<b>> n(List<String> list);
}
