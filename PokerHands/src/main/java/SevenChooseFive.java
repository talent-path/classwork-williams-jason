import java.util.ArrayList;
import java.util.List;

public class SevenChooseFive {


    public static int[] numOfWins (
            Card[] possible,
            int nextIndex,
            List<Card> currentlySelected,
            List<List<Card>> allCombinations){



    }
    private static void sevenChooseFive(
            Card[] possible,
            int nextIndex,
            List<Card> currentlySelected,
            List<List<Card>> allCombinations){

        int chosenCard = currentlySelected.size();
        int remaingCards = 5 - chosenCard;
        int availableCards = possible.length-nextIndex;

        if( currentlySelected.size() == 5 ){
            List<Card> copy = new ArrayList<>();
            for( Card toCopy : currentlySelected ) copy.add( toCopy );

            allCombinations.add( copy );
            return;
        }

        if( availableCards < remaingCards )
            return;

        currentlySelected.add( possible[nextIndex] );
        sevenChooseFive( possible, nextIndex +1, currentlySelected, allCombinations);

        currentlySelected.remove( currentlySelected.size() - 1 );

        //try without choosing the card
        sevenChooseFive( possible, nextIndex + 1, currentlySelected, allCombinations);
    }
}
