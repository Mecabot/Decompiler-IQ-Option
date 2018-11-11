package com.pro100svitlo.creditCardNfcReader.model;

import b.a.a.a;
import com.pro100svitlo.creditCardNfcReader.model.enums.ServiceCode1Enum;
import com.pro100svitlo.creditCardNfcReader.model.enums.ServiceCode2Enum;
import com.pro100svitlo.creditCardNfcReader.model.enums.ServiceCode3Enum;
import org.apache.commons.lang3.c;

public class Service extends AbstractData {
    private static final long serialVersionUID = 5154895810563519768L;
    private ServiceCode1Enum serviceCode1;
    private ServiceCode2Enum serviceCode2;
    private ServiceCode3Enum serviceCode3;

    public Service(String str) {
        if (str != null && str.length() == 3) {
            a aVar = new a(com.pro100svitlo.creditCardNfcReader.a.a.lj(c.f(str, 4, "0")));
            this.serviceCode1 = (ServiceCode1Enum) com.pro100svitlo.creditCardNfcReader.a.c.a(aVar.iJ(4), ServiceCode1Enum.class);
            this.serviceCode2 = (ServiceCode2Enum) com.pro100svitlo.creditCardNfcReader.a.c.a(aVar.iJ(4), ServiceCode2Enum.class);
            this.serviceCode3 = (ServiceCode3Enum) com.pro100svitlo.creditCardNfcReader.a.c.a(aVar.iJ(4), ServiceCode3Enum.class);
        }
    }
}
