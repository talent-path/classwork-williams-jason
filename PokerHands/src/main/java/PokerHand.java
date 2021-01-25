import java.util.HashMap;
import java.util.Map;

public class PokerHand {
    //field variables
    //we'll "compose" a poker hand from multiple sub-objects that we pull into a collection
    private Card[] cards;

    WinType win;

    static WinType[] winType = {
            WinType.ROYALFLUSH,
            WinType.STRAIGHTFLUSH,
            WinType.FOUROFKIND,
            WinType.FULLHOUSE,
            WinType.FLUSH,
            WinType.STRAIGHT,
            WinType.THREEOFKIND,
            WinType.TWOPAIR,
            WinType.ONEPAIR,
            WinType.HIGHCARD
    };

    //need a constructor to make sure every hand is built with all the cards needed
    public PokerHand(Card[] cards) {
        //for now we'll cross our fingers and hope its always 5
//        if( cards.length < 5 ){
//            //TODO: create a specific exception for this
//            throw new Exception("Invalid number of cards.");
//        }


        this.cards = cards;

        sortCards();
    }

    private void sortCards() {

        //bubble sort
        boolean sorted = false;

        while (!sorted) {

            sorted = true;
            for (int i = 0; i < cards.length - 1; i++) {
                //does the element at i need to be flipped with the element at i + 1?
                if ((cards[i].getCardValue().value < cards[i + 1].getCardValue().value) ||

                        (cards[i].getCardValue().value == cards[i + 1].getCardValue().value
                                && cards[i].getCardSuit().value < cards[i + 1].getCardSuit().value
                        )
                ) {
                    //we need to swap elements at i and i + 1
                    //it also means we found elements out of order
                    sorted = false;
                    Card temp = cards[i + 1];
                    cards[i + 1] = cards[i];
                    cards[i] = temp;
                }
            }

        }

    }

    public Card[] getCards() {
        return cards;
    }

    public Map<FaceValue, Integer> countFaceValues() {

        Map<FaceValue, Integer> count = new HashMap<>();

        for (Card toCount : cards) {
            if (!count.containsKey(toCount.getCardValue())) {
                count.put(toCount.getCardValue(), 0);
            }

            Integer currentCount = count.get(toCount.getCardValue());

            count.put(toCount.getCardValue(),
                    1 + currentCount);

        }

        return count;
    }

    public Map<Suit, Integer> countSuits() {

        Map<Suit, Integer> count = new HashMap<>();

        for (Card toCount : cards) {
            if (!count.containsKey(toCount.getCardSuit())) {
                count.put(toCount.getCardSuit(), 0);
            }

            Integer currentCount = count.get(toCount.getCardSuit());

            count.put(toCount.getCardSuit(),
                    1 + currentCount);

        }

        return count;
    }


