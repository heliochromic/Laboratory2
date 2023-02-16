import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Person a = new Professor("ok", "aa");
        String str = String.valueOf(a.getClass()).split(Pattern.quote(" "))[1];
        System.out.println(str.split(Pattern.quote(" "))[1]);
    }
}