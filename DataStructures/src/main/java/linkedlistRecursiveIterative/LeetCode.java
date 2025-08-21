package linkedlistRecursiveIterative;

public class LeetCode<T extends Comparable<T>> {

    public void deleteMiddle(SingleLinkedListNode<T> node) {
        if (node != null && node.getNext() != null) {
            int size = 0;
            SingleLinkedListNode<T> aux = node;
            while (aux != null && !aux.isNil()) {
                size++;
                aux = aux.getNext();
            }
    
            int position = size / 2;
    
            aux = node;
            int index = 0;
    
            while (aux != null && !aux.isNil()) {
                if (index == position - 1 && aux.getNext() != null) {
                    aux.setNext(aux.getNext().getNext());
                }
                aux = aux.getNext();
                index++;
            }
        }
    }

    public boolean isPalindrome(SingleLinkedListNode<T> node){
        SingleLinkedListNode<T> first = node;
        SingleLinkedListNode<T> second = node.getNext();

        while(first != null && first.getNext() != null){
            second = second.getNext();
            first = first.getNext().getNext();
        }

        SingleLinkedListNode<T> previous = null;
        SingleLinkedListNode<T> current = second;

        while (current != null) {
            SingleLinkedListNode<T> temp = current.next;
            current.setNext(previous);
            previous = current;
            current = temp;
        }

        SingleLinkedListNode<T> firstHalf = node;
        SingleLinkedListNode<T> seconfHalf = previous;

        boolean result = false;
        while(seconfHalf != null){
            if(seconfHalf.getData().equals(firstHalf.getData())){
                result = true;
            }
            seconfHalf = seconfHalf.getNext();
            firstHalf = firstHalf.getNext();
        }
        return result;
    }

    public void removeElements(SingleLinkedListNode<T> head, T val) {
        if (head != null && val != null) {
            while (!head.isNil() && head.getData().compareTo(val) == 0) {
                head.setData(head.getNext().getData());
                head.setNext(head.getNext().getNext());
            }
    
            SingleLinkedListNode<T> aux = head;
            while (!aux.isNil() && aux.getNext() != null && !aux.getNext().isNil()) {
                if (aux.getNext().getData().compareTo(val) == 0) {
                    aux.setNext(aux.getNext().getNext());
                } else {
                    aux = aux.getNext();
                }
            }
        }
    }

    


    public static void main(String[] args) {
    // Criar a lista: 1 -> 2 -> 3 -> 4 -> 5
    SingleLinkedListNode<Integer> head = new SingleLinkedListNode<>(1);
    SingleLinkedListNode<Integer> n2 = new SingleLinkedListNode<>(2);
    SingleLinkedListNode<Integer> n3 = new SingleLinkedListNode<>(3);
    SingleLinkedListNode<Integer> n4 = new SingleLinkedListNode<>(4);
    SingleLinkedListNode<Integer> n5 = new SingleLinkedListNode<>(5);

    head.setNext(n2);
    n2.setNext(n3);
    n3.setNext(n4);
    n4.setNext(n5);

    // Imprimir antes
    System.out.print("Antes: ");
    printList(head);
    LeetCode l = new LeetCode<>();
    // Remover o nó do meio
    l.removeElements(head, 5);

    // Imprimir depois
    System.out.print("Depois: ");
    printList(head);
}

public static <T> void printList(SingleLinkedListNode<T> node) {
    SingleLinkedListNode<T> aux = node;
    while (!aux.isNil()) {
        System.out.print(aux.getData() + " ");
        aux = aux.getNext();
    }
    System.out.println();
}

//  public static void main(String[] args) {
//     LeetCode<Integer> teste = new LeetCode<>();

//     SingleLinkedListNode<Integer> lista1 = criarLista(new Integer[]{1, 2, 2, 1});
//     System.out.println("Palíndromo? " + teste.isPalindrome(lista1)); // true

//     SingleLinkedListNode<Integer> lista2 = criarLista(new Integer[]{1, 2});
//     System.out.println("Palíndromo? " + teste.isPalindrome(lista2)); // false
// }

// // Método auxiliar para criar lista ligada
// public static SingleLinkedListNode<Integer> criarLista(Integer[] valores) {
//     if (valores == null || valores.length == 0) return null;

//     SingleLinkedListNode<Integer> head = new SingleLinkedListNode<>(valores[0], null);
//     SingleLinkedListNode<Integer> atual = head;

//     for (int i = 1; i < valores.length; i++) {
//         SingleLinkedListNode<Integer> novoNo = new SingleLinkedListNode<>(valores[i], null);
//         atual.setNext(novoNo);
//         atual = novoNo;
//     }
//     return head;
}

