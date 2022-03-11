import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Movimento{
    public Casa origem, destino;
    public Pedra pedra_movida;
    public ArrayList<Pedra> pedras_capturadas;

    public Movimento(Integer[] origem, Integer[] destino){
        pedras_capturadas = new ArrayList<>();
        for(Casa casa : Partida.tabuleiro){
            if(casa.lin == origem[0] && casa.col == origem[1]){
                this.origem = casa;
            } if(casa.lin == destino[0] && casa.col == destino[1]){
                this.destino = casa;
            }
        }

        /*Verificar para qual diagonal a pedra se move e
         *separar a mesma do Map retornado por diagonais()*/

        try {
            this.pedra_movida = Partida.tabuleiro.get(Partida.tabuleiro.indexOf(this.origem)).pedra_ocupante;
        } catch (IndexOutOfBoundsException e){
            System.out.println("Casas inválidas");
        }
    }

    private Boolean casaValida(Casa casa){
        return casa.temPedra();
    }

    private Map<Integer, ArrayList<Pedra>> diagonais(){
        Integer height = 8 , width = 8;
        Integer target = this.origem.lin*8+this.origem.col;
        //coordinates of target
        Integer nRow = (target / width);
        Integer nCol = target % width;

        ArrayList<Pedra> LTR = new ArrayList<>(); //left to right diagonal
        for(Integer r = nRow - Math.min(nRow, nCol), c = nCol - Math.min(nRow, nCol); r < height && c < width; r++, c++){
            LTR.add(Partida.tabuleiro.get(r * width + c).pedraOcupante());
        }

        ArrayList<Pedra> RTL = new ArrayList<>(); //right to left diagonal
        for(Integer r = nRow - Math.min(nRow, width - nCol - 1), c = nCol + Math.min(nRow, width - nCol - 1); r < height && 0 <= c; r++, c--){
            RTL.add(Partida.tabuleiro.get(r * width + c).pedraOcupante());
        }

        Map<Integer, ArrayList<Pedra>> diagonais = new HashMap<>();
        diagonais.put(1, LTR); diagonais.put(2, RTL);

        return diagonais;
    }
}