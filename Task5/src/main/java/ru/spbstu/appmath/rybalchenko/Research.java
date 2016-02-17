package ru.spbstu.appmath.rybalchenko;

import ru.spbstu.appmath.rybalchenko.exceptions.DimensionsException;
import ru.spbstu.appmath.rybalchenko.exceptions.MatrixCalcException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static ru.spbstu.appmath.rybalchenko.IOMatrix.getMatrixFromFile;


public class Research {
    public static void main(String[] args) {
        try {
            doResearch("matrix_generator/A1.txt", "matrix_generator/B1.txt", "small.txt");
            doResearch("matrix_generator/A2.txt", "matrix_generator/B2.txt", "medium.txt");
            doResearch("matrix_generator/A3.txt", "matrix_generator/B3.txt", "huge.txt");
        } catch (MatrixCalcException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void doResearch(final String firstMatrix, final String secondMatrix, final String report) throws DimensionsException {
        int threads = 1;

        try (PrintWriter printWriter = new PrintWriter("research/" + report)) {
            Matrix a = getMatrixFromFile(firstMatrix);
            Matrix b = getMatrixFromFile(secondMatrix);
            for (threads = 1; threads <= 1000; threads *= 10) {
                MatrixMultiplication multiplyMatrix = new MatrixMultiplication(a, b, threads);
                long startTime = System.currentTimeMillis();
                multiplyMatrix.multiply();
                long totalTime = System.currentTimeMillis() - startTime;
                printWriter.println(threads + "\t" + totalTime);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
