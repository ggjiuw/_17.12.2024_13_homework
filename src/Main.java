import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        boolean a = equals(getFirstCollection(), getSecondCollection());
        System.out.println(a);
    }

    public static Iterable<String> getFirstCollection() {
        List<String> ships = new ArrayList<>();
        ships.add("Titanic");
        ships.add("Queen Mary");
        ships.add("Black Pearl");
        return ships;
    }

    public static Iterable<String> getSecondCollection() {
        List<String> ships = new ArrayList<>();
        ships.add("Titanic");
        ships.add("Black Pearl");
        ships.add("Queen Mary");
        return ships;
    }

    public static boolean equals(Iterable<String> first, Iterable<String> second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }


        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (String item : first) {
            list1.add(item);
        }
        for (String item : second) {
            list2.add(item);
        }

        if (list1.size() != list2.size()) {
            return false;
        }

        for (String item1 : list1) {
            boolean found = false;
            Iterator<String> iterator = list2.iterator();
            while (iterator.hasNext()) {
                if (item1.equals(iterator.next())) {
                    found = true;
                    iterator.remove();
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }
}