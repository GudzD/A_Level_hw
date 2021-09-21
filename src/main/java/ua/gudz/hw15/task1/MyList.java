package ua.gudz.hw15.task1;
// Выполнить практику на слайде 20 (MyList)
// Реализовать двухсвязный список, при добавлении нового элемента он должен связаться с уже
// существующим последним элементом. Поиск с конца списка, если значение не найдено то возвращает null

class MyList<E> {
    static int size;
    private MyNode<E> head;
    private MyNode<E> tail;

    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        for (int i = 0; i < 100; i++) {
            list.addOnEnd(i);
        }
        System.out.println(list);
        System.out.println(list.getSize(size));
        System.out.println(list.getFromLast(101));
    }

    public void addOnEnd(E value) {
        MyNode<E> tmp = new MyNode<>(value);
        if (tail == null) {
            tail = tmp;
            head = tmp;
        } else {
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
        }
        size++;
    }

    public E getFromLast(E value) {
        MyNode<E> myNode = tail;
        for (int i = 0; i < size; i++) {
            if (myNode.value.equals(value)) {
                return myNode.value;
            }
            myNode = myNode.prev;
        }
        return null;
    }

    int getSize(int size) {
        return size;
    }

    @Override
    public String toString() {
        if (head == null) {
            return null;
        }
        MyNode<E> tmp = head;
        String tmpString = "[" + tmp.value.toString();
        while (tmp != tail) {
            tmp = tmp.next;
            tmpString = tmpString.concat(", " + tmp.value.toString());
        }
        tmpString = tmpString.concat("]");

        return tmpString;
    }
}
