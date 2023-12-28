package pl.javorek.ddd.service.applicationforloan.application.command;

import lombok.Value;

import java.util.function.BiConsumer;
import java.util.function.Function;

@Value
public class Profunctor<F, S> {
    F first;
    S second;

    <F1> Profunctor<F1, S> mapFirst(Function<F, F1> mapping) {
        return new Profunctor<>(mapping.apply(first), second);
    }

    <S1> Profunctor<F, S1> mapSecond(Function<S, S1> mapping) {
        return new Profunctor<>(first, mapping.apply(second));
    }

    void accept(BiConsumer<F, S> consumer) {
        consumer.accept(first, second);
    }
}
