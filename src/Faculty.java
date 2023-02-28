import java.io.IOException;
import java.util.HashMap;

public class Faculty {
    public String name;
    public Department[] departments = new Department[0];

    public Faculty(String name){
        this.name = name;
    }

    public void addDepartment(Department d){
        Department[] tempArr = new Department[departments.length];
        System.arraycopy(departments, 0, tempArr, 0, departments.length);
        departments = tempArr;
        departments[departments.length-1] = d;
    }

    public void removeDepartment(Department d){
        Department[] tempArr = new Department[departments.length-1];
        System.arraycopy(departments, 0, tempArr, 0, tempArr.length-1);
        int k = 0;
        for (Department department : departments){
            if (department.name.equals(d.name)) continue;
            tempArr[k] = department;
            k++;
        }
        departments = tempArr;
    }

    public void editDepartment(Department d) throws IOException {
        for (Department department:departments){
            if (department.name.equals(d.name)){
                System.out.print("Enter new department name: ");
                d.name = DataInput.getString();
            }
        }
    }

}
