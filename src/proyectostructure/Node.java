 
package proyectostructure;

 
public class Node implements LinkedListNode {
    private Object object;
    private Node next;
    private Node previus;
    
    public Node(Object object){
        if(object!=null){
            this.object = object; 
        }else{
            this.object = ""; 
        } 
        next = null;
        previus = null;
    }
    
    public Node(Object object, Node node){
       
        if(object!=null){
            this.object = object; 
        }else{
            this.object = ""; 
        } 
        next = node;
        previus = null;
    }
    
    public String toString(){
        return getObject()+" ";
    }

    public Object getObject() {
        return object;
    }

    @Override
    public void setObject(Object object) {
        this.object = object;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevius() {
        return previus;
    }

    public void setPrevius(Node previus) {
        this.previus = previus;
    }

     
    
    
    
    
}
