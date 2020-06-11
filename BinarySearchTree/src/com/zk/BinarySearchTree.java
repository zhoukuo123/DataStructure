package com.zk;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E> {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BinarySearchTree() {
        this(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public void add(E element) {
        elementNotNullCheck(element);

        // 添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        // 添加的不是第一个节点
        // 找到要插入的元素的父节点parent
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { // 相等
                node.element = element; // 覆盖更合理
                return;
            }
        }

        // 看看插入到父节点的哪个位置
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
    }

//    /**
//     * 前序遍历
//     */
//    public void preorderTraversal() {
//        preorderTraversal(root);
//    }
//
//    private void preorderTraversal(Node<E> node) {
//        if (node == null) return;
//
//        System.out.println(node.element);
//        preorderTraversal(node.left);
//        preorderTraversal(node.right);
//    }
//
//    /**
//     * 中序遍历
//     */
//    public void inorderTraversal() {
//        inorderTraversal(root);
//    }
//
//    private void inorderTraversal(Node<E> node) {
//        if (node == null) return;
//
//        inorderTraversal(node.left);
//        System.out.println(node.element);
//        inorderTraversal(node.right);
//    }
//
//    /**
//     * 后序遍历
//     */
//    public void postorderTraversal() {
//        postorderTraversal(root);
//    }
//
//    public void postorderTraversal(Node<E> node) {
//        if (node == null) return;
//
//        postorderTraversal(node.left);
//        postorderTraversal(node.right);
//        System.out.println(node.element);
//    }
//
//    /**
//     * 层序遍历
//     */
//    public void levelOrderTraversal() {
//        if (root == null) return;
//
//        Queue<Node<E>> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            Node<E> node = queue.poll();
//            System.out.println(node.element);
//
//            if (node.left != null) {
//                queue.offer(node.left);
//            }
//
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
//        }
//    }

    public void preorder(Visitor<E> visitor) {
        if (visitor == null) return;
        preorder(root, visitor);
    }

    private void preorder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        visitor.visit(node.element);
        preorder(node.left, visitor);
        preorder(node.right, visitor);
    }

    public void inorder(Visitor<E> visitor) {
        if (visitor == null) return;
        inorder(root, visitor);
    }

    private void inorder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        inorder(node.left, visitor);
        if (visitor.stop) return;
        visitor.visit(node.element);
        inorder(node.right, visitor);
    }

    public void postorder(Visitor<E> visitor) {
        if (visitor == null) return;
        postorder(root, visitor);
    }

    private void postorder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return; // 递归调用的终止

        postorder(node.left, visitor);
        postorder(node.right, visitor);

        if (visitor.stop) return; // 防止left或者right是true
        visitor.stop = visitor.visit(node.element);
    }

    public void levelOrder(Visitor<E> visitor) {
        if (root == null || visitor == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (visitor.visit(node.element)) return;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public boolean isComplete() {
        if (root == null) return false;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) return false;

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) { // node.left == null && node.right != null
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else { // node.right == null
                leaf = true;
            }
        }

        return true;
    }

//    public boolean isComplete() {
//        if (root == null) return false;
//
//        Queue<Node<E>> queue = new LinkedList<>();
//        queue.offer(root);
//
//        boolean leaf = false;
//        while (!queue.isEmpty()) {
//            Node<E> node = queue.poll();
//            if (leaf && !node.isLeaf()) return false;
//
//            if (node.hasTwoChildren()) {
//                queue.offer(node.left);
//                queue.offer(node.right);
//            } else if (node.left == null && node.right != null) {
//                return false;
//            } else { // 后面遍历的节点都必须是叶子节点
//                leaf = true;
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//            }
//        }
//
//        return true;
//    }

    public int height() {
        if (root == null) return 0;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        int height = 0;
        // 存储着每一层的元素数量
        int levelSize = 1;

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (levelSize == 0) { // 这一层访问完了
                levelSize = queue.size(); // 下一层元素的数量
                height++;
            }
        }
        return height;
    }

    public int height2() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb, "");
        return sb.toString();
    }

    private void toString(Node<E> node, StringBuilder sb, String prefix) {
        if (node == null) return;

        sb.append(prefix).append(node.element).append("\n");
        toString(node.left, sb, prefix + "L---");
        toString(node.right, sb, prefix + "R---");
    }

    /**
     * @return 返回值等于0, 代表e1和e2相等;返回值大于0, 代表e1大于e2;返回值小于0, 代表e1小于e2
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }

        return ((Comparable<E>)e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    public static abstract class Visitor<E> {
        boolean stop;
        /**
         * 外界自定义访问逻辑
         * @param element 节点上的元素
         * @return true 代表停止访问
         */
        abstract boolean visit(E element);
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }
}
