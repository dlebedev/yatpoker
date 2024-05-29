package io.github.dlebedev.yatpoker;

import java.util.function.Supplier;

public enum PokerStyle {
    draw(DrawFactory::new),
    holdem(HoldemFactory::new),
    stud(StudFactory::new),
    omaha(OmahaFactory::new);

    private final Supplier<PokerStyleFactory> constructor;

    PokerStyle(Supplier<PokerStyleFactory> constructor) {
        this.constructor = constructor;
    }

    public Supplier<PokerStyleFactory> getConstructor() {
        return constructor;
    }
}
