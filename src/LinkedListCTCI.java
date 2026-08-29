public class LinkedListCTCI {
    int data;
    LinkedListCTCI next  = null;

    public LinkedListCTCI(int data){
        this.data = data;
    }

    void appendToTail(int data){
        LinkedListCTCI end = new LinkedListCTCI(data);
        LinkedListCTCI current = this;
        while (current.next != null){
            current = current.next;
        }
        current.next = end;
    }

    LinkedListCTCI appendToHead (int data){
        LinkedListCTCI newLink = new LinkedListCTCI(data);
        newLink.next = this;
        return  newLink;
    }


    LinkedListCTCI deleteNode (LinkedListCTCI head, int data){
        LinkedListCTCI current = head;
        if (current.data == data){
            return head.next;
        }
        while(current.next != null){
            if (current.next.data == data){
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }
        return head;
    }


    LinkedListCTCI deleteRepetedNodes (LinkedListCTCI head){
        if (head == null)
            return null;
        LinkedListCTCI current = head;
        while (current.next != null){
            LinkedListCTCI aboveCurrent = current;
            while (aboveCurrent.next != null){
                if (current.data == aboveCurrent.next.data){
                    aboveCurrent.next = aboveCurrent.next.next;
                }else{
                    aboveCurrent = aboveCurrent.next;
                }
            }
            current = current.next;
        }
        return head;
    }


    LinkedListCTCI findTheKThNode (LinkedListCTCI head, int kth){
        if (head == null){
            return null;
        }
        LinkedListCTCI current = head;
        LinkedListCTCI currentkth = head;
        for (int i = 0; i<kth; i++){
            if (currentkth == null)
                return null;
            currentkth = currentkth.next;
        }
        while (currentkth != null){
            current = current.next;
            currentkth = currentkth.next;
        }
        return current;
    }
}
