package bst;

public class Prova3<T extends Comparable<T>> {
    
    public int contarFolhasNivelPar(BSTNode<T> node){
        int result = 0;
        if(node != null){
            result = contarFolhasNivelParRec(node, 0);
        }
        return result;
    }

    private int contarFolhasNivelParRec(BSTNode<T> node, int level){
        int result = 0;
        if(node != null && level >= 0 && !node.isEmpty()){
            if(node.getLeft().isEmpty() && node.getRight().isEmpty()){
                if(level % 2 == 0){
                    result = 1;
                }
            }
            else{
                result = contarFolhasNivelParRec((BSTNode<T>) node.getLeft(), level+1) + contarFolhasNivelParRec((BSTNode<T>) node.getRight(), level+1);
            } 
        }
        return result;
    }

    public T maisProximo(BSTNode<T> node, T x){
        T result = null;
        if(node != null && !node.isEmpty()){
            result = maisProximoRec(node, x);
        }
        return result;
    }

    private T maisProximoRec(BSTNode<T> node, T x){
        T result = null;
        if(node != null &&!node.isEmpty()){
            if(node.getData().compareTo(x) == 0){
                result = node.getData();
            }
            else{
                T candidate;
                if(x.compareTo(node.getData()) < 0){
                    candidate = maisProximoRec((BSTNode<T>) node.getLeft(), x);
                }
                else{
                    candidate = maisProximoRec((BSTNode<T>) node.getRight(), x);
                    if(candidate == null){
                        result = node.getData();
                    }
                    else {
                        int diffAtual = (Integer) node.getData() - (Integer) x;
                        if(diffAtual < 0){
                            diffAtual = -diffAtual;
                        }

                        int diffCand  = (Integer) candidate - (Integer) x;
                        if(diffCand < 0){
                            diffCand = -diffCand;
                        }
                        if(diffAtual <= diffCand){ 
                            result = node.getData(); 
                        } 
                        else{ 
                            result = candidate; 
                        }
                    }
                }
            }
        }

        return result;
    }

    public boolean existeCaminhoSomaPar(BSTNode<T> node){
        boolean result = false;
        if(node != null){
            result = exiteCaminhoSomaParRec(node, 0);
        }
        return result;
    }

    private boolean exiteCaminhoSomaParRec(BSTNode<T> node, int soma){
        boolean result = false;
        if(node != null && !node.isEmpty()){
            Integer nova = soma + (Integer) node.getData();
            if(node.getLeft().isEmpty() && node.getRight().isEmpty()){
                result = (nova % 2 == 0);
            }
            else {
                result = exiteCaminhoSomaParRec((BSTNode) node.getLeft(), nova) || exiteCaminhoSomaParRec((BSTNode)node.getRight(), nova);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BSTI<Integer> node = new BSTI<>();

        Integer[] arrayDeInteiros = new Integer[]{10,5, 3, 7, 15, 12, 20};

        for(Integer value : arrayDeInteiros) node.insert(value);

        Prova3 teste = new Prova3<>();

         System.out.println(teste.contarFolhasNivelPar(node.getRoot())); //conta quantas folhas estão em nivel par
        System.out.println(teste.maisProximo(node.getRoot(), 11)); // retorna o numero mais proximo de x
        System.out.println(teste.existeCaminhoSomaPar(node.getRoot()));
    }
}
