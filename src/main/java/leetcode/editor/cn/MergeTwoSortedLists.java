//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2078 👎 0

package leetcode.editor.cn;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        // ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        // ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode listNode1 = new ListNode(-9, new ListNode(3, null));
        ListNode listNode2 = new ListNode(5, new ListNode(7, null));
        // ListNode listNode1 = new ListNode(2, null);
        // ListNode listNode2 = null;
        ListNode listNode = solution.mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode();
            ListNode cur = head;
            while (list1 != null && list2 != null) {
                // 链表1中节点的值大于链表2中节点的值，链表2的节点后移，链表1的节点保持不变
                if (list1.val > list2.val) {
                    cur.next = list2;
                    list2 = list2.next;
                } else {
                    // 链表2中节点的值大于链表1中节点的值，链表1的节点后移，链表2的节点保持不变
                    cur.next = list1;
                    list1 = list1.next;
                }
                cur = cur.next;
            }
            // 合并后 list1 和 list2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
            cur.next = list1 == null ? list2 : list1;
            return head.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}