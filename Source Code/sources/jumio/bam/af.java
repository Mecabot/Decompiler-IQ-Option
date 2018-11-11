package jumio.bam;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.jumio.bam.R;
import com.jumio.commons.view.CompatibilityLayer;
import com.jumio.core.data.Strings;
import com.jumio.core.mvp.presenter.RequiresPresenter;
import com.jumio.sdk.exception.JumioError;
import com.jumio.sdk.exception.JumioError.ErrorInterface;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.models.CredentialsModel;
import com.jumio.sdk.view.fragment.BaseScanFragment;
import java.nio.CharBuffer;

@RequiresPresenter(z.class)
/* compiled from: BamScanFragment */
public class af extends BaseScanFragment<z, ah> implements ag, ai, jumio.bam.q.a {
    protected boolean a = false;
    private u b = null;
    private q c = null;
    private MenuItem d;
    private ConditionVariable e = new ConditionVariable(false);

    /* compiled from: BamScanFragment */
    class a implements ErrorInterface {
        private a() {
        }

        /* synthetic */ a(af afVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public String getCaption() {
            return Strings.getExternalString(af.this.getContext(), "error_view_button_cancel");
        }

        public void getAction() {
            ((z) af.this.getPresenter()).a(true, false);
        }

        public int getColorID() {
            return R.attr.bam_dialogNegativeButtonTextColor;
        }
    }

    /* compiled from: BamScanFragment */
    class b implements ErrorInterface {
        private b() {
        }

        /* synthetic */ b(af afVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public String getCaption() {
            return Strings.getExternalString(af.this.getContext(), "error_view_button_try_again");
        }

        public void getAction() {
            af.this.a = false;
            ((z) af.this.getPresenter()).c();
        }

        public int getColorID() {
            return R.attr.bam_dialogPositiveButtonTextColor;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((ah) this.callback).registerActivityCallback(this);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ((ah) this.callback).setUiAutomationId(R.string.bam_automation_scan_card);
        this.b = new u(getActivity());
        this.b.setVisibility(4);
        this.mFragmentRootView.addView(this.b);
        this.c = new q(getActivity(), this);
        this.c.setVisibility(4);
        this.c.setLayoutParams(new LayoutParams(-1, -1));
        View scrollView = new ScrollView(getActivity());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(3, R.id.topInfoBar);
        scrollView.setLayoutParams(layoutParams);
        scrollView.addView(this.c);
        scrollView.setFillViewport(true);
        scrollView.setImportantForAccessibility(2);
        this.mFragmentRootView.setImportantForAccessibility(1);
        this.mFragmentRootView.setContentDescription(Strings.getExternalString(getContext(), "scan_area_present_your_card_number"));
        this.mFragmentRootView.addView(scrollView);
        a(Strings.getExternalString(getActivity(), "activity_title_scan"));
        this.mFragmentRootView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                af.this.mFragmentRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                af.this.e.open();
            }
        });
        return onCreateView;
    }

    public void onLayoutRotated(boolean z) {
        super.onLayoutRotated(z);
        if (this.overlayView != null) {
            this.overlayView.requestLayout();
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(com.jumio.core.R.attr.colorControlNormal, typedValue, true);
        Drawable drawable = CompatibilityLayer.getDrawable(getResources(), R.drawable.bam_ic_check);
        drawable.setColorFilter(typedValue.data, Mode.SRC_ATOP);
        this.d = menu.add(3, 3, 3, "");
        this.d.setEnabled(false);
        this.d.setVisible(false);
        this.d.setShowAsAction(2);
        this.d.setTitle(R.string.bam_accessibility_confirm_values);
        this.d.setIcon(drawable);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 3) {
            this.c.a(((z) getPresenter()).a());
            ((z) getPresenter()).a(false, false);
            return true;
        } else if (itemId != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            ((z) getPresenter()).a(true, false);
            return true;
        }
    }

