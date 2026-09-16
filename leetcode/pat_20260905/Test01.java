import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lineRows = sc.nextLine();
        int line = Integer.parseInt(lineRows.split(" ")[0]);
        int row = Integer.parseInt(lineRows.split(" ")[1]);

        String[][] strMatrix = new String[line][row];
        for (int i = 1; i <= line; i++) {
            strMatrix[i - 1] = sc.nextLine().split(" ");
        }

        int dotOnLine = 0;
        int[][] matrix = new int[line][row];
        for (int i = 1; i <= line; i++) {
            for (int j = 1; j <= row; j++) {
                matrix[i - 1][j - 1] = Integer.parseInt(strMatrix[i - 1][j - 1]);
                dotOnLine = Math.max(dotOnLine, matrix[i - 1][j - 1]);
            }
        }


        int xMin = row;
        int xMax = 1;
        int yMin = line;
        int yMax = 1;
        for (int i = 1; i <= line; i++) {
            for (int j = 1; j <= row; j++) {
                if (matrix[i - 1][j - 1] != 0) {
                    xMin = Math.min(xMin, j);
                    xMax = Math.max(xMax, j);
                    yMin = Math.min(yMin, i);
                    yMax = Math.max(yMax, i);
                }
            }
        }

        int dots = 0;
        for (int i = yMin + 1; i <= yMax - 1; i++) {
            for (int j = xMin + 1; j <= xMax - 1; j++) {
                if (matrix[i - 1][j - 1] == 0) {
                    dots++;
                }
            }
        }
        double res = dots + (double) dotOnLine / 2 - 1;
        System.out.printf("%.1f=%d+%d/2-1", res, dots, dotOnLine);
    }
}
