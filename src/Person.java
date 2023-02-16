abstract class Person {
    String fullName;

    public Person(String fullName){this.fullName = fullName;}

    public Person(){this("undefined_name");}

}

class Student extends Person{
    int course;
    int group;

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        while (true){
            if (course > 0 && course <= 6) {
                this.course = course;
                break;
            }
            System.out.println("Course can be only in range from 1 to 6");
        }

    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Student(String fullName, int course, int group){
        super(fullName);
        this.course = course;
        this.group = group;
    }
}

class Professor extends Person{
    String discipline;

    public Professor(String fullName, String discipline){
        super(fullName);
        this.discipline = discipline;
    }




    //Write a method that fill an array with disciplines
}