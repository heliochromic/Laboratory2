import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Greeting! This program allows you to work with NaUKMA University");
        University university = new University("NaUKMA");

        Faculty fi = new Faculty("FI");
        Faculty fsnst = new Faculty("FSNST");
        Faculty fen = new Faculty("FEN");

        university.addFaculty(fi);
        university.addFaculty(fsnst);
        university.addFaculty(fen);

//        System.out.println(university);

        Department mathematics = new Department("Department of Mathematics");
        Department informatics = new Department("Department of Informatics");
        Department ir = new Department("Department of International relations");

        fi.addDepartment(mathematics);
        fi.addDepartment(informatics);
        fsnst.addDepartment(ir);

//        System.out.println(fi);
//
        Student emmaGarcia = new Student("Emma Garcia", 3, 3);
        Student johnHarris = new Student("John Harris", 4, 2);
        Student davidDavis = new Student("David Davis", 2, 1);
        Student davidAnderson = new Student("David Anderson", 2, 1);
        Student ivanIngram = new Student("Ivan Ingram", 2, 3);
        Student johnGarcia = new Student("John Garcia", 4, 5);
        Student aliceHarris = new Student("Alice Harris", 2, 6);
        Student davidJohnson = new Student("David Johnson", 3, 6);
        Student ivanFord = new Student("Ivan Ford", 1, 4);
        Student frankHarris = new Student("Frank Harris", 4, 5);
        Student helenHarris = new Student("Helen Harris", 1, 4);
        Student ivanClark = new Student("Ivan Clark", 2, 1);
        Student emmaBrown = new Student("Emma Brown", 2, 1);
        Student davidFord = new Student("David Ford", 4, 1);
        Student markBell = new Student("Mark Bell", 2, 5);

        Professor frankGarcia = new Professor("Frank Garcia", "Algebra");
        Professor johnIngram = new Professor("John Ingram", "Programming in java");
        Professor helenIngram = new Professor("Helen Ingram", "Model comp");
        Professor frankieHarris = new Professor("Frankie Harris", "Computer algorithms");
        Professor thomYorke = new Professor("Thom Yorke", "Relations with russia terrorist state");
        Professor conanGrey = new Professor("Conan Grey", "Understanding jokes of others cultures");


        informatics.addPerson(emmaGarcia);
        informatics.addPerson(johnHarris);
        informatics.addPerson(davidDavis);
        informatics.addPerson(davidAnderson);
        informatics.addPerson(ivanIngram);

        informatics.addPerson(frankGarcia);
        informatics.addPerson(frankieHarris);

        //System.out.println(informatics);

        mathematics.addPerson(johnGarcia);
        mathematics.addPerson(aliceHarris);
        mathematics.addPerson(davidJohnson);
        mathematics.addPerson(ivanFord);
        mathematics.addPerson(frankHarris);

        mathematics.addPerson(johnIngram);
        mathematics.addPerson(helenIngram);

        //System.out.println(mathematics);

        ir.addPerson(helenHarris);
        ir.addPerson(ivanClark);
        ir.addPerson(emmaBrown);
        ir.addPerson(davidFord);
        ir.addPerson(markBell);

        ir.addPerson(thomYorke);
        ir.addPerson(conanGrey);
        int circle = 1;
        boolean check = true;
        while (check) {
            try {
                while (circle == 1) {
                    int choice = DataInput.getInt("Select the actions you want to perform :\n 1-Create/delete/edit faculty.\n" +
                            "2-Create/delete/edit department of the faculty.\n" +
                            "3-Add/delete/edit a student/teacher to the department.\n" +
                            "4-Find a student/teacher by name, course or group.\n" +
                            "5-Display all students sorted by course.\n" +
                            "6-Display all students/teachers of the faculty sorted alphabetically.\n" +
                            "7-Bring out all students of the department arranged by courses.\n" +
                            "8-List all students/teachers of the department sorted alphabetically.\n" +
                            "9-Remove all students of the department of the specified course.\n" +
                            "10-List all students of the department of the specified course in alphabetical order.");
                    switch (choice) {
                        default:
                            System.out.println("Sorry, please enter the correct value!!");
                            break;
                        case 1:
                            changeFaculty(university);
                            break;
                        case 5:
                            sortByCourse(university);
                            break;
                        case 6: printallAlf(university); break;
                        case 7: studDepByCourse(university); break;
                        case 8: printAllDepAlf(university); break;
                        case 9: printAllStByCourse(university);break;
                        case 10:printAllStByCourseAlf(university);break;

                    }
                }
                check = false;
            } catch (NumberFormatException no) {
                System.out.println("Sorry, please enter the correct value!!");
            }
        }
