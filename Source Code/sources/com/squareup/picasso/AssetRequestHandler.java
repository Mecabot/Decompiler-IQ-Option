package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;

class AssetRequestHandler extends RequestHandler {
    protected static final String ANDROID_ASSET = "android_asset";
    private static final int ASSET_PREFIX_LENGTH = "file:///android_asset/".length();
    private AssetManager assetManager;
    private final Context context;
    private final Object lock = new Object();

    public AssetRequestHandler(Context context) {
        this.context = context;
    }

    public boolean canHandleRequest(Request request) {
        Uri uri = request.uri;
        if ("file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && ANDROID_ASSET.equals(uri.getPathSegments().get(0))) {
            return true;
        }
        return false;
    }

    public Result load(Request request, int i) {
        if (this.assetManager == null) {
            synchronized (this.lock) {
                if (this.assetManager == null) {
                    this.assetManager = this.context.getAssets();
                }
            }
        }
        return new Result(this.assetManager.open(getFilePath(request)), LoadedFrom.DISK);
    }

    static String getFilePath(Request request) {
        return request.uri.toString().substring(ASSET_PREFIX_LENGTH);
    }
}
