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
public class ProcessarTexto {
    private static  List<String> Sentences = new ArrayList<>();
    private String texto;
    private int n;
    
    private void sentences(){
        String[] Sentencas = texto.split("\\.");
        for(String Sentenca: Sentencas){
            Sentences.add(Sentenca);
        }
    }
    
    public List<String> tokens(String Sentence){
        n=0;
        List<String> Tokens = new ArrayList<>();
        String[] FilterList = Sentence.split("\\s|\\.|,|!|\\?|\\)|\\(|}|\\{");
        for(String Token: FilterList){
            if(!"".equals(Token)){
               Tokens.add(Token.toLowerCase());
               n++;
            }
        }
        return Tokens;
    }
    
    public void setTexto(String text){
        this.texto = text;
        Sentences.clear();
        sentences();
    }
    
    public String getTexto(){
        return this.texto;
    }
    
    public List<String> getSentences(){
        return this.Sentences;
    }
    
    public int getNTokens(){
        return this.n;
    }
}
