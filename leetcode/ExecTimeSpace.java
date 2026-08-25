public class ExecTimeSpace {

    public static void main(String[] args) {
        long start = System.nanoTime();
        //test code here
        for (int i = 1; i <= 1000000; i++) {
            System.out.print("");
        }
        long end = System.nanoTime();
        long durationNano = end - start;
        double durationMillis = durationNano / 1_000_000.0;
        System.out.println("time consumption is:" + durationMillis + "ms");

        Runtime rt = Runtime.getRuntime();
        rt.gc();
        long startMem = rt.freeMemory();
        //test code here
        int[] arr = new int[1000576];
        long endMem = rt.freeMemory();
        long occupiedMemByte = startMem - endMem;
        double occupiedMemMB = occupiedMemByte / 1024;
        System.out.println("memory occupied is:" + occupiedMemMB + "KB");
    }
}
