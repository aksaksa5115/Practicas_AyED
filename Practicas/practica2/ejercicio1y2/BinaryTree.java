package practica2.ejercicio1y2;

public class BinaryTree <T> {
	
    private T data;
    private BinaryTree<T> leftChild;   
    private BinaryTree<T> rightChild; 

    public BinaryTree() {
        super();
    }

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    /**
     * Preguntar antes de invocar si hasLeftChild()
     * @return
     */
    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }
    /**
     * Preguntar antes de invocar si hasRightChild()
     * @return
     */
    public BinaryTree<T> getRightChild() {
        return rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());
    }

    public boolean hasLeftChild() {
        return this.leftChild!=null;
    }

    public boolean hasRightChild() {
        return this.rightChild!=null;
    }
    @Override
    public String toString() {
        return this.getData().toString();
    }
    
    public void imprimirArbol() {
        if(this.hasLeftChild()) this.getLeftChild().imprimirArbol();
        System.out.print(this.getData() + " ");
        if(this.hasRightChild()) this.getRightChild().imprimirArbol();
    }
    //-------------------------EJERCICIO 2---------------------------
    
    public int contarHojas() {
    	
    	int left = 0;
    	int right = 0;
    	if (this.isEmpty()) {
    		return 0;
    	}
    	else if (this.isLeaf()) {
    		return 1;
    	}
    	else
    		if (this.hasLeftChild()) {
    			left += this.leftChild.contarHojas();
    		}
    		if (this.hasRightChild()) {
    			right += this.rightChild.contarHojas();
    		}
    	return left + right;
    }
    
    public BinaryTree<T> espejo(){
    	BinaryTree<T> espejito = new BinaryTree<T>(this.getData());
    	if(this.hasLeftChild()) {
    		espejito.addRightChild(this.getLeftChild().espejo());
    	}
    	if(this.hasRightChild()) {
    		espejito.addLeftChild(this.getRightChild().espejo());
    	}
    	return espejito;
    }
    
}
