项目类图

![](类图.png)


运行结果

![](result.png)


## 添加判断
要加到某个父节点下面到子节点，通过向节点链上寻找父节点是否存在引用相同
如果存在则不能添加（会产生循环引用）

## 删除判断
如果要溢出的子节点不存在于该xml文档中则无法删除


