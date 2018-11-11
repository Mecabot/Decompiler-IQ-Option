package com.iqoption.kyc.fragment.jumio;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.d.mp;
import com.iqoption.dto.entity.result.ProofDocsResult;
import com.iqoption.kyc.a.d;
import com.iqoption.kyc.c;
import com.iqoption.kyc.i;
import com.iqoption.util.ac;
import com.iqoption.util.ag;
import com.iqoption.util.am;
import com.iqoption.x.R;

/* compiled from: KycDocumentsUploadFragment */
public class e extends Fragment implements com.iqoption.kyc.a.b {
    public static final String TAG = "com.iqoption.kyc.fragment.jumio.e";
    private boolean aMv;
    private am adG;
    private com.iqoption.util.am.a cKG = new com.iqoption.util.am.a() {
        public void cp(boolean z) {
            if (z && e.this.isAdded() && ac.c(e.this.getFragmentManager(), e.TAG)) {
                am.n(e.this.zzakw());
            }
        }
    };
    private OnBackStackChangedListener cKO;
    @Nullable
    private volatile ProofDocsResult cLe;
    private boolean cLf;
    private a cLp;
    private mp cLq;
    private boolean cLr;
    private boolean csK;
    private boolean isInProgress;

    /* compiled from: KycDocumentsUploadFragment */
    public interface a {
        s<?> apA();

        s<?> apB();

        void apC();

        s<?> apw();

        s<?> apx();

        s<?> apy();

        s<?> apz();
    }

    /* compiled from: KycDocumentsUploadFragment */
    private static class b extends com.iqoption.system.c.b<e, Object> {
        private final Boolean cLv;

        public b(e eVar) {
            this(eVar, false);
        }

        public b(e eVar, boolean z) {
            super(eVar, Object.class);
            f(ac.dvn);
            this.cLv = Boolean.valueOf(z);
        }

        /* renamed from: a */
        public void z(@NonNull e eVar, Object obj) {
            super.z(eVar, obj);
            if (this.cLv == null) {
                eVar.dK(false);
            } else {
                eVar.f(false, this.cLv.booleanValue());
            }
        }

        /* renamed from: a */
        public void c(@NonNull e eVar, Throwable th) {
            super.c(eVar, th);
            if (this.cLv == null) {
                eVar.dK(false);
            } else {
                eVar.f(false, this.cLv.booleanValue());
            }
        }
    }

    @NonNull
    public String apR() {
        return "IdentityProving";
    }

    @NonNull
    public String apS() {
        return "DocumentsUploading";
    }

