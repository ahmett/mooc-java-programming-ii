import java.util.ArrayList;
import java.util.List;

public class Pipe<T> {

    private final List<T> list;

    public Pipe() {
        this.list = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        list.add(value);
    }

    public T takeFromPipe() {
        if (list.isEmpty()) {
            return null;
        }

        return list.remove(0);
    }

    public boolean isInPipe() {
        return !list.isEmpty();
    }
}
