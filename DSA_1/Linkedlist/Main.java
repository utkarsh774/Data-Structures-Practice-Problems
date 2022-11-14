public class Main{
    
    public static class Node{
         int data;
        Node next;
    }

    public static class LinkedList{
        Node head;
        Node tail;
        int size;
//=============================== ADD=========================================
        void addLast(int val){
            Node node = new Node();
            node.data = val;
            if(this.size == 0){
                head = tail = node;
            }
            else{
                tail.next = node;
                tail = node;
            }
            size++;
        }

        void addFirst(int val){
            Node node = new Node();
            node.data = val;
            if(this.size == 0){
                head = tail = node;
            }
            else{
              node.next = head;
              head = node;
            }
            size++;
        }
        void addAt(int idx,int val){
            if(idx<0||idx>this.size){
                System.out.println("Invalid Index");
            }
            if(idx == 0){
                addFirst(val);
            }
            else if(idx == this.size){
                addLast(val);
            }
            else{
                Node temp = this.head;
                for(int i = 1;i<idx;i++){
                    temp = temp.next;
                }
                Node node = new Node();
                node.data = val;
                node.next = temp.next;
                temp.next = node;
                size++;
            }
        }
//==========================DISPLAY=======================================
        void display(){
            Node temp = this.head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        }
//============================GET===========================================
      int  getFirst(){
            if(this.size == 0){
                System.out.print("List is empty");
                return -1;
            }
            else{
                return this.head.data;
            }

      }
      
      int getLast(){
          if(this.size == 0){
            System.out.print("List is empty")
            return -1;
          }
          else{
            return this.tail.data;
        }
      }
      int getAt(int idx){
          if(this.size==0){
            System.out.print("List is empty");
            return -1;
          }
          if(idx<0||idx>=this.size){
            System.out.print("Invalid indices");
            return -1; 
          }
          else{
              Node temp = head;
              for(int i = 0;i<idx;i++){
                  temp = temp.next;
              }
              return temp.data;
          }
      }
      //=========================REMOVE====================================
      void removeFirst(){
          if(size == 0){
              System.out.print("Invalid call");
          }
          if(size == 1){
              head = tail = null;
              size = 0;
          }
          else{
              head = head.next;
              size--;
          }
      }
      void removeLast(){
          if(size == 1){
            head = tail = null;
          }
          else{
              Node temp = head;
              for(int i = 1;i<size-1;i++){
                temp = temp.next;
              }
              tail = temp;
              tail.next = null;
          }
      }
    } 



    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.addFirst(10);
        l1.addFirst(20);
        l1.addFirst(30);
        l1.addFirst(40);
        l1.addFirst(50);
        l1.display();
    }
}
