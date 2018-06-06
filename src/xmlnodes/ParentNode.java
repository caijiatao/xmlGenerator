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

    public void addChild(XmlNode child){
        if(child == this){
            System.out.println("循环添加");
            return;
        }
        XmlNode parent = getParentNode();
        while(parent != null){
            if(parent == child){
                System.out.println("循环添加");
                return;
            }
            parent = parent.getParentNode();
        }
        childrenList.add(child);
    }

    public void removeChild(BeVisitor child){
        if(childrenList.contains(child)){
            childrenList.remove(child);
        }
        else{
            System.out.println("您要删除的元素不存在");
        }
    }

    @Override
    public void beVisited(XmlDomVisitor xmlDomVisitor) {
        xmlDomVisitor.visitParentNode(this);
    }




}
