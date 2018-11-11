package com.pro100svitlo.creditCardNfcReader.iso7816emv.a;

import com.pro100svitlo.creditCardNfcReader.enums.TagTypeEnum;
import com.pro100svitlo.creditCardNfcReader.enums.TagValueTypeEnum;
import com.pro100svitlo.creditCardNfcReader.iso7816emv.ITag;
import com.pro100svitlo.creditCardNfcReader.iso7816emv.ITag.Class;
import java.util.Arrays;

/* compiled from: TagImpl */
public final class a implements ITag {
    private final String description;
    private final byte[] egA;
    private final TagValueTypeEnum egB;
    private final Class egC;
    private final TagTypeEnum egD;
    public final String name;

    public a(String str, TagValueTypeEnum tagValueTypeEnum, String str2, String str3) {
        this(com.pro100svitlo.creditCardNfcReader.a.a.lj(str), tagValueTypeEnum, str2, str3);
    }

    public a(byte[] bArr, TagValueTypeEnum tagValueTypeEnum, String str, String str2) {
        if (bArr == null) {
            throw new IllegalArgumentException("Param id cannot be null");
        } else if (bArr.length == 0) {
            throw new IllegalArgumentException("Param id cannot be empty");
        } else if (tagValueTypeEnum == null) {
            throw new IllegalArgumentException("Param tagValueType cannot be null");
        } else {
            this.egA = bArr;
            this.name = str;
            this.description = str2;
            this.egB = tagValueTypeEnum;
            if (com.pro100svitlo.creditCardNfcReader.a.a.aL(this.egA[0], 5)) {
                this.egD = TagTypeEnum.CONSTRUCTED;
            } else {
                this.egD = TagTypeEnum.PRIMITIVE;
            }
            switch ((byte) ((this.egA[0] >>> 6) & 3)) {
                case (byte) 1:
                    this.egC = Class.APPLICATION;
                    return;
                case (byte) 2:
                    this.egC = Class.CONTEXT_SPECIFIC;
                    return;
                case (byte) 3:
                    this.egC = Class.PRIVATE;
                    return;
                default:
                    this.egC = Class.UNIVERSAL;
                    return;
            }
        }
    }

    public boolean isConstructed() {
        return this.egD == TagTypeEnum.CONSTRUCTED;
    }

    public byte[] aRI() {
        return this.egA;
    }

    public String getName() {
        return this.name;
    }

    public TagValueTypeEnum aRL() {
        return this.egB;
    }

    public TagTypeEnum aRM() {
        return this.egD;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ITag)) {
            return false;
        }
        ITag iTag = (ITag) obj;
        if (aRI().length != iTag.aRI().length) {
            return false;
        }
        return Arrays.equals(aRI(), iTag.aRI());
    }

    public int hashCode() {
        return 177 + Arrays.hashCode(this.egA);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tag[");
        stringBuilder.append(com.pro100svitlo.creditCardNfcReader.a.a.T(aRI()));
        stringBuilder.append("] Name=");
        stringBuilder.append(getName());
        stringBuilder.append(", TagType=");
        stringBuilder.append(aRM());
        stringBuilder.append(", ValueType=");
        stringBuilder.append(aRL());
        stringBuilder.append(", Class=");
        stringBuilder.append(this.egC);
        return stringBuilder.toString();
    }
}
