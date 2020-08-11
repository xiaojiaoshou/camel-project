package com.ghx.camleproject.utils;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @name: ${name}
 * @description:
 * @type: JAVA
 * @since: 2020/8/11 18:40
 * @author: guohuixiang
 */
public class XMLParser {


    public static void main(String[] args) throws Throwable {
//        SAXReader reader = new SAXReader();
//        Document document = reader.read(new File("C:\\Users\\Administrator\\Desktop\\example.xml"));
//        Element rootElement = document.getRootElement();
//        Element request = rootElement.element("request");
//        Attribute attribute = request.attribute("id");
//        String data = (String) attribute.getData();
//        Element paramters = request.element("paramters");
//        Iterator<Element> elementIterator = paramters.elementIterator();
//        Map<String, String> map = new HashMap<>();
//        while (elementIterator.hasNext()) {
//            Element next = elementIterator.next();
//            String name = next.getName();
//            System.out.println(name);
//            System.out.println(next.getText());
//            map.put(name, next.getText());
//        }
//        System.out.println(data);
//        Element transform = rootElement.element("transform");
//        Element paramterModel = transform.element("paramterModel");
//        String text = paramterModel.getText();
//        System.out.println(text);
//        int i = text.indexOf("<");
//        String substring = text.substring(i);
//        System.out.println(substring);
//        Document paramterModelDocument = DocumentHelper.parseText(substring);
//        Element rootElement1 = paramterModelDocument.getRootElement();
//        String name1 = rootElement1.getName();
//        Element body = rootElement1.element("Body");
//        Element getOrders = body.element("GetOrders");
//        String name2 = getOrders.getName();
//        System.out.println(name1);
//        System.out.println(name2);
//        Element element = rootElement1.element("Body");
//        String name = element.getName();
//        System.out.println(name);
//        List<Node> nodes = element.selectNodes("descendant::*");
//        for (Node node : nodes) {
//            if (map.containsKey(node.getName())) {
//                String o = map.get(node.getName());
//                if (o == null || "".equals(o)) {
//                    Element parent = node.getParent();
//                    parent.remove(node);
//                } else {
//                    node.setText(o);
//                }
//            }
//        }
//        System.out.println(paramterModelDocument.asXML());
    }
}
