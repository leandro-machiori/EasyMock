public interface Atacante {
    int atacar();
}

public interface Defensor {
    int defender(int dano);
}

public interface Magia {
    String lancarMagia(String tipo);
}
