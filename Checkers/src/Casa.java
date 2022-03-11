public class Casa {
    public Integer lin, col;
    public Pedra pedra_ocupante;
    public Character simb;
    
    public Casa(Integer lin, Integer col){
        this.lin = lin;
        this.col = col;
        this.simb = this.temPedra() ? this.pedra_ocupante.simb : '_';
    }

    public Pedra pedraOcupante(){
        return this.pedra_ocupante;
    }

    public void setPedra(Pedra nova_pedra){
        if(nova_pedra == null){
            this.pedra_ocupante = null;
            this.simb = '_';
        } else {
            this.pedra_ocupante = nova_pedra;
            this.simb = nova_pedra.simb;
        }
    }

    public Boolean temPedra(){
        return this.pedra_ocupante == null ? false : true;
    }
}
