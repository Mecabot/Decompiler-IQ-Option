package jumio.nv.core;

import android.content.Context;
import com.jumio.core.network.ApiCall.DynamicProvider;
import com.jumio.sdk.models.CredentialsModel;

/* compiled from: NVDynamicProvider */
public interface c extends DynamicProvider {
    CredentialsModel a();

    boolean a(Throwable th, Context context, boolean z);
}
