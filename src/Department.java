import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Department {
    public String name;
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

    public void removePerson(Person p) { //arraycopy: last destination index 4 out of bounds for object array[3]
        Person[] tempArr = new Person[people.length - 1];
        System.arraycopy(people, 0, tempArr, 0, people.length);
        int k = 0;
        for (Person person : people) {
            if (person.fullName.equals(p.fullName)) continue;
            k++;
            tempArr[k].fullName = person.fullName;
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
}
