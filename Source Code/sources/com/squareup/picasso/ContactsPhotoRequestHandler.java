package com.squareup.picasso;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.InputStream;

class ContactsPhotoRequestHandler extends RequestHandler {
    private static final int ID_CONTACT = 3;
    private static final int ID_DISPLAY_PHOTO = 4;
    private static final int ID_LOOKUP = 1;
    private static final int ID_THUMBNAIL = 2;
    private static final UriMatcher matcher = new UriMatcher(-1);
    private final Context context;

    @TargetApi(14)
    private static class ContactPhotoStreamIcs {
        private ContactPhotoStreamIcs() {
        }

        static InputStream get(ContentResolver contentResolver, Uri uri) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }

    static {
        matcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        matcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        matcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        matcher.addURI("com.android.contacts", "contacts/#", 3);
        matcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    ContactsPhotoRequestHandler(Context context) {
        this.context = context;
    }

    public boolean canHandleRequest(Request request) {
        Uri uri = request.uri;
        return b.CONTENT.equals(uri.getScheme()) && Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && matcher.match(request.uri) != -1;
    }

    public Result load(Request request, int i) {
        InputStream inputStream = getInputStream(request);
        return inputStream != null ? new Result(inputStream, LoadedFrom.DISK) : null;
    }

    private InputStream getInputStream(Request request) {
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri uri = request.uri;
        switch (matcher.match(uri)) {
            case 1:
                uri = Contacts.lookupContact(contentResolver, uri);
                if (uri == null) {
                    return null;
                }
                break;
            case 2:
            case 4:
                return contentResolver.openInputStream(uri);
            case 3:
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid uri: ");
                stringBuilder.append(uri);
                throw new IllegalStateException(stringBuilder.toString());
        }
        if (VERSION.SDK_INT < 14) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return ContactPhotoStreamIcs.get(contentResolver, uri);
    }
}
