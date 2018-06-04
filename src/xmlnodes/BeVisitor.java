package xmlnodes;

import xmlnodes.visitor.XmlDomVisitor;

/**
 * @author caijiatao
 * @date 2018/6/4 下午12:07
 */
public interface BeVisitor {
    void beVisited(XmlDomVisitor xmlDomVisitor);
}
