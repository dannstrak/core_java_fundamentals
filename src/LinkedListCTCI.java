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
        LinkedListCTCI resultHead = null;
        LinkedListCTCI resultTail = null;

        int acarreo = 0;
        while(head1 != null || head2 != null || acarreo > 0){
            int valor1 = (head1 != null) ? head1.data : 0;
            int valor2 = (head2 != null) ? head2.data : 0;

            int suma = valor1 + valor2 + acarreo;
            acarreo = suma / 10;
            int digitoFinal = suma % 10;

            LinkedListCTCI nuevoNodo = new LinkedListCTCI(digitoFinal);
            if (resultHead == null){
                resultHead = nuevoNodo;
                resultTail = resultTail;
            }else{
                resultTail.next = nuevoNodo;
                resultTail = nuevoNodo;
            }
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }
        return resultHead;
   }
}
