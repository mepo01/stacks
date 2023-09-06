package ak.po.interfaces;

public interface StackInterface
{
    /**
     * Odłuż na stosie
     * @param value
     */
    void push(Object value);

    /**
     * Pobierze ze stosu i zwróć
     * @return
     */
    Object pop();

    /**
     * Zwróć wierzchołek stosu bez zdejmowania
     * @return
     */
    Object peek();

    /**
     * Wyczyść
     */
    void clear();

    /**
     * Ilość elementów na stosie
     * @return
     */
    int size();

    /**
     * Czy pusty?
     * @return
     */
    boolean empty();

    /**
     * Zwraca i-ty element stosu
     * @param index
     * @return
     */
    Object getItem(int index);
}
