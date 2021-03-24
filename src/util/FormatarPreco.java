package util;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;

public class FormatarPreco {

    public BigDecimal paraBigDec(String str) {

        try {
            str = str.replace(".", "");
            str = str.replace(",", ".");
            str = str.trim();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new BigDecimal(str);
    }

}
