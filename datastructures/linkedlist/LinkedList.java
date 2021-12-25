package datastructures.linkedlist;

public class LinkedList {
    
    private static Node head;

    public static void print(Node headNode){
        Node ptr = headNode;
        if(ptr == null){
            System.out.println("NULL");
            return;
        }

        while(ptr.getNext() != null){
            System.out.print(ptr.getData().toString() + " -> ");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData().toString() + " -> NULL\n");
    }

    public static Node middleNode(Node headNode) { 
        Node ptrS = headNode, ptrF = headNode;

        if(headNode != null){
            while(ptrF != null && ptrF.getNext() != null) {
                ptrS = ptrS.getNext();
                ptrF = ptrF.getNext().getNext();
            }

            return ptrS;
        }

        return null;
    }

    // returns the head of the new list;
    public static Node reverseList(Node headNode){
        Node ptrA, ptrB, ptrC = null;
        
        if(headNode == null || headNode.getNext() == null){
            return headNode;
        }

        ptrA = headNode;
        ptrB = headNode.getNext();
        ptrC = headNode.getNext().getNext();
        ptrA.setNext(null);

        while(ptrC != null){
            ptrB.setNext(ptrA);
            
            ptrA = ptrB;
            ptrB = ptrC;
            ptrC = ptrC.getNext();
            //ptrC.print();
        }

        ptrB.setNext(ptrA);

        return ptrB;
    }

    // returns index of node that has been deleted 
    // -1 if nothing is deleted
    public static int delete(Integer val) {
        if(head == null)
            return -1;
        else{
            Node ptr = head;
            if(ptr.getData() == val){
                head = ptr.getNext();
                return 0  ;
            }
            int index = 0;
            while(ptr.getNext() != null) {
                if(ptr.getNext().getData() == val){
                    break;
                }
                ptr = ptr.getNext();
                index++;
            }
            if(ptr.getNext() == null){
                if(ptr.getData() == val){
                    if(head == ptr)
                        head = null;
                    return index;
                }
                return -1;
            }else{
                if(ptr.getNext().getNext() != null)
                    ptr.setNext(ptr.getNext().getNext());
                else
                    ptr.setNext(null);
                return index+1;
            }
        }
    }

    // returns index of newly inserted node
    public static int insert(Node newNode){
        if(head == null){
            head = newNode;
            return 0;
        }else{
            Node ptr  = head;
            int index = 0;
            while(ptr.getNext() != null){
                index++;
                ptr = ptr.getNext();
            }
            index++;
            ptr.setNext(newNode);

            return index;
        }
    }

    public static void main(String[] args){
        //Node n6 = new Node(6);
        //Node n5 = new Node(5);
        //Node n4 = new Node(4);
        //Node n3 = new Node(3);
        //Node n2 = new Node(2);
        Node n1 = new Node(1);

        insert(n1);
        //insert(n2);
        //insert(n3);
        //insert(n4);
        //insert(n5);
        //insert(n6);

        /* 
        print(LinkedList.head);
        System.out.println(delete(1));
        print(LinkedList.head);
        System.out.println(delete(2));
        print(LinkedList.head);
        System.out.println(delete(3));
        print(LinkedList.head);
        System.out.println(delete(4));
        print(LinkedList.head);
        System.out.println(delete(5));
        print(LinkedList.head);
        */

        /*
        print(LinkedList.head);
        LinkedList.head = reverseList(LinkedList.head);
        print(LinkedList.head);
        */

        print(LinkedList.head);
        Node mid = middleNode(LinkedList.head);
        if(mid != null){
            mid.print();
        }

    }
    
}
