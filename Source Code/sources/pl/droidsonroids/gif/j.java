package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* compiled from: RenderTask */
class j extends k {
    j(b bVar) {
        super(bVar);
    }

    public void doWork() {
        long c = this.fkX.fkA.c(this.fkX.fkz);
        if (c >= 0) {
            this.fkX.fky = SystemClock.uptimeMillis() + c;
            if (this.fkX.isVisible() && this.fkX.fkx && !this.fkX.fkC) {
                this.fkX.fkw.remove(this);
                this.fkX.fkG = this.fkX.fkw.schedule(this, c, TimeUnit.MILLISECONDS);
            }
            if (!this.fkX.fkB.isEmpty() && this.fkX.bFE() == this.fkX.fkA.getNumberOfFrames() - 1) {
                this.fkX.fkD.sendEmptyMessageAtTime(this.fkX.bFF(), this.fkX.fky);
            }
        } else {
            this.fkX.fky = Long.MIN_VALUE;
            this.fkX.fkx = false;
        }
        if (this.fkX.isVisible() && !this.fkX.fkD.hasMessages(-1)) {
            this.fkX.fkD.sendEmptyMessageAtTime(-1, 0);
        }
    }
}
