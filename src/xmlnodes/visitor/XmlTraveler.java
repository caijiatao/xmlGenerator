package xmlnodes.visitor;

import xmlnodes.BeVisitor;
import xmlnodes.ChildNode;
import xmlnodes.ParentNode;
import xmlnodes.XmlNode;

import java.util.ArrayList;

/**
 * Created by caijiatao on 2018/6/1.
 */
public class XmlTraveler implements XmlDomVisitor {
    int depth = 0;
    int nowId = 0;
    StringBuilder sb = new StringBuilder();
    ArrayList<XmlNode> arr = new ArrayList<XmlNode>();

    public StringBuilder travel(BeVisitor beVisitor){
        beVisitor.beVisited(this);
        depth = 0;
        nowId = 0;
        return sb;
    }

    public void delete(Integer id){
        arr.get(id).delete();
    }

    public BeVisitor get(Integer id){
        return arr.get(id);
    }


    @Override
    public void visitParentNode(ParentNode parentNode) {
        appendSplit(depth);
        sb.append(nowId++).append('.').append(parentNode.getTagName()).append("\n");
        arr.add(parentNode);
        depth++;
        for(BeVisitor xv:parentNode.childrenList){
            xv.beVisited(this);
        }
        depth--;
    }

    @Override
    public void visitChildNode(ChildNode childNode) {
        appendSplit(depth);
        sb.append(nowId++).append('.').append(childNode.getTagName()).append("\n");
        arr.add(childNode);
    }

    private void appendSplit(int num){
        for(int i = 0;i<num;i++){
            sb.append("\t");
        }
    }
}
