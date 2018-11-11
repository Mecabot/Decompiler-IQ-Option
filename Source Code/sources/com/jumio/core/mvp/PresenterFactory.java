package com.jumio.core.mvp;

import android.support.annotation.Nullable;
import com.jumio.core.mvp.presenter.Presenter;
import com.jumio.core.mvp.presenter.RequiresPresenter;

public class PresenterFactory {
    @Nullable
    public static <T extends Presenter> T createClass(Class<?> cls) {
        RequiresPresenter requiresPresenter = (RequiresPresenter) cls.getAnnotation(RequiresPresenter.class);
        if (requiresPresenter == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View ");
            stringBuilder.append(cls.getName());
            stringBuilder.append(" must be annotated with the @RequiresPresenter annotation!");
            throw new RuntimeException(stringBuilder.toString());
        }
        Class value = requiresPresenter.value();
        if (value == null) {
            return null;
        }
        try {
            return (Presenter) value.newInstance();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
