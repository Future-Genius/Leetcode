
public class Solution1 {
    public static void main(String args[]) {

        /** This demonstrate the main idea of single Linked-list, namely a node with a pointer to the next node, and
         * the last node points to null

         ListNode l1=new ListNode(3);
         ListNode l2=new ListNode(4);
         ListNode l3=new ListNode(8);
         ListNode dummy=new ListNode(0);
         dummy.setNext(l1);
         l1.setNext(l2);
         l2.setNext(l3);
         while(dummy.getNext()!=null) {
         System.out.println(dummy.getNext().getVal());
         dummy=dummy.getNext();
         } */


        /**同志们注意，此处两个ListNode没有dummy head，两个list的第一个元素分别对应要相加的两个数的个位
         * 两个list的第二个元素分别对应要相加的两个数的十位，以此类推。
         * 因此该算法将把两个元素的个位相加，计算%10后的结果，存入要返回的链表，并计算进位数count
         * 然后把两个元素的十位相加，同时加上上一步算出来的进位数count，计算%10后的结果，存入要返回的链表，以此类推
         * 如果两个链表其中一个变为变为null,则加法过程实际上已经结束，只需要注意最后一个进位数count，然后copy未结束的链表的剩余数
         * 若两个链表均变为null，则算法结束，返回结果
         */
        /*ListNode c1 = new ListNode(9);
        ListNode c2 = new ListNode(8);
        ListNode c3 = new ListNode(7);
        ListNode c4 = new ListNode(6);
        ListNode c5 = new ListNode(5);
        ListNode c6 = new ListNode(4);
        ListNode c7 = new ListNode(3);
        c1.setNext(c2);
        c2.setNext(c3);
        c3.setNext(c4);
        c4.setNext(c5);
        c5.setNext(c6);
        c6.setNext(c7);
        printList(c1);

        ListNode d1=new ListNode(9);
        ListNode d2=new ListNode(9);
        ListNode d3=new ListNode(7);
        ListNode d4=new ListNode(9);
        ListNode d5=new ListNode(9);
        d1.setNext(d2);
        d2.setNext(d3);
        d3.setNext(d4);
        d4.setNext(d5);
        printList(addTwoNumbers(c1,d1));
         */
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) {
            return null;
        }
        else{
            int count=0;
            //俺就喜欢用dummy head
            ListNode dummy=new ListNode(0);
            ListNode result=dummy;
            while(l1!=null || l2!=null) {
                int l1_var=0;
                int l2_var=0;
                if(l1!=null) {
                    l1_var=l1.getVal();
                }
                if(l2!=null) {
                    l2_var=l2.getVal();
                }
                //到这一步为止理解起来应该没什么问题
                int result_var=l1_var+l2_var+count;
                int result_store=result_var%10;

                //注意不能更新这一位的值，否则会导致这一位指向Null，而无法更新下一位的值，这是dummy head的作用
                result.setNext(new ListNode(result_store));

                //注意这时候result存放的地址是下一个元素的地址，所以我们需要dummy head去保存第一个元素的地址
                result=result.getNext();

                //现在要更新count的值，以供下一位使用
                count=result_var/10;

                //进入下一位的计算
                if(l1!=null) {
                    l1=l1.getNext();
                }
                if(l2!=null) {
                    l2=l2.getNext();
                }
            }

            /**处理最后一位看是否要进位，i.e实际结果的位数大于两个相加的list中的任意一个
             */
            if(count > 0) {
                result.setNext(new ListNode(count));
            }
            dummy=dummy.getNext();
            return dummy;
        }
    }

    //Useful for debug, print the Linked-list without dummy head
    public static void printList(ListNode p) {
        assert p!=null;
        while(p.getNext()!=null) {
            System.out.print(p.getVal()+" ");
            p=p.getNext();
        }
        System.out.print(p.getVal());
        System.out.println();
    }
}
