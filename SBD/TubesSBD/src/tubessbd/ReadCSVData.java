package tubessbd;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
public class ReadCSVData {
    
    public ArrayList<Table> CreateTab(){
        String CSVFile = "C:/Users/GL553VD/Downloads/Documents/SBD/Table.txt";   //PathFile
        String line="#";
        String spliter = " ";
        ArrayList<Table> table = new ArrayList<Table>();
        
        try (BufferedReader br=new BufferedReader(new FileReader(CSVFile))){
           while ((line=br.readLine())!=null){
               String[] TableName=line.split(spliter);
               Table tab = new Table(TableName[0]);
               for (int i=1; i<TableName.length;i++){
                   if(i==TableName.length-1){
                       String[] A = TableName[i].split("#");
                       tab.AddCol(A[0]);
                   } else{
                       tab.AddCol(TableName[i]);
                   }
               }
               table.add(tab);
           }
        } catch (IOException e){
            e.printStackTrace();
        }
        return table;
    }
    
}
