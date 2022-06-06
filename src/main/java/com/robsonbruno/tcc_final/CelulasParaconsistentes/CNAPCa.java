/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.robsonbruno.tcc_final.CelulasParaconsistentes;

/**
 *
 * @author Robson Bruno
 */
public class CNAPCa {
    private double a,b;
    private double Gc,Gcc,Gct;
    
    private void grauDeCrencaEContradicao(){
       Gct = (a+b)-1;
       Gc = a - b;
       Gcc = (Gc+1)/2;
    }
    
    public double[] getResultado(double a, double b, double FTct, double FTc){
        this.a = a;
        this.b = 1-b;
        double[] resposta = new double[2];
        
        grauDeCrencaEContradicao();
        double Gct2 = java.lang.Math.abs(this.Gct);
        double Gc2 = java.lang.Math.abs(this.Gc);
        if (Gct2 >= FTct){
            resposta[0] = 0.5;
            resposta[1] = 1;
        }else if ((Gct2 < FTct) && (Gc2 >= FTc)){
            resposta[0] = 0.5;
            resposta[1] = 0;
        }else{
            resposta[0] = Gcc;
            resposta[1] = 0;
        }
        return resposta;
    }
    
     public double getA(){
        return this.a;
    }
    public double getB(){
        return this.b;
    }
    public double getGc(){
        return this.Gc;
    }
    public double getGcc(){
        return this.Gcc;
    }
    public double getGct(){
        return this.Gcc;
    }
}
