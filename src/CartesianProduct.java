import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartesianProduct<T> {
    private final List<List<T>> listOfLists;
    private final int[] counters;
    private final List<Integer> counterLimits;


    public CartesianProduct(List<List<T>> listOfLists) {
        this.listOfLists = listOfLists;
        counters = new int[numberOfLists()];
        Arrays.fill(counters, 0);
        counterLimits = listOfLists.stream()
                .map(List::size)
                .toList();
    }

    public int numberOfLists(){
        return listOfLists.size();
    }

    public boolean hasNextList(){
        int size = numberOfLists();
        return (!(counters[size-1] == counterLimits.get(size-1)));
    }

    public List<T> getNextList() {
        List<T> res = new ArrayList<>();
        for (int list = 0; list < numberOfLists(); list++) {
            int index = counters[list];
            res.add(listOfLists.get(list).get(index));
        }
        incrementCounters();
        return res;
    }

    private void incrementCounters() {
        int counter = 0;
        incrementNextCounter(counter);
    }

    private void incrementNextCounter(int counter) {
        int nextCounterValue = counters[counter];
        int nextLimit = counterLimits.get(counter);
        if (nextCounterValue + 1 == nextLimit) {
            if (counter == numberOfLists()-1) {
                counters[counter] += 1;
                return;
            }
            counters[counter] = 0;
            incrementNextCounter(counter+1);
        } else counters[counter] += 1;
    }
}
