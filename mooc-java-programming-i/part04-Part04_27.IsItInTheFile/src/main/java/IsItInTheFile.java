import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class IsItInTheFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        System.out.println("Name of the file:");
        String file = String.valueOf(scanner.nextLine());

        System.out.println("Search for:");
        String searchedFor = String.valueOf(scanner.nextLine());

        try (Scanner read = new Scanner(Paths.get(file))) {
            while (read.hasNextLine()) {

                list.add(read.nextLine());
            }

        } catch (Exception error) {
            System.out.println("Reading the file " + file + " failed.");
        }
        if (list.contains(searchedFor)) {
            System.out.println("Found!");
        } else {
            System.out.println("Not found.");
        }

    }
}
