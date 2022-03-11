public class Pedra{
    public Jogador jogador;
    public Casa casa;
    public int sentido; //sentido próprio para usar na dama
    public Boolean dama; //dama ainda não implementada por completo
    public Character simb; //símbolo printado

    public Pedra(Jogador jogador, Casa casa, int sentido){
        this.jogador = jogador;
        this.casa = casa;
        casa.setPedra(this);
        this.sentido = sentido;
        this.dama = false;
        this.simb = this.jogador.cor == 0 ? 'w' : 'b';
    }

    public Boolean podeCapturar(Pedra pedra_alvo){
        return this.jogador.lista_pedras.contains(pedra_alvo);
    }

    public Boolean podeMoverPara(Casa casa){
        if(Partida.tabuleiro.contains(casa)){

            //casas na diagonal adjacente
            Casa casa1 = Partida.getCasa(this.casa.lin+this.sentido, this.casa.col+this.sentido);
            Casa casa2 = Partida.getCasa(this.casa.lin+this.sentido, this.casa.col-this.sentido);
            if(!Partida.getCasa(casa.lin, casa.col).temPedra()){
                if(this.dama){
                    return true;
                } else { //a casa é adjacente à essa pedra?
                    /*Uma peça comum pode mover, no máximo, duas linhas
                     *caso coma uma peça, caso contrário, pode apenas se mover
                     *uma coluna e uma linha no sentido definido*/
                    if(casa == casa1 || casa == casa2){
                        return true;
                    } else {
                        return false;
                    }
                }
            } else return false;
        } else return false;
    }

    public Jogador getJogador(){
        return this.jogador;
    }

    public Boolean pedraDama(){
        return this.dama;
    }

    public void viraDama(){
        this.dama = true;
    }
}