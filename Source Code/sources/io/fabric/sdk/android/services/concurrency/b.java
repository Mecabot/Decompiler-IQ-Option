package io.fabric.sdk.android.services.concurrency;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* compiled from: DependsOn */
public @interface b {
    Class<?>[] value();
}
