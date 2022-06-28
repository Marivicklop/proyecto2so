/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2so;

/**
 *
 * @author mvlop
 */
public class Cola<T> {
    
    private Node <T> first;
    private Node <T> last;
    private int size;
    
    public Cola() {
        this.first = null;
        this.last = null;
        this.size = 0;
        
    }
    
    public Cola(T datum) {
        Node<T> n = new Node(datum);
        this.first = n;
        this.last = n;
        this.size = 1;
    }
    
    private boolean isEmpty() {
        return this.first == null;
    }
    
    public void encolar(T datum) {
        Node<T> n = new Node(datum);
        this.size += 1;
        if (isEmpty()) {
            this.first = this.last = n;
        } else {
            this.last.setNext(n);
            this.last = n;
            
        }
    }
    
   public T desencolar() {
       if (isEmpty()) {
           return null;
       }
       
       Node<T> aux = this.first;
       this.first = aux.getNext();
       aux.setNext(null);
       this.size -=1;
       return aux.getData();
   }
    
   public T peek() {
       if (isEmpty()){
           return null;
       }
       
       Node<T> aux = this.last;
       return aux.getData();
   }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }
   
   
}
