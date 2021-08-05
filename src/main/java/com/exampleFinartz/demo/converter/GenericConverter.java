package com.exampleFinartz.demo.converter;

public interface GenericConverter<S, T> {
    T convert(S source);
}
