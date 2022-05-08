package headfirst;

public class GameStart {

    public static void main(String[] args) {
        int numOfGuesses = 0;

        GameHelper gameHelper = new GameHelper();

        DotCom dotCom = new DotCom();
        int randomNum = (int) (Math.random() * 5);

        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        dotCom.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive == true) {
            String guess = gameHelper.getUserInput("Введите число: ");
            String result = dotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("Потопил")) {
                isAlive = false;
                System.out.println("Для победы вам потребовалось " + numOfGuesses + " ходов");
            }
        }
    }
}