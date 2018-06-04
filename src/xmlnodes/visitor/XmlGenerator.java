package xmlnodes.visitor;

import xmlnodes.BeVisitor;
import xmlnodes.ChildNode;
import xmlnodes.ParentNode;
import xmlnodes.XmlNode;

import java.util.Map;

/**
 * Created by caijiatao on 2018/6/1.
 */
public class XmlGenerator implements XmlDomVisitor {
    StringBuilder sb = new StringBuilder();

    int depth = 0;
    private String charset = "UTF-8";
    private String version = "1.0";

    //生成被xml
    public StringBuilder generate(BeVisitor beVisitor){
        sb.append("<?xml version=\"").append(version)
                .append("\" charset=\"").append(charset).append("\" ?>\n");
        beVisitor.beVisited(this);
        return sb;
    }

    @Override
    public void visitParentNode(ParentNode parentNode) {
        appendTab(depth);
        parentNode.appendStartTag(sb);
        depth++;
        for(BeVisitor xv:parentNode.childrenList){
            xv.beVisited(this);
        }
        depth--;
        appendTab(depth);
        parentNode.appendClosedTag(sb);
    }

    @Override
    public void visitChildNode(ChildNode childNode) {

        if(childNode.getContent() != null){
            appendTab(depth);
            childNode.appendStartTag(sb);
            appendTab(depth+1);
            sb.append(childNode.getContent()).append(XmlNode.lineBreakCharacter);
            appendTab(depth);
            childNode.appendClosedTag(sb);
        }else{
            appendTab(depth);
            sb.append("<").append(childNode.getTagName());
            for(Map.Entry entry : childNode.properties.entrySet()){
                sb.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
            }
            sb.append(" />").append(XmlNode.lineBreakCharacter);
        }

    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void appendTab(int num){
        for (int i = 0; i < num; i++) {
            sb.append("\t");
        }
    }
}
