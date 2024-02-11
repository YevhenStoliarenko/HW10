import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadNumber {


    public void readNumber() throws IOException {

        File file = new File("phoneNumber.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(System.lineSeparator());
        }
        String result = stringBuilder.toString();
        String[] phoneNumber = result.split("\n");
        String regex1 = "\\((\\d){3}\\)(\\s)(\\d){3}\\-(\\d){4}";
        String regex2 = "(\\d){3}\\-(\\d){3}\\-(\\d){4}";
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);

        for (int i = 0; i < phoneNumber.length; i++) {
            Matcher matcher1 = pattern1.matcher(phoneNumber[i]);
            Matcher matcher2 = pattern2.matcher(phoneNumber[i]);
            if (matcher1.find() || matcher2.find()) {
                System.out.println(phoneNumber[i]);
            } else {
                System.out.println("Error!");
            }


        }
    }
}
