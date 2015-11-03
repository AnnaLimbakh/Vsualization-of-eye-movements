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

public class Pars_anya {
    List<Dannie> AList = new ArrayList();
    
    public List<Dannie> getAList(){
        return AList;
    }
    
    /**
     * @param args the command line arguments
     */
    public void pleaseParsItNow(String whatToParse) {
        //"sm002_anatoli002-003_398 Events.txt"
        try{ //для проблем с доступом к фалу
         FileInputStream stream = new FileInputStream (whatToParse);//указать путь к файлу
            InputStreamReader reader = new InputStreamReader ( stream );
            BufferedReader buffered_reader = new BufferedReader ( reader );
             //создаем "динамический массив" в каждой ячейке которого лежит объект класса Dannie
            String buf;
            
                            
            while ( ( buf = buffered_reader.readLine () ) != null ){//считываем пока не дойдем до конца фала
                
                if(buf.contains("Blink L")){
                    String[] mass = buf.split(" "); //разделяет строку по пробелу
                    String[] mass2 = mass[1].split(";");
                    AList.add(new Dannie(Integer.valueOf(mass2[5]),"Blink")); //добавляем новый объект класса Dannie в наш лист
                 }
                
                if(buf.contains("Saccade L")){
                    String[] mass = buf.split(" ");
                    String[] mass2 = mass[1].split(";");
                    AList.add(new Dannie(Integer.valueOf(mass2[5]),Float.parseFloat(mass2[6]),Float.parseFloat(mass2[7]),Float.parseFloat(mass2[8]),Float.parseFloat(mass2[9]),"Saccade"));
                    
                  
                 }
                
                if(buf.contains("Fixation L")){
                    String[] mass = buf.split(" ");
                    String[] mass2 = mass[1].split(";");
                    AList.add(new Dannie(Integer.valueOf(mass2[5]),Float.parseFloat(mass2[6]),Float.parseFloat(mass2[7]),Float.parseFloat(mass2[8]),Float.parseFloat(mass2[9]),"Fixation"));
                   
                 }
                
                }
            
            /*
            Dannie first = AList.get(0);
            System.out.println(first.getD());
            System.out.println(first.getEx());
            System.out.println(first.getEy());
            System.out.println(first.getSx());
            System.out.println(first.getSy());
            System.out.println(first.getTip());
            */
            
            
            buffered_reader.close();
            reader.close();
            stream.close();
        
        }
        catch(IOException IOEx){
            System.out.println(IOEx.toString());
        }
        
    }
}
    

