package io.card.payment;

class DetectionInfo {
    public boolean bottomEdge;
    public boolean complete = false;
    public CreditCard detectedCard;
    public int expiry_month;
    public int expiry_year;
    public float focusScore;
    public boolean leftEdge;
    public int[] prediction = new int[16];
    public boolean rightEdge;
    public boolean topEdge;

    public DetectionInfo() {
        this.prediction[0] = -1;
        this.prediction[15] = -1;
        this.detectedCard = new CreditCard();
    }

    boolean a(DetectionInfo detectionInfo) {
        return detectionInfo.topEdge == this.topEdge && detectionInfo.bottomEdge == this.bottomEdge && detectionInfo.leftEdge == this.leftEdge && detectionInfo.rightEdge == this.rightEdge;
    }

    boolean aTM() {
        return this.topEdge && this.bottomEdge && this.rightEdge && this.leftEdge;
    }

    boolean aTN() {
        return this.complete;
    }

    CreditCard aTO() {
        String str = new String();
        int i = 0;
        while (i < 16 && this.prediction[i] >= 0 && this.prediction[i] < 10) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(String.valueOf(this.prediction[i]));
            str = stringBuilder.toString();
            i++;
        }
        this.detectedCard.cardNumber = str;
        this.detectedCard.expiryMonth = this.expiry_month;
        this.detectedCard.expiryYear = this.expiry_year;
        return this.detectedCard;
    }

    int aTP() {
        return ((this.topEdge + this.bottomEdge) + this.leftEdge) + this.rightEdge;
    }
}
