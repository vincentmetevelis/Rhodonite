package com.vincentmet.rhodonite;

import java.util.Objects;

@FunctionalInterface
public interface TriConsumer<A, B, C> {
    void accept(A a, B b, C c);

    default TriConsumer<A, B, C> andThen(TriConsumer<A, B, C> after) {
        Objects.requireNonNull(after);
        return (d, e, f) -> {
            accept(d, e, f);
            after.accept(d, e, f);
        };
    }
}