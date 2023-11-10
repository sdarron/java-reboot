package ru.sberbank.edu;

import java.util.Arrays;
import java.util.Collection;


public class CustomArrayImpl<T> implements CustomArray<T> {

    private int size;
    private Object[] elementData;

    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayImpl() {
        this.elementData = new Object[ DEFAULT_CAPACITY ];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0) {
            int newCapacity = oldCapacity + minCapacity;
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    @Override
    public boolean add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("The argument must not be null");
        }
        try {
            if (size == elementData.length)
                elementData = grow(size + 1);
            elementData[size] = item;
            size = size + 1;
            return true;
        } catch (NullPointerException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean addAll(T[] items) {
        if (items == null) {
            throw new IllegalArgumentException("The argument must not be null");
        }
        Object[] a = items;
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew);
        System.arraycopy(a, 0, elementData, s, numNew);
        size = s + numNew;
        return true;
    }

    @Override
    public boolean addAll(Collection<T> items) {
        if (items == null) {
            throw new IllegalArgumentException("The argument must not be null");
        }
        Object[] a = items.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew);
        System.arraycopy(a, 0, elementData, s, numNew);
        size = s + numNew;
        return true;
    }

    public boolean addAll(CustomArrayImpl<T> items) {
        Object[] a = items.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew);
        System.arraycopy(a, 0, elementData, s, numNew);
        size = s + numNew;
        return true;
    }

    @Override
    public boolean addAll(int index, Object[] items) {
        if (items == null) {
            throw new IllegalArgumentException("The argument must not be null");
        }
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Object[] a = items;
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew);

        int numMoved = s - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index,
                    elementData, index + numNew,
                    numMoved);
        System.arraycopy(a, 0, elementData, index, numNew);
        size = s + numNew;
        return true;
    }

    @Override
    public T get(int index) {
        try {
            return (T) elementData[index];
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        } catch( NullPointerException e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public T set(int index, T item) {
       try {
           T oldValue = (T) elementData[index];
           elementData[index] = item;
           return oldValue;
       } catch (ArrayIndexOutOfBoundsException e){
           System.out.println(e);
       } catch (NullPointerException e){
           System.out.println(e);
       }
        return null;
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

    @Override
    public Object remove(int index) {
        try {
            final Object[] so = elementData;
            fastRemove(so, index);
            return so;
        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
        } catch (NullPointerException e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean remove(Object item) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        if (item == null) {
            for (; i < size; i++)
                if (es[i] == null) {
                    fastRemove(es, i);
                    return true;
                }
        } else {
            for (; i < size; i++)
                if (item.equals(es[i])) {
                    fastRemove(es, i);
                    return true;
                }
        }
        return false;
    }

    @Override
    public boolean contains(Object item) {
        return indexOf(item) >= 0;
    }

    int indexOfRange(Object item, int start, int end) {
        Object[] s = elementData;
        if (item == null) {
            for (int i = start; i < end; i++) {
                if (s[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (item.equals(s[i])) {
                    return i;
                }
            }
        }
        return -1;
    }


    @Override
    public int indexOf(Object item) {
        return indexOfRange(item, 0, size);
    }

    @Override
    public void ensureCapacity(int newElementsCount) {
        try {
            grow(newElementsCount);
        } catch (NullPointerException e){
            System.out.println(e);
        }
    }

    @Override
    public int getCapacity() {
        try {
            return elementData.length;
        } catch (NullPointerException e){
            System.out.println(e);
        }
        return -1;
    }

    @Override
    public void reverse() {
        for (int i = 0; i < size() / 2; i++) {
            Object temp = get(i);
            set(i, get(size() - i - 1));
            set(size() - i - 1, (T) temp);
        }
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
