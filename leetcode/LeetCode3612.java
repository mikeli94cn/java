public class LeetCode3612 {
    public static void main(String[] args) {
        String s ="a#b%*";
        //String s="z*#";
        //String s="z**";
        System.out.println(processStr(s));
    }

    public static String processStr(String s){
        char[] charArr=s.toCharArray();

        StringBuilder sbd=new StringBuilder();

        for(Character c : charArr){
            switch (c) {
                case Character chs when chs=='#' ->sbd.append(sbd.toString());
                case Character chs when chs=='%' ->sbd.reverse();
                case Character chs when chs=='*' ->safeDeleteLast(sbd);
                default -> sbd.append(c);



            }
        }
        return sbd.toString();

    }
    
    public static void safeDeleteLast(StringBuilder sbd){
        if(sbd.length()>=1){
            sbd.deleteCharAt(sbd.length()-1);
        }
    }
}
