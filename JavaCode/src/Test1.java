import java.util.Comparator;
import java.util.PriorityQueue;

public class Test1 {

  class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 class Solution{
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null) {
            return null;
        }
        ListNode head=null;
        ListNode index=null;
        PriorityQueue<ListNode> plists=new PriorityQueue<>(new PriorityQueueComparator());
        for (ListNode list : lists) {
            plists.add(list);
        }
        while (!plists.isEmpty()) {
            ListNode node = plists.poll();
            if (index==null) {
                head=node;
                index=node;
            }else{
                index.next=node;
                index=node;
            }
        }
        return head;
    }
 
    
}
static class PriorityQueueComparator implements Comparator<ListNode>{
    @Override
    public int compare(ListNode o1, ListNode o2) {
        return o1.val-o2.val;
    }

}
}