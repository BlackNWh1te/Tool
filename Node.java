package Tool;

public abstract class Node <T>{

    public Node(int priority) {
        this.priority = priority;
    }



    private final int priority;




    public int compareTo(Node comparableNode) {

            if (this.priority > comparableNode.getPriority()) return 1;

            else if (this.priority < comparableNode.getPriority()) return -1;

            else return 0;


    }

    public abstract T getValue();
    public abstract String toString();


    public int getPriority() {
        return this.priority;
    }
}
