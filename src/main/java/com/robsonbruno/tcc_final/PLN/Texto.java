/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.robsonbruno.tcc_final.PLN;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robson Bruno
 */
public class Texto{
    private String Titulo;
    private List<String> Frases = new ArrayList<>();
    private ArrayList<Double> ResultadoPositivo = new ArrayList<>(); 
    private ArrayList<Double> ResultadoNegativo = new ArrayList<>();

        public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }
    
    public List<String> getFrases() {
        return Frases;
    }

    public void setFrases(List<String> Frases) {
        this.Frases = Frases;
    }

    public ArrayList getResultadoPositivo() {
        return ResultadoPositivo;
    }

    public void setResultadoPositivo(ArrayList ResultadoPositivo) {
        this.ResultadoPositivo = ResultadoPositivo;
    }

    public ArrayList getResultadoNegativo() {
        return ResultadoNegativo;
    }

    public void setResultadoNegativo(ArrayList ResultadoNegativo) {
        this.ResultadoNegativo = ResultadoNegativo;
    }
    
}
