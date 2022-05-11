package headfirst;

import java.util.ArrayList;

public class DotComBust {
    // Объявляем и инициализируем нужные переменные
    private GameHelper gameHelper = new GameHelper();
    private ArrayList<DotCom> dotComsArrayList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    public void setUpGame() {
        // Создаём объекты, присваиваем им названия и добавляем их в ArrayList
        DotCom first = new DotCom();
        first.setName("Pets.com");

        DotCom second = new DotCom();
        second.setName("eToys.com");

        DotCom third = new DotCom();
        third.setName("Go2.com");

        dotComsArrayList.add(first);
        dotComsArrayList.add(second);
        dotComsArrayList.add(third);

        System.out.println("Ваша цель - за минимальное количество ходов 'потопить' 3 сайта: Pets.com, eToys.com, Go2.com");

        // Используем сеттер и устанавливаем адрес сайтов на игровом поле
        for (DotCom dotComToSet : dotComsArrayList) {
            ArrayList<String> newLocation = gameHelper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    public void startPlaying() {
        // Пока ArrayList не пуст, запрашиваем ход игрока
        while (!dotComsArrayList.isEmpty()) {
            String userGuess = gameHelper.getUserInput("Ваш ход:"); // Получаем пользовательский ввод
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    public void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Мимо";

        for (DotCom dotComToTest : dotComsArrayList) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Попал")) {
                break;
            }
            if (result.equals("Потопил")) {
                dotComsArrayList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    public void finishGame() {
        System.out.println("Ловите поздравления! Все сайты пошли ко дну.");
        if (numOfGuesses < 18) {
            System.out.println("На это у вас ушло совсем немного попыток. Всего лишь: " + numOfGuesses);
        } else {
            System.out.println("Неплохо! Ваш результат: " + numOfGuesses + " попыток");
        }
    }
}
