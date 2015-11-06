/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vizualization_2;

/**
 *
 * @author User
 */
public class Dannie {
    private float x,y;
private String tip;

    public Dannie( float x, float y, String tip) {
        this.x = x;
        this.y = y;
        this.tip = tip;
    }
// getters
    


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }


    public String getTip() {
        return tip;
    }
    //setters



    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }


    public void setTip(String tip) {
        this.tip = tip;
    }

    public Dannie() {
    }
}
