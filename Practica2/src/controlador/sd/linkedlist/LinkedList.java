package controlador.sd.linkedlist;

public class LinkedList<E> {

    private Node<E> head;
    private Node<E> last;
    private Integer size;

    public LinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    public Integer getSize() {
        return size;
    }

    public Boolean isEmpty() {
        return head == null;
    }

    protected void addFirst(E data) {

        size++;

        if (isEmpty()) {
            Node<E> aux = new Node<>(data, null);
            head = aux;
            last = aux;
            return;
        }

        Node<E> current = head;

        Node<E> tmp = new Node<>(data, current);

        head = tmp;

    }

    protected void addLast(E data) {

        if (isEmpty()) {
            addFirst(data);
            return;
        }

        Node<E> tmp = new Node<>(data, null);

        last.setNext(tmp);

        last = tmp;

        size++;

    }

    public void add(E data) {
        addLast(data);
    }

    public void add(E data, Integer idx) {

        if (idx == 0) {
            addFirst(data);
            return;
        }

        if (idx == (idx - 1)) {
            System.out.println("a");
            addLast(data);
            return;
        }

        Node<E> preview = getNode(idx - 1);

        Node<E> current = getNode(idx);

        Node<E> tmp = new Node<>(data, current);

        preview.setNext(tmp);

        size++;

    }

    public E getFirst() {

        if (isEmpty()) {
            throw new NullPointerException("Empty list");
        }

        return head.getData();

    }

    public E getLast() {

        if (isEmpty()) {
            throw new NullPointerException("Empty list");
        }

        return last.getData();

    }

    public E get(Integer idx) {

        if (isEmpty()) {
            throw new NullPointerException("Empty list");
        }

        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Out of range");
        }

        if (idx == 0) {
            return getFirst();
        }

        if (idx == (size - 1)) {
            return getLast();
        }

        Node<E> current = getNode(idx);

        return current.getData();
    }

    private Node<E> getNode(Integer idx) {

        if (isEmpty()) {
            throw new NullPointerException("Empty list");
        }

        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Out of range");
        }

        if (idx == 0) {
            return head;
        }

        if (idx == (size - 1)) {
            return last;
        }

        Node<E> tmp = head;

        Integer count = 0;

        while (count < idx) {
            tmp = tmp.getNext();
            count++;
        }

        return tmp;

    }

    public String print() {

        StringBuilder sb = new StringBuilder();

        if (isEmpty()) {
            sb.append("Empty List");
            return sb.toString();
        }

        Node<E> aux = head;

        while (aux != null) {
            sb.append(aux.getData().toString()).append("\n");
            aux = aux.getNext();
        }

        return sb.toString();
    }

    public void update(E dato, Integer idx) {

        Node<E> tmp = getNode(idx);

        tmp.setData(dato);

    }

    public void clear() {
        head = null;
        size = 0;
        last = null;
    }

    public E removeFirst() {

        if (isEmpty()) {
            throw new NullPointerException("Empty List");
        }

        E element = head.getData();

        if (size == 0) {
            head = last = null;
            size--;
            return element;
        }

        head = head.getNext();

        size--;

        return element;

    }

    public E removeLast() {

        if (isEmpty()) {
            throw new NullPointerException("List Empty");
        }

        E element = last.getData();

        if (size == 1) {
            head = last = null;
            size--;
            return element;
        }

        var a = size - 2;

        Node<E> tmp = getNode(a);

        tmp.setNext(null);

        last = tmp;

        size--;

        return element;

    }

    public E remove(Integer idx) {

        if (isEmpty()) {
            throw new NullPointerException("Empty list");
        }

        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Out of range");
        }

        if (idx == 0) {
            return removeFirst();
        }

        if (idx == (size - 1)) {
            return removeLast();
        }


        Node<E> tmp = getNode(idx - 1);

        E element = tmp.getData();

        tmp.setNext(tmp.getNext().getNext());

        size--;
        
        return element;

    }
    
}