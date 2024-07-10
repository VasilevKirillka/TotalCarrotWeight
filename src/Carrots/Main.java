package Carrots;

public class Main {
    public static void main(String[] args) {
        int[] carrotsWeight = {1, 2, 3, 4, 5};
        int moves = 10;
        int maxWeightPerMove = 5;
        int totalCarrotsWeight = getTotalCarrotsWeight(carrotsWeight, maxWeightPerMove, moves);
        System.out.println("Максимальное количество моркови за 1 день: " + totalCarrotsWeight + " кг");
    }
    private static int getTotalCarrotsWeight(int[] carrotWeights, int maxWeightPerMove, int moves) {
        int max = Integer.MIN_VALUE;
        for (int carrotWeight : carrotWeights) {
            if (max <= carrotWeight && carrotWeight <= maxWeightPerMove) {
                max = carrotWeight;
            }
        }
        return max*moves;
    }
}
