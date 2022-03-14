package fr.istic.vv;

import java.awt.*;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        if("".equals(str)) return true ;
        else if ("()".equals(str)) return true ;
        else if ("{}".equals(str)) return true ;
        else if ("[]".equals(str)) return true ;
        else {
            String result = str.replace("()","");
            result = result.replace("{}","");
            result = result.replace("[]","");
            if(result.equals(str)) return false ;
            else return isBalanced(result) ;
        }

    }

}
