public class Combate {
    private Atacante atacante;
    private Defensor defensor;
    private Magia magia;

    public Combate(Atacante atacante, Defensor defensor) {
        this.atacante = atacante;
        this.defensor = defensor;
    }

    public Combate(Atacante atacante, Defensor defensor, Magia magia) {
        this.atacante = atacante;
        this.defensor = defensor;
        this.magia = magia;
    }

    public Combate(Magia magia) {
        this.magia = magia;
    }

    public int realizarAtaque(){
        int dano = atacante.atacar();
        return defensor.defender(dano);
    }

    public String usarMagia(String tipo){
        return magia . lancarMagia (tipo);
    }
}

