/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubessbd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author GL553VD
 */
public class TubesSBD {

    /**
     * @param args the command line arguments
     */
    public static boolean Valid(String Q){
        boolean valid = false;
        int i = 0;
        if (Q.charAt(Q.length()-1) == ';'){
            valid = true;
            while(i!= Q.length()-2){
             if (Q.charAt(i)== ';'){
                 valid = false;
             }
             i++;
            }
        }
        return valid;
    }
    
    public static void Query(String Q, ArrayList<Table> T){
        String[] SQuery = Q.split(" ");
        String[] X = SQuery[SQuery.length-1].split(";");
        SQuery[SQuery.length-1] = X[0];
        int i=0;
        while(i<T.size() && !(T.get(i).getJudul().equals(SQuery[3]))){
            i++;
        }
        if (SQuery[0].equals("select")&& SQuery[2].equals("from") && SQuery.length == 4 ){
            if(T.get(i).getJudul().equals(SQuery[3])){
                if (SQuery[1].equals("*")){
                    System.out.println("Tabel : "+T.get(i).getJudul());
                    T.get(i).View();
                }else if (T.get(i).kolom.contains(SQuery[1])){
                    System.out.println("Tabel : "+T.get(i).getJudul());
                    T.get(i).ViewS(SQuery[1]);
                }else if(T.get(i).kolom.contains(SQuery[1]) && SQuery[1].contains(",")){
                    System.out.println("Tabel : "+T.get(i).getJudul());
                    T.get(i).ViewS(SQuery[1]);
                }else{
                    System.out.println("SQL Syntax Error");
                }
            }else{
                System.out.println("SQL Syntax Error");
            }
        }
        else if(SQuery[0].equals("select")&& SQuery[2].equals("from") && SQuery[4].equals("join") && SQuery[6].equals("using")){    
            int j=0;
            while(j<T.size() && !(T.get(j).getJudul().equals(SQuery[5]))){
                j++;
            }
            if(T.get(i).getJudul().equals(SQuery[3]) && T.get(j).getJudul().equals(SQuery[5])){
                if(SQuery[1].contains(SQuery[1])){
                    System.out.println("Tabel 1 : "+T.get(i).getJudul());
                    T.get(i).ViewS(SQuery[2]);
                    System.out.println("Tabel 2 : "+T.get(j).getJudul());
                    T.get(j).ViewS(SQuery[2]);
                }else{
                    System.out.println("SQL Syntax Error");
                }
            }else{
                System.out.println("SQL Syntax Error");
            }
        }else{
            System.out.println("SQL Syntax Error");
        }
    }
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        ReadCSVData read = new ReadCSVData();
        ArrayList<Table> Tab = read.CreateTab();
        System.out.println("Note : query tanpa capslock");
        System.out.print("Masukan query : ");
        Scanner A = new Scanner(System.in);
        String query = A.nextLine();
        A.close();
        query=query.trim();
        boolean V = Valid(query);
        if (V==true){
            Query(query, Tab);
        }else{
            System.out.println("SQL Error (Missing ; )");
        }
    }
}
