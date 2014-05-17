package com.algorithms.algorithms.sort.elementarysorts.shuffling.exercises;

import com.algorithms.algorithms.BaseAlgorithm;
import com.algorithms.algorithms.sort.elementarysorts.shuffling.KnuthShuffle;
import com.algorithms.algorithms.sort.elementarysorts.shuffling.PokerCard;
import com.algorithms.algorithms.sort.elementarysorts.shuffling.SortShuffle;
import com.algorithms.algorithms.sort.elementarysorts.shuffling.interfaces.IShuffle;
import com.algorithms.algorithms.sort.elementarysorts.shuffling.interfaces.IShuffleable;
import com.algorithms.interfaces.IAlgorithm;

/**
 * Created by Who on 2014/4/21.
 */
public class Exercise1 extends BaseAlgorithm implements IAlgorithm {
    @Override
    public long getID() {
        return 1398083687273l;
    }

    @Override
    public String getName() {
        return "Exercise #1 for Shuffle";
    }

    @Override
    public String getSummary() {
        return null;
    }

    @Override
    public void run() {
        PokerCard[] pokerCards = PokerCard.getDeckOfCards();
        print("SortShuffle:");
        testSortShuffle(pokerCards.clone());
        print();
        print("KnuthShuffle:");
        testKnuthShuffle(pokerCards.clone());
    }

    private void testSortShuffle(IShuffleable[] iShuffleables) {
        print("Original Deck:");
        printDeck(iShuffleables);
        IShuffle iShuffle = new SortShuffle();
        iShuffle.shuffle(iShuffleables);
        print("First shuffle:");
        printDeck(iShuffleables);
        iShuffle.shuffle(iShuffleables);
        print("Second shuffle:");
        printDeck(iShuffleables);
    }

    private void testKnuthShuffle(IShuffleable[] iShuffleables) {
        print("Original Deck:");
        printDeck(iShuffleables);
        KnuthShuffle knuthShuffle = new KnuthShuffle();
        knuthShuffle.shuffle(iShuffleables);
        print("First shuffle:");
        printDeck(iShuffleables);
        knuthShuffle.shuffle(iShuffleables);
        print("Second shuffle:");
        printDeck(iShuffleables);
    }

    private void printDeck(IShuffleable[] iShuffleables) {
        String string = "";
        for (int i = 0; i < iShuffleables.length; i++) {
            string += " " + iShuffleables[i].toString();
        }
        print(string);
    }
}
