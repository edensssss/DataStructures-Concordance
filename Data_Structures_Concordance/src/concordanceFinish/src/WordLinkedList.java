package concordanceFinish.src;
import java.util.List;

public class WordLinkedList {

    WordNode head = null, tail = null;

    class WordNode{
        int line;
        WordNode next;

        public WordNode(int line){
            this.line = line;
        }
    }

    //best case: O(1), worst case: O(n)
    public void addNode(int line){
        if(head==null){
            WordNode temp = new WordNode(line);
            head = temp;
            tail = temp;
        }else{
            if(search(line)==false) {
                tail.next = new WordNode(line);
                tail = tail.next;
            }
        }
    }

    // O(n)
    public boolean search(int target){
        WordNode temp = head;
        while(temp!=null){
            if(temp.line == target)
                return true;
            temp=temp.next; 
        }
        return false;
    }

    //O(n)
    public void printLinkedList(){
        WordNode temp = head;
        while(temp!=null){
            if(temp.next!=null)
                System.out.print(temp.line + " , ");
            else
                System.out.print(temp.line);
            temp = temp.next;
        }

    }
}
