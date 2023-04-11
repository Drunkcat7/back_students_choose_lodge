package com.back_students_choose_lodge.my_interceptor;
import java.lang.annotation.*;

/**
 * 角色注解
 *
 */
@Target({ElementType.METHOD})								// 方法注解
@Retention(RetentionPolicy.RUNTIME)							// 运行时
//@Documented
public @interface Role{
    String[] roles() default {};

}
