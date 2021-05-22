package code.transfer;

public interface Transferable<T> {
    Transferable getTransfer();

    T toObjectBy(String[] info);

    String toStringBy(T entity);
}
