/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.algoritmosmaven;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Software Student
 */
public class EXAMENDEMM {
    public int[][] leerArchivo(File file){
    int[][] matriz=null;
    int contadorFila=0, catColumna=0;
    Scanner s=null;
        try {
            s=new Scanner(file);
            while (s.hasNextLine()) {                
                String linea=s.nextLine();
                if (contadorFila==1) {
                    String[] vector=linea.split("\t");
                    catColumna=vector.length;
                }
                contadorFila++;
            }
            
            
            s=new Scanner(file);
            matriz=new int[contadorFila-1][catColumna];
            contadorFila=0;
            
            while (s.hasNextLine()) {                
                String linea=s.nextLine();
                if (contadorFila!=0) {
                    String[] vector=linea.split("\t");
                    for (int i = 0; i < vector.length; i++) {
                        matriz[contadorFila-1][i]=Integer.parseInt(vector[i].trim());
                    }
                }
                contadorFila++;
            }                                    
        } catch (IOException e) {
        }finally{
            try {
                s.close();
            } catch (Exception e) {
            }
        }            
    return matriz;
    }
    
    public void imprimirMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println("");
        }
    }
    public void escribirArchivo(String[] head, int[][] data, String nameFile){
        Writer out=null;
        int contador=0;
        try {
        String url=System.class.getResource("/").getFile().replaceAll("%20", " ");
            System.out.println("Ruta:"+url);
            String[] urlReal=url.split("target");
            out=new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(urlReal[0]+"src/main/resources/"+nameFile),"UTF-8"));
            if (head!=null && data!=null) {
                
            }else if(head==null && data!=null){
                for (int i = 0; i < data.length; i++) {
                    for (int j = 0; j < data[0].length; j++) {
                        try {
                            out.write(data[i][j]+"\t");
                            if (i<data.length-1) {
                                if(j==data[0].length-1){
                                out.write("\n");
                                }
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }else{
                System.out.println("Los parametros de entrada estan vacios");
            }
            
        } catch (Exception e) {
        }finally{
            try {
                out.close();
            } catch (Exception e) {
            }
        }    
    }
    public int[][] transformada06DEMM(int dim, int numIint){
        int[][] matriz=new int[dim][dim];
        int contador=0;
        for (int i = 0; i < matriz.length;i++) {
            for (int j = 0; j < matriz[0].length; j++){
                if(contador<=i){
                    matriz[i][j]=numIint;
                    numIint++;
                    contador++;
                }else{
                matriz[i][j]=-1;
                }
            } contador=0;
        }
        
       return matriz; 
    }
    public int[][] transformada09DEMM(int dim, int numIint){
        int[][] matriz=new int[5][5];
        int contador=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = matriz[0].length-1; j>=0; j--) {
                if(contador<=i){
                    matriz[i][j]=numIint;
                    numIint++;
                    contador++;
                }else{
                matriz[i][j]=-1;
                }
            } contador=0;
        }        
    return matriz;
    }
    public int[][] transformada12DEMM(int dim, int numIint){
        int[][] matriz=new int[dim][dim];
        int contador=0;
        
        for (int i = 0; i < matriz.length;i++) {
            for (int j = matriz[0].length-1; j>=0; j--){
            
                if(j<dim-i){
                    matriz[i][j]=numIint;
                    numIint++;
                    contador++;
                }else{
                matriz[i][j]=-1;
                }
            } contador=0;
        }
        
       return matriz; 
    }
    public int[][] transformada26DEMM(int dim, int numIint){
        int contador=0;
          int[][] matriz=new int[dim][dim];
          for (int x = 0; x < matriz.length; x++) {
              if(contador%2==0){
                  for (int y = 0; y < matriz[0].length; y++) {
                      matriz[x][y]=numIint;
                      numIint++;
                  }
              }else{
                  for (int y = matriz[0].length-1; y >=0; y--) {
                      matriz [x][y]=numIint;
                      numIint++;
                  }
              }
              contador++;
        }
        return matriz;
    }
    public int[][] transformada30DEMM(int dim, int numIint){
        int[][] matriz=new int[dim][dim];
        for (int c = 0; c < dim/2; c++) {
                  
            for (int ldx = c; ldx < dim-c-1; ldx++) {
                matriz[ldx][dim-1-c]=numIint;
                numIint++;                
            }
            for (int lix = dim-c-1; lix > c; lix--) {
                matriz[dim-1-c][lix]=numIint;
                numIint++;                
            }
            for (int lxx = dim-c-1; lxx > c; lxx--) {
                matriz[lxx][c]=numIint;
                numIint++;                
            }
            for (int lsx = c; lsx < dim-c-1; lsx++) {
                matriz[c][lsx]=numIint;
                numIint++;
            }      
        }
        
        if(dim%2!=0){
        matriz[dim/2][dim/2]=numIint--;
        }
        
        return matriz;
     }
    
    public static void main(String[] args) {
        EXAMENDEMM lea=new EXAMENDEMM();//Objeto lea
        URL fileUrl=System.class.getResource("/02-exemplo7.txt");
        System.out.println("Ruta:"+fileUrl.getFile());
        System.out.println("Ruta real:"+fileUrl.getFile().replaceAll("%20", " "));
        lea.imprimirMatriz(lea.leerArchivo(new File(fileUrl.getFile().replaceAll("%20", " "))));        
        System.out.println("Escribir Archivos");
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingree la Dimension de la Matriz:");
        int dimM=sc.nextInt();
        System.out.println("Ingrese el numero de Inicio");
        int numInic=sc.nextInt();        
        lea.escribirArchivo(null, lea.transformada06DEMM(dimM, numInic), "Transformadas06DEMM.txt");
        lea.escribirArchivo(null, lea.transformada09DEMM(dimM, numInic), "Transformadas09DEMM.txt");
        lea.escribirArchivo(null, lea.transformada12DEMM(dimM, numInic), "Transformadas12DEMM.txt");
        lea.escribirArchivo(null, lea.transformada26DEMM(dimM, numInic), "Transformadas26DEMM.txt");
        lea.escribirArchivo(null, lea.transformada30DEMM(dimM, numInic), "Transformadas30DEMM.txt");
        
    }
    
    
    
}
