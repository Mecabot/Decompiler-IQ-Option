package com.squareup.picasso;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.InputStream;

class ContentStreamRequestHandler extends RequestHandler {
    final Context context;

    ContentStreamRequestHandler(Context context) {
        this.context = context;
    }

    public boolean canHandleRequest(Request request) {
        return b.CONTENT.equals(request.uri.getScheme());
    }

    public Result load(Request request, int i) {
        return new Result(getInputStream(request), LoadedFrom.DISK);
    }

    InputStream getInputStream(Request request) {
        return this.context.getContentResolver().openInputStream(request.uri);
    }
}
