package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.common.internal.Hide;

@Hide
public interface zzk extends IInterface {
    Bundle getArguments();

    int getId();

    boolean getRetainInstance();

    String getTag();

    int getTargetRequestCode();

    boolean getUserVisibleHint();

    IObjectWrapper getView();

    boolean isAdded();

    boolean isDetached();

    boolean isHidden();

    boolean isInLayout();

    boolean isRemoving();

    boolean isResumed();

    boolean isVisible();

    void setHasOptionsMenu(boolean z);

    void setMenuVisibility(boolean z);

    void setRetainInstance(boolean z);

    void setUserVisibleHint(boolean z);

    void startActivity(Intent intent);

    void startActivityForResult(Intent intent, int i);

    IObjectWrapper zzarh();

    zzk zzari();

    IObjectWrapper zzarj();

    zzk zzark();

    void zzw(IObjectWrapper iObjectWrapper);

    void zzx(IObjectWrapper iObjectWrapper);
}
