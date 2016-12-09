package com.aiyun.utils;


import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by zhaoy on 2016/12/8.
 * 数组操作工具类
 */
public interface ArrayUtils<T> {

    <U> ArrayUtils<U> map(Converter<? super T, ? extends U> var1);

     Optional<List<T>> getList();

    ArrayUtils<T> filter(Predicate<? super T> predicate);
}
