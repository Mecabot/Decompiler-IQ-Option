package com.iqoption.fragment.account.security;

import android.content.Intent;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.os.OperationCanceledException;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.iqoption.activity.SetPasscodeActivity;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.d.kz;
import com.iqoption.fragment.account.security.phone.PhoneFragment;
import com.iqoption.fragment.account.security.sms.SmsFragment;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment.PasscodeScreen;
import com.iqoption.fragment.base.g;
import com.iqoption.util.am;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AccountSecurityFragment extends g implements com.iqoption.fragment.account.security.sms.SmsFragment.d, com.iqoption.fragment.account.security.touchId.b.a, com.iqoption.util.am.a {
    public static final String TAG = "com.iqoption.fragment.account.security.AccountSecurityFragment";
    private List<View> ctQ = new ArrayList();
    private List<View> ctR = new ArrayList();
    private a ctS;
    private kz ctT;
    private int ctU = 0;
    private boolean ctV = true;
    private View ctW;
    private int ctX;
    private int ctY;
    private int ctZ;
    private int cua;
    private y<Long> cub;
    private final c cuc = new c(this, null);
    private ScrollDirection cud = ScrollDirection.none;

    private enum ScrollDirection {
        none,
        left,
        right
    }

    private static class b implements Runnable {
        private WeakReference<AccountSecurityFragment> ckC;
        private final boolean visible;

        public b(AccountSecurityFragment accountSecurityFragment, boolean z) {
            this.ckC = new WeakReference(accountSecurityFragment);
            this.visible = z;
        }

        public void run() {
            AccountSecurityFragment accountSecurityFragment = (AccountSecurityFragment) this.ckC.get();
            if (accountSecurityFragment != null && accountSecurityFragment.isAdded()) {
                accountSecurityFragment.dc(this.visible);
            }
        }
    }

    private static class c {
        private final WeakReference<AccountSecurityFragment> ckC;

        /* synthetic */ c(AccountSecurityFragment accountSecurityFragment, AnonymousClass1 anonymousClass1) {
            this(accountSecurityFragment);
        }

        private c(AccountSecurityFragment accountSecurityFragment) {
            this.ckC = new WeakReference(accountSecurityFragment);
        }

        @com.google.common.b.e
        public void accountEvent(com.iqoption.app.b.b bVar) {
            String str = AccountSecurityFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("IQAccountEvents ");
            stringBuilder.append(bVar.getClass().getName());
            stringBuilder.append(": ");
            stringBuilder.append(bVar);
            i.d(str, stringBuilder.toString());
            ajh();
        }

        @com.google.common.b.e
        public void passcodeEvent(com.iqoption.app.b.d.c cVar) {
            String str = AccountSecurityFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cVar.getClass().getName());
            stringBuilder.append(": ");
            stringBuilder.append(cVar);
            i.d(str, stringBuilder.toString());
            ajh();
        }

        private void ajh() {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    AccountSecurityFragment accountSecurityFragment = (AccountSecurityFragment) c.this.ckC.get();
                    if (accountSecurityFragment != null) {
                        accountSecurityFragment.ajh();
                    }
                }
            });
        }
    }

    private class e implements Runnable {
        private final WeakReference<ViewPager> cug;
        private final int cuh;

        /* synthetic */ e(AccountSecurityFragment accountSecurityFragment, ViewPager viewPager, int i, AnonymousClass1 anonymousClass1) {
            this(viewPager, i);
        }

        private e(ViewPager viewPager, int i) {
            this.cug = new WeakReference(viewPager);
            this.cuh = i;
        }

        public void run() {
            ViewPager viewPager = (ViewPager) this.cug.get();
            if (viewPager != null) {
                try {
                    viewPager.setOffscreenPageLimit(this.cuh);
                } catch (Throwable e) {
                    i.e(AccountSecurityFragment.TAG, "error when setting page limit", e);
                }
            }
        }
    }

    private class d implements OnPageChangeListener {
        private d() {
        }

        /* synthetic */ d(AccountSecurityFragment accountSecurityFragment, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onPageScrolled(int i, float f, int i2) {
            String str = AccountSecurityFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPageScrolled position: ");
            stringBuilder.append(i);
            stringBuilder.append(", positionOffset: ");
            stringBuilder.append(f);
            stringBuilder.append(", positionOffsetPixels: ");
            stringBuilder.append(i2);
            i.v(str, stringBuilder.toString());
            if (AccountSecurityFragment.this.cud == ScrollDirection.none && AccountSecurityFragment.this.ctU == 1) {
                if (f < 0.5f) {
                    AccountSecurityFragment.this.cud = ScrollDirection.right;
                } else {
                    AccountSecurityFragment.this.cud = ScrollDirection.left;
                }
            }
            if (AccountSecurityFragment.this.cud != ScrollDirection.none) {
                int min;
                if (AccountSecurityFragment.this.cud == ScrollDirection.right) {
                    min = Math.min(i + 1, AccountSecurityFragment.this.ctT.bwm.getAdapter().getCount() - 1);
                } else {
                    min = i;
                    i = Math.min(i + 1, AccountSecurityFragment.this.ctT.bwm.getAdapter().getCount() - 1);
                }
                View view = (View) AccountSecurityFragment.this.ctR.get(i);
                View view2 = (View) AccountSecurityFragment.this.ctR.get(min);
                String str2 = AccountSecurityFragment.TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("CUR PAGE: ");
                stringBuilder2.append(i);
                stringBuilder2.append(", nextPage: ");
                stringBuilder2.append(min);
                stringBuilder2.append(", scroll direction:");
                stringBuilder2.append(AccountSecurityFragment.this.cud);
                i.v(str2, stringBuilder2.toString());
                if (f != 0.0f && i2 != 0) {
                    float f2 = AccountSecurityFragment.this.cud == ScrollDirection.right ? 1.0f - f : f;
                    float f3 = (f2 * 0.2f) + 1.0f;
                    view.setScaleX(f3);
                    view.setScaleY(f3);
                    f2 = (f2 * 0.7f) + 0.3f;
                    view.setAlpha(f2);
                    ((View) AccountSecurityFragment.this.ctQ.get(i)).setAlpha(f2);
                    String str3 = AccountSecurityFragment.TAG;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("CUR PAGE scale:");
                    stringBuilder3.append(f3);
                    stringBuilder3.append(", alpha:");
                    stringBuilder3.append(f2);
                    i.v(str3, stringBuilder3.toString());
                    if (view2 != view) {
                        if (AccountSecurityFragment.this.cud != ScrollDirection.right) {
                            f = 1.0f - f;
                        }
                        float f4 = (0.2f * f) + 1.0f;
                        view2.setScaleX(f4);
                        view2.setScaleY(f4);
                        f = (f * 0.7f) + 0.3f;
                        view2.setAlpha(f);
                        ((View) AccountSecurityFragment.this.ctQ.get(min)).setAlpha(f);
                        str3 = AccountSecurityFragment.TAG;
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("Next PAGE scale:");
                        stringBuilder4.append(f4);
                        stringBuilder4.append(", alpha:");
                        stringBuilder4.append(f);
                        i.v(str3, stringBuilder4.toString());
                    }
                }
            }
        }

        public void onPageScrollStateChanged(int i) {
            String str = AccountSecurityFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPageScrollStateChanged state: ");
            stringBuilder.append(i);
            i.v(str, stringBuilder.toString());
            AccountSecurityFragment.this.ctU = i;
            if (i == 0) {
                AccountSecurityFragment.this.cud = ScrollDirection.none;
            }
        }

        public void onPageSelected(int i) {
            String str = AccountSecurityFragment.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPageSelected position: ");
            stringBuilder.append(i);
            i.v(str, stringBuilder.toString());
            if (AccountSecurityFragment.this.ctW != null) {
                AccountSecurityFragment.this.ctW.setClickable(true);
            }
            AccountSecurityFragment.this.ctW = (View) AccountSecurityFragment.this.ctR.get(i);
            AccountSecurityFragment.this.ctW.setClickable(false);
        }
    }

    public class a extends FragmentStatePagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            View view = (View) AccountSecurityFragment.this.ctR.get(i);
            int id = view.getId();
            if (id == R.id.mailIcon) {
                return com.iqoption.fragment.account.security.a.c.ajm();
            }
            if (id == R.id.phoneIcon) {
                long j;
                PhoneNumber CM = com.iqoption.app.a.Cw().CM();
                if (CM == null) {
                    id = 0;
                } else {
                    id = CM.xE();
                }
                if (CM == null) {
                    j = 0;
                } else {
                    j = CM.ye();
                }
                return PhoneFragment.q(id, j);
            } else if (id == R.id.smsIcon) {
                return SmsFragment.ajD();
            } else {
                if (id == R.id.touchIdIcon) {
                    return com.iqoption.fragment.account.security.touchId.b.ajP();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported tab, id=");
                stringBuilder.append(view.getId());
                throw new RuntimeException(stringBuilder.toString());
            }
        }

        public int getCount() {
            return AccountSecurityFragment.this.ctR.size();
        }
    }

    public String gF() {
        return "security";
    }

    public void cp(boolean z) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onKeyboardVisibilityChanged visible=");
        stringBuilder.append(z);
        i.v(str, stringBuilder.toString());
        this.ctT.bwm.setSwipeable(z ^ 1);
        this.ctT.getRoot().postDelayed(new b(this, z), 1);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public static AccountSecurityFragment ajf() {
        return new AccountSecurityFragment();
    }

    public static void i(FragmentManager fragmentManager) {
        if (!l(fragmentManager)) {
            fragmentManager.beginTransaction().add(R.id.other_fragment, ajf(), TAG).addToBackStack(TAG).commit();
        }
    }

    public static boolean l(FragmentManager fragmentManager) {
        return fragmentManager.findFragmentByTag(TAG) != null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ctT = (kz) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_account_security, viewGroup, false);
        this.ctT.a(this);
        a(this.ctT);
        b(this.ctT);
        this.ctS = new a(getChildFragmentManager());
        this.ctT.bwm.setAdapter(this.ctS);
        this.ctT.bwm.setOffscreenPageLimit(1);
        com.iqoption.core.d.a.aSe.postDelayed(new e(this, this.ctT.bwm, 3, null), 5000);
        this.ctT.bwm.addOnPageChangeListener(new d(this, null));
        ahe();
        this.ctT.bwm.setCurrentItem(aV(this.ctW), false);
        IQApp.Dn().aD(this.cuc);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        IQApp.Dn().unregister(this.cuc);
        super.onDestroyView();
    }

    public View getContentView() {
        return this.ctT.getRoot();
    }

    public void j(int i, long j) {
        aW(this.ctT.getRoot().findViewById(R.id.phoneIcon));
    }

    public s<Long> db(boolean z) {
        startActivityForResult(SetPasscodeActivity.a(getContext(), z ? PasscodeScreen.newPasscode : PasscodeScreen.passcodeToTurnTouchIdOff), 1);
        this.cub = y.wb();
        return this.cub;
    }

    public void ajg() {
        startActivityForResult(SetPasscodeActivity.a(getContext(), PasscodeScreen.oldPasscode), 1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            if (intent != null) {
                long j = intent.getExtras().getLong(SetPasscodeActivity.adN);
                if (this.cub != null) {
                    this.cub.P(Long.valueOf(j));
                    this.cub = null;
                }
            }
        } else if (this.cub != null) {
            this.cub.h(new OperationCanceledException());
            this.cub = null;
        }
    }

    private void a(kz kzVar) {
        if (kzVar.bwi.getChildCount() != kzVar.bwd.getChildCount()) {
            throw new RuntimeException("dots are not equal tabs");
        }
        for (int i = 0; i < kzVar.bwd.getChildCount(); i++) {
            this.ctQ.add(kzVar.bwd.getChildAt(i));
        }
    }

    private void b(kz kzVar) {
        for (int i = 0; i < kzVar.bwi.getChildCount(); i++) {
            this.ctR.add(kzVar.bwi.getChildAt(i));
        }
        ajh();
        this.ctW = kzVar.bwi.findViewById(af.aR(getContext()).EO());
        if (this.ctW == null) {
            i.d("first tab will be selected");
            this.ctW = (View) this.ctR.get(0);
        }
        this.ctW.setAlpha(1.0f);
        this.ctW.setScaleX(1.2f);
        this.ctW.setScaleY(1.2f);
        this.ctW.setClickable(false);
        int aV = aV(this.ctW);
        if (aV == -1) {
            this.ctW = (View) this.ctR.get(0);
            aV = 0;
        }
        ((View) this.ctQ.get(aV)).setAlpha(1.0f);
    }

    private void ajh() {
        int i = Dg() ? R.drawable.ic_iq_security_mail_ok : R.drawable.ic_iq_security_mail;
        if (i != this.ctX) {
            this.ctX = i;
            this.ctT.bwg.setImageResource(i);
        }
        i = De() ? R.drawable.ic_iq_security_phone_ok : R.drawable.ic_iq_security_phone;
        if (i != this.ctY) {
            this.ctY = i;
            this.ctT.bwh.setImageResource(i);
        }
        i = ajj() ? R.drawable.ic_iq_security_sms_ok : R.drawable.ic_iq_security_sms;
        if (i != this.ctZ) {
            this.ctZ = i;
            this.ctT.bwk.setImageResource(i);
        }
        i = aji() ? R.drawable.ic_iq_security_touchid_ok : R.drawable.ic_iq_security_touchid;
        if (i != this.cua) {
            this.cua = i;
            this.ctT.bwl.setImageResource(i);
        }
    }

    private boolean aji() {
        return af.aR(getContext()).EP() >= 0;
    }

    private boolean ajj() {
        return com.iqoption.app.a.aL(getContext()).CR();
    }

    private boolean De() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL(getContext());
        return !TextUtils.isEmpty(aL.getPhone()) && aL.De();
    }

    private boolean Dg() {
        return com.iqoption.fragment.account.security.a.c.bl(getContext());
    }

    private int aV(View view) {
        return this.ctT.bwi.indexOfChild(view);
    }

    private int ajk() {
        return this.ctW == null ? -1 : this.ctW.getId();
    }

    public void ahJ() {
        onClose();
    }

    private void ahe() {
        View root = this.ctT.getRoot();
        root.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                FragmentManager childFragmentManager = AccountSecurityFragment.this.getChildFragmentManager();
                Fragment findFragmentByTag = childFragmentManager.findFragmentByTag(com.iqoption.fragment.account.security.touchId.a.TAG);
                if (findFragmentByTag != null) {
                    ((com.iqoption.fragment.account.security.touchId.a) findFragmentByTag).onBackPressed();
                } else {
                    Fragment findFragmentByTag2 = childFragmentManager.findFragmentByTag(PasscodeFragment.TAG);
                    if (findFragmentByTag2 != null) {
                        ((PasscodeFragment) findFragmentByTag2).onBackPressed();
                    } else {
                        AccountSecurityFragment.this.onClose();
                    }
                }
                return true;
            }
        });
        root.setFocusableInTouchMode(true);
    }

    public void aW(View view) {
        if (view.isClickable()) {
            view.setClickable(false);
            View view2 = this.ctW;
            if (view2 != null) {
                view2.setClickable(true);
                if (view2.getScaleX() > 1.0f) {
                    view2.animate().scaleX(1.0f).scaleY(1.0f).alpha(0.3f);
                }
                k(aV(view2), false);
            }
            this.ctW = view;
            this.ctW.animate().scaleX(1.2f).scaleY(1.2f).alpha(1.0f);
            int aV = aV(this.ctW);
            k(aV, true);
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select tab ");
            stringBuilder.append(aV);
            i.v(str, stringBuilder.toString());
            this.ctT.bwm.setCurrentItem(aV, true);
            view.getId();
        }
    }

    private void k(int i, boolean z) {
        ((View) this.ctQ.get(i)).animate().alpha(z ? 1.0f : 0.3f);
    }

    public void onResume() {
        super.onResume();
        this.ctV = true;
        zzakw().getWindow().setSoftInputMode(48);
        am.a(this);
    }

    public void onPause() {
        super.onPause();
        af.aR(getContext()).cR(ajk());
        zzakw().getWindow().setSoftInputMode(32);
        am.b(this);
        am.n(zzakw());
        cp(false);
    }

    private void dc(boolean z) {
        long j;
        if (z) {
            int i = this.ctV ? 550 : 200;
            this.ctV = false;
            zzakw().getWindowManager().getDefaultDisplay().getSize(new Point());
            float f = -this.ctT.bwm.getY();
            j = (long) i;
            this.ctT.bwj.animate().alpha(0.0f).setDuration(j);
            this.ctT.bwi.animate().alpha(0.0f).setDuration(j);
            this.ctT.bwm.animate().translationY(f).setDuration(j);
            this.ctT.bwd.animate().alpha(0.0f).setDuration(j);
            return;
        }
        j = (long) 300;
        this.ctT.bwj.animate().alpha(1.0f).setDuration(j);
        this.ctT.bwi.animate().alpha(1.0f).setDuration(j);
        this.ctT.bwm.animate().translationY(0.0f).setDuration(j);
        this.ctT.bwd.animate().alpha(1.0f).setDuration(j);
    }
}
