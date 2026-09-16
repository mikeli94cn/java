import java.util.ArrayList;
import java.util.List;

public class TreeGen {
    String val;
    List<TreeGen> children;

    TreeGen(String val){
        this.val=val;
        this.children=new ArrayList<>();
    }

    public static void main(String[] args) {
        TreeGen root=new TreeGen("A");
        TreeGen b=new TreeGen("B");
        TreeGen c=new TreeGen("C");
        TreeGen d=new TreeGen("D");

        root.children.add(b);
        root.children.add(c);
        root.children.add(d);
    }
}
