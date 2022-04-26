import java.util.Arrays;

public class heap <T extends Comparable<T>> {
    private Object[] arr;
    private int capacity = 10;
    private int size = 0;

    private int left(int index) {
        return 2 * index;
    }

    private int right(int index) {
        return 2 * index + 1;
    }
    private T get (int index)
    {
        return (T) arr[index];
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    public void add(T e) {
        if (size == arr.length) {
            increaseCapacity();
        }

        arr[size] = e;
        size++;


    }
    public T removeRoot()
    {
        int k=0;
        if(size>0)
        {
            k++;
        }
        arr[0]=arr[size];
        return (T) arr[size];
    }
    public boolean remove(T item)
    {
        int k=0;
        if (size == capacity)
            increaseCapacity();
        for(int i=0;i<size;i++)
        {
            if(k==0) {
                if (item == arr[i]) {
                    if (size == capacity)
                        increaseCapacity();

                    for(int j=i;i<size-1;i++)
                    {
                        arr[i]=arr[i+1];
                    }
                    size--;


                    k++;
                    return false;

                }
            }
        }
        return false;
    }
    private void heapify()
    {
        for(int i=0;i<size;i++)
        {
            T lef =get(left(i));
            T ri=get(right(i));
            if(lef.compareTo(ri)>0)
            {
                lef=(T) arr[i];
            }
            else
            {
                ri=(T) arr[i];
            }
        }
    }

}



