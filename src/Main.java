import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {

        University university = new University("NaUKMA");

        Faculty fi = new Faculty("FI");
        Faculty fsnst = new Faculty("FSNST");
        Faculty fen = new Faculty("FEN");

        university.addFaculty(fi);
        university.addFaculty(fsnst);
        university.addFaculty(fen);

        System.out.println(university);

        Department mathematics = new Department("Department of Mathematics");
        Department informatics = new Department("Department of Informatics");
        Department ir = new Department("Department of International relations");

        fi.addDepartment(mathematics);
        fi.addDepartment(informatics);
        fsnst.addDepartment(ir);

        System.out.println(fi);

        Student emmaGarcia = new Student("Emma Garcia",3,3);
        Student johnHarris = new Student("John Harris",4,2);
        Student davidDavis = new Student("David Davis",2,1);
        Student davidAnderson = new Student("David Anderson",2,1);
        Student ivanIngram = new Student("Ivan Ingram",2,3);
        Student johnGarcia = new Student("John Garcia",4,5);
        Student aliceHarris = new Student("Alice Harris",2,6);
        Student davidJohnson = new Student("David Johnson",3,6);
        Student ivanFord = new Student("Ivan Ford",1,4);
        Student frankHarris = new Student("Frank Harris",4,5);
        Student helenHarris = new Student("Helen Harris",1,4);
        Student ivanClark = new Student("Ivan Clark",2,1);
        Student emmaBrown = new Student("Emma Brown",2,1);
        Student davidFord = new Student("David Ford",4,1);
        Student markBell = new Student("Mark Bell", 2, 5);

        Professor frankGarcia = new Professor("Frank Garcia","Algebra");
        Professor johnIngram = new Professor("John Ingram","Programming in java");
        Professor helenIngram = new Professor("Helen Ingram","Model comp");
        Professor frankieHarris = new Professor("Frankie Harris","Computer algorithms");
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

        //System.out.println(ir);

        Student[] sortedDepartment = informatics.sortStudentsByCourse();
        System.out.println(informatics.personToString(sortedDepartment));

        Student[] sortedByNameListOfStudents = fi.sortFacultyStudentsByName();
        System.out.println(fi.personToString(sortedByNameListOfStudents));
    }
}