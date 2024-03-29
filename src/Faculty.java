import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class Faculty {
    public String name;
    public Department[] departments = new Department[0];

    public Faculty(String name) {
        this.name = name;
    }

    public void addDepartment(Department d) {
        Department[] tempArr = new Department[departments.length + 1];
        System.arraycopy(departments, 0, tempArr, 0, departments.length);
        departments = tempArr;
        departments[departments.length - 1] = d;
    }

    public void removeDepartment(Department d) {
        Department[] tempArr = new Department[departments.length - 1];
        if (this.departments.length > 1) {
            System.arraycopy(departments, 0, tempArr, 0, tempArr.length - 1);
        } else {
            System.arraycopy(departments, 0, tempArr, 0, tempArr.length);
        }
        int k = 0;
        for (Department department : departments) {
            if (department.name.equals(d.name)) continue;
            tempArr[k] = department;
            k++;
        }
        departments = tempArr;
    }

    public Department getDepartment(String name) {
        for (Department d : this.departments) {
            if (d.name.equals(name)) {
                return d;
            }
        }
        return null;
    }

    public boolean findDepartment(String name) {
        int count = 0;
        for (Department d : departments) {
            if (d.name.equals(name)) count++;
        }
        if (count != 0) return true;
        else return false;
    }

    public void editDepartment(Department d) throws IOException {
        for (Department department : departments) {
            if (department.name.equals(d.name)) {
                String newName=DataInput.getString("Please enter new department name: ").toUpperCase();
                while(newName.isEmpty())newName=DataInput.getString("Please enter new department name: ").toUpperCase();
                if (Arrays.asList(this.departments).contains(this.getDepartment(name))) {
                    System.out.println("Such department already exists");
                    break;
                }
                d.name = newName;
            }
        }
    }

    public Student[] sortFacultyStudentsByName() {
        Student[] temp = new Student[0];
        for (Department d : this.departments) {
            Student[] a = d.sortStudentsByName();
            int tempArrLength = temp.length + a.length;
            Student[] lol = new Student[tempArrLength];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(a -> a.fullName));
        return temp;
    }

    public Student[] sortFacultyStudentsByCourse() {
        Student[] temp = new Student[0];
        for (Department d : this.departments) {
            Student[] a = d.sortStudentsByName();
            int tempArrLength = temp.length + a.length;
            Student[] lol = new Student[tempArrLength];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(Student::getCourse));
        return temp;
    }

    public Student[] sortFacultyStudentsByGroup() {
        Student[] temp = new Student[0];
        for (Department d : this.departments) {
            Student[] a = d.sortStudentsByName();
            int tempArrLength = temp.length + a.length;
            Student[] lol = new Student[tempArrLength];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(Student::getGroup));
        return temp;
    }

    public Professor[] sortFacultyProfessorByName() {
        Professor[] temp = new Professor[0];
        for (Department d : this.departments) {
            Professor[] a = d.sortProfessorsByName();
            int tempArrLength = temp.length + a.length;
            Professor[] lol = new Professor[tempArrLength];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(a -> a.fullName));
        return temp;
    }

    public Professor[] sortFacultyProfessorByDiscipline() {
        Professor[] temp = new Professor[0];
        for (Department d : this.departments) {
            Professor[] a = d.sortProfessorsByName();
            int tempArrLength = temp.length + a.length;
            Professor[] lol = new Professor[tempArrLength];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(Professor::getDiscipline));
        return temp;
    }

    public Student[] getFacultyStudentsByCourse(int course) {
        Student[] temp = new Student[0];
        for (Department d : this.departments) {
            Student[] a = d.sortStudentsByName();
            int tempArrLength = temp.length + a.length;
            Student[] lol = new Student[tempArrLength];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        for (Student s : temp) {
            if (s.getCourse() != course) continue;
            Student[] lol = new Student[temp.length + 1];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            temp = lol;
            temp[temp.length - 1] = s;
        }
        return temp;
    }

    public String findStudentByName(String name) {
        for (Department department : this.departments) {
            for (Person p : department.people) {
                if (name.equals(p.fullName) &&
                        String.valueOf(p.getClass()).split(Pattern.quote(" "))[1].equals("Student")) {
                    return "department: " + department.name + ", student by name: " + p.fullName + ", course: " + ((Student) p).getCourse() + ", group: " + ((Student) p).getGroup();
                }
            }
        }
        return "Unfortunately, there is no student with such name";
    }

    public Student[] findStudentByGroup(int group) {
        Student[] temp = new Student[0];
        for (Department department : this.departments) {
            for (Person p : department.people) {
                if (String.valueOf(p.getClass()).split(Pattern.quote(" "))[1].equals("Professor")) continue;
                if (group == ((Student) p).getCourse()) {
                    Student[] sec = new Student[temp.length];
                    System.arraycopy(temp, 0, sec,0,temp.length);
                    temp = new Student[sec.length+1];
                    System.arraycopy(sec, 0, temp,0,temp.length-1);
                    temp[temp.length - 1] = (Student) p;
                }
            }
        }
        return temp;
        // тут повернеться array, якщо пустий, то такого студента нема, якщо один, то просто його повернути
        // як об'єкт аля s = Student[i], якщо пустий, то сказати, що воно пусте
    }

    public Student[] findStudentByCourse(int course) {
        Student[] temp = new Student[0];
        for (Department department : this.departments) {
            for (Person p : department.people) {
                if (String.valueOf(p.getClass()).split(Pattern.quote(" "))[1].equals("Professor")) continue;
                if (course == ((Student) p).getCourse()) {
                    Student[] sec = new Student[temp.length];
                    System.arraycopy(temp, 0, sec,0,temp.length);
                    temp = new Student[sec.length+1];
                    System.arraycopy(sec, 0, temp,0,temp.length-1);
                    temp[temp.length - 1] = (Student) p;
                }
            }
        }
        return temp;
    }

    public String findProfessorByName(String name) {
        for (Department department : this.departments) {
            for (Person p : department.people) {
                if (name.equals(p.fullName) &&
                        String.valueOf(p.getClass()).split(Pattern.quote(" "))[1].equals("Professor")) {
                    return "department: " + this.name + ", professor by name: " + p.fullName + ", his/her discipline: " + ((Professor) p).getDiscipline();
                }
            }
        }
        return "Unfortunately, there is no student with such name";
    }

    public String findProfessorByDiscipline(String discipline) {
        for (Department department : this.departments) {
            for (Person p : department.people) {

                if (String.valueOf(p.getClass()).split(Pattern.quote(" "))[1].equals("Student")) continue;
                if (discipline.equals(((Professor) p).getDiscipline())) {
                    return "department: " + department.name + ", professor by name: " + p.fullName + ", his/her discipline: " + ((Professor) p).getDiscipline();
                }
            }
        }
        return "Unfortunately, there is no professor with such name";
    }

    public String personToString(Person[] people) {
        StringBuilder temp = new StringBuilder("Sorted array:\n");
        if (people.length == 0)
            return "unfortunately, there is no " + people.getClass().getSimpleName().toLowerCase() + " in this faculty";
        for (Person person : people) {
            temp.append(person).append("\n");
        }
        return String.valueOf(temp);
    }


    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder("Faculty: " + name + "\n" + "Departments:\n");
        for (Department department : departments) {
            temp.append(department.name).append("\n");
        }
        return String.valueOf(temp);
    }
}
