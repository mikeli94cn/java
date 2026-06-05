class ListNode{
    int val;
    ListNode next;

    ListNode(){
    }
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val, ListNode next){
        this.val=val;
        this.next=next;
    }
}


class LeetCode2{
    public static void main(String[] args){
        LeetCode2 test=new LeetCode2();
        ListNode tmp=new ListNode(4);
        ListNode l1=new ListNode(2,tmp);

        tmp=new ListNode(6);
        ListNode l2=new ListNode(5,tmp);

        ListNode l3=test.addTwoNumbers(l1,l2);
        for(int i=1;i<=3;i++){
            System.out.println(l3.val);
            l3=l3.next;
        }

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int a=0;
        int b=0;
        int e=0;
        boolean l1Flag=false;
        boolean l2Flag=false;
        ListNode l3Prev=new ListNode();
        ListNode curNode=l3Prev;

        while(true){
            if(l1Flag && l2Flag && e==0){
                break;
            }else{
                if(l1Flag){
                    a=0;
                }else{
                    a=l1.val;
                }

                if(l2Flag){
                    b=0;
                }else{
                    b=l2.val;
                }

                int tmp=a+b+e;

                if(tmp>=10){
                    tmp=tmp-10;
                    e=1;
                }
                else{
                    e=0;
                }

                ListNode newNode=new ListNode(tmp);
                curNode.next=newNode;
                curNode=curNode.next;

                if(l1.next!=null){
                    l1=l1.next;
                }else{
                    l1Flag=true;
                }

                if(l2.next!=null){
                    l2=l2.next;
                }else{
                    l2Flag=true;
                }
            }
        }
        return l3Prev.next;
    }
}
