package dev.anhTuan_rest_api.rest_api.mappers;

public interface Mapper<A,B> {
    B mapTo(A a);
    A mapFrom(B b);

}
