import java.util.HashMap;

public class TestImmutable {
    public static void main(String[] args) {
        IamImmutable immutable = new IamImmutable(5, "Arpit", new HashMap<String, String>() {{
            put("1","A");
            put("2","B");
        }});

        System.out.println(immutable.getH());

        immutable.getH().put("3","C");
        System.out.println(immutable.getH());
    }
}
