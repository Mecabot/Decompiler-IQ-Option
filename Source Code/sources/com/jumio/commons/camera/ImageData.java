package com.jumio.commons.camera;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.jumio.commons.enums.ScreenAngle;
import com.jumio.commons.utils.FileUtil;
import java.io.File;
import java.io.Serializable;

public class ImageData implements Parcelable, Serializable {
    public static final Creator<ImageData> CREATOR = new Creator<ImageData>() {
        public ImageData createFromParcel(Parcel parcel) {
            return new ImageData(parcel, null);
        }

        public ImageData[] newArray(int i) {
            return new ImageData[i];
        }
    };
    private CameraPosition cameraPosition;
    private String exactImagePath;
    private boolean flashMode;
    private float focusConfidence;
    private String imagePath;
    private Size imageSize;
    private ScreenAngle orientationMode;

    public enum CameraPosition {
        FRONT,
        BACK
    }

    public int describeContents() {
        return 0;
    }

    /* synthetic */ ImageData(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    public void clear() {
        new File(this.imagePath).delete();
        new File(this.exactImagePath).delete();
        this.imagePath = null;
        this.exactImagePath = null;
    }

    public ImageData() {
        this.imageSize = null;
        this.flashMode = false;
        this.orientationMode = null;
        this.cameraPosition = null;
        this.focusConfidence = -1.0f;
    }

    private ImageData(Parcel parcel) {
        CameraPosition cameraPosition = null;
        this.imageSize = null;
        boolean z = false;
        this.flashMode = false;
        this.orientationMode = null;
        this.cameraPosition = null;
        this.focusConfidence = -1.0f;
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        if (!(readInt == -1 || readInt2 == -1)) {
            this.imageSize = new Size(readInt, readInt2);
        }
        if (parcel.readByte() == (byte) 1) {
            z = true;
        }
        this.flashMode = z;
        String readString = parcel.readString();
        this.orientationMode = readString.length() != 0 ? ScreenAngle.valueOf(readString) : null;
        readString = parcel.readString();
        if (readString.length() != 0) {
            cameraPosition = CameraPosition.valueOf(readString);
        }
        this.cameraPosition = cameraPosition;
        this.focusConfidence = parcel.readFloat();
        this.imagePath = parcel.readString();
        this.exactImagePath = parcel.readString();
    }

    public Size getImageSize() {
        return this.imageSize;
    }

    public void setImageSize(Size size) {
        this.imageSize = size;
    }

    public boolean isFlashMode() {
        return this.flashMode;
    }

    public void setFlashMode(boolean z) {
        this.flashMode = z;
    }

    public ScreenAngle getOrientationMode() {
        return this.orientationMode;
    }

    public void setOrientationMode(ScreenAngle screenAngle) {
        this.orientationMode = screenAngle;
    }

    public CameraPosition getCameraPosition() {
        return this.cameraPosition;
    }

    public void setCameraPosition(CameraPosition cameraPosition) {
        this.cameraPosition = cameraPosition;
    }

    public float getFocusConfidence() {
        return this.focusConfidence;
    }

    public void setFocusConfidence(float f) {
        this.focusConfidence = f;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public boolean hasImagePath() {
        return (this.imagePath == null || this.imagePath.length() == 0) ? false : true;
    }

    public String getExactImagePath() {
        return this.exactImagePath;
    }

    public void setExactImagePath(String str) {
        this.exactImagePath = str;
    }

    public boolean hasExactImagePath() {
        return (this.exactImagePath == null || this.exactImagePath.length() == 0) ? false : true;
    }

    public byte[] getImageData() {
        try {
            return FileUtil.readFile(getImagePath());
        } catch (Throwable e) {
            Log.e("ImageData", "Error reading File", e);
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = -1;
        parcel.writeInt(this.imageSize == null ? -1 : this.imageSize.width);
        if (this.imageSize != null) {
            i2 = this.imageSize.height;
        }
        parcel.writeInt(i2);
        parcel.writeByte((byte) this.flashMode);
        parcel.writeString(this.orientationMode == null ? "" : this.orientationMode.name());
        parcel.writeString(this.cameraPosition == null ? "" : this.cameraPosition.name());
        parcel.writeFloat(this.focusConfidence);
        parcel.writeString(this.imagePath);
        parcel.writeString(this.exactImagePath);
    }
}
