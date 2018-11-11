package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcwn;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public final class PlusShare {
    @Deprecated
    public static final String EXTRA_CALL_TO_ACTION = "com.google.android.apps.plus.CALL_TO_ACTION";
    @Deprecated
    public static final String EXTRA_CONTENT_DEEP_LINK_ID = "com.google.android.apps.plus.CONTENT_DEEP_LINK_ID";
    @Deprecated
    public static final String EXTRA_CONTENT_DEEP_LINK_METADATA = "com.google.android.apps.plus.CONTENT_DEEP_LINK_METADATA";
    @Deprecated
    public static final String EXTRA_CONTENT_URL = "com.google.android.apps.plus.CONTENT_URL";
    @Deprecated
    public static final String EXTRA_IS_INTERACTIVE_POST = "com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST";
    @Deprecated
    public static final String EXTRA_SENDER_ID = "com.google.android.apps.plus.SENDER_ID";
    @Deprecated
    public static final String KEY_CALL_TO_ACTION_DEEP_LINK_ID = "deepLinkId";
    @Deprecated
    public static final String KEY_CALL_TO_ACTION_LABEL = "label";
    @Deprecated
    public static final String KEY_CALL_TO_ACTION_URL = "url";
    @Deprecated
    public static final String KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION = "description";
    @Deprecated
    public static final String KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL = "thumbnailUrl";
    @Deprecated
    public static final String KEY_CONTENT_DEEP_LINK_METADATA_TITLE = "title";
    @Deprecated
    public static final String PARAM_CONTENT_DEEP_LINK_ID = "deep_link_id";

    @Deprecated
    public static class Builder {
        private final Context mContext;
        private final Intent mIntent = new Intent().setAction("android.intent.action.SEND");
        private boolean zzkhr;
        private ArrayList<Uri> zzkhs;

        @Deprecated
        public Builder(Activity activity) {
            this.mContext = activity;
            this.mIntent.addFlags(524288);
            if (activity != null && activity.getComponentName() != null) {
                this.zzkhr = true;
            }
        }

        @Deprecated
        public Builder(Context context) {
            this.mContext = context;
        }

        @Deprecated
        public Builder addCallToAction(String str, Uri uri, String str2) {
            zzbq.zza(this.zzkhr, (Object) "Must include the launching activity with PlusShare.Builder constructor before setting call-to-action");
            boolean z = (uri == null || TextUtils.isEmpty(uri.toString())) ? false : true;
            zzbq.checkArgument(z, "Must provide a call to action URL");
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString(PlusShare.KEY_CALL_TO_ACTION_LABEL, str);
            }
            bundle.putString(PlusShare.KEY_CALL_TO_ACTION_URL, uri.toString());
            if (!TextUtils.isEmpty(str2)) {
                zzbq.zza(PlusShare.zzla(str2), (Object) "The specified deep-link ID was malformed.");
                bundle.putString(PlusShare.KEY_CALL_TO_ACTION_DEEP_LINK_ID, str2);
            }
            this.mIntent.putExtra(PlusShare.EXTRA_CALL_TO_ACTION, bundle);
            this.mIntent.putExtra(PlusShare.EXTRA_IS_INTERACTIVE_POST, true);
            this.mIntent.setType("text/plain");
            return this;
        }

        @Deprecated
        public Builder addStream(Uri uri) {
            Uri uri2 = (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            if (uri2 == null) {
                return setStream(uri);
            }
            if (this.zzkhs == null) {
                this.zzkhs = new ArrayList();
            }
            this.zzkhs.add(uri2);
            this.zzkhs.add(uri);
            return this;
        }

        @Deprecated
        public Intent getIntent() {
            Intent intent;
            String str;
            boolean z = true;
            Object obj = (this.zzkhs == null || this.zzkhs.size() <= 1) ? null : 1;
            boolean equals = "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
            boolean booleanExtra = this.mIntent.getBooleanExtra(PlusShare.EXTRA_IS_INTERACTIVE_POST, false);
            boolean z2 = obj == null || !booleanExtra;
            zzbq.zza(z2, (Object) "Call-to-action buttons are only available for URLs.");
            z2 = !booleanExtra || this.mIntent.hasExtra(PlusShare.EXTRA_CONTENT_URL);
            zzbq.zza(z2, (Object) "The content URL is required for interactive posts.");
            if (!(!booleanExtra || this.mIntent.hasExtra(PlusShare.EXTRA_CONTENT_URL) || this.mIntent.hasExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID))) {
                z = false;
            }
            zzbq.zza(z, (Object) "Must set content URL or content deep-link ID to use a call-to-action button.");
            if (this.mIntent.hasExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID)) {
                zzbq.zza(PlusShare.zzla(this.mIntent.getStringExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID)), (Object) "The specified deep-link ID was malformed.");
            }
            if (obj == null && equals) {
                this.mIntent.setAction("android.intent.action.SEND");
                if (this.zzkhs == null || this.zzkhs.isEmpty()) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable) this.zzkhs.get(0));
                }
                this.zzkhs = null;
            }
            if (!(obj == null || equals)) {
                this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
                if (this.zzkhs == null || this.zzkhs.isEmpty()) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.zzkhs);
                }
            }
            if (!"com.google.android.gms.plus.action.SHARE_INTERNAL_GOOGLE".equals(this.mIntent.getAction())) {
                if (this.mIntent.hasExtra("android.intent.extra.STREAM")) {
                    intent = this.mIntent;
                    str = "com.google.android.apps.plus";
                    intent.setPackage(str);
                    return this.mIntent;
                }
                this.mIntent.setAction("com.google.android.gms.plus.action.SHARE_GOOGLE");
            }
            intent = this.mIntent;
            str = "com.google.android.gms";
            intent.setPackage(str);
            return this.mIntent;
        }

        @Deprecated
        public Builder setContentDeepLinkId(String str) {
            return setContentDeepLinkId(str, null, null, null);
        }

        @Deprecated
        public Builder setContentDeepLinkId(String str, String str2, String str3, Uri uri) {
            zzbq.checkArgument(this.zzkhr, "Must include the launching activity with PlusShare.Builder constructor before setting deep links");
            zzbq.checkArgument(TextUtils.isEmpty(str) ^ 1, "The deepLinkId parameter is required.");
            Bundle bundle = new Bundle();
            bundle.putString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, str2);
            bundle.putString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, str3);
            if (uri != null) {
                bundle.putString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, uri.toString());
            }
            this.mIntent.putExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_ID, str);
            this.mIntent.putExtra(PlusShare.EXTRA_CONTENT_DEEP_LINK_METADATA, bundle);
            this.mIntent.setType("text/plain");
            return this;
        }

        @Deprecated
        public Builder setContentUrl(Uri uri) {
            Object uri2 = uri != null ? uri.toString() : null;
            if (TextUtils.isEmpty(uri2)) {
                this.mIntent.removeExtra(PlusShare.EXTRA_CONTENT_URL);
                return this;
            }
            this.mIntent.putExtra(PlusShare.EXTRA_CONTENT_URL, uri2);
            return this;
        }

        @Deprecated
        public Builder setRecipients(Person person, List<Person> list) {
            this.mIntent.putExtra(PlusShare.EXTRA_SENDER_ID, person != null ? person.getId() : "0");
            int size = list != null ? list.size() : 0;
            if (size == 0) {
                this.mIntent.removeExtra("com.google.android.apps.plus.RECIPIENT_IDS");
                this.mIntent.removeExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES");
                return this;
            }
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (Person person2 : list) {
                arrayList.add(person2.getId());
                arrayList2.add(person2.getDisplayName());
            }
            this.mIntent.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_IDS", arrayList);
            this.mIntent.putStringArrayListExtra("com.google.android.apps.plus.RECIPIENT_DISPLAY_NAMES", arrayList2);
            return this;
        }

        @Deprecated
        public Builder setStream(Uri uri) {
            this.zzkhs = null;
            this.mIntent.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        @Deprecated
        public Builder setText(CharSequence charSequence) {
            this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        @Deprecated
        public Builder setType(String str) {
            this.mIntent.setType(str);
            return this;
        }
    }

    @Deprecated
    protected PlusShare() {
        throw new AssertionError();
    }

    @Deprecated
    public static Person createPerson(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("MinimalPerson ID must not be empty.");
        } else if (!TextUtils.isEmpty(str2)) {
            return new zzcwn(str2, str, null, 0, null);
        } else {
            throw new IllegalArgumentException("Display name must not be empty.");
        }
    }

    @Deprecated
    public static String getDeepLinkId(Intent intent) {
        return (intent == null || intent.getData() == null) ? null : intent.getData().getQueryParameter(PARAM_CONTENT_DEEP_LINK_ID);
    }

    @Hide
    protected static boolean zzla(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str = "GooglePlusPlatform";
            str2 = "The provided deep-link ID is empty.";
        } else if (!str.contains(" ")) {
            return true;
        } else {
            str = "GooglePlusPlatform";
            str2 = "Spaces are not allowed in deep-link IDs.";
        }
        Log.e(str, str2);
        return false;
    }
}
