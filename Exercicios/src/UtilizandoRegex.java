import java.util.regex.Pattern;

public class UtilizandoRegex {
    //REGEX -> https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
    UtilizandoRegex(){

    }

    //Formato -> (123) 456-7190
    public boolean validaNumeroCelular(String s){
        if(s.length() == 14){
            if(s.substring(0,1).equals("(") &&
                    s.substring(4,5).equals(")") &&
                    s.substring(5,6).equals(" ") &&
                    s.substring(9,10).equals("-")){

                if(Pattern.compile("\\d\\d\\d").matcher(s.substring(1,4)).find() &&
                        Pattern.compile("\\d\\d\\d").matcher(s.substring(6,9)).find() &&
                        Pattern.compile("\\d\\d\\d\\d").matcher(s.substring(10,14)).find()){

                    return true;
                }
            }
        }
        return false;
    }

    public String montaStringSemCaracteresEspeciais(String s){
        String[] list = s.split("");
        String retorno = "";

        for(String str : list){
            if(Pattern.compile("\\p{Punct}").matcher(str).find()){
                str="";
            }
            retorno += str;
        }
        return retorno;
    }
}
