package xmlnodes;

import xmlnodes.visitor.XmlDomVisitor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caijiatao on 2018/6/1.
 */
public abstract class XmlNode implements BeVisitor {
    public static String lineBreakCharacter = "\n";
    public Map<String, String> properties = new HashMap<String, String>();
    private ParentNode parentNode;
    private String tagName;

    public XmlNode(ParentNode parentNode, String tagName) {
        this.parentNode = parentNode;
        if (parentNode != null) {
            parentNode.addChild(this);
        }
        this.tagName = tagName;
    }

    public XmlNode(ParentNode parentNode, String tagName, Map<String, String> properties) {
        this.parentNode = parentNode;
        if (parentNode != null) {
            parentNode.addChild(this);
        }
        this.tagName = tagName;
        this.properties = properties;
    }

    public void delete() {
        if (parentNode == null) {
            return;
        }
        parentNode.removeChild(this);
    }

    public void appendStartTag(StringBuilder builder) {
        builder.append("<").append(tagName);
        for (Map.Entry entry : properties.entrySet()) {
            builder.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        builder.append(">").append(lineBreakCharacter);
    }

    public void appendClosedTag(StringBuilder builder) {
        builder.append("</").append(tagName).append(">").append(lineBreakCharacter);
    }

    public void addProperty(String name, String value) {
        properties.put(name, value);
    }

    public void deleteProperty(String name) {
        properties.remove(name);
    }

    public String getProperty(String name) {
        return properties.get(name);
    }


    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
