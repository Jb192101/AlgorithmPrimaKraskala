/*
Класс для модели
Реализация алгоритма Прима-Краскала
 */

import java.util.*;

public class Model {
    private final boolean[] b;
    private int countOfComplete = 0;
    private boolean isFull = false;
    private final int[][] matrix;
    private Set<Integer> indexes = new HashSet<>();
    private List<Integer[]> arcs;
    private int L = 0;

    private int cycleIteration = 0;

    public Model(int[][] _matrix) {
        this.b = new boolean[_matrix.length];
        for(int i = 0; i < _matrix.length; i++) {
            b[i] = false;
        }

        this.matrix = _matrix;
        this.arcs = new ArrayList<>();
    }

    // Реализация алгоритма Прима-Краскала
    public void PrimaKraskala() {
        // Шаг 1
        b[0] = true;
        indexes.add(0);
        countOfComplete++;

        // Шаг 2-3-4
        while(!isFull) {
            int min = Integer.MAX_VALUE;
            int ind1 = -1, ind2 = -1;
            for(int i : indexes) {
                for(int j = 0; j < matrix.length; j++) {
                    if(!indexes.contains(j) && matrix[i][j] != Integer.MAX_VALUE && min > matrix[i][j]) {
                        min = matrix[i][j];
                        ind1 = i;
                        ind2 = j;
                    }
                }
            }

            arcs.add(new Integer[] {ind1, ind2});
            indexes.add(ind2);
            countOfComplete++;
            b[ind2] = true;
            L += matrix[ind1][ind2];
            matrix[ind1][ind2] = Integer.MAX_VALUE;
            matrix[ind2][ind1] = Integer.MAX_VALUE;
            if(countOfComplete == matrix.length) {
                isFull = true;
            }
            cycleIteration++;
            printIterationInfo();
        }


    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    public List<Integer[]> getArcs() {
        return this.arcs;
    }

    public int getL() {
        return this.L;
    }

    private void printIterationInfo() {
        System.out.println();
        System.out.println("Итерация #" + this.cycleIteration);
        System.out.println();
        System.out.println("Вектор B: " + Arrays.toString(this.b));
        System.out.println("Множество Xp: " + this.indexes);
        System.out.print("Множество Ap: ");
        for(Integer[] a : this.arcs) {
            System.out.print(Arrays.toString(a));
        }
        System.out.println();
        System.out.println("L: " + this.L);
    }
}
