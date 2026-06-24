import java.util.Scanner;

class PatternMatchFromC{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str;
        while(sc.hasNextLine()){
            str=sc.nextLine();
            if(patternMatchMyself(str,"ould")){
                System.out.println(str);
            }
        }
    }

    /*
    public static boolean patternMatch(String str,String pattern){
        boolean flag=str.contains(pattern);
        return flag;
    }
    */

    public static boolean patternMatchMyself(String str, String pattern){
        boolean matchFlag=true;
        char[] chsStr=str.toCharArray();
        char[] chsPattern=pattern.toCharArray();
        for(int i=1;i<=chsStr.length;i++){
            if(chsStr[i-1]==chsPattern[0]){
                matchFlag=true;
                for(char c:chsPattern){
                    if(i<=chsStr.length){
                        if(chsStr[i-1]==c){
                            i++;
                        }else{
                            matchFlag=false;
                            break;
                        }
                    }else{
                        matchFlag=false;
                        break;
                    }
                }
                if(matchFlag){
                    break;
                }
            }
        }

        return matchFlag;
    }
}
