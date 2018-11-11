package com.pro100svitlo.creditCardNfcReader.model;

import com.pro100svitlo.creditCardNfcReader.model.enums.CountryCodeEnum;
import com.pro100svitlo.creditCardNfcReader.model.enums.CurrencyEnum;
import com.pro100svitlo.creditCardNfcReader.model.enums.TransactionTypeEnum;
import com.pro100svitlo.creditCardNfcReader.parser.apdu.a.c;
import com.pro100svitlo.creditCardNfcReader.parser.apdu.impl.AbstractByteBean;
import java.io.Serializable;
import java.util.Date;

public class EmvTransactionRecord extends AbstractByteBean<EmvTransactionRecord> implements Serializable {
    private static final long serialVersionUID = -7050737312961921452L;
    @c(aSh = "BCD_Format", aSk = "9f02", index = 1, size = 48)
    private Float amount;
    @c(aSk = "5f2a", index = 4, size = 16)
    private CurrencyEnum currency;
    @c(aSj = true, aSk = "9f27", index = 2, size = 8)
    private String cyptogramData;
    @c(aSh = "yyMMdd", aSi = 1, aSk = "9a", index = 5, size = 24)
    private Date date;
    @c(aSk = "9f1a", index = 3, size = 16)
    private CountryCodeEnum terminalCountry;
    @c(aSh = "HHmmss", aSi = 1, aSk = "9f21", index = 7, size = 24)
    private Date time;
    @c(aSj = true, aSk = "9c", index = 6, size = 8)
    private TransactionTypeEnum transactionType;

    public Float aRS() {
        return this.amount;
    }

    public CurrencyEnum aRT() {
        return this.currency;
    }

    public void a(Float f) {
        this.amount = f;
    }

    public void a(CurrencyEnum currencyEnum) {
        this.currency = currencyEnum;
    }
}
