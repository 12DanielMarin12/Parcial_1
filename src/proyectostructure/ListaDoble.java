 
package proyectostructure;
 
public class ListaDoble implements LinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    public ListaDoble(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public ListaDoble(Object object){
        this.head = new Node(object) ;
        this.tail = head;
        this.size = 1;
    }
    
    public ListaDoble(Node node){
        this.head = node;
        this.tail = head;
        this.size = 1;
    }
    
    
    @Override
    public boolean add(Object object) {
        Node n =  new Node(object) ;
        if(isEmpty()){
            this.head = n;
            this.tail = head;
            this.size = 1;
            return true;
        }else{
            tail.setNext(n);
            n.setPrevius(tail);
            tail = n;
            size++;
            return true;
        }
    }

    @Override
    public boolean add(LinkedListNode node, Object object) {
        try {
            if(isEmpty()){
               return false;
            }else{
                Node n = new Node(object);
                Node current = head;
                if(current.getObject()==node.getObject()){
                    n.setNext(current.getNext());
                    n.setPrevius(current);
                    current.setNext(n);
                    current.getNext().setPrevius(n);
                    size++;
                    return true;
                }else{
                    while(current!=null){
                        current = current.getNext();
                        if(current.getObject()==node.getObject()){
                            if(current==tail){
                                tail.setNext(n);
                                n.setPrevius(tail);
                                tail = n;
                                size++;
                                return true;
                            }else{
                                n.setNext(current.getNext());
                                n.setPrevius(current);
                                current.setNext(n);
                                current.getNext().setPrevius(n);
                                size++;
                                return true;
                            }
                        }
                    }
                }
                return false;

            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override//!?!?!?!?
    public boolean addAll(Object objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//?!?!?!
    public boolean addAll(LinkedListNode node, Object objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addFirst(Object object) {
        Node n = new Node(object); 
        if(isEmpty()){
            this.head = n;
            this.tail = head;
            this.size = 1;
            return true;
        }else{
            n.setNext(head);
            head.setPrevius(n);
            head = n;
            size++;
            return true;
        }
    }

    @Override
    public boolean addLast(Object object)  {
        Node n = new Node(object); 
        if (isEmpty()) {
            this.head = n;
            this.tail = head;
            this.size = 1;
            return true;
        }else{
            tail.setNext(n);
            n.setPrevius(tail);
            tail = n;
            size++;
            return true;
        }        
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public LinkedList clone() {
        LinkedList n = new ListaDoble();
        n.setHead(head);
        n.setTail(tail);
        n.setSize(size);
        return n;
    }

    @Override
    public boolean contains(Object object) {
        if(isEmpty()){
            return false;
        }else{
            Node current = head;
            while(current!=null){
                if(current.getObject()==object){
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    @Override//!??!?!
    public boolean containsAll(Object objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedListNode nodeOf(Object object) {
        if(isEmpty()){
            return null;
        }else{
            LinkedListNode current = head;
            while(current!=null){
                if(current.getObject()==object){
                    return current;
                }
                current = current.getNext();
            }
        }
        return null;
    }

    @Override
    public boolean isEquals(Object object) {
        if(isEmpty()){
            return false;
        }else{
            Node current = head;
            while(current!=null){
                if(current.getObject().getClass()==object.getClass()){
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public Object get() {
        return tail;
    }

    @Override
    public Object get(LinkedListNode node) {
        int c = 0;
        if(isEmpty()){
            return null;
        }else{
            Node current = head;
            while(current!=null){ 
                if(node.getObject()==current.getObject()){
                    return c;
                }
                c++;
                current = current.getNext();
            }
        }
        return false;
    }

    @Override
    public Object getPrevious(LinkedListNode node)  {
        if(isEmpty()){
            return null;
        }else{
            Node current = head;
            if(node.getObject()==current.getObject()){
                return null;
            }else{
                while(current!=null){
                    if(current.getObject()==node.getObject()){
                        return current.getPrevius();
                    }
                    current = current.getNext();
                }
            }
        }
        return null;
    }

    @Override
    public Object getNext(LinkedListNode node) {
        if(isEmpty()){
            return null;
        }else{
            Node current = head;
            if(node.getObject()==current.getObject()){
                return current.getNext();
            }else{
                while(current!=null){
                    if(current.getObject()==node.getObject()){
                        return current.getNext();
                    }
                    current = current.getNext();
                }
            }
        }
        return null;
    }

    @Override
    public Object getFirst() {
        return head;
    }

    @Override
    public Object getLast() {
        return tail;
    }

    @Override
    public boolean remove(Object object) {
        if(isEmpty()){
            return false;
        }else{
            Node current = head;
            if(current.getObject()==object){
                head = head.getNext();
                head.setPrevius(null);
                size--;
                return true;
            }
            while(current.getNext()!=null){
                if(current.getNext().getObject()==object){
                    current.setNext(current.getNext().getNext());
                    current.getNext().getNext().setPrevius(current);
                    size--;
                    return true;
                }
                current = current.getNext();
                
            }
        }
        return false;
    }

    @Override
    public boolean remove(LinkedListNode node) {
        if(isEmpty()){
            return false;
        }else{
            Node current = head;
            if(current.getObject()==node.getObject()){
                if(head.getNext()!=null){
                    head = head.getNext();
                    head.setPrevius(null);
                    size--;
                }else{
                    this.head=null;
                    size=0;
                }
                return true;
            }
            while(current.getNext()!=null){
                if(current.getNext().getObject()==node.getObject()){
                    current.setNext(current.getNext().getNext());
                    current.getNext().getNext().setPrevius(current);
                    size--;
                    return true;
                }
                current = current.getNext();
                
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Object objects) {
        try {
            if(isEmpty()){
               return false;
            }else{
                Node current = head;
                while(current!=null){ 
                    if(current.getObject()==objects){
                        remove(current);
                    }
                    current = current.getNext();
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean retainAll(Object objects) {
        try {
            if(isEmpty()){
               return false;
            }else{
                Node current = head;
                while(current!=null){ 
                    if(current.getObject()!=objects){
                        remove(current);
                        
                    }
                    current = current.getNext();
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean set(LinkedListNode node, Object object) {
        if(isEmpty()){
            return false;
        }else{
            Node current = head;
            while(current!=null){
                if(current.getObject()==node.getObject()){
                    current.setObject(object);
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public LinkedList subList(LinkedListNode from, LinkedListNode to) {
        if(isEmpty()){
            return null;
        } 
        if(contains(from.getObject()) && contains(to.getObject())){ 
            Node current = head; 
            while(current!=null){ 
                if(current.getObject()==from.getObject()){ 
                    LinkedList n = new ListaDoble();
                    while(current!=to){
                        System.out.println("...");
                        n.add(current.getObject());
                        current = current.getNext();
                    }
                    n.add(current.getObject());
                    return n;
                }
                current = current.getNext();
            }
        }
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size];
        Node current = head;
        
        for(int i = 0 ; i < size ; i++){
            a[i]=current.getObject();
            current = current.getNext();
        }
        
        return a;
    }

    @Override
    public LinkedList sort() { 
        LinkedList n = new ListaDoble();
        
        Node current = tail;
        while (current!=null){
            n.add(current.getObject());
            current = current.getPrevius();
        }
        return n;
    }
    
    public String toString(){
        Node current = head;
        String lista = "";
        
        while(current!=null){
            lista += current.toString();
            current = current.getNext();
        }
        return lista;
    }

    
    public String toStringReverse(){
        Node current = tail;
        String lista = "";
        
        while(current!=null){
            lista += current.toString();
            current = current.getPrevius();
        }
        return lista;
    }
  
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Node peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numContenidos(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float sumaLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object frecuencia(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toStringA() {
    try {
            Node current = head;
        String lista = "";
        
        while(current!=null){
            lista += current.toString();
            current = current.getNext();
            lista+=",";
        }
        return lista;
        } catch (Exception e) {
            return "algo salio mal";
        }    }
    
    
}
