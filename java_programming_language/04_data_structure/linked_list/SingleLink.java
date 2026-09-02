
public class SingleLink {

    int val;
    SingleLink next;

    public SingleLink(int val, SingleLink next) {
        this.val = val;
        this.next = next;
    }

    public SingleLink() {
    }

    /*
    0.create link
    1.iter link
    2.get length of link
    3.insert node
    4.queryNode(ByValue,ByPosition)
    5.deleteNode(ByValue,ByPosition)
    6.reverse
    7.sort
     */
    
    static SingleLink createLink(int n){
        SingleLink next=new SingleLink();
        for(int i=n;i>=1;i--){
            SingleLink node=new SingleLink(i,next);
            next=node;
        }
        SingleLink head=new SingleLink();
        head.next=next;
        return head;
    }
    
    static void iterLink(SingleLink head) {
        while (head.next != null) {
            head = head.next;
            if (head.val != 0) {
                System.out.print(head.val);
                if (head.next.val != 0) {
                    System.out.print("->");
                }
            }
        }
        System.out.print("\n");
    }

    static int getLength(SingleLink head) {
        int length = 0;
        while (head.next != null) {
            head = head.next;
            if (head.val != 0) {
                length++;
            }
        }
        return length;
    }

    static void insertNode(SingleLink head, int nodeVal, int nodePos) {
        int length = getLength(head);
        if (nodePos < 1 || nodePos > length + 1) {
            System.err.println("Error, insert position beyond linked list scale");
        } else {
            for (int i = 1; i <= nodePos - 1; i++) {
                head = head.next;
            }

            SingleLink node = new SingleLink();
            node.val = nodeVal;
            node.next = head.next;
            head.next = node;

        }
    }

    static int queryNodeByVal(SingleLink head, int val) {
        head = head.next;
        int pos = 1;
        while (head.val != val && head.next != null) {
            head = head.next;
            pos++;
        }
        if (head.next != null) {
            return pos;
        } else {
            return -1;
        }
    }

    static int queryNodeByPos(SingleLink head, int pos) {
        int length = getLength(head);
        if (pos < 1 || pos > length) {
            System.out.println("Error, position beyond linked list scale");
            return -1;
        } else {
            for (int i = 0; i <= pos - 1; i++) {
                head = head.next;
            }
            return head.val;
        }
    }

    static int deleteNodeByVal(SingleLink head, int val) {
        SingleLink prev = head;
        head = head.next;
        while (head.val != val && head.next != null) {
            prev = head;
            head = head.next;
        }
        if (head.next != null) {
            prev.next = head.next;
            return 1;
        } else {
            System.out.println("Error, didnt find the value, cannot delete");
            return -1;
        }
    }

    static int deleteNodeByPos(SingleLink head, int pos) {
        SingleLink prev = head;
        int length = getLength(head);

        if (pos < 1 || pos > length) {
            System.out.println("Error, position beyond linked list scale");
            return -1;
        } else {
            for (int i = 1; i <= pos; i++) {
                prev = head;
                head = head.next;
            }
            prev.next = head.next;
            return 0;
        }
    }

    static void reverseLink(SingleLink head) {
        SingleLink originHead = head;
        int length = getLength(head);
        SingleLink[] arr = new SingleLink[length];

        head = head.next;
        for (int i = 1; i <= length; i++) {
            arr[i - 1] = head;
            head = head.next;
        }

        head = originHead;
        for (int i = length; i >= 1; i--) {
            head.next = arr[i - 1];
            head = head.next;
        }
        head.next = new SingleLink();
    }

    static void sortLink(SingleLink head) {
        SingleLink originHead = head;
        int length = getLength(head);
        SingleLink[] arr = new SingleLink[length];
        head = head.next;
        for (int i = 0; i <= length - 1; i++) {
            int j = i;
            for (; j >= 1 && arr[j - 1].val > head.val; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = head;
            head = head.next;
        }
        head = originHead;
        for (int i = 1; i <= length; i++) {
            head.next = arr[i - 1];
            head = head.next;
        }
        head.next = new SingleLink();
    }
}
