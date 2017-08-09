package com.realdolmen.candyshop.interceptors;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by cda5732 on 1/03/2017.
 */
@InterceptorBinding
@Target({METHOD, TYPE})
@Retention(RUNTIME)
public @interface ActivateTimer {
}
