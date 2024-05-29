package io.github.dlebedev.yatpoker;

import java.util.function.Supplier;

public enum GameType {
    tournament(TournamentGame::new),
    cash(CashGame::new);

    private final Supplier<PokerGame> constructor;

    GameType(Supplier<PokerGame> constructor) {
        this.constructor = constructor;
    }

    public Supplier<PokerGame> getConstructor() {
        return constructor;
    }
}
