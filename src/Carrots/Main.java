package Carrots;

import java.util.*;

public class Main {
    private final static int MOVES = 10;
    private final static int MAX_WEIGHT_PER_MOVE = 5;

    public static void main(String[] args) {
        Field[] fields = {
                new Field("Поле 1", 8, 1),
                new Field("Поле 2", 5, 2),
                new Field("Поле 3", 5, 3),
                new Field("Поле 4", 4, 4),
                new Field("Поле 5", 5, 5)
        };

        int totalCarrotsWeight = calculateTotalCarrotsWeight(fields);

        System.out.println("Максимальное количество моркови за 10 попыток: " + totalCarrotsWeight + " кг");
    }

    private static int calculateTotalCarrotsWeight(Field[] fields) {
        List<Integer> weightMoveList = new ArrayList<>();
        for (Field field : fields) {
            int weightCarrotOnField = field.getCarrotsWeight();
            int availableCarrotsOnField = field.getCarrotsCount();
            while (availableCarrotsOnField > 0) {
                if (weightCarrotOnField > MAX_WEIGHT_PER_MOVE) {
                    break;
                }
                int maxCarrotsToTake = MAX_WEIGHT_PER_MOVE / weightCarrotOnField;
                int carrotsToTake = Math.min(maxCarrotsToTake, availableCarrotsOnField);
                availableCarrotsOnField -= carrotsToTake;
                weightMoveList.add(carrotsToTake * weightCarrotOnField);
            }
        }
        return weightMoveList.stream().sorted(Comparator.reverseOrder())
                .limit(MOVES).mapToInt(Integer::intValue).sum();
    }
}

class Field {
    private String name;
    private int carrotsCount;
    private int carrotsWeight;

    public Field(String name, int carrotsCount, int carrotsWeight) {
        this.name = name;
        this.carrotsCount = carrotsCount;
        this.carrotsWeight = carrotsWeight;
    }

    public int getCarrotsCount() {
        return carrotsCount;
    }

    public int getCarrotsWeight() {
        return carrotsWeight;
    }

    public String getName() {
        return name;
    }
}
