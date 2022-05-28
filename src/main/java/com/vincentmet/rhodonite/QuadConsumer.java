package com.vincentmet.rhodonite;

import java.util.Objects;

@FunctionalInterface
public interface QuadConsumer<A, B, C, D> {
    void accept(A a, B b, C c, D d);

    default QuadConsumer<A, B, C, D> andThen(QuadConsumer<A, B, C, D> after) {
        Objects.requireNonNull(after);
        return (e, f, g, h) -> {
            accept(e, f, g, h);
            after.accept(e, f, g, h);
        };
    }
}