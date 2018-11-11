package com.iqoption.menu;

import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.common.util.concurrent.n;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.app.IQApp;
import com.iqoption.app.a.b;
import com.iqoption.core.a.d;
import com.iqoption.core.a.e;
import com.iqoption.core.i;
import com.iqoption.core.util.p;
import com.iqoption.d.adi;
import com.iqoption.dto.Country;
import com.iqoption.mobbtech.connect.request.f;
import com.iqoption.util.ag;
import com.iqoption.verify.VerifyCardsActivity;
import com.iqoption.view.SelectionButton;
import com.iqoption.view.l;
import com.iqoption.view.spinner.AwesomeTextSpinner;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PersonalInfoView */
public class c extends FrameLayout {
    private static final String TAG = "com.iqoption.menu.c";
    @NonNull
    private e aMD;
    protected List<Country> aVh;
    protected ViewPager bGy;
    protected ImageView bOD;
    protected EditText bOE;
    protected EditText bOI;
    private TextView bOh;
    private TextView bOi;
    private LinearLayout bOj;
    private ImageView bOk;
    protected TextView bOt;
    protected AwesomeTextSpinner bOv;
    protected ImageView bOz;
    protected EditText cOA;
    protected View cOB;
    protected EditText cOC;
    protected EditText cOD;
    protected EditText cOE;
    protected View cOF;
    protected View cOG;
    private View cOH;
    private View cOI;
    private d cOJ;
    private View cOK;
    private a cOL;
    protected SelectionButton cOj;
    protected SelectionButton cOk;
    protected SelectionButton cOl;
    protected View cOm;
    protected SelectionButton cOn;
    protected View cOo;
    protected View cOp;
    private List<a> cOq;
    protected EditText cOr;
    protected EditText cOs;
    protected ArrayAdapter cOt;
    protected EditText cOu;
    protected EditText cOv;
    protected View cOw;
    protected View cOx;
    protected EditText cOy;
    protected EditText cOz;
    protected TradeRoomActivity cfy;
    protected String gender;

    /* compiled from: PersonalInfoView */
    public interface a {
        void ahC();
    }

    public c(TradeRoomActivity tradeRoomActivity) {
        this(tradeRoomActivity, null);
    }

    public c(TradeRoomActivity tradeRoomActivity, AttributeSet attributeSet) {
        this(tradeRoomActivity, attributeSet, 0);
    }

    public c(TradeRoomActivity tradeRoomActivity, AttributeSet attributeSet, int i) {
        super(tradeRoomActivity, attributeSet, i);
        this.aVh = new ArrayList();
        this.cfy = tradeRoomActivity;
        this.aMD = IQApp.Dk().Ds();
        this.cOJ = this.aMD.dZ("personal-data_show");
        LayoutInflater.from(getContext()).inflate(R.layout.personal_info_dialog, this, true);
        aep();
        aqX();
        getCountries();
        Tracker aP = IQApp.aP(getContext());
        aP.setScreenName("Personal data");
        aP.send(((ScreenViewBuilder) new ScreenViewBuilder().setCustomDimension(2, aP.get("&cid"))).build());
    }

