package recursao;

import java.util.Arrays;

import bst.BSTNode;


public class Recur<T> {

    private Node head;
    
    public int somaA(int[] a, int i){
        int result = 0;
        if(i != a.length){
            result = a[i] + somaA(a, i+1);
        }
        return result;
    }

    public int maxInArray(int a[], int i){
        int result = 0;
        if(i != a.length){
            result = this.maxInArray(a, i+1);
            if(result < a[i]){
                result = a[i];
            }
        }
        return result;
    }

    public boolean contains(int[] a, int i, int x){
        boolean result = false;
        if(i != a.length && i >= 0 && x < a.length){
            if(a[i] == x){
                result = true;
            }
            else{
                result = this.contains(a, i+1, x);
            }
        }
        return result;
    }

    public int cout(int[] a, int i, int x){
        int result = 0;
        if(i != a.length && i >= 0){
            if(a[i] == x){
                result = 1 + this.cout(a, i+1, x);
            }
            else{
                result = this.cout(a, i+1, x);
            }
        }
        return result;
    }

    public void inversion(int[] a, int i, int j){
        if(i < j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            this.inversion(a, i+1, j-1);
        }
    }

//------------------------------------------------------------------------------------------------------------------------
   
     public Integer sumLinkedList(Node node){
        Integer result = 0;
        if(node!= null){
                result = node.getData() + this.sumLinkedList(node.getNext());
        }
        return result; 
    }


    public Integer sumEvenLinkedList(Node node){
        Integer result = 0;
        if(node!= null){
            if(node.getData() % 2 == 0){
                result = node.getData() + this.sumLinkedList(node.getNext());
            }
            else{
                result = this.sumLinkedList(node.getNext());
            }
        }
        return result;
    }

    public Integer searchLast(Node node){
        Integer result = 0;
        if(node != null){
            if(node.getNext() == null){
                result = node.getData();
            }
            else{
                result = this.searchLast(node.getNext());
            }
        }
        return result;
    }

    public Integer CountNodes(Node node){
        Integer result = 0;
        if(node != null){
            result = 1 + this.CountNodes(node.getNext());
        }
        return result;
    }

    public Integer search(Node node, int x){
        Integer result = 0;
        if(node != null){
            if(node.getData() == x){
                result = node.getData();
            }
            else{
                result = this.search(node.getNext(), x);
            }
        }
        return result;
    }
    

    public void listInversion(){
        this.listInversionRec(getHead(), null);
    }

    public void listInversionRec(Node cur, Node prev){
        if(cur != null){
            Node next = cur.next;
            cur.setNext(prev);
            this.listInversionRec(next, cur);
        }
        else{
            setHead(prev);
        }
    }
//-----------------------------------------------------------------------------------------------

    public Integer sumNodes(BSTNode node){
        return this.sumNodesRec(node);
    }

    private Integer sumNodesRec(BSTNode node){
        Integer result = 0;
        if(node != null){
                result = (Integer) node.getData() + this.sumNodesRec((BSTNode) node.getLeft()) + this.sumNodesRec((BSTNode) node.getRight());
        }
        return result;
    }

    public int height(BSTNode node){
        return this.heightRec(node);
    }

    public int heightRec(BSTNode node){
        int result = -1;
        if(node != null){
            result = 1 + Math.max(this.height((BSTNode) node.getLeft()), this.height((BSTNode) node.getRight()));
        }
        return result;
    }

    public int countLeaf(BSTNode node){
        return this.countLeafRec(node);
    }

    public int countLeafRec(BSTNode node){
        int result = 0;
        if(node != null && !node.isEmpty()){
            if((node.getLeft() == null || node.getLeft().isEmpty()) && (node.getRight() == null || node.getRight().isEmpty())){
                result = 1;
            }
            else{
                result = this.countLeafRec((BSTNode) node.getLeft()) + this.countLeafRec((BSTNode)node.getRight());
            }
        }
        return result;
    }

    public Node<T> bstLinkedList(BSTNode node){
        return this.bstLinkedListRec(node, null);
    }

    private Node<T> bstLinkedListRec(BSTNode node, Node next) {
        Node<T> result = next;

        if(node != null && !node.isEmpty()){
            Node<T> right = this.bstLinkedListRec((BSTNode) node.getRight(), next);
            Node<T> cur = new Node<>((Integer) node.getData());
            cur.setNext(right);
            result = bstLinkedListRec((BSTNode) node.getLeft(), cur);
        }
        return result;
    }

      public static void main(String[] args) {
        BSTNode<Integer> root = new BSTNode.Builder<Integer>().data(10).build();
        BSTNode<Integer> n5 = new BSTNode.Builder<Integer>().data(5).build();
        BSTNode<Integer> n15 = new BSTNode.Builder<Integer>().data(15).build();
        BSTNode<Integer> n2 = new BSTNode.Builder<Integer>().data(2).build();
        BSTNode<Integer> n7 = new BSTNode.Builder<Integer>().data(7).build();
        BSTNode<Integer> n20 = new BSTNode.Builder<Integer>().data(20).build();

        root.setLeft(n5);
        root.setRight(n15);
        n5.setLeft(n2);
        n5.setRight(n7);
        n15.setRight(n20);

        Recur r = new Recur<>();
        Node<Integer> head = r.bstLinkedList(root);

        // imprimir lista recursivamente
        printList(head);
    }

    private static <T> void printList(Node<T> node) {
        if(node == null) {
            System.out.println("null");
            return;
        }
        System.out.print(node.data + " -> ");
        printList(node.next);
    }

    public Node getHead(){
        return this.head;
    }

    public void setHead(Node head){
        this.head = head;
    }
}
