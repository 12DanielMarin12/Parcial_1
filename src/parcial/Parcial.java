 
package parcial;
 
import proyectostructure.LinkedList; 
import proyectostructure.ListaDoble;
import proyectostructure.ListaSimple;
import proyectostructure.Node;

public class Parcial {
 
    public static void main(String[] args) {
        /*Metodos utilizables por cada punto
        1.interseccion_Dos_Conjuntos(ListaSimple A, ListaSimple B)
          diferencia_Dos_Conjuntos(ListaSimple A, ListaSimple B)
        
        2.promedio(LinkedList A)
          mediana(LinkedList A)
          moda(LinkedList A)
          frecuencia(LinkedList A, Object object)
        
        3.binarioOctal(String binario)
          octalBinario(String octal)
          binarioHexadecimal(String binario)
          hexadecimalBinario(String hexadecimal)
        
        4.suma(String valorUno, String valorDos)
          division(String dividendo, String divisor)
        
        5.evaluarPolinomio(LinkedList polinomio, int valorX)
          integrarPolinomio(LinkedList polinomio)
          sumarDosPolinomio(LinkedList polinomio1, LinkedList polinomio2)
        */
 
      


       
    }
    //Punto_1
    //Este metodo reecibe dos listas de conjuntos y devuelve una lista con la interseccion de ambas
    public static LinkedList interseccion_Dos_Conjuntos(ListaSimple A, ListaSimple B){
        LinkedList I = new ListaSimple();
        Node current = B.getHead();
        while(current!=null){
            if(I.contains(current.getObject())){
                current = current.getNext();
            }else{
                for (int i = 0; i < A.numContenidos(current.getObject()); i++) {
                    I.add(current.getObject());
                }
            }
        }
        return I;
    }
    //Este metodo reecibe dos listas de conjuntos y devuelve una lista con la diferencia de ambas
    public static LinkedList diferencia_Dos_Conjuntos(ListaSimple A, ListaSimple B){
        LinkedList I = new ListaSimple();
            Node current =A.getHead();
            while(current!=null){ 
                if(!B.contains(current.getObject())){
                     I.add(current.getObject());
                }
                current = current.getNext(); 
            }
            return I;
    }
    //Punto_2
    //todos los ejercicios del punto 2 reciben listas y a partir de ellas devuelven ya sea un String o un int
    public static float promedio(LinkedList A){
       Node current = A.getHead();
       int total = 0 ;
       while(current!=null){
           int temp= (int)current.getObject();
           total+=temp;
           current = current.getNext();
       }
       return total/A.getSize();
    }
    public static float mediana(LinkedList A){    
        if(A.getSize()%2==0){  
            Node current = A.getHead();
            for (int i = 0; i < ((int)A.getSize()/2)-1; i++) {
                current = current.getNext();
            }
            return ((int)current.getObject()+(int)current.getNext().getObject())/2;
        }else{
            Node current = A.getHead();
            for (int i = 0; i < ((int)A.getSize()/2); i++) {
                current = current.getNext();
            }
            return (int)current.getObject();
        }
    }
    public static Object moda(LinkedList A){
        Object value = 0 ;
        int rep = 0 ;
        Node current = A.getHead();
        while (current!=null){
            if(A.numContenidos(current.getObject())>rep){
                value = current.getObject();
                rep = A.numContenidos(current.getObject());
            }
            current = current.getNext();
        }
        return "valor: " + value + "    repeticiones: " + rep;
    }
    public static Object frecuencia(LinkedList A, Object object){
        return object + " se repite " + A.frecuencia(object) + " veces.";
        
    }
    //Punto 3-------------------
    //Los metodos del punto 3 piden Strings para poder manejar datos que los int no pueden contener,luego convierte el string en listas
    //una vez convertidos utiliza un metodo switch para ir evaluando nodo a nodo, haciendo conversion directa y guardando el resultado
    //en otra lista que se devolvera como el resultado
    static LinkedList binarioOctal(String binario){ 
        LinkedList binarioL = new ListaSimple();
        LinkedList octalL = new ListaSimple();
        for (int i = 0; i < binario.length(); i++) {
            if((binario.charAt(i)==' ')){ 
            }else{
                binarioL.add(binario.charAt(i));
            }
        }
        
        
        if(binarioL.getSize()%3!=0){
            for (int i = 0; i < binarioL.getSize()%3; i++) {
                binarioL.addFirst(0);
            }
        }        
        int i = 0;
        Node current = binarioL.getHead();
        while (i < binarioL.getSize()/3) {
            
            String bi = "";
            for (int j = 0; j < 3; j++) {
                bi += String.valueOf(current.getObject());
                current = current.getNext();
            }
            switch (bi) {
            case "000":
                octalL.add(0);
                break;
            case "001":
                octalL.add(1);
                break;
            case "010":
                octalL.add(2);
                break;
            case "011":
                octalL.add(3);
                break;
            case "100":
                octalL.add(4);
                break;
            case "101":
                octalL.add(5);
                break;
            case "110":
                octalL.add(6);
                break;
            case "111":
                octalL.add(7);
                break;
            default:
                System.out.println("El valor introducido es incorrecto, por favor verifique");
               return octalL ;
            } 
            i++;
        }
        return octalL;
    }
    static LinkedList octalBinario(String octal){ 
        LinkedList binarioL = new ListaSimple();
        LinkedList octalL = new ListaSimple();
        
        for (int i = 0; i < octal.length(); i++) {
            if((octal.charAt(i)==' ')){ 
            }else{
                octalL.add(octal.charAt(i));
            }
        }
         
        
        int i = 0;  
        Node current = octalL.getHead();
        String oc = "";

        while (i < octalL.getSize()) {
            oc = String.valueOf(current.getObject()); 
            switch (oc) {
            case "0":
                binarioL.add("000");
                break;
            case "1":
                binarioL.add("001");
                break;
            case "2":
                binarioL.add("010");
                break;
            case "3":
                binarioL.add("011");
                break;
            case "4":
                binarioL.add("100");
                break;
            case "5":
                binarioL.add("101");
                break;
            case "6":
                binarioL.add("110");
                break;
            case "7":
                binarioL.add("111");
                break;
            default:
                System.out.println("a introducido un valor incorrecto, por favor verifique");
                return binarioL;
            }
            i++;
            current = current.getNext();
        }
        return binarioL;
    }
    static LinkedList binarioHexadecimal(String binario){
        LinkedList binarioL = new ListaSimple();
        LinkedList hexadecimalL = new ListaSimple();
        
        for (int i = 0; i < binario.length(); i++) {
            if((binario.charAt(i)==' ')){ 
            }else{
                binarioL.add(binario.charAt(i));
            }
        }
        
        if(binarioL.getSize()%4!=0){
            for (int i = 0; i < binarioL.getSize()%4; i++) {
                binarioL.addFirst(0);
            }
        }  
         
        int i = 0; 
        System.out.println("binario: "+ binarioL);
        Node current = binarioL.getHead();
        while (i < binarioL.getSize()/4) {
            String hexa = "";
            for (int j = 0; j < 4; j++) {
                hexa += String.valueOf(current.getObject());
                current = current.getNext();
            }
            System.out.println("hexa: "+ hexa);
            switch (hexa) {
            case "0000":
                hexadecimalL.add(0);
                break;
            case "0001":
                hexadecimalL.add(1);
                break;
            case "0010":
                hexadecimalL.add(2);
                break;
            case "0011":
                hexadecimalL.add(3);
                break;
            case "0100":
                hexadecimalL.add(4);
                break;
            case "0101":
                hexadecimalL.add(5);
                break;
            case "0110":
                hexadecimalL.add(6);
                break;
            case "0111":
                hexadecimalL.add(7);
                break;
            case "1000  ":
                hexadecimalL.add(8);
                break;
            case "1001":
                hexadecimalL.add(9);
                break;
            case "1010":
                hexadecimalL.add("A");
                break;
            case "1011":
                hexadecimalL.add("B");
                break;
            case "1100":
                hexadecimalL.add("C");
                break;
            case "1101":
                hexadecimalL.add("D");
                break;
            case "1110":
                hexadecimalL.add("E");
                break;
            case "1111":
                hexadecimalL.add("F");
                break;
            default:
                System.out.println("uno de los datos introducidos es incorrecto, por favor verfique");
                return hexadecimalL;
            }
            i++; 
        }
        return hexadecimalL;
    }
    static LinkedList hexadecimalBinario(String hexadecimal){
            
        LinkedList binarioL = new ListaSimple();
        LinkedList hexadecimalL = new ListaSimple();
        hexadecimal = hexadecimal.toUpperCase(); 

        for (int i = 0; i < hexadecimal.length(); i++) {
            if((hexadecimal.charAt(i)==' ')){ 
            }else{
                hexadecimalL.add(hexadecimal.charAt(i));
            }
        }
        
        String hexa = "";
        int i = 0;  
        Node current = hexadecimalL.getHead();
        while (i < hexadecimalL.getSize()) {
            hexa = String.valueOf(current.getObject());
            
            switch (hexa) {
            case "0":
                binarioL.add("0000");
                break;
            case "1":
                binarioL.add("0001");
                break;
            case "2":
                binarioL.add("0010");
                break;
            case "3":
                binarioL.add("0011");
                break;
            case "4":
                binarioL.add("0100");
                break;
            case "5":
                binarioL.add("0101");
                break;
            case "6":
                binarioL.add("0110");
                break;
            case "7":
                binarioL.add("0111");
                break;
            case "8":
                binarioL.add("1000");
                break;
            case "9":
                binarioL.add("1001");
                break;
            case "A":
                binarioL.add("1010");
                break;
            case "B": 
                binarioL.add("1011");
                break;
            case "C":
                binarioL.add("1100");
                break;
            case "D":
                binarioL.add("1101");
                break;
            case "E":
                binarioL.add("1110");
                break;
            case "F":
                binarioL.add("1111");
                break;
            default:
                System.out.println("uno de los datos introducidos es incorrecto, por favor verifique");
                return binarioL;
            }
            i++;  
            current = current.getNext();
        }
        return binarioL;

    }
    

