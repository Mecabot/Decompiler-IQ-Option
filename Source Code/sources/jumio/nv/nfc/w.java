package jumio.nv.nfc;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.text.style.ImageSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import at.grabner.circleprogress.TextMode;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.analytics.Screen;
import com.jumio.analytics.UserAction;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.commons.view.SVGImageView;
import com.jumio.core.data.Strings;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.mvp.presenter.RequiresPresenter;
import com.jumio.core.overlay.Overlay;
import com.jumio.nfc.R;
import com.jumio.nv.data.NVStrings;
import com.jumio.nv.enums.EMRTDStatus;
import com.jumio.nv.extraction.NfcController;
import com.jumio.nv.nfc.core.communication.TagAccessSpec;
import com.jumio.nv.view.fragment.INetverifyActivityCallback;
import com.jumio.nv.view.fragment.INetverifyFragmentCallback;
import com.jumio.nv.view.fragment.NVBaseFragment;
import com.jumio.nv.view.fragment.NVScanFragment;
import com.jumio.nv.view.fragment.UploadFragment;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import com.jumio.sdk.gui.CircleView;
import com.jumio.sdk.models.CredentialsModel;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import net.sf.scuba.smartcards.CardServiceException;

@RequiresPresenter(v.class)
/* compiled from: NfcFragment */
public class w extends NVBaseFragment<v> implements OnGlobalLayoutListener, Overlay, INetverifyActivityCallback, u {
    private boolean a = false;
    private at.grabner.circleprogress.c b;
    private RelativeLayout c;
    private ViewFlipper d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private RelativeLayout i;
    private int j;
    private Animator k;
    private Point l;
    private Point m;
    private float[] n;
    private Bitmap o;
    private Bitmap p;

    /* compiled from: NfcFragment */
    class a implements InputFilter {
        private a() {
        }

        /* synthetic */ a(w wVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            StringBuilder stringBuilder = new StringBuilder();
            for (i3 = i; i3 < i2; i3++) {
                char charAt = charSequence.charAt(i3);
                if (Character.isLetterOrDigit(charAt)) {
                    stringBuilder.append(charAt);
                }
            }
            if ((stringBuilder.length() == i2 - i ? 1 : null) != null) {
                return null;
            }
            return stringBuilder.toString();
        }
    }

    /* compiled from: NfcFragment */
    public class b implements OnClickListener {
        private Dialog b;

        public b(Dialog dialog) {
            this.b = dialog;
        }

