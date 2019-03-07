package tubessbd;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GL553VD
 */
public class Table {
    public String judul;
    public ArrayList<String> kolom;
    
    public Table(String nama){
        this.judul = nama;
        this.kolom = new ArrayList<String>();
    }
    
    public String getJudul(){
        return judul;
    }
    
    public void AddCol(String NCol){
        kolom.add(NCol);
    }
    
    public void View(){
        System.out.print("Col : ");
        for (int i=0;i<=kolom.size()-1;i++){
            System.out.print(kolom.get(i)+", ");
        }
        System.out.println("");
    }
    
    public void ViewS(String x){
        String[] S = x.split(",");
        System.out.print("Col : ");
        for (int i=0;i<=kolom.size()-1;i++){
            for (int j=0;j<S.length;j++){
                if(kolom.get(i).equalsIgnoreCase(S[j])){
                    System.out.print(kolom.get(i)+", ");
                }
            }
        }
        System.out.println("");   
    }
    
    
}
