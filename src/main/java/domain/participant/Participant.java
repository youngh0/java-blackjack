package domain.participant;

import domain.card.Card;
import domain.card.Hand;

import java.util.List;

public abstract class Participant {
    protected static final String DEALER_NAME = "딜러";
    private static final int BUST_BOUNDARY_VALUE = 21;

    private final Hand hand;
    private final Name name;

    public Participant(List<Card> cards, Name name) {
        this.hand = new Hand(cards);
        this.name = name;
    }

    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    public int getHandValue() {
        return hand.calculateValue();
    }

    public List<String> getCardNames() {
        return hand.getCardNames();
    }

    public List<Card> getCards() {
        return hand.getCards();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isBust() {
        return hand.calculateValue() > BUST_BOUNDARY_VALUE;
    }

    abstract public boolean shouldHit();
}
