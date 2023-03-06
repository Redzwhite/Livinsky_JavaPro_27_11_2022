package org.example.homework23;
public class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    PerformOperation isOdd()
    {
        return (int a)-> a % 2 != 0;
    }
    PerformOperation isPrime()
    {
        return (int a)->
        {
            if(a == 1) return true;
            else
            {
                for (int i =  2; i < Math.sqrt(a); i++)
                    if(a%i == 0) return false;
                return true;
            }
        };
    }
    PerformOperation isPalindrome()
    {
        return (int a)->
        {
            String str = Integer.toString(a);
            String reverse = "";
            for(int i = str.length()-1; i >= 0; i--)
            {
                reverse = reverse + str.charAt(i);
            }
            return reverse.equals(str);
        };
    }
}
