public class Test {

    public static void main(String[] args) {

        SingleLink head = SingleLink.createLink(10);

        SingleLink.iterLink(head);

        System.out.println(SingleLink.getLength(head));

        SingleLink.insertNode(head, 99, 5);

        SingleLink.iterLink(head);

        // System.out.println(SingleLink.queryNodeByVal(head, 0));
        // System.out.println(SingleLink.queryNodeByPos(head, 7));
        System.out.println(SingleLink.deleteNodeByVal(head, 99));

        // System.out.println(SingleLink.deleteNodeByPos(head, 6));
        SingleLink.reverseLink(head);

        SingleLink.iterLink(head);

        SingleLink.sortLink(head);

        SingleLink.iterLink(head);

        SingleLink node1 = new SingleLink();
        node1.val = 5;
        SingleLink node2 = new SingleLink(4, node1);
        SingleLink node3 = new SingleLink(3, node2);
        SingleLink node4 = new SingleLink(2, node3);
        SingleLink node5 = new SingleLink(1, node4);
        SingleLink headTest = new SingleLink();
        headTest.next = node5;
        node1.next = node5;

        System.out.println(SingleLink.checkCycle(headTest));
        System.out.println(SingleLink.checkCycle(head));
    }
}
