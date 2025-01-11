package cheatSheet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@FunctionalInterface
public interface UPIPaymentInterface{
    public String doPayment(String source,String destination);

    default double getScratchCard(){
        return new Random().nextDouble();
    }

    static  String datePatterns(String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());

    }
}
