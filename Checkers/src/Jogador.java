import java.util.ArrayList;

public class Jogador{
    public ArrayList<Pedra> lista_pedras;
    public int cor; //branca(0) ou preta(1) | pode ser trocada por sentido
    public int sentido; //pedras movem para baixo ou para cima

    public Jogador(Boolean caracoroa){
        lista_pedras = new ArrayList<>();
        if(caracoroa){
            this.sentido = 1;
            setCor(0);
        } else{
            setCor(1);
            this.sentido = -1;
        }
    }

    public void addPedra(Casa pos_inicial){
        Pedra nova_pedra = new Pedra(this, pos_inicial, this.sentido);
        this.lista_pedras.add(nova_pedra);
    }

    //A movimentação é toda feita em Partida()
    /*public void MoverPedra(Movimento movimento){}
    public void getPartida(){}*/

    //Posiciona as pedras iniciais
    public void setPartida(Partida partida){
        int tamanho = 8;
        if(this.cor == 0){
            for(int i=0;i<tamanho;++i){
                for(int j=0;j<tamanho;++j){
                    if (i < tamanho/2-1){ //primeiras 3 linhas
                        if (i % 2==0){ //linha começa sem peça
                            if (j % 2==1){
                                //System.out.println("Pedra adicionada em: " + i + ", " + j);
                                this.addPedra(partida.getCasa(i, j));
                            }
                        } else { //linha começa com peça
                            if (j % 2 == 0){
                                //System.out.println("Pedra adicionada em: " + i + ", " + j);
                                this.addPedra(partida.getCasa(i, j));
                            }
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < tamanho; ++i) {
                for (int j = 0; j < tamanho; ++j) {
                    if (i > tamanho / 2) { //últimas 3 linhas
                        if (i % 2 == 0) { //linha começa sem peça
                            if (j % 2 == 1) {
                                //System.out.println("Pedra adicionada em: " + i + ", " + j);
                                this.addPedra(partida.getCasa(i, j));
                            }
                        } else { //linha começa com peça
                            if (j % 2 == 0) {
                                //System.out.println("Pedra adicionada em: " + i + ", " + j);
                                this.addPedra(partida.getCasa(i, j));
                            }
                        }
                    }
                }
            }
        }
    }

    public ArrayList<Pedra> getListaPedras(){
        return this.lista_pedras;
    }

    public Integer getNumPedras(){
        return this.lista_pedras.size();
    }

    public void removePedra(Pedra pedra_alvo){
        this.lista_pedras.remove(pedra_alvo);
    }

    public void setCor(int cor){
        this.cor = cor;
    }

    //a ideia era que os movimentos possíveis fossem listados para o usuário
    public void escolherMovimento(Movimento movimento){
    }

    public void setDama(Pedra pedra){
        this.lista_pedras.get(this.lista_pedras.indexOf(pedra)).dama = true;
    }
}