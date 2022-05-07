package headfirst;

public class DotCom {
    private int[] locationCells;
    private int numOfHits = 0;

    String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "Мимо";
        for (int cell: locationCells){
            if (guess == cell) {
                result = "Попал";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length)
            result = "Потопил";
        return result;
    }

    void setLocationCells(int[] locs) {
        locationCells = locs;
    }
}
