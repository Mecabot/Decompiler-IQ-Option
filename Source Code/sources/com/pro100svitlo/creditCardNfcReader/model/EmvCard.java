package com.pro100svitlo.creditCardNfcReader.model;

import com.pro100svitlo.creditCardNfcReader.enums.EmvCardScheme;
import java.util.Collection;
import java.util.List;

public class EmvCard extends AbstractData {
    private static final long serialVersionUID = 736740432469989941L;
    private String aid;
    private String applicationLabel;
    private Collection<String> atrDescription;
    private String cardNumber;
    private String expireDate;
    private String holderFirstname;
    private String holderLastname;
    private int leftPinTry;
    private List<EmvTransactionRecord> listTransactions;
    private boolean nfcLocked;
    private Service service;
    private EmvCardScheme type;

    public void ld(String str) {
        this.aid = str;
    }

    public String aRQ() {
        return this.holderLastname;
    }

    public void le(String str) {
        this.holderLastname = str;
    }

    public String aRR() {
        return this.holderFirstname;
    }

    public void lf(String str) {
        this.holderFirstname = str;
    }

    public String Vg() {
        return this.cardNumber;
    }

    public void lg(String str) {
        this.cardNumber = str;
    }

    public String auW() {
        return this.expireDate;
    }

    public void lh(String str) {
        this.expireDate = str;
    }

    public void bK(List<EmvTransactionRecord> list) {
        this.listTransactions = list;
    }

    public void a(EmvCardScheme emvCardScheme) {
        this.type = emvCardScheme;
    }

    public void li(String str) {
        this.applicationLabel = str;
    }

    public boolean equals(Object obj) {
        return (obj instanceof EmvCard) && this.cardNumber != null && this.cardNumber.equals(((EmvCard) obj).Vg());
    }

    public void io(int i) {
        this.leftPinTry = i;
    }

    public void a(Service service) {
        this.service = service;
    }

    public void gc(boolean z) {
        this.nfcLocked = z;
    }
}
