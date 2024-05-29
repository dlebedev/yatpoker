package io.github.dlebedev.yatpoker;

public class BettingStructure {
    double bigBlind;
    double smallBlind;
    double ante;
    LimitType limitType;

    public BettingStructure(double bigBlind, double smallBlind, double ante, LimitType limitType) {
        this.bigBlind = bigBlind;
        this.smallBlind = smallBlind;
        this.ante = ante;
        this.limitType = limitType;
    }

    public double getBigBlind() {
        return bigBlind;
    }

    public void setBigBlind(double bigBlind) {
        this.bigBlind = bigBlind;
    }

    public double getSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(double smallBlind) {
        this.smallBlind = smallBlind;
    }

    public double getAnte() {
        return ante;
    }

    public void setAnte(double ante) {
        this.ante = ante;
    }

    @Override
    public String toString() {
        return "BettingStructure{" +
                "bigBlind=" + bigBlind +
                ", smallBlind=" + smallBlind +
                '}';
    }
}
