/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.robsonbruno.tcc_final.CelulasParaconsistentes;

import com.robsonbruno.tcc_final.PLN.Texto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robson Bruno
 */
public class CCIR {
    private double FTct, FTd;
    
    public List<String> avaliar(Texto Frases){
        
        List<String> Selecionadas = new ArrayList<>();
        
        CNAPd Decisao = new CNAPd();
        String Resultado;
        int cont=0;
        for (String Frase: Frases.getFrases()){
            String px = Frases.getResultadoPositivo().get(cont).toString();
            double x = Double.parseDouble(px);
            String py = Frases.getResultadoNegativo().get(cont).toString();
            double y = Double.parseDouble(py);

            Resultado = Decisao.getResultado(x,y, FTct, FTd);

            cont++;
            if ("Verdadeiro".equals(Resultado))
                Selecionadas.add(Frase);
        }

        return Selecionadas;
    }
    
     public List<String> avaliar(Texto Frases, double Limiar) {
        
        List<String> Selecionadas = new ArrayList<>();
        int cont=0;
        double maior=0;
        
        for(String Frase: Frases.getFrases()){
            String px = Frases.getResultadoPositivo().get(cont).toString();
            double x = Double.parseDouble(px);
           
            if(x>maior)
                maior=x;
            
            cont++;
        }
        cont=0;
        Limiar = maior*Limiar;
        for(String Frase: Frases.getFrases()){
            String px = Frases.getResultadoPositivo().get(cont).toString();
            double x = Double.parseDouble(px);
           
            if(x>Limiar)
                Selecionadas.add(Frase);
            
            cont++;
        }
        
        return Selecionadas;
    }
    
    public void setParamentros(double FTct, double FTd){
        this.FTct = FTct;
        this.FTd = FTd;
    }
        
    public void setFTct(double FTct){
        this.FTct = FTct;
    }
    
    public void setFTd(double FTd){
        this.FTd = FTd;
    }

}
