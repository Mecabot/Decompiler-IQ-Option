package jumio.bam;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.jumio.bam.BamCardInformation;
import com.jumio.bam.enums.CreditCardType;
import com.jumio.commons.PersistWith;
import com.jumio.commons.json.JumioJSONObject;
import com.jumio.commons.log.Log;
import com.jumio.core.mvp.model.StaticModel;
import java.util.Arrays;

@PersistWith("CardDataModel")
/* compiled from: CardDataModel */
public class y extends BamCardInformation implements StaticModel {
    public static final Creator<y> CREATOR = new Creator<y>() {
        /* renamed from: a */
        public y createFromParcel(Parcel parcel) {
            return new y(parcel);
        }

        /* renamed from: a */
        public y[] newArray(int i) {
            return new y[i];
        }
    };
    private boolean a = false;
    private boolean b = false;
    private JumioJSONObject c = null;
    private JumioJSONObject d = null;
    private JumioJSONObject e = null;

    public y(Parcel parcel) {
        super(parcel);
    }

    public void clear() {
        super.clear();
        this.a = false;
        this.b = false;
        if (this.c != null) {
            this.c.clear();
            this.c = null;
        }
        if (this.d != null) {
            this.d.clear();
            this.d = null;
        }
        if (this.e != null) {
            this.e.clear();
            this.e = null;
        }
    }

    public void a(CreditCardType creditCardType) {
        this.cardType = creditCardType;
    }

    public void a(StringBuilder stringBuilder) {
        if (this.cardNumber != null) {
            Arrays.fill(this.cardNumber, 0);
        }
        this.cardNumber = new char[stringBuilder.length()];
        stringBuilder.getChars(0, stringBuilder.length(), this.cardNumber, 0);
        if (this.cardNumberGrouped != null) {
            Arrays.fill(this.cardNumberGrouped, 0);
        }
        ab.a(stringBuilder, this.cardType);
        this.cardNumberGrouped = new char[stringBuilder.length()];
        stringBuilder.getChars(0, stringBuilder.length(), this.cardNumberGrouped, 0);
        if (this.cardNumberMasked != null) {
            Arrays.fill(this.cardNumberMasked, 0);
        }
        ab.a(stringBuilder);
        ab.a(stringBuilder, this.cardType);
        this.cardNumberMasked = new char[stringBuilder.length()];
        stringBuilder.getChars(0, stringBuilder.length(), this.cardNumberMasked, 0);
    }

    public char[] a(boolean z) {
        return z ? getCardNumberMasked() : getCardNumberGrouped();
    }

    public void b(StringBuilder stringBuilder) {
        stringBuilder = h(stringBuilder);
        if (this.cardHolderName != null) {
            Arrays.fill(this.cardHolderName, 0);
        }
        this.cardHolderName = new char[stringBuilder.length()];
        stringBuilder.getChars(0, stringBuilder.length(), this.cardHolderName, 0);
    }

    private StringBuilder h(StringBuilder stringBuilder) {
        int length = stringBuilder.length() - 1;
        int i = 0;
        while (i < length && stringBuilder.charAt(i) <= ' ') {
            i++;
        }
        while (length >= i && stringBuilder.charAt(length) <= ' ') {
            length--;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(stringBuilder, i, length + 1);
        Object obj = null;
        for (int length2 = stringBuilder2.length() - 1; length2 >= 0; length2--) {
            if (!Character.isWhitespace(stringBuilder2.charAt(length2))) {
                obj = null;
            } else if (obj == null) {
                obj = 1;
            } else {
                stringBuilder2.deleteCharAt(length2);
            }
        }
        return stringBuilder2;
    }

    public void c(StringBuilder stringBuilder) {
        if (this.cardSortCode != null) {
            Arrays.fill(this.cardSortCode, 0);
        }
        this.cardSortCode = new char[stringBuilder.length()];
        stringBuilder.getChars(0, stringBuilder.length(), this.cardSortCode, 0);
    }

    public void d(StringBuilder stringBuilder) {
        if (this.cardAccountNumber != null) {
            Arrays.fill(this.cardAccountNumber, 0);
        }
        this.cardAccountNumber = new char[stringBuilder.length()];
        stringBuilder.getChars(0, stringBuilder.length(), this.cardAccountNumber, 0);
    }

    public void e(StringBuilder stringBuilder) {
        if (this.cardExpiryDateMonth != null) {
            Arrays.fill(this.cardExpiryDateMonth, 0);
        }
        this.cardExpiryDateMonth = new char[stringBuilder.length()];
        stringBuilder.getChars(0, stringBuilder.length(), this.cardExpiryDateMonth, 0);
    }

    public void f(StringBuilder stringBuilder) {
        if (this.cardExpiryDateYear != null) {
            Arrays.fill(this.cardExpiryDateYear, 0);
        }
        this.cardExpiryDateYear = new char[stringBuilder.length()];
        stringBuilder.getChars(0, stringBuilder.length(), this.cardExpiryDateYear, 0);
    }

    public void g(StringBuilder stringBuilder) {
        if (this.cardCvvCode != null) {
            Arrays.fill(this.cardCvvCode, 0);
        }
        this.cardCvvCode = new char[stringBuilder.length()];
        stringBuilder.getChars(0, stringBuilder.length(), this.cardCvvCode, 0);
    }

    public void a(String str, String str2) {
        this.customFields.put(str, str2);
    }

    public BamCardInformation a() {
        return BamCardInformation.create(this);
    }

    public void b(boolean z) {
        this.cardSortCodeValid = z;
    }

    public void c(boolean z) {
        this.cardAccountNumberValid = z;
    }

    public void d(boolean z) {
        this.a = z;
    }

    public boolean b() {
        return this.a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public JumioJSONObject c() {
        return this.c;
    }

    public void a(JumioJSONObject jumioJSONObject) {
        this.c = jumioJSONObject;
    }

    public JumioJSONObject d() {
        return this.d;
    }

    public void b(JumioJSONObject jumioJSONObject) {
        this.d = jumioJSONObject;
    }

    public void a(String str, long j) {
        if (this.e == null) {
            this.e = new JumioJSONObject();
        }
        try {
            this.e.put(str, j);
        } catch (Throwable e) {
            Log.printStackTrace(e);
        }
    }

    public JumioJSONObject e() {
        return this.e;
    }

    public boolean f() {
        return this.b;
    }

    public void e(boolean z) {
        this.b = z;
    }
}
