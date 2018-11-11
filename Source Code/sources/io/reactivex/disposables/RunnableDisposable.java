package io.reactivex.disposables;

final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    /* renamed from: t */
    protected void cc(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunnableDisposable(disposed=");
        stringBuilder.append(isDisposed());
        stringBuilder.append(", ");
        stringBuilder.append(get());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