    //Punto_4-------------------
    /*El punto 4 es un poco mas complicado, para la suma se creo un metodo que recibe un string para poder usar datos que los int no puedan manejar
    este metodo se encarga de pulir los datos, es decir si hay 0 adelante del todo o espacios vacios este se encarga de eliminarlos y agragarlos
    a una lista nueva, una ves hecho llama a otro metodo de suma recursiva que pedira las listas resultantes del primer metodo y ocn base a ellas
    devolvera una lista con los resultados.*/
    
    
    static LinkedList suma(String valorUno, String valorDos){
        LinkedList valorUnoL = new ListaDoble();
        LinkedList valorDosL = new ListaDoble();
        //estos bucles for agregaran los valores a las listas
        for (int i = 0; i < valorUno.length(); i++) {
            if((valorUno.charAt(i)==' ')){ 
            }else{
                valorUnoL.add(Integer.parseInt(String.valueOf(valorUno.charAt(i))));
            }
        }
        for (int i = 0; i < valorDos.length(); i++) {
            if((valorDos.charAt(i)==' ')){ 
            }else{
                valorDosL.add(Integer.parseInt(String.valueOf(valorDos.charAt(i))));
            }
        }
         
 
                Node lastvalorUnoL = valorUnoL.getTail(); 
                Node lastvalorDosL = valorDosL.getTail();  
                
                if(valorUnoL.getSize() < valorDosL.getSize()){ 
                    sumaRecursiva(lastvalorDosL, lastvalorUnoL , valorDosL);
                    return valorDosL;
                }else{ 
                    sumaRecursiva(lastvalorUnoL, lastvalorDosL, valorUnoL);
                    return valorUnoL;
                }
                    /*
                for (int i = 0; i < menor; i++){  
                    if((Integer.parseInt(String.valueOf(lastvalorUnoL.getObject())))+(Integer.parseInt(String.valueOf(lastvalorDosL.getObject())))>=10){ 
                        sumaRecursiva(lastvalorUnoL, lastvalorDosL, valorUnoL);
                    }
                     

                    suma = Integer.parseInt(String.valueOf(lastvalorUnoL.getObject()))+Integer.parseInt(String.valueOf(lastvalorUnoL.getObject()));
                    lastvalorUnoL.setObject(suma);
                    lastvalorUnoL = lastvalorUnoL.getPrevius(); 
                    lastvalorDosL = lastvalorDosL.getPrevius(); 
                    
                }
                */   
                 
        
        
         
        
    }
    static boolean sumaRecursiva(Node valorUnoN, Node valorDosN, LinkedList suma){ 
            int temp = Integer.parseInt(String.valueOf(valorUnoN.getObject()))+Integer.parseInt(String.valueOf(valorDosN.getObject()));
             
                if(valorDosN.getPrevius()==null) { 
                    if(temp>=10){
                        valorUnoN.setObject(temp-10);
                        suma.addFirst(1);
                    }else{
                        valorUnoN.setObject(temp);
                    }
                    return true;
                }else{
                    System.out.println("entre al else recursivo");
                    if(temp>=10){
                         valorUnoN.setObject(temp-10);
                         valorUnoN.getPrevius().setObject(Integer.parseInt(String.valueOf(valorUnoN.getPrevius().getObject()))+1); 
                    }else{
                        valorUnoN.setObject(temp);
                    }
                    
                                    

                    System.out.println("temp: "+ temp);
                    System.out.println("previo:  "+ Integer.parseInt(String.valueOf(valorUnoN.getPrevius().getObject()))); 
                    System.out.println("lista:  "+ suma);
                    sumaRecursiva(valorUnoN.getPrevius(), valorDosN.getPrevius(), suma);
                } 
                return false;
    }
    
