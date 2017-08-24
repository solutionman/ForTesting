import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

// String to BigDecimal and Back to String

public class TestingBigDecimal {
    public static void main(String[] args){

        String  a = "0.41";

        BigDecimal b = new BigDecimal(a).setScale( 2, BigDecimal.ROUND_HALF_UP );

        String c = new BigDecimal(a).setScale( 2, BigDecimal.ROUND_HALF_UP ).toString();


        System.out.println(b);
        System.out.println(c);

        StringBuilder sb = new StringBuilder();

        sb.append(c);                         // append  - adds strings to our string
        System.out.println(sb);
        sb.append(',');
        System.out.println(sb);

        BigDecimal zero = BigDecimal.ZERO;
        System.out.println("BigDecimal zero = " + zero);

        String StringData = sb.toString();

        //char[] data = {'0', '.', '4', '0'};
        char[] data = StringData.toCharArray();

        try {
            File date = new File("./output");
            PrintWriter writer = new PrintWriter("12345.s09");
            writer.write(data);
            writer.close();
        } catch (IOException e){
            System.out.println("Some problems with writing to file");
        }

    }
}












