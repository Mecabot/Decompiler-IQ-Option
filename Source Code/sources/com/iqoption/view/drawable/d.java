package com.iqoption.view.drawable;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

/* compiled from: RemoteAnimationDrawable */
final class d extends AnimationDrawable {
    private final int dFF;
    private boolean dFH;

    public d(int i) {
        this.dFF = i;
        setOneShot(true);
    }

    /* renamed from: gZ */
    public BitmapDrawable getFrame(int i) {
        return (BitmapDrawable) super.getFrame(i);
    }

    public void addFrame(@NonNull Drawable drawable, int i) {
        aIX();
        if (drawable instanceof BitmapDrawable) {
            super.addFrame(drawable, i);
            return;
        }
        throw new IllegalArgumentException("Only BitmapDrawable supported as frame");
    }

    void recycle() {
        if (!this.dFH) {
            int i = 0;
            if (isRunning()) {
                stop();
                i = 1;
            }
            int numberOfFrames = getNumberOfFrames();
            for (i = 
/*
Method generation error in method: com.iqoption.view.drawable.d.recycle():void, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r0_3 'i' int) = (r0_1 'i' int), (r0_2 'i' int) binds: {(r0_1 'i' int)=B:4:0x000b, (r0_2 'i' int)=B:5:0x000d} in method: com.iqoption.view.drawable.d.recycle():void, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:183)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:173)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:323)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:260)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:222)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 22 more

*/

    boolean isRecycled() {
        return this.dFH;
    }

    boolean isCompleted() {
        return this.dFF == getNumberOfFrames();
    }

    private void aIX() {
        if (this.dFH) {
            throw new IllegalStateException("Drawable is recycled");
        }
    }
}
