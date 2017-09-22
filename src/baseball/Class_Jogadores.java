/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;

import javax.swing.JLabel;

/**
 *
 * @author PCP
 */
public class Class_Jogadores {
    
    private String Nome_Jogador;
    private String Numero_Camisa;
    private String Posicao_Jogador;
    private int N_Batedor;
    private int Pontuacao;
    private String Equipe;
    private JLabel label_jogador;
    private int Posicao_X_Defesa;
    private int Posicao_Y_Defesa;
    private int Posicao_X_Ataque;
    private int Posicao_y_Ataque;
    private String Nome_Equipe1;
    private String Nome_Equipe2;
    private double N_Arremessos;
    private double N_Strikes;
    private double N_Balls;
    private double N_Strike_Out_Sofridos;
    private double N_Eliminacoes_Batida; //Eliminações após rebatida
    private double N_Rebatidas_Simples;
    private double N_Rebatidas_Duplas;
    private double N_Rebatidas_Triplas;
    private double N_Rebatidas_HR;
    private double N_Roubos_Bases;
    private int N_Strikes_Outs;
    private int N_Walks_Pitcher;
    private int N_Dead_Balls;
    private double AB; //IDAS AO BAT
    private double HIT; //BATIDAS VALIDAS
    private double BB; //WALK
    private double HPB; //BOLADA DO PITCHER
    private double SF; //BATIDAS DE SACRIFICIO
    private double OBP; // PORCENTAGEM ON BASE
    private double Total_Bases; //EMPURRADAS DE BASES COM BATIDA
    private double SLG;
    private int N_Pontos_Feitos;
    private int N_Eliminacoes; //Nº DE VEZES QUE O JOGADOR FOI ELIMINADO

    public double getN_Roubos_Bases() {
        return N_Roubos_Bases;
    }

    public void setN_Roubos_Bases_1() {
        this.N_Roubos_Bases++;
    }

    public double getN_Eliminacoes_Batida() {
        return N_Eliminacoes_Batida;
    }

    public void setN_Eliminacoes_Batida_1() {
        this.N_Eliminacoes_Batida++;
    }

    public int getN_Pontos_Feitos() {
        return N_Pontos_Feitos;
    }

    public void setN_Pontos_Feitos_1() {
        this.N_Pontos_Feitos++;
    }
    
    
    
    public void setN_Strike_Out_Sofridos_1(){
        this.N_Strike_Out_Sofridos++;
    }
    public double getN_Strike_Out_Sofridos(){
        return this.N_Strike_Out_Sofridos;
    }
    
    public void setN_Eliminacoes_1(){
        this.N_Eliminacoes++;
    }
    public int getN_Eliminacoes(){
        return this.N_Eliminacoes;
    }

    public int getN_Dead_Balls() {
        return N_Dead_Balls;
    }

    public void setN_Dead_Balls_1() {
        this.N_Dead_Balls++;
    }

    
    public int getN_Strikes_Outs() {
        return N_Strikes_Outs;
    }

    public void setN_Strikes_Outs_1() {
        this.N_Strikes_Outs++;
    }

    public int getN_Walks_Pitcher() {
        return N_Walks_Pitcher;
    }

    public void setN_Walks_Pitcher_1() {
        this.N_Walks_Pitcher++;
    }

    public double getN_Arremessos() {
        return N_Arremessos;
    }

    public void setN_Arremessos_1() {
        this.N_Arremessos++;
    }

    public double getN_Strikes() {
        return N_Strikes;
    }

    public void setN_Strikes_1() {
        this.N_Strikes++;
    }

    public double getN_Balls() {
        return N_Balls;
    }

    public void setN_Balls_1() {
        this.N_Balls++;
    }

    public double getN_Rebatidas_Simples() {
        return N_Rebatidas_Simples;
    }

    public void setN_Rebatidas_Simples_1() {
        this.N_Rebatidas_Simples++;
    }

    public double getN_Rebatidas_Duplas() {
        return N_Rebatidas_Duplas;
    }

    public void setN_Rebatidas_Duplas(double N_Rebatidas_Duplas) {
        this.N_Rebatidas_Duplas = N_Rebatidas_Duplas;
    }

    public double getN_Rebatidas_Triplas() {
        return N_Rebatidas_Triplas;
    }

    public void setN_Rebatidas_Triplas(double N_Rebatidas_Triplas) {
        this.N_Rebatidas_Triplas = N_Rebatidas_Triplas;
    }

