package com.pro100svitlo.creditCardNfcReader.parser.apdu.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: Data */
public @interface c {
    String aSh() default "yyyyMMdd";

    int aSi() default 0;

    boolean aSj() default false;

    String aSk();

    int index();

    int size();
}
