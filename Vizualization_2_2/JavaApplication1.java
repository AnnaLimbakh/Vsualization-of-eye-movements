/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vizualization_2;

import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author User
 */
public class JavaApplication1 extends PApplet{
    
    public static void main(String[] args){
        PApplet.main(new String[]{"vizualization_2.JavaApplication1"});
    }

    PImage img1 = createImage(1024,1024,RGB);
    
    Pars_anya superParser = new Pars_anya();
    
    int num=40, movers=3, d3=25, frames=120;
    float angle, theta, d,d2;
    int i=0;
    float sx_s = -1;
        float sy_s = -1;
        float ex_s = -1;
        float ey_s = -1;
        int dur = 1;
        int speed = 1;
    //int duration=10;
           
    @Override
    public void setup() {
        size(1300, 700);
        img1 = loadImage("thegreatwar1.jpg");
        image(img1,0,0);
        
        superParser.pleaseParsItNow("smvf_procenko001-002_389_Trial018_Samples.txt");
         
    }

    @Override
    public void draw() {
        
             
        ellipseMode(CENTER);
        strokeWeight(3);
               stroke(0,0,250,250);
               fill(250,250);
        rect(50,50,200,30);
        if((mouseX >=50)&&(mouseX<=230)&&(mouseY>=50)&&(mouseY<=80)){
            fill(0,0,250,250);
            noStroke();
        rect(mouseX,50,30,30);
        speed = 10 - mouseX/30;
        
        }
        else{
            fill(0,0,250,250);
            noStroke();
        rect(220,50,30,30);
        speed = 1;
        }
        Dannie D1 = superParser.getAList().get(i);
        Dannie D2 = new Dannie();
       if (i<superParser.getAList().size()){
         D2 = superParser.getAList().get(i+1);}
        
        
        if (frameCount == dur){
        i++;
        dur+=speed;
       // }
       /* System.out.println("i"+i);
        System.out.println("fr"+frameCount);
        System.out.println("dur"+duration + D1.getD()/10000);**/
        
       
           if ( D1.getTip() == "Fixation") {
               strokeWeight(1);
               stroke(250,0,0,150);
               fill(250,0,0,150);
               if(((float) D1.getX()!=0)&&((float)D1.getY()!=0))
               {
               ellipse((float) D1.getX(), (float) D1.getY(), 9,9);
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
               fill(0,0,0,150);
               if ((D1.getX() != 0) && (D1.getY()!=0)){               
                  ellipse((float)D1.getX(), (float) D1.getY(), 20, 20);
               }
           }
         
        
       }
       //print(fCouner);
      // print(sCounet);
    }
}
