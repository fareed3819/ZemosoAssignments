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

class SLIstIterator<T>
{
    Node<T> head;
    Node<T> current;
    int count;
    SLIstIterator(Node<T> head){
        this.head=head;
    }

    public void insert(T data){
        count++;
        if (head==null){
            head=new Node<T>(data);
            current=head;
        }
        else{
            current.next=new Node<T>(data);
            current=current.next;
        }
        System.out.println("item inserted:"+data);
    }


    public void delete(T data){
        if (head==null){
            System.out.println("List is empty: Cannot forward delete opeartion of item"+data);
            return;
        }
        if(String.valueOf(head.data).equals(String.valueOf(data))){
            head=head.next;
            count--;
            System.out.println("item deleted:"+data);
            return;
        }
        Node<T> pre=head;
        Node<T> temp=null;
        while(pre.next!=null){
            temp=pre.next;
            if(  String.valueOf(temp.data).equals(String.valueOf(data)) ) {
                pre.next=temp.next;
                count--;
                System.out.println("item deleted:"+data);
                return;
            }
            else
                pre=pre.next;
        }
        System.out.println("item not found:"+data);
    }

    public void display(){
        if(head==null){
            System.out.println("Empty list:[]");
            return;
        }
        Node<T> temp=head;
        System.out.print("[");
        while(temp!=null){
            System.out.print(" "+temp.data+",");
            temp=temp.next;
        }
        System.out.println("]");
    }
    public void size(){
        System.out.println("size is :"+count);
    }
}

class Generics{
    public static void main(String args[])
    {
        SLIst<Integer> st = new SLIst<Integer>();
        SLIstIterator it  = st.getIterator();
        it.insert(10);
        it.insert(20);
        it.insert(30);
        it.insert(40);
        it.insert(50);
        it.insert(60);
        it.size();
        it.display();
        it.delete(60);
        it.delete(30);
        it.delete(90);
        it.delete(10);
        it.size();
        it.display();
        SLIst<String> st1 = new SLIst<String>();
        SLIstIterator it1 = st1.getIterator();
        it1.insert("rahul");
        it1.insert("sreetej");
        it1.insert("kotha");
        it1.insert("jayesh");
        it1.insert("griet");
        it1.insert("cse");
        it1.size();
        it1.display();
        it1.delete("sreetej");
        it1.delete("griet");
        it1.delete("hyderabad");
        it1.size();
        it1.display();
    }
}