package com.enes.utility;

@FunctionalInterface
public interface Function<U, V, Y> {
    Y apply(U u, V v);
}
