package assignment10;

import java.util.Scanner;
class Node<T>
{
    T data;
    Node<T> next;
    Node(){}
    Node(T data)
    {
        this.data=data;
        next=null;
    }
}
class SLIst<T>
{
    Node<T> head;
    SLIst(){
        head=null;
    }
    SLIst(T data){
        head=new Node<T>(data);
    }
    public SLIstIterator getIterator(){
        return new SLIstIterator<T>(head);
    }
}

class SLIstIterator<T> {
    Node<T> head;
    Node<T> current;
    int count;

    SLIstIterator(Node<T> head) {
        this.head = head;
    }

    public void insert(T data) {
        count++;
        if (head == null) {
            head = new Node<T>(data);
            current = head;
        } else {
            current.next = new Node<T>(data);
            current = current.next;
        }
        System.out.println("item inserted:" + data);
    }


    public void delete(T data) {
        if (head == null) {
            System.out.println("List is empty: Cannot forward delete opeartion of item" + data);
            return;
        }
        if (String.valueOf(head.data).equals(String.valueOf(data))) {
            head = head.next;
            count--;
            System.out.println("item deleted:" + data);
            return;
        }
        Node<T> previous = head;
        Node<T> temp = null;
        while (previous.next != null) {
            temp = previous.next;
            if (String.valueOf(temp.data).equals(String.valueOf(data))) {
                previous.next = temp.next;
                count--;
                System.out.println("item deleted: " + data);
                return;
            } else
                previous = previous.next;
        }
        System.out.println("item not found:" + data);
    }

    public void display() {
        if (head == null) {
            System.out.println("Empty list:[]");
            return;
        }
        Node<T> temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print(" " + temp.data + ",");
            temp = temp.next;
        }
        System.out.println("]");
    }

    public void size() {

        System.out.println("size is :" + count);
    }
}


class Generics{
    public static void main(String args[])
    {
        SLIst<Integer> st = new SLIst<Integer>();
        SLIstIterator iterator  = st.getIterator();

        Scanner scanner=new Scanner(System.in);
        int choice=1;
        while(true) {
            switch (choice) {
                case 1:
                    System.out.println("Enter data\n");
                    iterator.insert(scanner.nextInt());
                    break;

                case 2:
                    iterator.size();
                    break;
                case 3:
                    iterator.display();
                    break;

                case 4:System.out.println("Enter data to delete ");
                    iterator.delete(scanner.nextInt());break;
            }
            System.out.println(" \n  Select \n 1 .Insert \n 2. Size \n 3.Display 4.Delete \n");
            choice=scanner.nextInt();
        }


    }
}
