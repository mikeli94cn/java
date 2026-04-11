public class Ex03_19_java{

    public static void main(String[] args){
        int i,ab,cd;

	for(i=1000;i<=9999;i++){
	    ab=i / 100;
	    cd =i % 100;
	    if((ab+cd)*(ab+cd)==i)
		    System.out.println(i);
	    
	}
    }
}
