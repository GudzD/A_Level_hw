package ua.gudz.hw16.task3;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

class ListIterator implements Iterator<String> {
    List<String> list;
    int pos = 0;

    public ListIterator(List<String> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        while (pos < list.size()) {
            if (list.get(pos).toLowerCase(Locale.ROOT).startsWith("a"))
                return true;
            pos++;
        }
        return false;
    }

    @Override
    public String next() {
        if (hasNext())
            return list.get(pos++);
        throw new NoSuchElementException();
    }
}