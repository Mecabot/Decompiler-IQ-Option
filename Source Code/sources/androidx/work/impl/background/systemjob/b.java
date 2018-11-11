package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import androidx.work.e;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.d;
import androidx.work.impl.b.j;
import androidx.work.impl.c;
import androidx.work.impl.g;
import java.util.List;

@RequiresApi(23)
@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: SystemJobScheduler */
public class b implements c {
    private final a fE;
    private final androidx.work.impl.utils.c fh;
    private final g fu;
    private final JobScheduler mJobScheduler;

    public b(@NonNull Context context, @NonNull g gVar) {
        this(context, gVar, (JobScheduler) context.getSystemService("jobscheduler"), new a(context));
    }

    @VisibleForTesting
    public b(Context context, g gVar, JobScheduler jobScheduler, a aVar) {
        this.fu = gVar;
        this.mJobScheduler = jobScheduler;
        this.fh = new androidx.work.impl.utils.c(context);
        this.fE = aVar;
    }

    public void a(j... jVarArr) {
        WorkDatabase bA = this.fu.bA();
        int length = jVarArr.length;
        int i = 0;
        while (i < length) {
            j jVar = jVarArr[i];
            try {
                bA.beginTransaction();
                d K = bA.bx().K(jVar.id);
                int h = K != null ? K.gh : this.fh.h(this.fu.bB().aC(), this.fu.bB().aD());
                if (K == null) {
                    this.fu.bA().bx().a(new d(jVar.id, h));
                }
                b(jVar, h);
                if (VERSION.SDK_INT == 23) {
                    b(jVar, this.fh.h(this.fu.bB().aC(), this.fu.bB().aD()));
                }
                bA.setTransactionSuccessful();
                bA.endTransaction();
                i++;
            } catch (Throwable th) {
                bA.endTransaction();
                throw th;
            }
        }
    }

    @VisibleForTesting
    public void b(j jVar, int i) {
        JobInfo a = this.fE.a(jVar, i);
        e.b("SystemJobScheduler", String.format("Scheduling work ID %s Job ID %s", new Object[]{jVar.id, Integer.valueOf(i)}), new Throwable[0]);
        this.mJobScheduler.schedule(a);
    }

    public void x(@NonNull String str) {
        List<JobInfo> allPendingJobs = this.mJobScheduler.getAllPendingJobs();
        if (allPendingJobs != null) {
            for (JobInfo jobInfo : allPendingJobs) {
                if (str.equals(jobInfo.getExtras().getString("EXTRA_WORK_SPEC_ID"))) {
                    this.fu.bA().bx().L(str);
                    this.mJobScheduler.cancel(jobInfo.getId());
                    if (VERSION.SDK_INT != 23) {
                        return;
                    }
                }
            }
        }
    }

    public static void h(@NonNull Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            List<JobInfo> allPendingJobs = jobScheduler.getAllPendingJobs();
            if (allPendingJobs != null) {
                for (JobInfo jobInfo : allPendingJobs) {
                    if (jobInfo.getExtras().containsKey("EXTRA_WORK_SPEC_ID")) {
                        jobScheduler.cancel(jobInfo.getId());
                    }
                }
            }
        }
    }
}
