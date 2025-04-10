import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        Матрица для примера
        Результаты:
        L = 23
        Ветви остова:
        [0, 2], [2, 5], [5, 1], [1, 3], [3, 4], [5, 6]
         */
        int[][] initializeMatrix1 = {
                {Integer.MAX_VALUE, 19, 5, 14, 8, 12, 9},
                {19, Integer.MAX_VALUE, Integer.MAX_VALUE, 2, 5, 5, Integer.MAX_VALUE},
                {5, Integer.MAX_VALUE, Integer.MAX_VALUE, 6, Integer.MAX_VALUE, 3, 7},
                {14, 2, 6, Integer.MAX_VALUE, 3, 9, Integer.MAX_VALUE},
                {8, 5, Integer.MAX_VALUE, 3, Integer.MAX_VALUE, 8, 6},
                {12, 5, 3, 9, 8, Integer.MAX_VALUE, 5},
                {9, Integer.MAX_VALUE, 7, Integer.MAX_VALUE, 6, 5, Integer.MAX_VALUE},
        };

//        int[][] initializeMatrix2 = {
//                {Integer.MAX_VALUE, 2, 6, 9, 8, 9},
//                {2, Integer.MAX_VALUE, 3, 8, 10, 12},
//                {6, 3, Integer.MAX_VALUE, 6, 12, 10},
//                {9, 8, 6, Integer.MAX_VALUE, 8, 3},
//                {8, 10, 12, 8, Integer.MAX_VALUE, 2},
//                {9, 12, 10, 3, 2, Integer.MAX_VALUE},
//        };

        Model model = new Model(initializeMatrix1);
        model.PrimaKraskala();

        System.out.println("Ветви остова: ");
        model.getArcs().forEach(e -> System.out.println(Arrays.toString(e)));

        System.out.println();
        System.out.println();
        System.out.println("L: " + model.getL());
        System.out.println();

        System.out.println("Матрица после изменений (для проверки): ");
        Arrays.stream(model.getMatrix()).forEach(e -> System.out.println(Arrays.toString(e)));
    }
}