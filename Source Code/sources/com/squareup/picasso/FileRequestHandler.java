package com.squareup.picasso;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;

class FileRequestHandler extends ContentStreamRequestHandler {
    FileRequestHandler(Context context) {
        super(context);
    }

    public boolean canHandleRequest(Request request) {
        return "file".equals(request.uri.getScheme());
    }

    public Result load(Request request, int i) {
        return new Result(null, getInputStream(request), LoadedFrom.DISK, getFileExifRotation(request.uri));
    }

    static int getFileExifRotation(Uri uri) {
        return new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
    }
}
