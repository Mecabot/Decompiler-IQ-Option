package com.umoove.all;

import android.graphics.PointF;

/* compiled from: UMHeadData */
public class f {
    public PointF eiX = new PointF();
    public PointF eiY = new PointF();

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append("Head Position [");
        stringBuilder.append(this.eiX.x);
        stringBuilder.append(",");
        stringBuilder.append(this.eiX.y);
        stringBuilder.append("]\r\n");
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append("Head Movements [");
        stringBuilder.append(this.eiY.x);
        stringBuilder.append(",");
        stringBuilder.append(this.eiY.y);
        stringBuilder.append("]\r\n");
        return stringBuilder.toString();
    }
}
