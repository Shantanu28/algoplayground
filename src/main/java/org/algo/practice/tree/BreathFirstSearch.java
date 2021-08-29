package org.algo.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Shantanu Singh on 7/26/21.
 */
public class BreathFirstSearch {

    private Node root;

    private List<String> breathFirstSearch() {
        List<String> array = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            array.add(node.getData());

            if (node.getLeftNode() != null) {
                queue.add(node.getLeftNode());
            }

            if (node.getRightNode() != null) {
                queue.add(node.getRightNode());
            }
        }

        return array;
    }

    public static void main(String[] args) {
        BreathFirstSearch tree = new BreathFirstSearch();
        tree.root = new Node("A");
        tree.root.setLeftNode(new Node("B"));
        tree.root.setRightNode(new Node("D"));
        tree.root
            .getLeftNode()
            .setLeftNode(new Node("E"));
        tree.root
            .getLeftNode()
            .setRightNode(new Node("F"));
        tree.root
            .getRightNode()
            .setLeftNode(new Node("G"));
        tree.root
            .getRightNode()
            .setRightNode(new Node("H"));
        tree.root
            .getLeftNode()
            .getRightNode()
            .setLeftNode(new Node("I"));
        tree.root
            .getLeftNode()
            .getRightNode()
            .setRightNode(new Node("J"));
        tree.root
            .getRightNode()
            .getLeftNode()
            .setRightNode(new Node("K"));

        System.out.println(
            "\nInorder traversal of binary tree is " + tree.breathFirstSearch());
    }
}
