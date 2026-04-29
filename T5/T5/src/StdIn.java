import java.util.Scanner;
import java.util.Locale;

public final class StdIn {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in, "UTF-8");
        scanner.useLocale(Locale.US);
    }

    private StdIn() { }

    public static boolean isEmpty() {
        return !scanner.hasNext();
    }

    public static int readInt() {
        return scanner.nextInt();
    }

    public static String readString() {
        return scanner.next();
    }
}
