import java.util.ArrayList;

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

    LinkedListCTCI deleteMiddleNode(LinkedListCTCI head){
        if (head == null)
            return null;
        LinkedListCTCI current = head;
        LinkedListCTCI currentTh = head;
        int contador = 0;
        int contadorFinal = contador /2;
        while (currentTh != null){
            currentTh = currentTh.next;
            contador += 1;
        }
        for (int j = 0; j<contadorFinal; j++ ){
            current = current.next;
        }
        return current;
    }

    boolean deleteNode(LinkedListCTCI nodoABorrar){
        LinkedListCTCI current = this;
        while (current.next != null){
            if (current.next == nodoABorrar){
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return true;
    }

    boolean deleteMiddleNode2 (LinkedListCTCI nodeABorrar){
        if (nodeABorrar == null || nodeABorrar.next == null){
            return false;
        }
        LinkedListCTCI current = nodeABorrar;
        current.data = current.next.data;
        current.next = current.next.next;
        return true;
    }

    LinkedListCTCI partitionWith2List (LinkedListCTCI head , int valuePartition){
        LinkedListCTCI lowersHead = null;
        LinkedListCTCI lowersTail = null;
        LinkedListCTCI uppersHead = null;
        LinkedListCTCI uppersTail = null;
        if (head == null){
            return null;
        }
        while (head != null){
            LinkedListCTCI next = head.next;
            head.next = null;
            if (head.data < valuePartition){
                if (lowersHead == null){
                    lowersHead = head;
                    lowersTail = lowersHead;
                }else{
                    lowersTail.next = head;
                    lowersTail = head;
                }
            }else{
                if (uppersHead == null){
                    uppersHead = head;
                    uppersTail = uppersHead;
                }else{
                    uppersTail.next = head;
                    uppersTail = head;
                }
            }
            head = next;
        }
        if (lowersHead == null){
            return uppersHead;
        }
        lowersTail.next = uppersHead;
        return lowersHead;
    }


   LinkedListCTCI sumLists (LinkedListCTCI head1, LinkedListCTCI head2){
        LinkedListCTCI newList = null ;
        LinkedListCTCI head01next = head1.next;
        LinkedListCTCI head02next = head2.next;
        while (head1 != null || head2!= null){
            int acarreo = 0;
            int value = head1.data + head2.data;
            if (value > 9){
                int suma = value % 10;
                acarreo = value / 10;
                if (newList == null){
                    newList = new LinkedListCTCI(suma);
                }else{
                    LinkedListCTCI current = new LinkedListCTCI(suma);
                    newList.next = current;
                    newList = current;
                }
            }else{
                int nuevovalue = value + acarreo;
                acarreo = nuevovalue / 10;
                if (newList == null){
                    newList = new LinkedListCTCI(nuevovalue);
                }else{
                    LinkedListCTCI current = new LinkedListCTCI(nuevovalue);
                    newList.next = current;
                    newList = current;
                }
            }
            head1 = head01next;
            head2 = head02next;
        }
        return newList;
   }

}
