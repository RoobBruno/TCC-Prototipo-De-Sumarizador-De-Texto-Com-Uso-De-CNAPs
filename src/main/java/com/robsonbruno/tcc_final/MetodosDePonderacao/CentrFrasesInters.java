/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.robsonbruno.tcc_final.MetodosDePonderacao;

import com.robsonbruno.tcc_final.PLN.ProcessarTexto;
import com.robsonbruno.tcc_final.PLN.Stemming;
import com.robsonbruno.tcc_final.PLN.Texto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robson Bruno
 */
public class CentrFrasesInters {
    /* INICIALIZANDO VARIÁVEIS */
    private List<String> Frases = new ArrayList();
    private ProcessarTexto Processar = new ProcessarTexto();
    private Stemming Stemmer = new Stemming();
    private ArrayList<Double> ResultadoPositivo = new ArrayList<>(); 
    private ArrayList<Double> ResultadoNegativo = new ArrayList<>();
    private int nPalavras = 0;
    private double[] Centralidades;
    private int[] NPalavras,SPalavras;
    private int[] NIntersecao;
    private String[] Sentencas;
    
    public Texto ponderar(Texto Arquivo){
        /* INICIANDO VARIÁVEIS */
        NPalavras = new int[Arquivo.getFrases().size()];
        SPalavras = new int[Arquivo.getFrases().size()];
        NIntersecao = new int[Arquivo.getFrases().size()];
        Sentencas = new String[Arquivo.getFrases().size()];
        Centralidades = new double[Arquivo.getFrases().size()];
        Frases = (Stemmer.Stemming(Arquivo.getFrases()));
        
        /* COMPUTAÇÃO DO NÚMERO DE CHAVES E INTERSEÇÕES */
        contPalavras();
        contIntersecao();
        
        /* LAÇO QUE CALCULA O GRAU DE CENTRALIDADE E CONTRADIÇÃO DAS SENTENÇAS */
        for(int i=0;i<Sentencas.length;i++){
            double Centralidade = Double.valueOf(NIntersecao[i])/Double.valueOf(nPalavras);
            Centralidades[i] = Centralidade;
            double Contradicao = Double.valueOf(SPalavras[i])/Double.valueOf(NPalavras[i]);
            ResultadoNegativo.add(Contradicao);
        }
        
        /* IDENTIFICANDO O MAIOR GRAU DE CENTRALIDADE */
        double Maior = acharMaiorPontuacao();
        
        /* LAÇO QUE CALCULA A PONTUAÇÃO FINAL DAS SENTENÇAS */
        for(int i=0;i<Centralidades.length;i++){
            ResultadoPositivo.add(Centralidades[i]/Maior);
        }
        
        /* RETORNANDO O RESULTADO PARA O OBJETO */
        Arquivo.setResultadoNegativo(ResultadoNegativo);
        Arquivo.setResultadoPositivo(ResultadoPositivo);
        
        return Arquivo;
    }
    
    /* COMPUTA A QUANTIDADE DE PALAVRAS EM CADA SENTENÇA E NO TOTAL */
    private void contPalavras(){
        int palavras=0, cont=0;
        for(String Frase: Frases){
            Sentencas[cont] = Frase;
            List<String> Tokens = Processar.tokens(Frase);
            for(String Token: Tokens){
                palavras++;
                nPalavras++;
            }
            NPalavras[cont] = palavras;
            cont++;
            palavras = 0;
        }        
    }
    
    /* COMPUTA O GRAU DE INTERSEÇÕES DE CADA SENTENÇA */
    private void contIntersecao(){
        int intersecoes=0;
        
        for(int i=0;i<Sentencas.length;i++){ 
            List<String> Tokens = Processar.tokens(Sentencas[i]);
            for(String Token: Tokens){
                for(int x=i+1;x<Sentencas.length;x++){
                    List<String> Tokenz = Processar.tokens(Sentencas[x]);
                    for(String Tokem: Tokenz){
                        if(Tokem.equals(Token))
                            intersecoes++;
                    }
                }
                if(i==0){
                    NIntersecao[i] = intersecoes;
                }else{
                    for(int x=i-1;x>=0;x--){
                        List<String> Tokenz = Processar.tokens(Sentencas[x]);
                        for(String Tokem: Tokenz){
                            if(Tokem.equals(Token))
                                intersecoes++;
                        }
                    }
                 NIntersecao[i] = intersecoes+NIntersecao[i];
                }
                if(NIntersecao[i]==0)
                    SPalavras[i]++;
            } 
            intersecoes=0;
        }
    }
    
    /* IDENTIFICA O MAIOR GRAU DE CENTRALIDADE OBTIDO */
    private double acharMaiorPontuacao(){
        double maior = 0.0;
        
        for(int i=0;i<Centralidades.length;i++){
            if(Centralidades[i]>maior)
                maior = Centralidades[i];
        }
        
        return maior;
    }
}
