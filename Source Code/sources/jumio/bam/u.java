package jumio.bam;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jumio.bam.R;
import com.jumio.bam.enums.CreditCardType;
import com.jumio.bam.environment.BamEnvironment;
import com.jumio.commons.utils.ScreenUtil;

/* compiled from: TopCreditCardDataBar */
public class u extends RelativeLayout {
    private LinearLayout a = ((LinearLayout) findViewById(R.id.bam_top_bar_sub_container));
    private ImageView b = ((ImageView) findViewById(R.id.bam_top_bar_cc_logo));
    private TextView c = ((TextView) findViewById(R.id.bam_top_bar_cc_number));
    private TextView d;
    private TextView e;
    private TextView f;

    public u(Context context) {
        super(context);
        inflate(getContext(), R.layout.bam_top_cc_data_bar, this);
        setId(R.id.topInfoBar);
        this.c.setTypeface(BamEnvironment.loadOcraFontTypeface(context));
        this.d = (TextView) findViewById(R.id.bam_top_bar_cc_expiry);
        this.d.setVisibility(8);
        this.e = (TextView) findViewById(R.id.bam_top_bar_cc_holder_name);
        this.e.setVisibility(8);
        this.f = (TextView) findViewById(R.id.bam_top_bar_cc_sort_code_and_account_number);
        this.f.setVisibility(8);
    }

    public void a(CreditCardType creditCardType, Resources resources) {
        Bitmap decodeResource;
        switch (creditCardType) {
            case VISA:
                decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.bam_icon_visa);
                break;
            case MASTER_CARD:
                decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.bam_icon_mastercard);
                break;
            case AMERICAN_EXPRESS:
                decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.bam_icon_amex);
                break;
            case DINERS_CLUB:
                decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.bam_icon_diners);
                break;
            case DISCOVER:
                decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.bam_icon_discover);
                break;
            case CHINA_UNIONPAY:
                decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.bam_icon_cup);
                break;
            case JCB:
                decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.bam_icon_jcb);
                break;
            default:
                decodeResource = null;
                break;
        }
        this.b.setImageBitmap(decodeResource);
    }

    public void setCreditCardNumber(CharSequence charSequence) {
        this.c.setText(charSequence);
    }

    public void setExpiryDate(CharSequence charSequence) {
        this.d.setText(charSequence);
        this.d.setVisibility(0);
        a();
    }

    public void setSortCodeAndAccountNumber(CharSequence charSequence) {
        this.f.setText(charSequence);
        this.f.setVisibility(0);
        a();
    }

    public void setCardHolderName(CharSequence charSequence) {
        this.e.setText(charSequence);
        this.e.setVisibility(0);
        a();
    }

    private void a() {
        this.a.setPadding(0, 0, 0, ScreenUtil.dpToPx(getContext(), 5));
    }
}
