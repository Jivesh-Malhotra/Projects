package ca.sheridancollege.project;

import ca.sheridancollege.project.PokerCard.Suit;
import ca.sheridancollege.project.PokerCard.Value;
import java.util.ArrayList;

public class CardDeck extends GroupOfPokers{

    public CardDeck() {
        super(52);  
        generateDeck();  //will generate 52 cards deck by default
        shuffle();
    }

    public CardDeck(int size) {
        super(size);
        generateDeck(size);
        shuffle();
    }

    private void generateDeck(int size) {
        // TODO - implement CardDeck.generateDeck
    }

    private void generateDeck() {
        ArrayList<PokerCard> cardDeck = new ArrayList();
        for (Suit suit : PokerCard.Suit.values()) {
            for (Value value : PokerCard.Value.values()) {
                cardDeck.add(new PokerCard(value, suit));
            }
        }
        setCards(cardDeck);  //set cards in GroupOfPokersStatic
    }

    public void distributeCards(int numberOfPlayer) {
        CardHand[] cardHands = new CardHand[numberOfPlayer];
        for(int i = 0; i < numberOfPlayer; i++){
            cardHands[i] = new CardHand(0);
        }

        int smallHandSize = getPokerCards().size() / numberOfPlayer; //52 can change to deck size
        int largeHandSize = smallHandSize + 1;
        int largeHandCount = getPokerCards().size() - smallHandSize * numberOfPlayer; //number of players with larger hand size
        int smallHandCount = numberOfPlayer - largeHandCount; //number of players with smaller hand size

        for (int i = 0; i < largeHandCount; i++) {
            ArrayList<PokerCard> cards = new ArrayList(getPokerCards().subList(0, largeHandSize));
            cardHands[i].setCards(cards);
            removeRangeCards(0, largeHandSize);
        }
        for (int i = 0; i < smallHandCount; i++) {
            ArrayList<PokerCard> cards = new ArrayList(getPokerCards().subList(0, smallHandSize));
            cardHands[i + largeHandCount].setCards(cards);
            removeRangeCards(0, smallHandSize);
        }
        
        CardHands.setCardHands(cardHands);
    }
}
