/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.robsonbruno.tcc_final.CelulasParaconsistentes;

/**
 *
 * @author Robson Bruno
 */
public class CNAPClse {
    private double Gcc;
    
    public double[] getResultado(double a, double b){
        double[] resposta = new double[2];
        Gcc = ((a-b)+1)/2;
        
        if (Gcc >= 0.5){
            resposta[0] = a;
            resposta[1] = 0.5;
            return resposta;
        }else{
            resposta[0] = 0.5;
            resposta[1] = b;
            return resposta;
            }
    } 
    
    public double getGcc(){
        return Gcc;
    }
}
