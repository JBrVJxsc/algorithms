package com.algorithms.algorithms.sort.elementarysorts.shuffling;

import com.algorithms.algorithms.sort.elementarysorts.shuffling.interfaces.IShuffleable;

/**
 * Created by Who on 2014/4/21.
 */
public class PokerCard implements IShuffleable {
    private long index = 0;
    private String suit = "";

    public PokerCard(long index, String suit) {
        this.index = index;
        this.suit = suit;
    }

    public static PokerCard[] getDeckOfCards() {
        PokerCard[] pokerCards = new PokerCard[54];
        for (int i = 0; i < 54; i++) {
            pokerCards[i] = new PokerCard(i, String.valueOf(i));
        }
        return pokerCards;
    }

    @Override
    public long getIndex() {
        return index;
    }

    @Override
    public void setIndex(long index) {
        this.index = index;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public int compareTo(Object o) {
        PokerCard pokerCard = (PokerCard) o;
        if (index > pokerCard.index) {
            return 1;
        } else if (index < pokerCard.index) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return getSuit();
    }
}