    //if no straight, return a null
    public FaceValue straightHighCardValue() {
        FaceValue straight = null;
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].cardValue.value == cards[i + 1].cardValue.value + 1) {
                if (i == 3) {
                    straight = cards[0].getCardValue();
                }
            } else break;
        }
        return straight;
    }


    public boolean isFlush() {
        boolean isFl = false;
        Suit pair = null;
        for (Suit key : countSuits().keySet()) {
            if (countSuits().get(key) == 5) {
                isFl = true;
            }
        }
        return isFl;
    }

    public boolean isStraightFlush() {
        return (straightHighCardValue() != null) && isFlush();
    }

    public boolean isFullHouse() {
        return pairValue() != null && threeOfAKindValue() != null;
    }

    public boolean isRoyalFlush() {
        return isStraightFlush() && cards[0].getCardValue() == FaceValue.ACE;
    }

    //if not 4 of a kind, return null
    public FaceValue fourOfAKindValue() {
        FaceValue pair = null;
        for (FaceValue key : countFaceValues().keySet()) {
            if (countFaceValues().get(key) == 4) {
                pair = key;
            }
        }
        return pair;
    }

    //should return null if there are really 4
    public FaceValue threeOfAKindValue() {
        FaceValue pair = null;
        for (FaceValue key : countFaceValues().keySet()) {
            if (countFaceValues().get(key) == 3) {
                pair = key;
            }
        }
        return pair;
    }

    //should return null if there are really 3 (or more of the same card)
    public FaceValue pairValue() {

        FaceValue pair = null;
        for (FaceValue key : countFaceValues().keySet()) {
            if (countFaceValues().get(key) > 2) {
                pair = key;
            }
        }
        return pair;

    }

    //should return null when there is only one pair
    public FaceValue lowerPairValue() {

        FaceValue pair = null;
        for (FaceValue key : countFaceValues().keySet()) {
            if (countFaceValues().get(key) == 2) {
                if (key != pairValue())
                    pair = key;
            }
        }
        return pair;

    }


    //return 0 if "this" ties with "that"
    //return negative number if "this" wins over "that"
    //return positive number if "this" loses to "that"


    public int compareTo(PokerHand that) {

        if (this.straightHighCardValue() != null && that.straightHighCardValue() != null) {
            if (this.straightHighCardValue().value > that.straightHighCardValue().value) {
                return -1;
            } else if (this.straightHighCardValue().value < that.straightHighCardValue().value) {
                return 1;
            } else return 0;
        } else if (this.isFlush() && that.isFlush()) {
            return 0;
        } else if (this.isFlush() && !that.isFlush()) {
            return -1;
        } else if (!this.isFlush() && that.isFlush()) {
            return 1;
        } else if (this.isStraightFlush() && that.isStraightFlush()) {
            return 0;
        } else if (this.isStraightFlush() && !that.isStraightFlush()) {
            return -1;
        } else if (!this.isStraightFlush() && that.isStraightFlush()) {
            return 1;
        } else if (this.isFullHouse() && that.isFullHouse()) {
            return 0;
        } else if (this.isFullHouse() && !that.isFullHouse()) {
            return -1;
        } else if (!this.isFullHouse() && that.isFullHouse()) {
            return 1;
        } else if (this.isRoyalFlush() && that.isRoyalFlush()) {
            return 0;
        } else if (this.isRoyalFlush() && !that.isRoyalFlush()) {
            return -1;
        } else if (!this.isRoyalFlush() && that.isRoyalFlush()) {
            return 1;
        } else if (this.fourOfAKindValue() != null && that.fourOfAKindValue() != null) {
            if (this.fourOfAKindValue().value > that.fourOfAKindValue().value) {
                return -1;
            } else if (this.fourOfAKindValue().value < that.fourOfAKindValue().value) {
                return 1;
            } else return 0;
        } else if (this.threeOfAKindValue() != null && that.threeOfAKindValue() != null) {
            if (this.threeOfAKindValue().value > that.threeOfAKindValue().value) {
                return -1;
            } else if (this.threeOfAKindValue().value < that.threeOfAKindValue().value) {
                return 1;
            } else return 0;
        } else if (this.pairValue() != null && that.pairValue() != null) {
            if (this.pairValue().value > that.pairValue().value) {
                return -1;
            } else if (this.pairValue().value < that.pairValue().value) {
                return 1;
            } else return 0;
        } else if (this.lowerPairValue() != null && that.lowerPairValue() != null) {
            if (this.lowerPairValue().value > that.lowerPairValue().value) {
                return -1;
            } else if (this.lowerPairValue().value < that.lowerPairValue().value) {
                return 1;
            } else return 0;
        } else if (this.cards[0].getCardValue().value > that.cards[0].getCardValue().value) {
            return -1;
        } else if (this.cards[0].getCardValue().value < that.cards[0].getCardValue().value) {
            return 1;
        }
        return 0;


    }


}

//in general compareTo() sematics are
// - means "this before that"
// 0 means "they're equal"
// + means "that before this"




