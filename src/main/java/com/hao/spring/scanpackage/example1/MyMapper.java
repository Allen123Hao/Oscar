package com.hao.spring.scanpackage.example1;

import java.lang.annotation.*;

/**
 * <code>MyMapper</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-10-31
 * @version: 1.0
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyMapper {
    String value() default "";
}
