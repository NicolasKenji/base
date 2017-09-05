/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;

/**
 *
 * @author PCP
 */
public class Class_Partida {
    private int Entrada;
    private int Pontuacao_Equipe0;
    private int Pontuacao_Equipe1;
    private int Atacador_Equipe0;
    private int Atacador_Equipe1;
    private int Strikes;
    private int Balls;
    private int Outs;

    public int getStrikes() {
        return Strikes;
    }

    public void setStrikes() {
        this.Strikes++;   
    }

    public int getBalls() {
        return Balls;
    }

    public void setBalls() {
        if(Balls < 4){
            this.Balls++;   
        }
    }
    public void setZerarBalls(){
        this.Balls = 0;
        setZerarStrikes();
    }

    public int getOuts() {
        return Outs;
    }

    public void setOuts() {
        this.Outs++;
    }
    public void setZerarOuts(){
        this.Outs = 0;
    }
    public void setZerarStrikes(){
        this.Strikes = 0;
    }

    
    
    public int getAtacador_Equipe0() {
        return Atacador_Equipe0;
    }

    public void setAtacador_Equipe0() {
        if(this.Atacador_Equipe0 < 8){
            this.Atacador_Equipe0++;
        }
        else{
            this.Atacador_Equipe0 = 0;
        }
    }

    public int getAtacador_Equipe1() {
        return Atacador_Equipe1;
    }

    public void setAtacador_Equipe1() {
        if(this.Atacador_Equipe1 < 17){
            this.Atacador_Equipe1++;
        }
        else{
            this.Atacador_Equipe1 = 9;
        }
        
    }
    
    

    public Class_Partida(){
        this.Entrada = 1;
        this.Pontuacao_Equipe0 = 0;
        this.Pontuacao_Equipe1 = 0;
        this.Atacador_Equipe0 = -1;
        this.Atacador_Equipe1 = 8;
    }

    public int getEntrada() {
        return Entrada;
    }

    public void setEntrada(int Entrada) {
        this.Entrada = Entrada;
    }

    public int getPontuacao_Equipe0() {
        return Pontuacao_Equipe0;
    }

    public void setPontuacao_Equipe0() {
        this.Pontuacao_Equipe0++;
    }

    public int getPontuacao_Equipe1() {
        return Pontuacao_Equipe1;
    }

    public void setPontuacao_Equipe1() {
        this.Pontuacao_Equipe1++;
    }
    
}
