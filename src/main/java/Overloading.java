public class Overloading {
    public static void main(String[] args) {
        System.out.println();add(10,20);
    }

    public static int add(int a, int b)
    {
        return a + b;
    }

    public static long add(long a, long b)
    {
        System.out.println("hello");
        return a + b;
    }
}
