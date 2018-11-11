package com.jumio.sdk.exception;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.analytics.Screen;
import com.jumio.analytics.UserAction;
import com.jumio.core.R;
import com.jumio.gui.Colors;

public class JumioError {

    public interface ErrorInterface {
        void getAction();

        String getCaption();

        int getColorID();
    }

    public static AlertDialog getAlertDialogBuilder(Context context, JumioException jumioException, final ErrorInterface errorInterface, final ErrorInterface errorInterface2) {
        final JumioErrorCase errorCase = jumioException.getErrorCase();
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("detailedErrorCode", Integer.valueOf(jumioException.getDetailedErrorCase()));
        metaInfo.put("errorCode", Integer.valueOf(errorCase.code()));
        String str = "retryPossible";
        boolean z = errorCase.retry() && errorInterface != null;
        metaInfo.put(str, Boolean.valueOf(z));
        JumioAnalytics.add(MobileEvents.pageView(JumioAnalytics.getSessionId(), Screen.ERROR, metaInfo));
        Builder builder = new Builder(context);
        builder.setTitle(R.string.jumio_error_dialog_title);
        builder.setMessage(errorCase.localizedMessage(context));
        builder.setCancelable(false);
        if (errorCase.retry() && errorInterface != null) {
            builder.setPositiveButton(errorInterface.getCaption(), new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    errorInterface.getAction();
                    JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.ERROR, UserAction.RETRY, String.valueOf(errorCase.code())));
                }
            });
        }
        if (errorInterface2 != null) {
            builder.setNegativeButton(errorInterface2.getCaption(), new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    errorInterface2.getAction();
                    JumioAnalytics.add(MobileEvents.userAction(JumioAnalytics.getSessionId(), Screen.ERROR, UserAction.CANCEL, String.valueOf(errorCase.code())));
                }
            });
        }
        AlertDialog show = builder.show();
        if (errorInterface != null) {
            show.getButton(-1).setTextColor(Colors.parseColorStateList(context, errorInterface.getColorID(), -6832627));
        }
        if (errorInterface2 != null) {
            show.getButton(-2).setTextColor(Colors.parseColorStateList(context, errorInterface2.getColorID(), Colors.DIALOG_NEGATIVE_ACTION_COLOR));
        }
        return show;
    }
}
