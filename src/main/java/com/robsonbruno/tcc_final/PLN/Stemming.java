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
public class Stemming {
    
    private List<String> NewList = new ArrayList<>();
    private ProcessarTexto Processar = new ProcessarTexto();
    private StopWords Limpar = new StopWords();
    
    public List<String> Stemming(List<String> Sentences){
        String NewSentence;
        for(String Sentenca: Sentences){
            NewSentence = Limpar.removerStopWords(Sentenca);
            NewSentence = sufixAnalise(NewSentence);
           NewSentence = prefixAnalise(NewSentence);
            NewList.add(NewSentence);
        }
        return NewList;
    }
    
    public String Stemming(String Sentence){
        String NewSentence;
        
        NewSentence = Limpar.removerStopWords(Sentence);        
        NewSentence = sufixAnalise(NewSentence);
        NewSentence = prefixAnalise(NewSentence);
        
        return NewSentence;
    }
    
    private String sufixAnalise(String sentenca){
        List<String> Tokens = Processar.tokens(sentenca);
        List<String> Palavras = new ArrayList<>();

        for(String Token: Tokens){
             if(Token.length()>3){
                 int Size = 0;
                 String Palavra=Token,Sufixo;
                 
                 if (Token.length()>=9){
                    Size = Token.length()-6;
                    Sufixo = Token.substring(Size);
                    Palavra = sufix6(Sufixo,Token,Size);
                 }
                 
                 if ((Palavra.equals(Token))&&(Token.length()>=8)){
                    Size = Token.length()-5;
                    Sufixo = Token.substring(Size);
                    Palavra = sufix5(Sufixo,Token,Size);
                    
                 }
                 
                 if (((Palavra.equals(Token))&&Token.length()>=7)){
                    Size = Token.length()-4;
                    Sufixo = Token.substring(Size);
                    Palavra = sufix4(Sufixo,Token,Size);
                    
                 }
                 
                 if (((Palavra.equals(Token))&&Token.length()>=6)){
                    Size = Token.length()-3;
                    Sufixo = Token.substring(Size);
                    Palavra = sufix3(Sufixo,Token,Size);
                 }
                 
                 Palavra = sufix2(Palavra);
                 Palavras.add(Palavra);
                 
             }else{
                 Palavras.add(Token);
             }
        }
        return sentenca = String.join(" ",Palavras);
    }
    
    private String sufix6(String sufixo, String token, int size){
        String palavra="";
        switch(sufixo){
            case "zarrão":
                palavra = token.substring(0, size);
                break;
            case "úsculo":
                palavra = token.substring(0, size);
                break;
            case "únculo":
                palavra = token.substring(0, size);
                break;
            case "amento":
                palavra = token.substring(0, size);
                break;
            case "emento":
                palavra = token.substring(0, size);
                break;
            case "imento":
                palavra = token.substring(0, size);
                break;
            case "omento":
                palavra = token.substring(0, size);
                break;
            case "umento":
                palavra = token.substring(0, size);
                break;
            case "amente":
                palavra = token.substring(0, size);
                break;  
            case "omente":
                palavra = token.substring(0, size);
                break; 
            case "imente":
                palavra = token.substring(0, size);
                break;
            case "umente":
                palavra = token.substring(0, size);
                break;
            default:
                palavra = token;
                break;
        }
        return palavra;
    }
    
    private String sufix5(String sufixo, String token, int size){
        String palavra="";
        switch(sufixo){
            case "alhão":
                palavra = token.substring(0, size);
                break;
            case "arrão":
                palavra = token.substring(0, size);
                break;
            case "eirão":
                palavra = token.substring(0, size);
                break;
            case "astro":
                palavra = token.substring(0, size);
                break;
            case "zinho":
                palavra = token.substring(0, size);
                break;
            case "áculo":
                palavra = token.substring(0, size);
                break;
            case "ículo":
                palavra = token.substring(0, size);
                break;
            case "ância":
                palavra = token.substring(0, size);
                break;
            case "ência":
                palavra = token.substring(0, size);
                break;
            case "douro":
                palavra = token.substring(0, size);
                break;
            case "tório":
                palavra = token.substring(0, size);
                break;
            case "mento":
                palavra = token.substring(0, size);
                break;
            case "mente":
                palavra = token.substring(0, size);
                break;
            case "estre":
                palavra = token.substring(0, size);
                break;
            case "entar":
                palavra = token.substring(0, size);
                break;
            case "ficar":
                palavra = token.substring(0, size);
                break;
            case "ilhar":
                palavra = token.substring(0, size);
                break;
            case "inhar":
                palavra = token.substring(0, size);
                break;
            case "iscar":
                palavra = token.substring(0, size);
                break;
            default:
                palavra = token;
            }
        return palavra;
    }

