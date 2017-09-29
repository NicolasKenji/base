package baseball;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.io.*;
import java.util.*;
import jxl.Workbook;
import jxl.write.DateFormat;
import jxl.write.Number;
import jxl.write.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Partida extends javax.swing.JFrame {
    private Class_Partida partida;
    private ArrayList<Class_Jogadores> jogadores;
    private Class_Equipes[] equipes;
    private int X_Home = 340;
    private int Y_Home = 330;
    private int X_Primeira_Base = 420;
    private int Y_Primeira_Base = 220;
    private int X_Segunda_Base = 320;
    private int Y_Segunda_Base = 130;
    private int X_Terceira_Base = 230;
    private int Y_Terceira_Base = 230;
    private boolean Primeira_Base_Cheia = false;
    private boolean Segunda_Base_Cheia = false;
    private boolean Terceira_Base_Cheia = false;
    private Class_Jogadores jogador_aux;
    private int Batedor;
    private int Batedor_Primeira_Base;
    private int Batedor_Segunda_Base;
    private int Batedor_Terceira_Base;
    private String j;
    private int Equipe_Def;
    private Timer timer;  
    private Timer t;
    private Timer t2;
    private Timer t3;
    private Timer t4;
    private int currentSegundo = 0;
    private int currentMinuto = 0;
    private int currentHora = 0;
    private int velocidade = 1000;
    private int AUX;
    private int AUY;
    private int AUX2;
    private int AUY2;
    private int AUX3;
    private int AUY3;
    private int AUX4;
    private int AUY4;
    DecimalFormat df;
    private int Pitcher_Do_Inning;
    public Partida(ArrayList<Class_Jogadores> jogadores, Class_Equipes[] equipes, int Defesa) {
        initComponents();
        this.df = new DecimalFormat("0.000");
        this.jogadores = jogadores;
        this.equipes = equipes;
        this.Equipe_Def = Defesa;
        this.setLocationRelativeTo(null);
        Setar_Labels();
        jLabel_Equipe1.setText(equipes[0].getNome_Equipe());
        jLabel_Equipe2.setText(equipes[1].getNome_Equipe());  
        iniciarContagem();
        stopTime();
    }
    public void setPitcher_Do_Inning(int Pitcher_Do_Inning){
        this.Pitcher_Do_Inning = Pitcher_Do_Inning;
    }
    public int getPitcher_Do_Inning(){
        return this.Pitcher_Do_Inning;
    }
    public void setEliminacao_Batida(int i){
        jogadores.get(i).setN_Eliminacoes_Batida_1();
    } 
    public void Zerar_Variaveis(){
        Primeira_Base_Cheia = false;
        Segunda_Base_Cheia = false;
        Terceira_Base_Cheia = false;
        Batedor_Primeira_Base = 0;
        Batedor_Segunda_Base = 0;
        Batedor_Terceira_Base = 0;
    }
    private void iniciarContagem() {
        ActionListener action = new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                currentSegundo++;
                
                if(currentSegundo==60){
                    currentMinuto++;
                    currentSegundo = 0;
                }
                
                if(currentMinuto==60){
                    currentHora++;
                    currentMinuto = 0;
                }
                
                String hr = currentHora <= 9? "0"+currentHora:currentHora+"";
                String min = currentMinuto <= 9? "0"+currentMinuto:currentMinuto+"";
                String seg = currentSegundo <= 9? "0"+currentSegundo:currentSegundo+"";
                
                jCronometro.setText(hr+":"+min+":"+seg);  
            }  
        };  
        this.timer = new Timer(velocidade, action);  
        this.timer.start();
    }
    private void stopTime() {
        timer.stop();
        currentHora = 0;
        currentMinuto = 0;
        currentSegundo = 0;
        jCronometro.setText("00:00:00");
}
    private String Label_Painel_Jogadores(int o){
        j = "Nº "+jogadores.get(o).getNumero_Camisa()+ "    Nome: "+jogadores.get(o).getNome_Jogador();
        return j;
    }
    private void Verificar_Label(int x){
    if(x == 0){
        jogadores.get(x).setLabel_jogador(jJogador1);
        jLabel_JogadorDetalhes_1.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
        
    }
    else if(x == 1){
        jogadores.get(x).setLabel_jogador(jJogador2);
        jLabel_JogadorDetalhes_2.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 2){
        jogadores.get(x).setLabel_jogador(jJogador3);
        jLabel_JogadorDetalhes_3.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 3){
        jogadores.get(x).setLabel_jogador(jJogador4);
        jLabel_JogadorDetalhes_4.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 4){
        jogadores.get(x).setLabel_jogador(jJogador5);
        jLabel_JogadorDetalhes_5.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 5){
        jogadores.get(x).setLabel_jogador(jJogador6);
        jLabel_JogadorDetalhes_6.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 6){
        jogadores.get(x).setLabel_jogador(jJogador7);
        jLabel_JogadorDetalhes_7.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 7){
        jogadores.get(x).setLabel_jogador(jJogador8);
        jLabel_JogadorDetalhes_8.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 8){
        jogadores.get(x).setLabel_jogador(jJogador9);
        jLabel_JogadorDetalhes_9.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 9){
        jogadores.get(x).setLabel_jogador(jJogador21);
        jLabel_JogadorDetalhes_21.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 10){
        jogadores.get(x).setLabel_jogador(jJogador22);
        jLabel_JogadorDetalhes_22.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 11){
        jogadores.get(x).setLabel_jogador(jJogador23);
        jLabel_JogadorDetalhes_23.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 12){
        jogadores.get(x).setLabel_jogador(jJogador24);
        jLabel_JogadorDetalhes_24.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 13){
        jogadores.get(x).setLabel_jogador(jJogador25);
        jLabel_JogadorDetalhes_25.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 14){
        jogadores.get(x).setLabel_jogador(jJogador26);
        jLabel_JogadorDetalhes_26.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 15){
        jogadores.get(x).setLabel_jogador(jJogador27);
        jLabel_JogadorDetalhes_27.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 16){
        jogadores.get(x).setLabel_jogador(jJogador28);
        jLabel_JogadorDetalhes_28.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 17){
        jogadores.get(x).setLabel_jogador(jJogador29);
        jLabel_JogadorDetalhes_29.setText(Label_Painel_Jogadores(x));
        jogadores.get(x).getLabel_jogador().setText(jogadores.get(x).getNumero_Camisa());
        jogadores.get(x).getLabel_jogador().setName(Integer.toString(x));
    }
}
    public void Setar_Labels(){
        for(int x=0;x<18;x++){
            if("PITCHER".equals(this.jogadores.get(x).getPosicao_Jogador())){
                jogadores.get(x).setPosicao_X_Defesa(320);
                jogadores.get(x).setPosicao_Y_Defesa(210);
                
                if(equipes[0].getNome_Equipe().equals(jogadores.get(x).getEquipe())){
                    jogadores.get(x).setPosicao_X_Ataque(30);
                    jogadores.get(x).setPosicao_y_Ataque(240); 
                }
                else{
                    jogadores.get(x).setPosicao_X_Ataque(560);
                    jogadores.get(x).setPosicao_y_Ataque(240); 
                }
                Verificar_Label(x);
            }  
            if("CATCHER".equals(this.jogadores.get(x).getPosicao_Jogador())){
                jogadores.get(x).setPosicao_X_Defesa(320);
                jogadores.get(x).setPosicao_Y_Defesa(360);
                if(equipes[0].getNome_Equipe().equals(jogadores.get(x).getEquipe())){
                    jogadores.get(x).setPosicao_X_Ataque(80);
                    jogadores.get(x).setPosicao_y_Ataque(240); 
                }
                else{
                    jogadores.get(x).setPosicao_X_Ataque(610);
                    jogadores.get(x).setPosicao_y_Ataque(240); 
                }
                Verificar_Label(x);
            }  
            if("FIRST BASE".equals(this.jogadores.get(x).getPosicao_Jogador())){
                jogadores.get(x).setPosicao_X_Defesa(450);
                jogadores.get(x).setPosicao_Y_Defesa(200);
                
                if(equipes[0].getNome_Equipe().equals(jogadores.get(x).getEquipe())){
                    jogadores.get(x).setPosicao_X_Ataque(30);
                    jogadores.get(x).setPosicao_y_Ataque(270); 
                }
                else{
                    jogadores.get(x).setPosicao_X_Ataque(560);
                    jogadores.get(x).setPosicao_y_Ataque(270); 
                }
                Verificar_Label(x);
            }  
            if("SECOND BASE".equals(this.jogadores.get(x).getPosicao_Jogador())){
                jogadores.get(x).setPosicao_X_Defesa(400);
                jogadores.get(x).setPosicao_Y_Defesa(150);
                
                if(equipes[0].getNome_Equipe().equals(jogadores.get(x).getEquipe())){
                    jogadores.get(x).setPosicao_X_Ataque(80);
                    jogadores.get(x).setPosicao_y_Ataque(270); 
                }
                else{
                    jogadores.get(x).setPosicao_X_Ataque(610);
                    jogadores.get(x).setPosicao_y_Ataque(270); 
                }
                Verificar_Label(x);
            }  
            if("SHORTSTOP".equals(this.jogadores.get(x).getPosicao_Jogador())){
                jogadores.get(x).setPosicao_X_Defesa(250);
                jogadores.get(x).setPosicao_Y_Defesa(150);
                
                if(equipes[0].getNome_Equipe().equals(jogadores.get(x).getEquipe())){
                    jogadores.get(x).setPosicao_X_Ataque(30);
                    jogadores.get(x).setPosicao_y_Ataque(300); 
                }
                else{
                    jogadores.get(x).setPosicao_X_Ataque(560);
                    jogadores.get(x).setPosicao_y_Ataque(300); 
                }
                Verificar_Label(x);
            }  
            if("THIRD BASE".equals(this.jogadores.get(x).getPosicao_Jogador())){
                jogadores.get(x).setPosicao_X_Defesa(200);
                jogadores.get(x).setPosicao_Y_Defesa(200);
                
                if(equipes[0].getNome_Equipe().equals(jogadores.get(x).getEquipe())){
                    jogadores.get(x).setPosicao_X_Ataque(80);
                    jogadores.get(x).setPosicao_y_Ataque(300); 
                }
                else{
                    jogadores.get(x).setPosicao_X_Ataque(610);
                    jogadores.get(x).setPosicao_y_Ataque(300); 
                }
                Verificar_Label(x);
            }  
            if("LEFT FIELD".equals(this.jogadores.get(x).getPosicao_Jogador())){
                jogadores.get(x).setPosicao_X_Defesa(160);
                jogadores.get(x).setPosicao_Y_Defesa(70);
                
                if(equipes[0].getNome_Equipe().equals(jogadores.get(x).getEquipe())){
                    jogadores.get(x).setPosicao_X_Ataque(30);
                    jogadores.get(x).setPosicao_y_Ataque(330); 
                }
                else{
                    jogadores.get(x).setPosicao_X_Ataque(560);
                    jogadores.get(x).setPosicao_y_Ataque(330); 
                }
                Verificar_Label(x);
            }  
            if("CENTER FIELD".equals(this.jogadores.get(x).getPosicao_Jogador())){
                jogadores.get(x).setPosicao_X_Defesa(320);
                jogadores.get(x).setPosicao_Y_Defesa(20);
                
                if(equipes[0].getNome_Equipe().equals(jogadores.get(x).getEquipe())){
                    jogadores.get(x).setPosicao_X_Ataque(80);
                    jogadores.get(x).setPosicao_y_Ataque(330); 
                }
                else{
                    jogadores.get(x).setPosicao_X_Ataque(610);
                    jogadores.get(x).setPosicao_y_Ataque(330); 
                }
                Verificar_Label(x);
            }  
            if("RIGHT FIELD".equals(this.jogadores.get(x).getPosicao_Jogador())){
                jogadores.get(x).setPosicao_X_Defesa(460);
                jogadores.get(x).setPosicao_Y_Defesa(60);
                
                if(equipes[0].getNome_Equipe().equals(jogadores.get(x).getEquipe())){
                    jogadores.get(x).setPosicao_X_Ataque(30);
                    jogadores.get(x).setPosicao_y_Ataque(360); 
                }
                else{
                    jogadores.get(x).setPosicao_X_Ataque(560);
                    jogadores.get(x).setPosicao_y_Ataque(360); 
                }
                Verificar_Label(x);
            }  
        }
    }
    public void Atualizar_Pontuacao(){
        jLabel_Pontuacao1.setText(Integer.toString(partida.getPontuacao_Equipe0())); 
        jLabel_Pontuacao2.setText(Integer.toString(partida.getPontuacao_Equipe1())); 
        jLabel_Qt_Balls.setText(Integer.toString(partida.getBalls()));
        jLabel_Qt_Strikes.setText(Integer.toString(partida.getStrikes()));
        jLabel_Qt_Outs.setText(Integer.toString(partida.getOuts()));
    }
    public void Verificar_Balls(){
        if(partida.getBalls() == 4){
            setBatedor_Proxima_Base();
            jogadores.get(getPitcher_Do_Inning()).setN_Walks_Pitcher_1();
            partida.setZerarBalls();
        }
    }
    public boolean Verificar_Outs(){
        if(partida.getOuts() == 3){
            partida.setZerarOuts();
            Zerar_Variaveis();     
            Alterar_Defesa();
            return true;
        }
        return false;
    }
    public void Verificar_Strikes(){
        if(partida.getStrikes() == 3){
            jogadores.get(getPitcher_Do_Inning()).setN_Strikes_Outs_1();
            partida.setZerarBalls();
            Eliminar_Jogador_StrikeOut(Batedor);
            setProximo_Batedor();
            Verificar_Outs();
        }
    }
    public void setDead_Ball(){
        jogadores.get(getPitcher_Do_Inning()).setN_Arremessos_1(); 
        jogadores.get(getPitcher_Do_Inning()).setN_Dead_Balls_1();
        partida.setZerarBalls();
            jogadores.get(Batedor).setHPB();
            setBatedor_Proxima_Base();
        Atualizar_Pontuacao();
    }
    public void Eliminar_Jogador_StrikeOut(int i){  
        jogadores.get(i).setN_Eliminacoes_1();
        jogadores.get(i).setN_Strike_Out_Sofridos_1();
        partida.setOuts();
        if(Equipe_Def == 0){
            jogadores.get(i).getLabel_jogador().setLocation(jogadores.get(partida.getAtacador_Equipe1()).getPosicao_X_Ataque(), jogadores.get(partida.getAtacador_Equipe1()).getPosicao_y_Ataque());
        }
        else if (Equipe_Def == 1){
            jogadores.get(i).getLabel_jogador().setLocation(jogadores.get(partida.getAtacador_Equipe0()).getPosicao_X_Ataque(), jogadores.get(partida.getAtacador_Equipe0()).getPosicao_y_Ataque());
        }
    }
    public void Eliminar_Jogador(int i){  
        jogadores.get(i).setN_Eliminacoes_1();
        partida.setOuts();
        
        if(i == Batedor_Primeira_Base){
            Primeira_Base_Cheia = false;
        }
        else if(i == Batedor_Segunda_Base){
            Segunda_Base_Cheia = false;
        }
        else if(i == Batedor_Terceira_Base){
            Terceira_Base_Cheia = false;
        }
        if(Equipe_Def == 0){
            jogadores.get(i).getLabel_jogador().setLocation(jogadores.get(partida.getAtacador_Equipe1()).getPosicao_X_Ataque(), jogadores.get(partida.getAtacador_Equipe1()).getPosicao_y_Ataque());
        }
        else if (Equipe_Def == 1){
            jogadores.get(i).getLabel_jogador().setLocation(jogadores.get(partida.getAtacador_Equipe0()).getPosicao_X_Ataque(), jogadores.get(partida.getAtacador_Equipe0()).getPosicao_y_Ataque());
        }
        Atualizar_Pontuacao();
        Verificar_Outs();
    }
    public void setProximo_Batedor(){
        if(Equipe_Def == 0){
            partida.setAtacador_Equipe1();
            jogadores.get(partida.getAtacador_Equipe1()).getLabel_jogador().setLocation(X_Home, Y_Home);
            this.Batedor = partida.getAtacador_Equipe1();
        }
        else if (Equipe_Def == 1){
            partida.setAtacador_Equipe0();
            jogadores.get(partida.getAtacador_Equipe0()).getLabel_jogador().setLocation(X_Home, Y_Home);
            this.Batedor = partida.getAtacador_Equipe0();
        }
    }
    private void setPrimeira_Base_Equipe(JLabel jo1, int i) {
        Primeira_Base_Cheia = true;
        Batedor_Primeira_Base = i;
        AUX = X_Home;
        AUY = Y_Home;
        ActionListener acao = new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                if(AUX < X_Primeira_Base){
                    AUX++;
                }
                if(AUY > Y_Primeira_Base){
                    AUY--;
                }

                jo1.setLocation(AUX, AUY); 
                if(AUX >= X_Primeira_Base && AUY <= Y_Primeira_Base){
                    t.stop();
                }
            }  
        };  
        this.t = new Timer(10, acao);  
        this.t.start();
    }
    private void setSegunda_Base_Equipe(JLabel jo2) {
        Segunda_Base_Cheia = true;
        Batedor_Segunda_Base = Batedor_Primeira_Base;
        AUX2 = X_Primeira_Base;
        AUY2 = Y_Primeira_Base;
        ActionListener acao2 = new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                if(AUX2 > X_Segunda_Base){
                    AUX2--;
                }
                if(AUY2 > Y_Segunda_Base){
                    AUY2--;
                }
                jo2.setLocation(AUX2, AUY2); 
                if(AUX2 <= X_Segunda_Base && AUY2 <= Y_Segunda_Base){
                    t2.stop();
                }
            }  
        };  
        this.t2 = new Timer(10, acao2);  
        this.t2.start();
    }
    private void setTerceira_Base_Equipe(JLabel jo3) {
        Terceira_Base_Cheia = true;
        Batedor_Terceira_Base = Batedor_Segunda_Base;
        AUX3 = X_Segunda_Base;
        AUY3 = Y_Segunda_Base;
        ActionListener acao3 = new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                if(AUX3 > X_Terceira_Base){
                    AUX3--;
                }
                if(AUY3 < Y_Terceira_Base){
                    AUY3++;
                }

                jo3.setLocation(AUX3, AUY3); 
                if(AUX3 <= X_Terceira_Base && AUY3 >= Y_Terceira_Base){
                    t3.stop();
                }
            }  
        };  
        this.t3 = new Timer(10, acao3);  
        this.t3.start();
    }
    private void setHome_Base_Equipe(JLabel jo4) {
        AUX4 = X_Terceira_Base;
        AUY4 = Y_Terceira_Base;
        ActionListener acao4 = new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                if(AUX4 < X_Home){
                    AUX4++;
                }
                if(AUY4 < Y_Home){
                    AUY4++;
                }
                jo4.setLocation(AUX4, AUY4); 
                if(AUX4 >= X_Home && AUY4 >= Y_Home){
                    t4.stop();
                    jogadores.get(Batedor_Terceira_Base).setN_Pontos_Feitos_1();
                    if(Equipe_Def == 1){
                        jo4.setLocation(jogadores.get(partida.getAtacador_Equipe0()).getPosicao_X_Ataque(), jogadores.get(partida.getAtacador_Equipe0()).getPosicao_y_Ataque());
                        partida.setPontuacao_Equipe0();
                        Atualizar_Pontuacao();
                    }
                    else if(Equipe_Def == 0){
                        jo4.setLocation(jogadores.get(partida.getAtacador_Equipe1()).getPosicao_X_Ataque(), jogadores.get(partida.getAtacador_Equipe1()).getPosicao_y_Ataque());
                        partida.setPontuacao_Equipe1();
                        Atualizar_Pontuacao();
                    } 
                }
            }  
        };  
        this.t4 = new Timer(10, acao4);  
        this.t4.start();
    }
    public void setRebatida_Simples(){
        partida.setZerarBalls();
        jogadores.get(Batedor).setN_Rebatidas_Simples_1();
        setBatedor_Proxima_Base();
        Atualizar_Pontuacao();
    }
    public void setBatedor_Proxima_Base(){
        if(Primeira_Base_Cheia == false){
                setPrimeira_Base_Equipe(jogadores.get(this.Batedor).getLabel_jogador(), Batedor);
            }
            else if(Primeira_Base_Cheia == true && Segunda_Base_Cheia == false){
                setSegunda_Base_Equipe(jogadores.get(Batedor_Primeira_Base).getLabel_jogador());
                setPrimeira_Base_Equipe(jogadores.get(this.Batedor).getLabel_jogador(), Batedor);

            }
            else if(Primeira_Base_Cheia == true && Segunda_Base_Cheia == true && Terceira_Base_Cheia == false){
                setTerceira_Base_Equipe(jogadores.get(Batedor_Segunda_Base).getLabel_jogador());
                setSegunda_Base_Equipe(jogadores.get(Batedor_Primeira_Base).getLabel_jogador());
                setPrimeira_Base_Equipe(jogadores.get(this.Batedor).getLabel_jogador(), Batedor);
            }
            else if(Primeira_Base_Cheia == true && Segunda_Base_Cheia == true && Terceira_Base_Cheia == true){          
                setHome_Base_Equipe(jogadores.get(Batedor_Terceira_Base).getLabel_jogador());
                setTerceira_Base_Equipe(jogadores.get(Batedor_Segunda_Base).getLabel_jogador());
                setSegunda_Base_Equipe(jogadores.get(Batedor_Primeira_Base).getLabel_jogador());
                setPrimeira_Base_Equipe(jogadores.get(this.Batedor).getLabel_jogador(), Batedor);
            }
        setProximo_Batedor();
    }
    public boolean Verificar_Proxima_Base(int i){
        if(Batedor_Segunda_Base == i){
            return Terceira_Base_Cheia;
        }
        else if(Batedor_Primeira_Base == i){
            return Segunda_Base_Cheia;
        }
        else if(Batedor == i){
            return Primeira_Base_Cheia;
        }
        return false;
    }
    public void setRoubo_Base(int i){
        jogadores.get(i).setN_Roubos_Bases_1();
        if(i == Batedor_Primeira_Base){
            if(Segunda_Base_Cheia){
                JOptionPane.showMessageDialog(null, "Base destino está cheia, manipule ela primeiro.");
            }
            else{
                Batedor_Segunda_Base = i;
                Primeira_Base_Cheia = false;
                setSegunda_Base_Equipe(jogadores.get(i).getLabel_jogador());
                
            }
        }
        else if(i == Batedor_Segunda_Base){
            
        }
        else if(i == Batedor_Terceira_Base){
            
        }
    }
    public void Alterar_Defesa(){
        if(this.Equipe_Def == 1){
        Equipe_Def = 0;
        for(int i=0;i<=8;i++){
            jogadores.get(i).getLabel_jogador().setLocation(jogadores.get(i).getPosicao_X_Defesa(), jogadores.get(i).getPosicao_Y_Defesa());
            if("PITCHER".equals(jogadores.get(i).getPosicao_Jogador())){
                setPitcher_Do_Inning(i);
            }
        }
        for(int i=9;i<18;i++){
            jogadores.get(i).getLabel_jogador().setLocation(jogadores.get(i).getPosicao_X_Ataque(), jogadores.get(i).getPosicao_y_Ataque());
        }
        jogadores.get(partida.getAtacador_Equipe1()).getLabel_jogador().setLocation(X_Home, Y_Home);
        Batedor = partida.getAtacador_Equipe1();
        
        }
        else if(this.Equipe_Def == 0){
            Equipe_Def = 1;
            for(int i=9;i<=17;i++){
                jogadores.get(i).getLabel_jogador().setLocation(jogadores.get(i).getPosicao_X_Defesa(), jogadores.get(i).getPosicao_Y_Defesa());
                if("PITCHER".equals(jogadores.get(i).getPosicao_Jogador())){
                setPitcher_Do_Inning(i);     
            }
            }
            for(int i=0;i<9;i++){
                jogadores.get(i).getLabel_jogador().setLocation(jogadores.get(i).getPosicao_X_Ataque(), jogadores.get(i).getPosicao_y_Ataque());
            }
            jogadores.get(partida.getAtacador_Equipe0()).getLabel_jogador().setLocation(X_Home, Y_Home);
            Batedor =  partida.getAtacador_Equipe0();
        }
    }
    public void Rebatida_Simples(){
        if(Terceira_Base_Cheia){
            int dialogResult = Opcoes_Corredor(Batedor_Terceira_Base, "Terceira");
            if(dialogResult == 0){
                setHome_Base_Equipe(jogadores.get(Batedor_Terceira_Base).getLabel_jogador());
                Terceira_Base_Cheia = false;
            }
            else if(dialogResult == 2){
                Eliminar_Jogador(Batedor_Terceira_Base);
                Terceira_Base_Cheia = false;
            }
        }
        if(Segunda_Base_Cheia){
            int dialogResult2 = Opcoes_Corredor(Batedor_Segunda_Base, "Segunda");
            if(dialogResult2 == 0){
                if(!Verificar_Proxima_Base(Batedor_Segunda_Base)){
                    setTerceira_Base_Equipe(jogadores.get(Batedor_Segunda_Base).getLabel_jogador());
                    Segunda_Base_Cheia = false;
                }
                else{
                    JOptionPane.showMessageDialog(null, "O jogador não pode avançar, pois a base destino está cheia.");
                }
            }
            else if(dialogResult2 == 2){
                Eliminar_Jogador(Batedor_Segunda_Base);
                Segunda_Base_Cheia = false;
            }
        }
        if(Primeira_Base_Cheia){
            int dialogResult3 = Opcoes_Corredor(Batedor_Primeira_Base, "Primeira");
            if(dialogResult3 == 0){
                if(!Verificar_Proxima_Base(Batedor_Primeira_Base)){
                    setSegunda_Base_Equipe(jogadores.get(Batedor_Primeira_Base).getLabel_jogador());
                    Primeira_Base_Cheia = false;
                }
                else{
                    JOptionPane.showMessageDialog(null, "O jogador não pode avançar, pois a base destino está cheia.");
                }
            }
            else if(dialogResult3 == 2){
                Eliminar_Jogador(Batedor_Primeira_Base);
                Segunda_Base_Cheia = false;
            }
        }
        setPrimeira_Base_Equipe(jogadores.get(Batedor).getLabel_jogador(), Batedor);
        setProximo_Batedor(); 
        partida.setZerarBalls();
        Atualizar_Pontuacao();
    }
    public void Rebatida_Dupla(){
        if(Terceira_Base_Cheia){
            int dialogResult = JOptionPane.showConfirmDialog(null, "O jogador da terceira base fez o ponto?");
            if(dialogResult == JOptionPane.YES_OPTION){
                setHome_Base_Equipe(jogadores.get(Batedor_Terceira_Base).getLabel_jogador());
            }
            else if(dialogResult == JOptionPane.NO_OPTION){
                if(Segunda_Base_Cheia){
                    int dialogResult2 = JOptionPane.showConfirmDialog(null, "Clique em 'Sim' para eliminar o jogador da Terceira Base\n"
                                                                        + "'Não para '");
                }
                
                Eliminar_Jogador(Batedor_Terceira_Base);
            }
            Terceira_Base_Cheia = false;
        }
    }
    public void sendEmail(){

    }
    public int Opcoes_Corredor(int jog_x, String corredor){
        String[] values = {"Avançar para proxima base", "Permanecer na base atual", "Eliminar o jogador"};

        Object selected = JOptionPane.showInputDialog(null, "Escolha a ação do corredor da "+corredor+" base:", "Manipular corredor", JOptionPane.DEFAULT_OPTION, null, values, "0");
        if ( selected != null ){
            String selectedString = selected.toString();
            
            if(selected == values[0]){
                return 0;
            }
            else if(selected == values[1]){
                return 1;
            }
            else if(selected == values[2]){
                return 2;
            }
        }else{
            System.out.println("Não escolheu nenhuma opção");
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Equipe1 = new javax.swing.JLabel();
        jLabel_Equipe2 = new javax.swing.JLabel();
        jLabel_Pontuacao1 = new javax.swing.JLabel();
        jLabel_Pontuacao2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel_Qt_Strikes = new javax.swing.JLabel();
        jLabel_Qt_Balls = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel_Qt_Outs = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel_JogadorDetalhes_1 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_2 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_3 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_4 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_5 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_6 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_7 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_8 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel_JogadorDetalhes_21 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_22 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_23 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_27 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_28 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_26 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_25 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_29 = new javax.swing.JLabel();
        jLabel_JogadorDetalhes_24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton8 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jPanel_Campo = new javax.swing.JPanel();
        jJogador9 = new javax.swing.JLabel();
        jJogador1 = new javax.swing.JLabel();
        jJogador2 = new javax.swing.JLabel();
        jJogador3 = new javax.swing.JLabel();
        jJogador4 = new javax.swing.JLabel();
        jJogador5 = new javax.swing.JLabel();
        jJogador8 = new javax.swing.JLabel();
        jJogador6 = new javax.swing.JLabel();
        jJogador7 = new javax.swing.JLabel();
        jJogador21 = new javax.swing.JLabel();
        jJogador25 = new javax.swing.JLabel();
        jJogador26 = new javax.swing.JLabel();
        jJogador27 = new javax.swing.JLabel();
        jJogador28 = new javax.swing.JLabel();
        jJogador29 = new javax.swing.JLabel();
        jJogador22 = new javax.swing.JLabel();
        jJogador23 = new javax.swing.JLabel();
        jJogador24 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jCronometro = new javax.swing.JLabel();
        jButton_Pausar = new javax.swing.JButton();
        jButton_Finalizar = new javax.swing.JButton();
        jButton_Comecar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setBackground(new java.awt.Color(255, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Placar");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel_Equipe1.setText("jLabel3");

        jLabel_Equipe2.setText("jLabel3");

        jLabel_Pontuacao1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Pontuacao1.setText("0");

        jLabel_Pontuacao2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Pontuacao2.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel_Equipe1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Pontuacao1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel_Equipe2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Pontuacao2)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Equipe1)
                    .addComponent(jLabel_Pontuacao1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Equipe2)
                    .addComponent(jLabel_Pontuacao2))
                .addGap(0, 49, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Strike / Ball");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Strikes:");

        jLabel7.setText("Balls:");

        jLabel_Qt_Strikes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Qt_Strikes.setText("0");

        jLabel_Qt_Balls.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Qt_Balls.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Qt_Strikes))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Qt_Balls)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel_Qt_Strikes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel_Qt_Balls))
                .addGap(0, 37, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setBackground(new java.awt.Color(255, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Out");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Out:");

        jLabel_Qt_Outs.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Qt_Outs.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Qt_Outs)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel_Qt_Outs))
                .addGap(0, 38, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setBackground(new java.awt.Color(255, 51, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Pitcher");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setText("Strike");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ball");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Dead");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Princial", jPanel2);

        jPanel3.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel_JogadorDetalhes_1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_1.setText("jLabel3");

        jLabel_JogadorDetalhes_2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_2.setText("jLabel4");

        jLabel_JogadorDetalhes_3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_3.setText("jLabel5");

        jLabel_JogadorDetalhes_4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_4.setText("jLabel6");

        jLabel_JogadorDetalhes_5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_5.setText("jLabel7");

        jLabel_JogadorDetalhes_6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_6.setText("jLabel8");

        jLabel_JogadorDetalhes_7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_7.setText("jLabel9");

        jLabel_JogadorDetalhes_8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_8.setText("jLabel10");

        jLabel_JogadorDetalhes_9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_9.setText("jLabel11");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_JogadorDetalhes_1)
                    .addComponent(jLabel_JogadorDetalhes_2)
                    .addComponent(jLabel_JogadorDetalhes_3)
                    .addComponent(jLabel_JogadorDetalhes_4)
                    .addComponent(jLabel_JogadorDetalhes_5)
                    .addComponent(jLabel_JogadorDetalhes_6)
                    .addComponent(jLabel_JogadorDetalhes_7)
                    .addComponent(jLabel_JogadorDetalhes_8)
                    .addComponent(jLabel_JogadorDetalhes_9))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_JogadorDetalhes_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_9)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6);
        jPanel6.setBounds(0, 0, 215, 240);

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel_JogadorDetalhes_21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_21.setText("jLabel3");

        jLabel_JogadorDetalhes_22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_22.setText("jLabel4");

        jLabel_JogadorDetalhes_23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_23.setText("jLabel5");

        jLabel_JogadorDetalhes_27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_27.setText("jLabel9");

        jLabel_JogadorDetalhes_28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_28.setText("jLabel10");

        jLabel_JogadorDetalhes_26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_26.setText("jLabel8");

        jLabel_JogadorDetalhes_25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_25.setText("jLabel7");

        jLabel_JogadorDetalhes_29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_29.setText("jLabel11");

        jLabel_JogadorDetalhes_24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_JogadorDetalhes_24.setText("jLabel6");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_JogadorDetalhes_21)
                    .addComponent(jLabel_JogadorDetalhes_22)
                    .addComponent(jLabel_JogadorDetalhes_23)
                    .addComponent(jLabel_JogadorDetalhes_24)
                    .addComponent(jLabel_JogadorDetalhes_25)
                    .addComponent(jLabel_JogadorDetalhes_26)
                    .addComponent(jLabel_JogadorDetalhes_27)
                    .addComponent(jLabel_JogadorDetalhes_28)
                    .addComponent(jLabel_JogadorDetalhes_29))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_JogadorDetalhes_21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_JogadorDetalhes_29)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel7);
        jPanel7.setBounds(0, 238, 215, 240);

        jTabbedPane1.addTab("Jogadores", jPanel3);

        jPanel11.setBackground(new java.awt.Color(0, 153, 255));
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PITCHER", "CATCHER", "FIRST BASE", "SECOND BASE", "THIRD BASE", "SHORTSTOP", "LEFT FIELD", "CENTER FIELD", "RIGHT FIELD" }));
        jPanel11.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 114, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Substituir:");
        jPanel11.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Trocar de posição");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel11.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 52, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Entrada de novo jogador");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel11.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PITCHER", "CATCHER", "FIRST BASE", "SECOND BASE", "THIRD BASE", "SHORTSTOP", "LEFT FIELD", "CENTER FIELD", "RIGHT FIELD" }));
        jPanel11.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 122, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Destino:");
        jPanel11.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 10));
        jPanel11.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 124, -1));

        jLabel11.setText("Nome:");
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));
        jPanel11.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 62, -1));

        jLabel12.setText("Camisa:");
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jButton7.setText("Substituir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jPanel12.setBackground(new java.awt.Color(255, 51, 51));
        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Entrada de novo jogador");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel12.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jButton8.setText("Substituir");
        jPanel12.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Destino:");
        jPanel12.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PITCHER", "CATCHER", "FIRST BASE", "SECOND BASE", "THIRD BASE", "SHORTSTOP", "LEFT FIELD", "CENTER FIELD", "RIGHT FIELD" }));
        jPanel12.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 122, -1));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Trocar de posição");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel12.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 41, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Substituir:");
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel13.setText("Camisa:");
        jPanel12.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));
        jPanel12.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 62, -1));

        jLabel14.setText("Nome:");
        jPanel12.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        jPanel12.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 124, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PITCHER", "CATCHER", "FIRST BASE", "SECOND BASE", "THIRD BASE", "SHORTSTOP", "LEFT FIELD", "CENTER FIELD", "RIGHT FIELD" }));
        jPanel12.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 114, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Substituição", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 560));

        jPanel_Campo.setLayout(null);

        jJogador9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola azul.png"))); // NOI18N
        jJogador9.setText("99");
        jJogador9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador9_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador9);
        jJogador9.setBounds(30, 360, 50, 23);

        jJogador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola azul.png"))); // NOI18N
        jJogador1.setText("10");
        jJogador1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador1_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador1);
        jJogador1.setBounds(30, 240, 50, 23);

        jJogador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola azul.png"))); // NOI18N
        jJogador2.setText("22");
        jJogador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogado2_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador2);
        jJogador2.setBounds(80, 240, 50, 23);

        jJogador3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola azul.png"))); // NOI18N
        jJogador3.setText("33");
        jJogador3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador3_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador3);
        jJogador3.setBounds(30, 270, 50, 23);

        jJogador4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola azul.png"))); // NOI18N
        jJogador4.setText("44");
        jJogador4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador4_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador4);
        jJogador4.setBounds(80, 270, 50, 23);

        jJogador5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola azul.png"))); // NOI18N
        jJogador5.setText("55");
        jJogador5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador5_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador5);
        jJogador5.setBounds(30, 300, 50, 23);

        jJogador8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola azul.png"))); // NOI18N
        jJogador8.setText("88");
        jJogador8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador8_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador8);
        jJogador8.setBounds(80, 330, 50, 23);

        jJogador6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola azul.png"))); // NOI18N
        jJogador6.setText("66");
        jJogador6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador6_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador6);
        jJogador6.setBounds(80, 300, 50, 23);

        jJogador7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola azul.png"))); // NOI18N
        jJogador7.setText("77");
        jJogador7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador7_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador7);
        jJogador7.setBounds(30, 330, 50, 23);

        jJogador21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola vermelha.png"))); // NOI18N
        jJogador21.setText("00");
        jJogador21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador21_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador21);
        jJogador21.setBounds(560, 240, 50, 23);

        jJogador25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola vermelha.png"))); // NOI18N
        jJogador25.setText("00");
        jJogador25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador25_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador25);
        jJogador25.setBounds(560, 300, 50, 23);

        jJogador26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola vermelha.png"))); // NOI18N
        jJogador26.setText("00");
        jJogador26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador26_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador26);
        jJogador26.setBounds(610, 300, 50, 23);

        jJogador27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola vermelha.png"))); // NOI18N
        jJogador27.setText("00");
        jJogador27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador27_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador27);
        jJogador27.setBounds(560, 330, 50, 23);

        jJogador28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola vermelha.png"))); // NOI18N
        jJogador28.setText("00");
        jJogador28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador28_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador28);
        jJogador28.setBounds(610, 330, 50, 23);

        jJogador29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola vermelha.png"))); // NOI18N
        jJogador29.setText("00");
        jJogador29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador29_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador29);
        jJogador29.setBounds(560, 360, 50, 23);

        jJogador22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola vermelha.png"))); // NOI18N
        jJogador22.setText("00");
        jJogador22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador22_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador22);
        jJogador22.setBounds(610, 240, 50, 23);

        jJogador23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola vermelha.png"))); // NOI18N
        jJogador23.setText("00");
        jJogador23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador23_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador23);
        jJogador23.setBounds(560, 270, 50, 23);

        jJogador24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/bola vermelha.png"))); // NOI18N
        jJogador24.setText("00");
        jJogador24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador24_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador24);
        jJogador24.setBounds(610, 270, 50, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/img/fundo_baseball_1.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_Campo.add(jLabel2);
        jLabel2.setBounds(130, 0, 404, 404);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setLayout(null);

        jCronometro.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jCronometro.setText("00:00:00");
        jPanel1.add(jCronometro);
        jCronometro.setBounds(102, 12, 108, 29);

        jButton_Pausar.setText("Pausar");
        jButton_Pausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PausarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Pausar);
        jButton_Pausar.setBounds(120, 100, 80, 23);

        jButton_Finalizar.setText("Finalizar");
        jButton_Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FinalizarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Finalizar);
        jButton_Finalizar.setBounds(210, 100, 90, 23);

        jButton_Comecar.setText("Começar");
        jButton_Comecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ComecarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Comecar);
        jButton_Comecar.setBounds(10, 100, 100, 23);

        jPanel_Campo.add(jPanel1);
        jPanel1.setBounds(170, 410, 310, 130);

        jButton1.setText("Teste SLG");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel_Campo.add(jButton1);
        jButton1.setBounds(550, 70, 100, 23);

        jButton5.setText("Exibir Pitcher");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel_Campo.add(jButton5);
        jButton5.setBounds(550, 100, 120, 23);

        jButton6.setText("Test");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel_Campo.add(jButton6);
        jButton6.setBounds(550, 130, 90, 23);

        getContentPane().add(jPanel_Campo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 690, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ComecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ComecarActionPerformed
        Class_Partida partida = new Class_Partida();
        this.partida = partida;
        partida.setAtacador_Equipe0();
        partida.setAtacador_Equipe1();
        Alterar_Defesa();
        timer.restart();
    }//GEN-LAST:event_jButton_ComecarActionPerformed

    private void jButton_PausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PausarActionPerformed
    
    }//GEN-LAST:event_jButton_PausarActionPerformed

    private void jButton_FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FinalizarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Você realmente deseja terminar a partida?");
        if(dialogResult == JOptionPane.YES_OPTION){
            String local = "c:/temp/Relatorio de Partida.xls";
            stopTime();
            JOptionPane.showMessageDialog(null, "Planilha criada no local: "+local);
            WritableWorkbook planilha;
            try {
                planilha = Workbook.createWorkbook(new File(local));
                WritableSheet aba = planilha.createSheet("ListaAlunos", 0);
                String cabecalho[] = new String[5];
                cabecalho[0] = "ID";
                cabecalho[1] = "Nome";
                cabecalho[2] = "Telefone";
                cabecalho[3] = "E-mail";
                cabecalho[4] = "Data Cadastro";

                for (int i = 0; i < cabecalho.length; i++) {
                    Label label = new Label(i, 0, cabecalho[i]);
                    aba.addCell(label);
                    WritableCell cell = aba.getWritableCell(i, 0);
                }

                for (int linha = 1; linha < 10; linha++) {
                    Random numeroAleatorio = new Random();
                    Number number = new Number(0, linha,numeroAleatorio.nextInt(2000));
                    aba.addCell(number);

                    Label label = new Label(1, linha, "Jose da Silva");
                    aba.addCell(label);

                    label = new Label(2, linha, "2230-6625");
                    aba.addCell(label);

                    label = new Label(3, linha, "josesilva@feltex.com.br");
                    aba.addCell(label);

                    Date data = Calendar.getInstance().getTime();
                    DateFormat customDateFormat = new DateFormat(
                                    "dd MMM yyyy hh:mm:ss");
                    WritableCellFormat dateFormat = new WritableCellFormat(
                                    customDateFormat);
                    DateTime dateCell = new DateTime(4, linha, data, dateFormat);
                    aba.addCell(dateCell);
                }
                planilha.write();
                planilha.close();
            }catch (IOException ex) {
                Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
            }catch (WriteException ex) {
                Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
            }  
            //

        }
        
    }//GEN-LAST:event_jButton_FinalizarActionPerformed

    private void Jogador1_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador1_Click
        int Jogador = Integer.parseInt(jJogador1.getName());  
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador1_Click

    private void Jogado2_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogado2_Click
        int Jogador = Integer.parseInt(jJogador2.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogado2_Click

    private void Jogador3_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador3_Click
        int Jogador = Integer.parseInt(jJogador3.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador3_Click

    private void Jogador4_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador4_Click
        int Jogador = Integer.parseInt(jJogador4.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador4_Click

    private void Jogador5_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador5_Click
        int Jogador = Integer.parseInt(jJogador5.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador5_Click

    private void Jogador6_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador6_Click
        int Jogador = Integer.parseInt(jJogador6.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador6_Click

    private void Jogador7_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador7_Click
        int Jogador = Integer.parseInt(jJogador7.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador7_Click

    private void Jogador8_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador8_Click
        int Jogador = Integer.parseInt(jJogador8.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador8_Click

    private void Jogador9_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador9_Click
        int Jogador = Integer.parseInt(jJogador9.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador9_Click

    private void Jogador21_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador21_Click
        int Jogador = Integer.parseInt(jJogador21.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador21_Click

    private void Jogador22_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador22_Click
        int Jogador = Integer.parseInt(jJogador22.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador22_Click

    private void Jogador23_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador23_Click
        int Jogador = Integer.parseInt(jJogador23.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador23_Click

    private void Jogador24_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador24_Click
        int Jogador = Integer.parseInt(jJogador24.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador24_Click

    private void Jogador25_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador25_Click
        int Jogador = Integer.parseInt(jJogador25.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador25_Click

    private void Jogador26_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador26_Click
        int Jogador = Integer.parseInt(jJogador26.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador26_Click

    private void Jogador27_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador27_Click
        int Jogador = Integer.parseInt(jJogador27.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador27_Click

    private void Jogador28_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador28_Click
        int Jogador = Integer.parseInt(jJogador28.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador28_Click

    private void Jogador29_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador29_Click
        int Jogador = Integer.parseInt(jJogador29.getName());
        Jogadas jogada = new Jogadas(Jogador, partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_Jogador29_Click

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jogadores.get(0).setAB(10);
        jogadores.get(0).setN_Rebatidas_Simples_1();
        jogadores.get(0).setN_Rebatidas_Duplas(0);
        jogadores.get(0).setN_Rebatidas_Triplas(0);
        jogadores.get(0).setN_Rebatidas_HR(0);
        
        JOptionPane.showMessageDialog(null, df.format(jogadores.get(0).getSLG())); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jogadores.get(getPitcher_Do_Inning()).setN_Arremessos_1();
        jogadores.get(getPitcher_Do_Inning()).setN_Strikes_1();
        partida.setStrikes();
        Verificar_Strikes();
        Atualizar_Pontuacao();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JOptionPane.showMessageDialog(null, "Nº Arremessos: "+jogadores.get(getPitcher_Do_Inning()).getN_Arremessos()+
            "\n Nº Strikes: "+jogadores.get(getPitcher_Do_Inning()).getN_Strikes()+
            "\n Nº Balls: "+jogadores.get(getPitcher_Do_Inning()).getN_Balls()+
            "\n Nº Strike Outs: "+jogadores.get(getPitcher_Do_Inning()).getN_Strikes_Outs()+
            "\n Nº Dead Balls: "+jogadores.get(getPitcher_Do_Inning()).getN_Dead_Balls());
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jogadores.get(getPitcher_Do_Inning()).setN_Arremessos_1();
        jogadores.get(getPitcher_Do_Inning()).setN_Balls_1();
        partida.setBalls();
        Verificar_Balls();
        Atualizar_Pontuacao();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setDead_Ball();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        jComboBox2.setVisible(false);
        jComboBox3.setVisible(false);
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        jTextField4.setVisible(false);    
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        if(jRadioButton4.isSelected()){
            jLabel15.setVisible(true);
            jComboBox3.setVisible(true);
            
            jTextField3.setVisible(false);
            jTextField4.setVisible(false);  
            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        if(jRadioButton3.isSelected()){
            jLabel15.setVisible(false);
            jComboBox3.setVisible(false);
            
            jTextField3.setVisible(true);
            jTextField4.setVisible(true);  
            jLabel13.setVisible(true);
            jLabel14.setVisible(true);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(jRadioButton1.isSelected()){
            jLabel10.setVisible(true);
            jComboBox2.setVisible(true);
            
            jTextField1.setVisible(false);
            jTextField2.setVisible(false);  
            jLabel11.setVisible(false);
            jLabel12.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(jRadioButton2.isSelected()){
            jLabel10.setVisible(false);
            jComboBox2.setVisible(false);
            
            jTextField1.setVisible(true);
            jTextField2.setVisible(true);  
            jLabel11.setVisible(true);
            jLabel12.setVisible(true);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int i, j;
        if(jRadioButton1.isSelected()){
            for(i=0;i<8;i++){
                //ACHAR O JOGADOR 1
                if(jogadores.get(i).getPosicao_Jogador() == jComboBox1.getSelectedItem()){
                    jogador_aux = jogadores.get(i);
                    JOptionPane.showMessageDialog(null, "Nome [0]: "+jogadores.get(i).getNome_Jogador());
                }
            }
            for(j=0;j<8;j++){
                //ACHAR O JOGADOR 2
                if(jogadores.get(j).getPosicao_Jogador() == jComboBox2.getSelectedItem()){
                    jogadores.set(i, jogadores.get(j));
                    jogadores.set(j, jogador_aux);
                    JOptionPane.showMessageDialog(null, "Nome [0]: "+jogadores.get(i).getNome_Jogador());
                }
            }
        }
        else{
        //    
        }
        
        
        for(int x=0;x<=8;x++){
        jogadores.get(x).getLabel_jogador().setLocation(jogadores.get(x).getPosicao_X_Defesa(), jogadores.get(x).getPosicao_Y_Defesa());
        if("PITCHER".equals(jogadores.get(x).getPosicao_Jogador())){
            setPitcher_Do_Inning(x);
        }
    }

    }//GEN-LAST:event_jButton7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton_Comecar;
    private javax.swing.JButton jButton_Finalizar;
    private javax.swing.JButton jButton_Pausar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jCronometro;
    private javax.swing.JLabel jJogador1;
    private javax.swing.JLabel jJogador2;
    private javax.swing.JLabel jJogador21;
    private javax.swing.JLabel jJogador22;
    private javax.swing.JLabel jJogador23;
    private javax.swing.JLabel jJogador24;
    private javax.swing.JLabel jJogador25;
    private javax.swing.JLabel jJogador26;
    private javax.swing.JLabel jJogador27;
    private javax.swing.JLabel jJogador28;
    private javax.swing.JLabel jJogador29;
    private javax.swing.JLabel jJogador3;
    private javax.swing.JLabel jJogador4;
    private javax.swing.JLabel jJogador5;
    private javax.swing.JLabel jJogador6;
    private javax.swing.JLabel jJogador7;
    private javax.swing.JLabel jJogador8;
    private javax.swing.JLabel jJogador9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Equipe1;
    private javax.swing.JLabel jLabel_Equipe2;
    private javax.swing.JLabel jLabel_JogadorDetalhes_1;
    private javax.swing.JLabel jLabel_JogadorDetalhes_2;
    private javax.swing.JLabel jLabel_JogadorDetalhes_21;
    private javax.swing.JLabel jLabel_JogadorDetalhes_22;
    private javax.swing.JLabel jLabel_JogadorDetalhes_23;
    private javax.swing.JLabel jLabel_JogadorDetalhes_24;
    private javax.swing.JLabel jLabel_JogadorDetalhes_25;
    private javax.swing.JLabel jLabel_JogadorDetalhes_26;
    private javax.swing.JLabel jLabel_JogadorDetalhes_27;
    private javax.swing.JLabel jLabel_JogadorDetalhes_28;
    private javax.swing.JLabel jLabel_JogadorDetalhes_29;
    private javax.swing.JLabel jLabel_JogadorDetalhes_3;
    private javax.swing.JLabel jLabel_JogadorDetalhes_4;
    private javax.swing.JLabel jLabel_JogadorDetalhes_5;
    private javax.swing.JLabel jLabel_JogadorDetalhes_6;
    private javax.swing.JLabel jLabel_JogadorDetalhes_7;
    private javax.swing.JLabel jLabel_JogadorDetalhes_8;
    private javax.swing.JLabel jLabel_JogadorDetalhes_9;
    private javax.swing.JLabel jLabel_Pontuacao1;
    private javax.swing.JLabel jLabel_Pontuacao2;
    private javax.swing.JLabel jLabel_Qt_Balls;
    private javax.swing.JLabel jLabel_Qt_Outs;
    private javax.swing.JLabel jLabel_Qt_Strikes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_Campo;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}
