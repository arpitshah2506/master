import java.util.HashMap;

final class IamImmutable {
    private int i;
    private String s;
    private HashMap<String, String> h;

    public IamImmutable(int i, String s, HashMap<String, String> h) {
        this.i = i;
        this.s = s;
        this.h = h;
    }

    public int getI() {
        return i;
    }

    public String getS() {
        return s;
    }

    public HashMap<String, String> getH() {
        return new HashMap<>(h);
    }
}
