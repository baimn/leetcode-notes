package p0002;

/**
 * Created by apple on 2021/8/23.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return v1(l1, l2);
    }

    public ListNode v1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode cr = result;
        int sum = 0;
        int accrual = 0;
        while (null != c1 || null != c2 || accrual == 1) {
            sum = 0;
            cr.next = new ListNode();
            cr = cr.next;
            if (null == c1 && null == c2 && accrual == 1) {
                cr.val = 1;
                break;
            }
            if (null != c1) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (null != c2) {
                sum += c2.val;
                c2 = c2.next;
            }

            sum += accrual;
            if (sum < 10) {
                cr.val = sum;
                accrual = 0;
            } else {
                cr.val = sum - 10;
                accrual = 1;
            }

        }
        return result.next;
    }
}