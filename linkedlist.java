public class linkedlist<T> implements MyList<T>{
        private static class n<T> {
            n<T> prev;
            n<T> next;
            T data;
            n(T data) {
                this.data = data;
            }
        }
        private int length = 0;
        private n<T> head, tail;

        public linkedlist() {
        }
        @Override
        public int size() {
            return length;
        }
        @Override
        public boolean contains(Object o) {
            for(n<T> i = head; i != null; i = i.next) {
                if (o.equals(i.data)) {
                    return true;
                }
            }
            return false;
        }
        public void add(T item) {
            n<T> newNode = new n<>(item);
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
            if(index == 0) {
                n<T> newNode = new n<>(item);
                newNode.next = head;
                head = newNode;
                length++;

                if (tail == null)
                    tail = head;

            }
            else if (index >= length) {
                n<T> newNode = new n<>(item);

                if(tail == null) {
                    head = tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = tail.next;
                }
                length++;
            }

            else {
                linkedlist.n<T> current = head;

                for(int i = 0; i < index - 1; i++) {
                    current = current.next;
                }

                n<T> temp = current.next;
                current.next = new n<T>(item);
                (current.next).next = temp;
                length++;
            }
        }
        @Override
        public boolean remove(T item) {
            if (this.head == null) {
                return false;
            } else {
                for(n<T> i = this.head; i != null; i = i.next) {
                    if (item.equals(i.data)) {
                        i.data = i.next.data;
                        i.next = i.next.next;
                    }
                }

                length--;
                return true;
            }
        }
        @Override
        public T remove(int index) {
            if (head == null) {
                return (T) null;
            } else if (index == 0) {
                return (T) head.next;
            } else {
                n<T> current = head;

                for(int counter = 0; counter < index - 1; counter++) {
                    current = current.next;
                }

                current.next = current.next.next;
                length--;
                return (T) head;
            }
        }
        @Override
        public void clear() {
            length = 0;
        }

        public T get(int index) {
            if (index >= length || index < 0) {
                throw new IndexOutOfBoundsException("index BOLSHE 0");
            }
            n<T> temp = head;

            while(index != 0) {
                temp = temp.next;
                index--;
            }

            return temp.data;
        }
        @Override
        public int indexOf(Object o) {
            int counter = 0;

            for(n<T> i = this.head; i != null; i = i.next) {
                if (o.equals(i.data)) {
                    return counter;
                }

                counter++;
            }

            return 0;
        }
        @Override
        public int lastIndexOf(Object o) {
            n<T> index = head;
            int counter = 0;
            int lastIndex = -1;
            for (n<T> i = head; i != null; i = i.next) {
                counter++;
                if (o.equals(i.data)) {
                    lastIndex = counter;
                }
            }
            return lastIndex - 1;
        }
        @Override
        public void sort() {
        }
    }

