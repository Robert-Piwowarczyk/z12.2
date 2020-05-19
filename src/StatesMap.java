import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

 class StatesMap {
     static Map<String, TreeSet<State>> readFile(String fileName) throws FileNotFoundException {
         Map<String, TreeSet<State>> statesMap = new HashMap<>();
         try (Scanner fileReader = new Scanner(new File(fileName))) {
             fileReader.nextLine();
             while (fileReader.hasNextLine()) {
                 String[] data = fileReader.nextLine().split(";");
                 String state = data[0];
                State states = new State(data[1],data[2] , Integer.parseInt(data[3]));
                 if (statesMap.containsKey(states))
                     statesMap.get(state).add(states);
                 else {
                     TreeSet<State> stateSet = new TreeSet<>();
                     stateSet.add(states);
                     statesMap.put(state, stateSet);
                 }
             }
         }
         return statesMap;
     }

     private static void insertProductIntoMap
             (Map<String, TreeSet<State>> productsMap, String category, State state) {
         if (productsMap.containsKey(category))
             productsMap.get(category).add(state);
         else {
             TreeSet<State> categorySet = new TreeSet<>();
             categorySet.add(state);
             productsMap.put(category, categorySet);
         }
     }
 }
