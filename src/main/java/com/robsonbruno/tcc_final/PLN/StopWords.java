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
public class StopWords {
    private static String[] StopWords = new String[127];
    private static String ListaDePalavras = "a,acerca,adeus,agora,ainda,além,algumas,algo,algumas,alguns,ali,além,ambas,ambos,ano,anos,antes,ao,aonde,aos,apenas,apoio,apontar,após,após,aquela,aquelas,aquele,aqueles,aqui,aquilo,as,assim,através,atrás,até,aí,baixo,bastante,bem,boa,boas,bom,bons,breve,cada,caminho,catorze,cedo,cento,certamente,certeza,cima,cinco,coisa,com,como,comprido,conhecido,conselho,contra,contudo,corrente,cuja,cujas,cujo,cujos,custa,cá,da,daquela,daquelas,daquele,daqueles,dar,das,de,debaixo,dela,delas,dele,deles,demais,dentro,depois,desde,desligado,dessa,dessas,desse,desses,desta,destas,deste,destes,deve,devem,deverá,dez,dezanove,dezasseis,dezassete,dezoito,dia,diante,direita,dispõe,dispõem,diversa,diversas,diversos,diz,dizem,dizer,do,dois,dos,doze,duas,durante,dá,dão,dúvida,e,ela,elas,ele,eles,em,embora,enquanto,então,entre,era,eram,essa,essas,esse,esses,esta,estado,estamos,estar,estará,estas,estava,estavam,este,esteja,estejam,estejamos,estes,esteve,estive,estivemos,estiver,estivera,estiveram,estiverem,estivermos,estivesse,estivessem,estiveste,estivestes,estivéramos,estivéssemos,estou,está,estás,está,vamos,estão,eu,exemplo,falta,fará,favor,faz,fazeis,fazem,fazemos,fazer,fazesfazia,faço,fez,fim,final,foi,fomos,for,fora,foram,forem,forma,formos,fosse,fossem,foste,fostes,fui,fôramos,fôssemos,geral,grande,grandes,grupo,ha,haja,hajam,hajamos,havemos,havia,hei,hoje,hora,horas,houve,houvemos,houver,houvera,houveram,houverei,houverem,houveremos,houveria,houveriam,houvermos,houverá,houverão,houveríamos,houvesse,houvessem,houvéramos,houvéssemos,há,hão,iniciar,inicio,ir,irá,isso,ista,iste,isto,já,lado,lhe,lhes,ligado,local,logo,longe,lugar,lá,maior,maioria,maiorias,mais,mal,mas,me,mediante,meio,menor,menos,meses,mesma,mesmas,mesmo,mesmos,meu,meus,mil,minha,minhas,momento,muito,muitos,máximo,mês,na,nada,não,naquela,naquelas,naquele,naqueles,nas,nem,nenhuma,nessa,nessas,nesse,nesses,nesta,nestas,neste,nestes,no,noite,nome,nos,nossa,nossas,nosso,nossos,nova,novas,nove,novo,novos,num,numa,numas,nunca,nuns,não,nível,nós,número,o,obra,obrigada,obrigado,oitava,oitavo,oito,onde,ontem,onze,os,ou,outra,outras,outro,outros,para,parece,parte,partir,poucas,pegar,pela,pelas,pelo,pelos,perante,perto,pessoas,pode,podem,poder,poderá,podia,pois,ponto,pontos,por,porque,porquê,portanto,posição,possivelmente,posso,possível,pouca,pouco,poucos,povo,primeira,primeiras,primeiro,primeiros,próprio,própria,próprias,próprio,próprios,próxima,próximas,próximo,próximos,puderam,pôde,põe,põem,quais,qual,qualquer,quando,quanto,quarta,quarto,quatro,que,quem,quer,quereis,querem,queremas,queres,quero,questão,quieto,quinta,quinto,quinze,quais,quê,relação,sabe,sabem,saber,se,segunda,segundo,sei,seis,seja,sejam,sejamos,sem,sempre,sendo,ser,serei,seremos,seria,seriam,será,serão,seríamos,sete,seu,seus,sexta,sexto,sim,sistema,sob,sobre,sois,somente,somos,sou,sua,suas,são,sétima,sétimo,só,tal,talvez,também,tanta,tantas,tanto,tarde,te,tem,temos,tempo,tendes,tenha,tenham,tenhamos,tenho,tens,tentar,tentaram,tente,tentei,ter,terceira,terceiro,terei,teremos,teria,teriam,terá,terão,teríamos,teu,teus,teve,tinha,tinham,tipo,tive,tivemos,tiver,tivera,tiveram,tiverem,tivermos,tivesse,tivessem,tiveste,tivestes,tivéramos,tivéssemos,toda,todas,todo,todos,trabalhar,trabalho,treze,três,tu,tua,tuas,tudo,tão,tém,têm,tínhamos,um,uma,umas,uns,usa,usar,vai,vais,valor,veja,vem,vens,ver,verdade,verdadeiro,vez,vezes,viagem,vindo,vinte,você,vocês,vos,vossa,vossas,vosso,vossos,vários,vão,vêm,vós,zero,à,às,área,é,éramos,és,último";
    
    public String removerStopWords(String Sentence){
        StopWords = ListaDePalavras.split(",");
        List<String> Selecionadas = new ArrayList<>();
        String NewSentence="SENTENÇA VAZIA";
        Boolean achou = false;
        ProcessarTexto analisar = new ProcessarTexto();
        List<String> Tokens = analisar.tokens(Sentence);
        
        for(String token: Tokens){
            token = token.toLowerCase();
            for(String word: StopWords){
                if(word.equals(token)){
                    achou = true;
                    break;
                }
            }
            if(achou == false)
                Selecionadas.add(token);
            else
                achou = false;
        }
        
        return NewSentence = String.join(" ", Selecionadas);
    }
}
