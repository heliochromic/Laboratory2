import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
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

    public Student[] sortFacultyStudentsByName() {
        Student[] temp = new Student[0];
        for (Department d : this.departments){
            Student[] a = d.sortStudentsByName();
            int tempArrLength = temp.length + a.length;
            Student[] lol = new Student[tempArrLength];
            System.arraycopy(temp, 0, lol,0,temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(a -> a.fullName));
        return temp;
    }

    public Student[] sortFacultyStudentsByCourse() {
        Student[] temp = new Student[0];
        for (Department d : this.departments){
            Student[] a = d.sortStudentsByName();
            int tempArrLength = temp.length + a.length;
            Student[] lol = new Student[tempArrLength];
            System.arraycopy(temp, 0, lol,0,temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(Student::getCourse));
        return temp;
    }

    public Student[] sortFacultyStudentsByGroup() {
        Student[] temp = new Student[0];
        for (Department d : this.departments){
            Student[] a = d.sortStudentsByName();
            int tempArrLength = temp.length + a.length;
            Student[] lol = new Student[tempArrLength];
            System.arraycopy(temp, 0, lol,0,temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(Student::getGroup));
        return temp;
    }

    public Professor[] sortFacultyProfessorByName() {
        Professor[] temp = new Professor[0];
        for (Department d : this.departments){
            Professor[] a = d.sortProfessorsByName();
            int tempArrLength = temp.length + a.length;
            Professor[] lol = new Professor[tempArrLength];
            System.arraycopy(temp, 0, lol,0,temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(a -> a.fullName));
        return temp;
    }

    public Professor[] sortFacultyProfessorByDiscipline() {
        Professor[] temp = new Professor[0];
        for (Department d : this.departments){
            Professor[] a = d.sortProfessorsByName();
            int tempArrLength = temp.length + a.length;
            Professor[] lol = new Professor[tempArrLength];
            System.arraycopy(temp, 0, lol,0,temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(Professor::getDiscipline));
        return temp;
    }

    public Student[] getFacultyStudentsByCourse(int course){
        Student[] temp = new Student[0];
        for (Department d : this.departments){
            Student[] a = d.sortStudentsByName();
            int tempArrLength = temp.length + a.length;
            Student[] lol = new Student[tempArrLength];
            System.arraycopy(temp, 0, lol,0,temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        for (Student s : temp){
            if (s.getCourse() != course) continue;
            Student[] lol = new Student[temp.length + 1];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            temp = lol;
            temp[temp.length - 1] = s;
        }
        return temp;
    }



}
