package linear.equation;
import java.util.Scanner;
public class LinearEquation {
    public static void main(String[] args) 
    {
        String Eq=" "; int equal_pos=0; int coff_sum=0,constant_sum=0;double ans;
        Scanner kb=new Scanner(System.in);
        System.out.print("Enter the Linear Equation(X): ");
        Eq+=kb.nextLine();
        Eq+=" ";
        for(int i=0;i<Eq.length();i++)
        {
            if(Eq.charAt(i)=='=')
            {
                equal_pos=i;
            }
        }
        int l,ll,r,n;
        for(int i=0;i<Eq.length();i++)
        {
            l=i;l--;
            r=i;r++;
            if(Character.isLetter(Eq.charAt(i)) )//for cofficent sum
            {
                 if(Character.isDigit(Eq.charAt(l))) //*2x
                 {
                     n=Eq.charAt(l);
                     n=n-48;
                     //System.out.println(n);
                     //System.out.println(n);
                     ll=l;ll--;
                     if(Eq.charAt(ll)=='+' || Eq.charAt(ll)==' ')
                     {
                         if(i<equal_pos) 
                         {
                             coff_sum=coff_sum+n;
                         }
                         else if(i>equal_pos) 
                         {
                             coff_sum=coff_sum-n;
                         }
                     }
                     else if(Eq.charAt(ll)=='-')
                     {
                         if(i<equal_pos) coff_sum-=n;
                         else if(i>equal_pos) coff_sum+=n;
                     }
                 }
                 else if(Eq.charAt(l)=='+')//+x
                 {
                     if(i<equal_pos) coff_sum++;//last
                     else if(i>equal_pos) coff_sum++;
                 }
                 else if(Eq.charAt(l)=='-')//-x///
                 {
                     if(i<equal_pos) coff_sum--;
                     else if(i>equal_pos) coff_sum++;
                 }
                 else if(Eq.charAt(l)==' ' || Eq.charAt(l)=='=')
                 {
                    if(i<equal_pos) coff_sum++;
                    else if(i>equal_pos) coff_sum--;
                 }
            }
            else if(Character.isDigit(Eq.charAt(i)))//for constants
            {
                n=Eq.charAt(i);
                n=n-48;
               if(Eq.charAt(l)==' ' & Eq.charAt(r)!='X')
               {
                   if(i<equal_pos)
                   {
                       constant_sum=constant_sum-n;
                   }
                   else if(i>equal_pos) 
                   {
                       constant_sum=constant_sum+n;
                   }
               }
               else if(Eq.charAt(l)=='=' & Eq.charAt(r)!='X')
               {
                   constant_sum=constant_sum+n;
               }
               else if(Eq.charAt(l)=='+' & Eq.charAt(r)!='X')
               {
                   if(i<equal_pos)
                   {
                       constant_sum=constant_sum-n;
                   }
                   else if(i>equal_pos) 
                   {
                       constant_sum=constant_sum+n;
                   }
               }
              else if(Eq.charAt(l)=='-' & Eq.charAt(r)!='X')
               {
                   if(i<equal_pos)
                   {
                      constant_sum=constant_sum+n; 
                   }
                   else if(i>equal_pos)
                   {
                       constant_sum=constant_sum-n;
                   }
               }
            }
                       
        }
         System.out.println("Coff: "+coff_sum+"  Const: "+constant_sum);
        if(coff_sum!=0)
        {
            ans=constant_sum/coff_sum;
            System.out.println("The value of X: "+ans);
        }
        else
            System.out.println("The value of X: Undefine");
        
    }  
}