    /*el primer metodo de division se encarga de recibir string para poder usar datos mas grandes que los int y corregir los datos
    para no encontrarnos con espacios vacios o '0' al inicio de los nuemros y convierte los strings en listas*/
    
    static LinkedList division(String dividendo, String divisor){
        //Estos dos While's quitan los ceros al principio de los numeros si lo hay para evitar errores.
        LinkedList dividendoL = new ListaDoble();
        LinkedList divisorL = new ListaDoble();
        LinkedList cociente = new ListaSimple();
        //Estos for's agregan los valores introducidos a sus listas correspondientes sin espacios vacios
        for (int i = 0; i < dividendo.length(); i++) {
            if((dividendo.charAt(i)==' ')){ 
            }else{
                dividendoL.add(dividendo.charAt(i));

            }
        }
        for (int i = 0; i < divisor.length(); i++) {
            if((divisor.charAt(i)==' ')){ 
            }else{
                divisorL.add(divisor.charAt(i));

            }
        }
          
         
        //Estos dos if's quitan los ceros al inicio del numero
        if(dividendoL.getSize()>1){
            while(Integer.parseInt(String.valueOf(dividendoL.getHead().getObject()))==0){ 
                dividendoL.remove(dividendoL.getHead());
            } 
        }
        if(divisor.length()>1){
            while(Integer.parseInt(String.valueOf(divisorL.getHead().getObject()))==0){
                divisorL.remove(divisorL.getHead());
            }   
        } 
         
        //Este if retorna 'cociente = 0' en caso de que uno de los dos numeros sea 0
        int longitudDividendo = Integer.parseInt(String.valueOf(dividendoL.getHead().getObject()));
        int longitudDivisor = Integer.parseInt(String.valueOf(divisorL.getHead().getObject()));
        if((longitudDivisor==0)|| longitudDividendo==0){
            cociente.add(0);
            return cociente;
        }
        
        //verificación de que es posible realizar la division
        if(dividendoL.getSize() == divisorL.getSize()){
            if(comprobarSiDivisibleve(dividendoL.getHead(), divisorL.getHead())){
                cociente.add(0);
                return cociente;
            }
        }
        
        
        //invoca al metodo que empieza a dividir
        int co = divisionRecursiva(dividendoL, divisorL);  
        cociente.add(co); 
        
        return cociente;
    }
    
