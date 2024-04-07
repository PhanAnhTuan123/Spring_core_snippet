package dev.anhTuan.dto_mapper.mapper;

public interface Mapper<A,B> {
    B mapTo(A a);

    A mapFrom(B b);
}
