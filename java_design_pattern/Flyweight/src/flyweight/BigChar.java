package flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
	   
    private char charname;
    private String fontdata;
   
    public BigChar(char charname) {
        this.charname = charname;
        System.out.println(this.charname);
        try {
            BufferedReader reader = new BufferedReader(
                new FileReader("C:\\code_folder\\clone_coding\\java_design_pattern\\Flyweight\\src\\big" + charname + ".txt")
            );
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            this.fontdata = buf.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }
    // 큰 문자를 표시한다.
    public void print() {
        System.out.print(fontdata);
    }
}

