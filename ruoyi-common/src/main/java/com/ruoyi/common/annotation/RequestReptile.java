package com.ruoyi.common.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解防止表单重复提交
 * 
 * @author ruoyi
 *
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestReptile
{
    /**
     * 间隔时间(ms)，小于此时间视为爬虫，直接封禁IP
     */
    public int interval() default 1000;

    /**
     * 提示消息
     */
    public String message() default "不允许重复提交，请稍候再试";
}
