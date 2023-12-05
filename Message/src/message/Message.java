/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package message;

import java.util.Scanner;


/**
 *
 * @author admin
 */
class QueueClass<T> {
    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int maxSize;

    public QueueClass(int maxSize) {
        this.front = null;
        this.rear = null;
        this.maxSize = maxSize;
    }

    public void enqueue(T item) {
        if (size() < maxSize) {
            Node newNode = new Node(item);
            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        } else {
            System.out.println("Queue is full. Cannot enqueue more items.");
        }
    }

    public T dequeue() {
        if (!isEmpty()) {
            T data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return data;
        }
        return null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        int count = 0;
        Node current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

// Lớp Stack không cần import
class ClassStack<T> {
    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public ClassStack() {
        this.top = null;
    }

    public void push(T item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (!isEmpty()) {
            T data = top.data;
            top = top.next;
            return data;
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return top.data;
        }
        return null;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
public class Message {

    public static void main(String[] args) {
         int maxSize = 8; // maximum size
        QueueClass<String> queueClass = new QueueClass<>(maxSize);
        ClassStack<String> classStack = new ClassStack<>();
        Scanner scanner = new Scanner(System.in);
        // Input messages from the keyboard
        System.out.println("Enter messages (press 'exit' stop the program):");
        String userInput;
        while (!(userInput = scanner.nextLine()).equals("exit")) {
           if (userInput.length() <= 225) {
                queueClass.enqueue(userInput);
            } else {
                System.out.println("Message exceeds 225 characters limit."
                        + " Please enter a shorter message.");
            }
        }
        while (!queueClass.isEmpty()) {
            String message = queueClass.dequeue();
            if (message != null) {
                classStack.push(message);
            }
        }
        while (!classStack.isEmpty()) {
            System.out.println("message is sended to stack: " + classStack.pop());
        }

        scanner.close();
    }
   }

