package sorting;

/**
 * Dado dois arrays ordenados em ordem crescente, encontrar a k-esima
 * estatistica de ordem da uniao ordenada deles.
 * 
 * Restricoes: - os arrays nao possuem elementos em comum e nem repetidos - k eh
 * um numero compreendido entre 1 e array1.length + array2.length - caso o
 * k-esima estatistica de ordem nao exista, o metodo deve retornar null - voce
 * nao pode usar memoria extra - seu algoritmo deve ter complexidade
 * O(array1.length + array2.length). - voce nao pode usar nenhum metodo pronto
 * de manipulacao de arrays, exceto length.
 * 
 * 
 *
 */

public class ProvaLeda<T extends Comparable<T>> {
    public T statisticsOrder(T[] array1, T[] array2, int k) {
        if(k < 1 || k > (array1.length + array2.length)){
            return null;
        }
        return auxStatisticsOrder(array1, array2, k);
    }
    
    public T auxStatisticsOrder(T[] array1, T[] array2, int k) {
        int cont1 = 0;
        int cont2 = 0;
        T kStatistics = null;

        while(k > 0 && cont1 < array1.length && cont2 < array2.length){
            if(array1[cont1].compareTo(array2[cont2]) < 0){
                kStatistics = array1[cont1];
                cont1++;
            }
            else{
                kStatistics = array2[cont2];
                cont2++;
            }
            k--;
        }

        while(k > 0 && cont1 < array1.length){
            kStatistics = array1[cont1];
            cont1++;
            k--;
        }

        while(k > 0 && cont2 < array2.length){
            kStatistics = array2[cont2];
            cont2++;
            k--;
        }

        if(k > 0){
            return null;
        }
        return kStatistics;
        
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 3, 4};
        Integer[] a2 = new Integer[]{5, 6, 7, 8};
        ProvaLeda<Integer> sorter = new ProvaLeda<>();
        System.out.println("k-esima = " + sorter.statisticsOrder(a, a2, 8));
    }
}
