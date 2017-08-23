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

        sb.append(b);                         // append  - adds strings to our string
        System.out.println(sb);
        sb.append(',');
        System.out.println(sb);

    }
}


