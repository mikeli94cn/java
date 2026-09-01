import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ZOJB002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        System.out.println(new ZOJB002().aPlusBPoly(line1, line2));
    }

    private String aPlusBPoly(String line1, String line2) {
        String[] strArr1 = line1.split(" ");
        String[] strArr2 = line2.split(" ");
        Map<Integer, Double> treeMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 2; i <= strArr1.length; i += 2) {
            int k = Integer.parseInt(strArr1[i - 1]);
            double v = BigDecimal
                    .valueOf(Double.parseDouble(strArr1[i]))
                    .setScale(1, RoundingMode.HALF_UP)
                    .doubleValue();
            treeMap.put(k, v);
        }
        for (int i = 2; i <= strArr2.length; i += 2) {
            int k = Integer.parseInt(strArr2[i - 1]);
            double v = BigDecimal
                    .valueOf(Double.parseDouble(strArr2[i]))
                    .setScale(1, RoundingMode.HALF_UP)
                    .doubleValue();

            if (treeMap.containsKey(k)) {
                double sum = treeMap.get(k) + v;
                if (sum == 0.0) {
                    treeMap.remove(k);
                } else {
                    treeMap.put(k, sum);
                }
            } else {
                treeMap.put(k, v);
            }
        }

        StringBuilder sbd = new StringBuilder();
        sbd.append(treeMap.size() + " ");
        for (Map.Entry<Integer, Double> entry : treeMap.entrySet()) {
            sbd.append(entry.getKey() + " " + entry.getValue() + " ");
        }
        sbd.deleteCharAt(sbd.length() - 1);
        return sbd.toString();
    }
}
