package io.card.payment;

/* compiled from: MaxLengthValidator */
class g extends h implements n {
    private int maxLength;

    g(int i) {
        this.maxLength = i;
    }

    public boolean isValid() {
        return super.isValid() && getValue().length() <= this.maxLength;
    }
}
