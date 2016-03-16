/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam_practica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 *
 * @author Gamers
 */
public class Codejam_practica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        int num_caso = 0;
        int c = 0;
        int l = 0;
        Object[][] casos = null;
        String linea = "";
        File archivo = null;
        try {
            archivo = new File("/Users/Gamers/Downloads/A-large-practice.in");
            FileReader read = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(read);
            num_caso = Integer.parseInt(buffer.readLine());
            casos = new Object[num_caso][3];
            int count_linea = 0;
            System.out.println("prueba de datos:");
            while(linea != null) {
                //comienza a leer desde la 2 linea hacia habajo
                String []datos = {buffer.readLine(), buffer.readLine(), buffer.readLine()};
                //obtengo e lultimo dato del array para que cuando lea otravez, lea desde el ultimo hacia el suguiente
                linea = datos[datos.length - 1];
                if(linea == null){
                    //salida del ciclo while cuando ya no hay mas lineas por leer
                    break;
                }else{
                    casos[count_linea] = datos;
                    //verifico los elementos que se hayan insertado correctamente
                    String[] names = {"credito", "cantidad_articlulos", "Precio de articlulos"};
                    for (int i = 0; i < casos[count_linea].length; i++) {
                        System.out.println("caso: " + (count_linea  + 1) + ", " + names[i] + " " + casos[count_linea][i]);
                    }
                }
                count_linea++;
            }
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finaliza prueba de datos \n");
            System.out.println("Resultados:");
        }
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            archivo = new File("c:/prueba.txt");
            fichero = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fichero);
            pw = new PrintWriter(bw);
            for (int i = 0; i < casos.length; i++) {
                c = Integer.parseInt(casos[i][0].toString());
                l = Integer.parseInt(casos[i][1].toString());
                String[] separate = casos[i][2].toString().split(" ");
                StringTokenizer tokens = new StringTokenizer(casos[i][2].toString());
                String[] resu = new String[2];
                String resultados = "";
                for (int j = 0; j < l; j++) {
                    int pos = j;
                    boolean suma = false;
                    for (int k = 0; k < separate.length; k++) {
                        if(pos != k){
                            if(Integer.parseInt(separate[k]) + Integer.parseInt(separate[pos]) == c){
                                if(k < pos){
                                    resu[0] = "Case #" + (i + 1) + ":";
                                    resu[1] = "" + (k + 1) + " "+ (pos + 1) + "";
                                }else{
                                    resu[0] = "Case #" + (i + 1) + ":";
                                    resu[1] = "" + (pos + 1) + " " + (k + 1) + "";
                                }
                                suma = true;
                                break;
                            }
                        }else{
                            //si la posicion al sumar es igual al mismo me salgo para que no sume la misma posicion
                            continue;
                        }
                    }
                    if(suma != false){
                        break;
                    }
                }
                //muestro los resultados
                for (int res = 0; res < resu.length; res++) {
                    resultados += resu[res] + " ";
                    if(res >= resu.length - 1){
                        System.out.println("" + resultados);
                        //los copio uno por uno
                        pw.println(resultados);
                    }
                }
            }
            pw.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