    private String sufix4(String sufixo, String token, int size){
        String palavra="";
        switch(sufixo){
            case "ázio":
                palavra = token.substring(0, size);
                break;
            case "aréu":
                palavra = token.substring(0, size);
                break;
            case "arra":
                palavra = token.substring(0, size);
                break;
            case "orra":
                palavra = token.substring(0, size);
                break;
            case "elho":
                palavra = token.substring(0, size);
                break;
            case "ilho":
                palavra = token.substring(0, size);
                break;
            case "acho":
                palavra = token.substring(0, size);
                break;
            case "icho":
                palavra = token.substring(0, size);
                break;
            case "ucho":
                palavra = token.substring(0, size);
                break;
            case "ebre":
                palavra = token.substring(0, size);
                break;
            case "zito":
                palavra = token.substring(0, size);
                break;
            case "isco":
                palavra = token.substring(0, size);
                break;
            case "usco":
                palavra = token.substring(0, size);
                break;
            case "culo":
                palavra = token.substring(0, size);
                break;
            case "agem":
                palavra = token.substring(0, size);
                break;
            case "alha":
                palavra = token.substring(0, size);
                break;
            case "aria":
                palavra = token.substring(0, size);
                break;
            case "ário":
                palavra = token.substring(0, size);
                break;
            case "eiro":
                palavra = token.substring(0, size);
                break;
            case "ugem":
                palavra = token.substring(0, size);
                break;
            case "dade":
                palavra = token.substring(0, size);
                break;
            case "ície":
                palavra = token.substring(0, size);
                break;
            case "tude":
                palavra = token.substring(0, size);
                break;
            case "ismo":
                palavra = token.substring(0, size);
                break;
            case "ísmo":
                palavra = token.substring(0, size);
                break;
            case "ista":
                palavra = token.substring(0, size);
                break;
            case "ança":
                palavra = token.substring(0, size);
                break;
            case "ença":
                palavra = token.substring(0, size);
                break;
            case "ante":
                palavra = token.substring(0, size);
                break;
            case "ente":
                palavra = token.substring(0, size);
                break;
            case "inte":
                palavra = token.substring(0, size);
                break;
            case "ício":
                palavra = token.substring(0, size);
                break;
            case "ouro":
                palavra = token.substring(0, size);
                break;
            case "ório":
                palavra = token.substring(0, size);
                break;
            case "ejar":
                palavra = token.substring(0, size);
                break;
            case "icar":
                palavra = token.substring(0, size);
                break;
            case "itar":
                palavra = token.substring(0, size);
                break;
            case "izar":
                palavra = token.substring(0, size);
                break;
            default:
                palavra = token;
            }
        return palavra;
    }

