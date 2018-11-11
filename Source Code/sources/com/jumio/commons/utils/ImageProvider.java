package com.jumio.commons.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.DownloadTask.ProgressListener;

@Deprecated
public class ImageProvider {
    private static final String COUNTRY_IMAGE_URL = "assets/nv/images/country/";
    private static final String IMAGE_EXTENSION = ".webp";
    private static ImageManager mImageManager;

    public interface FlagReceivedInterface {
        void onFlagReceived(Bitmap bitmap);
    }

    private static synchronized ImageManager getImageManager() {
        ImageManager imageManager;
        synchronized (ImageProvider.class) {
            if (mImageManager == null) {
                mImageManager = new ImageManager();
            }
            imageManager = mImageManager;
        }
        return imageManager;
    }

    public static Bitmap getCountryFlagFromServer(String str, String str2, Options options) {
        Bitmap bitmap;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(COUNTRY_IMAGE_URL);
        stringBuilder.append("flag_");
        stringBuilder.append(str2.toLowerCase());
        stringBuilder.append(IMAGE_EXTENSION);
        str = stringBuilder.toString();
        int hashCode = str.hashCode();
        if (getImageManager().hasBitmap(hashCode)) {
            bitmap = getImageManager().getBitmap(hashCode);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Reading ");
            stringBuilder2.append(str);
            stringBuilder2.append(" from local cache");
            Log.v(stringBuilder2.toString());
        } else {
            try {
                System.currentTimeMillis();
                byte[] data = new DownloadTask(str).getData();
                if (data != null) {
                    Bitmap decodeByteArray;
                    System.currentTimeMillis();
                    if (options != null) {
                        decodeByteArray = BitmapFactory.decodeByteArray(data, 0, data.length, options);
                    } else {
                        decodeByteArray = BitmapFactory.decodeByteArray(data, 0, data.length);
                    }
                    getImageManager().storeBitmap(hashCode, decodeByteArray);
                    bitmap = decodeByteArray;
                } else {
                    bitmap = null;
                }
            } catch (Throwable e) {
                Log.e(ImageProvider.class.getSimpleName(), e);
                return null;
            }
        }
        return bitmap;
    }

    public static void getCountryFlagFromServerAsync(String str, String str2, final Options options, final FlagReceivedInterface flagReceivedInterface) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(COUNTRY_IMAGE_URL);
        stringBuilder.append("flag_");
        stringBuilder.append(str2.toLowerCase());
        stringBuilder.append(IMAGE_EXTENSION);
        str = stringBuilder.toString();
        final int hashCode = str.hashCode();
        if (getImageManager().hasBitmap(hashCode)) {
            flagReceivedInterface.onFlagReceived(getImageManager().getBitmap(hashCode));
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Reading ");
            stringBuilder2.append(str);
            stringBuilder2.append(" from local cache");
            Log.v(stringBuilder2.toString());
            return;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(str);
            downloadTask.setListener(new ProgressListener() {
                public void onProgressUpdate(float f) {
                }

                public void onProgressDone(byte[] bArr) {
                    if (bArr == null) {
                        flagReceivedInterface.onFlagReceived(null);
                        return;
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    ImageProvider.getImageManager().storeBitmap(hashCode, decodeByteArray);
                    flagReceivedInterface.onFlagReceived(decodeByteArray);
                }
            });
            downloadTask.execute(new Void[0]);
        } catch (Throwable e) {
            Log.e(ImageProvider.class.getSimpleName(), e);
        }
    }
}
