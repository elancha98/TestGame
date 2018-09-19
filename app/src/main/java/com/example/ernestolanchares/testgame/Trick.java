package com.example.ernestolanchares.testgame;

public class Trick {
    private Card[] cards = new Card[4];
    private Card highest;
    private int nCards = 0, points = 1;
    private Player next, winner;
    private Hand hand;
    private Card.Suit suit;

    public Trick(Player beginner, Hand hand) {
        next = beginner;
        this.hand = hand;
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
        if (hand.higher(card, highest)) {
            winner = next;
            highest =
        }
        next = hand.getGame().getPlayerById((next.getId() + 1) % 4);

        points += card.getCardPoints();

        return points;
    }
}
