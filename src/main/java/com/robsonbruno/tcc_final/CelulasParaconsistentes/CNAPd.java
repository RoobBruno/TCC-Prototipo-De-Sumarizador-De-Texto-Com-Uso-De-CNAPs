/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.robsonbruno.tcc_final.CelulasParaconsistentes;

/**
 *
 * @author Robson Bruno
 */
public class CNAPd {
    private double a,b;
    private double FTct, FTd;
    private double Gcc,Gct,Lf,Lv;

    public double getGcc() {
        return Gcc;
    }

    public double getGct() {
        return Gct;
    }
    
    private void grauDeCrencaEContradicao(){
       Gct = (a+b)-1;
       Gcc = ((a-b)+1)/2;
    }
    
    private void limites(){
       Lf = (1 - FTd)/2;
       Lv = (1 + FTd)/2;
    }
    
    public String getResultado (double a, double b, double FTct, double FTd){
        this.a = a;
        this.b = b;
        this.FTct = FTct;
        this.FTd = FTd;
        
        grauDeCrencaEContradicao();
        limites();
        double ct = java.lang.Math.abs(Gct);
        if(ct>=FTct){
            return "Inconsistente";
        }else{
            if (Gcc <= Lf){
                return "Falso";
            }else if(Gcc >= Lv){
                return "Verdadeiro";
            }else{
                double[] ab = new double[2];
                CNAPCa Ca = new CNAPCa();
                ab = Ca.getResultado(a, b, FTct, Lv);
                String resultado = getResultado(ab[0],ab[1]);
                
                if (resultado.equals("Indeterminado")){ 
                    if (a>=0.8 || b>=0.8) {
                        CNAPClse Lse = new CNAPClse();
                        ab = Lse.getResultado(a, b);
                        return getResultado(ab[0],ab[1]); 
                    }
                }
                return resultado;
            }
        }
    }
    private String getResultado (double a, double b){
        this.a = a;
        this.b = b;
        
        grauDeCrencaEContradicao();
        limites();
        double ct = java.lang.Math.abs(Gct);
        if(ct>=FTct){
            return "Inconsistente";
        }else{
            if (Gcc <= Lf){
                return "Falso";
            }else if(Gcc >= Lv){
                return "Verdadeiro";
            }else{
                return "Indeterminado";
            }
        }
    }
    
    public double getA(){
        return this.a;
    }
    public double getB(){
        return this.b;
    }
    public double getFTct(){
        return this.FTct;
    }
    public double getFTd(){
        return this.FTd;
    }
}
