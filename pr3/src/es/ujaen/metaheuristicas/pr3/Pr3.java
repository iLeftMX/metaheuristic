package es.ujaen.metaheuristicas.pr3;

import es.ujaen.metaheuristicas.pr3.algorithms.AGG;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Programa principal.
 *
 * @author Raúl Moya Reyes <www.raulmoya.es>
 */
public class Pr3 {

    public static void main(String[] args) {

        /* Semillas - 77358477, 73584777, 35847777, 58477773, 84777735 */
        List<Integer> seeds = new ArrayList(
                Arrays.asList(new Integer[]{77358477, 73584777, 35847777, 58477773, 84777735})
        );

        /* Menú */
        Scanner in = new Scanner(System.in);
        System.out.println("Selecciona el dataset: \n 1 - Breast \n 2 - R15 \n 3 - Yeast");
        int dataset = in.nextInt();
        System.out.println("");
        System.out.println("Selecciona el algoritmo: \n 1 - MA (10,1.0) \n 2 - MA (10,0.1)");
        int algorithm = in.nextInt();
        System.out.println("\n");

        switch (dataset) {
            case 1:
                run("breast.txt", 699, seeds, 2, algorithm);
                break;
            case 2:
                run("R15.txt", 600, seeds, 15, algorithm);
                break;
            case 3:
                run("yeast.txt", 1484, seeds, 10, algorithm);
                break;
        }

    }

    private static Float run(String fileName, Integer size, List<Integer> seeds, Integer numberClusters, Integer algorithm) {

        float finalCost = 0;
        for (Integer seed : seeds) {
            switch (algorithm) {
                case 1:
                    finalCost = AGG.init(fileName, size, seed, numberClusters, 10, 1f);
                    break;
                case 2:
                    finalCost = AGG.init(fileName, size, seed, numberClusters, 10, 0.1f);
                    break;
            }
        }
        return finalCost;
    }

}
