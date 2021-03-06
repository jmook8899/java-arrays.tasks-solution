package com.lugowoy.tasks.multidimensional.firstTaskForFormationOfSquareMatrixAccordingToGivenPattern;

import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 15.10.2017. */

public class Main {

    private static final int BOUND = 50;

    public static void main(String[] args) {

        System.out.println("Enter the length of the matrix elements : ");
        int n = ArrayLength.getLengthArray(new ReadingConsole(), BOUND);

        int [][] array = new int[n][n];
        int k = 1, num = n;

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = k;
                    k++;
                }
                k = 1;
            } else {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = num;
                    num--;
                }
                num = n;
            }
        }


        System.out.println("Result matrix : ");
        for(int i = 0; i < array.length; i++) {
            for(int  j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

}
