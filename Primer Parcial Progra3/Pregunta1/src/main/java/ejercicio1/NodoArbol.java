/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.Stack;

/**
 *
 * @author Wclinares
 */
public class NodoArbol {

    private static class Node {

        private int data;
        private Node left, right;

        public Node(int value) {
            data = value;
            left = right = null;
        }

    }
    private Node root;

    public NodoArbol() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return null == root;
    }

    public int size() {
        Node current = root;
        int size = 0;
        Stack<Node> stack = new Stack<Node>();
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                size++;
                current = stack.pop();
                current = current.right;
            }
        }
        return size;
    }

    public void clear() {
        root = null;
    }

}
