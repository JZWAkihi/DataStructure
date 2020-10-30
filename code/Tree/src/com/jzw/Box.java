package com.jzw;

import java.io.*;

public class Box implements Serializable {

    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void main(String[] args) {
        Box box = new Box();
        box.height = 50;
        box.width = 50;
        try {
            FileOutputStream stream = new FileOutputStream("tx.text");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);

            objectOutputStream.writeObject(box);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
