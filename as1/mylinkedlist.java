public class mylinkedlist <T> implements MyList<T> {
    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public mylinkedlist() {}

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            MyNode <T> av=head;
            for (MyNode<T> i = head; i != null; i = i.next)
            {
                if((i.next)==(null))
                {
                    i.prev.data=i.data;
                }
                else i.data=i.next.data;
            }
            while (index!=0)
            {
                av=av.next;
                index--;
            }
            av.data=item;
            length++;
        }
    }

        @Override
        public boolean remove (T item){
            if (head.data == null) {

            }
            if (head.data == item) {
                head = head.next;
            }
            MyNode<T> temp = head;
            while (temp.next != null) {
                if (temp.next.data == item) {
                    temp.next = temp.next.next;
                }
                temp = temp.next;
            }


            return false;
        }

        @Override
        public T removei ( int index){
            if (head == null) {
                return (T) null;
            } else if (index == 0) {
                return (T) head.next;
            } else {
                mylinkedlist.MyNode<T> current = head;

                for (int counter = 0; counter < index - 1; counter++) {
                    current = current.next;
                }

                current.next = current.next.next;
                length--;
                return (T) head;
            }

        }

        @Override
        public void clear () {
            length = 0;
        }

        public T get ( int index){
            if (index >= length || index < 0)
                throw new IndexOutOfBoundsException("index should be positive and less than size");

            MyNode<T> temp = head;

            while (index != 0) {
                temp = temp.next;
                index--;
            }

            return temp.data;
        }

        @Override
        public int indexOf (Object o){
            MyNode<T> temp = head;
            while (temp.next != null) {
                if (o.equals(temp)) {
                    return length;
                }
                temp = temp.next;

            }
            return 0;
        }

        @Override
        public int lastIndexOf (Object o){
            int a = 0;
            MyNode<T> temp = tail;
            while (temp.next != null) {
                if (a == 0) {
                    if (o.equals(temp)) {
                        a++;
                        return length;

                    }
                    temp = temp.prev;
                }

            }
            return 0;
        }

        @Override
        public void sort () {

        }

        public int size () {
            return length;
        }

        @Override
        public boolean contains (Object o){

            for (MyNode<T> i = head; i != null; i = i.next) {
                if (o.equals(i.data)) {
                    return true;
                }
            }
            return false;
        }
    }

