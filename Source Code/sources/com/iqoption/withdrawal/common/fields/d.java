package com.iqoption.withdrawal.common.fields;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.transition.Fade;
import android.support.transition.TransitionManager;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.d.amk;
import com.iqoption.d.amr;
import com.iqoption.d.um;
import com.iqoption.microservice.withdraw.response.PayoutFieldType;
import com.iqoption.microservice.withdraw.response.WithdrawMethodType;
import com.iqoption.microservice.withdraw.response.n;
import com.iqoption.util.am;
import com.iqoption.util.l;
import com.iqoption.util.q;
import com.iqoption.view.text.x;
import com.iqoption.withdrawal.common.LimitDirection;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 b2\u00020\u0001:\u0003bcdB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fH\u0002J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020#0\n2\u0006\u0010$\u001a\u00020\fH\u0002J\u001a\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000bH\u0002J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.H\u0002J\u0014\u0010/\u001a\u0004\u0018\u00010,2\b\u00100\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u00101\u001a\u00020,H\u0002J\b\u00102\u001a\u00020,H\u0002J)\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020.2\b\u00104\u001a\u0004\u0018\u00010.2\b\u00105\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u0004H\u0002J\b\u00109\u001a\u00020\u0017H\u0002J\b\u0010:\u001a\u00020\u0017H\u0002J\u0010\u0010;\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010<\u001a\u00020\fH\u0002J\u0012\u0010=\u001a\u00020\u00172\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J&\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020?H\u0016J\u001a\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u00020A2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010J\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010K\u001a\u00020\u0017H\u0002J\u0018\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020A2\u0006\u0010N\u001a\u00020\fH\u0002J\u0010\u0010O\u001a\u00020\f2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010P\u001a\u00020\u00172\u0006\u00103\u001a\u00020.H\u0002J\u0010\u0010Q\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u0004H\u0002J\u0010\u0010R\u001a\u00020\u00172\u0006\u0010S\u001a\u00020\bH\u0002J\u0018\u0010T\u001a\u00020\u00172\u0006\u0010U\u001a\u00020.2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010V\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010W\u001a\u00020,H\u0002J\u0010\u0010X\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010Y\u001a\u00020\u0017H\u0002J\b\u0010Z\u001a\u00020\u0017H\u0002J\b\u0010[\u001a\u00020\u0017H\u0002J \u0010\\\u001a\u00020\f2\u0006\u00108\u001a\u00020\u00042\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020^H\u0002J\u001e\u0010`\u001a\u00020\u0017*\u00020\u00002\b\u0010a\u001a\u0004\u0018\u00010,2\u0006\u00108\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "()V", "amountHolder", "Lcom/iqoption/withdrawal/common/fields/FieldHolder;", "binding", "Lcom/iqoption/databinding/FragmentWithdrawFieldsBinding;", "fieldsData", "Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsData;", "fieldsValidationMap", "", "", "", "lastShownFields", "", "Lcom/iqoption/microservice/withdraw/response/PayoutField;", "restoredState", "Lcom/iqoption/withdrawal/common/fields/WithdrawState;", "viewModel", "Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsViewModel;", "withdrawButtonHolder", "Lcom/iqoption/withdrawal/common/fields/WithdrawButtonHolder;", "applyContentLength", "", "edit", "Landroid/widget/EditText;", "field", "applyImeOptions", "isLastField", "applyInputType", "isAmount", "areAllFieldsValid", "changeWithdrawButtonProgress", "progress", "collectValues", "", "valuesAsString", "findWithdrawMethodLimit", "Lcom/iqoption/microservice/withdraw/response/WithdrawLimit;", "method", "Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "currency", "formatAmountWithWalletMask", "limit", "Lcom/iqoption/withdrawal/common/AmountLimit;", "amount", "", "getAmountExceededLimit", "value", "getAmountLowerLimit", "getAmountUpperLimit", "commission", "refundAmount", "withMethodLimit", "(DLjava/lang/Double;Lcom/iqoption/microservice/withdraw/response/WithdrawLimit;)Lcom/iqoption/withdrawal/common/AmountLimit;", "hideFieldError", "holder", "hideInsufficientFoundsUI", "hideKeyboardIfOpened", "initWithdrawButton", "isFitWithoutCommission", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onSaveInstanceState", "outState", "onViewCreated", "view", "performMethodSelection", "performWithdraw", "prepareTitleView", "titleView", "inlineWithdrawButton", "shouldInlineWithdrawButton", "showCommission", "showFieldRegexpError", "showFields", "data", "showInsufficientFoundsUI", "walletAmount", "showLimit", "topLimit", "showWarningDialog", "showWithdrawFail", "showWithdrawSuccess", "updateWithdrawButton", "validateField", "regexpError", "Lcom/iqoption/withdrawal/common/fields/ValidationUIMode;", "limitError", "showFieldLimitError", "amountExceededLimit", "Companion", "FieldOnFocusChangeListener", "TextWatcher", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawFieldsFragment.kt */
public final class d extends com.iqoption.fragment.base.f {
    public static final String TAG = "com.iqoption.withdrawal.common.fields.d";
    public static final a dQp = new a();
    private HashMap atz;
    private final Map<String, Boolean> bWR = new LinkedHashMap();
    private um dQi;
    private WithdrawFieldsViewModel dQj;
    private c dQk;
    private List<com.iqoption.microservice.withdraw.response.f> dQl;
    private a dQm;
    private b dQn;
    private g dQo;

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsFragment$Companion;", "", "()V", "STATE_WITHDRAW", "", "TAG", "newInstance", "Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawFieldsFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final d aNp() {
            return new d();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsFragment$FieldOnFocusChangeListener;", "Landroid/view/View$OnFocusChangeListener;", "holder", "Lcom/iqoption/withdrawal/common/fields/FieldHolder;", "(Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsFragment;Lcom/iqoption/withdrawal/common/fields/FieldHolder;)V", "onFocusChange", "", "view", "Landroid/view/View;", "hasFocus", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawFieldsFragment.kt */
    public final class b implements OnFocusChangeListener {
        private final a dQq;
        final /* synthetic */ d dQr;

        public b(d dVar, a aVar) {
            kotlin.jvm.internal.h.e(aVar, "holder");
            this.dQr = dVar;
            this.dQq = aVar;
        }

        public void onFocusChange(View view, boolean z) {
            this.dQr.a(this.dQq, z ? ValidationUIMode.HIDE_ERROR_IF_VALID : ValidationUIMode.UPDATE_UI, ValidationUIMode.UPDATE_UI);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"})
    /* compiled from: WithdrawFieldsFragment.kt */
    static final class d implements OnEditorActionListener {
        final /* synthetic */ d dQr;

        d(d dVar) {
            this.dQr = dVar;
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            this.dQr.abP();
            return true;
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/withdrawal/common/fields/WithdrawFieldsFragment$onViewCreated$2$1"})
    /* compiled from: WithdrawFieldsFragment.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ d dQr;

        e(d dVar) {
            this.dQr = dVar;
        }

        public final void onClick(View view) {
            this.dQr.aNi();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/withdrawal/common/fields/WithdrawFieldsFragment$onViewCreated$3$1"})
    /* compiled from: WithdrawFieldsFragment.kt */
    static final class f implements OnClickListener {
        final /* synthetic */ d dQr;

        f(d dVar) {
            this.dQr = dVar;
        }

        public final void onClick(View view) {
            this.dQr.aNi();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/withdrawal/common/fields/WithdrawFieldsFragment$showFieldLimitError$1$1"})
    /* compiled from: WithdrawFieldsFragment.kt */
    static final class i implements OnClickListener {
        final /* synthetic */ d dQs;
        final /* synthetic */ String dQt;
        final /* synthetic */ com.iqoption.withdrawal.common.a dQu;

        i(d dVar, String str, com.iqoption.withdrawal.common.a aVar) {
            this.dQs = dVar;
            this.dQt = str;
            this.dQu = aVar;
        }

        public final void onClick(View view) {
            this.dQs.b(this.dQu);
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: WithdrawFieldsFragment.kt */
    static final class j implements OnClickListener {
        final /* synthetic */ d dQr;
        final /* synthetic */ com.iqoption.withdrawal.common.a dQv;

        j(d dVar, com.iqoption.withdrawal.common.a aVar) {
            this.dQr = dVar;
            this.dQv = aVar;
        }

        public final void onClick(View view) {
            String I = q.I(this.dQv.getValue());
            a c = this.dQr.dQm;
            if (c == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            EditText aMW = c.aMW();
            aMW.setText(I);
            aMW.setSelection(I.length());
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsFragment$TextWatcher;", "Lcom/iqoption/view/text/TextWatcherAdapter;", "holder", "Lcom/iqoption/withdrawal/common/fields/FieldHolder;", "(Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsFragment;Lcom/iqoption/withdrawal/common/fields/FieldHolder;)V", "afterTextChanged", "", "text", "Landroid/text/Editable;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawFieldsFragment.kt */
    public final class c extends x {
        private final a dQq;
        final /* synthetic */ d dQr;

        public c(d dVar, a aVar) {
            kotlin.jvm.internal.h.e(aVar, "holder");
            this.dQr = dVar;
            this.dQq = aVar;
        }

        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            this.dQr.a(this.dQq, ValidationUIMode.HIDE_ERROR_IF_VALID, ValidationUIMode.UPDATE_UI);
            this.dQr.aNh();
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "value", "Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsData;", "onChanged"})
    /* compiled from: WithdrawFieldsFragment.kt */
    static final class g<T> implements Observer<c> {
        final /* synthetic */ d dQr;

        g(d dVar) {
            this.dQr = dVar;
        }

        /* renamed from: c */
        public final void onChanged(c cVar) {
            if (cVar != null) {
                this.dQr.a(cVar);
            }
        }
    }

    @kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "result", "Lcom/iqoption/microservice/withdraw/response/WithdrawResponse;", "onChanged"})
    /* compiled from: WithdrawFieldsFragment.kt */
    static final class h<T> implements Observer<n> {
        final /* synthetic */ d dQr;

        h(d dVar) {
            this.dQr = dVar;
        }

        /* renamed from: a */
        public final void onChanged(n nVar) {
            if (nVar == null || !nVar.isSuccessful()) {
                this.dQr.aNj();
            } else {
                this.dQr.aNk();
            }
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    static {
        if (d.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dQo = bundle != null ? (g) bundle.getParcelable("STATE_WITHDRAW") : null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        um G = um.G(layoutInflater, viewGroup, false);
        kotlin.jvm.internal.h.d(G, "this");
        this.dQi = G;
        kotlin.jvm.internal.h.d(G, "FragmentWithdrawFieldsBi….apply { binding = this }");
        return G.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            getChildFragmentManager().beginTransaction().add(R.id.withdrawFieldsVerifyContainer, com.iqoption.withdrawal.common.fields.verify.g.dQH.aNv(), com.iqoption.withdrawal.common.fields.verify.g.dQH.Ll()).commitNow();
        }
        WithdrawFieldsViewModel L = WithdrawFieldsViewModel.dQx.L(com.iqoption.core.ext.a.n(this));
        kotlin.jvm.internal.h.d(L, "WithdrawFieldsViewModel.create(act)");
        this.dQj = L;
        L = this.dQj;
        if (L == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        L.akH().observe(this, new g(this));
        um umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        view = umVar.bHc;
        if (view == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        kotlin.jvm.internal.h.d(view, "binding.withdrawButtonCollapsed!!");
        Button button = (Button) view.findViewById(com.iqoption.b.a.withdrawButton);
        button.setEnabled(false);
        button.setOnClickListener(new e(this));
        umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        view = umVar.bHd;
        if (view == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        kotlin.jvm.internal.h.d(view, "binding.withdrawButtonExpanded!!");
        button = (Button) view.findViewById(com.iqoption.b.a.withdrawButton);
        button.setEnabled(false);
        button.setOnClickListener(new f(this));
    }

    public void onSaveInstanceState(Bundle bundle) {
        kotlin.jvm.internal.h.e(bundle, "outState");
        c cVar = this.dQk;
        if (cVar != null) {
            com.iqoption.microservice.withdraw.response.a aNc = cVar.aNc();
            Map fy = fy(true);
            if (fy == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            }
            bundle.putParcelable("STATE_WITHDRAW", new g(aNc, fy));
        }
        super.onSaveInstanceState(bundle);
    }

    private final void a(c cVar) {
        this.dQk = cVar;
        Fade fade = new Fade();
        fade.setDuration(300);
        um umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        View root = umVar.getRoot();
        if (root == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        TransitionManager.beginDelayedTransition((ViewGroup) root, fade);
        com.iqoption.withdrawal.common.a aNm = aNm();
        com.iqoption.withdrawal.common.a aNn = aNn();
        double amountRequired = cVar.aNd().getAmountRequired();
        boolean z = false;
        Object obj = (amountRequired == 0.0d || amountRequired < aNn.getValue() || aNm.getValue() == 0.0d) ? 1 : null;
        if (obj != null) {
            a(amountRequired, aNn);
            return;
        }
        aNg();
        com.iqoption.microservice.withdraw.response.a aNc = cVar.aNc();
        b(aNc);
        List atw = aNc.atw();
        if ((kotlin.jvm.internal.h.E(this.dQl, atw) ^ 1) != 0) {
            this.dQl = atw;
            b(cVar);
        } else {
            Map map = this.bWR;
            String str = "amount";
            a aVar = this.dQm;
            if (aVar == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            map.put(str, Boolean.valueOf(a(aVar, ValidationUIMode.UPDATE_UI, ValidationUIMode.UPDATE_UI)));
            aNh();
        }
        a(cVar, aNm);
        L(aNc.atv());
        com.iqoption.withdrawal.common.fields.verify.g gVar = (com.iqoption.withdrawal.common.fields.verify.g) getChildFragmentManager().findFragmentByTag(com.iqoption.withdrawal.common.fields.verify.g.dQH.Ll());
        if (gVar != null) {
            if (cVar.aNf() == WithdrawMethodType.COMMON) {
                z = true;
            }
            gVar.fA(z);
        }
    }

    private final void a(double d, com.iqoption.withdrawal.common.a aVar) {
        CharSequence string;
        um umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        LinearLayout linearLayout = umVar.bHi;
        kotlin.jvm.internal.h.d(linearLayout, "binding.withdrawFieldsSufficientFounds");
        linearLayout.setVisibility(8);
        umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        amr amr = umVar.bHh;
        if (amr == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        kotlin.jvm.internal.h.d(amr, "binding.withdrawFieldsInsufficientFounds!!");
        View root = amr.getRoot();
        kotlin.jvm.internal.h.d(root, "binding.withdrawFieldsInsufficientFounds!!.root");
        root.setVisibility(0);
        umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        root = umVar.getRoot();
        kotlin.jvm.internal.h.d(root, "binding.root");
        TextView textView = (TextView) root.findViewById(com.iqoption.b.a.withdrawInsufficientFoundsDescription);
        kotlin.jvm.internal.h.d(textView, "binding.root.withdrawInsufficientFoundsDescription");
        if (d > 0.0d) {
            string = getString(R.string.withdraw_lower_than_n1, a(aVar));
        } else {
            string = getString(R.string.your_balance_is_n1, M(d));
        }
        textView.setText(string);
    }

    private final void aNg() {
        um umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        LinearLayout linearLayout = umVar.bHi;
        kotlin.jvm.internal.h.d(linearLayout, "binding.withdrawFieldsSufficientFounds");
        linearLayout.setVisibility(0);
        umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        amr amr = umVar.bHh;
        if (amr == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        kotlin.jvm.internal.h.d(amr, "binding.withdrawFieldsInsufficientFounds!!");
        View root = amr.getRoot();
        kotlin.jvm.internal.h.d(root, "binding.withdrawFieldsInsufficientFounds!!.root");
        root.setVisibility(8);
    }

    private final boolean a(com.iqoption.microservice.withdraw.response.a aVar) {
        return aVar.atw().size() == 1 && getResources().getBoolean(R.bool.isLand);
    }

    private final void a(c cVar, com.iqoption.withdrawal.common.a aVar) {
        String string;
        String string2 = getString(R.string.up_to_n1, a(aVar));
        kotlin.jvm.internal.h.d(string2, "getString(R.string.up_to_n1, formattedAmount)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(u.capitalize(string2));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getColor(R.color.withdraw_green)), spannableStringBuilder.length() - r0.length(), spannableStringBuilder.length(), 33);
        um umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        TextView textView = umVar.bHk;
        kotlin.jvm.internal.h.d(textView, "binding.withdrawLimit");
        textView.setText(spannableStringBuilder);
        um umVar2 = this.dQi;
        if (umVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        TextView textView2 = umVar2.bHk;
        kotlin.jvm.internal.h.d(textView2, "binding.withdrawLimit");
        textView2.setVisibility(0);
        umVar2 = this.dQi;
        if (umVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        umVar2.bHk.setOnTouchListener(new com.iqoption.view.d.c());
        umVar2 = this.dQi;
        if (umVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        umVar2.bHk.setOnClickListener(new j(this, aVar));
        switch (aVar.aMQ()) {
            case WALLET_AMOUNT:
                if (cVar.aNc().atv() <= ((double) null)) {
                    string = getString(R.string.you_cannot_withdraw_exceed_balance);
                    break;
                } else {
                    string = getString(R.string.the_requested_amount_should_not_include_fee);
                    break;
                }
            case WITHDRAW_METHOD_LIMIT:
                if (aVar.aMR() != LimitDirection.UPPER) {
                    string = getString(R.string.withdraw_lower_than_n1, r0);
                    break;
                }
                string = getString(R.string.max_withdraw_in_one_transaction);
                break;
            case CARD_REFUND_LIMIT:
                string = getString(R.string.amount_cannot_exeed);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        um umVar3 = this.dQi;
        if (umVar3 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        TextView textView3 = umVar3.bHl;
        kotlin.jvm.internal.h.d(textView3, "binding.withdrawLimitDescription");
        textView3.setText(string);
        um umVar4 = this.dQi;
        if (umVar4 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        TextView textView4 = umVar4.bHl;
        kotlin.jvm.internal.h.d(textView4, "binding.withdrawLimitDescription");
        textView4.setVisibility(0);
    }

    private final void L(double d) {
        um umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        TextView textView;
        if (d > ((double) null)) {
            String e = l.e("$%s", Double.valueOf(d));
            TextView textView2 = umVar.bHe;
            kotlin.jvm.internal.h.d(textView2, "withdrawCommission");
            textView2.setText(getString(R.string.commission_n1, e));
            textView = umVar.bHe;
            kotlin.jvm.internal.h.d(textView, "withdrawCommission");
            textView.setVisibility(0);
            textView = umVar.bHf;
            kotlin.jvm.internal.h.d(textView, "withdrawCommissionDescription");
            textView.setVisibility(0);
            return;
        }
        textView = umVar.bHe;
        kotlin.jvm.internal.h.d(textView, "withdrawCommission");
        textView.setVisibility(8);
        textView = umVar.bHf;
        kotlin.jvm.internal.h.d(textView, "withdrawCommissionDescription");
        textView.setVisibility(8);
    }

    private final void b(c cVar) {
        com.iqoption.microservice.withdraw.response.a aNc = cVar.aNc();
        g gVar = this.dQo;
        if (!com.iqoption.microservice.withdraw.response.i.a(gVar != null ? gVar.aNq() : null, aNc)) {
            this.dQo = (g) null;
        }
        List<com.iqoption.microservice.withdraw.response.f> atw = aNc.atw();
        boolean a = a(aNc);
        um umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        LinearLayout linearLayout = umVar.bHg;
        linearLayout.removeAllViews();
        this.bWR.clear();
        LayoutInflater from = LayoutInflater.from(getContext());
        for (com.iqoption.microservice.withdraw.response.f fVar : atw) {
            amk aC = amk.aC(from, linearLayout, false);
            kotlin.jvm.internal.h.d(aC, "binding");
            View root = aC.getRoot();
            a aVar = new a(aC, fVar);
            kotlin.jvm.internal.h.d(root, Promotion.ACTION_VIEW);
            root.setTag(aVar);
            boolean c = f.a(fVar);
            TextView textView = aC.bUP;
            String translate = LocalizationUtil.translate(fVar.atF());
            CharSequence charSequence = translate;
            Object obj = (charSequence == null || u.M(charSequence)) ? 1 : null;
            if (obj != null) {
                translate = fVar.atE();
            }
            if (c) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" (");
                stringBuilder.append(cVar.aNe().symbol);
                stringBuilder.append(')');
                translate = kotlin.jvm.internal.h.p(translate, stringBuilder.toString());
            }
            kotlin.jvm.internal.h.d(textView, "titleView");
            textView.setText(translate);
            e(textView, a);
            View root2 = aC.getRoot();
            kotlin.jvm.internal.h.d(root2, "binding.root");
            EditText editText = (EditText) root2.findViewById(com.iqoption.b.a.withdrawFieldEditText);
            editText.setHint(fVar.getPlaceholder());
            boolean z = 0 == atw.size() - 1;
            editText.setOnFocusChangeListener(new b(this, aVar));
            editText.addTextChangedListener(new c(this, aVar));
            kotlin.jvm.internal.h.d(editText, "this");
            a(editText, z);
            c(editText, c);
            a(editText, fVar);
            if (c) {
                a aVar2 = this.dQm;
                if (aVar2 != null) {
                    EditText aMW = aVar2.aMW();
                    if (aMW != null) {
                        Editable text = aMW.getText();
                        if (text != null) {
                            aVar.aMW().setText(text.toString());
                        }
                    }
                }
                this.dQm = aVar;
                editText.setFilters((InputFilter[]) new com.iqoption.view.text.i[]{new com.iqoption.view.text.i(2)});
            }
            g gVar2 = this.dQo;
            if (gVar2 != null) {
                Map Vk = gVar2.Vk();
                if (Vk != null) {
                    editText.setText((CharSequence) Vk.get(fVar.getName()));
                }
            }
            linearLayout.addView(root);
            this.bWR.put(fVar.getName(), Boolean.valueOf(a(aVar, ValidationUIMode.SKIP_UI_UPDATES, ValidationUIMode.SKIP_UI_UPDATES)));
            int i = 0 + 1;
        }
        aNh();
        this.dQo = (g) null;
    }

    private final void e(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (z) {
            layoutParams2.width = -2;
            layoutParams2.weight = 0.0f;
        }
        view.setLayoutParams(layoutParams2);
    }

    private final void a(EditText editText, boolean z) {
        if (z) {
            editText.setImeOptions(268435462);
            editText.setOnEditorActionListener(new d(this));
            return;
        }
        editText.setImeOptions(268435461);
    }

    private final void c(EditText editText, boolean z) {
        if (z) {
            editText.setInputType(8194);
        }
    }

    private final void a(EditText editText, com.iqoption.microservice.withdraw.response.f fVar) {
        boolean z;
        switch (fVar.atG()) {
            case TEXT:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        editText.setSingleLine(z);
        if (fVar.atG() == PayoutFieldType.TEXT) {
            editText.setFilters((InputFilter[]) new LengthFilter[]{new LengthFilter(255)});
        }
    }

    private final void b(com.iqoption.microservice.withdraw.response.a aVar) {
        um umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        View view = umVar.bHc;
        if (view == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        um umVar2 = this.dQi;
        if (umVar2 == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        View view2 = umVar2.bHd;
        if (view2 == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        if (a(aVar)) {
            kotlin.jvm.internal.h.d(view, "collapsedButton");
            view.setVisibility(0);
            kotlin.jvm.internal.h.d(view2, "expandedButton");
            view2.setVisibility(8);
            this.dQn = new b(view);
            return;
        }
        kotlin.jvm.internal.h.d(view, "collapsedButton");
        view.setVisibility(8);
        kotlin.jvm.internal.h.d(view2, "expandedButton");
        view2.setVisibility(0);
        this.dQn = new b(view2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    private final void aNh() {
        /*
        r5 = this;
        r0 = r5.dQn;
        if (r0 == 0) goto L_0x0060;
    L_0x0004:
        r0 = r0.aNa();
        if (r0 == 0) goto L_0x0060;
    L_0x000a:
        r1 = r5.aNl();
        r0.setEnabled(r1);
        r1 = r5.dQm;
        if (r1 == 0) goto L_0x0020;
    L_0x0015:
        r1 = r1.aMW();
        if (r1 == 0) goto L_0x0020;
    L_0x001b:
        r1 = com.iqoption.withdrawal.common.fields.f.f(r1);
        goto L_0x0021;
    L_0x0020:
        r1 = 0;
    L_0x0021:
        r2 = 2131822789; // 0x7f1108c5 float:1.927836E38 double:1.053260403E-314;
        r2 = r5.getString(r2);
        r3 = r1;
        r3 = (java.lang.CharSequence) r3;
        if (r3 == 0) goto L_0x0036;
    L_0x002d:
        r3 = r3.length();
        if (r3 != 0) goto L_0x0034;
    L_0x0033:
        goto L_0x0036;
    L_0x0034:
        r3 = 0;
        goto L_0x0037;
    L_0x0036:
        r3 = 1;
    L_0x0037:
        if (r3 != 0) goto L_0x005a;
    L_0x0039:
        if (r1 != 0) goto L_0x003e;
    L_0x003b:
        kotlin.jvm.internal.h.aXZ();
    L_0x003e:
        r3 = java.lang.Double.parseDouble(r1);
        r1 = r5.M(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r2);
        r2 = 32;
        r3.append(r2);
        r3.append(r1);
        r2 = r3.toString();
    L_0x005a:
        r2 = (java.lang.CharSequence) r2;
        r0.setText(r2);
        return;
    L_0x0060:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.common.fields.d.aNh():void");
    }

    private final void aNi() {
        abP();
        View view = getView();
        if (view != null) {
            view = view.findFocus();
            if (view != null) {
                view.clearFocus();
            }
        }
        fz(true);
        Map fy = fy(false);
        WithdrawFieldsViewModel withdrawFieldsViewModel = this.dQj;
        if (withdrawFieldsViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        c cVar = this.dQk;
        if (cVar == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        withdrawFieldsViewModel.a(cVar.aNc(), fy).observe(this, new h(this));
    }

    private final Map<String, Object> fy(boolean z) {
        Map<String, Object> linkedHashMap = new LinkedHashMap();
        um umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        LinearLayout linearLayout = umVar.bHg;
        kotlin.jvm.internal.h.d(linearLayout, "container");
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = linearLayout.getChildAt(i);
            kotlin.jvm.internal.h.d(childAt, "child");
            Object tag = childAt.getTag();
            if (tag == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.withdrawal.common.fields.FieldHolder");
            }
            a aVar = (a) tag;
            String name = aVar.aMY().getName();
            String g = f.f(aVar.aMW());
            if (z || !f.a(aVar.aMY())) {
                linkedHashMap.put(name, g);
            } else {
                linkedHashMap.put(name, Double.valueOf(Double.parseDouble(g)));
            }
        }
        return linkedHashMap;
    }

    private final void aNj() {
        fz(false);
        com.iqoption.withdrawal.common.d.dPT.a(com.iqoption.core.ext.a.p(this), R.id.withdrawOtherContainer, false);
    }

    private final void aNk() {
        fz(false);
        com.iqoption.withdrawal.common.d.dPT.a(com.iqoption.core.ext.a.p(this), R.id.withdrawOtherContainer, true);
    }

    private final void fz(boolean z) {
        b bVar = this.dQn;
        if (bVar != null) {
            boolean z2 = false;
            bVar.aNb().setVisibility(z ? 0 : 8);
            TextView aNa = bVar.aNa();
            if (!z && aNl()) {
                z2 = true;
            }
            aNa.setEnabled(z2);
        }
    }

    private final boolean aNl() {
        if ((this.bWR.isEmpty() ^ 1) != 0) {
            for (Object next : this.bWR.values()) {
                if ((((Boolean) next).booleanValue() ^ 1) != 0) {
                    break;
                }
            }
            Object next2 = null;
            if (next2 == null) {
                return true;
            }
        }
        return false;
    }

    private final String a(com.iqoption.withdrawal.common.a aVar) {
        return M(aVar.getValue());
    }

    private final String M(double d) {
        c cVar = this.dQk;
        if (cVar == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        String e = l.e(cVar.aNe().mask, Double.valueOf(d));
        kotlin.jvm.internal.h.d(e, "formatedAmount(fieldsDat….conversion.mask, amount)");
        return e;
    }

    private final void abP() {
        com.iqoption.activity.b ajV = ajV();
        kotlin.jvm.internal.h.d(ajV, "iqActivity");
        if (ajV.zN()) {
            Context activity = zzakw();
            View view = getView();
            if (view == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            am.a(activity, view);
        }
    }

    private final com.iqoption.withdrawal.common.a kp(String str) {
        CharSequence charSequence = str;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        if (obj != null) {
            return null;
        }
        if (str == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        double parseDouble = Double.parseDouble(str);
        com.iqoption.withdrawal.common.a aNm = aNm();
        if (parseDouble > aNm.getValue()) {
            return aNm;
        }
        aNm = aNn();
        if (parseDouble < aNm.getValue()) {
            return aNm;
        }
        return null;
    }

    private final com.iqoption.withdrawal.common.a aNm() {
        c cVar = this.dQk;
        if (cVar == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        com.iqoption.microservice.withdraw.response.a aNc = cVar.aNc();
        Double d = null;
        com.iqoption.microservice.withdraw.response.c cVar2 = (com.iqoption.microservice.withdraw.response.c) (!(aNc instanceof com.iqoption.microservice.withdraw.response.c) ? null : aNc);
        if (cVar2 != null) {
            d = Double.valueOf(cVar2.atz());
        }
        c cVar3 = this.dQk;
        if (cVar3 == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        String str = cVar3.aNe().name;
        kotlin.jvm.internal.h.d(str, "fieldsData!!.conversion.name");
        return a(aNc.atv(), d, a(aNc, str));
    }

    private final com.iqoption.withdrawal.common.a a(double d, Double d2, com.iqoption.microservice.withdraw.response.g gVar) {
        c cVar = this.dQk;
        if (cVar == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        double amountRequired = cVar.aNd().getAmountRequired();
        cVar = this.dQk;
        if (cVar == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        return com.iqoption.withdrawal.common.b.a(amountRequired, d, cVar.aNe(), d2, gVar);
    }

    private final com.iqoption.withdrawal.common.a aNn() {
        c cVar = this.dQk;
        if (cVar == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        return com.iqoption.withdrawal.common.b.a(a(cVar.aNc(), cVar.aNd().currency));
    }

    private final com.iqoption.microservice.withdraw.response.g a(com.iqoption.microservice.withdraw.response.a aVar, String str) {
        List atx = aVar.atx();
        com.iqoption.microservice.withdraw.response.g gVar = null;
        if (atx == null) {
            return null;
        }
        for (com.iqoption.microservice.withdraw.response.g next : atx) {
            if (kotlin.jvm.internal.h.E(next.getName(), str)) {
                gVar = next;
                break;
            }
        }
        return gVar;
    }

    private final boolean aNo() {
        a aVar = this.dQm;
        if (aVar == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        String g = f.f(aVar.aMW());
        if ((u.M(g) ^ 1) != 0) {
            double parseDouble = Double.parseDouble(g);
            c cVar = this.dQk;
            if (cVar == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            if (parseDouble <= cVar.aNd().getAmountRequired()) {
                return true;
            }
        }
        return false;
    }

    private final boolean a(a aVar, ValidationUIMode validationUIMode, ValidationUIMode validationUIMode2) {
        com.iqoption.microservice.withdraw.response.f aMY = aVar.aMY();
        String g = f.f(aVar.aMW());
        boolean z = true;
        int b = f.a(aMY, g) ^ 1;
        if (b != 0 && validationUIMode == ValidationUIMode.UPDATE_UI) {
            b(aVar);
        } else if (b == 0 && ValidationUIMode.Companion.aMZ().contains(validationUIMode)) {
            a(aVar);
        }
        boolean c = f.a(aMY);
        com.iqoption.withdrawal.common.a kp = c ? kp(g) : null;
        Object obj = kp != null ? 1 : null;
        if (c) {
            if (obj != null && validationUIMode2 == ValidationUIMode.UPDATE_UI) {
                a(this, kp, aVar);
            } else if (obj == null && ValidationUIMode.Companion.aMZ().contains(validationUIMode2)) {
                a(aVar);
            }
        }
        if (!(b == 0 && obj == null)) {
            z = false;
        }
        this.bWR.put(aMY.getName(), Boolean.valueOf(z));
        return z;
    }

    private final void a(a aVar) {
        aVar.aMW().setBackgroundResource(R.drawable.withdraw_edittext_bg);
        aVar.aMX().setVisibility(8);
    }

    private final void b(a aVar) {
        aVar.aMW().setBackgroundResource(R.drawable.withdraw_edittext_error_bg);
        TextView aMX = aVar.aMX();
        aMX.setVisibility(0);
        aMX.setText(aMX.getContext().getString(R.string.incorrect_value));
        aMX.setOnClickListener(null);
        aMX.setOnTouchListener(null);
    }

    private final void a(d dVar, com.iqoption.withdrawal.common.a aVar, a aVar2) {
        if (aVar == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        String a = dVar.a(aVar);
        switch (aVar.aMR()) {
            case UPPER:
                a = dVar.getString(R.string.you_cannot_withdraw_up_to, a);
                break;
            case LOWER:
                a = dVar.getString(R.string.you_cannot_withdraw_less_then, a);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        TextView aMX = aVar2.aMX();
        aMX.setVisibility(0);
        aMX.setText(a);
        aMX.setOnClickListener(new i(dVar, a, aVar));
        aMX.setOnTouchListener(new com.iqoption.view.d.c());
        aVar2.aMW().setBackgroundResource(R.drawable.withdraw_edittext_error_bg);
    }

    private final void b(com.iqoption.withdrawal.common.a aVar) {
        String string;
        Object string2;
        String a = a(aVar);
        switch (aVar.aMR()) {
            case UPPER:
                string = getString(R.string.up_to_n1, a);
                kotlin.jvm.internal.h.d(string, "getString(R.string.up_to_n1, limitAmountText)");
                string = u.capitalize(string);
                break;
            case LOWER:
                string = getString(R.string.withdrawal_limit);
                kotlin.jvm.internal.h.d(string, "getString(R.string.withdrawal_limit)");
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        switch (aVar.aMQ()) {
            case WALLET_AMOUNT:
                if (!aNo()) {
                    string2 = getString(R.string.you_cannot_withdraw_exceed_balance);
                    break;
                } else {
                    string2 = getString(R.string.the_requested_amount_should_not_include_fee);
                    break;
                }
            case WITHDRAW_METHOD_LIMIT:
                if (aVar.aMR() != LimitDirection.UPPER) {
                    string2 = getString(R.string.withdraw_lower_than_n1, a);
                    break;
                }
                string2 = getString(R.string.max_withdraw_in_one_transaction);
                break;
            case CARD_REFUND_LIMIT:
                string2 = getString(R.string.amount_cannot_exeed);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        abP();
        um umVar = this.dQi;
        if (umVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        View findFocus = umVar.getRoot().findFocus();
        if (findFocus != null) {
            findFocus.clearFocus();
        }
        com.iqoption.withdrawal.common.e.a aVar2 = com.iqoption.withdrawal.common.e.dPW;
        FragmentManager p = com.iqoption.core.ext.a.p(this);
        CharSequence charSequence = string;
        kotlin.jvm.internal.h.d(string2, "message");
        aVar2.a(p, R.id.withdrawOtherContainer, charSequence, (CharSequence) string2);
    }
}
