package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * 第一个自定义注解
 * 只有一个参数 ： 一般定义成value  使用时 value可以省
 *
 * @Target 规定注解的适用范围
 * @Retention 制定在什么时候有效
 */
@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface AnnotationFirst {
    String studentName() default "";
    int age() default 0;
    int id() default -1/**-1表示不存在*/;
}
