import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class Department {
    String name;
    public Person[] people = new Person[0];

    public Department(String name) {
        this.name = name;
    }

    public void addPerson(Person p) {
        Person[] tempArr = new Person[people.length + 1];
        System.arraycopy(people, 0, tempArr, 0, people.length);
        people = tempArr;
        people[people.length - 1] = p;
    }

    public void addPersonFromConsole() throws IOException {
        Person[] tempArr = new Person[people.length + 1];
        System.arraycopy(people, 0, tempArr, 0, people.length);
        people = tempArr;
        boolean doPositionEntered;
        do {
            //String position = DataInput.getString();
            doPositionEntered = false;
            switch (DataInput.getString()) {
                case "student" -> {
                    Student temp = null;
                    String fullName = DataInput.getString();
                    int course = DataInput.getInt();
                    int group = DataInput.getInt();
                    //people[people.length - 1] = new Student(fullName, 0, group);
                    temp = new Student(fullName, 0, group);
                    temp.setCourse(course);
                    people[people.length - 1] = temp;
                }
                case "professor" -> {
                    Professor temp = null;
                    String fullName = DataInput.getString();
                    String discipline = DataInput.getString();
                    people[people.length - 1] = new Professor(fullName, discipline);
                }
                default -> doPositionEntered = true;
            }
        } while (doPositionEntered);
    }

    public void removePerson(Person p) {
        Person[] tempArr = new Person[people.length - 1];
        System.arraycopy(people, 0, tempArr, 0, tempArr.length - 1);
        //people = tempArr;
        int k = 0;
        for (Person person : people) {
            if (person.fullName.equals(p.fullName)) continue;
            tempArr[k] = person;
            k++;
        }
        people = tempArr;
    }

    public void editPerson(Person p) throws Exception {
        for (Person person : people) {
            if (person.fullName.equals(p.fullName)) {
                switch (String.valueOf(person.getClass()).split(Pattern.quote(" "))[1]) {
                    case "Professor" -> {
                        System.out.print("Which field in professor's information do you want to change(name, discipline): ");
                        String field = DataInput.getString();
                        switch (field) {
                            case "name" -> {
                                System.out.print("Enter new name: ");
                                p.fullName = DataInput.getString();
                            }
                            case "course" -> {
                                System.out.print("Enter new course: ");
                                Professor temp = (Professor) p;
                                temp.setDiscipline(DataInput.getString());
                            }
                            default -> System.out.println("fuck you, can write method with first time");
                        }

                    }
                    case "Student" -> {
                        System.out.println(Arrays.toString(p.getClass().getDeclaredFields()));
                        System.out.print("Which field in student's information do you want to change(name, course, group): ");
                        //method for choosing value and edit it
                        String field = DataInput.getString();
                        switch (field) {
                            case "name" -> {
                                System.out.print("Enter new name: ");
                                p.fullName = DataInput.getString();
                            }
                            case "course" -> {
                                System.out.print("Enter new course: ");
                                Student temp = (Student) p;
                                temp.setCourse(DataInput.getInt());
                            }
                            case "group" -> {
                                System.out.print("Enter new group: ");
                                Student temp = (Student) p;
                                temp.setGroup(DataInput.getInt());
                            }
                            default -> System.out.println("fuck you, can write method with first time");
                        }
                    }
                    default -> throw new Exception("shit happens");
                }
            }
        }
    }

    public Professor[] sortProfessorsByName() {
        Professor[] temp = new Professor[0];
        for (Person p : this.people) {
            if (String.valueOf(p.getClass().getSimpleName()).equals("Student")) continue;
            Professor[] lol = new Professor[temp.length + 1];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            lol[lol.length - 1] = (Professor) p;
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(a -> a.fullName));
        return temp;
    }

    public Student[] sortStudentsByName() {
        Student[] temp = new Student[0];
        for (Person p : this.people) {
            if (String.valueOf(p.getClass().getSimpleName()).equals("Professor")) continue;
            Student[] lol = new Student[temp.length + 1];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            lol[lol.length - 1] = (Student) p;
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(a -> a.fullName));
        return temp;
    }

    public Student[] sortStudentsByGroup() {
        Student[] temp = new Student[0];
        for (Person p : this.people) {
            if (String.valueOf(p.getClass().getSimpleName()).equals("Professor")) continue;
            Student[] lol = new Student[temp.length + 1];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            lol[lol.length - 1] = (Student) p;
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(Student::getGroup));
        return temp;
    }

    public Student[] sortStudentsByCourse() {
        Student[] temp = new Student[0];
        for (Person p : this.people) {
            if (String.valueOf(p.getClass().getSimpleName()).equals("Professor")) continue;
            Student[] lol = new Student[temp.length + 1];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            lol[lol.length - 1] = (Student) p;
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(Student::getCourse));
        return temp;
    }

    public Professor[] sortProfessorByDiscipline() {
        Professor[] temp = new Professor[0];
        for (Person p : this.people) {
            if (String.valueOf(p.getClass().getSimpleName()).equals("Student")) continue;
            Professor[] lol = new Professor[temp.length + 1];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            lol[lol.length - 1] = (Professor) p;
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(Professor::getDiscipline));
        return temp;
    }

    public Student[] getStudentsByCourse(int course){
        Student[] temp = new Student[0];
        for (Student s : this.sortStudentsByCourse()){
            if (s.getCourse() != course) continue;
            Student[] lol = new Student[temp.length + 1];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            temp = lol;
            temp[temp.length - 1] = s;
        }

        return temp;
    }
}
