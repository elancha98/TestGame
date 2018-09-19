package com.example.ernestolanchares.testgame;

import static com.example.ernestolanchares.testgame.Card.Suit.*;

public class Trick {
    private Card[] cards = new Card[4];
    private Card highestCard;                   // highest.suit must be either suit or hand.getTrump()
    private int nCards = 0, points = 1;
    private Player next, winner;
    private Hand hand;
    private Card.Suit suit;

    public Trick(Player beginner, Hand hand, Card.Suit suit) {
        next = beginner;
        this.hand = hand;
        this.suit = suit;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public Player getWinner() {
        return winner;
    }

    public int throwCard(Card card) {
        if (nCards < 0 || nCards > 3) {
            throw new IllegalArgumentException("Trick has " + nCards + " cards");
        }

        cards[nCards++] = card;
        if (isHigher(card)) {
            winner = next;
            highestCard = card;
        }
        next = hand.getGame().getPlayerById((next.getId() + 1) % 4);

        points += card.getCardPoints();

        return points;
    }

    // Returns if card1 is higher than card2.
    // Pre: card2.suit is either suit or hand.getTrump().
    public boolean isHigher(Card card1) {
        if (highestCard.getSuit() == suit) {
            if (card1.getSuit() == suit) return card1.getValue() > highestCard.getValue();
            else if (card1.getSuit() == hand.getTrump()) return true;
        }
        else if (card1.getSuit() == hand.getTrump())
            return card1.getValue() > highestCard.getValue();
        return false;
    }
}