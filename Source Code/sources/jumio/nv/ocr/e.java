package jumio.nv.ocr;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.jumio.clientlib.impl.templatematcher.FrameProcessingCallbackTemplateMatcher;
import com.jumio.clientlib.impl.templatematcher.FrameQueue;
import com.jumio.clientlib.impl.templatematcher.LibImage;
import com.jumio.clientlib.impl.templatematcher.TemplateInfo;
import com.jumio.commons.log.Log;

/* compiled from: TemplateMatcherFrameCallback */
public class e extends FrameProcessingCallbackTemplateMatcher {
    private Handler a;
    private long b = 0;
    private long c = 0;
    private boolean d = false;

    public e(Handler handler) {
        this.a = handler;
    }

    public void intermediateResult(FrameQueue frameQueue, TemplateInfo templateInfo) {
        if (!this.d) {
            long j;
            if (this.c == 0) {
                this.c = System.currentTimeMillis();
                j = 0;
            } else {
                j = System.currentTimeMillis() - this.c;
                this.c = System.currentTimeMillis();
            }
            Parcelable aVar = new a(templateInfo);
            aVar.a(j);
            Bundle bundle = new Bundle();
            bundle.putParcelable("templateInfo", aVar);
            if (frameQueue.size() > 0) {
                LibImage frameByID = frameQueue.getFrameByID(templateInfo.getFrameIndex());
                if (frameByID != null) {
                    byte[] bArr = new byte[((int) (((float) (frameByID.getWidth() * frameByID.getHeight())) * 1.5f))];
                    frameByID.getFrameBuffer(bArr);
                    bundle.putByteArray("finalResultFrame", bArr);
                } else {
                    Log.w("TemplateMatcher", "IntermediateResult: no frame received from queue!!");
                }
            } else {
                Log.w("TemplateMatcher", "IntermediateResult: FrameQueue empty!!");
            }
            Message message = new Message();
            message.what = 102;
            message.setData(bundle);
            this.a.sendMessage(message);
        }
    }

    public void finalResult(FrameQueue frameQueue, TemplateInfo templateInfo) {
        if (!this.d) {
            this.d = true;
            long j = 0;
            if (this.b == 0) {
                this.b = System.currentTimeMillis();
            } else {
                long currentTimeMillis = System.currentTimeMillis() - this.b;
                this.b = System.currentTimeMillis();
                j = currentTimeMillis;
            }
            Bundle bundle = new Bundle();
            Parcelable aVar = new a(templateInfo);
            aVar.a(j);
            bundle.putParcelable("templateInfo", aVar);
            LibImage frameByID = frameQueue.getFrameByID(templateInfo.getFrameIndex());
            byte[] bArr = new byte[((int) (((float) (frameByID.getWidth() * frameByID.getHeight())) * 1.5f))];
            frameByID.getFrameBuffer(bArr);
            frameQueue.clear();
            bundle.putByteArray("finalResultFrame", bArr);
            Message message = new Message();
            message.what = 103;
            message.setData(bundle);
            this.a.sendMessage(message);
        }
    }

    public void noResult(FrameQueue frameQueue) {
        this.d = false;
        this.a.sendEmptyMessage(101);
    }

    public void a() {
        this.d = false;
    }
}
