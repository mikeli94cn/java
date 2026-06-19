import java.util.Arrays;

public class ArrayOneToTwo {

    public static void main(String[] args) {
        char[] chs=new char[62];
        int idx=0;
        for(char c='0';c<='9';c++){
            chs[idx]=c;
            idx++;
        }
        for(char c='a';c<='z';c++){
            chs[idx]=c;
            idx++;
        }
        for(char c='A';c<='Z';c++){
            chs[idx]=c;
            idx++;
        }

        int chunkSize=8;
        int chunkNums=(chs.length-1)/chunkSize+1;
        char[][] chunk=new char[chunkNums][chunkSize];
        int nums=0;
        int size=0;
        for(char c:chs){
            chunk[nums][size]=c;
            size++;
            if(size==chunkSize){
                size=0;
                nums++;
            }
        }
        System.out.println(Arrays.toString(chs));
        for(int i=1;i<=chunk.length;i++){
            System.out.println(Arrays.toString(chunk[i-1]));
        }
        for(int i=0;i<=9;i++){
            System.out.println(getChar(chunk, chunkSize, i));
        }

    }

    public static char getChar(char[][] chunk,int chunkSize, int index){
        int nums=index/chunkSize;
        int size=index%chunkSize;
        return chunk[nums][size];
    }
}
