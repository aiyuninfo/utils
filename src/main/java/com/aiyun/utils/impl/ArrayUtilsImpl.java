package com.aiyun.utils.impl;

import com.aiyun.utils.ArrayUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;

/**
 * Created by zhaoy on 2016/12/8.
 */
public class ArrayUtilsImpl<T> implements ArrayUtils<T>,Serializable {

    private static final long serialVersionUID = 867755909294344L;

    private List<T> content = new ArrayList();

    public ArrayUtilsImpl() {

    }

    public ArrayUtilsImpl(List<T> content) {
        this.content = content;
    }

    @Override
    public <U> ArrayUtils<U> map(Converter<? super T, ? extends U> converter) {
        Assert.notNull(converter, "Converter must not be null!");
        ArrayList result = new ArrayList(this.content.size());
        Iterator<T> var3 = this.iterator();
        while(var3.hasNext()) {
            T element = var3.next();
            result.add(converter.convert(element));
        }
        return new ArrayUtilsImpl(result);
    }

    public ArrayUtils<T> filter(Predicate<? super T> predicate){
        Objects.requireNonNull(predicate);
        ArrayList result = new ArrayList(this.content.size());
        Iterator<T> var3 = this.iterator();
        while (var3.hasNext()) {
            T element = var3.next();
            boolean test = predicate.test(element);
            if(test){
                result.add(element);
            }
        }
        return new ArrayUtilsImpl<T>(result);
    }

    @Override
    public Optional<List<T>> getList() {
        Optional <List<T>> optional = Optional.ofNullable(content);
        return optional;
    }

    public Iterator<T> iterator() {
        return this.content.iterator();
    }


}
