package xmlnodes;

import xmlnodes.visitor.XmlDomVisitor;

/**
 * Created by caijiatao on 2018/6/1.
 */
public class ChildNode extends XmlNode {

    private String content;

    public ChildNode(ParentNode parentNode, String tagName, String content) {
        super(parentNode,tagName);
        this.content = content;
    }

    public ChildNode(ParentNode parentNode, String tagName) {
        super(parentNode,tagName);
    }

    @Override
    public void beVisited(XmlDomVisitor xmlDomVisitor) {
        xmlDomVisitor.visitChildNode(this);
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
