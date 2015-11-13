/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vizualization_2;

import processing.core.PApplet;
import processing.core.PImage;
import controlP5.*;
/**
 *
 * @author User
 */
public class JavaApplication1 extends PApplet{
    
    public static void main(String[] args){
        PApplet.main(new String[]{"vizualization_2.JavaApplication1"});
    }

    PImage img1;// = createImage(1024,1024,RGB);
    
    Pars_anya superParser = new Pars_anya();
    
    int num=40, movers=3, d3=25, frames=120;
    float angle, theta, d,d2;
    int i=0;
    float sx_s = -1;
        float sy_s = -1;
        float ex_s = -1;
        float ey_s = -1;
        int dur = 1;
        float speed = 1;
        float rad = 0;
        float opa = 1;
        //Slider
        ControlP5 cp5;
        int myColor1 = color(250,0,0);
        int myColor2 = color(0,0,0);
        int myColor3 = color(150,0,0);

        int sliderValue = 100;
        int sliderTicks1 = 100;
        int sliderTicks2 = 30;
        Slider abc;
    //int duration=10;
           
    @Override
    public void setup() {
        size(1920, 1080);
     
        
        superParser.pleaseParsItNow("EMIP3_2_1 (1)_ARU-P05_005 Samples.txt");
        //Slider
        cp5 = new ControlP5(this);
        cp5.addSlider("sliderValue")
        .setPosition(50,50)
        .setSize(200,30)
        .setRange(1,10)
        .setColorActive(myColor1)
        .setColorBackground(myColor2) 
        .setColorForeground(myColor3)
        ;
        
        cp5.addSlider("sliderValue1")
        .setPosition(50,100)
        .setSize(200,30)
        .setRange(10,80)
        .setColorActive(myColor1)
        .setColorBackground(myColor2) 
        .setColorForeground(myColor3)
        ;
        
        cp5.addSlider("sliderValue2")
        .setPosition(50,150)
        .setSize(200,30)
        .setRange(1,10)
        .setColorActive(myColor1)
        .setColorBackground(myColor2) 
        .setColorForeground(myColor3)
        ;
                img1 = loadImage("ScanPath.jpg");
                image(img1,0,0);
        
        
        
         
        
    }

    @Override
    public void draw() {
        opa = cp5.getValue("sliderValue2");
        /*for(int i =0;i<img1.pixels.length; i++) {
        img1.pixels[i] = color(red(img1.pixels[i]), green(img1.pixels[i]),blue(img1.pixels[i]),10); 
        }*/
        tint (255,opa);
           /* img1.updatePixels();*/
        image(img1,0,0);
    
           
        ellipseMode(CENTER);
        
speed = 11-cp5.getValue("sliderValue");

        Dannie D1 = superParser.getAList().get(i);
        Dannie D2 = new Dannie();
       if (i<superParser.getAList().size()){
         D2 = superParser.getAList().get(i+1);}
        
        if (frameCount%50 == 0){
            image(img1,0,0);
        }
        if (frameCount == dur){
        i++;
        dur+=speed;
       // }
       /* System.out.println("i"+i);
        System.out.println("fr"+frameCount);
        System.out.println("dur"+duration + D1.getD()/10000);**/
        
        
        
       
           if ( D1.getTip() == "Fixation") {
               strokeWeight(1);
               noStroke();
               fill(250,0,0,5);
               rad = cp5.getValue("sliderValue1");
               if(((float) D1.getX()!=0)&&((float)D1.getY()!=0))
               {
               ellipse((float) D1.getX(), (float) D1.getY(), rad,rad);
               }
                     // System.out.print((float) D1.getEx()+"|");
                      //System.out.print((float) D1.getEy()+"\n");
                     // System.out.print((float) D1.getSx()+"|");
                     // System.out.print((float) D1.getSy()+"\n");
               //fCounter++;
           }
           if (D1.getTip() == "Saccade"){
                      stroke(50,150,100,250);
                      strokeWeight(3);
                      strokeCap(SQUARE);
                      if(sx_s == -1 ){
                          if ((D1.getX() != 0) && (D1.getY()!=0)){
                      sx_s = D1.getX();
                      sy_s = D1.getY();}}
                      if ((D1.getX() != 0) && (D1.getY()!=0)){
                      ex_s = D1.getX();
                      ey_s = D1.getY();}
                      if(D2.getTip()!="Saccade"){
                          
                      
                          line(sx_s, sy_s, ex_s, ey_s);
                          sx_s = -1;
                          sy_s = -1;

                     /* System.out.println("sx" + sx_s);
                      System.out.println("sy" +sy_s);
                      System.out.println("ex" +D1.getX());
                      System.out.println("ey" +D1.getY());*/
                      }
                     
                      
                                           
                      
                      //System.out.println((float) D1.getEx());
                      //System.out.println((float)D1.getEy());
                      //System.out.println((float) D1.getSx());
                     // System.out.println((float) D1.getSy());
                      //sCounter++;
                   
           }
           if ( D1.getTip() == "Blink"){
               System.out.println("Blink");
               System.out.println((float) D1.getX());
               System.out.println((float)D1.getY());
               noStroke();
               fill(0,0,0,50);
               if ((D1.getX() != 0) && (D1.getY()!=0)){               
                  ellipse((float)D1.getX(), (float) D1.getY(), 20, 20);
               }
           }
         
        
       }
       //print(fCouner);
      // print(sCounet);
    }
}
