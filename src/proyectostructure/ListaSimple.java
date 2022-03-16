 
package proyectostructure;
 
public class ListaSimple implements LinkedList{
    private Node head;
    private Node tail;
    private int size;
    
    public ListaSimple(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public ListaSimple(Object object){
        this.head = new Node(object) ; 
        this.tail = head;
        this.size = 1;
    }
    
    public ListaSimple(Node node){
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
                Node current = head;
                if(current.getObject()==node.getObject()){
                    current.setNext(new Node(object, current.getNext()));
                    size++;
                    return true;
                }else{
                    while(current!=null){
                        current = current.getNext();
                        if(current.getObject()==node.getObject()){
                            if(current==tail){
                                current.setNext(new Node(object));
                                tail = current.getNext();
                                size++;
                                return true;
                            }else{
                                current.setNext(new Node(object, current.getNext()));
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
        head = new Node(object, head);
        size++;
        return true;
    }

    @Override
    public boolean addLast(Object object)  {
        Node n = new Node(object);
        tail.setNext(n);
        tail = n;
        size++;
        return true;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public LinkedList clone() {
        ListaSimple n = new ListaSimple();
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
        try {
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
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Object getPrevious(LinkedListNode node) {
        try {
            if(isEmpty()){
            return null;
        }else{
            Node current = head;
            if(node.getObject()==current.getObject()){
                return null;
            }else{
                while(current.getNext()!=null){
                    if(current.getNext().getObject()==node.getObject()){
                        return current;
                    }
                    current = current.getNext();
                }
            }
        }
        return null;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Object getNext(LinkedListNode node) {
        try {
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
        } catch (Exception e) {
            return false;
        }
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
                size--;
                return true;
            }
            while(current.getNext()!=null){
                if(current.getNext().getObject()==object){
                    current.setNext(current.getNext().getNext());
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
                head = head.getNext();
                size--;
                return true;
            }
            while(current.getNext()!=null){
                if(current.getNext().getObject()==node.getObject()){
                    current.setNext(current.getNext().getNext());
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
        try {
            if(isEmpty()){
            return false;
        }else{
            Node current = head;
            while(current!=null){
                if(current==node){
                    current.setObject(object);
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public LinkedList subList(LinkedListNode from, LinkedListNode to) {
        try {
            if(isEmpty()){
            return null;
        } 
        if(contains(from.getObject()) && contains(to.getObject())){ 
            Node current = head; 
            while(current!=null){ 
                if(current.getObject()==from.getObject()){ 
                    LinkedList n = new ListaSimple();
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
        } catch (Exception e) {
            return null;
        }
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
        Object[] k = toArray(); 
        LinkedList n = new ListaSimple();
        
        for(int i=size-1 ; i>0 ; i--){
            n.add(k[i]);
        }
        return n;
    }
    @Override
    public String toString(){
        try {
            Node current = head;
        String lista = "";
        
        while(current!=null){
            lista += current.toString();
            current = current.getNext();
        }
        return lista;
        } catch (Exception e) {
            return "algo salio mal";
        }
    }

    @Override
    public Node getHead() {
        return head;
    }

    @Override
    public void setHead(Node head) {
        this.head = head;
    }

    @Override
    public Node getTail() {
        return tail;
    }

    @Override
    public void setTail(Node tail) {
        this.tail = tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override//no es para esta lista
    public LinkedList toStringReverse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //PRCIAL PUNTO 1
    @Override
    public int numContenidos(Object object){
        if(isEmpty()){
            return 0;
        }else{
            int c = 0;
            Node current = head;
            while(current!=null){
                if(current.getObject()==object){
                    c++;
                }
                current = current.getNext();
            }
            return c;
        }        
    }
    
    //PARCIAL PUNTO 2
    @Override
    public float sumaLista(){
        try {
            float c = 0;
            Node current = head;
            while (current!=null) {
               
                c += (float)(int)current.getObject();  
                current = current.getNext(); 
            }
            return c;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Object frecuencia(Object object){
        return numContenidos(object);
    }
    
    
}
