package bst;

public class FloorCeilBSTImpl extends BSTI<Integer> {

    public Integer floor(Integer[] array, double numero) {
        Integer floor = null;
        if(array != null && array.length > 0){
            for(Integer v : array){
                this.insert(v);
            }
            floor = this.floor(super.getRoot(), numero, null);
        }
        return floor;
    }

    private Integer floor(BSTNode<Integer> node, double numero, Integer floor){
        if(!node.isEmpty()){
            if(numero < node.getData()){
                floor = this.floor((BSTNode<Integer>) node.getLeft(), numero, floor);
            }
            else if(numero > node.getData()){
                floor = this.floor((BSTNode<Integer>) node.getRight(), numero, node.getData());
            }
            else{
                floor = node.getData();
            }
        }
        return floor;
    }

    public Integer ceil(Integer[] array, double numero) {
        Integer ceil = null;
        if(array != null && array.length > 0){
            for(Integer v : array){
                this.insert(v);
            }
            ceil = this.ceil(super.getRoot(), numero, null);
        }
        return ceil;
    }
            
    private Integer ceil(BSTNode<Integer> node, double numero, Integer ceil) {
        if(!node.isEmpty()){
            if(numero < node.getData()){
                ceil = this.ceil((BSTNode<Integer>) node.getLeft(), numero, node.getData());
            }
            else if(numero > node.getData()){
                ceil = this.ceil((BSTNode<Integer>) node.getRight(), numero, ceil);
            }
            else{
                ceil = node.getData();
            }
        }
        return ceil;
    }   
}