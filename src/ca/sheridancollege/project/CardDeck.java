package ca.sheridancollege.project;

import ca.sheridancollege.project.PokerCard.Suit;
import ca.sheridancollege.project.PokerCard.Value;
import java.util.ArrayList;

public class CardDeck extends GroupOfCards {

    public CardDeck(int size) {
        super(size);
        generateDeck(size);
    }

    private void generateDeck(int size) {

        // TODO - implement CardDeck.generateDeck
        for (Suit suit : PokerCard.Suit.values()) {
            for (Value value : PokerCard.Value.values()) {
                cards.add(new PokerCard(suit, value));
            }
        }
    }

    public CardHand[] distributeCards(int numberOfPlayer) {
        // TODO - implement CardDeck.distributeCards
        CardHand[] cardHands = new CardHand[numberOfPlayer];
        return cardHands;
    }
}
