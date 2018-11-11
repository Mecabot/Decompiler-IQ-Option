package com.jumio.core.mvp.model;

public interface Subscriber<Result> {
    void onError(Throwable th);

    void onResult(Result result);
}
