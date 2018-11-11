package com.iqoption.util;

/* compiled from: PaysystemUtils */
public class ay {
    public static int jN(java.lang.String r4) {
        /*
        r4 = r4.toLowerCase();
        r0 = r4.hashCode();
        r1 = 0;
        switch(r0) {
            case -2026893968: goto L_0x01aa;
            case -1858389962: goto L_0x019f;
            case -1811005639: goto L_0x0194;
            case -1383481471: goto L_0x0189;
            case -1344073615: goto L_0x017e;
            case -1344073156: goto L_0x0173;
            case -1301190080: goto L_0x0168;
            case -1207741214: goto L_0x015d;
            case -1102572140: goto L_0x0152;
            case -1077672001: goto L_0x0146;
            case -1068501242: goto L_0x013b;
            case -995205389: goto L_0x012f;
            case -982669688: goto L_0x0123;
            case -900297649: goto L_0x0117;
            case -896955097: goto L_0x010a;
            case -789229186: goto L_0x00fe;
            case -715891769: goto L_0x00f1;
            case -688183224: goto L_0x00e5;
            case -188485426: goto L_0x00d9;
            case 3446716: goto L_0x00cd;
            case 3471082: goto L_0x00c2;
            case 38358441: goto L_0x00b6;
            case 94432162: goto L_0x00aa;
            case 100048981: goto L_0x009e;
            case 126718547: goto L_0x0092;
            case 178883556: goto L_0x0086;
            case 227806283: goto L_0x0079;
            case 258797699: goto L_0x006d;
            case 337489243: goto L_0x0061;
            case 681516189: goto L_0x0055;
            case 1251821346: goto L_0x0049;
            case 1296748693: goto L_0x003d;
            case 1838754222: goto L_0x0031;
            case 1874310395: goto L_0x0025;
            case 1874310403: goto L_0x0019;
            case 1886509301: goto L_0x000e;
            default: goto L_0x000c;
        };
    L_0x000c:
        goto L_0x01b5;
    L_0x000e:
        r0 = "one-tap-payment";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0016:
        r4 = 0;
        goto L_0x01b6;
    L_0x0019:
        r0 = "webmoney-wmz";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0022:
        r4 = 6;
        goto L_0x01b6;
    L_0x0025:
        r0 = "webmoney-wmr";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x002e:
        r4 = 5;
        goto L_0x01b6;
    L_0x0031:
        r0 = "neosurf";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0039:
        r4 = 31;
        goto L_0x01b6;
    L_0x003d:
        r0 = "neteller";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0045:
        r4 = 35;
        goto L_0x01b6;
    L_0x0049:
        r0 = "multibanco";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0051:
        r4 = 22;
        goto L_0x01b6;
    L_0x0055:
        r0 = "mistercash";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x005d:
        r4 = 21;
        goto L_0x01b6;
    L_0x0061:
        r0 = "lobanet";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0069:
        r4 = 20;
        goto L_0x01b6;
    L_0x006d:
        r0 = "fastbanktransfer";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0075:
        r4 = 16;
        goto L_0x01b6;
    L_0x0079:
        r0 = "toditocard";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0082:
        r4 = 29;
        goto L_0x01b6;
    L_0x0086:
        r0 = "yandex-money";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x008f:
        r4 = 7;
        goto L_0x01b6;
    L_0x0092:
        r0 = "gluepay";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x009a:
        r4 = 18;
        goto L_0x01b6;
    L_0x009e:
        r0 = "ideal";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x00a6:
        r4 = 19;
        goto L_0x01b6;
    L_0x00aa:
        r0 = "cashu";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x00b2:
        r4 = 10;
        goto L_0x01b6;
    L_0x00b6:
        r0 = "giropay";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x00be:
        r4 = 17;
        goto L_0x01b6;
    L_0x00c2:
        r0 = "qiwi";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x00ca:
        r4 = 3;
        goto L_0x01b6;
    L_0x00cd:
        r0 = "poli";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x00d5:
        r4 = 24;
        goto L_0x01b6;
    L_0x00d9:
        r0 = "euteller";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x00e1:
        r4 = 13;
        goto L_0x01b6;
    L_0x00e5:
        r0 = "przelewy";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x00ed:
        r4 = 26;
        goto L_0x01b6;
    L_0x00f1:
        r0 = "teleingreso";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x00fa:
        r4 = 28;
        goto L_0x01b6;
    L_0x00fe:
        r0 = "visa-mastercard";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0107:
        r4 = 1;
        goto L_0x01b6;
    L_0x010a:
        r0 = "sofort";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0113:
        r4 = 27;
        goto L_0x01b6;
    L_0x0117:
        r0 = "skrill";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0120:
        r4 = 4;
        goto L_0x01b6;
    L_0x0123:
        r0 = "polinz";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x012b:
        r4 = 25;
        goto L_0x01b6;
    L_0x012f:
        r0 = "paypal";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0137:
        r4 = 33;
        goto L_0x01b6;
    L_0x013b:
        r0 = "moneta";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0143:
        r4 = 2;
        goto L_0x01b6;
    L_0x0146:
        r0 = "fasapay";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x014e:
        r4 = 30;
        goto L_0x01b6;
    L_0x0152:
        r0 = "liqpay";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x015a:
        r4 = 34;
        goto L_0x01b6;
    L_0x015d:
        r0 = "abaqoos";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0165:
        r4 = 23;
        goto L_0x01b6;
    L_0x0168:
        r0 = "ekonto";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0170:
        r4 = 12;
        goto L_0x01b6;
    L_0x0173:
        r0 = "ewirese";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x017b:
        r4 = 15;
        goto L_0x01b6;
    L_0x017e:
        r0 = "ewiredk";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0186:
        r4 = 14;
        goto L_0x01b6;
    L_0x0189:
        r0 = "boleto";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x0191:
        r4 = 32;
        goto L_0x01b6;
    L_0x0194:
        r0 = "banklinkswed";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x019c:
        r4 = 8;
        goto L_0x01b6;
    L_0x019f:
        r0 = "banklink";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x01a7:
        r4 = 9;
        goto L_0x01b6;
    L_0x01aa:
        r0 = "dineromail";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x01b5;
    L_0x01b2:
        r4 = 11;
        goto L_0x01b6;
    L_0x01b5:
        r4 = -1;
    L_0x01b6:
        r0 = 2131232388; // 0x7f080684 float:1.8080884E38 double:1.052968706E-314;
        r2 = 2131232408; // 0x7f080698 float:1.8080924E38 double:1.052968716E-314;
        r3 = 2131232386; // 0x7f080682 float:1.808088E38 double:1.052968705E-314;
        switch(r4) {
            case 0: goto L_0x0239;
            case 1: goto L_0x0239;
            case 2: goto L_0x0235;
            case 3: goto L_0x0231;
            case 4: goto L_0x022d;
            case 5: goto L_0x0229;
            case 6: goto L_0x0225;
            case 7: goto L_0x0221;
            case 8: goto L_0x0220;
            case 9: goto L_0x021f;
            case 10: goto L_0x021b;
            case 11: goto L_0x0217;
            case 12: goto L_0x0213;
            case 13: goto L_0x020f;
            case 14: goto L_0x020e;
            case 15: goto L_0x020d;
            case 16: goto L_0x0209;
            case 17: goto L_0x0205;
            case 18: goto L_0x0201;
            case 19: goto L_0x01fd;
            case 20: goto L_0x01f9;
            case 21: goto L_0x01f5;
            case 22: goto L_0x01f1;
            case 23: goto L_0x01ed;
            case 24: goto L_0x01ec;
            case 25: goto L_0x01eb;
            case 26: goto L_0x01e7;
            case 27: goto L_0x01e3;
            case 28: goto L_0x01df;
            case 29: goto L_0x01db;
            case 30: goto L_0x01d7;
            case 31: goto L_0x01d3;
            case 32: goto L_0x01cf;
            case 33: goto L_0x01cb;
            case 34: goto L_0x01c7;
            case 35: goto L_0x01c3;
            default: goto L_0x01c2;
        };
    L_0x01c2:
        return r1;
    L_0x01c3:
        r4 = 2131232402; // 0x7f080692 float:1.8080912E38 double:1.052968713E-314;
        return r4;
    L_0x01c7:
        r4 = 2131232405; // 0x7f080695 float:1.8080918E38 double:1.0529687146E-314;
        return r4;
    L_0x01cb:
        r4 = 2131232412; // 0x7f08069c float:1.8080933E38 double:1.052968718E-314;
        return r4;
    L_0x01cf:
        r4 = 2131232396; // 0x7f08068c float:1.80809E38 double:1.05296871E-314;
        return r4;
    L_0x01d3:
        r4 = 2131232395; // 0x7f08068b float:1.8080898E38 double:1.0529687097E-314;
        return r4;
    L_0x01d7:
        r4 = 2131232414; // 0x7f08069e float:1.8080937E38 double:1.052968719E-314;
        return r4;
    L_0x01db:
        r4 = 2131232407; // 0x7f080697 float:1.8080922E38 double:1.0529687156E-314;
        return r4;
    L_0x01df:
        r4 = 2131232400; // 0x7f080690 float:1.8080908E38 double:1.052968712E-314;
        return r4;
    L_0x01e3:
        r4 = 2131232393; // 0x7f080689 float:1.8080894E38 double:1.0529687087E-314;
        return r4;
    L_0x01e7:
        r4 = 2131232415; // 0x7f08069f float:1.8080939E38 double:1.0529687196E-314;
        return r4;
    L_0x01eb:
        return r3;
    L_0x01ec:
        return r3;
    L_0x01ed:
        r4 = 2131232385; // 0x7f080681 float:1.8080878E38 double:1.0529687047E-314;
        return r4;
    L_0x01f1:
        r4 = 2131232387; // 0x7f080683 float:1.8080882E38 double:1.0529687057E-314;
        return r4;
    L_0x01f5:
        r4 = 2131232416; // 0x7f0806a0 float:1.808094E38 double:1.05296872E-314;
        return r4;
    L_0x01f9:
        r4 = 2131232397; // 0x7f08068d float:1.8080902E38 double:1.0529687107E-314;
        return r4;
    L_0x01fd:
        r4 = 2131232390; // 0x7f080686 float:1.8080888E38 double:1.052968707E-314;
        return r4;
    L_0x0201:
        r4 = 2131232403; // 0x7f080693 float:1.8080914E38 double:1.0529687136E-314;
        return r4;
    L_0x0205:
        r4 = 2131232406; // 0x7f080696 float:1.808092E38 double:1.052968715E-314;
        return r4;
    L_0x0209:
        r4 = 2131232392; // 0x7f080688 float:1.8080892E38 double:1.052968708E-314;
        return r4;
    L_0x020d:
        return r2;
    L_0x020e:
        return r2;
    L_0x020f:
        r4 = 2131232398; // 0x7f08068e float:1.8080904E38 double:1.052968711E-314;
        return r4;
    L_0x0213:
        r4 = 2131232401; // 0x7f080691 float:1.808091E38 double:1.0529687126E-314;
        return r4;
    L_0x0217:
        r4 = 2131232404; // 0x7f080694 float:1.8080916E38 double:1.052968714E-314;
        return r4;
    L_0x021b:
        r4 = 2131232409; // 0x7f080699 float:1.8080926E38 double:1.0529687166E-314;
        return r4;
    L_0x021f:
        return r0;
    L_0x0220:
        return r0;
    L_0x0221:
        r4 = 2131232413; // 0x7f08069d float:1.8080935E38 double:1.0529687186E-314;
        return r4;
    L_0x0225:
        r4 = 2131232410; // 0x7f08069a float:1.8080928E38 double:1.052968717E-314;
        return r4;
    L_0x0229:
        r4 = 2131232411; // 0x7f08069b float:1.808093E38 double:1.0529687176E-314;
        return r4;
    L_0x022d:
        r4 = 2131232399; // 0x7f08068f float:1.8080906E38 double:1.0529687116E-314;
        return r4;
    L_0x0231:
        r4 = 2131232391; // 0x7f080687 float:1.808089E38 double:1.0529687077E-314;
        return r4;
    L_0x0235:
        r4 = 2131232389; // 0x7f080685 float:1.8080886E38 double:1.0529687067E-314;
        return r4;
    L_0x0239:
        r4 = 2131232394; // 0x7f08068a float:1.8080896E38 double:1.052968709E-314;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.util.ay.jN(java.lang.String):int");
    }
}
