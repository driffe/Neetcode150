import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LinkedList {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if(list1.val > list2.val) {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
    }
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();

        while (head != null) {
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }

        return false;
    }
    public void reorderList(ListNode head) {
        List<ListNode> lst = new ArrayList<>();
        while(head != null) {
            lst.add(head);
            head = head.next;
        }
        int left = 0;
        int right = lst.size()-1;
        // 2468
        // 2->8->4->6
        // 0 1
        // 3 2
        while(left < right) {
            lst.get(left).next = lst.get(right);
            left++;
            if(left == right) {
                break;
            }
            lst.get(right).next = lst.get(left);
            right--;
        }
        lst.get(left).next = null;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int sum = 0;

        while (l1 != null || l2 != null) {

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            result.next = new ListNode(sum % 10);
            result = result.next;
            sum /= 10;
        }

        if(sum > 0) {
            result.next = new ListNode(sum);
        }

        return temp.next;
    }
    public int findDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }
}
