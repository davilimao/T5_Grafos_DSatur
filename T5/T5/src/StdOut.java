public final class StdOut {
    private StdOut() { }

    public static void print(Object x) {
        System.out.print(x);
    }

    public static void println() {
        System.out.println();
    }

    public static void println(Object x) {
        System.out.println(x);
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}
