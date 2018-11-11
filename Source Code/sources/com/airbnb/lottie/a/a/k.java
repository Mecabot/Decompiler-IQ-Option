package com.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* compiled from: MergePathsContent */
public class k implements i, l {
    private final List<l> kG = new ArrayList();
    private final Path kV = new Path();
    private final Path kW = new Path();
    private final MergePaths kX;
    private final Path kr = new Path();
    private final String name;

    public k(MergePaths mergePaths) {
        if (VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.kX = mergePaths;
    }

    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b bVar = (b) listIterator.previous();
            if (bVar instanceof l) {
                this.kG.add((l) bVar);
                listIterator.remove();
            }
        }
    }

    public void a(List<b> list, List<b> list2) {
        for (int i = 0; i < this.kG.size(); i++) {
            ((l) this.kG.get(i)).a(list, list2);
        }
    }

    public Path getPath() {
        this.kr.reset();
        switch (this.kX.et()) {
            case Merge:
                dv();
                break;
            case Add:
                a(Op.UNION);
                break;
            case Subtract:
                a(Op.REVERSE_DIFFERENCE);
                break;
            case Intersect:
                a(Op.INTERSECT);
                break;
            case ExcludeIntersections:
                a(Op.XOR);
                break;
        }
        return this.kr;
    }

    public String getName() {
        return this.name;
    }

    private void dv() {
        for (int i = 0; i < this.kG.size(); i++) {
            this.kr.addPath(((l) this.kG.get(i)).getPath());
        }
    }

    @TargetApi(19)
    private void a(Op op) {
        this.kW.reset();
        this.kV.reset();
        for (int size = this.kG.size() - 1; size >= 1; size--) {
            l lVar = (l) this.kG.get(size);
            if (lVar instanceof c) {
                c cVar = (c) lVar;
                List dq = cVar.dq();
                for (int size2 = dq.size() - 1; size2 >= 0; size2--) {
                    Path path = ((l) dq.get(size2)).getPath();
                    path.transform(cVar.dr());
                    this.kW.addPath(path);
                }
            } else {
                this.kW.addPath(lVar.getPath());
            }
        }
        int i = 0;
        l lVar2 = (l) this.kG.get(0);
        if (lVar2 instanceof c) {
            c cVar2 = (c) lVar2;
            List dq2 = cVar2.dq();
            while (i < dq2.size()) {
                Path path2 = ((l) dq2.get(i)).getPath();
                path2.transform(cVar2.dr());
                this.kV.addPath(path2);
                i++;
            }
        } else {
            this.kV.set(lVar2.getPath());
        }
        this.kr.op(this.kV, this.kW, op);
    }
}
