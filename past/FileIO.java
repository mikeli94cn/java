import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;

public class FileIO
{

public static void main(String[] args)
{

try
{
    Scanner in=new Scanner(Paths.get("d:\\code\\for_io_test.txt"),"UTF-8");
    String rs=in.nextLine();
    System.out.println(rs);
    // d:\code\for_io_test.txt
    // d:\\code\\for_io_test.txt
/*
    String filename="for_io_test.txt";

    File f=new file(filename);

    Scanner in =new Scanner(f);

    String rs=in.nextString();
*/




}
catch(IOException e)
{
    System.out.println("catch exception");
    e.printStackTrace();
}



}

}