    private String sufix3(String sufixo, String token, int size){
        String palavra="";
         switch(sufixo){
            case "aça":
                palavra = token.substring(0, size);
                break;
            case "aço":
                palavra = token.substring(0, size);
                break;
            case "uça":
                palavra = token.substring(0, size);
                break;
            case "ino":
                palavra = token.substring(0, size);
                break;
            case "ejo":
                palavra = token.substring(0, size);
                break;
            case "eco":
                palavra = token.substring(0, size);
                break;
            case "ico":
                palavra = token.substring(0, size);
                break;
            case "icho":
                palavra = token.substring(0, size);
                break;
            case "ela":
                palavra = token.substring(0, size);
                break;
            case "ete":
                palavra = token.substring(0, size);
                break;
            case "eto":
                palavra = token.substring(0, size);
                break;
            case "ito":
                palavra = token.substring(0, size);
                break;
            case "ote":
                palavra = token.substring(0, size);
                break;
            case "ola":
                palavra = token.substring(0, size);
                break;
            case "ulo":
                palavra = token.substring(0, size);
                break;
            case "ada":
                palavra = token.substring(0, size);
                break;
            case "ado":
                palavra = token.substring(0, size);
                break;
            case "ato":
                palavra = token.substring(0, size);
                break;
            case "ama":
                palavra = token.substring(0, size);
                break;
            case "ame":
                palavra = token.substring(0, size);
                break;
            case "edo":
                palavra = token.substring(0, size);
                break;
            case "ite":
                palavra = token.substring(0, size);
                break;
            case "ume":
                palavra = token.substring(0, size);
                break;
            case "dão":
                palavra = token.substring(0, size);
                break;
            case "eza":
                palavra = token.substring(0, size);
                break;
            case "ice":
                palavra = token.substring(0, size);
                break;
            case "ura":
                palavra = token.substring(0, size);
                break;
            case "ção":
                palavra = token.substring(0, size);
                break;
            case "são":
                palavra = token.substring(0, size);
                break;
            case "aco":
                palavra = token.substring(0, size);
                break;
            case "ano":
                palavra = token.substring(0, size);
                break;
            case "eno":
                palavra = token.substring(0, size);
                break;
            case "ita":
                palavra = token.substring(0, size);
                break;
            case "oso":
                palavra = token.substring(0, size);
                break;
            case "udo":
                palavra = token.substring(0, size);
                break;
            case "vel":
                palavra = token.substring(0, size);
                break;
            case "ivo":
                palavra = token.substring(0, size);
                break;
            case "iço":
                palavra = token.substring(0, size);
                break;
            case "ear":
                palavra = token.substring(0, size);
                break;
            default:
                palavra = token;
            }
        return palavra;
    }

    private String sufix2(String token){
        String palavra=token;
        //System.out.println("Palavra: "+palavra);
        boolean verificar=true; 
        while(verificar){
            if(palavra.length()<=3)
                break;
            int Size = palavra.length()-2;
            //System.out.println("tamanho: "+Size+", Sufixo: "+palavra);
            String Sufixo = palavra.substring(Size,palavra.length());
            
            switch (Sufixo){
                case "ão":
                    palavra = palavra.substring(0, Size);
                    break;
                case "az":
                    palavra = palavra.substring(0, Size);
                    break;
                case "im":
                    palavra = palavra.substring(0, Size);
                    break;
                case "al":
                    palavra = palavra.substring(0, Size);
                    break;
                case "ia":
                    palavra = palavra.substring(0, Size);
                    break;
                case "io":
                    palavra = palavra.substring(0, Size);
                    break;
                case "ez":
                    palavra = palavra.substring(0, Size);
                    break;
                case "or":
                    palavra = palavra.substring(0, Size);
                    break;
                case "ar":
                    palavra = palavra.substring(0, Size);
                    break;
                case "eo":
                    palavra = palavra.substring(0, Size);
                    break;
                case "ês":
                    palavra = palavra.substring(0, Size);
                    break;
                case "eu":
                    palavra = palavra.substring(0, Size);
                    break;
                case "il":
                    palavra = palavra.substring(0, Size);
                    break;
                default:
                    verificar = false;
            }
        }
        
        return palavra;
    }
    
    private String prefixAnalise(String sentenca){
        List<String> Tokens = Processar.tokens(sentenca);
        List<String> Palavras = new ArrayList<>();
        
        for(String Token: Tokens){
            if(Token.length()>3){
                 String Palavra=Token,Prefixo;
                 
                if(Token.length()>=9){
                    Prefixo = Token.substring(0,6);
                    Palavra = Prefix6(Prefixo,Token);
                }
                
                if((Palavra.equals(Token))&&(Token.length()>=8)){
                    Prefixo = Token.substring(0,5);
                    Palavra = Prefix5(Prefixo,Token);
                }
                
                if((Palavra.equals(Token))&&(Token.length()>=7)){
                    Prefixo = Token.substring(0,4);
                    Palavra = Prefix4(Prefixo,Token);
                }
                
                if((Palavra.equals(Token))&&(Token.length()>=6)){
                    Prefixo = Token.substring(0,3);
                    Palavra = Prefix3(Prefixo,Token);
                }
                
                if((Palavra.equals(Token))&&(Token.length()>=5)){
                    Prefixo = Token.substring(0,2);
                    Palavra = Prefix2(Prefixo,Token);
                }
                
                if((Palavra.equals(Token))&&(Token.length()>=4)){
                    Prefixo = Token.substring(0,1);
                    Palavra = Prefix1(Prefixo,Token);
                }
                
                Palavras.add(Palavra);

            }else{
                Palavras.add(Token);
            }
        }
        
        return sentenca = String.join(" ",Palavras);
    }

