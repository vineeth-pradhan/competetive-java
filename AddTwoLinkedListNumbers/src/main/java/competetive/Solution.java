package competetive;
import competetive.LinkedList;
import competetive.ListNode;

class Solution {
  public static void main(String[] args) {
    LinkedList l1 = new LinkedList(new int[] { 1,1,1 });
    LinkedList l2 = new LinkedList(new int[] { 9,9 });

    l1.printList();
    l2.printList();
    ListNode result = addTwoNumbers(l1.headNode.next, l2.headNode.next);
    LinkedList l3 = new LinkedList(result);
    l3.printList();
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode currentNode = new ListNode();
    ListNode l3 = new ListNode(0, currentNode);
    int carryOver = 0;
    while(l1 != null || l2 != null) {
      if(l1 != null && l2 != null){
        currentNode.val = (l1.val + l2.val + carryOver) % 10;
        carryOver = (l1.val + l2.val + carryOver) / 10;
        l1 = l1.next;
        l2 = l2.next;
        if(l1 != null && l2 != null) {
          currentNode.next = new ListNode();
          currentNode = currentNode.next;
          continue;
        }
        else if(carryOver != 0){ currentNode.next = new ListNode(carryOver); }
      }
      else if(l1 != null && l2 == null) {
        currentNode.next = new ListNode();
        currentNode = currentNode.next;
        currentNode.val = (l1.val + carryOver) % 10;
        carryOver = (l1.val + carryOver) / 10;
        if(carryOver == 0 && l1.next != null){
          currentNode.next = l1.next;
          break;
        }
        else if(carryOver != 0 && l1.next == null){ currentNode.next = new ListNode(carryOver); }
        l1 = l1.next;
      }
      else if(l2 != null && l1 == null) {
        currentNode.next = new ListNode();
        currentNode = currentNode.next;
        currentNode.val = (l2.val + carryOver) % 10;
        carryOver = (l2.val + carryOver) / 10;
        if(carryOver == 0 && l2.next != null){
          currentNode.next = l2.next;
          break;
        }
        else if(carryOver != 0 && l2.next == null){ currentNode.next = new ListNode(carryOver); }
        l2 = l2.next;
      }
    }
    return l3.next;
  }
}
