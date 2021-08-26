public class Hideout<T> {

    private T object;

    public void putIntoHideout(T toHide) {
        object = toHide;
    }

    public T takeFromHideout() {
        T temp = object;
        object = null;

        return temp;
    }

    public boolean isInHideout() {
        return object != null;
    }
}
