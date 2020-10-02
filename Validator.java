import java.util.Scanner;
public class Validator
{
    int validateStrength(String str)
    {
        int cri = 0;
        if(str.length() >= 8 )
        {
            cri++;
            System.out.println("1");
        }
        if(str.length() <= 16 )
        {
            cri++;
            System.out.println("2");
        }
        
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        boolean specialFlag = false;
        for(int i=0; i < str.length(); i++)
        {
            ch = str.charAt(i);
                if(Character.isDigit(ch))
                {
                   numberFlag = true;
                }
                else if (Character.isUpperCase(ch))
                {
                    capitalFlag = true;
                }
                else if (Character.isLowerCase(ch))
                {
                    lowerCaseFlag = true;
                }
                else
                {
                    if(Character.isWhitespace(ch) == false)
                    {
                        specialFlag = true;
                    }
                }
        }
        
        if(capitalFlag){
            cri++;
            System.out.println("3");
        }
        if(lowerCaseFlag){
            cri++;
            System.out.println("4");
        }
        if(numberFlag){
            cri++;
            System.out.println("5");
        }
        if(specialFlag){
            cri++;
            System.out.println("6");
        }
        
        boolean consNo = false;
        for(int i=0; i < ( str.length() - 1 ); i++)
        {
        
            if(Character.isDigit(str.charAt(i)) && Character.isDigit(str.charAt(i+1)))
            {
                if(Math.abs(  str.charAt(i) - str.charAt(i+1)  ) == 1)
                {
                    consNo = true;
                    break;
                }
                    
            }
        }
        if (consNo)
        {
            cri++;
            System.out.println("7");
        }
        
        boolean consUpper = false;
        for(int i=0; i < ( str.length() - 2 ); i++)
        {
                if(Character.isUpperCase(str.charAt(i)) && Character.isUpperCase(str.charAt(i+1)) && Character.isUpperCase(str.charAt(i+2)))
                {
                    consUpper = true;
                    break;
                }
        }
        if (consUpper)
        {
            cri++;
            System.out.println("8");
        }
       
        boolean consLower = false;
        for(int i=0; i < ( str.length() - 2 ); i++)
        {
                if(Character.isLowerCase(str.charAt(i)) && Character.isLowerCase(str.charAt(i+1)) && Character.isLowerCase(str.charAt(i+2)))
                {
                    consLower = true;
                    break;
                }
        }
        
        if (consLower)
        {
            cri++;
            System.out.println("9");
        }
        
        
        if(cri < 2){
            return 0;
        }
        if(cri >= 2 && cri < 5){
            return 1;
        }
        if(cri >= 5 && cri < 8)
        {
            return 2;
        }
        else{
            return 3;
        }
    }
    
    public static void main(String args[])
    {
      String pswd;
      Scanner in = new Scanner(System.in);
      pswd = in.nextLine();
      Validator v = new Validator();
      System.out.println(v.validateStrength(pswd));
    }      
}
