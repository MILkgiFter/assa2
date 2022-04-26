public  class queue<T> {
    private myqueue<T> head;
    private myqueue<T> tail;
    int length=0;
    private static class myqueue<T>
    {
        private final T value;
        private myqueue<T> next;

        public myqueue(T value)
        {
            this.value=value;
        }

    }
    public void enqueue(T i)
    {
        myqueue<T> q=new myqueue<>(i);
                if(head==null)
                {
                    head=q;

                }
                if(tail!=null)
                {
                    tail.next=q;
                }
                tail=q;
                length++;
    }
    public void dequeue()
    {
        head=head.next;
        if(head==null)
        {
            tail=null;
        }
    }
    public T peek()
    {
        return head.value;
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
