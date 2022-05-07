package headfirst;

import java.util.Scanner;

public class GameStart {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DotCom dotCom = new DotCom();

        int[] location = {2, 3, 4};
        dotCom.setLocationCells(location);

        System.out.print("Введите ваш вариант: ");
        String userGuess = scanner.next();
        String result = dotCom.checkYourself(userGuess);

        System.out.println(result);
    }
}
