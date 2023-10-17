import java.util.HashMap;
import java.util.Map;

public class Multiset<E> {
    private final Map<E, Integer> numElements;

    public Multiset() {
        numElements = new HashMap<>();
    }

    public void add(E element){
        numElements.put(element, numElements.getOrDefault(element, 0) + 1);
    }

    public void remove (E element){
        int count = numElements.getOrDefault(element,0);
        if (count > 1) {
            numElements.put(element, count - 1);
        }
        else{
            numElements.remove(element);
        }
    }
}
