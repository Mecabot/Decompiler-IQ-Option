package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.common.internal.Hide;

@Hide
public interface zzey extends IInterface {
    Bundle zza(Account account);

    Bundle zza(Account account, String str, Bundle bundle);

    Bundle zza(String str, Bundle bundle);

    AccountChangeEventsResponse zza(AccountChangeEventsRequest accountChangeEventsRequest);

    Bundle zzp(String str);
}
