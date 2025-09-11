package recursao;

import java.util.Arrays;


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
                result = (Integer) node.getData() + this.sumNodesRec(node.getLeft()) + this.sumNodesRec(node.getRight());
        }
        return result;
    }

    public int height(BSTNode node){
        return this.heightRec(node);
    }

    public int heightRec(BSTNode node){
        int result = -1;
        if(node != null){
            result = 1 + Math.max(this.height(node.getLeft()), this.height(node.getRight()));
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
                result = this.countLeafRec(node.getLeft()) + this.countLeafRec(node.getRight());
            }
        }
        return result;
    }

    


    public static void main(String[] args) {
        int[] a = new int[]{
            1, 2, 3, 4, 4
        };
        Recur r = new Recur();

        // System.out.println(r.somaA(a, 0));
        // System.out.println(r.maxInArray(a, 0));
        // System.out.println(r.contains(a, 0, 2));
        // System.out.println(r.cout(a, 0, 4));
        // r.inversion(a, 0, a.length-1);
        // System.out.println(Arrays.toString(a));

        Node head = new Node(1); 
        head.next = new Node(2); 
        head.next.next = new Node(3); 
        head.next.next.next = new Node(12);

        // System.out.println(r.sumLinkedList(head)); 
        // System.out.println(r.searchLast(head)); 
        // System.out.println(r.CountNodes(head));
        // System.out.println(r.search(head, 3));
        // r.setHead(head);
        // r.listInversion();

        BSTNode<Integer> root = new BSTNode<>(10);
        BSTNode<Integer> n4 = new BSTNode<>(4);
        BSTNode<Integer> n15 = new BSTNode<>(15);
        BSTNode<Integer> n2 = new BSTNode<>(2);
        BSTNode<Integer> n7 = new BSTNode<>(7);

        root.setLeft(n4);
        root.setRight(n15);
        n4.setLeft(n2);
        n4.setRight(n7);

        //System.out.println(r.sumNodes(root));
        System.out.println(r.height(root));
        System.out.println(r.countLeaf(root));
        
    }

    public Node getHead(){
        return this.head;
    }

    public void setHead(Node head){
        this.head = head;
    }
}
