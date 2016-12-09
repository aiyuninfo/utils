package com.aiyun.utils;

/**
 * Created by zhaoy on 2016/12/9.
 */

public interface Converter<S, T> {
    T convert(S var1);
}
