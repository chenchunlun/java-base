package regular;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Test {
    public static void test(){

        try {
            Pattern pattern = Pattern.compile("(?:(?:http|https)://[/a-zA-Z0-9&%.-?=]+)");
            StringBuilder sb = new StringBuilder();
            URL url = new URL("http://www.163.com/");
            String str = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((str = br.readLine())!=null){
                sb.append(str);
            }
            Matcher matcher = pattern.matcher(sb.toString());
            while (matcher.find()){
                System.out.println(matcher.group());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
