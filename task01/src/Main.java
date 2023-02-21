import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        String str1 = "123qwe23qwe1";
        String str2 = "123qwe123qwe0";
        //System.out.println(Arrays.toString(Pattern.compile("\\D+").split(str1)));
        Comparator<String> comparatorForSumInStr = Comparator.comparingInt(o ->
                Arrays.stream(Pattern.compile("\\D+").split(o))
                             .mapToInt(Integer::parseInt).sum());
       System.out.println(comparatorForSumInStr.compare(str1, str2));
    }
}