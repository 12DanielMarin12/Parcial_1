 
package parcial;
 
import proyectostructure.LinkedList; 
import proyectostructure.ListaSimple;
import proyectostructure.Node;

public class Parcial {
 
    public static void main(String[] args) {
        
        //-------PUNTO 1--------------------------------------------------------------------------------
        System.out.println("PUNTO 1");
        
        ListaSimple A = new ListaSimple();
        ListaSimple B = new ListaSimple();      
       
        String[] a = new String[] {"g","a","t","a","c","a","o","c","g","t","a","c","g","t","t","a","c","a","g","t","c","a","c","c","a","t","d"};//ESTOS SON LOS CONJUNTOS QUE SE OPERAN
        String[] b = new String[] {"t","a","t","c","a","a","t","c","a","a","c","a","t","a","a","a","t","t","c","a","c","a","t"};                
        
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]); 
        }
        for (int i = 0; i < b.length; i++) {
            B.add(b[i]); 
        }
         
        System.out.println("A:  " + A);
        System.out.println("B:  " + B);
        
        System.out.println("Operaciones");
        
        //SE UTILIZARON LISTAS SIMPLEAS PARA ALMACENAR LOS RESULTADOS DE LAS OPERACIONES
        
        LinkedList Q = interseccion_Dos_Conjuntos(A, B);
        System.out.println("A+B:  " + Q);
        
        LinkedList Q1 = diferencia_Dos_Conjuntos(A, B);
        System.out.println("A-B: " + Q1);

        
        //-------PUNTO 2---------------------------------------------------------------------------------
        System.out.println("\n\nPUNTO 2");
        
        LinkedList A2 = new ListaSimple();
        int[] a2 = new int[]{1,2,3,4,5,6,7,8,9};//DATOS QUE SE USARAN PARA LA MODA, FRECUENCIA, MEDIANA Y PROMEDIO
        for (int i = 0; i < a2.length; i++) {
            A2.add(a2[i]); 
        }
         System.out.println("lista:      " + estadistica(A2, 3));
         
         
        //-------PUNTO 3---------------------------------------------------------------------------------
        System.out.println("\n\nPUNTO 3\n");
       
        String bi = "111010011001011101100001"; 
        String oc = "123421"; 
        String hex = "7266483FDA";
        System.out.println("Conversiones: " + sistemasNumericos(bi, oc, bi, hex));
        
        
        
        
        //-------PUNTO 3--------------------------------------------------------------------------------- 
        System.out.println("\n\nPUNTO 4"); 
        
        String val1 = "22";
        String val2 = "9234";
        System.out.println(calculadora(val1, val2));
        
        
        System.out.println("\n\nPUNTO 5"); 

         

   
       
    }
    
    //Punto_1
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
    public static LinkedList estadistica(LinkedList A, int B){
        LinkedList n = new ListaSimple(); 
         n.add("promedio = " + promedio(A));
         n.add("mediana = " + mediana(A));
         n.add("moda =" + moda(A));
         n.add("frecuencia = " + frecuencia(A, 3));
         
         return n;
    }
    
    public static float promedio(LinkedList A){
       float tot = (float)A.sumaLista(); 
       return tot/A.getSize();
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
    
    static LinkedList sistemasNumericos(String biOc, String ocBi, String biHex, String hexBi){
        LinkedList n = new ListaSimple();
        n.add("Binario->Octal:  " +binarioOctal(biOc));
        n.add("Octal->Binario:  " +octalBinario(ocBi));
        n.add("Binario->Hexadecimal:  " + binarioHexadecimal(biHex));
        n.add("Hexadecimal->Binario:  " +hexadecimalBinario(hexBi));
        return n;
    }
    
    static String binarioOctal(String binario){ 
        if(binario.length()%3!=0){
            String clone="";
            switch(binario.length()%3){
                case 2: clone+="0";
                        break;
                case 1: clone+="0";
                        clone+="0";
                        break;
            }
            clone+=binario;
            binario = clone;
        }
        
        String octal = "";
        int f = 0, i = 0, l = 3;
        
        while (i < binario.length()/3) {
  
            String c = binario.substring(f,l); 
            switch (c) {
            case "000":
                octal += "0";
                break;
            case "001":
                octal += "1";
                break;
            case "010":
                octal += "2";
                break;
            case "011":
                octal += "3";
                break;
            case "100":
                octal += "4";
                break;
            case "101":
                octal += "5";
                break;
            case "110":
                octal += "6";
                break;
            case "111":
                octal += "7";
                break;
            default:
               return "Invalid Octal Digit " +"'"+ c + "'" ;
            }
            i++;
            f+=3;
            l+=3;
        }
        return octal;
    }

    static String octalBinario(String octal){ 
        int i = 0; 
        String binario = ""; 
        while (i < octal.length()-1) {
  
            char c = octal.charAt((int)i); 
            switch (c) {
            case '0':
                binario += "000";
                break;
            case '1':
                binario += "001";
                break;
            case '2':
                binario += "010";
                break;
            case '3':
                binario += "011";
                break;
            case '4':
                binario += "100";
                break;
            case '5':
                binario += "101";
                break;
            case '6':
                binario += "110";
                break;
            case '7':
                binario += "111";
                break;
            default:
                return "Invalid Octal Digit " + c;
            }
            i++;
        }
        return binario;
    }

    static String binarioHexadecimal(String binario){
        
        String octal = "";
        int f = 0, i = 0, l = 4; 
        String hexa = "";
        
         if(binario.length()%4!=0){
            String clone="";
            switch(binario.length()%3){
                
                case 3: clone+="0";
                        break;
                case 2: clone+="0";
                        clone+="0";
                        break;
                case 1: clone+="0";
                        clone+="0";
                        clone+="0";
                        break;
               
            }
             
            clone+=binario;
            binario = clone;
        }         
         
        while (i < binario.length()/4) {
  
            String c = binario.substring(f,l); 
            switch (c) {
            case "0000":
                hexa += "0";
                break;
            case "0001":
                hexa += "1";
                break;
            case "0010":
                hexa += "2";
                break;
            case "0011":
                hexa += "3";
                break;
            case "0100":
                hexa += "4";
                break;
            case "0101":
                hexa += "5";
                break;
            case "0110":
                hexa += "6";
                break;
            case "0111":
                hexa += "7";
                break;
            case "1000  ":
                hexa += "8";
                break;
            case "1001":
                hexa += "9";
                break;
            case "1010":
                hexa += "A";
                break;
            case "1011":
                
                hexa += "B";
                break;
            case "1100":
                hexa += "C";
                break;
            case "1101":
                hexa += "D";
                break;
            case "1110":
                hexa += "E";
                break;
            case "1111":
                hexa += "F";
                break;
            default:
                return "\nInvalid Octal Digit " + "'" + c + "'";
            }
            i++;
            f+=4;
            l+=4; 
        }
        return hexa;
    }
    
    static String hexadecimalBinario(String hexadecimal){
               
        hexadecimal = hexadecimal.toUpperCase(); 
        String hexa = "";
        int i = 0;  
             
        while (i < hexadecimal.length()) {
  
            char c = hexadecimal.charAt(i); 
            switch (c) {
            case '0':
                hexa += "0000";
                break;
            case '1':
                hexa += "0001";
                break;
            case '2':
                hexa += "0010";
                break;
            case '3':
                hexa += "0011";
                break;
            case '4':
                hexa += "0100";
                break;
            case '5':
                hexa += "0101";
                break;
            case '6':
                hexa += "0110";
                break;
            case '7':
                hexa += "0111";
                break;
            case '8':
                hexa += "1000";
                break;
            case '9':
                hexa += "1001";
                break;
            case 'A':
                hexa += "1010";
                break;
            case 'B': 
                hexa += "1011";
                break;
            case 'C':
                hexa += "1100";
                break;
            case 'D':
                hexa += "1101";
                break;
            case 'E':
                hexa += "1110";
                break;
            case 'F':
                hexa += "1111";
                break;
            default:
                return "\nInvalid hexadecimal Digit " + "'" + c + "'";
            }
            i++;  
        }
        return hexa;

    }
    
    //Punto_4-------------------
    
    static LinkedList calculadora(String I, String O){
        LinkedList n = new ListaSimple();
        n.add("Suma = " + suma(I, O));
        return n;
    }
    
    static String suma(String I, String O){
        
        String may = (I.length()>O.length())?I:O;
        String men = (I.length()<O.length())?I:O;
        String sum = "";
        String tempR =""; 
        int longitudmayor = may.length()-1;
        int temp = 0;
        String clone = "";
        
        
        if(I.length()!=O.length()){
             int dif = may.length()-men.length();
             for (int i = 0; i < dif; i++) {
                clone+="0";
            } 
            clone += men;
            men = clone;
        } 
         
        for (int i = 0; i < men.length(); i++) {
            
            int b = (Integer.parseInt(Character.toString(may.charAt(longitudmayor)))+Integer.parseInt(Character.toString(men.charAt(longitudmayor--))));
            b += temp;
            temp = b/10;
            tempR= b%10+sum;
            sum = tempR; 
            if(i==1 && temp!=0){
                sum = temp+tempR;
            }
        } 
        
        while(Character.toString(sum.charAt(0)).equals("0")){
            sum = sum.substring(1,sum.length());
        }
        return ""+sum;
    }
    
     
    
    
    
    
   


}









    
    
    
    
    
    
    
    
    

