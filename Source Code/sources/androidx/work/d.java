package androidx.work;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.List;

/* compiled from: InputMerger */
public abstract class d {
    @NonNull
    public abstract Data b(@NonNull List<Data> list);

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static d o(String str) {
        try {
            return (d) Class.forName(str).newInstance();
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trouble instantiating + ");
            stringBuilder.append(str);
            e.e("InputMerger", stringBuilder.toString(), e);
            return null;
        }
    }
}
