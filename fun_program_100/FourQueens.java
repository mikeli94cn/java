import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FourQueens {
    public static void main(String[] args) {
        int[] res = new int[4];
        // fourQueenOrigin(res);
        // fourQueen(res, 1);
        fourQueenDetail(res, 1, 1);
    }

  /*
  public static void fourQueen(int[] res, int line) {
    fourQueenDetail(res, 1, 1);

    for (int i = 1; i <= 4; i++) {
      res[n - 1] = i;
      if (n != 4) {
        if (checkXYAix(res)) {
          fourQueen(res, n + 1);
        }
      } else {
        if (checkXYAix(res)) {
          for (int cnt = 1; cnt <= 4; cnt++) {
            System.out.printf("(%d,%d)", cnt, res[cnt - 1]);
          }
          System.out.println();
        }
      }
      res[n - 1] = 0;
    }
  }
  */

    public static void fourQueenDetail(int[] res, int col, int line) {
        if (col >= 1 && col <= 4) {
            if (line > 4) {
                res[col-1]=0;
                fourQueenDetail(res, col - 1, res[col - 1 -1] + 1);

            } else {
                res[col - 1] = line;

                if (checkXYAix(res)) {
                    if (col < 4) {
                        fourQueenDetail(res, col + 1, 1);
                    } else {
                        System.out.println(Arrays.toString(res));
                        fourQueenDetail(res, col, line + 1);
                    }
                } else {
                    fourQueenDetail(res, col, line + 1);
                }

                res[col - 1] = 0;
            }
        }
    }

  /*
  public static void fourQueenOrigin(int[] res) {
    // four hierachy loops
    for (int i = 1; i <= 4; i++) {
      res[1 - 1] = i;
      if (checkXYAix(res)) {
        for (int j = 1; j <= 4; j++) {
          res[2 - 1] = j;
          if (checkXYAix(res)) {
            for (int m = 1; m <= 4; m++) {
              res[3 - 1] = m;
              if (checkXYAix(res)) {
                for (int n = 1; n <= 4; n++) {
                  res[4 - 1] = n;
                  if (checkXYAix(res)) {
                    for (int cnt = 1; cnt <= 4; cnt++) {
                      System.out.printf("(%d,%d)", cnt, res[cnt - 1]);
                    }
                    System.out.println();
                  }
                  res[4 - 1] = 0;
                }
              }
              res[3 - 1] = 0;
            }
          }
          res[2 - 1] = 0;
        }
      }
      res[1 - 1] = 0;
    }
  }
  */

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
