package xmlnodes;

import xmlnodes.visitor.XmlDomVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caijiatao on 2018/6/1.
 */
public class ParentNode extends XmlNode {

    public List<BeVisitor> childrenList = new ArrayList<BeVisitor>();

    public ParentNode(ParentNode parentNode, String tagName) {
        super(parentNode,tagName);
    }

    public void addChild(BeVisitor child){
        childrenList.add(child);
    }

    public void removeChild(BeVisitor child){
        childrenList.remove(child);
    }

    @Override
    public void beVisited(XmlDomVisitor xmlDomVisitor) {
        xmlDomVisitor.visitParentNode(this);
    }




}
