public class MyARRlist<T> implements MyList<T>  {
    private Object[] arr,arr1;
    private int length = 0;
    private int capacity = 10;


    public MyARRlist() {
        arr = new Object[capacity];
        arr1 = new Object[capacity];
    }




    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        arr[length++] = item;

    }

    @Override
    public void add(T item, int index) {
        if (length == capacity)
            increaseCapacity();
        for(int i=length;i>index;i--)
        {
            arr[i]=arr[i-1];
        }
        length++;
        arr[index]=item;

    }

    @Override
    public boolean remove(T item) {
        int k=0;
        if (length == capacity)
            increaseCapacity();
        for(int i=0;i<length;i++)
        {
            if(k==0) {
                if (item == arr[i]) {
                    removei(i);
                    k++;
                }
            }
        }
return false;
    }

    @Override
    public T removei(int index){
        if (length == capacity)
            increaseCapacity();

        for(int i=index;i<length-1;i++)
        {
            arr[i]=arr[i+1];
        }
        length--;



        return (T) arr[index];

    }

    @Override
    public void clear() {
        for(int i=0;i<length;i++)
        {
            removei(i);
        }
        removei(0);
    }


    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    public T get(int index) {
        return (T)arr[index];
    }

    @Override
    public int indexOf(Object o) {
        int k=0,b=0;
        for (int i = 0; i < length; i++) {
            if (k == 0) {
                if (arr[i] == o) {
                    k++;
                    b=i;
                }
            }
        }
        return b;
    }

    @Override
    public int lastIndexOf(Object o) {
        int a=0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == o) {
               a=i;
            }
        }
        return a;
    }

    @Override
    public void sort() {
        for(int i=0;i<length;i++)
        {
            if((arr[i]).hashCode()>(arr[i+1]).hashCode())
            {
                arr[i]=arr[i+1];
            }
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0;i<length;i++)
        {
            if(o==arr[i])
            {
                return true;
            }
        }
        return false;
    }

}
