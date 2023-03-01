abstract class Person {
    String fullName;

    public Person(String fullName) {
        this.fullName = fullName;
    }

    public Person() {
        this("undefined_name");
    }

    public abstract String toString();


}

class Student extends Person {
    private int course;
    private int group;

    public Student(String fullName, int course, int group) {
        super(fullName);
        this.course = course;
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        if (course > 0 && course <= 6) {
            this.course = course;
        } else {
            System.out.println("Course can be only in range from 1 to 6");
            this.course = 0;
        }


    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", group=" + group +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}

class Professor extends Person {
    private String discipline;

    public Professor(String fullName, String discipline) {
        super(fullName);
        this.discipline = discipline;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "discipline='" + discipline + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}