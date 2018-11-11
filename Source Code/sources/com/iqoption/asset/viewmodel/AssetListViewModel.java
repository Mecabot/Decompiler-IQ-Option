package com.iqoption.asset.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ&\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\r0\f0\u00062\u0006\u0010\t\u001a\u00020\n¨\u0006\u000f"}, aXE = {"Lcom/iqoption/asset/viewmodel/AssetListViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "observeAssetDisplayData", "Lio/reactivex/Flowable;", "", "Lcom/iqoption/asset/mediators/AssetDisplayData;", "assetStreamParams", "Lcom/iqoption/asset/mediators/AssetStreamParams;", "observeAssetDisplayDataWithSort", "Lkotlin/Pair;", "Lcom/iqoption/asset/sort/AssetSort;", "Companion", "asset_release"})
/* compiled from: AssetListViewModel.kt */
public final class AssetListViewModel extends AndroidViewModel {
    private static final String TAG = "com.iqoption.asset.viewmodel.AssetListViewModel";
    public static final a aqV = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/asset/viewmodel/AssetListViewModel$Companion;", "", "()V", "TAG", "", "create", "Lcom/iqoption/asset/viewmodel/AssetListViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "asset_release"})
    /* compiled from: AssetListViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public AssetListViewModel(Application application) {
        h.e(application, "application");
        super(application);
    }

    static {
        if (AssetListViewModel.class.getName() == null) {
            h.aXZ();
        }
    }
}
