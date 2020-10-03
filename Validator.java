import java.util.Scanner;
public class Global
{
    public static int cri;
}
public class Validator
{
    public static void status(val)
    {
        Global.cri++;
        System.out.println(val);
    }
    int validateStrength(String str)
    {
        int cri = 0, len = str.length();
        if(len>=8) status(1);
        if(len<=16) status(2);
        char ch;
        boolean capitalFlag = false, lowerCaseFlag = false, numberFlag = false, specialFlag = false, consNo = false, consUpper = false, consLower = false;
        for(int i=0; i < len; i++)
        {
            ch = str.charAt(i);
                if(Character.isDigit(ch)) numberFlag = true;
                else if (Character.isUpperCase(ch)) capitalFlag = true;
                else if (Character.isLowerCase(ch)) lowerCaseFlag = true;
                else
                {
                    if(!Character.isWhitespace(ch)) specialFlag = true;
                }
        }
        
        if(capitalFlag) status(3);
        if(lowerCaseFlag) status(4);
        if(numberFlag) status(5);
        if(specialFlag) status(6);

        int i;
        for(i=0;i<(len-1);i++)
            if(Character.isDigit(str.charAt(i)) && Character.isDigit(str.charAt(i+1)))
                if(Math.abs(str.charAt(i) - str.charAt(i+1)) == 1) consNo = true;break;
                              
        if (consNo) status(7);
        
        for(int i=0; i<(len-2); i++)
                if(Character.isUpperCase(str.charAt(i)) && Character.isUpperCase(str.charAt(i+1)) && Character.isUpperCase(str.charAt(i+2)))
                {
                    consUpper = true;
                    break;
                }
        if (consUpper) status(8);
       
        for(int i=0; i<(len-2); i++)
                if(Character.isLowerCase(str.charAt(i)) && Character.isLowerCase(str.charAt(i+1)) && Character.isLowerCase(str.charAt(i+2)))
                {
                    consLower = true;
                    break;
                }
        
        if (consLower) status(9);
        
        if(Global.cri < 2) return 0;
        if(Global.cri >= 2 && cri < 5) return 1;
        if(Global.cri >= 5 && cri < 8) return 2;
        else return 3;
    }
    
    public static void main(String args[])
    {
      Scanner in = new Scanner(System.in);
      String pswd = in.nextLine();
      Validator v = new Validator();
      System.out.println(v.validateStrength(pswd));
    }      
}
