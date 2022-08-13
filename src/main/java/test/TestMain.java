package test;

public class TestMain {
    public static void main(String[] args) {
        String s = "";
        System.out.println("".equals(s));
        boolean matches = s.matches(null);
        System.out.println(matches);
    }
}