    public static e a(ProofDocsResult proofDocsResult, boolean z, boolean z2) {
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_PROOF_DOCS", proofDocsResult);
        bundle.putBoolean("KEY_IS_SHOW_CONTINUE_LATER", z);
        bundle.putBoolean("KEY_IS_REGULATED", z2);
        eVar.setArguments(bundle);
        return eVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.cLe = (ProofDocsResult) bundle.getParcelable("KEY_PROOF_DOCS");
            this.cLr = bundle.getBoolean("KEY_IS_SHOW_CONTINUE_LATER");
            this.aMv = bundle.getBoolean("KEY_IS_REGULATED", true);
            return;
        }
        this.aMv = true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = 0;
        this.cLq = (mp) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_kyc_documents_upload, viewGroup, false);
        this.csK = ((Integer) com.iqoption.app.a.aL(getContext()).akx.getValue()).intValue() == 0;
        setHasOptionsMenu(this.cLr);
        this.cLq.bxZ.setVisibility(this.csK ? 8 : 0);
        this.cLq.byb.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (!e.this.isInProgress) {
                    Object obj = (view.getTag(R.id.isDeclined) == null || !((Boolean) view.getTag(R.id.isDeclined)).booleanValue()) ? null : 1;
                    e.this.cLf = true;
                    if (obj != null) {
                        e.this.f(true, true);
                        o.a(e.this.cLp.apy(), new b(e.this, true), com.iqoption.core.d.a.aSe);
                        return;
                    }
                    e.this.f(true, true);
                    o.a(e.this.cLp.apw(), new b(e.this, true), com.iqoption.core.d.a.aSe);
                }
            }
        });
        this.cLq.bxW.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                if (!e.this.isInProgress) {
                    e.this.cLf = true;
                    Object obj = (view.getTag(R.id.isDeclined) == null || !((Boolean) view.getTag(R.id.isDeclined)).booleanValue()) ? null : 1;
                    if (obj != null) {
                        e.this.f(true, false);
                        o.a(e.this.cLp.apz(), new b(e.this, false), com.iqoption.core.d.a.aSe);
                        return;
                    }
                    e.this.f(true, false);
                    o.a(e.this.cLp.apx(), new b(e.this, false), com.iqoption.core.d.a.aSe);
                }
            }
        });
        LinearLayout linearLayout = this.cLq.bxW;
        if (!this.aMv) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        this.cLq.bxZ.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                e.this.cLf = false;
                com.iqoption.kyc.a.a.a(e.this.getContext(), true, e.this.apR(), e.this.apS(), true);
                o.a(e.this.cLp.apB(), new b(e.this), com.iqoption.core.d.a.aSe);
            }
        });
        ImageSpan imageSpan = new ImageSpan(getContext(), R.drawable.ic_kyc_account_verification_info);
        ImageSpan imageSpan2 = new ImageSpan(getContext(), R.drawable.ic_kyc_account_verification_info_selected);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.cLq.byf.getText().toString());
        stringBuilder.append("   ");
        String stringBuilder2 = stringBuilder.toString();
        final CharSequence spannableString = new SpannableString(stringBuilder2);
        final SpannableString spannableString2 = new SpannableString(stringBuilder2);
        spannableString.setSpan(imageSpan, stringBuilder2.length() - 1, stringBuilder2.length(), 17);
        spannableString2.setSpan(imageSpan2, stringBuilder2.length() - 1, stringBuilder2.length(), 17);
        this.cLq.byf.setText(spannableString);
        this.cLq.byf.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 3) {
                    switch (action) {
                        case 0:
                            if (!e.this.isInProgress) {
                                e.this.cLq.byf.setText(spannableString2);
                                e.this.cLq.byf.setSelected(true);
                            }
                            return true;
                        case 1:
                            break;
                        default:
                            return false;
                    }
                }
                if (!e.this.isInProgress) {
                    e.this.cLq.byf.setText(spannableString);
                    e.this.cLq.byf.setSelected(false);
                    e.this.cLp.apC();
                }
                return true;
            }
        });
        apX();
        this.cKO = new d(this, getContext(), com.iqoption.kyc.a.a.apP(), getFragmentManager(), new c(getContext()).Dh(), apR(), apS(), TAG) {
            final /* synthetic */ e cLs;

            protected void apV() {
                super.apV();
                this.cLs.cLf = false;
                this.cLs.apX();
                if (this.cLs.cLe != null) {
                    this.cLs.b(this.cLs.cLe);
                }
            }
        };
        getFragmentManager().addOnBackStackChangedListener(this.cKO);
        this.adG = new am(zzakw());
        if (this.cLe != null) {
            b(this.cLe);
        } else {
            dK(true);
        }
        return this.cLq.getRoot();
    }

    public boolean apT() {
        return this.cLf;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.kyc_continue_later_documents_menu, menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!ac.c(getFragmentManager(), TAG) || menuItem.getItemId() != R.id.action_continue_later_documents) {
            return super.onOptionsItemSelected(menuItem);
        }
        com.iqoption.kyc.a.a.a(getContext(), true, apR(), apS(), true);
        dK(true);
        ag.b(this.cLp.apA(), new b(this));
        return true;
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem findItem = menu.findItem(R.id.action_continue_later_documents);
        if (findItem != null) {
            findItem.setEnabled(this.isInProgress ^ 1);
            findItem.setVisible(ac.c(getFragmentManager(), TAG));
        }
    }

    private void apX() {
        i.a((AppCompatActivity) zzakw(), this.cLq.bxz.toolbar);
        zzakw().invalidateOptionsMenu();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.cLp = (a) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnFragmentInteractionListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onStart() {
        super.onStart();
        am.a(this.cKG);
    }

    public void onStop() {
        super.onStop();
        am.b(this.cKG);
    }

    public void onDetach() {
        super.onDetach();
        this.cLp = null;
    }

    public void onDestroyView() {
        com.iqoption.core.i.d(TAG, "onDestroyView");
        getFragmentManager().removeOnBackStackChangedListener(this.cKO);
        super.onDestroyView();
    }

    public void f(boolean z, boolean z2) {
        this.isInProgress = z;
        View view = z2 ? this.cLq.byc : this.cLq.bxX;
        View view2 = z2 ? this.cLq.byb : this.cLq.bxW;
        View view3 = z2 ? this.cLq.bxW : this.cLq.byb;
        if (z) {
            view3.setEnabled(false);
            this.cLq.bxZ.setEnabled(false);
            view.setVisibility(0);
            view.setAlpha(1.0f);
            view2.animate().alpha(0.2f).setInterpolator(new DecelerateInterpolator());
        } else {
            view3.setEnabled(true);
            this.cLq.bxZ.setEnabled(true);
            view.animate().alpha(0.0f).setInterpolator(new DecelerateInterpolator()).setListener(new com.iqoption.view.a.a.c(view));
            view2.animate().alpha(1.0f).setInterpolator(new AccelerateInterpolator());
        }
        zzakw().invalidateOptionsMenu();
    }

    public void dK(boolean z) {
        this.isInProgress = z;
        if (z) {
            this.cLq.bxZ.setEnabled(false);
            this.cLq.byc.setVisibility(0);
            this.cLq.byc.setAlpha(1.0f);
            this.cLq.bxX.setVisibility(0);
            this.cLq.bxX.setAlpha(1.0f);
            this.cLq.byb.animate().alpha(0.2f).setInterpolator(new DecelerateInterpolator());
            this.cLq.bxW.animate().alpha(0.2f).setInterpolator(new DecelerateInterpolator());
        } else {
            this.cLq.bxZ.setEnabled(true);
            this.cLq.byc.animate().alpha(0.0f).setInterpolator(new DecelerateInterpolator()).setListener(new com.iqoption.view.a.a.c(this.cLq.byc));
            this.cLq.bxX.animate().alpha(0.0f).setInterpolator(new DecelerateInterpolator()).setListener(new com.iqoption.view.a.a.c(this.cLq.bxX));
            this.cLq.byb.animate().alpha(1.0f).setInterpolator(new AccelerateInterpolator());
            this.cLq.bxW.animate().alpha(1.0f).setInterpolator(new AccelerateInterpolator());
        }
        zzakw().invalidateOptionsMenu();
    }

    public void b(ProofDocsResult proofDocsResult) {
        this.cLe = proofDocsResult;
        this.cLq.bxV.setVisibility(0);
        int i = 1;
        a(proofDocsResult, this.cLq.byb, this.cLq.byd, 1);
        a(proofDocsResult, this.cLq.bxW, this.cLq.bxY, 2);
        Object obj = (proofDocsResult.isVerified(1) || proofDocsResult.isUnderReview(1)) ? 1 : null;
        if (!(proofDocsResult.isVerified(2) || proofDocsResult.isUnderReview(2))) {
            i = 0;
        }
        if ((obj == null || i == 0) && !this.csK) {
            this.cLq.bxZ.setVisibility(0);
        } else {
            this.cLq.bxZ.setVisibility(8);
        }
    }

    private void a(ProofDocsResult proofDocsResult, View view, TextView textView, int i) {
        if (proofDocsResult.isVerified(i)) {
            textView.setText(R.string.kyc_doc_verified);
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_kyc_document_success, 0, 0, 0);
            textView.setVisibility(0);
            view.setEnabled(false);
            view.setTag(R.id.isDeclined, Boolean.valueOf(false));
            if (i == 2) {
                this.cLq.bxV.setVisibility(8);
            }
        } else if (proofDocsResult.isUnderReview(i)) {
            textView.setText(R.string.kyc_doc_under_review);
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_kyc_time, 0, 0, 0);
            textView.setVisibility(0);
            view.setEnabled(false);
            view.setTag(R.id.isDeclined, Boolean.valueOf(false));
            if (i == 2) {
                this.cLq.bxV.setVisibility(8);
            }
        } else if (proofDocsResult.isDeclined(i)) {
            textView.setText(R.string.declined);
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_kyc_document_error, 0, 0, 0);
            textView.setVisibility(0);
            view.setEnabled(true);
            view.setTag(R.id.isDeclined, Boolean.valueOf(true));
        } else {
            textView.setVisibility(8);
            view.setEnabled(true);
            view.setTag(R.id.isDeclined, Boolean.valueOf(false));
        }
    }
}
