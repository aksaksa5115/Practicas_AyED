package practica3.ejercicio1;

import java.util.LinkedList;
import practica1.ejercicio8.Queue;
import java.util.List;

public class GeneralTree<T> {

    private T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();
    
    public GeneralTree() {	
	
    }
    public GeneralTree(T data) {
        this.data = data;
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this(data);
	this.children = children;
    }	
    
    public T getData() {
	return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }
	
    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null)
            this.children = children;
    }
	
    public void addChild(GeneralTree<T> child) {
        this.getChildren().add(child);
    }

    public boolean isLeaf() {
        return !this.hasChildren();
    }
	
    public boolean hasChildren() {
        return !this.children.isEmpty();
    }
	
    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren())
            children.remove(child);
    }
    //-------------------EJERCICIO 3------------------------
    
    public int altura() {
    	int altura = -1;
    	if (!this.isEmpty())
    		altura = alturita();
    	return altura;
    }
    
    private int alturita() {
    	if (this.isLeaf())
    		return 0;
    	else {
    		int alturaMaxima = -1;
    		for (GeneralTree<T> hijos : this.getChildren())
    			alturaMaxima = Math.max(alturaMaxima, hijos.alturita());
    		
    		return alturaMaxima + 1;
    	}
    }
    
    public int nivel (T dato) {
    	int profundidad = -1;
    	if (!this.isEmpty())
    		profundidad = nivelito(dato);
    	return profundidad;
    }
    
    private int nivelito(T dato) {
    	int cont = 0; //nivel en el que arrancamos
    	int act = 0; //almacenara la cantidad de nodos en el nivel actual
    	GeneralTree<T> aux; //servira para recorrer uno a uno los nodos
    	Queue<GeneralTree<T>> cola = new Queue<>(); //con este bicho haremos un recorrido BFS
    	cola.enqueue(this); //encolamos la raiz del arbol
    	while (!cola.isEmpty()) {
    		act = cola.size(); //vemos la cantidad de nodos en el nivel actual
    		for (int i=0; i<act; i++) { //recorremos cada nodo
    			aux = cola.dequeue(); //desencolamos un nodo
    			if(aux.getData().equals(dato)) { //preguntamos si es el que buscamos
    				return cont;
    			} else {
    				for(GeneralTree<T> hijos: aux.getChildren()) // si no es, almacenamos los hijos del nodo extraido
    					cola.enqueue(hijos);
    			}
    		}
    		cont++; //avanzamos al siguiente nivel
    	}
    	return -1; //caso que no se encontro nunca
    }
    
    public int ancho() {
       	int ancho = -1;
    	if (!this.isEmpty())
    		ancho = anchito();
    	return ancho;
    }
    
    private int anchito() {
    	
    	Queue<GeneralTree<T>> cola = new Queue();
    	cola.enqueue(this);
    	int anchoMax = 0;
    	
    	while (!cola.isEmpty()) {
    		int nivelActual = cola.size();
    		anchoMax = Math.max(anchoMax, nivelActual);
    		
    		for (int i=0; i<nivelActual; i++) {
    			GeneralTree<T> nodo = cola.dequeue();
    			for (GeneralTree<T> hijo: nodo.getChildren())
    				cola.enqueue(hijo);
    		}
    		
    	}
    	return anchoMax;
    	
    }
    
    
    
}