    private String Prefix6(String Prefixo, String Token) {
        String palavra="";
        
        switch(Prefixo){
            case "circun":
                palavra = Token.substring(6, Token.length());
                break;
            case "circum":
                palavra = Token.substring(6, Token.length());
                break;
            case "contra":
                palavra = Token.substring(6, Token.length());
                break;
            case "preter":
                palavra = Token.substring(6, Token.length());
                break;
            case "sesqui":
                palavra = Token.substring(6, Token.length());
                break;
            default:
                palavra = Token;
        }
        
        return palavra;
    }
    
    private String Prefix5(String Prefixo, String Token) {
        String palavra="";
        
        switch(Prefixo){
            case "circu":
                palavra = Token.substring(5, Token.length());
                break;
            case "entre":
                palavra = Token.substring(5, Token.length());
                break;
            case "extra":
                palavra = Token.substring(5, Token.length());
                break;
            case "infra":
                palavra = Token.substring(5, Token.length());
                break;
            case "inter":
                palavra = Token.substring(5, Token.length());
                break;
            case "intra":
                palavra = Token.substring(5, Token.length());
                break;
            case "intro":
                palavra = Token.substring(5, Token.length());
                break;
            case "justa":
                palavra = Token.substring(5, Token.length());
                break;
            case "multi":
                palavra = Token.substring(5, Token.length());
                break;
            case "pluri":
                palavra = Token.substring(5, Token.length());
                break;
            case "retro":
                palavra = Token.substring(5, Token.length());
                break;
            case "super":
                palavra = Token.substring(5, Token.length());
                break;
            case "sobre":
                palavra = Token.substring(5, Token.length());
                break;
            case "supra":
                palavra = Token.substring(5, Token.length());
                break;
            case "trans":
                palavra = Token.substring(5, Token.length());
                break;
            case "ultra":
                palavra = Token.substring(5, Token.length());
                break;
            case "arque":
                palavra = Token.substring(5, Token.length());
                break;
            case "hiper":
                palavra = Token.substring(5, Token.length());
                break;
            default:
                palavra = Token;
        }
        
        return palavra;
    }  
    
    private String Prefix4(String Prefixo, String Token) {
        String palavra="";
        
        switch(Prefixo){
            case "ambi":
                palavra = Token.substring(4, Token.length());
                break;
            case "ante":
                palavra = Token.substring(4, Token.length());
                break;
            case "bene":
                palavra = Token.substring(4, Token.length());
                break;
            case "male":
                palavra = Token.substring(4, Token.length());
                break;
            case "pene":
                palavra = Token.substring(4, Token.length());
                break;
            case "semi":
                palavra = Token.substring(4, Token.length());
                break;
            case "soto":
                palavra = Token.substring(4, Token.length());
                break;
            case "sota":
                palavra = Token.substring(4, Token.length());
                break;
            case "tras":
                palavra = Token.substring(4, Token.length());
                break;
            case "tres":
                palavra = Token.substring(4, Token.length());
                break;
            case "tris":
                palavra = Token.substring(4, Token.length());
                break;
            case "vice":
                palavra = Token.substring(4, Token.length());
                break;
            case "vizo":
                palavra = Token.substring(4, Token.length());
                break;
            case "anfi":
                palavra = Token.substring(4, Token.length());
                break;
            case "anti":
                palavra = Token.substring(4, Token.length());
                break;
            case "antí":
                palavra = Token.substring(4, Token.length());
                break;
            case "aqui":
                palavra = Token.substring(4, Token.length());
                break;
            case "arce":
                palavra = Token.substring(4, Token.length());
                break;
            case "cata":
                palavra = Token.substring(4, Token.length());
                break;
            case "endo":
                palavra = Token.substring(4, Token.length());
                break;
            case "hipo":
                palavra = Token.substring(4, Token.length());
                break;
            case "meta":
                palavra = Token.substring(4, Token.length());
                break;
            case "para":
                palavra = Token.substring(4, Token.length());
                break;
            case "peri":
                palavra = Token.substring(4, Token.length());
                break;
            default:
                palavra = Token;
                break;
        }
        
        return palavra;
    }
    
