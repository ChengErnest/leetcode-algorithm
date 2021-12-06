//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 1904 👎 0

package leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] arr = {"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            // 假设第一个字符串为最长公共前缀
            String base = strs[0];
            // 循环后续字符串
            for (int i = 1; i < strs.length; i++) {
                // 获取最长公共前缀
                int j = 0;
                for (; j < base.length() && j < strs[i].length(); j++) {
                    // 当字符不匹配时退出
                    if (base.charAt(j) != strs[i].charAt(j)) {
                        break;
                    }
                }
                // 修改当前最长公共前缀
                base = base.substring(0, j);
                // 当最长公共前缀位空时，没必要继续循环
                if ("".equals(base)) {
                    return base;
                }
            }
            return base;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}