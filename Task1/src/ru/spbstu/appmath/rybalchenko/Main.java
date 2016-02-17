package ru.spbstu.appmath.rybalchenko;

public class Main {
    public static void main(String[] args) {
        double a[] = parse(args);
        bubble(a);
        for (double i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void bubble(double arr[]) {
        boolean swapped = true;
        int j = 0;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    double tmp;
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    private static double[] parse(String[] input) {
        double res[] = new double[input.length];
        for (int i = 0; i < input.length; i++)
            res[i] = Double.parseDouble(input[i]);
        return res;
    }
}