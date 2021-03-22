package com.sytoss.algorithm.csv;


import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;
import static org.testng.AssertJUnit.*;

public class AlgorithmCSVTest {

    private static final String path = "D:\\DevEnv\\Compilers\\algorithmCSV\\src\\main\\resources\\list.csv";

    @Test
    public static void readFromCSV() {


        try {

            assertEquals(AlgorithmCSV.read(path), "1,Jenya,Vasiliev,\"22.03.1995\",\"Our \"\"mentor\"\".\"\n" +
                                                        "2,Danylo,Hrechyshkin,\"01.10.2001\",\"Team member.\"\n" +
                                                        "3,Mihsha,Jilin,\"05.04.2002\",\"Team member.\"\n");

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }


    }

    @Test
    public static void splitToLines() {

        try {
            String[] lines = AlgorithmCSV.splitToLines(path);
            assertTrue(Arrays.equals(lines, new String[] {"1,Jenya,Vasiliev,\"22.03.1995\",\"Our \"\"mentor\"\".\"",
                                                          "2,Danylo,Hrechyshkin,\"01.10.2001\",\"Team member.\"",
                                                          "3,Mihsha,Jilin,\"05.04.2002\",\"Team member.\""}));

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }


    }

    @Test
    public static void splitToWords() {


        try {
            String[][] matrix = AlgorithmCSV.createRawMatrix(path);
            String[][] expected = new String[][] {
                    {"1","Jenya","Vasiliev","\"22.03.1995\"","\"Our \"\"mentor\"\".\""},
                    {"2","Danylo","Hrechyshkin","\"01.10.2001\"","\"Team member.\""},
                    {"3","Mihsha","Jilin","\"05.04.2002\"","\"Team member.\""}
            };

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    assertEquals(matrix[i][j], expected[i][j]);
                }
            }


        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }

    /////////side events isn't
    ////////Do not detect the comma in "".
    @Test
    public static void cleanUpLines() {

        try {
            String[][] matrix = AlgorithmCSV.createMatrix(path);
            String[][] expected = new String[][] {{"1","Jenya", "Vasiliev", "22.03.1995", "Our \"mentor\"."}};

            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    assertEquals(expected[i][j], matrix[i][j]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
