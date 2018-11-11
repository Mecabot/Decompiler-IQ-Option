package jumio.nv.core;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Frame.Builder;
import com.google.android.gms.vision.Frame.Metadata;
import com.google.android.gms.vision.face.Face;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: SafeFaceDetector */
public class q extends Detector<Face> {
    private Detector<Face> a;

    public q(Detector<Face> detector) {
        this.a = detector;
    }

    public void release() {
        this.a.release();
    }

    public SparseArray<Face> detect(Frame frame) {
        int width = frame.getMetadata().getWidth();
        int height = frame.getMetadata().getHeight();
        double d;
        if (height > 1280) {
            d = ((double) height) / 640.0d;
            if (Math.floor(((double) width) / d) < 147.0d) {
                frame = a(frame, (int) Math.ceil(d * 147.0d));
            }
        } else if (width > 1280) {
            d = ((double) width) / 640.0d;
            if (Math.floor(((double) height) / d) < 147.0d) {
                frame = b(frame, (int) Math.ceil(d * 147.0d));
            }
        } else if (width < 147) {
            frame = a(frame, 147);
        }
        return this.a.detect(frame);
    }

    public boolean isOperational() {
        return this.a.isOperational();
    }

    public boolean setFocus(int i) {
        return this.a.setFocus(i);
    }

    private Frame a(Frame frame, int i) {
        Metadata metadata = frame.getMetadata();
        int width = metadata.getWidth();
        int height = metadata.getHeight();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Padded image from: ");
        stringBuilder.append(width);
        stringBuilder.append("x");
        stringBuilder.append(height);
        stringBuilder.append(" to ");
        stringBuilder.append(i);
        stringBuilder.append("x");
        stringBuilder.append(height);
        Log.i("SafeFaceDetector", stringBuilder.toString());
        ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
        int arrayOffset = grayscaleImageData.arrayOffset();
        Object array = grayscaleImageData.array();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * height);
        int arrayOffset2 = allocateDirect.arrayOffset();
        Object array2 = allocateDirect.array();
        int i2 = 0;
        Arrays.fill(array2, (byte) 0);
        while (i2 < height) {
            System.arraycopy(array, (i2 * width) + arrayOffset, array2, (i2 * i) + arrayOffset2, width);
            i2++;
        }
        return new Builder().setImageData(allocateDirect, i, height, 17).setId(metadata.getId()).setRotation(metadata.getRotation()).setTimestampMillis(metadata.getTimestampMillis()).build();
    }

    private Frame b(Frame frame, int i) {
        Metadata metadata = frame.getMetadata();
        int width = metadata.getWidth();
        int height = metadata.getHeight();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Padded image from: ");
        stringBuilder.append(width);
        stringBuilder.append("x");
        stringBuilder.append(height);
        stringBuilder.append(" to ");
        stringBuilder.append(width);
        stringBuilder.append("x");
        stringBuilder.append(i);
        Log.i("SafeFaceDetector", stringBuilder.toString());
        ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
        int arrayOffset = grayscaleImageData.arrayOffset();
        Object array = grayscaleImageData.array();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(width * i);
        int arrayOffset2 = allocateDirect.arrayOffset();
        Object array2 = allocateDirect.array();
        int i2 = 0;
        Arrays.fill(array2, (byte) 0);
        while (i2 < height) {
            int i3 = i2 * width;
            System.arraycopy(array, arrayOffset + i3, array2, i3 + arrayOffset2, width);
            i2++;
        }
        return new Builder().setImageData(allocateDirect, width, i, 17).setId(metadata.getId()).setRotation(metadata.getRotation()).setTimestampMillis(metadata.getTimestampMillis()).build();
    }
}
