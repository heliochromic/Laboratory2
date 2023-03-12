import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class University {
    public String name;
    public Faculty[] faculties = new Faculty[0];

    public University(String name){
        this.name = name;
    }

    public void addFaculty(Faculty f) {
        Faculty[] tempArr = new Faculty[faculties.length + 1];
        System.arraycopy(faculties, 0, tempArr, 0, faculties.length);
        faculties = tempArr;
        faculties[faculties.length - 1] = f;
    }
    public boolean findFaculty(String name){
        int count=0;
        for (Faculty faculty: faculties) {
            if (faculty.name.equals(name)) count++;
        }
        if(count!=0)return true;
        else return false;
    }
    public Faculty getFaculty(String name) {
        for (Faculty f : this.faculties){
            if (f.name.equals(name.toUpperCase())){
                return f;
            }
        }
        return null;
    }

    public void removeFaculty(Faculty f) {
        Faculty[] tempArr = new Faculty[faculties.length - 1];
        if (this.faculties.length > 1){
            System.arraycopy(faculties, 0, tempArr, 0, tempArr.length - 1);
        } else {
            System.arraycopy(faculties, 0, tempArr, 0, tempArr.length);
        }
        int k = 0;
        for (Faculty faculty: faculties) {
            if (faculty.name.equals(f.name)) continue;
            tempArr[k] = faculty;
            k++;
        }
        faculties = tempArr;
    }
    public void editFaculty(Faculty f) throws IOException {
        for (Faculty faculty : faculties) {
            if (faculty.name.equals(f.name.toUpperCase())) {
                String newName=DataInput.getString("Please enter new faculty name: ").toUpperCase();
                while(newName.isEmpty())newName=DataInput.getString("Please enter new faculty name: ").toUpperCase();
                f.name =newName;

            }
        }
    }

    public Student[] sortUniStudentsByName(){
        Student[] temp = new Student[0];
        for (Faculty f : this.faculties){
            Student[] a = f.sortFacultyStudentsByName();
            int tempArrLength = temp.length + a.length;
            Student[] lol = new Student[tempArrLength];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;

        }
        Arrays.sort(temp, Comparator.comparing(a -> a.fullName));
        return temp;
    }
    public Student[] sortUniStudentsByCourse() {
        Student[] temp = new Student[0];
        for (Faculty faculty : faculties) {
            Student[] a = faculty.sortFacultyStudentsByCourse();
            int tempArrLength = temp.length + a.length;
            Student[] lol = new Student[tempArrLength];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(Student::getCourse));
        return temp;
    }

    public Student[] sortUniStudentsByGroup() {
        Student[] temp = new Student[0];
        for (Faculty faculty:faculties) {
            Student[] a = faculty.sortFacultyStudentsByGroup();
            int tempArrLength = temp.length + a.length;
            Student[] lol = new Student[tempArrLength];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(Student::getGroup));
        return temp;
    }

    public Professor[] sortUniProfessorByName() {
        Professor[] temp = new Professor[0];
        for (Faculty faculty : faculties) {
            Professor[] a = faculty.sortFacultyProfessorByName();
            int tempArrLength = temp.length + a.length;
            Professor[] lol = new Professor[tempArrLength];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(a -> a.fullName));
        return temp;
    }

    public Professor[] sortUniProfessorByDiscipline() {
        Professor[] temp = new Professor[0];
        for (Faculty faculty : faculties) {
            Professor[] a = faculty.sortFacultyProfessorByDiscipline();
            int tempArrLength = temp.length + a.length;
            Professor[] lol = new Professor[tempArrLength];
            System.arraycopy(temp, 0, lol, 0, temp.length);
            System.arraycopy(a, 0, lol, temp.length, a.length);
            temp = lol;
        }
        Arrays.sort(temp, Comparator.comparing(Professor::getDiscipline));
        return temp;
    }

    public Student[] getUniStudentsByCourse(int course) {
        Student[] temp = new Student[0];
        for (Faculty faculty : faculties) {
            Student[] a = faculty.getFacultyStudentsByCourse(course);
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
        for (Faculty faculty : this.faculties){
            for (Department department : faculty.departments) {
                for (Person p : department.people) {
                    if (name.equals(p.fullName) &&
                            String.valueOf(p.getClass()).split(Pattern.quote(" "))[1].equals("Student")) {
                        return "faculty: "+faculty.name+", department: " + department.name + ", student by name: " + p.fullName + ", course: " + ((Student) p).getCourse() + ", group: " + ((Student) p).getGroup();
                    }
                }
            }
        }
        return "Unfortunately, there is no student with such name";
    }
    public String findProfessorByName(String name) {
        for (Faculty faculty : this.faculties){
            for (Department department : faculty.departments) {
                for (Person p : department.people) {
                    if (name.equals(p.fullName) &&
                            String.valueOf(p.getClass()).split(Pattern.quote(" "))[1].equals("Professor")) {
                        return "university: "+faculty.name+", department: " + department.name + ", professor by name: " + p.fullName + ", his/her discipline: " + ((Professor) p).getDiscipline();
                    }
                }
            }
        }
        return "Unfortunately, there is no student with such name";
    }
    public Student[] findStudentByGroup(int group) {
        Student[] temp = new Student[0];
        for (Faculty faculty : this.faculties){
            for (Department department : faculty.departments) {
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
        }
        return temp;
        // тут повернеться array, якщо пустий, то такого студента нема, якщо один, то просто його повернути
        // як об'єкт аля s = Student[i], якщо пустий, то сказати, що воно пусте
    }
    public Student[] findStudentByCourse(int course) {
        Student[] temp = new Student[0];
        for (Faculty faculty : this.faculties){
            for (Department department : faculty.departments) {
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
        }
        return temp;
    }
    public String findProfessorByDiscipline(String discipline) {
        for (Faculty faculty : this.faculties){
            for (Department department : faculty.departments) {
                for (Person p : department.people) {
                    if (String.valueOf(p.getClass()).split(Pattern.quote(" "))[1].equals("Student"))continue;
                    if (discipline.equals(((Professor) p).getDiscipline())){
                        return "university: "+faculty.name+", department: " + department.name + ", professor by name: " + p.fullName + ", his/her discipline: " + ((Professor) p).getDiscipline();
                    }
                }
            }
        }
        return "Unfortunately, there is no professor with such name";
    }

    public String personToString(Person[] people){
        StringBuilder temp = new StringBuilder("Sorted array:\n");
        if (people.length == 0) return "unfortunately, there is no "+people.getClass().getSimpleName().toLowerCase()+" in this university";
        for(Person person:people){
            temp.append(person).append("\n");
        }
        return String.valueOf(temp);
    }
    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder("University: " + name + "\n" + "Faculties:\n");
        for (Faculty faculty : faculties){
            temp.append(faculty.name).append("\n");
        }
        return String.valueOf(temp);
    }
}