//
//        //System.out.println(ir);
//
//        Student[] sortedDepartment = informatics.sortStudentsByCourse();
//        System.out.println(informatics.personToString(sortedDepartment));
//
//        Student[] sortedByNameListOfStudents = fi.sortFacultyStudentsByName();
//        System.out.println(fi.personToString(sortedByNameListOfStudents));
    }

    private static void printAllStByCourseAlf(University university) throws IOException {
        String dep;
        String fac;
        int course=0;
        do {
            fac=DataInput.getString("Please enter name of the faculty  in which you want to see the list of students by course(" + university + ") :").toUpperCase();;
        }while(fac.isEmpty());
        boolean contain = university.findFaculty(fac);
        if(contain){
            boolean circle=true;
            do {
                do {
                    dep = DataInput.getString("Please enter name of the department in which you want to see the list of students by course " + university.getFaculty(fac));
                } while (dep.isEmpty());
                boolean present = university.getFaculty(fac).findDepartment(dep);
                if (present) {
                    boolean cicle;
                    do {
                        boolean rep=true;
                        while(rep){
                            try {
                                course = DataInput.getInt("Enter course what you want to find : ");
                                while (course < 1 || course > 6) course = DataInput.getInt("Enter course");
                                rep=false;
                            }catch (NumberFormatException no) {System.out.println("Please, enter correct value!!");}}
                            Student[] sortStudDepByCourse = university.getFaculty(fac).getDepartment(dep).getStudentsByCourse(course);
                            Arrays.sort(sortStudDepByCourse, Comparator.comparing(a -> a.fullName));
                        //*********як сортувати за алфавітом чи є метод
                        System.out.println(university.personToString(sortStudDepByCourse));
                        String ask=DataInput.getString("Do you want retry? ");
                        while(ask.isEmpty())ask=DataInput.getString("Do you want retry? ");
                        if(ask.equals("yes"))cicle=false;
                        else cicle=true;
                    }while(!cicle);
                    String retry=DataInput.getString("Do you want to change the department of faculty? ");
                    while(retry.isEmpty())retry=DataInput.getString("Do you want to change the department of faculty? ");
                    if(retry.equals("yes"))circle=true;
                    else  circle=false;
                } else System.out.println("You entered a non-existent department");
            }while(circle);
        }else System.out.println("You entered a non-existent faculty");

    }

    private static void printAllStByCourse(University university) throws IOException {
        String dep;
        String fac;
        int course=0;
        do {
            fac=DataInput.getString("Please enter name of the faculty  in which you want to see the list of students by course(" + university + ") :").toUpperCase();;
        }while(fac.isEmpty());
        boolean contain = university.findFaculty(fac);
        if(contain){
            boolean circle=true;
            do {
                do {
                    dep = DataInput.getString("Please enter name of the department in which you want to see the list of students by course " + university.getFaculty(fac));
                } while (dep.isEmpty());
                boolean present = university.getFaculty(fac).findDepartment(dep);
                if (present) {
                    boolean cicle;
                    do {
                    boolean rep=true;
                    while(rep){
                    try {
                         course = DataInput.getInt("Enter course what you want to find : ");
                        while (course < 1 || course > 6) course = DataInput.getInt("Enter course");
                        rep=false;
                    }catch (NumberFormatException no) {System.out.println("Please, enter correct value!!");}}
                    Student[] sotrtStudDepByCourse = university.getFaculty(fac).getDepartment(dep).getStudentsByCourse(course);
                    System.out.println(university.getFaculty(fac).getDepartment(dep).personToString(sotrtStudDepByCourse));
                        String ask=DataInput.getString("Do you want retry? ");
                        while(ask.isEmpty())ask=DataInput.getString("Do you want retry? ");
                        if(ask.equals("yes"))cicle=false;
                        else cicle=true;
                    }while(!cicle);
                    String retry=DataInput.getString("Do you want to change the department of faculty? ");
                    while(retry.isEmpty())retry=DataInput.getString("Do you want to change the department of faculty? ");
                    if(retry.equals("yes"))circle=true;
                    else  circle=false;
                } else System.out.println("You entered a non-existent department");
            }while(circle);
        }else System.out.println("You entered a non-existent faculty");

    }

    private static void printAllDepAlf(University university) throws IOException {
        String dep;
        String fac;
        do {
            fac=DataInput.getString("Please enter name of the faculty  in which you want to see the list of students by course(" + university + ") :").toUpperCase();;
        }while(fac.isEmpty());
        boolean contain = university.findFaculty(fac);
        if(contain){
            boolean circle=true;
            do {
                do {
                    dep = DataInput.getString("Please enter name of the department in which you want to see the list of students by course " + university.getFaculty(fac));
                } while (dep.isEmpty());
                boolean present = university.getFaculty(fac).findDepartment(dep);
                if (present) {
                    boolean cicle;
                    do {
                        boolean doPositionEntered;
                        do {
                            doPositionEntered = false;
                            switch (DataInput.getString("Do you want to enter \"student\" or \"professor\"").toLowerCase()) {
                                case "student" -> {
                                    Student[] sortedByNameListOfStudentsDep = university.getFaculty(fac).getDepartment(dep).sortStudentsByName();
                                    System.out.println(university.getFaculty(fac).getDepartment(dep).personToString(sortedByNameListOfStudentsDep));

                                }
                                case "professor" -> {
                                    Professor[] sortedByNameListOfProfessorDep = university.getFaculty(fac).getDepartment(dep).sortProfessorsByName();
                                    System.out.println(university.getFaculty(fac).getDepartment(dep).personToString(sortedByNameListOfProfessorDep));
                                }
                                default -> doPositionEntered = true;
                            }
                        } while (doPositionEntered);
                        String ask=DataInput.getString("Do you want retry? ");
                        while(ask.isEmpty())ask=DataInput.getString("Do you want retry? ");
                        if(ask.equals("yes"))cicle=false;
                        else cicle=true;
                    }while(!cicle);
                    String retry=DataInput.getString("Do you want to change the department of faculty? ");
                    while(retry.isEmpty())retry=DataInput.getString("Do you want to change the department of faculty? ");
                    if(retry.equals("yes"))circle=true;
                    else  circle=false;
                } else System.out.println("You entered a non-existent department");
            }while(circle);
        }else System.out.println("You entered a non-existent faculty");

    }


    private static void studDepByCourse(University university) throws IOException {
        String dep;
        String fac;
        do {
            fac=DataInput.getString("Please enter name of the faculty  in which you want to see the list of students by course(" + university + ") :").toUpperCase();;
        }while(fac.isEmpty());
        boolean contain = university.findFaculty(fac);
        if(contain){
            boolean circle=true;
            do {
                do {
                    dep = DataInput.getString("Please enter name of the department in which you want to see the list of students by course " + university.getFaculty(fac));
                } while (dep.isEmpty());
                boolean present = university.getFaculty(fac).findDepartment(dep);
                if (present) {
                    Student[] sotrtStudDepByCourse = university.getFaculty(fac).getDepartment(dep).sortStudentsByCourse();
                    System.out.println(university.getFaculty(fac).getDepartment(dep).personToString(sotrtStudDepByCourse));
                    circle=false;
                } else System.out.println("You entered a non-existent department");
            }while(circle);
        }else System.out.println("You entered a non-existent faculty");

    }

    private static void printallAlf(University university) throws IOException {
        String dep;
        do {
            dep=DataInput.getString("Please enter name of the faculty  in which you want to see the list of persons(" + university + ") :").toUpperCase();;
        }while(dep.isEmpty());
        boolean contain = university.findFaculty(dep);
        if(contain){
            boolean doPositionEntered;
            do {
                doPositionEntered = false;
                switch (DataInput.getString("Do you want to enter \"student\" or \"professor\"").toLowerCase()) {
                    case "student" -> {
                        Student[] sortedByNameListOfStudents = university.getFaculty(dep).sortFacultyStudentsByName();
                        System.out.println(university.getFaculty(dep).personToString(sortedByNameListOfStudents));

                    }
                    case "professor" -> {
                        Professor [] sortedByNameListOfProfessor=university.getFaculty(dep).sortFacultyProfessorByName();
                        System.out.println(university.getFaculty(dep).personToString(sortedByNameListOfProfessor));
                    }
                    default -> doPositionEntered = true;
                }
            } while (doPositionEntered);

        }else System.out.println("You entered a non-existent faculty");
    }

    private static void sortByCourse(University university) {
        System.out.println("All student sort by course: ");
        Student[] yug = university.sortUniStudentsByCourse();
        System.out.println(university.personToString(yug));
    }

    public static void changeFaculty(University university) throws IOException {

        System.out.println("We already have such faculties in university  :\n " + university);
        int circle = 1;
        boolean repeat = true;
        while (repeat) {

            try {
                while (circle == 1) {
                    System.out.println("Сhoose which actions you want to implement on the faculty: ");
                    int act = DataInput.getInt("1-create new faculty \n" +
                            "2-delete faculty\n" +
                            "3-edit faculty");
                    while (act < 1 || act > 3) {
                        act = DataInput.getInt("1-create new faculty \n" +
                                "2-delete faculty\n" +
                                "3-edit faculty");
                    }
                    outerloop:
                    if (act == 1) {
                        int rep = 1;
                        while (rep == 1) {
                            String name;
                            do {
                                name = DataInput.getString("Enter the name of the new faculty ").toUpperCase();
                                if (Arrays.asList(university.faculties).contains(university.getFaculty(name.toUpperCase()))) {
                                    System.out.println("Such faculty already exists");
                                    break outerloop;
                                }
                            } while (name.isEmpty());
                            Faculty newFac = new Faculty(name);
                            university.addFaculty(newFac);
                            int kolo = 1;
                            while (kolo == 1) {
                                String dep = DataInput.getString("Please, enter name of department of faculty " + name + " : ");
                                while (dep.isEmpty())
                                    dep = DataInput.getString("Please, enter name of department of faculty " + name + " : ");
                                Department newDep = new Department(dep);
                                newFac.addDepartment(newDep);
                                System.out.println("Now we must to add person to the department : ");
                                String suggest = "yes";
                                while (suggest.equals("yes")) {

                                        newDep.addPersonFromConsole();
                                    suggest = DataInput.getString("Do you want to repeat adding person? ").toLowerCase();
                                }
                                System.out.println(newDep);
                                kolo = DataInput.getInt("Please enter 1 to repeat adding department: ");
                            }
                            System.out.println(" Congratulations! you create new faculty in University!");
                            System.out.println(newFac);

                            System.out.println("We have such faculties in university  :\n " + university);
                            rep = DataInput.getInt("Please enter 1 to repeat adding faculty: ");
                        }
                    }
                    if (act == 2) {
                        String removeFac = DataInput.getString("Please enter name of the faculty what you want delete(" + university + ") :").toUpperCase();
                        while (removeFac.isEmpty())
                            removeFac = DataInput.getString("Please enter name of the faculty what you want delete(" + university + ") :").toUpperCase();
                        boolean contain = university.findFaculty(removeFac);
                        if (contain) {
                            String agree = "yes";
                            String reask = DataInput.getString("Are you sure you want to delete the faculty? ").toLowerCase();
                            if (reask.equals(agree)) {
                                university.removeFaculty(university.getFaculty(removeFac.toUpperCase()));
                                System.out.println("You have successfully deleted the faculty! Now we have: "+university);
                            }
                        } else {
                            System.out.println("You entered a non-existent faculty");
                        }
                    }
                    if (act==3){
                        String editFac = DataInput.getString("Please enter name of the faculty what you want edit(" + university + ") :").toUpperCase();
                        while (editFac.isEmpty())
                            editFac = DataInput.getString("Please enter name of the faculty what you want edit(" + university + ") :").toUpperCase();
                        boolean contain = university.findFaculty(editFac);
                        if (contain) {
                            String reask = DataInput.getString("Are you sure you want to edit the faculty? ").toLowerCase();
                            if (reask.equals("yes")) {
                                university.editFaculty(university.getFaculty(editFac));
                                System.out.println("You have successfully edited the faculty! Now we have: "+university);
                            }
                        } else {
                            System.out.println("You entered a non-existent faculty");
                        }
                    }
                    circle = DataInput.getInt("Enter 1 to repeat choosing actions with faculties: ");
                    repeat = false;
                }
            } catch (NumberFormatException no) {
                System.out.println("Please, enter correct value!");
            }
        }
    }
}