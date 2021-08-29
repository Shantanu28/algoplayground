package org.algo.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shantanu Singh on 7/26/21.
 */
public class DepthFirstSearch {

    static class Node {

        private String name;
        private List<Node> child = new ArrayList<>();

        public Node(final String name) {
            this.name = name;
        }

        public Node addChild(final String name) {
            Node childNode = new Node(name);
            this.child.add(childNode);

            return this;
        }

        public List<String> depthFirstSearchPreOrder(final List<String> array) {

            array.add(this.name);

            for (Node childNode : this.child) {
                childNode.depthFirstSearchPreOrder(array);
            }

            return array;
        }

    }

    public static void main(String[] args) {
        DepthFirstSearch.Node graph = new DepthFirstSearch.Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.child.get(0).addChild("E").addChild("F");
        graph.child.get(2).addChild("G").addChild("H");
        graph.child.get(0).child.get(1).addChild("I").addChild("J");
        graph.child.get(2).child.get(0).addChild("K");

        List<String> inputArray = new ArrayList<String>();

        List<String> strings = graph.depthFirstSearchPreOrder(inputArray);

        System.out.println(strings);

    }
}
