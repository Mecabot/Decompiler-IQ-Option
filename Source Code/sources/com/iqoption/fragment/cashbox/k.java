package com.iqoption.fragment.cashbox;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.i;
import com.iqoption.d.hd;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.base.f;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: DepositPaymentCompletedFragment */
public class k extends f {
    public static final String TAG = "com.iqoption.fragment.cashbox.k";
    private boolean cxM;
    private String cxN;
    private hd cxO;
    private Builder cxf;
    private String errorMessage;
    private String reason;

    /* compiled from: DepositPaymentCompletedFragment */
    public interface a {
        void aaw();

        void aax();

        void cq(boolean z);
    }

    public static k b(boolean z, String str, String str2, String str3) {
        k kVar = new k();
        Bundle bundle = new Bundle();
        bundle.putBoolean("ARG_PAYMENT_SUCCESSFULLY", z);
        bundle.putString("ARG_PAYMENT_ERROR_MESSAGE", str);
        bundle.putString("ARG_REASON", str2);
        bundle.putString("ARG_RESPONSE_LOG", str3);
        kVar.setArguments(bundle);
        return kVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cxM = bundle.getBoolean("ARG_PAYMENT_SUCCESSFULLY");
            this.errorMessage = bundle.getString("ARG_PAYMENT_ERROR_MESSAGE");
            this.reason = bundle.getString("ARG_REASON");
            this.cxN = bundle.getString("ARG_RESPONSE_LOG");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cxO = (hd) DataBindingUtil.inflate(layoutInflater, R.layout.deposit_payment_completed_page, viewGroup, false);
        if (this.cxM) {
            this.cxO.boG.setText(R.string.payment_successful);
            this.cxO.bqQ.getRoot().setVisibility(0);
            this.cxO.bqR.getRoot().setVisibility(8);
            d(this.cxO.bqQ.bqU);
        } else {
            this.cxO.boG.setText(R.string.deposit_error);
            this.cxO.bqR.getRoot().setVisibility(0);
            this.cxO.bqQ.getRoot().setVisibility(8);
            this.cxO.bqR.bqW.setMovementMethod(new ScrollingMovementMethod());
            if (TextUtils.isEmpty(this.errorMessage)) {
                this.cxO.bqR.bqW.setVisibility(8);
            } else {
                this.cxO.bqR.bqW.setText(this.errorMessage);
                this.cxO.bqR.bqW.setVisibility(0);
            }
        }
        this.cxO.bqO.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a a = k.this.akC();
                if (a != null) {
                    a.cq(k.this.cxM);
                }
            }
        });
        this.cxO.bqQ.bqV.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a a = k.this.akC();
                if (a != null) {
                    a.cq(k.this.cxM);
                }
            }
        });
        this.cxO.bqR.bqY.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a a = k.this.akC();
                if (a != null) {
                    a.aaw();
                }
            }
        });
        TextView textView = this.cxO.bqR.bqZ;
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a a = k.this.akC();
                if (a != null) {
                    a.aax();
                }
            }
        });
        Object string = getContext().getString(R.string.contact_the_support_from_payment_unsuccessfull);
        CharSequence replace = getContext().getString(R.string.payment_unsuccessful_n1, new Object[]{string}).replace(".", ".\n");
        if (replace.contains(string)) {
            CharSequence spannableString = new SpannableString(replace);
            int indexOf = TextUtils.indexOf(replace, string);
            final int color = ContextCompat.getColor(getContext(), R.color.deposit_page_contact_the_support);
            spannableString.setSpan(new ClickableSpan() {
                public void onClick(View view) {
                    a a = k.this.akC();
                    if (a != null) {
                        a.aax();
                    }
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(color);
                }
            }, indexOf, string.length() + indexOf, 33);
            textView.setText(spannableString);
        }
        return this.cxO.getRoot();
    }

    private void d(final ImageView imageView) {
        if (VERSION.SDK_INT >= 21) {
            try {
                final Drawable drawable = getContext().getDrawable(R.drawable.ic_ring_checkmark_animated);
                imageView.setImageDrawable(drawable);
                if (drawable instanceof AnimatedVectorDrawable) {
                    com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
                        public void run() {
                            imageView.setVisibility(0);
                            ((AnimatedVectorDrawable) drawable).start();
                        }
                    }, 300);
                    return;
                }
                return;
            } catch (Throwable e) {
                i.e(TAG, "animateSuccess", e);
                imageView.setImageDrawable(getContext().getDrawable(R.drawable.ic_ring_checkmark));
                return;
            }
        }
        imageView.setImageResource(R.drawable.ic_ring_checkmark);
    }

    public void onResume() {
        super.onResume();
        am.n(zzakw());
        this.cxf = Event.Builder(Event.CATEGORY_SCREEN_OPENED, this.cxM ? "deposit-success" : "deposit-error");
        this.cxf.setParameters(com.iqoption.core.util.i.ZZ().l("reason", this.reason == null ? "" : this.reason).l("responseLog", this.cxN == null ? "" : this.cxN).aab());
    }

    public void onPause() {
        super.onPause();
        EventManager.Bm().a(this.cxf.calcDuration().build());
    }

    public boolean onBackPressed() {
        a akC = akC();
        if (akC != null) {
            akC.cq(this.cxM);
        }
        return true;
    }

    private a akC() {
        if (getContext() instanceof a) {
            return (a) getContext();
        }
        return getTargetFragment() instanceof a ? (a) getTargetFragment() : null;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onDetach() {
        super.onDetach();
    }
}