        public void onClick(View view) {
            JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.ERROR, UserAction.CANCEL, "BACErrorDialog"));
            this.b.dismiss();
            w.this.a = false;
            ((v) w.this.getPresenter()).a(EMRTDStatus.DENIED);
        }
    }

    /* compiled from: NfcFragment */
    public class c implements OnClickListener {
        private final EditText b;
        private final EditText c;
        private final EditText d;
        private Dialog e;

        public c(EditText editText, EditText editText2, EditText editText3, Dialog dialog) {
            this.b = editText;
            this.c = editText2;
            this.d = editText3;
            this.e = dialog;
        }

        public void onClick(View view) {
            if (this.b.getText().length() > 0 && this.c.getText().length() > 0 && this.d.getText().length() > 0) {
                ((v) w.this.getPresenter()).a().setDateOfBirth(a(this.c.getText().toString()));
                ((v) w.this.getPresenter()).a().setIdNumber(this.b.getText().toString());
                ((v) w.this.getPresenter()).a().setDateOfExpiry(a(this.d.getText().toString()));
                ((v) w.this.getPresenter()).a().setShouldDownloadFaceimage(false);
                this.e.dismiss();
                w.this.a = false;
                ((v) w.this.getPresenter()).a(true);
                w.this.g();
            }
        }

        private Date a(String str) {
            try {
                return DateFormat.getDateFormat(w.this.getView().getContext()).parse(str);
            } catch (ParseException unused) {
                return new Date();
            }
        }
    }

    /* compiled from: NfcFragment */
    class d implements OnClickListener {
        private final Calendar b = Calendar.getInstance();
        private OnDateSetListener c;

        public d(OnDateSetListener onDateSetListener, Date date) {
            this.c = onDateSetListener;
            if (date != null) {
                this.b.setTime(date);
            }
        }

        public void onClick(View view) {
            new DatePickerDialog(w.this.getActivity(), this.c, this.b.get(1), this.b.get(2), this.b.get(5)).show();
        }
    }

    /* compiled from: NfcFragment */
    class e implements TextWatcher {
        private TextView b;
        @Nullable
        private TextView c;
        @Nullable
        private View d;

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public e(TextView textView, TextView textView2, @Nullable View view) {
            this.b = textView;
            this.c = textView2;
            this.d = view;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2 = charSequence.toString();
            try {
                java.text.DateFormat dateFormat = DateFormat.getDateFormat(w.this.getActivity().getApplicationContext());
                dateFormat.setLenient(false);
                dateFormat.parse(charSequence2);
                this.b.setError(null);
                if (this.c != null) {
                    this.c.setVisibility(0);
                }
                if (this.d != null) {
                    this.d.setEnabled(true);
                    this.d.setAlpha(1.0f);
                }
            } catch (ParseException unused) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("error parsing date ");
                stringBuilder.append(charSequence2);
                f.b("NfcFragment", stringBuilder.toString());
                this.b.setError("Invalid date");
                if (this.c != null) {
                    this.c.setVisibility(8);
                }
                if (this.d != null) {
                    this.d.setEnabled(false);
                    this.d.setAlpha(0.5f);
                }
            }
        }
    }

    /* compiled from: NfcFragment */
    class f implements TextWatcher {
        private final TextView b;
        private final TextView c;

        public void afterTextChanged(Editable editable) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public f(TextView textView, TextView textView2) {
            this.c = textView;
            this.b = textView2;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            float measureText = this.b.getPaint().measureText(this.b.getText().toString());
            float measureText2 = this.c.getPaint().measureText(this.c.getText().toString());
            i2 = this.c.getWidth();
            if (i2 > 0) {
                if (measureText2 * 1.2f >= ((float) i2) - measureText) {
                    this.b.setVisibility(4);
                } else {
                    this.b.setVisibility(0);
                }
            }
        }
    }

    public void addViews(@NonNull ViewGroup viewGroup) {
    }

    public void calculate(@NonNull DocumentScanMode documentScanMode, @NonNull DocumentFormat documentFormat, Rect rect) {
    }

    public void doDraw(Canvas canvas) {
    }

    public void onError(Throwable th) {
    }

    public void prepareDraw(ScanSide scanSide, boolean z, boolean z2) {
    }

    public void setVisible(int i) {
    }

    public void update(ExtractionUpdate extractionUpdate) {
    }

    public static w a(Bundle bundle) {
        w wVar = new w();
        wVar.setArguments(bundle);
        return wVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            TagAccessSpec tagAccessSpec = new TagAccessSpec();
            tagAccessSpec.setIdNumber(bundle.getString("idnumber", ""));
            tagAccessSpec.setDateOfBirth(new Date(bundle.getLong("dob", 0)));
            tagAccessSpec.setDateOfExpiry(new Date(bundle.getLong("doe", 0)));
            tagAccessSpec.setCountryIso3(bundle.getString("country", ""));
            String string = bundle.getString("scanReference", "");
            ((v) getPresenter()).a(tagAccessSpec);
            ((v) getPresenter()).a(string);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MRZ_");
            stringBuilder.append(string);
            f.a(stringBuilder.toString());
        }
        a(Strings.getExternalString(getActivity(), NVStrings.NFC_TITLE));
        ((INetverifyFragmentCallback) this.callback).registerActivityCallback(this);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = new RelativeLayout(getContext());
        this.c.setLayoutParams(new LayoutParams(-1, -1));
        this.d = new ViewFlipper(getContext());
        this.d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.d.setInAnimation(AnimationUtils.loadAnimation(getContext(), 17432578));
        this.d.setOutAnimation(AnimationUtils.loadAnimation(getContext(), 17432579));
        this.c.addView(this.d);
        return this.c;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.c.getViewTreeObserver().addOnGlobalLayoutListener(this);
        g();
    }

    public void onResume() {
        super.onResume();
        boolean equals = ((v) getPresenter()).a().getCountryIso3().toLowerCase().equals("usa");
        if (this.o == null) {
            this.o = BitmapFactory.decodeResource(getResources(), equals ? R.drawable.nv_nfc_phone_usa : R.drawable.nv_nfc_phone_row);
        }
        if (this.p == null) {
            if (((v) getPresenter()).b() == DocumentScanMode.MRP) {
                this.p = BitmapFactory.decodeResource(getResources(), equals ? R.drawable.nv_nfc_passport_usa : R.drawable.nv_nfc_passport_row);
            } else {
                this.p = BitmapFactory.decodeResource(getResources(), R.drawable.nv_nfc_id);
            }
        }
        this.e.setImageBitmap(this.p);
        this.f.setImageBitmap(this.o);
        AnimatorSet animatorSet = new AnimatorSet();
        Animator ofFloat = ObjectAnimator.ofFloat(this.d.getChildAt(0).findViewById(R.id.help_background), "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        Animator ofFloat2 = ObjectAnimator.ofFloat(this.d.getChildAt(0).findViewById(R.id.overall_container), "alpha", new float[]{0.0f, 1.0f});
        ofFloat2.setStartDelay(200);
        ofFloat2.setDuration(500);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.e != null) {
            this.e.setImageBitmap(null);
        }
        if (this.f != null) {
            this.f.setImageBitmap(null);
        }
        if (this.p != null) {
            this.p.recycle();
            this.p = null;
        }
        if (this.o != null) {
            this.o.recycle();
            this.o = null;
        }
        if (this.k != null) {
            this.k.cancel();
            this.k.removeAllListeners();
            this.k = null;
        }
        if (this.c.getViewTreeObserver() != null) {
            this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        System.gc();
    }

    public void handleOrientationChange(boolean z, boolean z2) {
        int i;
        if (!z2 || this.d == null) {
            i = 0;
        } else {
            i = this.d.getDisplayedChild();
            this.d.removeAllViews();
        }
        LayoutInflater from = LayoutInflater.from(getContext());
        TypedValue typedValue = new TypedValue();
        Theme theme = getActivity().getTheme();
        RelativeLayout relativeLayout = (RelativeLayout) from.inflate(z ? R.layout.nv_helpview_portrait : R.layout.nv_helpview_land, null);
        int dpToPx = ScreenUtil.dpToPx(getContext(), 45);
        relativeLayout.findViewById(R.id.overall_container).setPadding(dpToPx, 0, dpToPx, 0);
        relativeLayout.findViewById(R.id.helpview_progress_info).setVisibility(4);
        ((TextView) relativeLayout.findViewById(R.id.helpview_doctype_title)).setText(Html.fromHtml(Strings.getExternalString(getContext(), NVStrings.NFC_HEADER_START)));
        theme.resolveAttribute(R.attr.netverify_helpInstructions, typedValue, true);
        ((TextView) relativeLayout.findViewById(R.id.helpview_scan_instructions)).setText(a(Strings.getExternalString(getContext(), NVStrings.NFC_DESCRIPTION_START), "${icon}", R.drawable.nv_nfc_epassport_white, typedValue.data));
        ((TextView) relativeLayout.findViewById(R.id.helpview_scan_instructions)).setContentDescription(getString(R.string.netverify_accessibility_nfc_description_start));
        Button button = (Button) relativeLayout.findViewById(R.id.helpview_fallback_button);
        button.setText(Strings.getExternalString(getContext(), NVStrings.NFC_BUTTON_NO_NFC_SYMBOL));
        theme.resolveAttribute(R.attr.netverify_helpFallback, typedValue, true);
        button.getBackground().setColorFilter(typedValue.data, Mode.MULTIPLY);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.SCAN, UserAction.NFC_NO_EMRTD));
                ((v) w.this.getPresenter()).a(EMRTDStatus.NOT_PERFORMED);
            }
        });
        int dpToPx2 = ScreenUtil.dpToPx(getContext(), 190);
        int dpToPx3 = ScreenUtil.dpToPx(getContext(), 60);
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.doctype_container);
        linearLayout.setContentDescription(getString(R.string.netverify_accessibility_nfc_description_start));
        View relativeLayout2 = new RelativeLayout(getContext());
        relativeLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, dpToPx3 + dpToPx2));
        this.e = new ImageView(getContext());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dpToPx2);
        layoutParams.addRule(12);
        this.e.setLayoutParams(layoutParams);
        this.e.setAdjustViewBounds(true);
        this.e.setId(R.id.passport_imageview);
        this.e.setImageBitmap(this.p);
        relativeLayout2.addView(this.e);
        this.f = new ImageView(getContext());
        layoutParams = new RelativeLayout.LayoutParams(-1, dpToPx2);
        layoutParams.addRule(5, R.id.passport_imageview);
        layoutParams.addRule(6, R.id.passport_imageview);
        layoutParams.addRule(7, R.id.passport_imageview);
        layoutParams.addRule(8, R.id.passport_imageview);
        this.f.setLayoutParams(layoutParams);
        this.f.setAdjustViewBounds(true);
        this.f.setId(R.id.passport_phone_imageview);
        this.f.setImageBitmap(this.o);
        relativeLayout2.addView(this.f);
        linearLayout.addView(relativeLayout2);
        if (!z2) {
            relativeLayout.findViewById(R.id.help_background).setAlpha(0.0f);
            relativeLayout.findViewById(R.id.overall_container).setAlpha(0.0f);
        }
        this.d.addView(relativeLayout);
        RelativeLayout relativeLayout3 = (RelativeLayout) from.inflate(z ? R.layout.nv_helpview_portrait : R.layout.nv_helpview_land, null);
        relativeLayout3.findViewById(R.id.helpview_progress_info).setVisibility(4);
        relativeLayout3.findViewById(R.id.helpview_fallback_button).setVisibility(4);
        this.g = (TextView) relativeLayout3.findViewById(R.id.helpview_doctype_title);
        this.g.setText(Html.fromHtml(Strings.getExternalString(getContext(), NVStrings.NFC_HEADER_DOWNLOAD)));
        this.h = (TextView) relativeLayout3.findViewById(R.id.helpview_scan_instructions);
        this.h.setText(Strings.getExternalString(getContext(), NVStrings.NFC_DESCRIPTION_DOWNLOAD));
        TypedValue typedValue2 = new TypedValue();
        theme.resolveAttribute(R.attr.netverify_helpTitle, typedValue2, true);
        int i2 = typedValue2.data;
        TypedValue typedValue3 = new TypedValue();
        theme.resolveAttribute(R.attr.netverify_helpBackground, typedValue3, true);
        int i3 = typedValue3.data;
        LinearLayout linearLayout2 = (LinearLayout) relativeLayout3.findViewById(R.id.doctype_container);
        int dpToPx4 = ScreenUtil.dpToPx(getContext(), 40);
        dpToPx = ScreenUtil.dpToPx(getContext(), 6);
        int spToPx = (int) ScreenUtil.spToPx(getContext(), 45.0f);
        this.b = new at.grabner.circleprogress.c(getContext());
        this.b.setLayoutParams(new RelativeLayout.LayoutParams(dpToPx2, dpToPx2));
        this.b.setBarColor(i2);
        this.b.setBarWidth(dpToPx);
        this.b.setBlockCount(1);
        this.b.setContourSize(0.0f);
        this.b.setMaxValue(7.0f);
        this.b.setRimColor(0);
        this.b.setRimWidth(dpToPx);
        this.b.setTextColor(i2);
        this.b.setTextSize(spToPx);
        this.b.setUnit("%");
        this.b.setUnitColor(i2);
        this.b.setUnitSize(spToPx);
        this.b.setValue(0.0f);
        this.b.setShowUnit(true);
        this.b.setTextMode(TextMode.PERCENT);
        linearLayout2.addView(this.b);
        this.i = new RelativeLayout(getContext());
        this.i.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        View circleView = new CircleView(getContext());
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dpToPx2, dpToPx2);
        layoutParams2.addRule(14);
        circleView.setLayoutParams(layoutParams2);
        circleView.setPadding(0, 0, 0, 0);
        circleView.setFillColor(i2);
        this.i.addView(circleView);
        View sVGImageView = new SVGImageView(getContext());
        layoutParams = new RelativeLayout.LayoutParams(dpToPx2, dpToPx2);
        layoutParams.addRule(14);
        sVGImageView.setLayoutParams(layoutParams);
        sVGImageView.setPadding(dpToPx4, dpToPx4, dpToPx4, dpToPx4);
        sVGImageView.setPaintColor(i3);
        sVGImageView.setPathString("M226.749912,330.55 L166.199912,270 L146.016579,290.183333 L226.749912,370.916667 L399.749912,197.916667 L379.566579,177.733333 L226.749912,330.55 Z");
        this.i.addView(sVGImageView);
        this.i.setVisibility(8);
        linearLayout2.addView(this.i);
        this.d.addView(relativeLayout3);
        if (z2 && i != 0) {
            this.d.setDisplayedChild(i);
        }
    }

    public CredentialsModel a() {
        return ((INetverifyFragmentCallback) this.callback).getCredentials();
    }

    public NfcController b() {
        return ((INetverifyFragmentCallback) this.callback).getNfcController();
    }

    public void a(boolean z) {
        ((v) getPresenter()).a(false);
        ((INetverifyFragmentCallback) this.callback).startFragment(z ? new UploadFragment() : new NVScanFragment(), true, 0, R.animator.nv_fade_out);
    }

    public Rect getOverlayBounds() {
        return new Rect();
    }

    public void onGlobalLayout() {
        if (this.l == null) {
            this.l = new Point();
            this.l.x = (int) (this.e.getX() + (((float) this.e.getWidth()) / 2.0f));
            this.l.y = (int) (this.e.getY() + (((float) this.e.getHeight()) / 2.0f));
        }
        if (this.m == null) {
            this.m = new Point();
            this.m.x = (int) (this.f.getX() + (((float) this.f.getWidth()) / 2.0f));
            this.m.y = (int) (this.f.getY() + (((float) this.f.getHeight()) / 2.0f));
        }
        if (this.j == 0) {
            this.j = ScreenUtil.dpToPx(getActivity(), 50);
        }
        if (this.n == null) {
            this.n = new float[]{this.f.getY() - (((float) this.j) * 0.9f), this.f.getY()};
        }
        if (this.k != null) {
            this.k.cancel();
        }
        if (this.j > 0) {
            this.k = a(this.f, this.n);
            this.k.start();
        }
    }

    private SpannableString a(String str, String str2, int i, int i2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return new SpannableString(str);
        }
        int spToPx = (int) ScreenUtil.spToPx(getContext(), 14.0f);
        float f = ((float) spToPx) * 1.8091873f;
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = getResources().getDrawable(i);
        drawable.mutate();
        if (drawable != null) {
            drawable.setBounds(0, 0, (int) f, spToPx);
            drawable.setColorFilter(i2, Mode.SRC_ATOP);
            spannableString.setSpan(new ImageSpan(drawable, 1), indexOf, str2.length() + indexOf, 33);
        }
        return spannableString;
    }

    private Animator a(View view, float... fArr) {
        view.clearAnimation();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "y", fArr);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(1000);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new AnimatorListener() {
            public boolean a;

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                if (!this.a) {
                    animator.setStartDelay(2000);
                    animator.start();
                }
            }

            public void onAnimationCancel(Animator animator) {
                this.a = true;
            }
        });
        return animatorSet;
    }

    public void c() {
        if (this.d.getDisplayedChild() == 0) {
            this.d.showNext();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("access view class ");
        stringBuilder.append(hashCode());
        Log.d("NfcFragment", stringBuilder.toString());
        this.i.setVisibility(8);
        this.b.setValue(0.0f);
        this.b.setVisibility(0);
        this.b.invalidate();
        this.g.setText(Html.fromHtml(Strings.getExternalString(getContext(), NVStrings.NFC_HEADER_DOWNLOAD)));
        this.h.setText(Strings.getExternalString(getContext(), NVStrings.NFC_DESCRIPTION_DOWNLOAD));
    }

    public void a(int i) {
        this.b.setValueAnimated((float) i);
    }

    public void d() {
        this.b.setVisibility(8);
        this.i.setVisibility(0);
        this.g.setText(Html.fromHtml(Strings.getExternalString(getContext(), NVStrings.NFC_HEADER_FINISH)));
        this.h.setText("");
    }

    public void a(o oVar) {
        Dialog f;
        Object obj;
        f.a("NfcFragment", "showing dialog");
        ((v) getPresenter()).a(false);
        if (oVar.a() == p.BAC_CHECK && (oVar.c() instanceof CardServiceException)) {
            f = f();
            obj = "NFC BAC authentication failed";
        } else {
            Builder e = e();
            f = e != null ? e.create() : null;
            obj = "NFC reading error";
        }
        if (f != null) {
            f.setCancelable(false);
            f.show();
        }
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("retryPossible", Boolean.valueOf(true));
        metaInfo.put("message", obj);
        JumioAnalytics.add(MobileEvents.pageView(JumioAnalytics.getSessionId(), Screen.ERROR, metaInfo));
        this.d.setDisplayedChild(0);
    }

    private Builder e() {
        if (this.a) {
            return null;
        }
        this.a = true;
        Context activity = getActivity();
        return new Builder(activity, 5).setTitle(Strings.getExternalString(activity, NVStrings.NFC_GENERAL_ERROR_DIALOG_TITLE)).setMessage(Strings.getExternalString(activity, NVStrings.NFC_GENERAL_ERROR_DIALOG_TEXT)).setPositiveButton(Strings.getExternalString(activity, "button_retry"), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                w.this.g();
                w.this.a = false;
                w.this.d.showPrevious();
                ((v) w.this.getPresenter()).a(true);
                dialogInterface.dismiss();
            }
        }).setNegativeButton(Strings.getExternalString(activity, "button_cancel"), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.ERROR, UserAction.CANCEL));
                w.this.a = false;
                dialogInterface.dismiss();
                ((v) w.this.getPresenter()).a(EMRTDStatus.NOT_PERFORMED);
            }
        }).setIcon(17301543);
    }

    private Dialog f() {
        if (this.a) {
            return null;
        }
        Dialog dialog;
        this.a = true;
        if (VERSION.SDK_INT >= 21) {
            dialog = new Dialog(getActivity(), 16974394);
        } else {
            dialog = new Dialog(getActivity());
        }
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle(Strings.getExternalString(getActivity(), NVStrings.NFC_BAC_DIALOG_TITLE));
        dialog.setContentView(R.layout.nv_nfc_bac_entry_dialog);
        EditText editText = (EditText) dialog.findViewById(R.id.passportNumberTextfield);
        final EditText editText2 = (EditText) dialog.findViewById(R.id.dobEntryField);
        final EditText editText3 = (EditText) dialog.findViewById(R.id.doeEntryField);
        Context activity = getActivity();
        TextView textView = (TextView) dialog.findViewById(R.id.ppNumberHint);
        TextView textView2 = (TextView) dialog.findViewById(R.id.hintDob);
        TextView textView3 = (TextView) dialog.findViewById(R.id.hintDoe);
        textView.setText(Strings.getExternalString(activity, NVStrings.NFC_BAC_DIALOG_ID_NUMBER));
        textView2.setText(Strings.getExternalString(activity, NVStrings.NFC_BAC_DIALOG_DATE_OF_BIRTH));
        textView3.setText(Strings.getExternalString(activity, NVStrings.NFC_BAC_DIALOG_DATE_OF_EXPIRY));
        editText.addTextChangedListener(new f(editText, textView));
        List arrayList = new ArrayList(Arrays.asList(editText.getFilters()));
        arrayList.add(0, new AllCaps());
        arrayList.add(1, new a(this, null));
        editText.setFilters((InputFilter[]) arrayList.toArray(new InputFilter[arrayList.size()]));
        editText2.addTextChangedListener(new f(editText2, textView2));
        View findViewById = dialog.findViewById(R.id.bacEntryOkButton);
        editText2.addTextChangedListener(new e(editText2, textView2, findViewById));
        editText2.setKeyListener(null);
        TagAccessSpec a = ((v) getPresenter()).a();
        editText2.setOnClickListener(new d(new OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Calendar instance = Calendar.getInstance();
                instance.set(1, i);
                instance.set(2, i2);
                instance.set(5, i3);
                editText2.setText(w.this.a(instance.getTime()));
            }
        }, a.getDateOfBirth()));
        editText3.addTextChangedListener(new f(editText3, textView3));
        editText3.addTextChangedListener(new e(editText3, textView3, findViewById));
        editText3.setKeyListener(null);
        editText3.setOnClickListener(new d(new OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Calendar instance = Calendar.getInstance();
                instance.set(1, i);
                instance.set(2, i2);
                instance.set(5, i3);
                editText3.setText(w.this.a(instance.getTime()));
            }
        }, a.getDateOfExpiry()));
        editText.setText(a.getIdNumber());
        editText2.setText(a(a.getDateOfBirth()));
        editText3.setText(a(a.getDateOfExpiry()));
        TextView textView4 = (TextView) dialog.findViewById(16908310);
        if (textView4 != null) {
            textView4.setSingleLine(false);
        }
        ((TextView) dialog.findViewById(R.id.content_description)).setText(Strings.getExternalString(getActivity(), NVStrings.NFC_BAC_DIALOG_TEXT));
        ((Button) findViewById).setText(Strings.getExternalString(getActivity(), "button_retry"));
        findViewById.setOnClickListener(new c(editText, editText2, editText3, dialog));
        dialog.findViewById(R.id.bacEntryCancelButton).setOnClickListener(new b(dialog));
        return dialog;
    }

    private String a(Date date) {
        return DateFormat.getDateFormat(getActivity().getApplicationContext()).format(date);
    }

    private void g() {
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put(Param.TYPE, "NFC");
        JumioAnalytics.add(MobileEvents.pageView(JumioAnalytics.getSessionId(), Screen.SCAN, metaInfo));
    }
}
