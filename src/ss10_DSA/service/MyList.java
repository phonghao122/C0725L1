package ss10_DSA.service;

public class MyList<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;


    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public MyList(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        elements = new Object[capacity];
    }

    // Đảm bảo dung lượng mảng đủ chứa phần tử mới
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
    }

    // Thêm phần tử vào cuối danh sách
    public void add(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // Lấy phần tử tại vị trí index
    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    // Cập nhật phần tử tại vị trí index
    public void set(int index, E element) {
        checkIndex(index);
        elements[index] = element;
    }

    // Xóa phần tử tại vị trí index
    public void remove(int index) {
        checkIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // tránh memory leak
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Tìm vị trí phần tử đầu tiên có giá trị bằng o
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
}
