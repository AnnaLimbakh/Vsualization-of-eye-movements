/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pars_anya;

import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author User
 */
public class JavaApplication1 extends PApplet{
    
    public static void main(String[] args){
        PApplet.main(new String[]{"pars_anya.JavaApplication1"});
    }

    PImage img1 = createImage(1024,1024,RGB);
    
    Pars_anya superParser = new Pars_anya();
    
    int num=40, movers=3, d3=25, frames=120;
    float angle, theta, d,d2;
    int i=1;
    int duration=10;
           
    @Override
    public void setup() {
        size(1300, 700);
        img1 = loadImage("thegreatwar1.jpg");
        image(img1,0,0);
        
        superParser.pleaseParsItNow("sm002_anatoli002-003_398 Events.txt");
    }

    @Override
    public void draw() {
                
        ellipseMode(CENTER);
        Dannie D1 = superParser.getAList().get(i);
        Dannie D2 = new Dannie();
        if(i>0)
        {
            D2 = superParser.getAList().get(i-1);
        }
        if (frameCount == duration ){
        i++;
        duration+=D1.getD()/20000;
        }
        System.out.println("i"+i);
        System.out.println("fr"+frameCount);
        System.out.println("dur"+duration + D1.getD()/10000);
        
       
           if ( D1.getTip() == "Fixation") {
               strokeWeight(3);
               stroke(250,0,0,250);
               fill(250,250,250,250);
               if(((float) D1.getEx()!=0)&&((float)D1.getEy()!=0)&&((float) D1.getSx()!=0)&&((float) D1.getSy()!=0) && ((float) D1.getEx()<1000)&&((float)D1.getEy()<1000)&&((float) D1.getSx()<1000)&&((float) D1.getSy()<1000))
               {
               ellipse((float) D1.getSx(), (float) D1.getSy(), 2,2);
               fill(250,0,0,50);
               ellipse((float) D1.getSx(), (float) D1.getSy(),(float) D1.getEx(), (float)D1.getEy());
               }
                     // System.out.print((float) D1.getEx()+"|");
                      //System.out.print((float) D1.getEy()+"\n");
                     // System.out.print((float) D1.getSx()+"|");
                     // System.out.print((float) D1.getSy()+"\n");
               //fCounter++;
           }
           if (D1.getTip() == "Saccade"){
                      stroke(50,150,100,150);
                      strokeWeight(1);
                      strokeCap(SQUARE);
                      if(((float) D1.getEx()!=0)&&((float)D1.getEy()!=0)&&((float) D1.getSx()!=0)&&((float) D1.getSy()!=0))
                      {
                        line((float) D1.getEx(), (float)D1.getEy(), (float) D1.getSx(), (float) D1.getSy());
                      }
                      //System.out.println((float) D1.getEx());
                      //System.out.println((float)D1.getEy());
                      //System.out.println((float) D1.getSx());
                     // System.out.println((float) D1.getSy());
                      //sCounter++;
                   
           }
           if ( D1.getTip() == "Blink"){
               
               noStroke();
               fill(0,0,0,0);
               if (i>0){               
                  // ellipse((float)D2.getEx(), (float) D2.getEy(), 10, 10);
               }
           }
         
        
       }
       //print(fCouner);
      // print(sCounet);
    }
