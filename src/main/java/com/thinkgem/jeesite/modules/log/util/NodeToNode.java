package com.thinkgem.jeesite.modules.log.util;

import com.ehome.sourch.pojo.Node;

import java.util.ArrayList;
import java.util.List;

public class NodeToNode {

    public Node nodeToNode(com.thinkgem.jeesite.modules.node.entity.Node node1){
        Node node = new Node();
        node.setIp(node1.getIp());
        node.setPort(Integer.valueOf(node1.getPort()));
        node.setUsername(node1.getUsername());
        node.setPassword(node1.getPassword());
        if(node1.getNodename1()!=null) {
            node.setNodename1(node1.getNodename1());
        }
        if(node1.getNodename2()!=null) {
            node.setNodename2(node1.getNodename2());
        }
        if(node1.getPath1() != null) {
            node.setPath1(node1.getPath1());
        }
        if(node1.getPath2() != null) {
            node.setPath2(node1.getPath2());
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return node;
    }
    public List<Node> nodesToNodes(List<com.thinkgem.jeesite.modules.node.entity.Node> nodes1){
        List<Node> nodes = new ArrayList<Node>();
        for(int i =0; i<nodes1.size(); i++){
            if (!"1".equals(nodes1.get(i).getDelFlag())) {
                nodes.add(this.nodeToNode(nodes1.get(i)));
            }
        }
        return nodes;
    }
}
