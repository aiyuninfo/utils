package com.aiyun.utils.impl;

import com.aiyun.utils.ListUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by zhaoy on 2016/12/8.
 */
public class ListUtilsImpl<T> implements ListUtils<T>,Serializable {

    private static final long serialVersionUID = 867755909294344L;

    private List<T> content = new ArrayList();

    public ListUtilsImpl() {

    }

    public ListUtilsImpl(List<T> content) {
        this.content = content;
    }

    @Override
    public <S> ListUtils<S> map(Converter<? super T, ? extends S> var1) {
        return new ListUtilsImpl(this.getConvertedContent(var1));
    }

    @Override
    public Optional<List<T>> getList() {
        Optional <List<T>> optional = Optional.ofNullable(content);
        return optional;
    }

    protected <S> List<S> getConvertedContent(Converter<? super T, ? extends S> converter) {
        Assert.notNull(converter, "Converter must not be null!");
        ArrayList result = new ArrayList(this.content.size());
        Iterator<T> var3 = this.iterator();
        while(var3.hasNext()) {
            T element = var3.next();
            result.add(converter.convert(element));
        }
        return result;
    }

    public Iterator<T> iterator() {
        return this.content.iterator();
    }


}
