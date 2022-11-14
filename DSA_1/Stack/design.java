import java.util.*;
public class design {
    // stack of size specified by the user
    public static class CustomStack
    {
        int[] data;
        int tos;
        public CustomStack(int cap)
        {
            data = new int[cap];
            tos = -1;
        }
        int size()
        {
            return tos + 1;
        }
        void push(int val)
        {
            if(tos == data.length - 1)
            {
                System.out.println("Stack overflow");
                return;
            }
            tos++;
            data[tos] = val;
         }
         int pop()
         {
             if(tos == -1)
             {
                System.out.println("Stack underflow");
                return -1;
             }
             int temp = data[tos];
             tos--;
             return temp;
         }
         int peek()
         {
            if(tos == -1)
            {
               System.out.println("Stack underflow");
               return -1;
            }
            return data[tos];  
         }
         void display()
         {
             for(int ele = tos;ele>=0;ele--)
             {
                 System.out.print(data[ele]+" ");
             }
             System.out.println();
         }
    }
// dynamic sized stack where initial size is 10
    public static class DynamicClass
    {
        int[] data;
        int tos;

        public DynamicClass()
        {
            data = new int[10];
            tos = -1;
        }

        int size()
        {
            return tos + 1;
        }
        void push(int val)
        {
            if(tos == data.length - 1)
            {
                int[] arr = new int[2*this.size()];
                for(int i = 0;i<data.length;i++)
                {
                    arr[i] = data[i];
                }
                arr[++tos] = val;
                data = arr;

                return;
            }
            tos++;
            data[tos] = val;
        }
        int pop()
        {
            if(tos == -1)
            {
                System.out.println("Stack underflow");
                return -1;
            }
            int temp = data[tos];
            tos--;
            return temp;
        }
        int peek()
        {
            if(tos == -1)
            {
                System.out.print
            }
        }
    }
// https://leetcode.com/problems/number-of-recent-calls/
    public static class RecentCounter {
        LinkedList<Integer> st;
        public RecentCounter() {
            st = new LinkedList<>();
        }
    
        public int ping(int t) {
          st.addLast(t);
          
          int start = t - 3000;
          
          while(st.getFirst()<start)
          {
              st.removeFirst();
          }
          return st.size();
        }
      }
      // https://leetcode.com/problems/design-a-stack-with-increment-operation/


      public static class stackWithIncrement{

            int[] val;
            int[] inc;
            int tos;

            public stackWithIncrement(int maxSize) {
                val = new int[maxSize];
                inc = new int[maxSize];
                tos = -1;
            }
            
            public void push(int x) {
                if(tos == val.length -1)
                {
                    return;
                }
                tos++;
                val[tos] = x;
            }
            
            public int pop() {
                if(tos == -1)
                {
                    return -1;
                }
                int value = val[tos];
                int increment = inc[tos];
                inc[tos] = 0;
                tos--;
                if(tos>=0)
                inc[tos]=increment+inc[tos];
                return value + increment;
            }
            
            public void increment(int k, int val) {
                if(tos == -1)
                return;
                int incrementElement = Math.min(tos+1,k);
                int incrementIdx = incrementElement -1;
                inc[incrementIdx] += val;
            }


      }
// https://leetcode.com/problems/min-stack/submissions/
     public  class MinStack {

        public class Pair
        {
            int ele;
            int msf;

            Pair(int ele,int msf)
            {
                this.ele = ele;
                this.msf = msf;
            }
        }
        Stack<Pair> st;
        public MinStack() {
            st = new Stack<>();
        }
        
        public void push(int val) {
            if(st.size() == 0)
            {
                Pair p = new Pair(val,val);
                st.push(p);
            }
            else
            {
                Pair prevPair = st.peek();
                int prevVal  =  prevPair.ele;
                int prevMsf = prevPair.msf;

                if(val<prevMsf)
                {
                    st.push(new Pair(val,val));
                }
                else
                {
                    st.push(new Pair(val,prevMsf));   
                }
            }
        }
        
        public void pop() {
            st.pop();
        }
        
        public int top() {
            return st.peek().ele;
        }
        
        public int getMin() {
         return st.peek().msf;  
        }
    }
// https://leetcode.com/problems/exclusive-time-of-functions/
    public static int[] exclusiveTime(int n, List<String> logs) {
     
            class logpair
            {
                int id,timestamp,sleeptime;
                boolean isstart;
                logpair(String str)
                {
                   
                   id = Integer.parseInt(str.split(":")[0]);
                   isstart = str.split(":")[1].equals("start");
                   timestamp = Integer.parseInt(str.split(":")[2]);
                    
                }
            }
            int[] ans = new int[n];  
            Stack<logpair> st  = new Stack<>();  
            for(int i = 0;i<logs.size();i++)
            {
                String str = logs.get(i);
                logpair mp = new logpair(str);

                if(mp.isstart)
                {
                    st.push(mp);
                }
                else
                {
                    logpair rp = st.pop();
                    ans[rp.id] +=  (mp.timestamp - rp.timestamp + 1) - rp.sleeptime;
                    if(st.size()!=0)
                    {
                        st.peek().sleeptime += mp.timestamp - rp.timestamp + 1;
                    }
                }
            }
            return ans;
        }
    

   // https://www.geeksforgeeks.org/design-a-hit-counter/

    public static class hitCounters
    {
            // contstructor -> Initialize your ds here
            ArrayList<Integer> al;
        hitCounters()
        {
            al = new ArrayList<>();
        }

        int hit(int timestamp)
        {
            al.add(timestamp);
        }
        int gethit(int timestamp)
        {
            int i = 0;
            int val = timestamp - 300 + 1;
            while(val>al.get(i))
            {
                i++;
            } 
            return al.size() - i;
        }
// optimized in space using queue
        public static class hitCounter
        {
                // contstructor -> Initialize your ds here
                LinkedList<Integer> ll;
            hitCounter()
            {
              ll = new LinkedList<>();
            }
    
            int hit(int timestamp)
            {
                ll.addFirst(timestamp);
            }
            int gethit(int timestamp)
            {
                int val = timestamp - 300 + 1;
                while(val>ll.getLast())
                {
                    ll.removeLast();
                } 
                return ll.size();
            }
    }

    public static void main(String[] args)
    {

    }

}
