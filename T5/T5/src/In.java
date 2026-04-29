import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;

public class In {
    private Scanner scanner;

    public In(String name) {
        try {
            File file = new File(name);
            if (file.exists()) {
                scanner = new Scanner(file, "UTF-8");
                scanner.useLocale(Locale.US);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Could not open " + name, ioe);
        }
    }

    public boolean exists() {
        return scanner != null;
    }

    public int readInt() {
        return scanner.nextInt();
    }

    public boolean isEmpty() {
        return !scanner.hasNext();
    }

    public void close() {
        scanner.close();
    }
}
