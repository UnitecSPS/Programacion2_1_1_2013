/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

/**
 *
 * @author Gotcha
 */
public class LigaJusticia {
    public static void main(String[] args){
        Villanos vill = new Villanos();
        
        try{
            vill.maldad(true);
            vill.setCrimenes(0);
        }
        catch(ArithmeticException e){
            System.out.println("FALLO EL ATRACO!: " +
                    e.getMessage());
        }
        catch(NullPointerException e){
            System.out.println("No seas bruto instancia Joker");
        }
        catch(Exception e){
            System.out.println("ERROR: " + e.getMessage() + " " +
                    e.getClass());
            e.printStackTrace();
            /*if( e instanceof ArithmeticException ){
                System.out.println("Ocurrio un error mat");
            }
            else if( e instanceof NullPointerException){
                System.out.println("Ta nulo man!");
            }*/
        }
        finally{
            try{
                
            }
            catch(Exception e){
                
            }
            finally{
                System.out.println("FINALLY INTERNO");
            }
            
            System.out.println("SE CORRIO EL FINALLY");
        }
        
        System.out.println("DIA TERMINADO");
    }
}
