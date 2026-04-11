import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

class StringAnalysis_100
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String input=sc.nextLine();

        String[] splitInput=input.split("@");
        String fullCharacterSet=splitInput[0];
        String occupiedCharacterSet=splitInput[1];

        ArrayList<String[]> characterList=new ArrayList<>();

        String[] fullCharacterSetSplit= fullCharacterSet.split(",");

        for(String character:fullCharacterSetSplit)
        {
            String[] characterSplit=character.split(":");
            characterList.add(characterSplit);
        }

        if(occupiedCharacterSet.isEmpty())
        {
            System.out.println(fullCharacterSet+"@");
            System.exit(0);
        }

        HashMap<String,Integer> occupiedCharacters=new HashMap<>();

        String[] occupiedCharacterSetSplit=occupiedCharacterSet.split(",");

        for(String character:occupiedCharacterSetSplit)
        {
            String[] characterSplit=character.split(":");
            occupiedCharacters.put(characterSplit[0],Integer.parseInt(characterSplit[1]));
        }

        for(int i=0;i<characterList.size();i++)
        {
            String[] character=characterList.get(i);
            if(occupiedCharacters.containsKey(character[0]))
            {
                int count=Integer.parseInt(character[1])-occupiedCharacters.get(character[0]);
                if(count>0)
                    character[1]=Integer.toString(count);
                else
                {
                    characterList.remove(i);
                    i--;
                }
            }
        }

        StringBuilder result=new StringBuilder();
        for(String[] character:characterList)
            result.append(character[0]).append(":").append(character[1]).append(",");
        result.deleteCharAt(result.length()-1);
        System.out.println(result.toString());

    }
}