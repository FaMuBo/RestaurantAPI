package com.exampleFinartz.demo.models.converter;

public interface GenericConverter<S, T> {
    T convert(S source);
}
