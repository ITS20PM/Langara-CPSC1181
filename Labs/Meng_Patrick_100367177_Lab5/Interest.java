/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author zhiru
 */
public class Interest {
    private double p;
    private double r;
    private double i;
    private int n;
    private int t;
    
    public Interest(double p, double r, int n, int t){
        this.p = p;
        this.r = r;
        this.n = n;
        this.t = t;
    }
        
    public double amount(){
        return p*Math.pow(1+r/n, n*t);
    }
    
    public void display(){
        i = amount() - p;
        System.out.println("Principle investment: "+p);
        System.out.println("Total interest earned: "+ i);
        System.out.println("Final Amount: "+amount());
    }
}
