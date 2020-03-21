import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 13104 KB, 76 ms
// 3568번 iSharp
// https://www.acmicpc.net/problem/3568
public class Bj3568 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ;");
        String basicVariable = st.nextToken();

        String v;
        Pattern NamePattern = Pattern.compile("[a-zA-Z]");
        Pattern variablePattern = Pattern.compile("[&*\\[\\]]");
        while (st.hasMoreTokens()) {
            v = st.nextToken();

            Matcher variableMatcher = variablePattern.matcher(v);
            StringBuilder variable = new StringBuilder();
            while(variableMatcher.find())
                variable.append(variableMatcher.group());


            Matcher nameMatcher = NamePattern.matcher(v);
            StringBuilder name = new StringBuilder();
            while(nameMatcher.find())
                name.append(nameMatcher.group());

            System.out.println(basicVariable + reverseString(variable) + " " + name + ";");
        }
    }
    private static String reverseString(StringBuilder sb) {
        String s = "";
        for (int i = sb.length()-1; i >= 0; i--) {
            if (sb.charAt(i) == ']') {
                s += "[]";
                i--;
            } else {
                s += sb.charAt(i);
            }
        }
        return s;
    }
}
