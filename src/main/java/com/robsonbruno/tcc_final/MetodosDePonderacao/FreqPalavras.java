/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.robsonbruno.tcc_final.MetodosDePonderacao;

import com.robsonbruno.tcc_final.PLN.ProcessarTexto;
import com.robsonbruno.tcc_final.PLN.Texto;
import com.robsonbruno.tcc_final.PLN.Stemming;
import com.robsonbruno.tcc_final.PLN.StopWords;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Robson Bruno
 */
public class FreqPalavras {
    private List<String> FrasesList = new ArrayList<>();
    private Stemming Stemmer = new Stemming();
    private ProcessarTexto Analise = new ProcessarTexto();
    private Texto Frases;
    private int[] Frequencia;
    private int[] Tamanho = new int[2];
    private int[] NPalavras;
    private String[] Palavras;
    private double[] SentencasScore;
    double[] PalavrasScore;
    
    public Texto ponderar(Texto Frases){
        /* INICIALIZANDO VARIÁVEIS */
        FrasesList = Stemmer.Stemming(Frases.getFrases());
        Tamanho = verificarTamanho();
        Frequencia = new int[Tamanho[1]];
        NPalavras = new int[Tamanho[1]];
        Palavras = new String[Tamanho[1]];
        SentencasScore = new double[Tamanho[0]];
        PalavrasScore = new double[Tamanho[1]];
        
        /* FUNÇÕES DE CALCULO DE FREQUÊNCIA E DEFINIÇÃO DE VALOR DAS PALAVRAS */
        calcularFreqPos();
        calcularScore();
        
        /*LAÇO DEFINIDOR DE PONTUAÇÃO DAS SENTENÇAS*/
        int c0=0;
        for (String Frase: FrasesList){
            List<String> Tokens = Analise.tokens(Frase);
            for (String Token: Tokens){
                int c=0;
                for (String palavra: Palavras){ 
                    if (palavra == null)
                        break;
                    if (palavra.equals(Token)){
                          if(SentencasScore[c0] == 0){
                            SentencasScore[c0] = PalavrasScore[c];
                          }else{
                             SentencasScore[c0] = PalavrasScore[c]+SentencasScore[c0];
                            }
                        }                             
                     c++;
                    }
                }
             SentencasScore[c0]=  SentencasScore[c0]/Double.valueOf(NPalavras[c0]);
             c0++;
            }
        
        /* LAÇO QUE PASSA A PONTUAÇÃO DEFINITIVA PARA O FORMATO DE LISTA */
        ArrayList<Double> ResultadoPositivo = new ArrayList<>();
        for(double score: SentencasScore){
            if(score != 0)
            ResultadoPositivo.add(score);
        }
        
        /* ADIÇÃO FINAL DE RESULTADOS DA ANÁLISE NO OBJETO DE TEXTO */
        Frases.setResultadoPositivo(ResultadoPositivo);
        Frases.setResultadoNegativo(calcularNeg(Frases));
        // O VALOR DA CONTRADIÇÃO É OBTIDO PELO MÉTODO "CalcularNeg"
        return Frases;
    }
    
    /* IDENTIFICA A QUANTIDADES DE SENTENÇAS E PALAVRAS PRESENTES EM CADA */
    private int[] verificarTamanho(){
        int f=0,t=0;
        for (String Frase: FrasesList){
            f++;
            List<String> Tokens = Analise.tokens(Frase);
            for(String Token: Tokens){
                t++;
            }
        }
        Tamanho[0] = f;
        Tamanho[1] = t;
        
        return Tamanho;
    }
    
    /* FAZ O LEVANTAMENTO DA INCIDÊNCIA DAS PALAVRAS */
    private void calcularFreqPos(){
        int c0 = 0;
        for (String Frase: FrasesList){
            List<String> Tokens = Analise.tokens(Frase);
            for (String Token: Tokens){
                NPalavras[c0] = NPalavras[c0]+1;
                int c=0;
                for (String Palavra: Palavras){
                    if (Palavra == null){
                        Palavras[c]=Token;
                        Frequencia[c]=1;
                        break;
                    }else if (Palavra.equals(Token)){
                        Frequencia[c]= Frequencia[c]+1;
                        break;
                    }
                    c++;
                }
            }
            c0++;
        }
    }
    
    /* RETORNA A FREQUÊNCIA DE MAIOR VALOR */
   private int maiorValor(){
        int maior=0; 
        int cont=0;
        for (int freq: Frequencia){
            if(freq == 0){
                break;
            }else if(freq>maior){
                maior = freq;
                cont++;
            }
        }
        return maior;
    }
   
    /* CALCULA A PONTUAÇÃO DEFINITIVA DE CADA PALAVRA */
    private void calcularScore(){
        int maior = maiorValor();
        int c=0;
        for(double freq: Frequencia){
            if(freq==0)
                break;
            
            PalavrasScore[c] = Double.valueOf(freq/maior);
            c++;
        }
    }
    
    /* CALCULA O VALOR DA CONTRADIÇÃO DAS SENTENÇAS */
     private  ArrayList<Double> calcularNeg(Texto Frases){
        ArrayList<Double> Score = new ArrayList<>();
        int c=0;
        for(String frase: Frases.getFrases()){
            ProcessarTexto process = new ProcessarTexto();
            List<String> Tokens = process.tokens(frase);
            int n=0;
            for(String token: Tokens){
               n++; 
            }
            double pn = Double.valueOf(n);
            double result = (pn-NPalavras[c])/pn;
            if(result<0)
                Score.add(0.0);
            else
                Score.add(result);
        }
         return Score;
    }
     
}