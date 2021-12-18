package com.sk.oopspractice;

public class intQueue {
    private int [] q;
    private int size;
    private int total;
    private int front;
    private int rear;

    public intQueue() {
        size  = 100;
        total = 0;
        front = 0;
        rear  = 0;
        q = new int[size];
    }

    public intQueue(int size) {
        this.size  = size;
        total = 0;
        front = 0;
        rear  = 0;
        q = new int[this.size];
    }
    
    public boolean enQueue(int item) {
        if(isFull()) return false;
        else {
            total++;
            q[rear] = item;
            rear = (rear+1) % size;
            return true;
        }
    }
    
    public int deQueue() {
        int item = q[front];
        total--;
        front = (front + 1)%size;
        return item;
    }
    
    public boolean isFull() {
        if(size == total) return true;
        else return false;
    }
    
    public void showAll() {
        int f = front;
        if(total != 0) {
            for (int i = 0; i < total; i++) {
                System.out.println(" " + q[f]);
                f = (f+1) % size;
            }
        }
    }
}
