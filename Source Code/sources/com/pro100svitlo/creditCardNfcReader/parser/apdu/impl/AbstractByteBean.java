package com.pro100svitlo.creditCardNfcReader.parser.apdu.impl;

import com.pro100svitlo.creditCardNfcReader.iso7816emv.e;
import com.pro100svitlo.creditCardNfcReader.model.AbstractData;
import com.pro100svitlo.creditCardNfcReader.parser.apdu.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.slf4j.b;
import org.slf4j.c;

public abstract class AbstractByteBean<T> extends AbstractData implements a {
    private static final b egK = c.nJ(AbstractByteBean.class.getName());
    private static final long serialVersionUID = -2016039522844322383L;

    private Collection<com.pro100svitlo.creditCardNfcReader.parser.apdu.a.a> bL(List<e> list) {
        if (list == null) {
            return (Collection) com.pro100svitlo.creditCardNfcReader.parser.apdu.a.b.aSd().aSf().get(getClass().getName());
        }
        Map map = (Map) com.pro100svitlo.creditCardNfcReader.parser.apdu.a.b.aSd().aSg().get(getClass().getName());
        Collection<com.pro100svitlo.creditCardNfcReader.parser.apdu.a.a> arrayList = new ArrayList(map.size());
        for (e eVar : list) {
            Object obj = (com.pro100svitlo.creditCardNfcReader.parser.apdu.a.a) map.get(eVar.aRJ());
            if (obj != null) {
                obj.setSize(eVar.getLength() * 8);
            } else {
                obj = new com.pro100svitlo.creditCardNfcReader.parser.apdu.a.a();
                obj.gd(true);
                obj.setSize(eVar.getLength() * 8);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public void a(byte[] bArr, List<e> list) {
        Collection<com.pro100svitlo.creditCardNfcReader.parser.apdu.a.a> bL = bL(list);
        b.a.a.a aVar = new b.a.a.a(bArr);
        for (com.pro100svitlo.creditCardNfcReader.parser.apdu.a.a aVar2 : bL) {
            if (aVar2.aSc()) {
                aVar.iG(aVar2.getSize());
            } else {
                a(aVar2.getField(), this, a.c(aVar2, aVar));
            }
        }
    }

    protected void a(Field field, a aVar, Object obj) {
        if (field != null) {
            try {
                field.set(aVar, obj);
            } catch (Throwable e) {
                egK.error("Parameters of fied.set are not valid", e);
            } catch (Throwable e2) {
                b bVar = egK;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Impossible to set the Field :");
                stringBuilder.append(field.getName());
                bVar.error(stringBuilder.toString(), e2);
            }
        }
    }
}
