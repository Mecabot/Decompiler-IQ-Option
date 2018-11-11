package com.iqoption.g;

import android.util.Pair;
import com.google.common.util.concurrent.s;
import com.iqoption.core.connect.g;
import com.iqoption.core.connect.n;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.service.websocket.a.b;
import io.reactivex.e;
import java.util.Set;

/* compiled from: IqSocket */
public interface a extends g {
    e<Boolean> DH();

    e<n> aDA();

    s<Void> aDv();

    String aDz();

    void aiM();

    s<Void> bE(Object obj);

    boolean c(b bVar);

    void g(Set<Pair<Integer, Integer>> set);

    void h(Set<Pair<Integer, InstrumentType>> set);

    boolean isAuthorized();

    boolean jF(String str);

    boolean m(Object obj, int i);
}
