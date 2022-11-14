import java.util.*;
public class Anagrams
{
    public static boolean isEquals(HashMap<Character,Integer> phm,HashMap<Character,Integer>shm)
    {
        for(char key : shm.keySet())
        {
            if(shm.get(key)!=phm.getOrDefault(key, 0))
            {
                return false;
            }
        }
        return true;
    }
    public static void findAnagrams(String s, String p) {
       HashMap<Character,Integer> shm = new HashMap<>();
       HashMap<Character,Integer> phm = new HashMap<>();

       for(int i = 0;i<p.length();i++)
       {
           char ch = p.charAt(i);
           phm.put(ch,phm.getOrDefault(ch,0)+1);
       }
        for(int i = 0;i<p.length();i++)
        {
            char ch = s.charAt(i);
            shm.put(ch,shm.getOrDefault(ch, 0)+1);
        }
        int i = p.length();
        int j = 0;
        int count = 0;
        String ans = "";
        while(i<s.length())
        {
            if(isEquals(phm,shm))
            {
                count++;
                ans+=j+" ";
            }

            // acquire 
            char chi = s.charAt(i);
            shm.put(chi,shm.getOrDefault(chi,0)+1);

            // release
            char chj = s.charAt(j);

            if(shm.get(chj) == 1)
            {
                shm.remove(chj);
            }
            else
            {
                shm.put(chj,shm.get(chj)-1);
            }

            // move window for next iteration
            i++;
            j++;
        }
        if(isEquals(phm,shm))
        {
            count++;
            ans+=j;
        }

    }
    public static boolean areKAnagrams(String str1, String str2, int k) {
            HashMap<Character,Integer> hm1 = new HashMap<>();
         
            for(int i = 0;i<str1.length();i++)
            {
                char ch = str1.charAt(i);
                hm1.put(ch,hm1.getOrDefault(ch,0)+1);
            }

            for(int i = 0;i<str2.length();i++)
            {
                char ch = str2.charAt(i);
                if(hm1.getOrDefault(ch,0) == 0)
                {

                }
                else
                {
                    hm1.put(ch,hm1.get(ch) - 1);
                }
            }
            int ans = 0;
            for(char ch : hm1.keySet())
            {
                ans+=hm1.get(ch);
            }

            if(ans<=k)
            {
                return true;
            }
            return false;
	}
    public static void main(String[] args)
    {

    }
}