    /**division recursiva se encarga de hacer las restas o en caso de ser necesario llamar a una resta recrusiva, todo esto se hace recorriendo 
     las listas resultantes del primer metodo*/
    static int divisionRecursiva(LinkedList dividendo, LinkedList divisor){ 
        try {
            int cociente = 0; 
            int valueDivisor = Integer.parseInt(String.valueOf(divisor.getHead().getObject()));
            int valueDividendo = Integer.parseInt(String.valueOf(dividendo.getHead().getObject())); 
            
                while(true){ 
                int resta = 0;
                Node lastDivisor= divisor.getTail(); 
                Node lastDividendo = dividendo.getTail();  
                if(dividendo.getSize() < divisor.getSize() || Integer.parseInt(String.valueOf(dividendo.getHead().getObject()))<=0){ 
                    return cociente ; 
                }else{   


                    for (int i = 0; i < divisor.getSize(); i++){ 

                        if(Integer.parseInt(String.valueOf(lastDividendo.getObject()))-Integer.parseInt(String.valueOf(lastDivisor.getObject()))<0){ 
                            restaRecursiva(lastDividendo, Integer.parseInt(String.valueOf(lastDivisor.getObject())) );
                            while(Integer.parseInt(String.valueOf(dividendo.getHead().getObject()))==0){
                                dividendo.remove(dividendo.getHead());
                            }
                        }


                        resta = Integer.parseInt(String.valueOf(lastDividendo.getObject()))-Integer.parseInt(String.valueOf(lastDivisor.getObject()));
                        lastDividendo.setObject(resta);
                        lastDivisor = lastDivisor.getPrevius(); 
                        lastDividendo = lastDividendo.getPrevius(); 
                            }
                        cociente++;
                    }   
                } 
             
        } catch (Exception e) {
            System.out.println("Usted a introducido un valor invalido, sea división entre '0' o un valor vacio ' '. ");
            return 0;
        }
    } 
   
