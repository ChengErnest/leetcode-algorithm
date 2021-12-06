# LeetCode算法
## 编程环境
- IntelliJ IDEA 2021.3 (Community Edition)
- JDK 17

## IDEA配置
###LeetCode Editor插件配置

插件地址：https://plugins.jetbrains.com/plugin/12132-leetcode-editor

使用教程：https://github.com/shuzijun/leetcode-editor/blob/master/README_ZH.md

- 进入IDEA插件窗口，搜索LeetCode Editor并安装
- 配置LeetCode
  
  - 进入Configuration窗口: File -> settings->tools->leetcode plugin
  - 设置LeetCode用户名(LoginName)和密码(Password)
  - 启用自定义模板，勾选 Custom Tem...
  - 设置源代码文件生成路径(TempFilePath)
    > 这里以Maven项目为了，设置到java的源代码目录即可，
    > 例如：D:\code\leetcode\src\main\java
  - 设置源代码文件类名(Code FileName)
    ```
    $!velocityTool.camelCaseName(${question.titleSlug})
    ```
  
  - 设置源代码模板
    ```
    ${question.content}
    package leetcode.editor.cn;
    public class $!velocityTool.camelCaseName(${question.titleSlug}){
        public static void main(String[] args) {
            Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        }
        ${question.code}
    }
    ```
