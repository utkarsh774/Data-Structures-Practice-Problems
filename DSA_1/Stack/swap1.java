public class swap1 {
    
    public static class person
    {
        String name;
        int age;

        public void sayHi()
        {
            System.out.println(name+" "+age);
        }

    }

    public static void main(String[] args)
    {
        person p1 = new person();
        p1.name = "A";
        p1.age = 10;

        person p2 = new person();
        p2.name = "B";
        p2.age = 20;

        p1.sayHi();
        p2.sayHi();

        swap4(p1,p2);
        p1.sayHi();
        p2.sayHi();
    }

    public static void swap1(person p1,person p2)
    {
        person temp = p1;
        p1 = p2;
        p2 = temp;
    }
    public static void swap2(person p1,person p2)
    {
        String temp1  = p1.name;
        p1.name = p2.name;
        p2.name = temp1;

        int temp2 = p1.age;
        p1.age = p2.age;
        p2.age = temp2;
    }
    public static void swap3(person p1,person p2)
   {
        int temp1  = p1.age;
        p1.age = p2.age;
        p2.age = temp1;

        p1 = new person();
        String temp2 = p1.name;
        p1.name = p2.name;
        p2.name = temp2;
    }
    public static void swap4(person a1,person a2)
    {
        a2 = new person();
        int temp = a1.age;
        a1.age = a2.age;
        a2.age = temp;

        a1 = new person();
        String t = a1.name;
        a1.name = a2.name;
        a2.name = t;
    }
}
