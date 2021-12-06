//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 👍 1704 👎 0

package leetcode.editor.cn;
public class PalindromeNumber{
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(101));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        // 负数不存在回文数
        if (x < 0) {
            return false;
        }
        // 获取最大除数位，用于获取首位数字
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x != 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            // 去除已校验的首位和末尾数字
            x = x % div / 10;
            // 除数减少两位
            div /= 100;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}