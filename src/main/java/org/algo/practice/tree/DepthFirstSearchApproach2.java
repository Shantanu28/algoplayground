package org.algo.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Shantanu Singh on 7/26/21.
 */
@Setter
@Getter
public class DepthFirstSearchApproach2 {

    private Node root;

    public DepthFirstSearchApproach2() {
        this.root = null;
    }

    public List<String> preOrder(final List<String> array, final Node node) {

        if (node == null)
            return array;

        array.add(node.getData());

        preOrder(array, node.getLeftNode());

        preOrder(array, node.getRightNode());

        return array;
    }

    public List<String> postOrder(final List<String> array, final Node node) {

        if (node == null)
            return array;

        postOrder(array, node.getLeftNode());

        postOrder(array, node.getRightNode());

        array.add(node.getData());

        return array;
    }

    public List<String> inOrder(final List<String> array, final Node node) {

        if (node == null)
            return array;

        inOrder(array, node.getLeftNode());

        array.add(node.getData());

        inOrder(array, node.getRightNode());

        return array;
    }

    public List<String> inOrderWithoutRecursion() {

        List<String> array = new ArrayList<>();

        if (this.root == null)
            return array;

        Stack<Node> stack = new Stack<>();
        Node curr = this.root;

        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.getLeftNode();
            }

            curr = stack.pop();
            array.add(curr.getData());

            curr = curr.getRightNode();
        }

        return array;
    }

    public void morris() {
        Node curr, prev;

        if (this.root == null)
            return;

        curr = this.root;
        while (curr != null) {
            if (curr.getLeftNode() == null) {
                System.out.print(curr.getData() + " ");
                curr = curr.getRightNode();
            } else {
                /* Find the previous (prev) of curr */
                prev = curr.getLeftNode();
                while (prev.getRightNode() != null && prev.getRightNode() != curr)
                    prev = prev.getRightNode();

                /* Make curr as right child of its prev */
                if (prev.getRightNode() == null) {
                    prev.setRightNode(curr);
                    curr = curr.getLeftNode();
                }

                /* fix the right child of prev*/

                else {
                    prev.setRightNode(null);
                    System.out.print(curr.getData() + " ");
                    curr = curr.getRightNode();
                }

            }

        }
    }

    public static void main(String[] args) {
        DepthFirstSearchApproach2 tree = new DepthFirstSearchApproach2();
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
            "Preorder traversal of binary tree is " + tree.preOrder(new ArrayList<>(), tree.getRoot()));

        System.out.println(
            "\nPostorder traversal of binary tree is " + tree.postOrder(new ArrayList<>(), tree.getRoot()));

        System.out.println(
            "\nInorder traversal of binary tree is " + tree.inOrder(new ArrayList<>(), tree.getRoot()));

        System.out.println(
            "\nInorder traversal of binary tree is " + tree.inOrderWithoutRecursion());

        tree.morris();

    }
}
