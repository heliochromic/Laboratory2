import java.io.IOException;
import java.util.regex.Pattern;

public class Department {
    public String name;
    public static Person[] people = new Person[0];

    public Department(String name) {this.name = name;}

    public void addPerson() throws IOException {
        Person[] tempArr = new Person[people.length+1];
        System.arraycopy(people,0,tempArr,0,people.length);
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
                    people[people.length-1] = temp;
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

    public void removePerson() throws IOException {
        Person[] tempArr = new Person[people.length-1];
        System.arraycopy(people,0,tempArr,0,people.length);
        String fullName = DataInput.getString();
        int k = 0;
        for (Person person : people){
            if (person.fullName.equals(fullName)) continue;
            k++;
            tempArr[k].fullName = person.fullName;
        }
        people = tempArr;
    }

    public void editPerson() throws IOException {
        String fullName = DataInput.getString();
        for (Person person : people){
            if (person.fullName.equals(fullName)){
                switch (String.valueOf(person.getClass()).split(Pattern.quote(" "))[1]){
                    case "Professor" -> {
                        System.out.print("Which field in professor's information do you want to change(name, discipline): ");
                        //method for choosing value and edit it
                    }
                    case "Student" -> {
                        System.out.print("Which field in student's information do you want to change(name, course, group): ");
                        //method for choosing value and edit it
                    }
                    default -> System.out.println("Undefined fucking object");
                }
            }
        }
    }
}
