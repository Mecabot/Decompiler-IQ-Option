package com.jumio.core.mvp.model;

public abstract class DynamicModel<Input, Update, Result> extends PublisherWithUpdate<Update, Result> implements Model {
    public abstract void feed(Input input);
}
