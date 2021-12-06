//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2808 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("(("));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            // s.length() & 1 值为 1,则s的长度为奇数
            if (s.length() < 2 || (s.length() & 1) == 1) {
                return false;
            }
            Map<Character, Character> map = new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                // 入栈前判断栈顶是否与当前括号匹配
                char c = s.charAt(i);
                // 后括号
                if (map.containsKey(c)) {
                    // stack.isEmpty()，说明当前后括号，无前括号匹配
                    // stack.peek() != map.get(c)，说明栈顶与当前后括号不匹配
                    if (stack.isEmpty() || stack.peek() != map.get(c)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    // 前括号直接入栈
                    stack.push(c);
                }
            }
            // 若栈为空，则说明括号全匹配
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}