    /*division recursiva se encarga de hacer las sumas para numeros que al restarse den menos de cero recorriendo las listas resultantes
    del primer metodo*/
    static void restaRecursiva(Node dividendo, int resta){
            //este if probablemente vaya en el division recursiva para llamar a este metodo en el momento correcto
             
                if(dividendo.getPrevius()!=null) { 
                    int p = Integer.parseInt(String.valueOf(dividendo.getPrevius().getObject()));  
                    if(Integer.parseInt(String.valueOf(dividendo.getPrevius().getObject()))==0){ 
                        restaRecursiva(dividendo.getPrevius(), resta);
                    } 
                    dividendo.getPrevius().setObject(Integer.parseInt(String.valueOf(dividendo.getPrevius().getObject()))-1);
                     dividendo.setObject(Integer.parseInt(String.valueOf(dividendo.getObject()))+10);   
                 }
        }
    
    
    /**este metodo verifica que los numeros introducidos si pueden ser divididos de los contrario devolvera cero*/
    static boolean comprobarSiDivisibleve(Node dividendo, Node divisor){
        
            int digitoDivisor = Integer.parseInt(String.valueOf(divisor.getObject()));
            int digitoDividendo = Integer.parseInt(String.valueOf(dividendo.getObject()));
                
                if(digitoDividendo<digitoDivisor){
                    return true;
                }else {
                    if(dividendo.getNext()==null){
                        return false;
                    }else{
                        if(digitoDividendo==digitoDivisor){
                           return comprobarSiDivisibleve(dividendo.getNext(), divisor.getNext());
                        }else{
                            return false;
                        }
                    }
                } 
            } 
   

    //Punto_5
    //todos los metodos del punto 5 reciven listas como parametros y con base a esas listas
    //hacen las operaciones necesarias, las guardan en otra lsita y la retornan como resultado.
    
    static int evaluarPolinomio(LinkedList polinomio, int valorX){
        try {
            int valor = 0;
            Node current = polinomio.getHead();
            for (int i = 0 ; i < polinomio.getSize(); i++) {
                int valueCurrent = Integer.parseInt(String.valueOf(current.getObject()));
                if(valueCurrent==0){
                    
                }else{                
                    if(i==0){
                        valor+=valueCurrent;
                    }else{
                        valor += ((Math.pow(valorX, i))*valueCurrent);
                        System.out.println("valor: "+valor);
                        System.out.println("valueCurrent: "+valueCurrent);
                        System.out.println("i: "+i);
                    }
                } 
                current = current.getNext();
            } 
            return valor;
        } catch (Exception e) {
            System.out.println("Usted a introducido un valor invalido");
            return 0;
        }
    }
    
    static LinkedList integrarPolinomio(LinkedList polinomio){
        LinkedList integracionP = new ListaDoble();
        try {
             Node current = polinomio.getHead();
            for (int i = 0 ; i < polinomio.getSize(); i++) {
                int valueCurrent = Integer.parseInt(String.valueOf(current.getObject()));
                if(valueCurrent==0){
                    integracionP.addLast(current);
                }else{                
                    if(i==0){
                        integracionP.addLast(String.valueOf(valueCurrent)+"/"+(i+1));
                    }else{
                        integracionP.addLast(String.valueOf(valueCurrent)+"/"+(i+1));
                    }
                } 
                            current = current.getNext();
            }
            integracionP.addFirst("c");
            integracionP.addFirst("<");
            integracionP.addLast(">");
            return integracionP;
        } catch (Exception e) {
            System.out.println("Usted a introducido un valor invalido");
            return integracionP;
        }
    }
    
    static LinkedList sumarDosPolinomio(LinkedList polinomio1, LinkedList polinomio2){
        LinkedList suma;
        Node current;
        if(polinomio1.getSize()>polinomio2.getSize()){
            suma = polinomio1.clone();
            current = polinomio2.getHead();
        }else{
            suma = polinomio2.clone();
            current = polinomio1.getHead();
        }
        
        Node currentSuma = suma.getHead();
        int longitudMenor = (polinomio1.getSize()>polinomio2.getSize())?polinomio2.getSize():polinomio1.getSize();
        for (int i = 0; i < longitudMenor; i++) {
            int sumaP = Integer.parseInt(String.valueOf(current.getObject()))+Integer.parseInt(String.valueOf(currentSuma.getObject()));
            currentSuma.setObject(sumaP);
            
            current = current.getNext();
            currentSuma = currentSuma.getNext();
        }
        
        return suma;
        
    }
    
    
    
      
}
    
   
    
    
    
    
    
    
    

