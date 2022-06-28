/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2so;

/**
 *
 * @author mvlop
 */
public class Node<T> {
    private T data;
    private Node next;
    
    /**
     *
     * @param datum
     */
    public Node (T datum) {
        this.data = datum;
        this.next = null;
    }


    public T getData() {
        return data;
    }


    
    public void setData(T data) {
        this.data = data;
    }


    
    public Node getNext() {
        return next;
    }


    
    public void setNext(Node next) {
        this.next = next;
    }
    
    
    
}