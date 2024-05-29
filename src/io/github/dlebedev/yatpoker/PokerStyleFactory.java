package io.github.dlebedev.yatpoker;

public interface PokerStyleFactory {
    Player createPlayer();
    Dealer createDealer();
    Table createTable();
}
