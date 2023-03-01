import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {

        Department dp = new Department("FI");
        dp.addPerson(new Student("Anton Yakoobovich", 1, 4));
        dp.addPerson(new Student("Sasha Prokhorov", 3, 1));
        dp.addPerson(new Student("Anastasia Smovzhenko", 4, 1));
        dp.addPerson(new Professor("Ushenko Kateryna", "Введення в залупу"));


        //System.out.println(dp.people[1]);

        //DataInput.getString();
        //dp.editPerson(dp.people[1]);

        //System.out.println(dp.people[1]);
        DataInput.getString();

        System.out.println(Arrays.toString(dp.people));
        dp.removePerson(dp.people[0]); //arraycopy: last destination index 4 out of bounds for object array[3]
        System.out.println(Arrays.toString(dp.people));

    }
}