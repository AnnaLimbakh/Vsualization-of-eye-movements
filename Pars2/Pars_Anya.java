/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pars_anya;

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Анна
 */


public class Pars_Anya{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{ //для проблем с доступом к фалу
         FileInputStream stream = new FileInputStream ("smvf_procenko001-002_389_Trial018_Samples.txt");//указать путь к файлу
            InputStreamReader reader = new InputStreamReader ( stream );
            BufferedReader buffered_reader = new BufferedReader ( reader );
            List  <Dannie> AList = new ArrayList(); //создаем "динамический массив" в каждой ячейке которого лежит объект класса Dannie
            String buf;
            
                            
            while ( ( buf = buffered_reader.readLine () ) != null ){//считываем пока не дойдем до конца фала
                
                if(buf.contains(",-")){ //разделяет строку по пробелу
                    String[] mass = buf.split(",");
                    AList.add(new Dannie(Float.parseFloat(mass[3]),Float.parseFloat(mass[4]),"Blink")); //добавляем новый объект класса Dannie в наш лист
                 }
                
                if(buf.contains(",Saccade")){
                    String[] mass = buf.split(",");
                    AList.add(new Dannie(Float.parseFloat(mass[3]),Float.parseFloat(mass[4]),"Saccade"));
                  
                 }
                
                if(buf.contains(",Fixation")){
                    String[] mass = buf.split(",");
                    AList.add(new Dannie(Float.parseFloat(mass[3]),Float.parseFloat(mass[4]),"Fixation"));
                   
                 }
                
                }
            
            
            Dannie first = AList.get(0);
            System.out.println(first.getX());
            System.out.println(first.getY());
            System.out.println(first.getTip());
            
            
            
            buffered_reader.close();
            reader.close();
            stream.close();
        
        }
        catch(IOException IOEx){
            System.out.println(IOEx.toString());
        }
}
}
    


