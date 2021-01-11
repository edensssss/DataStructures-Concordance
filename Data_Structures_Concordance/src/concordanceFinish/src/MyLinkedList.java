package concordanceFinish.src;


class MyLinkedList {

    Node head = null, tail = null;

    //node - linkedlist
    class Node {
        String word;
        Node next;
        WordLinkedList wordInfo;

        Node() {
            word = "";
            wordInfo = new WordLinkedList();
        }

        Node(String w) {
            word = w;
            wordInfo = new WordLinkedList();
        } //constructor to create a new node
    }

    public MyLinkedList() {

    }

    //best case: O(1), worst case: O(n)
    public void addNode(String val) {
        Node temp = new Node(val);

        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            if (search(val) == false) {
                tail.next = temp;
                tail = temp;
            }
        }
    }

    //O(n)
    public boolean search(String val) {
        Node temp = head;
        while (temp != null) {
            if (temp.word != null)
                if (temp.word.equals(val))
                    return true;
            temp = temp.next;
        }
        return false;
    }

    //O(n)
    public void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.word + ": ");
            temp.wordInfo.printLinkedList();
            System.out.println();
            temp = temp.next;
        }
    }

    //O(n^2)
    public void sortList() {
        //Node current will point to head
        Node current = head, index = null;
        String temp;
        WordLinkedList wordTemp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                //Node index will point to node next to current
                index = current.next;

                while (index != null) {
                    //If current node's data is greater than index's node data, swap the data between them
                    if (current.word.compareTo(index.word) > 0) {
                        temp = current.word;
                        current.word = index.word;
                        index.word = temp;

                        wordTemp = current.wordInfo;
                        current.wordInfo = index.wordInfo;
                        index.wordInfo = wordTemp;


                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
}

