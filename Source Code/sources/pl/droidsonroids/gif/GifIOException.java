package pl.droidsonroids.gif;

import android.support.annotation.NonNull;
import java.io.IOException;

public class GifIOException extends IOException {
    private static final long serialVersionUID = 13038402904505L;
    private final String mErrnoMessage;
    @NonNull
    public final GifError reason;

    public String getMessage() {
        if (this.mErrnoMessage == null) {
            return this.reason.getFormattedDescription();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.reason.getFormattedDescription());
        stringBuilder.append(": ");
        stringBuilder.append(this.mErrnoMessage);
        return stringBuilder.toString();
    }

    private GifIOException(int i, String str) {
        this.reason = GifError.fromCode(i);
        this.mErrnoMessage = str;
    }
}
