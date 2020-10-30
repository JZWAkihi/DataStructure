package com;

import com.sun.jmx.remote.internal.ArrayQueue;

//定义结点
class Node{
    //结点值
    private int no;
    //结点名字
    private String name;
    //左节点
    private Node left;
    //右节点
    private Node right;

    //前序遍历
    public void preOrderNode(){
        //遍历
        System.out.println("结点名字是" + this.getName() + ",值是" + this.getNo());
        //查看它的左节点能否遍历
        if(this.left != null){
            this.left.preOrderNode();
        }
        //查看它的右节点能否遍历
        if(this.right != null){
            this.right.preOrderNode();
        }

    }
    //中序
    public void infixOrderNode(){
        if(this.left != null){
            this.left.infixOrderNode();
        }

        System.out.println("结点名字是" + this.getName() + ",值是" + this.getNo());

        if (this.right != null){
            this.right.infixOrderNode();
        }
    }
    //后序
    public void postOrderNode(){
        if (this.left != null){
            this.left.postOrderNode();
        }

        if (this.right != null){
            this.right.postOrderNode();
        }

        System.out.println("结点名字是" + this.getName() + ",值是" + this.getNo());
    }

    public Node() {
    }

    public Node(int no, String name, Node left, Node right) {
        this.no = no;
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class BinaryTree{
    //根结点
    private Node root;

    public BinaryTree() {
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    //前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrderNode();
        }else{
            System.out.println("二叉树为空");
        }
    }

    //中序遍历
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrderNode();
        }else{
            System.out.println("二叉树为空");
        }
    }

    //后序遍历
    public void postOrder(){
        if(this.root != null){
            this.root.postOrderNode();
        }else{
            System.out.println("二叉树为空");
        }
    }


    //层次遍历

    public void LevelOrder(){
        ArrayQueue<Node> queue = new ArrayQueue<Node>(10);

        queue.add(root);

        while(queue.size() != 0){
            Node node = queue.remove(0);
            System.out.println("结点名字是" + node.getName() + ",值是" + node.getNo());

            if(node.getLeft() != null){
                queue.add(node.getLeft());
            }
            if (node.getRight() != null){
                queue.add(node.getRight());
            }
        }
    }


}

public class BinaryTreeDemo {

    public static void main(String[] args) {

        //创建一颗树
        BinaryTree binaryTree = new BinaryTree();

        //定义结点
        Node node3 = new Node(3, "3", null, null);

        Node node1 = new Node(1, "1", node3, null);

        Node node2 = new Node(2, "2", null, null);

        Node root = new Node(0, "0", node1, node2);

        binaryTree.setRoot(root);

        binaryTree.preOrder();
        System.out.println("********************************************************");

        binaryTree.infixOrder();

        System.out.println("********************************************************");

        binaryTree.postOrder();

        System.out.println("********************************************************");

        binaryTree.LevelOrder();

    }

}
