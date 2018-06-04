package main;

import xmlnodes.ChildNode;
import xmlnodes.visitor.XmlGenerator;
import xmlnodes.ParentNode;
import xmlnodes.visitor.XmlTraveler;

public class Main {

    public static void main(String[] args) {
        ParentNode par = new ParentNode(null,"CategoryList");
        ParentNode par1 = new ParentNode(par,"Category");
        par1.addProperty("ID","01");
        new ChildNode(par1,"XML","MainCategory");
        new ChildNode(par1,"Description" , "This is a list my xml  articles.");
        new ChildNode(par1,"Active","true");
        XmlGenerator xmlGenerator = new XmlGenerator();
        StringBuilder sb = xmlGenerator.generate(par);

        System.out.println(sb.toString());

        //打印出层级和编号
        XmlTraveler xmlTraveler = new XmlTraveler();
        sb = xmlTraveler.travel(par);
        System.out.println(sb.toString());
    }
}
