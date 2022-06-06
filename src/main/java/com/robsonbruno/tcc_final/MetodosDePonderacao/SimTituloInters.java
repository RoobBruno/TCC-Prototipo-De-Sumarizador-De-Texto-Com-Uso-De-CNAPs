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
public class SimTituloInters {
    private int[] NMatchs,NFaults, NPalavras;
    private int NTitulo;
    private double Amortecedor;
    private Stemming Steammer = new Stemming();
    private List<String> Frases = new ArrayList();
    private String Titulo;
    private ProcessarTexto Analise = new ProcessarTexto(); 
    private ArrayList<Double> ResultadoPositivo = new ArrayList();
    private ArrayList<Double> ResultadoNegativo = new ArrayList();
    
    public Texto ponderar(Texto Arquivo){
        /* INICIALIZANDO VARIÁVEIS */
        Frases = Steammer.Stemming(Arquivo.getFrases());
        Titulo = Steammer.Stemming(Arquivo.getTitulo());
        NMatchs = new int[Frases.size()];
        NFaults = new int[Frases.size()];
        NPalavras = new int[Frases.size()];
        
        /* OBTENÇÃO DO NÚMERO DE PALAVRAS DO TÍTULO */
        List<String> TituloTokens = Analise.tokens(Titulo);
        NTitulo = TituloTokens.size();
        
        /* LAÇO QUE COMPUTA AS INTERSEÇÕES */
        int cont=0;
        for(String frase: Frases){
            List<String> Tokens = Analise.tokens(frase);
            for(String Token: Tokens){
                NPalavras[cont]++;
                for(String TituloToken: TituloTokens){
                    if(TituloToken.equals(Token)){
                        NMatchs[cont]++;
                        break;
                    }
                }
            }
            NFaults[cont] = NTitulo - NMatchs[cont];
            cont++;
        }
        
        /* LAÇO QUE CALCULA OS VALORES FINAIS DE PONTUAÇÃO E CONTRADIÇÃO */
        for(int i=0;i<NMatchs.length;i++){
            double Pontuacao = Double.valueOf(NMatchs[i])/Double.valueOf(NTitulo);
            ResultadoPositivo.add(Pontuacao);
            Pontuacao = (Double.valueOf(NFaults[i])/Double.valueOf(NPalavras[i]));
            ResultadoNegativo.add(Pontuacao);
        }
        
        /* RETORNA OS RESULTADOS PARA O OBJETO */
        Arquivo.setResultadoNegativo(ResultadoNegativo);
        Arquivo.setResultadoPositivo(ResultadoPositivo);
        
        return Arquivo;
    }
}
