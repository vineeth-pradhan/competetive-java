// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
package competetive;
import com.list.*;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list2 == null) { return list1; }
        if(list1 == null) { return list2; }
        ListNode head = new ListNode();
        ListNode temp;
        head.next = (list1.val <= list2.val) ? list1 : list2;
        if(list1.val > list2.val) {
            temp = list1;
            list1 = list2;
            list2 = temp;
        }
        while(list1.next != null && list2.next != null) {
            if(list1.next.val >= list2.val){
                temp = list1.next;
                list1.next = list2;
                list1 = list1.next;
                list2 = temp;
            }
            else { list1 = list1.next; }
        }
        if(list1.next == null) {
            list1.next = list2;
        }
        else {
            while(list1.next != null && list1.next.val <= list2.val) {
                list1 = list1.next;
            }
            temp = list1.next;
            list1.next = list2;
            list2.next = temp;
        }
        return head.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list1, list2;
        int[] inputArray1 = { -10,-10,-9,-4,1,6,6 };
        int[] inputArray2 = { -7 };
        try {
            list1 = new ListNode(inputArray1[0]);
            list1.constructLinkedList(inputArray1, list1, 0);
            System.out.println(ListNode.printLinkedList(list1));
        }
        catch(ArrayIndexOutOfBoundsException e) {
            list1 = null;
        }
        try {
            list2 = new ListNode(inputArray2[0]);
            list2.constructLinkedList(inputArray2, list2, 0);
            System.out.println(ListNode.printLinkedList(list2));
        }
        catch(ArrayIndexOutOfBoundsException e){
            list2 = null;
        }
        System.out.println(ListNode.printLinkedList(solution.mergeTwoLists(list1, list2)));
    }
}
