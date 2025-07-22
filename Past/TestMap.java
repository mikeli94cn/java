import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

class Employee
{
    String name;

    Employee(String name)
    {
        this.name=name;
    }
}

public class TestMap
{
    public static void main(String[] args) {
        Map<String,Employee> staff=new HashMap<>();
        staff.put("1001",new Employee("zhang san"));
        staff.put("1002",new Employee("li si"));
        staff.put("1003",new Employee("wang wu"));
        staff.put("1004",new Employee("zhao liu"));

        System.out.println(staff);

        staff.remove("1001");

        staff.put("1004",new Employee("zhao qi"));

        System.out.println(staff.get("1002"));

        for()

    }
}