package xmlnodes.visitor;

import xmlnodes.ChildNode;
import xmlnodes.ParentNode;

/**
 * 访问者
 * Created by caijiatao on 2018/6/1.
 */
public interface XmlDomVisitor {
    //访问父节点
    void visitParentNode(ParentNode parentNode);
    //访问子节点
    void visitChildNode(ChildNode childNode);
}
