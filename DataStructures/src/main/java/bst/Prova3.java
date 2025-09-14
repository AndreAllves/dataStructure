package bst;

import java.util.LinkedList;
import java.util.List;

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

    public int contarFolhasNivelImpar(BSTNode<T> node){
        int result = 0;
        if(node != null){
            result = contarFolhasNivelImparRec(node, 0);
        }
        return result;
    }

    private int contarFolhasNivelImparRec(BSTNode<T> node, int level){
        int result = 0;
        if(node != null && level >= 0 && !node.isEmpty()){
            if(node.getLeft().isEmpty() && node.getRight().isEmpty()){
                if(level % 2 != 0){
                    result = 1;
                }
            }
            else{
                result = contarFolhasNivelImparRec((BSTNode<T>) node.getLeft(), level+1) 
                    + contarFolhasNivelImparRec((BSTNode<T>) node.getRight(), level+1);
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

    public Integer somaUnicoFilho(BSTNode<Integer> node){
        return this.somaUnicoFilhoRec(node);
    }

    private Integer somaUnicoFilhoRec(BSTNode<Integer> node){
        Integer result = 0;
        if(node != null && !node.isEmpty()){
            if((node.getLeft().isEmpty() && !node.getRight().isEmpty()) || (!node.getLeft().isEmpty() && node.getRight().isEmpty())){
                result += 1;
            }
            result += this.somaUnicoFilhoRec((BSTNode<Integer>) node.getLeft());
            result += this.somaUnicoFilhoRec((BSTNode<Integer>) node.getRight());

        }
        return result;
    }

    public List<T> maiorSubSeqBST(BSTNode<T> node){
        List<T> list = new LinkedList<>();
        this.maiorSubSeqBSTRec(node, list);
        return list;
    }

    private void maiorSubSeqBSTRec(BSTNode<T> node, List<T> list) {
        if(node != null && !node.isEmpty()){
            this.maiorSubSeqBSTRec((BSTNode<T>) node.getLeft(), list);

            if(list.isEmpty() || node.getData().compareTo(list.get(list.size() - 1)) > 0){
                list.add(node.getData());
            }

            this.maiorSubSeqBSTRec((BSTNode<T>) node.getRight(), list);
        }
    }

    public BSTNode<T> buildBST(T[] array){
        return this.buildBSTRec(array, 0, array.length - 1);
    }

    private BSTNode<T> buildBSTRec(T[] array, int left, int right) {
        BSTNode<T> result = null;
        if(left <= right){
            int middle = (left + right) / 2;

            BSTNode<T> leftB = this.buildBSTRec(array, left, middle-1);
            BSTNode<T> rightB = this.buildBSTRec(array, middle+1, right);

            result = new BSTNode.Builder<T>().data(array[middle]).left(leftB).right(rightB).build();
        }
        return result;
    }

    public boolean bstQuaseCompleta(BSTNode<T> node){
        return this.bstQuaseCompletaRec(node, 0) != -1;
    }

    private int bstQuaseCompletaRec(BSTNode<T> node, int i) {
        int result = 0;

        if(node != null && !node.isEmpty()){

            int left = bstQuaseCompletaRec((BSTNode<T>) node.getLeft(), 2 * i + 1);
            if(left == -1) {
                result = -1;
            }
            int right = bstQuaseCompletaRec((BSTNode<T>) node.getRight(), 2 * i + 2);
            if(right == -1) {
                result = -1;
            }

            else{
                result = 1 + left + right;
            }
        }
        return result;
    }

    public Integer rangeCountBST(BSTNode<T> node, int left, int right){
        return rangeCountBSTRec(node, left, right);
    }

    private Integer rangeCountBSTRec(BSTNode<T> node, int left, int right){
        Integer result = 0;

        if(node != null && !node.isEmpty()){
            if((Integer) node.getData() >= left && (Integer) node.getData() <= right){
                result = 1;
            }
            if ((Integer) node.getData() > left){
                result += this.rangeCountBSTRec((BSTNode<T>) node.getLeft(), left, right);
            }
            if ((Integer) node.getData() < right) {
                result += this.rangeCountBSTRec((BSTNode<T>) node.getRight(), left, right);
            }
        }
        return result;
    }

    public int somNivelMaisProfundo(BSTNode node){
        return this.somNivelMaisProfundoRec(node, 1, this.height(node));
    }

    private int height(BSTNode<T> node){
        int height = 0;
        if(node != null && !node.isEmpty()){
            height = 1 + Math.max(this.height((BSTNode<T>) node.getLeft()), this.height((BSTNode<T>) node.getRight()));
        }
        return height;
    }
    

    private int somNivelMaisProfundoRec(BSTNode node, int cur, int targ){
        int result = 0;

        if(node != null && !node.isEmpty()){
            if(cur == targ){
                result = (int) node.getData();
            }
            else{
                result = this.somNivelMaisProfundoRec((BSTNode) node.getLeft(), cur + 1, targ) + this.somNivelMaisProfundoRec((BSTNode) node.getRight(), cur + 1, targ);
            }
        }
        return result;
    }

    public Integer maiorMenorQueX(BSTNode<Integer> node, Integer x) {
        return maiorMenorQueXRec(node, x, null);
    }

    private Integer maiorMenorQueXRec(BSTNode<Integer> node, Integer x, Integer best) {
        Integer resultado = best;

        if (node != null && !node.isEmpty()) {
            Integer data = node.getData();

            if (data < x) {
                Integer right = maiorMenorQueXRec((BSTNode<Integer>) node.getRight(), x, data);
                if (right != null) resultado = right;
            } else {
                Integer left = maiorMenorQueXRec((BSTNode<Integer>) node.getLeft(), x, best);
                if (left != null) resultado = left;
            }
        }

        return resultado;
    }

    public int contarBalanceados(BSTNode<Integer> node) {
        int[] count = new int[]{0};
        contarBalanceadosRec(node, count);
        return count[0];
    }

    
    private int contarBalanceadosRec(BSTNode<Integer> node, int[] count) {
        int altura = 0;

        if (node != null && !node.isEmpty()) {
            int leftHeight = contarBalanceadosRec((BSTNode<Integer>) node.getLeft(), count);
            int rightHeight = contarBalanceadosRec((BSTNode<Integer>) node.getRight(), count);

            if (leftHeight == rightHeight) count[0]++;

            altura = 1 + Math.max(leftHeight, rightHeight);
        }

        return altura;
    }

    public void transformarSomaAcumulada(BSTNode<Integer> node) {
        this.transformarSomaAcumulada(node, 0);
    }

    public int transformarSomaAcumulada(BSTNode<Integer> node, int somaAcum) {
        int resultado = somaAcum;

        if(node != null && !node.isEmpty()){
            resultado = transformarSomaAcumulada((BSTNode<Integer>) node.getRight(), resultado);

            int atual = node.getData();
            node.setData(atual + resultado);
            resultado = node.getData();

            resultado = transformarSomaAcumulada((BSTNode<Integer>) node.getLeft(), resultado);
        }

        return resultado;
    }

    public boolean existeNoIgualSomaSubarvore(BSTNode<Integer> node) {
        return existeNoRec(node) != null;
    }

    private Integer existeNoRec(BSTNode<Integer> node) {
        Integer somaSub = null;

        if(node != null && !node.isEmpty()){
            int leftSum = existeNoRec((BSTNode<Integer>) node.getLeft()) != null ? existeNoRec((BSTNode<Integer>) node.getLeft()) : 0;
            int rightSum = existeNoRec((BSTNode<Integer>) node.getRight()) != null ? existeNoRec((BSTNode<Integer>) node.getRight()) : 0;

            int totalSub = leftSum + rightSum;

            if(node.getData() == totalSub) somaSub = node.getData();
            else somaSub = node.getData() + totalSub;
        }

        return somaSub;
    }


    public String menorNumeroInorder(BSTNode<Integer> node) {
        String resultado = "";

        if(node != null && !node.isEmpty()){
            resultado += menorNumeroInorder((BSTNode<Integer>) node.getLeft());
            resultado += node.getData();
            resultado += menorNumeroInorder((BSTNode<Integer>) node.getRight());
        }

        return resultado;
    }

    public void substituirPorNosMaiores(BSTNode<Integer> node) {
        this.substituirPorNosMaiores(node, 0);

    }

    public int substituirPorNosMaiores(BSTNode<Integer> node, int count) {
        int resultado = count;

        if(node != null && !node.isEmpty()){
            resultado = substituirPorNosMaiores((BSTNode<Integer>) node.getRight(), resultado);

            int atual = node.getData();
            node.setData(resultado); 
            resultado++;

            resultado = substituirPorNosMaiores((BSTNode<Integer>) node.getLeft(), resultado);
        }

        return resultado;
    }    
}
