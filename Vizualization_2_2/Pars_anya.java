/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vizualization_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;
import processing.core.PImage;
import java.io.*;

/**
 *
 * @author User
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
        try{ //РґР»СЏ РїСЂРѕР±Р»РµРј СЃ РґРѕСЃС‚СѓРїРѕРј Рє С„Р°Р»Сѓ
         FileInputStream stream = new FileInputStream ("smvf_procenko001-002_389_Trial018 Samples.txt");//СѓРєР°Р·Р°С‚СЊ РїСѓС‚СЊ Рє С„Р°Р№Р»Сѓ
            InputStreamReader reader = new InputStreamReader ( stream );
            BufferedReader buffered_reader = new BufferedReader ( reader );
           //СЃРѕР·РґР°РµРј "РґРёРЅР°РјРёС‡РµСЃРєРёР№ РјР°СЃСЃРёРІ" РІ РєР°Р¶РґРѕР№ СЏС‡РµР№РєРµ РєРѕС‚РѕСЂРѕРіРѕ Р»РµР¶РёС‚ РѕР±СЉРµРєС‚ РєР»Р°СЃСЃР° Dannie
            String buf;
            
                            
            while ( ( buf = buffered_reader.readLine () ) != null ){//СЃС‡РёС‚С‹РІР°РµРј РїРѕРєР° РЅРµ РґРѕР№РґРµРј РґРѕ РєРѕРЅС†Р° С„Р°Р»Р°
                
                if(buf.contains(",Blink")){ //СЂР°Р·РґРµР»СЏРµС‚ СЃС‚СЂРѕРєСѓ РїРѕ РїСЂРѕР±РµР»Сѓ
                    String[] mass = buf.split(",");
                    AList.add(new Dannie(Float.parseFloat(mass[3]),Float.parseFloat(mass[4]),"Blink")); //РґРѕР±Р°РІР»СЏРµРј РЅРѕРІС‹Р№ РѕР±СЉРµРєС‚ РєР»Р°СЃСЃР° Dannie РІ РЅР°С€ Р»РёСЃС‚
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
