import java.util.*;
public class strings {
    // leetcode 32
    public int longestValidParentheses(String s) {
     Stack<Integer> st = new Stack<>();
     
     st.push(-1);
     int max = 0;
     for(int i = 0;i<s.length();i++)
     {
         char ch = s.charAt(i);

         if(st.peek()!=-1&&s.charAt(st.peek())=='(' && ch == ')')
         {
             st.pop();

             max = Math.max(max,i - st.peek());
         }
         else
         {
             st.push(i);
         }
     }
     return max;
    }

// leetcode 20
    public static  boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
       for(int i = 0;i<s.length();i++)
       {
           char ch = s.charAt(i);
           
           if(ch=='(' || ch == '{' || ch == '[')
           {
                st.push(ch);
           }
          else 
          {
              if(st.size() == 0)
              {
                  return false;
              }
              else if(st.peek()!='(' && ch == ')') return false;
              else if(st.peek()!='{' && ch == '}') return false;
              else if(st.peek()!='[' && ch == ']') return false;
              st.pop();
          }
       }
       return st.size()==0;
       } 
    //856
       public  static int scoreOfParentheses(String s) {
        
            Stack<Integer> st  =  new Stack<>();

            // ( -> -1

            for(int i = 0;i<s.length();i++)
            {
                char ch = s.charAt(i);

                if(ch == ')')
                {
                    if(st.peek() == -1) 
                    {
                        st.pop();
                        st.push(1);
                    }
                  else
                {
                    int sum = 0;

                    while(st.peek()!=-1)
                    {
                       sum += st.pop();
                    }
                    st.pop();
                    st.push(2*sum);
                }
                }
                else{
                    st.push(-1);
                }
            }
            int ans = 0;
            while(st.size()>0)
            {
               ans+= st.pop();
            }
            return ans;
    }
// leetcode 1003
    public static boolean isValid_(String s) {

        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(st.size()>1 && ch == 'c')
            {
                char ch1 = st.pop();
                char ch2 = st.pop();

                if(ch1=='b' && ch2 == 'a')
                {

                }
                else
                {
                    st.push(ch2);
                    st.push(ch1);
                    st.push(ch);
                }
            }
            else
            {
                st.push(ch);
            }

           
        }
         return st.size() == 0;
    }
    public static void main(String[] args)
    {

        
    }
}
