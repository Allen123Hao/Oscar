package com.hao.xml.xpath;

import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

/**
 * <code>XPathParseNode</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-21
 * @version: 1.0
 */
@Slf4j
public class XPathParseNode {

    public static void parseNode() {
        try {
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
//            XPathExpression titleExpression1 = xPath.compile("/bookstore/book[1]/title");
//            XPathExpression titleExpression1 = xPath.compile("/bookstore/book[1]/title/text()");
//            XPathExpression titleExpression1 = xPath.compile("/bookstore/book[price>=30]/title");
            XPathExpression titleExpression1 = xPath.compile("//book[last()-1]");
            XPathExpression titleExpression2 = xPath.compile("//book[1]");

            XPathExpression titleExpression = xPath.compile("/bookstore/book/title");

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            docFactory.setNamespaceAware(true);
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//            String xmlPath = XPathParseNode.class.getClassLoader().getResource("").getPath();
            String xmlPath = XPathParseNode.class.getResource("").getPath();
            log.info("XML路径:{}",xmlPath);
            Document document = docBuilder.parse(xmlPath+"bookstore.xml");
            log.info("=======titleExpression1=======");
            //自动匹配第一个符合的
            Node node1 = (Node) titleExpression1.evaluate(document,XPathConstants.NODE);
            log.info("node1 name:{},node1 value:{},node1 text:{}",
                    node1.getNodeName(),node1.getNodeValue(),node1.getTextContent());
            log.info("=======titleExpression2=======");
            //自动匹配第一个符合的
            Node node2 = (Node) titleExpression2.evaluate(document,XPathConstants.NODE);
            log.info("node2 name:{},node2 value:{},node2 text:{}",
                    node2.getNodeName(),node2.getNodeValue(),node2.getTextContent());
            XPathExpression title_expr = xPath.compile("title");
            Node node2_title = (Node) title_expr.evaluate(node2,XPathConstants.NODE);
            log.info("node2_title name:{},node2_title value:{},node2_title text:{}",
                    node2_title.getNodeName(),node2_title.getNodeValue(),node2_title.getTextContent());
            log.info("=======titleExpression3=======");
            NodeList nodeList = (NodeList) titleExpression.evaluate(document, XPathConstants.NODESET);
            for(int i=0;i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                log.info("node name:"+node.getNodeName()+",node value:"+node.getNodeValue());
                Node child = node.getFirstChild();
                log.info("child node name:"+child.getNodeName()+",child node value:"+child.getNodeValue());
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        XPathParseNode xPathParseNode = new XPathParseNode();
//        xPathParseNode.parseNode();
        parseNode();
    }
}