    public double getN_Rebatidas_HR() {
        return N_Rebatidas_HR;
    }

    public void setN_Rebatidas_HR(double N_Rebatidas_HR) {
        this.N_Rebatidas_HR = N_Rebatidas_HR;
    }

    public double getAB() {
        return AB;
    }

    public void setAB(double AB) {
        this.AB = AB;
    }

    public double getHIT() {
        return HIT;
    }

    public void setHIT(double HIT) {
        this.HIT = HIT;
    }

    public double getBB() {
        return BB;
    }

    public void setBB(double BB) {
        this.BB = BB;
    }

    public double getHPB() {
        return HPB;
    }

    public void setHPB() {
        this.HPB++;
    }

    public double getSF() {
        return SF;
    }

    public void setSF(double SF) {
        this.SF = SF;
    }
    
    
    private double getOBP(){
        OBP = (HIT + BB + HPB) / (AB + BB + HPB + SF);
        return this.OBP;
    }
    public double getTotal_Bases(){
        this.Total_Bases = N_Rebatidas_Simples + (2 * N_Rebatidas_Duplas) + (3 * N_Rebatidas_Triplas) + (4 * N_Rebatidas_HR);
        return Total_Bases;
    }
    public double getSLG(){
        this.SLG = getTotal_Bases() / this.AB;
        return SLG;
    }

    public String getNome_Equipe1() {
        return Nome_Equipe1;
    }

    public void setNome_Equipe1(String Nome_Equipe1) {
        this.Nome_Equipe1 = Nome_Equipe1;
    }

    public String getNome_Equipe2() {
        return Nome_Equipe2;
    }

    public void setNome_Equipe2(String Nome_Equipe2) {
        this.Nome_Equipe2 = Nome_Equipe2;
    }

    public int getPosicao_X_Defesa() {
        return Posicao_X_Defesa;
    }

    public void setPosicao_X_Defesa(int Posicao_X_Defesa) {
        this.Posicao_X_Defesa = Posicao_X_Defesa;
    }

    public int getPosicao_Y_Defesa() {
        return Posicao_Y_Defesa;
    }

    public void setPosicao_Y_Defesa(int Posicao_Y_Defesa) {
        this.Posicao_Y_Defesa = Posicao_Y_Defesa;
    }

    public int getPosicao_X_Ataque() {
        return Posicao_X_Ataque;
    }

    public void setPosicao_X_Ataque(int Posicao_X_Ataque) {
        this.Posicao_X_Ataque = Posicao_X_Ataque;
    }

    public int getPosicao_y_Ataque() {
        return Posicao_y_Ataque;
    }

    public void setPosicao_y_Ataque(int Posicao_y_Ataque) {
        this.Posicao_y_Ataque = Posicao_y_Ataque;
    }

    public JLabel getLabel_jogador() {
        return label_jogador;
    }

    public void setLabel_jogador(JLabel label_jogador) {
        this.label_jogador = label_jogador;
    }
    
    public Class_Jogadores(String nome, String numero, String pos, int n_bater, String equipe){
        this.Nome_Jogador = nome;
        this.Numero_Camisa = numero;
        this.Posicao_Jogador = pos;
        this.N_Batedor = n_bater;
        this.Pontuacao = 0;
        this.Equipe = equipe;
    }

    public String getNome_Jogador() {
        return Nome_Jogador;
    }

    public void setNome_Jogador(String Nome_Jogador) {
        this.Nome_Jogador = Nome_Jogador;
    }

    public String getNumero_Camisa() {
        return Numero_Camisa;
    }

    public void setNumero_Camisa(String Numero_Camisa) {
        this.Numero_Camisa = Numero_Camisa;
    }

    public String getPosicao_Jogador() {
        return Posicao_Jogador;
    }

    public void setPosicao_Jogador(String Posicao_Jogador) {
        this.Posicao_Jogador = Posicao_Jogador;
    }

    public int getN_Batedor() {
        return N_Batedor;
    }

    public void setN_Batedor(int N_Batedor) {
        this.N_Batedor = N_Batedor;
    }

    public int getPontuacao() {
        return Pontuacao;
    }

    public void setPontuacao(int Pontuacao) {
        this.Pontuacao = Pontuacao;
    }

    public String getEquipe() {
        return Equipe;
    }

    public void setEquipe(String Equipe) {
        this.Equipe = Equipe;
    }
    
    
}
