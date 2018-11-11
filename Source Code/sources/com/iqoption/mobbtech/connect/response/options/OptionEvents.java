package com.iqoption.mobbtech.connect.response.options;

import android.util.Pair;
import com.google.common.collect.ImmutableList;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.dto.entity.position.Position;

public interface OptionEvents {
    public static final String TAG = "com.iqoption.mobbtech.connect.response.options.OptionEvents";

    public enum TYPE_REMOVE_GROUP {
        EXPIRED,
        SELL,
        HOVERING
    }

    public static class b {
        public b() {
            com.iqoption.core.i.v(OptionEvents.TAG, "ClosedOptionGroupsClear");
        }
    }

    public static class c {
    }

    public interface l {
    }

    public static class q {
    }

    public static class a implements OptionEvents {
        public ImmutableList<a> cWB;
        public final a cWC;
        public final Long cWD;

        public a(ImmutableList<a> immutableList, a aVar, Long l) {
            this.cWB = immutableList;
            this.cWC = aVar;
            this.cWD = l;
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ClosedOptionGroupOptionAdded ");
            stringBuilder.append(l);
            com.iqoption.core.i.v(str, stringBuilder.toString());
        }

        public boolean a(ImmutableList<a> immutableList, ImmutableList<b> immutableList2) {
            this.cWB = immutableList;
            int indexOf = immutableList.indexOf(this.cWC);
            return indexOf != -1 ? ((a) immutableList.get(indexOf)).A(this.cWD) : false;
        }
    }

    public static class h implements OptionEvents, l {
        public ImmutableList<b> cWE;
        public final b cWF;

        public h(ImmutableList<b> immutableList, b bVar) {
            this.cWE = immutableList;
            this.cWF = bVar;
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NewOpenOptionGroup ");
            stringBuilder.append(bVar);
            com.iqoption.core.i.v(str, stringBuilder.toString());
        }

        public boolean a(ImmutableList<a> immutableList, ImmutableList<b> immutableList2) {
            this.cWE = immutableList2;
            return immutableList2.contains(this.cWF);
        }
    }

    public static class i implements OptionEvents {
        public ImmutableList<b> cWE;
        public b cWG;
        public final e cWH;

        public i(ImmutableList<b> immutableList, b bVar, e eVar) {
            this.cWE = immutableList;
            this.cWG = bVar;
            this.cWH = eVar;
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OpenOptionGroupOptionAdded ");
            stringBuilder.append(bVar);
            com.iqoption.core.i.v(str, stringBuilder.toString());
        }

        public boolean a(ImmutableList<a> immutableList, ImmutableList<b> immutableList2) {
            this.cWE = immutableList2;
            int indexOf = immutableList2.indexOf(this.cWG);
            if (indexOf == -1) {
                return false;
            }
            this.cWG = (b) immutableList2.get(indexOf);
            return this.cWG.avh().contains(this.cWH);
        }
    }

    public static class j implements OptionEvents, l {
        public ImmutableList<b> cWE;
        public final b cWI;
        public final e cWJ;

        public j(ImmutableList<b> immutableList, b bVar, e eVar) {
            this.cWE = immutableList;
            this.cWI = bVar;
            this.cWJ = eVar;
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OpenOptionGroupOptionRemoved ");
            stringBuilder.append(eVar);
            com.iqoption.core.i.v(str, stringBuilder.toString());
        }

        public boolean equals(Object obj) {
            return this == obj || ((obj instanceof j) && com.google.common.base.f.equal(this.cWJ, ((j) obj).cWJ));
        }

        public int hashCode() {
            return com.google.common.base.f.hashCode(this.cWJ);
        }

        public boolean a(ImmutableList<a> immutableList, ImmutableList<b> immutableList2) {
            this.cWE = immutableList2;
            return immutableList2.contains(this.cWI);
        }
    }

    public static class k implements OptionEvents, l {
        public ImmutableList<b> cWE;
        public final b cWK;
        public final TYPE_REMOVE_GROUP cWL;

        public k(ImmutableList<b> immutableList, b bVar, TYPE_REMOVE_GROUP type_remove_group) {
            this.cWE = immutableList;
            this.cWK = bVar;
            this.cWL = type_remove_group;
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OpenOptionGroupRemoved ");
            stringBuilder.append(bVar);
            com.iqoption.core.i.v(str, stringBuilder.toString());
        }

        public boolean a(ImmutableList<a> immutableList, ImmutableList<b> immutableList2) {
            this.cWE = immutableList2;
            return true;
        }
    }

    public static class m implements l {
        public m() {
            com.iqoption.core.i.v(OptionEvents.TAG, "OpenOptionGroupsClear");
        }
    }

    public static class d extends com.iqoption.system.a.c<Order> {
    }

    public static class e extends com.iqoption.system.a.c<Order> {
    }

    public static class f extends com.iqoption.system.a.c<Order> {
        public f(Order order) {
            setValue(order);
        }
    }

    public static class g extends com.iqoption.system.a.c<Pair<ImmutableList<a>, a>> implements OptionEvents {
        public g() {
            com.iqoption.core.i.v(TAG, "NewClosedOptionGroup");
        }

        public boolean a(ImmutableList<a> immutableList, ImmutableList<b> immutableList2) {
            if (!immutableList.contains(((Pair) getValue()).second)) {
                return false;
            }
            setValue(Pair.create(immutableList, ((Pair) getValue()).second));
            return true;
        }
    }

    public static class n extends com.iqoption.system.a.c<Position> implements OptionEvents {
        public boolean a(ImmutableList<a> immutableList, ImmutableList<b> immutableList2) {
            return true;
        }

        public n(Position position) {
            setValue(position);
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PositionClosed: id:");
            stringBuilder.append(position.getId());
            stringBuilder.append(" type: ");
            stringBuilder.append(position);
            com.iqoption.core.i.v(str, stringBuilder.toString());
        }
    }

    public static class o extends com.iqoption.system.a.c<Pair<ImmutableList<a>, a>> implements OptionEvents {
        public o() {
            com.iqoption.core.i.v(TAG, "ReplaceClosedOptionGroup");
        }

        public boolean a(ImmutableList<a> immutableList, ImmutableList<b> immutableList2) {
            if (!immutableList.contains(((Pair) getValue()).second)) {
                return false;
            }
            setValue(Pair.create(immutableList, ((Pair) getValue()).second));
            return true;
        }
    }

    public static class p extends com.iqoption.system.a.c<Boolean> implements OptionEvents {
        public boolean a(ImmutableList<a> immutableList, ImmutableList<b> immutableList2) {
            return true;
        }
    }

    boolean a(ImmutableList<a> immutableList, ImmutableList<b> immutableList2);
}
