package io.github.dlebedev.yatpoker;

public interface PokerStyleFactory {
    public Player createPlayer();
    public Dealer createDealer();
    public Table createTable();
}
