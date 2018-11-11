package com.iqoption.d;

import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.iqoption.e.a.a.a;
import com.iqoption.view.RobotoTextView;
import com.iqoption.view.RotatedAnimatedVectorSwitchView;
import com.iqoption.x.R;

/* compiled from: AssetFragmentBindingImpl */
public class aq extends ap implements a {
    @Nullable
    private static final IncludedLayouts awU = null;
    @Nullable
    private static final SparseIntArray awV = new SparseIntArray();
    private long awW;
    @Nullable
    private final OnClickListener bkG;
    @Nullable
    private final OnClickListener bkH;
    @Nullable
    private final OnClickListener bkI;
    @Nullable
    private final OnClickListener bkJ;
    @Nullable
    private final OnClickListener bkK;
    @Nullable
    private final OnClickListener bkL;
    @Nullable
    private final OnClickListener bkM;
    @Nullable
    private final OnClickListener bkN;
    @Nullable
    private final OnClickListener bkO;
    @Nullable
    private final OnClickListener bkP;
    @Nullable
    private final OnClickListener bkQ;
    @Nullable
    private final OnClickListener bkR;

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        awV.put(R.id.contentLayout, 20);
        awV.put(R.id.typeContainerScrollView, 21);
        awV.put(R.id.raw, 22);
        awV.put(R.id.selectedLocal, 23);
        awV.put(R.id.localeFlag, 24);
        awV.put(R.id.titleLocalType, 25);
        awV.put(R.id.countLocalType, 26);
        awV.put(R.id.titleToggleOption, 27);
        awV.put(R.id.countToggleOptione, 28);
        awV.put(R.id.selectedBinary, 29);
        awV.put(R.id.titleBinaryType, 30);
        awV.put(R.id.countBinaryType, 31);
        awV.put(R.id.selectedDigital, 32);
        awV.put(R.id.titleDigitalType, 33);
        awV.put(R.id.countDigitalType, 34);
        awV.put(R.id.selectedFx, 35);
        awV.put(R.id.titleStrikeFx, 36);
        awV.put(R.id.countFxType, 37);
        awV.put(R.id.selectedForex, 38);
        awV.put(R.id.titleForexType, 39);
        awV.put(R.id.countForexType, 40);
        awV.put(R.id.selectedStock, 41);
        awV.put(R.id.titleStockType, 42);
        awV.put(R.id.countStockActive, 43);
        awV.put(R.id.selectedCrypto, 44);
        awV.put(R.id.titleCryptoType, 45);
        awV.put(R.id.countCryptoType, 46);
        awV.put(R.id.selectedCommodity, 47);
        awV.put(R.id.titleСommodityType, 48);
        awV.put(R.id.countCommodityActive, 49);
        awV.put(R.id.selectedEtf, 50);
        awV.put(R.id.titleEtfType, 51);
        awV.put(R.id.countEtfActive, 52);
        awV.put(R.id.selectedIndex, 53);
        awV.put(R.id.titleIndexType, 54);
        awV.put(R.id.countIndexActive, 55);
        awV.put(R.id.selectedBond, 56);
        awV.put(R.id.titleBoundType, 57);
        awV.put(R.id.countBondActive, 58);
        awV.put(R.id.more_type, 59);
        awV.put(R.id.selectedMore, 60);
        awV.put(R.id.titleMoreType, 61);
        awV.put(R.id.activeContainer, 62);
        awV.put(R.id.activeProTraderFragment, 63);
        awV.put(R.id.localSettingContainer, 64);
        awV.put(R.id.localeIcon, 65);
        awV.put(R.id.verticalSpace, 66);
        awV.put(R.id.countryName, 67);
        awV.put(R.id.activeLinearContainer, 68);
        awV.put(R.id.searchEdit, 69);
        awV.put(R.id.assetSort, 70);
        awV.put(R.id.assetSortArrow, 71);
        awV.put(R.id.sortSwitcher, 72);
        awV.put(R.id.cfdSortContainer, 73);
        awV.put(R.id.diffSort, 74);
        awV.put(R.id.diffSortArrow, 75);
        awV.put(R.id.spreadSort, 76);
        awV.put(R.id.spreadSortArrow, 77);
        awV.put(R.id.leverageSort, 78);
        awV.put(R.id.leverageSortArrow, 79);
        awV.put(R.id.profitSort, 80);
        awV.put(R.id.profitSortArrow, 81);
        awV.put(R.id.assetList, 82);
        awV.put(R.id.activeMoreFragment, 83);
    }

    public aq(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 84, awU, awV));
    }

    private aq(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[62], (LinearLayout) objArr[68], (FrameLayout) objArr[83], (FrameLayout) objArr[63], (RecyclerView) objArr[82], (RobotoTextView) objArr[70], (RotatedAnimatedVectorSwitchView) objArr[71], (RelativeLayout) objArr[14], (RelativeLayout) objArr[3], (LinearLayout) objArr[12], (LinearLayout) objArr[73], (LinearLayout) objArr[9], (LinearLayout) objArr[20], (TextView) objArr[31], (TextView) objArr[58], (TextView) objArr[49], (TextView) objArr[46], (TextView) objArr[34], (TextView) objArr[52], (TextView) objArr[40], (TextView) objArr[37], (TextView) objArr[55], (TextView) objArr[26], (TextView) objArr[43], (TextView) objArr[28], (TextView) objArr[67], (LinearLayout) objArr[8], (RobotoTextView) objArr[74], (RotatedAnimatedVectorSwitchView) objArr[75], (LinearLayout) objArr[15], (RelativeLayout) objArr[4], (LinearLayout) objArr[10], (FrameLayout) objArr[0], (LinearLayout) objArr[6], (RelativeLayout) objArr[5], (ImageView) objArr[19], (LinearLayout) objArr[11], (RobotoTextView) objArr[78], (RotatedAnimatedVectorSwitchView) objArr[79], (LinearLayout) objArr[17], (ImageView) objArr[13], (RelativeLayout) objArr[64], (LinearLayout) objArr[1], (ImageView) objArr[24], (ImageView) objArr[65], (LinearLayout) objArr[59], (RobotoTextView) objArr[80], (RotatedAnimatedVectorSwitchView) objArr[81], (RelativeLayout) objArr[18], (LinearLayout) objArr[22], (EditText) objArr[69], (View) objArr[29], (View) objArr[56], (View) objArr[47], (View) objArr[44], (View) objArr[32], (View) objArr[50], (View) objArr[38], (View) objArr[35], (View) objArr[53], (View) objArr[23], (View) objArr[60], (View) objArr[41], (ViewSwitcher) objArr[72], (RobotoTextView) objArr[76], (RotatedAnimatedVectorSwitchView) objArr[77], (LinearLayout) objArr[16], (LinearLayout) objArr[7], (TextView) objArr[30], (TextView) objArr[57], (TextView) objArr[45], (TextView) objArr[33], (TextView) objArr[51], (TextView) objArr[39], (TextView) objArr[54], (TextView) objArr[25], (TextView) objArr[61], (TextView) objArr[48], (TextView) objArr[42], (TextView) objArr[36], (TextView) objArr[27], (LinearLayout) objArr[2], (ScrollView) objArr[21], (Space) objArr[66]);
        this.awW = -1;
        this.bjg.setTag(null);
        this.bjh.setTag(null);
        this.bji.setTag(null);
        this.bjk.setTag(null);
        this.bjz.setTag(null);
        this.bjC.setTag(null);
        this.bjD.setTag(null);
        this.bjE.setTag(null);
        this.bjF.setTag(null);
        this.bjG.setTag(null);
        this.bjH.setTag(null);
        this.bjI.setTag(null);
        this.bjJ.setTag(null);
        this.bjM.setTag(null);
        this.bjN.setTag(null);
        this.bjP.setTag(null);
        this.bjV.setTag(null);
        this.bkn.setTag(null);
        this.bko.setTag(null);
        this.bkC.setTag(null);
        setRootTag(view);
        this.bkG = new com.iqoption.e.a.a(this, 11);
        this.bkH = new com.iqoption.e.a.a(this, 12);
        this.bkI = new com.iqoption.e.a.a(this, 10);
        this.bkJ = new com.iqoption.e.a.a(this, 8);
        this.bkK = new com.iqoption.e.a.a(this, 9);
        this.bkL = new com.iqoption.e.a.a(this, 6);
        this.bkM = new com.iqoption.e.a.a(this, 5);
        this.bkN = new com.iqoption.e.a.a(this, 7);
        this.bkO = new com.iqoption.e.a.a(this, 3);
        this.bkP = new com.iqoption.e.a.a(this, 4);
        this.bkQ = new com.iqoption.e.a.a(this, 1);
        this.bkR = new com.iqoption.e.a.a(this, 2);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.awW = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.awW != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.iqoption.fragment.a) obj);
        return true;
    }

    public void a(@Nullable com.iqoption.fragment.a aVar) {
        this.bkF = aVar;
        synchronized (this) {
            this.awW |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.awW;
            this.awW = 0;
        }
        com.iqoption.fragment.a aVar = this.bkF;
        if ((j & 2) != 0) {
            Void voidR = (Void) null;
            com.iqoption.core.ui.a.a(this.bjg, voidR);
            this.bjh.setOnClickListener(this.bkO);
            this.bji.setOnClickListener(this.bkH);
            this.bjk.setOnClickListener(this.bkK);
            this.bjz.setOnClickListener(this.bkJ);
            com.iqoption.core.ui.a.a(this.bjC, voidR);
            this.bjD.setOnClickListener(this.bkP);
            this.bjE.setOnClickListener(this.bkI);
            this.bjG.setOnClickListener(this.bkL);
            this.bjH.setOnClickListener(this.bkM);
            com.iqoption.core.ui.a.a(this.bjI, voidR);
            this.bjJ.setOnClickListener(this.bkG);
            com.iqoption.core.ui.a.a(this.bjM, voidR);
            com.iqoption.core.ui.a.a(this.bjN, voidR);
            this.bjP.setOnClickListener(this.bkQ);
            com.iqoption.core.ui.a.a(this.bjV, voidR);
            com.iqoption.core.ui.a.a(this.bkn, voidR);
            this.bko.setOnClickListener(this.bkN);
            this.bkC.setOnClickListener(this.bkR);
        }
    }

    public final void a(int i, View view) {
        Object obj = null;
        com.iqoption.fragment.a aVar;
        switch (i) {
            case 1:
                aVar = this.bkF;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.aA(view);
                    return;
                }
                return;
            case 2:
                aVar = this.bkF;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.az(view);
                    return;
                }
                return;
            case 3:
                aVar = this.bkF;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.aA(view);
                    return;
                }
                return;
            case 4:
                aVar = this.bkF;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.aA(view);
                    return;
                }
                return;
            case 5:
                aVar = this.bkF;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.aA(view);
                    return;
                }
                return;
            case 6:
                aVar = this.bkF;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.aA(view);
                    return;
                }
                return;
            case 7:
                aVar = this.bkF;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.aA(view);
                    return;
                }
                return;
            case 8:
                aVar = this.bkF;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.aA(view);
                    return;
                }
                return;
            case 9:
                aVar = this.bkF;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.aA(view);
                    return;
                }
                return;
            case 10:
                aVar = this.bkF;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.aA(view);
                    return;
                }
                return;
            case 11:
                aVar = this.bkF;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.aA(view);
                    return;
                }
                return;
            case 12:
                aVar = this.bkF;
                if (aVar != null) {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.aA(view);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
