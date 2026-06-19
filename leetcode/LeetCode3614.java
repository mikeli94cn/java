public class LeetCode3614 {
    public static void main(String[] args) {
        //String s="a#b%*";
        //String s="cd%#*#";
        //String s="0123456789abcdefghijklmnopqrstuvwxyz#*";
        String s="nr#x#gva#jq%yqi%##f###i#u#%##wynnck#reh%u#gv###g#xufhis%l#ng##o%%##v#qt%i";
        //long idx=1;
        //long idx=3;
        //long idx=40;
        long idx=415249132440988;
        

        System.out.println(processStr(s,idx));
    }

    public static char processStr(String s, long idx){
        char[] chArr=s.toCharArray();
        StringBuilder sbd=new StringBuilder();
        for(Character c:chArr){
            switch (c) {
                case Character ch when ch=='#'->sbd.append(sbd.toString());
                case Character ch when ch=='%'->sbd.reverse();
                case Character ch when ch=='*'->safeRemoveLast(sbd);
                default ->sbd.append(c);
            }
        }

        char[] chArrNew=sbd.toString().toCharArray();
        if(idx>=chArrNew.length){
            return '.';
        }else{
            if(idx<=Integer.MAX_VALUE){
                return chArrNew[(int)idx];
            }else{
                //1.convert arr to twoDemArr
                //2.translate idx to twoDemIdx
                //3.fetch value

                //1.convert arr to twoDemArr
                int chunkSize=10000;
                int chunkPages=(chArrNew.length-1)/chunkSize+1;

                char[][] chunk=new char[chunkPages][chunkSize];

                int pages=0;
                int size=0;
                for(char c:chArrNew){
                    chunk[pages][size]=c;
                    size++;
                    if(size==chunkSize){
                        size=0;
                        pages++;
                    }
                }

                //2.convert idx to twoDemIdx
                int idxPages=(int)(idx/chunkSize);
                int idxSize=(int)(idx%chunkSize);

                //3.fecth value
                return chunk[idxPages][idxSize];
            }
        }
    }

    public static void safeRemoveLast(StringBuilder sbd){
        if(sbd.length()>=1){
            sbd.deleteCharAt(sbd.length()-1);
        }
    }
}
