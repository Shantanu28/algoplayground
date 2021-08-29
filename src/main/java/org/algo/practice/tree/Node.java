package org.algo.practice.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Shantanu Singh on 7/26/21.
 */
@Getter
@Setter
public class Node {

    private String data;

    private Node leftNode;

    private Node rightNode;

    public Node(final String item) {
        this.data = item;
        leftNode = rightNode = null;
    }
}
