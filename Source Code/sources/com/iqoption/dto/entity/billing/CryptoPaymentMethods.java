package com.iqoption.dto.entity.billing;

import java.util.ArrayList;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, aXE = {"Lcom/iqoption/dto/entity/billing/CryptoPaymentMethods;", "Ljava/util/ArrayList;", "Lcom/iqoption/dto/entity/billing/CryptoPaymentMethod;", "()V", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CryptoPaymentMethod.kt */
public final class CryptoPaymentMethods extends ArrayList<CryptoPaymentMethod> {
    public /* bridge */ boolean contains(CryptoPaymentMethod cryptoPaymentMethod) {
        return super.contains(cryptoPaymentMethod);
    }

    public final /* bridge */ boolean contains(Object obj) {
        return obj instanceof CryptoPaymentMethod ? contains((CryptoPaymentMethod) obj) : false;
    }

    public int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(CryptoPaymentMethod cryptoPaymentMethod) {
        return super.indexOf(cryptoPaymentMethod);
    }

    public final /* bridge */ int indexOf(Object obj) {
        return obj instanceof CryptoPaymentMethod ? indexOf((CryptoPaymentMethod) obj) : -1;
    }

    public /* bridge */ int lastIndexOf(CryptoPaymentMethod cryptoPaymentMethod) {
        return super.lastIndexOf(cryptoPaymentMethod);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        return obj instanceof CryptoPaymentMethod ? lastIndexOf((CryptoPaymentMethod) obj) : -1;
    }

    public final CryptoPaymentMethod remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ boolean remove(CryptoPaymentMethod cryptoPaymentMethod) {
        return super.remove(cryptoPaymentMethod);
    }

    public final /* bridge */ boolean remove(Object obj) {
        return obj instanceof CryptoPaymentMethod ? remove((CryptoPaymentMethod) obj) : false;
    }

    public CryptoPaymentMethod removeAt(int i) {
        return (CryptoPaymentMethod) super.remove(i);
    }

    public final int size() {
        return getSize();
    }
}