    private String Prefix3(String Prefixo, String Token) {
        String palavra="";
        
        switch(Prefixo){
            case "abs":
                palavra = Token.substring(3, Token.length());
            case "bem":
                break;
            case "ben":
                palavra = Token.substring(3, Token.length());
                break;
            case "cis":
                palavra = Token.substring(3, Token.length());
                break;
            case "com":
                palavra = Token.substring(3, Token.length());
                break;
            case "con":
                palavra = Token.substring(3, Token.length());
                break;
            case "des":
                palavra = Token.substring(3, Token.length());
                break;
            case "dis":
                palavra = Token.substring(3, Token.length());
                break;
            case "mal":
                palavra = Token.substring(3, Token.length());
                break;
            case "per":
                palavra = Token.substring(3, Token.length());
                break;
            case "pos":
                palavra = Token.substring(3, Token.length());
                break;
            case "pre":
                palavra = Token.substring(3, Token.length());
                break;
            case "pro":
                palavra = Token.substring(3, Token.length());
                break;
            case "sub":
                palavra = Token.substring(3, Token.length());
                break;
            case "sob":
                palavra = Token.substring(3, Token.length());
                break;
            case "tri":
                palavra = Token.substring(3, Token.length());
                break;
            case "uni":
                palavra = Token.substring(3, Token.length());
                break;
            case "vis":
                palavra = Token.substring(3, Token.length());
                break;
            case "aná":
                palavra = Token.substring(3, Token.length());
                break;
            case "apo":
                palavra = Token.substring(3, Token.length());
                break;
            case "arc":
                palavra = Token.substring(3, Token.length());
                break;
            case "dia":
                palavra = Token.substring(3, Token.length());
                break;
            case "epi":
                palavra = Token.substring(3, Token.length());
                break;
            case "sin":
                palavra = Token.substring(3, Token.length());
                break;
            case "sim":
                palavra = Token.substring(3, Token.length());
                break;
            default:
                palavra = Token;
        }
        
        return palavra;
    }
    
    private String Prefix2(String Prefixo, String Token) {
        String palavra="";
        
        switch(Prefixo){
            case "ab":
                palavra = Token.substring(2, Token.length());
            case "ad":
                break;
            case "bi":
                palavra = Token.substring(2, Token.length());
                break;
            case "co":
                palavra = Token.substring(2, Token.length());
                break;
            case "de":
                palavra = Token.substring(2, Token.length());
                break;
            case "di":
                palavra = Token.substring(2, Token.length());
                break;
            case "ex":
                palavra = Token.substring(2, Token.length());
                break;
            case "es":
                palavra = Token.substring(2, Token.length());
                break;
            case "in":
                palavra = Token.substring(2, Token.length());
                break;
            case "im":
                palavra = Token.substring(2, Token.length());
                break;
            case "em":
                palavra = Token.substring(2, Token.length());
                break;
            case "en":
                palavra = Token.substring(2, Token.length());
                break;
            case "ob":
                palavra = Token.substring(2, Token.length());
                break;
            case "re":
                palavra = Token.substring(2, Token.length());
                break;
            case "so":
                palavra = Token.substring(2, Token.length());
                break;
            case "an":
                palavra = Token.substring(2, Token.length());
                break;
            case "ec":
                palavra = Token.substring(2, Token.length());
                break;
            case "eu":
                palavra = Token.substring(2, Token.length());
                break;
            case "ev":
                palavra = Token.substring(2, Token.length());
                break;
            case "si":
                palavra = Token.substring(2, Token.length());
                break;
            default:
                palavra = Token;
        }
        
        return palavra;
    }
    
    private String Prefix1(String Prefixo, String Token) {
        String palavra="";
        
        switch(Prefixo){
            case "a":
                palavra = Token.substring(1, Token.length());
            case "e":
                break;
            case "i":
                palavra = Token.substring(1, Token.length());
                break;
            case "o":
                palavra = Token.substring(1, Token.length());
                break;
            default:
                palavra = Token;
        }
        
        return palavra;
    }
}
