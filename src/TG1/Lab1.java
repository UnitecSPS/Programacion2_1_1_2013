/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TG1;
import java.util.Scanner;
/**
 *
 * @author Immac
 */
public class Lab1 {

//Hacer un clase que tenga un arreglo unidimesional de enteros. En el constructor se inicializa con una longitud que recibe de parametro.
 public int[] num;
 private Scanner read = new Scanner(System.in);
 
 public Lab1(int longitud){
     this.num = new int[longitud];
 }
 
 private void LlenarArreglo(int index){
     
    if(this.num.length > index){
        System.out.println("Ingrese un entero para la posicion " + (index+1));
        this.num[index] = read.nextInt();
        LlenarArreglo(index+1);
    }
     
 }
 
 public void LlenarArreglo(){
     LlenarArreglo(0);
 }
 
 private void Imprimir(int index){
   if(this.num.length > index){
       System.out.println(this.num[index]);
       Imprimir(index+1);
   }
     
 }
  public void Imprimir(){
      Imprimir(0);
  }

private boolean BuscarNum(int num,int index){
    
   if(this.num.length > index){
       
       if(num == this.num[index]){
           return true;
       }
       return BuscarNum(num,index+1);
       
   }
   return false;
    
}
  

public boolean BuscarNum(int num){
   return BuscarNum(num,0);
}

private int Suma(int index){
     if(this.num.length > index){
         return this.num[index] + Suma(index+1);
     }
     return 0;
}

public int Suma(){
    return Suma(0);
}

}
    
