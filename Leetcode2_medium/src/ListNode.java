public class ListNode {

    //encapsulate the variables
    private int val;
    private ListNode next=null;

    public  ListNode(int val) { this.val = val; }


      public void setNext(ListNode pnext) {
        this.next = pnext;
      }
      public void setVal(int value) {
        this.val = value;
      }


      public int getVal() {
        return val;
      }
      public ListNode getNext() {
        return next;
      }
}