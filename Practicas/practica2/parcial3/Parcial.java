package practica2.parcial3;
import java.util.List;

import practica2.ejercicio1y2.*;

public class Parcial {
    private List<BinaryTree<Integer>> lis;
    private int cant;
    
    public Parcial(List<BinaryTree<Integer>> lis, int cant) {
        this.lis = lis;
        this.cant = cant;
    }

    public List<BinaryTree<Integer>> getLis() {
        return lis;
    }

    public void setLis(List<BinaryTree<Integer>> lis) {
        this.lis = lis;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

}
