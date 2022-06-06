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
public class BushyPath {
     private int[] Arestas;
     private int[] Faltas;
     private int maiorGrau=0,maiorDistancia=0;
     private String[] Vertices;
     private List<String> Frases = new ArrayList<>();
     private ProcessarTexto Analise = new ProcessarTexto();
     private Stemming Stemmer = new Stemming();
     private ArrayList<Double> ResultadoPositivo = new ArrayList<>();
     private ArrayList<Double> ResultadoNegativo = new ArrayList<>();
    
     public Texto ponderar(Texto Arquivo){
        /* INICIALIZANDO VARIÁVEIS */
         Frases = Stemmer.Stemming(Arquivo.getFrases());
         Arestas = new int [Frases.size()];
         Faltas = new int [Frases.size()];
         Vertices = new String[Frases.size()];
         Frases.toArray(Vertices);
         
         /* CONSTRUINDO MULTIGRAFO */
         definirArestas();
         maiorGrau();
         
         /* LAÇO DEFINIDOR DA PONTUAÇÃO E CONTRADIÇÃO DAS SENTENÇAS */
         for(int i=0;i<Vertices.length;i++){
            double Pontuacao = Double.valueOf(Arestas[i])/Double.valueOf(maiorGrau);
             ResultadoPositivo.add(Pontuacao);
             Pontuacao = (Double.valueOf(Faltas[i]))/Double.valueOf(maiorDistancia);
             ResultadoNegativo.add(Pontuacao);
         }
         
         Arquivo.setResultadoNegativo(ResultadoNegativo);
         Arquivo.setResultadoPositivo(ResultadoPositivo);
         
         return Arquivo;
     }
     
     /* DEFINI O NÚMERO DE ARESTAS DE CADA VÉRTICE */
     private void definirArestas(){
        for(int i=0;i<Vertices.length;i++){
            List<String> Tokens = Analise.tokens(Vertices[i]);
            for(int j=i+1;j<Vertices.length;j++){
                List<String> Tokenzs = Analise.tokens(Vertices[j]);
                int n=0;
                for(String Token: Tokens){
                    for(String Tokenz: Tokenzs){
                        if(Token.equals(Tokenz)){
                            Arestas[i]++;
                            Arestas[j]++;
                            //break;
                        }else{
                            Faltas[i]++;
                            Faltas[j]++;
                        }
                    }
                }
            }
        }
    }
     
     /* IDENTIFICA O MAIOR GRAU E DISTÂNCIA */
    private void maiorGrau(){
        for(int Aresta: Arestas){
            if(Aresta>maiorGrau)
                maiorGrau = Aresta;
        }
        for(int Falta: Faltas){
            if(Falta>maiorDistancia){
                maiorDistancia = Falta;
            }
        }
    }
}
