package com.hao.spring.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * <code>MyComponet</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/1/23
 * @version: 1.0
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyComponent {
    String value() default "";
}
