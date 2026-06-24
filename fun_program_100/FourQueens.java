import java.util.Arrays;
import java.util.HashSet;

public class FourQueens {
    public static void main(String[] args) {
        int[] res = new int[4];
        fourQueenDetail(res, 1, 1);
    }

    public static void fourQueenDetail(int[] res, int col, int line) {
        if (col >= 1 && col <= 4) {
            if (line <= 4) {
                res[col - 1] = line;
                if (checkXYAix(res)) {
                    if (col < 4) {
                        fourQueenDetail(res, col + 1, 1);
                    } else {
                        System.out.println(Arrays.toString(res));
                        res[col - 1] = 0;
                        fourQueenDetail(res, col, line + 1);
                    }
                } else {
                    res[col - 1] = 0;
                    fourQueenDetail(res, col, line + 1);
                }
                res[col - 1] = 0;
            } else {
                res[col - 1] = 0;
                fourQueenDetail(res, col-1, res[col - 1 - 1] + 1);

            }
        }
    }


    public static boolean checkXYAix(int[] res) {
        boolean flagPositive = true;
        boolean flagNegative = true;
        boolean flagHorizon = true;
        HashSet<Integer> checkPositive = new HashSet<>();
        HashSet<Integer> checkNegative = new HashSet<>();
        HashSet<Integer> checkHorizon = new HashSet<>();
        for (int i = 1; i <= 4; i++) {
            if (res[i - 1] != 0) {
                int tmpYminusX = res[i - 1] - i;
                int tmpXplusY = i + res[i - 1];
                if (checkPositive.contains(tmpYminusX)) {
                    flagPositive = false;
                    break;
                } else {
                    checkPositive.add(tmpYminusX);
                }

                if (checkNegative.contains(tmpXplusY)) {
                    flagNegative = false;
                    break;
                } else {
                    checkNegative.add(tmpXplusY);
                }

                if (checkHorizon.contains(res[i - 1])) {
                    flagHorizon = false;
                    break;
                } else {
                    checkHorizon.add(res[i - 1]);
                }
            }
        }

        return flagPositive & flagNegative & flagHorizon;
    }
}







package org.example;

import java.util.Arrays;
import java.util.HashSet;

public class FourQueens {
    public static void main(String[] args) {
        int[] res = new int[4];
        fourQueenDetail(res, 1, 1);
    }

    public static void fourQueenDetail(int[] res, int col, int line) {
        if (col >= 1 && col <= 4) {
            if (line <= 4) {
                res[col - 1] = line;
                if (checkXYAix(res)) {
                    if (col < 4) {
                        fourQueenDetail(res, col + 1, 1);
                    } else {
                        System.out.println(Arrays.toString(res));
                    }
                }
                res[col - 1] = 0;
                fourQueenDetail(res, col, line + 1);


            } else {
                res[col - 1] = 0;
                if (col > 1) {
                    fourQueenDetail(res, col - 1, res[col - 1 - 1] + 1);
                }
            }
        }
    }


    public static boolean checkXYAix(int[] res) {
        boolean flagPositive = true;
        boolean flagNegative = true;
        boolean flagHorizon = true;
        HashSet<Integer> checkPositive = new HashSet<>();
        HashSet<Integer> checkNegative = new HashSet<>();
        HashSet<Integer> checkHorizon = new HashSet<>();
        for (int i = 1; i <= 4; i++) {
            if (res[i - 1] != 0) {
                int tmpYminusX = res[i - 1] - i;
                int tmpXplusY = i + res[i - 1];
                if (checkPositive.contains(tmpYminusX)) {
                    flagPositive = false;
                    break;
                } else {
                    checkPositive.add(tmpYminusX);
                }

                if (checkNegative.contains(tmpXplusY)) {
                    flagNegative = false;
                    break;
                } else {
                    checkNegative.add(tmpXplusY);
                }

                if (checkHorizon.contains(res[i - 1])) {
                    flagHorizon = false;
                    break;
                } else {
                    checkHorizon.add(res[i - 1]);
                }
            }
        }

        return flagPositive & flagNegative & flagHorizon;
    }
}
