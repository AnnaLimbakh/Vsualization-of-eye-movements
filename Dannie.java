/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pars_anya;

/**
 *
 * @author mac
 */
public class Dannie {
private int dur;
private float sx,sy,ex,ey;
private String tip;

    public Dannie(int dur, float sx, float sy, float ex, float ey, String tip) {
        this.dur = dur;
        this.sx = sx;
        this.sy = sy;
        this.ex = ex;
        this.ey = ey;
        this.tip = tip;
    }
// getters
    public Dannie(int dur, String tip) {
        this.dur = dur;
        this.tip = tip;
    }

    public int getD() {
        return dur;
    }

    public float getSx() {
        return sx;
    }

    public float getSy() {
        return sy;
    }

    public float getEx() {
        return ex;
    }

    public float getEy() {
        return ey;
    }

    public String getTip() {
        return tip;
    }
    //setters

    public void setDur(int dur) {
        this.dur = dur;
    }

    public void setSx(float sx) {
        this.sx = sx;
    }

    public void setSy(float sy) {
        this.sy = sy;
    }

    public void setEx(float ex) {
        this.ex = ex;
    }

    public void setEy(float ey) {
        this.ey = ey;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Dannie() {
    }
    
    
    
    

    
    
}
