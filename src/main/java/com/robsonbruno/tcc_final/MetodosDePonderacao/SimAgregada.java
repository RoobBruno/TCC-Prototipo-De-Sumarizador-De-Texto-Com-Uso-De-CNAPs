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
public class SimAgregada {
    private double Limiar=0.1;
    private int[][] Arestas;
    private double[] PontuacaoPositiva;
    private double[] PontuacaoNegativa;
    private String[] Vertices;
    private int[] NPalavras;
    private int[] NArestas;
    private List<String> Frases = new ArrayList<>();
    private ProcessarTexto Analise = new ProcessarTexto();
    private Stemming Stemmer = new Stemming();
    private ArrayList<Double> ResultadoPositivo = new ArrayList<>();
    private ArrayList<Double> ResultadoNegativo = new ArrayList<>();
    
    
    public Texto ponderar(Texto Arquivo){
        /* INICIALIZANDO VARIÁVEIS */
        Frases = Stemmer.Stemming(Arquivo.getFrases());
        Arestas = new int [Frases.size()][Frases.size()];
        Vertices = new String[Frases.size()];
        PontuacaoPositiva = new double[Frases.size()];
        PontuacaoNegativa = new double[Frases.size()];
        NPalavras = new int[Frases.size()];
        NArestas = new int[Frases.size()];
        Frases.toArray(Vertices);
        
        /* OBTENÇÃO DO GRAFO E CALCULANDO OS PESOS*/
        definirArestas();
        somarPontuacao();
        
        /*LAÇO DE DEFINIÇÃO DOS VALORES */
        for(int i=0;i<Vertices.length;i++){
            ResultadoPositivo.add(PontuacaoPositiva[i]/NArestas[i]);
            ResultadoNegativo.add(PontuacaoNegativa[i]/NArestas[i]);
        }
        
        /* RETORNO DOS RESULTADOS AO OBJETO */
        Arquivo.setResultadoPositivo(ResultadoPositivo);
        Arquivo.setResultadoNegativo(ResultadoNegativo);
        
        return Arquivo;
    }
    
    /* DEFINI AS ARESTAS E AS COMPUTA */
    private void definirArestas(){
        for(int i=0;i<Vertices.length;i++){
            List<String> Tokens = Analise.tokens(Vertices[i]);
            for(int j=i+1;j<Vertices.length;j++){
                List<String> Tokenzs = Analise.tokens(Vertices[j]);
                for(String Token: Tokens){
                    NPalavras[i]++;
                    for(String Tokenz: Tokenzs){
                        if(Token.equals(Tokenz)){
                            Arestas[i][j]++;
                            NArestas[i]++;
                            NArestas[j]++;
                        }
                    }
                }
            }
        }
    }
    
    /* CALCULA OS PESOS DAS ARESTAS E FAZ O SOMATÓRIO */
    private void somarPontuacao(){
        double A,B,PesoPositivo,PesoNegativo;
        for(int i=0;i<Vertices.length;i++){
            for(int j=i+1;j<Vertices.length;j++){
                if(Arestas[i][j]!=0){
                    A = Double.valueOf(Arestas[i][j])/Double.valueOf(NPalavras[i]);
                    B = Double.valueOf(Arestas[i][j])/Double.valueOf(NPalavras[j]);
                    A = Math.toRadians(A);
                    B = Math.toRadians(B);
                    A = Math.cos(A);
                    B = Math.cos(B);
                    
                    if(A>=B){
                        PesoPositivo = B/A;
                        PesoNegativo = A*B;
                    }else{
                        PesoPositivo = A/B;
                        PesoNegativo = B*A;
                    }
                    
                    if(PesoPositivo>Limiar){
                        PontuacaoPositiva[j] = PontuacaoPositiva[j]+PesoPositivo;
                        PontuacaoPositiva[j] = PontuacaoPositiva[j]+PesoPositivo;
                        PontuacaoNegativa[i] = PontuacaoNegativa[i]+PesoNegativo;
                        PontuacaoNegativa[j] = PontuacaoNegativa[j]+PesoNegativo;
                    }
                }
            }
        }
    }
}
