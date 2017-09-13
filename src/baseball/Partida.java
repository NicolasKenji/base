package baseball;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Partida extends javax.swing.JFrame {
    public String[] Tipos_Jogadas = new String[5];
    public String[] Tipos_Arremessos = new String[3];
    private Class_Partida partida;
    private Class_Jogadores[] jogadores;
    private String Equipe_Defesa;
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
    private int Batedor_Primeira_Base;
    private int Batedor_Segunda_Base;
    private int Batedor_Terceira_Base;
    private String j;
    private JComboBox combo_tipos;
    private JComboBox combo_arremessos;
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
    
    public void setPitcher_Do_Inning(int Pitcher_Do_Inning){
        this.Pitcher_Do_Inning = Pitcher_Do_Inning;
    }
    public int getPitcher_Do_Inning(){
        return this.Pitcher_Do_Inning;
    }
    public Partida(Class_Jogadores[] jogadores, Class_Equipes[] equipes, String Defesa) {
        initComponents();
        this.df = new DecimalFormat("0.000");
        this.jogadores = jogadores;
        this.equipes = equipes;
        this.Equipe_Defesa = Defesa;
        this.setLocationRelativeTo(null);
        Setar_Labels();
        jLabel_Equipe1.setText(equipes[0].getNome_Equipe());
        jLabel_Equipe2.setText(equipes[1].getNome_Equipe());  
        combo_tipos = new JComboBox<>(getTipos_Jogadas());
        combo_arremessos = new JComboBox<>(getTipos_Arremessos());
        iniciarContagem();
        stopTime();
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
        j = "Nº "+jogadores[o].getNumero_Camisa()+ "    Nome: "+jogadores[o].getNome_Jogador();
        return j;
    }
    private void Verificar_Label(int x){
    if(x == 0){
        jogadores[x].setLabel_jogador(jJogador1);
        jLabel_JogadorDetalhes_1.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
        
    }
    else if(x == 1){
        jogadores[x].setLabel_jogador(jJogador2);
        jLabel_JogadorDetalhes_2.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 2){
        jogadores[x].setLabel_jogador(jJogador3);
        jLabel_JogadorDetalhes_3.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 3){
        jogadores[x].setLabel_jogador(jJogador4);
        jLabel_JogadorDetalhes_4.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 4){
        jogadores[x].setLabel_jogador(jJogador5);
        jLabel_JogadorDetalhes_5.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 5){
        jogadores[x].setLabel_jogador(jJogador6);
        jLabel_JogadorDetalhes_6.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 6){
        jogadores[x].setLabel_jogador(jJogador7);
        jLabel_JogadorDetalhes_7.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 7){
        jogadores[x].setLabel_jogador(jJogador8);
        jLabel_JogadorDetalhes_8.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 8){
        jogadores[x].setLabel_jogador(jJogador9);
        jLabel_JogadorDetalhes_9.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 9){
        jogadores[x].setLabel_jogador(jJogador21);
        jLabel_JogadorDetalhes_21.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 10){
        jogadores[x].setLabel_jogador(jJogador22);
        jLabel_JogadorDetalhes_22.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 11){
        jogadores[x].setLabel_jogador(jJogador23);
        jLabel_JogadorDetalhes_23.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 12){
        jogadores[x].setLabel_jogador(jJogador24);
        jLabel_JogadorDetalhes_24.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 13){
        jogadores[x].setLabel_jogador(jJogador25);
        jLabel_JogadorDetalhes_25.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 14){
        jogadores[x].setLabel_jogador(jJogador26);
        jLabel_JogadorDetalhes_26.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 15){
        jogadores[x].setLabel_jogador(jJogador27);
        jLabel_JogadorDetalhes_27.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 16){
        jogadores[x].setLabel_jogador(jJogador28);
        jLabel_JogadorDetalhes_28.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
    else if(x == 17){
        jogadores[x].setLabel_jogador(jJogador29);
        jLabel_JogadorDetalhes_29.setText(Label_Painel_Jogadores(x));
        jogadores[x].getLabel_jogador().setText(jogadores[x].getNumero_Camisa());
        jogadores[x].getLabel_jogador().setName(Integer.toString(x));
    }
}
    public void Setar_Labels(){
        for(int x=0;x<18;x++){
            if("PITCHER".equals(this.jogadores[x].getPosicao_Jogador())){
                jogadores[x].setPosicao_X_Defesa(320);
                jogadores[x].setPosicao_Y_Defesa(210);
                
                if(equipes[0].getNome_Equipe().equals(jogadores[x].getEquipe())){
                    jogadores[x].setPosicao_X_Ataque(30);
                    jogadores[x].setPosicao_y_Ataque(240); 
                }
                else{
                    jogadores[x].setPosicao_X_Ataque(560);
                    jogadores[x].setPosicao_y_Ataque(240); 
                }
                Verificar_Label(x);
            }  
            if("CATCHER".equals(this.jogadores[x].getPosicao_Jogador())){
                jogadores[x].setPosicao_X_Defesa(320);
                jogadores[x].setPosicao_Y_Defesa(360);
                if(equipes[0].getNome_Equipe().equals(jogadores[x].getEquipe())){
                    jogadores[x].setPosicao_X_Ataque(80);
                    jogadores[x].setPosicao_y_Ataque(240); 
                }
                else{
                    jogadores[x].setPosicao_X_Ataque(610);
                    jogadores[x].setPosicao_y_Ataque(240); 
                }
                Verificar_Label(x);
            }  
            if("FIRST BASE".equals(this.jogadores[x].getPosicao_Jogador())){
                jogadores[x].setPosicao_X_Defesa(450);
                jogadores[x].setPosicao_Y_Defesa(200);
                
                if(equipes[0].getNome_Equipe().equals(jogadores[x].getEquipe())){
                    jogadores[x].setPosicao_X_Ataque(30);
                    jogadores[x].setPosicao_y_Ataque(270); 
                }
                else{
                    jogadores[x].setPosicao_X_Ataque(560);
                    jogadores[x].setPosicao_y_Ataque(270); 
                }
                Verificar_Label(x);
            }  
            if("SECOND BASE".equals(this.jogadores[x].getPosicao_Jogador())){
                jogadores[x].setPosicao_X_Defesa(400);
                jogadores[x].setPosicao_Y_Defesa(150);
                
                if(equipes[0].getNome_Equipe().equals(jogadores[x].getEquipe())){
                    jogadores[x].setPosicao_X_Ataque(80);
                    jogadores[x].setPosicao_y_Ataque(270); 
                }
                else{
                    jogadores[x].setPosicao_X_Ataque(610);
                    jogadores[x].setPosicao_y_Ataque(270); 
                }
                Verificar_Label(x);
            }  
            if("SHORTSTOP".equals(this.jogadores[x].getPosicao_Jogador())){
                jogadores[x].setPosicao_X_Defesa(250);
                jogadores[x].setPosicao_Y_Defesa(150);
                
                if(equipes[0].getNome_Equipe().equals(jogadores[x].getEquipe())){
                    jogadores[x].setPosicao_X_Ataque(30);
                    jogadores[x].setPosicao_y_Ataque(300); 
                }
                else{
                    jogadores[x].setPosicao_X_Ataque(560);
                    jogadores[x].setPosicao_y_Ataque(300); 
                }
                Verificar_Label(x);
            }  
            if("THIRD BASE".equals(this.jogadores[x].getPosicao_Jogador())){
                jogadores[x].setPosicao_X_Defesa(200);
                jogadores[x].setPosicao_Y_Defesa(200);
                
                if(equipes[0].getNome_Equipe().equals(jogadores[x].getEquipe())){
                    jogadores[x].setPosicao_X_Ataque(80);
                    jogadores[x].setPosicao_y_Ataque(300); 
                }
                else{
                    jogadores[x].setPosicao_X_Ataque(610);
                    jogadores[x].setPosicao_y_Ataque(300); 
                }
                Verificar_Label(x);
            }  
            if("LEFT FIELD".equals(this.jogadores[x].getPosicao_Jogador())){
                jogadores[x].setPosicao_X_Defesa(160);
                jogadores[x].setPosicao_Y_Defesa(70);
                
                if(equipes[0].getNome_Equipe().equals(jogadores[x].getEquipe())){
                    jogadores[x].setPosicao_X_Ataque(30);
                    jogadores[x].setPosicao_y_Ataque(330); 
                }
                else{
                    jogadores[x].setPosicao_X_Ataque(560);
                    jogadores[x].setPosicao_y_Ataque(330); 
                }
                Verificar_Label(x);
            }  
            if("CENTER FIELD".equals(this.jogadores[x].getPosicao_Jogador())){
                jogadores[x].setPosicao_X_Defesa(320);
                jogadores[x].setPosicao_Y_Defesa(20);
                
                if(equipes[0].getNome_Equipe().equals(jogadores[x].getEquipe())){
                    jogadores[x].setPosicao_X_Ataque(80);
                    jogadores[x].setPosicao_y_Ataque(330); 
                }
                else{
                    jogadores[x].setPosicao_X_Ataque(610);
                    jogadores[x].setPosicao_y_Ataque(330); 
                }
                Verificar_Label(x);
            }  
            if("RIGHT FIELD".equals(this.jogadores[x].getPosicao_Jogador())){
                jogadores[x].setPosicao_X_Defesa(460);
                jogadores[x].setPosicao_Y_Defesa(60);
                
                if(equipes[0].getNome_Equipe().equals(jogadores[x].getEquipe())){
                    jogadores[x].setPosicao_X_Ataque(30);
                    jogadores[x].setPosicao_y_Ataque(360); 
                }
                else{
                    jogadores[x].setPosicao_X_Ataque(560);
                    jogadores[x].setPosicao_y_Ataque(360); 
                }
                Verificar_Label(x);
            }  
        }
    }
    public void Defender_Equipe0(){
    Equipe_Def = 0;
    for(int i=0;i<=8;i++){
        jogadores[i].getLabel_jogador().setLocation(jogadores[i].getPosicao_X_Defesa(), jogadores[i].getPosicao_Y_Defesa());
        if("PITCHER".equals(jogadores[i].getPosicao_Jogador())){
            setPitcher_Do_Inning(i);
        }
    }
}
    public void Defender_Equipe1(){
        Equipe_Def = 1;
        for(int i=9;i<=17;i++){
            jogadores[i].getLabel_jogador().setLocation(jogadores[i].getPosicao_X_Defesa(), jogadores[i].getPosicao_Y_Defesa());
            if("PITCHER".equals(jogadores[i].getPosicao_Jogador())){
            setPitcher_Do_Inning(i);     
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
            jogadores[getPitcher_Do_Inning()].setN_Walks_Pitcher_1();
            partida.setZerarBalls();
            if(Equipe_Def == 0){
                Batida_Equipe1();
            }
            else if(Equipe_Def == 1){
                Batida_Equipe0();
            }
        }
    }
    public void Verificar_Outs(){
        if(partida.getOuts() == 3){
            partida.setZerarOuts();
            Zerar_Variaveis();
            
            if(Equipe_Def == 0){
                Bater_Equipe0();
            }
            else if (Equipe_Def == 1){
                Bater_Equipe1();
            }
        }
    }
    public void Verificar_Strikes(){
        if(partida.getStrikes() == 3){
            jogadores[getPitcher_Do_Inning()].setN_Strikes_Outs_1();
            partida.setZerarStrikes();
            partida.setOuts();
            if(Equipe_Def == 0){
                Eliminar_Batedor_Equipe1();
                setProximo_Batedor_Equipe1();
            }
            else if (Equipe_Def == 1){
                Eliminar_Batedor_Equipe0();
                setProximo_Batedor_Equipe0();
            }
            Verificar_Outs();
        }
    }
    public void setDead_Ball(){
        jogadores[getPitcher_Do_Inning()].setN_Arremessos_1(); 
        jogadores[getPitcher_Do_Inning()].setN_Dead_Balls_1();
        partida.setZerarBalls();
        if(Equipe_Def == 0){
            jogadores[partida.getAtacador_Equipe1()].setHPB();
            Batida_Equipe1();
        }
        else if(Equipe_Def == 1){
            jogadores[partida.getAtacador_Equipe0()].setHPB();
            Batida_Equipe0();
        }
    }
    public String[] getTipos_Jogadas() {
        Tipos_Jogadas[0] = "Arremesso";
        Tipos_Jogadas[1] = "Batida";
        Tipos_Jogadas[2] = "Defesa";
        Tipos_Jogadas[3] = "Falha";
        Tipos_Jogadas[4] = "Ação";
        return Tipos_Jogadas;
    }
    public void Msg_Tipo(String m){
        if("Arremesso".equals(m)){
            String[] escolha = { "Confirmar", "Cancelar"};
            String title = "Escolha a jogada";
            int selecao =  JOptionPane.showOptionDialog(null, combo_arremessos, title,
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);  

            if(selecao == 0){
                if(combo_arremessos.getSelectedItem() == Tipos_Arremessos[0]){
                    partida.setStrikes();
                    Verificar_Strikes();
                    Atualizar_Pontuacao();
                }  
                else if(combo_arremessos.getSelectedItem() == Tipos_Arremessos[1]){
                    partida.setBalls();
                    Verificar_Balls();
                    Atualizar_Pontuacao();
                } 
            }
        }        
    }
    public String[] getTipos_Arremessos(){
        Tipos_Arremessos[0] = "Strike";
        Tipos_Arremessos[1] = "Ball";
        Tipos_Arremessos[2] = "Dead Ball";
        
        return Tipos_Arremessos;
    }
    public void Bater_Equipe0(){
        Defender_Equipe1();
        for(int i=0;i<9;i++){
            jogadores[i].getLabel_jogador().setLocation(jogadores[i].getPosicao_X_Ataque(), jogadores[i].getPosicao_y_Ataque());
        }
        jogadores[partida.getAtacador_Equipe0()].getLabel_jogador().setLocation(X_Home, Y_Home);
    }
    public void Bater_Equipe1(){
        Defender_Equipe0();
        for(int i=9;i<18;i++){
            jogadores[i].getLabel_jogador().setLocation(jogadores[i].getPosicao_X_Ataque(), jogadores[i].getPosicao_y_Ataque());
        }
        jogadores[partida.getAtacador_Equipe1()].getLabel_jogador().setLocation(X_Home, Y_Home);
    } 
    public void Input_Msg(int j){
        String[] escolha = { "Confirmar", "Cancelar"};
        String title = "Escolha a jogada";
        int selecao =  JOptionPane.showOptionDialog(null, combo_tipos, title,
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);  

        if(selecao == 0){  
            Msg_Tipo((String) combo_tipos.getSelectedItem());
        }
    }   
    public void Batida_Equipe1(){
        if(Primeira_Base_Cheia == false){
            setPrimeira_Base_Equipe(jogadores[partida.getAtacador_Equipe1()].getLabel_jogador(), partida.getAtacador_Equipe1());
        }
        else if(Primeira_Base_Cheia == true && Segunda_Base_Cheia == false){
            setSegunda_Base_Equipe(jogadores[Batedor_Primeira_Base].getLabel_jogador());
            setPrimeira_Base_Equipe(jogadores[partida.getAtacador_Equipe1()].getLabel_jogador(), partida.getAtacador_Equipe1());
            
        }
        else if(Primeira_Base_Cheia == true && Segunda_Base_Cheia == true && Terceira_Base_Cheia == false){
            setTerceira_Base_Equipe(jogadores[Batedor_Segunda_Base].getLabel_jogador());
            setSegunda_Base_Equipe(jogadores[Batedor_Primeira_Base].getLabel_jogador());
            setPrimeira_Base_Equipe(jogadores[partida.getAtacador_Equipe1()].getLabel_jogador(), partida.getAtacador_Equipe1());
        }
        else if(Primeira_Base_Cheia == true && Segunda_Base_Cheia == true && Terceira_Base_Cheia == true){
            partida.setPontuacao_Equipe1();
            Atualizar_Pontuacao();
            setHome_Base_Equipe(jogadores[Batedor_Terceira_Base].getLabel_jogador());
            setTerceira_Base_Equipe(jogadores[Batedor_Segunda_Base].getLabel_jogador());
            setSegunda_Base_Equipe(jogadores[Batedor_Primeira_Base].getLabel_jogador());
            setPrimeira_Base_Equipe(jogadores[partida.getAtacador_Equipe1()].getLabel_jogador(), partida.getAtacador_Equipe1());
        }
        partida.setAtacador_Equipe1();
        jogadores[partida.getAtacador_Equipe1()].getLabel_jogador().setLocation(X_Home, Y_Home);
    }
    public void Batida_Equipe0(){
        if(Primeira_Base_Cheia == false){
            setPrimeira_Base_Equipe(jogadores[partida.getAtacador_Equipe0()].getLabel_jogador(), partida.getAtacador_Equipe0());
        }
        else if(Primeira_Base_Cheia == true && Segunda_Base_Cheia == false){
            setSegunda_Base_Equipe(jogadores[Batedor_Primeira_Base].getLabel_jogador());
            setPrimeira_Base_Equipe(jogadores[partida.getAtacador_Equipe0()].getLabel_jogador(), partida.getAtacador_Equipe0());
            
        }
        else if(Primeira_Base_Cheia == true && Segunda_Base_Cheia == true && Terceira_Base_Cheia == false){
            setTerceira_Base_Equipe(jogadores[Batedor_Segunda_Base].getLabel_jogador());
            setSegunda_Base_Equipe(jogadores[Batedor_Primeira_Base].getLabel_jogador());
            setPrimeira_Base_Equipe(jogadores[partida.getAtacador_Equipe0()].getLabel_jogador(), partida.getAtacador_Equipe0());
        }
        else if(Primeira_Base_Cheia == true && Segunda_Base_Cheia == true && Terceira_Base_Cheia == true){          
            //JOGADOR TERCEIRA BASE FEZ PONTO
            partida.setPontuacao_Equipe0();
            Atualizar_Pontuacao();
            setHome_Base_Equipe(jogadores[Batedor_Terceira_Base].getLabel_jogador());
            setTerceira_Base_Equipe(jogadores[Batedor_Segunda_Base].getLabel_jogador());
            setSegunda_Base_Equipe(jogadores[Batedor_Primeira_Base].getLabel_jogador());
            setPrimeira_Base_Equipe(jogadores[partida.getAtacador_Equipe0()].getLabel_jogador(), partida.getAtacador_Equipe0());
        }
        partida.setAtacador_Equipe0();
        jogadores[partida.getAtacador_Equipe0()].getLabel_jogador().setLocation(X_Home, Y_Home);
    }
    public void Eliminar_Batedor_Equipe1(){
        jogadores[partida.getAtacador_Equipe1()].getLabel_jogador().setLocation(jogadores[partida.getAtacador_Equipe1()].getPosicao_X_Ataque(), jogadores[partida.getAtacador_Equipe1()].getPosicao_y_Ataque());
    }
    public void Eliminar_Batedor_Equipe0(){
    jogadores[partida.getAtacador_Equipe0()].getLabel_jogador().setLocation(jogadores[partida.getAtacador_Equipe0()].getPosicao_X_Ataque(), jogadores[partida.getAtacador_Equipe0()].getPosicao_y_Ataque());
    }
    public void setProximo_Batedor_Equipe0(){
        partida.setAtacador_Equipe0();
        jogadores[partida.getAtacador_Equipe0()].getLabel_jogador().setLocation(X_Home, Y_Home);
    }
    public void setProximo_Batedor_Equipe1(){
        partida.setAtacador_Equipe1();
        jogadores[partida.getAtacador_Equipe1()].getLabel_jogador().setLocation(X_Home, Y_Home);
    }
    private void setPrimeira_Base_Equipe(JLabel jo1, int batedor) {
        Primeira_Base_Cheia = true;
        Batedor_Primeira_Base = batedor;
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
        Terceira_Base_Cheia = true;
        Batedor_Terceira_Base = Batedor_Segunda_Base;
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
                if(Equipe_Def == 1){
                    jo4.setLocation(jogadores[partida.getAtacador_Equipe0()].getPosicao_X_Ataque(), jogadores[partida.getAtacador_Equipe0()].getPosicao_y_Ataque());
                }
                else if(Equipe_Def == 0){
                    jo4.setLocation(jogadores[partida.getAtacador_Equipe1()].getPosicao_X_Ataque(), jogadores[partida.getAtacador_Equipe1()].getPosicao_y_Ataque());
                }
                
            }
            }  
        };  
        this.t4 = new Timer(10, acao4);  
        this.t4.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jPanel4 = new javax.swing.JPanel();
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

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

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
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

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
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

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
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Substituição", jPanel4);

        jPanel3.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(0));

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
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(0));

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

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 560));

        jPanel_Campo.setLayout(null);

        jJogador9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola azul.png"))); // NOI18N
        jJogador9.setText("99");
        jJogador9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador9_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador9);
        jJogador9.setBounds(30, 360, 50, 23);

        jJogador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola azul.png"))); // NOI18N
        jJogador1.setText("10");
        jJogador1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador1_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador1);
        jJogador1.setBounds(30, 240, 50, 23);

        jJogador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola azul.png"))); // NOI18N
        jJogador2.setText("22");
        jJogador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogado2_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador2);
        jJogador2.setBounds(80, 240, 50, 23);

        jJogador3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola azul.png"))); // NOI18N
        jJogador3.setText("33");
        jJogador3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador3_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador3);
        jJogador3.setBounds(30, 270, 50, 23);

        jJogador4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola azul.png"))); // NOI18N
        jJogador4.setText("44");
        jJogador4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador4_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador4);
        jJogador4.setBounds(80, 270, 50, 23);

        jJogador5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola azul.png"))); // NOI18N
        jJogador5.setText("55");
        jJogador5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador5_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador5);
        jJogador5.setBounds(30, 300, 50, 23);

        jJogador8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola azul.png"))); // NOI18N
        jJogador8.setText("88");
        jJogador8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador8_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador8);
        jJogador8.setBounds(80, 330, 50, 23);

        jJogador6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola azul.png"))); // NOI18N
        jJogador6.setText("66");
        jJogador6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador6_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador6);
        jJogador6.setBounds(80, 300, 50, 23);

        jJogador7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola azul.png"))); // NOI18N
        jJogador7.setText("77");
        jJogador7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador7_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador7);
        jJogador7.setBounds(30, 330, 50, 23);

        jJogador21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola vermelha.png"))); // NOI18N
        jJogador21.setText("00");
        jJogador21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador21_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador21);
        jJogador21.setBounds(560, 240, 50, 23);

        jJogador25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola vermelha.png"))); // NOI18N
        jJogador25.setText("00");
        jJogador25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador25_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador25);
        jJogador25.setBounds(560, 300, 50, 23);

        jJogador26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola vermelha.png"))); // NOI18N
        jJogador26.setText("00");
        jJogador26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador26_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador26);
        jJogador26.setBounds(610, 300, 50, 23);

        jJogador27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola vermelha.png"))); // NOI18N
        jJogador27.setText("00");
        jJogador27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador27_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador27);
        jJogador27.setBounds(560, 330, 50, 23);

        jJogador28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola vermelha.png"))); // NOI18N
        jJogador28.setText("00");
        jJogador28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador28_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador28);
        jJogador28.setBounds(610, 330, 50, 23);

        jJogador29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola vermelha.png"))); // NOI18N
        jJogador29.setText("00");
        jJogador29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador29_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador29);
        jJogador29.setBounds(560, 360, 50, 23);

        jJogador22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola vermelha.png"))); // NOI18N
        jJogador22.setText("00");
        jJogador22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador22_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador22);
        jJogador22.setBounds(610, 240, 50, 23);

        jJogador23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola vermelha.png"))); // NOI18N
        jJogador23.setText("00");
        jJogador23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador23_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador23);
        jJogador23.setBounds(560, 270, 50, 23);

        jJogador24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/bola vermelha.png"))); // NOI18N
        jJogador24.setText("00");
        jJogador24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jogador24_Click(evt);
            }
        });
        jPanel_Campo.add(jJogador24);
        jJogador24.setBounds(610, 270, 50, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseball/fundo_baseball_1.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
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

        jButton6.setText("Jogadas");
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

        if(this.Equipe_Defesa == null ? equipes[0].getNome_Equipe() == null : this.Equipe_Defesa.equals(equipes[0].getNome_Equipe())){
            Bater_Equipe1();
        }
        else{
            Bater_Equipe0();
        }
        timer.restart();
    }//GEN-LAST:event_jButton_ComecarActionPerformed

    private void jButton_PausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PausarActionPerformed
        timer.stop();
    }//GEN-LAST:event_jButton_PausarActionPerformed

    private void jButton_FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FinalizarActionPerformed
        stopTime();
    }//GEN-LAST:event_jButton_FinalizarActionPerformed

    private void Jogador1_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador1_Click
        int Jogador = Integer.parseInt(jJogador1.getName());  
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador1_Click

    private void Jogado2_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogado2_Click
        int Jogador = Integer.parseInt(jJogador2.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogado2_Click

    private void Jogador3_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador3_Click
        int Jogador = Integer.parseInt(jJogador3.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador3_Click

    private void Jogador4_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador4_Click
        int Jogador = Integer.parseInt(jJogador4.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador4_Click

    private void Jogador5_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador5_Click
        int Jogador = Integer.parseInt(jJogador5.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador5_Click

    private void Jogador6_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador6_Click
        int Jogador = Integer.parseInt(jJogador6.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador6_Click

    private void Jogador7_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador7_Click
        int Jogador = Integer.parseInt(jJogador7.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador7_Click

    private void Jogador8_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador8_Click
        int Jogador = Integer.parseInt(jJogador8.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador8_Click

    private void Jogador9_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador9_Click
        int Jogador = Integer.parseInt(jJogador9.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador9_Click

    private void Jogador21_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador21_Click
        int Jogador = Integer.parseInt(jJogador21.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador21_Click

    private void Jogador22_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador22_Click
        int Jogador = Integer.parseInt(jJogador22.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador22_Click

    private void Jogador23_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador23_Click
        int Jogador = Integer.parseInt(jJogador23.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador23_Click

    private void Jogador24_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador24_Click
        int Jogador = Integer.parseInt(jJogador24.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador24_Click

    private void Jogador25_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador25_Click
        int Jogador = Integer.parseInt(jJogador25.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador25_Click

    private void Jogador26_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador26_Click
        int Jogador = Integer.parseInt(jJogador26.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador26_Click

    private void Jogador27_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador27_Click
        int Jogador = Integer.parseInt(jJogador27.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador27_Click

    private void Jogador28_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador28_Click
        int Jogador = Integer.parseInt(jJogador28.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador28_Click

    private void Jogador29_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jogador29_Click
        int Jogador = Integer.parseInt(jJogador29.getName());
        Input_Msg(Jogador);
    }//GEN-LAST:event_Jogador29_Click

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jogadores[0].setAB(10);
        jogadores[0].setN_Rebatidas_Simples(0);
        jogadores[0].setN_Rebatidas_Duplas(0);
        jogadores[0].setN_Rebatidas_Triplas(0);
        jogadores[0].setN_Rebatidas_HR(0);
        
        JOptionPane.showMessageDialog(null, df.format(jogadores[0].getSLG()));
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jogadores[getPitcher_Do_Inning()].setN_Arremessos_1();
        jogadores[getPitcher_Do_Inning()].setN_Strikes_1();
        partida.setStrikes();
        Verificar_Strikes();
        Atualizar_Pontuacao();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JOptionPane.showMessageDialog(null, "Nº Arremessos: "+jogadores[getPitcher_Do_Inning()].getN_Arremessos()+
                "\n Nº Strikes: "+jogadores[getPitcher_Do_Inning()].getN_Strikes()+
                "\n Nº Balls: "+jogadores[getPitcher_Do_Inning()].getN_Balls()+
                "\n Nº Strike Outs: "+jogadores[getPitcher_Do_Inning()].getN_Strikes_Outs()+
                "\n Nº Dead Balls: "+jogadores[getPitcher_Do_Inning()].getN_Dead_Balls());
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jogadores[getPitcher_Do_Inning()].setN_Arremessos_1();
        jogadores[getPitcher_Do_Inning()].setN_Balls_1();
        partida.setBalls();
        Verificar_Balls();
        Atualizar_Pontuacao();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setDead_Ball();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Jogadas jogada = new Jogadas(partida,jogadores,this);
        jogada.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_Comecar;
    private javax.swing.JButton jButton_Finalizar;
    private javax.swing.JButton jButton_Pausar;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_Campo;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
