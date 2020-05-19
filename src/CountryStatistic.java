import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

class CountryStatistic {
    public static void main(String[] args) {
        try {
            Map<String, TreeSet<State>> statesMap = StatesMap.readFile("states.csv");
            String category = readCategoryFromUser();
            printCategoryStats(statesMap, category);
        } catch (FileNotFoundException e) {
            System.err.println("Brak pliku z danymi państw");
        }
    }

    private static String readCategoryFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kod kraju dla wyświetlenia statystyk:");
        return scanner.nextLine();
    }

    private static void printCategoryStats(Map<String, TreeSet<State>> productsMap, String category) {
        TreeSet<State> states = productsMap.get(category);
        if (states == null)
            System.out.println("Brak zapisanych państw na liście");
        else  {
            printAll(states);
        }
    }

    private static void printAll(TreeSet<State> states) {
        for (State state : states) {
            System.out.println("Statystyka kraju: " + state);
        }
    }
}