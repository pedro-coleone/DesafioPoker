package DesafioPoker;

public class Carta {
    // Atributos
    private String nome;
    private String naipe;

    // Construtor
    public Carta(){
        nome = " ";
        naipe = " ";
    }
    // Métodos
    public void setNome(String nomeSet){
        nome = nomeSet;
    }
    public void setNaipe(String naipeSet){
        naipe = naipeSet;
    }
    public String getNome(){
        return nome;
    }
    public String getNaipe(){
        return naipe;
    }
}
