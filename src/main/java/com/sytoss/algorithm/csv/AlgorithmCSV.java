package com.sytoss.algorithm.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgorithmCSV {

    private static final String separators = ",";

    public static String read(String path) throws FileNotFoundException {
        File file = new File(path);

        Scanner sc = new Scanner(file);

        StringBuilder str = new StringBuilder();

        while (sc.hasNextLine()) {
            str.append(sc.nextLine());
            str.append('\n');
        }

        return str.toString();

    }

    public static String[] splitToLines(String path) throws FileNotFoundException {
        String rawTxt = read(path);
        return rawTxt.split("\n");
    }

    public static String[][] createRawMatrix(String path) throws FileNotFoundException {
        String[] array = AlgorithmCSV.splitToLines(path);

        String[][] matrix = new String[array.length][];

        for (int i = 0; i < array.length; i++) {
            matrix[i] = array[i].split(separators);

            /*StringBuilder words = new StringBuilder();

            int start = 0, endl = 0;
            Boolean isComplex = false;

            for (int j = 0; j < array[i].toCharArray().length; j++) {
                /*if(array[i].toCharArray()[j] == '\"') {
                    isComplex = true;
                }

                if(j+1 < array[i].toCharArray().length &&
                         array[i].toCharArray()[j] == '\"' &&
                         array[i].toCharArray()[j + 1] == ',') {
                    isComplex = true;
                }

                if()

            }

            matrix[i] = words.toString().split("#");*/

        }

        return matrix;
    }

    public static String[][] createMatrix(String path) throws FileNotFoundException {

        String[][] matrix = AlgorithmCSV.createRawMatrix(path);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {


                StringBuilder word = new StringBuilder(matrix[i][j]);

                for (int k = 0; k < word.length(); k++) {

                    if(!Character.isLetterOrDigit(matrix[i][j].toCharArray()[k])) {
                        word.deleteCharAt(0);
                        word.deleteCharAt(word.length()-1);

                        break;
                    }
                }

                matrix[i][j] = word.toString();
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                StringBuilder word = new StringBuilder(matrix[i][j]);

                for (int k = 0; k < word.length(); k++) {

                    if(matrix[i][j].toCharArray()[k] == '\"') {
                        if(k + 1 < matrix[i][j].toCharArray().length && matrix[i][j].toCharArray()[k + 1] == '\"')
                        word.deleteCharAt(k);
                    }
                }

                matrix[i][j] = word.toString();


            }
        }


        return matrix;

    }
}
