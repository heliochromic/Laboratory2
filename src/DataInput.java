import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

    public static Long getLong(String text) throws IOException {
        String s = getString(text);
        Long value = Long.valueOf(s);
        return value;
    }

    public static char getChar(String text) throws IOException{
        String s = getString(text);
        return s.charAt(0);
    }

    public static Integer getInt(String text){
        String s = "";
        try {
            s = getString(text);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Integer value = Integer.valueOf(s);
        return value;

    }

    public static String getString(String text) throws IOException{
        System.out.println(text);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static void printText(String text){
        System.out.println(text);
    }

}