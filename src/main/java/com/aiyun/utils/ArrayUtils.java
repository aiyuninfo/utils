package com.aiyun.utils;

import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.Optional;

/**
 * Created by zhaoy on 2016/12/8.
 * 数组操作工具类
 */
public interface ArrayUtils<T> {

    <S> ArrayUtils<S> map(Converter<? super T, ? extends S> var1);

     Optional<List<T>> getList();
}
