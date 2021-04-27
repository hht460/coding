package org.hthu.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] ins = in.nextLine().split("|");
            Node nodes = null;
            for (String command : ins) {
                nodes = new Command(command).execute(nodes);
            }
            while (nodes != null) {
                System.out.println(nodes.content);
                nodes = nodes.next;
            }
        }
    }
}


class Node {

    Node(String content) {
        this.content = content;
    }

    String content;
    Node next;
}

class Command {
    int lineno;

    String action;

    String contend;

    List<String> ADD_ACTIONS = Arrays.asList("a", "i", "r");
    List<String> ALL_ACTIONS = Arrays.asList("a", "i", "r", "d");

    Command(String command) {
        String[] strList = command.split(" ");
        this.lineno = Integer.parseInt(strList[0]);
        this.action = strList[1];
        if (ADD_ACTIONS.contains(this.action)) {
            this.contend = strList[2];
        }
    }

    Node execute(Node nodes) {
        if (!this.ALL_ACTIONS.contains(this.action)) {
            return null;
        }
        if (nodes == null && (this.lineno != 1 || !this.action.equals("i"))) {
            return null;
        }

        if (nodes == null) {
            return new Node(this.contend);
        }
        switch (this.action) {
            case "a":
                return append(nodes);
            case "r":
                return replace(nodes);
            case "i":
                return insert(nodes);
            default:
                return delete(nodes);
        }
    }

    Node append(Node nodes) {
        int start = 0;
        Node head = nodes;
        while (start < this.lineno - 1) {
            nodes = nodes.next;
            start++;
        }
        Node next = nodes.next;
        nodes.next = new Node(this.contend);
        nodes.next = next;
        return head;
    }

    Node insert(Node nodes) {
        if (this.lineno == 1) {
            Node newHead = new Node(this.contend);
            newHead.next = nodes;
            return newHead;
        }
        int start = 0;
        Node head = nodes;
        while (start < this.lineno - 2) {
            nodes = nodes.next;
            start++;
        }
        Node next = nodes.next;
        nodes.next = new Node(this.contend);
        nodes.next = next;
        return head;
    }

    Node replace(Node nodes) {
        int start = 0;
        Node head = nodes;
        while (start < this.lineno - 1) {
            nodes = nodes.next;
            start++;
        }
        nodes.content = this.contend;
        return head;
    }

    Node delete(Node nodes) {
        return nodes;
    }
}
