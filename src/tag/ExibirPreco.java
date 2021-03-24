package tag;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ExibirPreco {
    
    public static String paraStr(BigDecimal bigDecimal) {
            
        try {
            DecimalFormat formatoDecimal = new DecimalFormat("#,###,##0.00");
            return formatoDecimal.format(bigDecimal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
