import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

     MyARRlist <Integer> ar1= new MyARRlist<>();
     ar1.add(3);
        ar1.add(3 ,0 );

        ar1.add(4 ,1 );
        ar1.add(2 ,3 );

        ar1.add(1234);
        ar1.add(1334);
        ar1.add(134);
        System.out.println(ar1.indexOf(3));



        for(int i=0;i<ar1.size();i++)
            System.out.print(ar1.get(i)+"  ");

        ar1.remove(3);
        System.out.print("1)"+ar1.indexOf(4));

        System.out.println();
        for(int i=0;i<ar1.size();i++)
            System.out.print(ar1.get(i)+"  ");
        mylinkedlist<Integer> ar=new mylinkedlist<>();
        ar.add(123);
        ar.add(15);
        ar.add(145 ,0 );
        System.out.println(ar.size());
        for(int i=0;i<ar.size()-1;i++)
            System.out.print(ar.get(i)+"  ");
        queue<Integer> b=new queue<>();
        b.enqueue(12);
        System.out.println(b.peek());
        b.dequeue();
        b.enqueue(12);
        b.enqueue(4122);
        b.enqueue(11);
        b.enqueue(5);
        System.out.println(b.peek());
        System.out.println(b.empty()+" "+b.size());
        stack<Integer> c=new stack<>();
        System.out.println(c.empty());
        c.push(123);
        c.push(123);
        c.push(11);
        c.push(12412);
        System.out.println(c.pop());
        System.out.println(c.peek());


    }
}
