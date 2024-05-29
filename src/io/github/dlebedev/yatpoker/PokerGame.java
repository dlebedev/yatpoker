package io.github.dlebedev.yatpoker;

public abstract class PokerGame implements Runnable {
    private BettingStructure bettingStructure;
    private PokerStyleFactory factory;

    public BettingStructure getBettingStructure() {
        return bettingStructure;
    }

    public void setBettingStructure(BettingStructure bettingStructure) {
        this.bettingStructure = bettingStructure;
    }

    public PokerStyleFactory getFactory() {
        return factory;
    }

    public void setFactory(PokerStyleFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {

    }
}
