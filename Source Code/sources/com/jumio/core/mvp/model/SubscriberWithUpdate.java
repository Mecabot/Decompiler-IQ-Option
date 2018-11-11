package com.jumio.core.mvp.model;

public interface SubscriberWithUpdate<Update, Result> extends Subscriber<Result> {
    void onUpdate(Update update);
}
