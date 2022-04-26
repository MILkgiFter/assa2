public class stack<T>   {
    private n<T> head;
    private int length;
    private static class n<T>
    {
        private T value;
        private n <T> next;
        public n(T value)
        {
            this.value=value;
        }

    }
    public T peek()
    {
        return head.value;
    }
    public T pop()
    {
        T value = head.value;
        head=head.next;
        return value;
    }
    public void push(T item)
    {
        n<T> nd=new n<>(item);
        nd.next=head;
        head=nd;
        length++;
    }
    public boolean empty()
    {
        return head==null;
    }
    public int size()
    {
        return length;
    }


}