    protected void aep() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(getContext());
        this.cOK = findViewById(R.id.savePersonalInfo);
        this.cOK.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (c.this.bGy.getCurrentItem() == 0) {
                    c.this.aqY();
                } else if (c.this.bGy.getCurrentItem() == 1) {
                    c.this.arb();
                } else if (c.this.bGy.getCurrentItem() == 2) {
                    c.this.cfy.onBackPressed();
                }
            }
        });
        ((TextView) findViewById(R.id.personalName)).setText(aL.Df());
        TextView textView = (TextView) findViewById(R.id.personalId);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getContext().getString(R.string.personal_cabinet));
        stringBuilder.append(" ");
        stringBuilder.append(aL.getUserId());
        textView.setText(stringBuilder.toString());
        this.bGy = (ViewPager) findViewById(R.id.personalViewPager);
        this.bGy.setOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                c.this.setActiveTab(i);
            }
        });
        this.cOw = findViewById(R.id.iconAlertDocs);
        this.cOj = (SelectionButton) findViewById(R.id.infoTab);
        this.cOk = (SelectionButton) findViewById(R.id.passTab);
        this.cOl = (SelectionButton) findViewById(R.id.docsTab);
        this.cOm = findViewById(R.id.docTabContainer);
        this.cOn = (SelectionButton) findViewById(R.id.cardsTab);
        this.cOo = findViewById(R.id.cardsTabContainer);
        this.cOp = findViewById(R.id.iconAlertCards);
        this.cOq = new ArrayList();
        this.cOq.add(new a(this.cOj, true));
        this.cOq.add(new a(this.cOk, true));
        this.cOq.add(new a(this.cOl, true));
        this.cOq.add(new a(this.cOn, true));
        if (!aL.akB) {
            this.cOm.setVisibility(8);
            b(this.cOl, false);
        }
        if (com.iqoption.app.managers.feature.a.HR()) {
            this.cOo.setVisibility(0);
        } else {
            this.cOo.setVisibility(8);
            b(this.cOn, false);
        }
        b.aN(this.cOq);
        List arrayList = new ArrayList();
        arrayList.add(getInfoPage());
        arrayList.add(getPassPage());
        if (!aL.Dh()) {
            ag.b(com.iqoption.microservice.a.a.eb(false), new n<com.iqoption.microservice.a.b.a>() {
                public void l(Throwable th) {
                }

                /* renamed from: b */
                public void onSuccess(com.iqoption.microservice.a.b.a aVar) {
                    i.v(c.TAG, aVar.toString());
                    if (ViewCompat.isAttachedToWindow(c.this)) {
                        String str = aVar.cRM;
                        Object obj = -1;
                        int hashCode = str.hashCode();
                        if (hashCode != -1757359925) {
                            if (hashCode != 1090724009) {
                                if (hashCode == 1350822958 && str.equals("DECLINED")) {
                                    obj = 2;
                                }
                            } else if (str.equals("VERIFYING")) {
                                obj = 1;
                            }
                        } else if (str.equals("INITIATED")) {
                            obj = null;
                        }
                        switch (obj) {
                            case null:
                            case 1:
                            case 2:
                                c.this.cOm.setVisibility(0);
                                if (c.this.b(c.this.cOl, true)) {
                                    b.aN(c.this.cOq);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
        this.bGy.setAdapter(new l(arrayList));
        this.cOj.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                c.this.bGy.setCurrentItem(0, true);
                c.this.aMD.dV("personal-data_info");
            }
        });
        this.cOk.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                c.this.bGy.setCurrentItem(1, true);
                c.this.aMD.dV("personal-data_password");
            }
        });
        this.cOl.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (c.this.cfy != null) {
                    new com.iqoption.kyc.activity.KycActivity.a(c.this.cfy).ic(com.iqoption.kyc.fragment.jumio.e.TAG).start();
                    c.this.aMD.dV("personal-data_documents");
                }
            }
        });
        this.cOn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (c.this.cfy != null) {
                    VerifyCardsActivity.start(c.this.cfy);
                    c.this.aMD.dV("personal-data_cards");
                }
            }
        });
        findViewById(R.id.backButton).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                c.this.cfy.onBackPressed();
            }
        });
        ara();
        setActiveTab(0);
        this.cOH = findViewById(R.id.kycStatusLayout);
        this.bOj = (LinearLayout) findViewById(R.id.kycStatus);
        this.bOk = (ImageView) findViewById(R.id.kycStatusIcon);
        this.bOi = (TextView) findViewById(R.id.kycDocumentStatus);
        this.bOh = (TextView) findViewById(R.id.kycDaysLeft);
        this.cOI = findViewById(R.id.kycButton);
        this.cOI.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (c.this.cfy != null) {
                    com.iqoption.app.a aL = com.iqoption.app.a.aL(c.this.getContext());
                    if (aL.kycStatus == 2 || aL.akD) {
                        new com.iqoption.kyc.activity.KycActivity.a(c.this.cfy).ic(com.iqoption.kyc.fragment.jumio.d.TAG).start();
                    } else {
                        new com.iqoption.kyc.activity.KycActivity.a(c.this.cfy).start();
                    }
                }
            }
        });
        aqU();
    }

    private boolean b(@NonNull View view, boolean z) {
        for (a aVar : this.cOq) {
            if (view.getId() == aVar.getView().getId()) {
                if (aVar.aqT() != z) {
                    aVar.setVisible(z);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public void onBackPressed() {
        this.aMD.dV("personal-data_back");
        this.cOJ.Bs();
    }

    private void aqU() {
        ((LayoutParams) this.bOj.getLayoutParams()).weight = this.cOm.getVisibility() == 0 ? 9.0f : 6.0f;
        com.iqoption.app.a aL = com.iqoption.app.a.aL(getContext());
        int intValue = ((Integer) aL.akx.getValue()).intValue();
        switch (aL.kycStatus) {
            case 0:
            case 3:
                this.cOH.setVisibility(8);
                return;
            case 1:
            case 2:
                if (intValue != -1) {
                    this.cOH.setVisibility(0);
                    int color = ResourcesCompat.getColor(getResources(), R.color.profile_kyc_error, null);
                    this.bOk.setImageResource(R.drawable.ic_profile_kyc_error);
                    this.bOi.setText(R.string.kyc_not_verified);
                    this.bOi.setTextColor(color);
                    if (intValue == 0) {
                        this.bOh.setVisibility(8);
                        return;
                    }
                    TextView textView = this.bOh;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(getResources().getString(R.string.kyc_days_left));
                    stringBuilder.append(" ");
                    stringBuilder.append(intValue);
                    textView.setText(stringBuilder.toString());
                    this.bOh.setVisibility(0);
                    return;
                }
                this.cOH.setVisibility(8);
                return;
            default:
                return;
        }
    }

    protected void setActiveTab(int i) {
        if (i == 0) {
            this.cOj.setSelected(true);
            this.cOk.setSelected(false);
            this.cOl.setSelected(false);
            ahB();
        } else if (i == 1) {
            this.cOj.setSelected(false);
            this.cOk.setSelected(true);
            this.cOl.setSelected(false);
            this.cOK.setVisibility(0);
        } else if (i == 2) {
            this.cOj.setSelected(false);
            this.cOk.setSelected(false);
            this.cOl.setSelected(true);
            this.cOK.setVisibility(8);
        }
    }

    protected void aqV() {
        this.gender = "male";
        this.bOD.setImageResource(R.drawable.radio_button_on);
        this.bOz.setImageResource(R.drawable.radio_button_off);
    }

    protected void aqW() {
        this.gender = "female";
        this.bOD.setImageResource(R.drawable.radio_button_off);
        this.bOz.setImageResource(R.drawable.radio_button_on);
    }

    protected void aqX() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(getContext());
        this.bOE.setText(aL.getFirstName());
        this.bOI.setText(aL.getLastName());
        this.cOr.setText(aL.getEmail());
        this.cOs.setText(aL.CO());
        this.cOu.setText(aL.getCountryCode());
        this.cOv.setText(aL.getPhone());
        this.cOy.setText(aL.getCity());
        this.cOz.setText(aL.CN());
        this.cOA.setText(aL.getAddress());
        if (aL.CK() == null || !aL.CK().equals("male")) {
            aqW();
        } else {
            aqV();
        }
    }

    protected void aqY() {
        String obj = this.bOE.getText().toString();
        String obj2 = this.bOI.getText().toString();
        Object obj3 = this.cOr.getText().toString();
        String obj4 = this.cOs.isEnabled() ? this.cOs.getText().toString() : "";
        Object obj5 = this.cOu.getText().toString();
        Object obj6 = this.cOv.getText().toString();
        String obj7 = this.cOy.getText().toString();
        String obj8 = this.cOz.getText().toString();
        String obj9 = this.cOA.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            b.b(getContext().getString(R.string.please_enter_your_name), getContext());
        } else if (TextUtils.isEmpty(obj2)) {
            b.b(getContext().getString(R.string.please_enter_your_surname), getContext());
        } else if (TextUtils.isEmpty(obj3)) {
            b.b(getContext().getString(R.string.please_enter_your_email), getContext());
        } else if (!p.u(obj3)) {
            b.b(getContext().getString(R.string.please_enter_valid_email), getContext());
        } else if (TextUtils.isEmpty(obj5)) {
            b.b(getContext().getString(R.string.please_enter_your_country_code), getContext());
        } else if (TextUtils.isEmpty(obj6)) {
            b.b(getContext().getString(R.string.please_enter_your_phone_number), getContext());
        } else {
            long j = !this.aVh.isEmpty() ? ((Country) this.aVh.get(this.bOv.getSelection())).id : -1;
            if (j == -1 || j == 0) {
                b.b(getContext().getString(R.string.please_enter_your_country), getContext());
                return;
            }
            TextView textView = (TextView) findViewById(R.id.personalName);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(" ");
            stringBuilder.append(obj2);
            textView.setText(stringBuilder.toString());
            new f().a(getContext(), obj, obj2, obj3, obj5, obj6, obj7, obj8, obj9, this.gender, j, obj4);
        }
    }

    protected void getCountries() {
        new com.iqoption.mobbtech.connect.request.d().a(getContext(), new com.iqoption.mobbtech.connect.request.d.a() {
            public void aO(List<Country> list) {
                c.this.aVh.clear();
                c.this.aVh.addAll(list);
                c.this.cOt.notifyDataSetChanged();
                for (int i = 0; i < list.size(); i++) {
                    if (((Country) list.get(i)).id == com.iqoption.app.a.aL(c.this.getContext()).Db()) {
                        c.this.bOv.setSelection(i, true);
                        return;
                    }
                }
            }
        });
    }

    protected View getPassPage() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.personal_pass_page, null);
        this.cOC = (EditText) inflate.findViewById(R.id.currentPassword);
        this.cOD = (EditText) inflate.findViewById(R.id.confirmPassword1);
        this.cOE = (EditText) inflate.findViewById(R.id.confirmPassword2);
        return inflate;
    }

    protected View getInfoPage() {
        adi adi = (adi) com.iqoption.core.ext.a.a((ViewGroup) this, (int) R.layout.personal_info_page, (ViewGroup) this, false);
        View root = adi.getRoot();
        this.bOE = (EditText) root.findViewById(R.id.nameEdit);
        this.bOI = (EditText) root.findViewById(R.id.surnameEdit);
        this.cOr = (EditText) root.findViewById(R.id.personalEmail);
        this.cOs = (EditText) root.findViewById(R.id.tin);
        this.cOu = (EditText) root.findViewById(R.id.countryCode);
        this.cOv = (EditText) root.findViewById(R.id.phone);
        this.cOx = root.findViewById(R.id.iconAlertConfirm);
        this.bOt = (TextView) root.findViewById(R.id.confirmLink);
        this.bOt.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (c.this.cfy != null) {
                    new com.iqoption.kyc.activity.KycActivity.a(c.this.cfy).ic(com.iqoption.kyc.fragment.b.c.TAG).start();
                }
            }
        });
        this.cOy = (EditText) root.findViewById(R.id.city);
        this.cOB = root.findViewById(R.id.genderLayout);
        this.cOz = (EditText) root.findViewById(R.id.zip);
        this.cOA = (EditText) root.findViewById(R.id.address);
        this.cOA.setHorizontallyScrolling(false);
        this.cOA.setMaxLines(100);
        this.bOv = (AwesomeTextSpinner) root.findViewById(R.id.countrySpinner);
        this.cOt = new ArrayAdapter(getContext(), R.layout.dark_string_item, R.id.name, this.aVh);
        this.bOv.setAdapter(this.cOt);
        this.bOv.setItemSelectedListener(new com.iqoption.view.spinner.AwesomeTextSpinner.a() {
            public void fi(int i) {
                i = ((Country) c.this.aVh.get(i)).phoneCode;
                if (i > 0 && TextUtils.isEmpty(c.this.cOu.getText())) {
                    EditText editText = c.this.cOu;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    stringBuilder.append("");
                    editText.setText(stringBuilder.toString());
                }
            }
        });
        this.bOD = (ImageView) root.findViewById(R.id.maleCheck);
        this.bOz = (ImageView) root.findViewById(R.id.femaleCheck);
        this.cOF = root.findViewById(R.id.male);
        this.cOG = root.findViewById(R.id.female);
        this.cOF.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                c.this.aqV();
            }
        });
        this.cOG.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                c.this.aqW();
            }
        });
        aqZ();
        ahB();
        if (com.iqoption.gdpr.a.bt(getContext())) {
            adi.bOx.setVisibility(0);
            adi.bOw.setOnClickListener(new d(this));
        } else {
            adi.bOx.setVisibility(8);
        }
        return root;
    }

    final /* synthetic */ void br(View view) {
        if (this.cOL != null) {
            this.cOL.ahC();
            this.aMD.dV("personal-data_delete-account");
        }
    }

    public void ahB() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(getContext());
        boolean z = false;
        if (aL.akD) {
            this.bOE.setEnabled(false);
            this.bOI.setEnabled(false);
            this.cOr.setEnabled(false);
            this.cOs.setEnabled(false);
            this.cOy.setEnabled(false);
            this.cOz.setEnabled(false);
            this.cOA.setEnabled(false);
            this.bOD.setEnabled(false);
            this.bOz.setEnabled(false);
            this.cOB.setEnabled(false);
            this.cOF.setEnabled(false);
            this.cOG.setEnabled(false);
            this.cOK.setVisibility(8);
        }
        if (!TextUtils.isEmpty(com.iqoption.app.a.Cw().CO())) {
            this.cOs.setEnabled(false);
        }
        if (aL.De()) {
            this.cOv.setEnabled(false);
            this.cOu.setEnabled(false);
        }
        AwesomeTextSpinner awesomeTextSpinner = this.bOv;
        if (!aL.akD && com.iqoption.kyc.a.aoz()) {
            z = true;
        }
        awesomeTextSpinner.setEnabled(z);
    }

    public void aqZ() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(getContext());
        if (!aL.akA || aL.De()) {
            this.bOt.setVisibility(8);
            this.cOx.setVisibility(8);
            return;
        }
        this.bOt.setVisibility(0);
        this.cOx.setVisibility(0);
        TextView textView = this.bOt;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<u>");
        stringBuilder.append(this.cfy.getString(R.string.confirm));
        stringBuilder.append("</u>");
        textView.setText(Html.fromHtml(stringBuilder.toString()));
    }

    public void ara() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(getContext());
        if (!aL.akF || aL.akC) {
            this.cOw.setVisibility(0);
        } else {
            this.cOw.setVisibility(8);
        }
    }

    protected void arb() {
        String obj = this.cOD.getText().toString();
        String obj2 = this.cOE.getText().toString();
        if (obj.isEmpty() || !obj.equals(obj2)) {
            b.b(getContext().getString(R.string.passwords_not_match), getContext());
            return;
        }
        new com.iqoption.mobbtech.connect.request.c().b(getContext(), this.cOC.getText().toString(), obj, obj2);
    }

    public void setCardVerificationFailed(boolean z) {
        this.cOp.setVisibility(z ? 0 : 8);
    }

    public void setCallback(a aVar) {
        this.cOL = aVar;
    }
}
