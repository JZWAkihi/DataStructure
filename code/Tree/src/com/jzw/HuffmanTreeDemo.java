package com.jzw;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//先创建Node结点
class Node implements Comparable<Node>{
    private int no;
    private String name;

    private Node left;
    private Node right;

    public Node() {
    }

    public Node(int no) {
        this.no = no;
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

    //前序遍历
    public void perOrder(){
        System.out.println(this.no );

        if(this.left != null){
            this.left.perOrder();
        }

        if (this.right != null){
            this.right.perOrder();
        }

    }

    //前序遍历
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null){
            this.right.infixOrder();
        }

    }

    //后序遍历
    public void postOrder(){
        if(this.left != null){
            this.left.postOrder();
        }


        if (this.right != null){
            this.right.postOrder();
        }

        System.out.println(this);
    }

    //用于比较
    @Override
    public int compareTo(Node o) {
        return this.no - o.no;
    }
}

public class HuffmanTreeDemo {

    //创建赫夫曼树的方法
    public static Node creatHuffmanTree(int arr[]) {
        //第一步，将每个arr中的元素构成一个Node
        //并将Node放入ArrayList
        List<Node> nodes = new ArrayList<Node>();

        for (int i = 0; i < arr.length; i++) {
            nodes.add(new Node(arr[i]));
        }


        //开始循环
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);


            //得到权值最小的两个根结点
            Node leftnode = nodes.get(0);
            Node rightnode = nodes.get(1);
            //创造父亲结点
            Node parent = new Node(leftnode.getNo()+rightnode.getNo());
            parent.setLeft(leftnode);
            parent.setRight(rightnode);

            //移除已合并的结点
            nodes.remove(leftnode);
            nodes.remove(rightnode);

            //将父结点添加进序列中
            nodes.add(parent);

        }

        //最后只剩下一个结点，为最优二叉树的根结点
        return nodes.get(0);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{13,7,8,3,29,6,1};

        Node node = creatHuffmanTree(arr);

        node.perOrder();
    }
}
