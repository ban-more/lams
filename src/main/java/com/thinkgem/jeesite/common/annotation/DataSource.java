package com.thinkgem.jeesite.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by wzw on 2018/1/10.
 */
@Target({ TYPE, METHOD })
@Retention(RUNTIME)
public @interface DataSource {
    String value();
}