    public boolean onBackButtonPressed() {
        ((z) getPresenter()).a(true, false);
        return true;
    }

    public void c() {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                af.this.a(false);
                af.this.handleControls(false, false);
                af.this.a = true;
            }
        });
    }

    protected void handleControls(boolean z, boolean z2) {
        if (!this.a) {
            super.handleControls(z, z2);
        }
    }

    public void updateBranding(boolean z) {
        this.e.block();
        super.updateBranding(z);
    }

    public CredentialsModel d() {
        return ((ah) this.callback).getCredentials();
    }

    public boolean a(y yVar, x xVar) {
        return (xVar.a() && xVar.b()) || xVar.c() || xVar.n().size() != 0 || (xVar.e() && xVar.d());
    }

    public void b(y yVar, x xVar) {
        u uVar;
        StringBuilder stringBuilder;
        boolean z = xVar.a() && xVar.b();
        ((ah) this.callback).setUiAutomationId(R.string.bam_automation_additional_info);
        this.c.setVisibility(0);
        handleControls(false, false);
        this.mFragmentRootView.removeView(this.textureView);
        this.mFragmentRootView.removeView(this.overlayView);
        this.mFragmentRootView.removeView(this.flashSwitcher);
        this.mFragmentRootView.removeView(this.cameraSwitcher);
        this.mFragmentRootView.setContentDescription("");
        this.mFragmentRootView.setImportantForAccessibility(2);
        this.b.setCreditCardNumber(CharBuffer.wrap(yVar.a(xVar.h())));
        if (!(yVar.getCardExpiryDateMonth().length == 0 || yVar.getCardExpiryDateYear().length == 0 || z)) {
            uVar = this.b;
            stringBuilder = new StringBuilder();
            stringBuilder.append(CharBuffer.wrap(yVar.getCardExpiryDateMonth()));
            stringBuilder.append(" / ");
            stringBuilder.append(CharBuffer.wrap(yVar.getCardExpiryDateYear()));
            uVar.setExpiryDate(stringBuilder.toString());
        }
        if (yVar.isCardAccountNumberValid() && yVar.isCardSortCodeValid() && yVar.getCardSortCode().length != 0 && yVar.getCardAccountNumber().length != 0) {
            uVar = this.b;
            stringBuilder = new StringBuilder();
            stringBuilder.append(CharBuffer.wrap(yVar.getCardSortCode()));
            stringBuilder.append(" ");
            stringBuilder.append(CharBuffer.wrap(yVar.getCardAccountNumber()));
            uVar.setSortCodeAndAccountNumber(stringBuilder.toString());
        }
        this.b.a(yVar.getCardType(), getResources());
        this.b.setVisibility(0);
        q qVar = this.c;
        boolean c = xVar.c();
        boolean z2 = xVar.d() && xVar.e();
        qVar.a(z, c, z2, xVar.n(), null, true);
        if (xVar.d()) {
            CharSequence wrap = CharBuffer.wrap(yVar.getCardHolderName());
            if (xVar.e() && wrap.length() != 0) {
                this.c.a(wrap);
            } else if (!(wrap.length() == 0 || wrap.toString().isEmpty())) {
                this.b.setCardHolderName(wrap);
            }
        }
        if (z) {
            this.c.a(yVar.getCardExpiryDateMonth(), yVar.getCardExpiryDateYear());
        }
        if (xVar.c()) {
            this.c.a(yVar.getCardType());
        }
        a(Strings.getExternalString(getActivity(), "activity_title_additional_info"));
    }

    public void onError(Throwable th) {
        if (th instanceof JumioException) {
            JumioError.getAlertDialogBuilder(getContext(), (JumioException) th, new b(this, null), new a(this, null));
        }
    }

    public void a() {
        ((z) getPresenter()).a(true, true);
    }

    public void a(boolean z) {
        if (this.d != null) {
            this.d.setVisible(z);
            this.d.setEnabled(z);
        }
    }
}
