public class integer {

    private static int value;

    integer(int value) {
        this.value = value;
    }

    public static int getValue() {
        return value;
    }

    public static void setValue(int value) {
        integer.value = value;
    }
    public static void addtoValue(int value) {
        integer.value += value;
    }
}
