package DesafioPoker;

public class Baralho {
    // Atributos
    private Carta[] cartas = new Carta[52];

    // Construtor
    public Baralho(){
        for(int i = 1; i <= 13; i++){
            // Utilizando o 4*(i-1) para transformar a posição do baralho no nome da carta
            int posicao = 4 * (i - 1);

            // Loop de 4 iterações para atribuir as 4 cartas de cada nome
            for(int j = 0; j < 4; j++){
                cartas[posicao+j] = new Carta();
                switch (i){
                    case 1: cartas[posicao+j].setNome("A");
                        break;
                    case 11:cartas[posicao+j].setNome("J");
                        break;
                    case 12:cartas[posicao+j].setNome("Q");
                        break;
                    case 13:cartas[posicao+j].setNome("K");
                        break;
                    default:cartas[posicao+j].setNome(i+"");
                        break;
                }
                // Utilizando o resto da divisao da iteração por 4
                // para transformar a itração da carta no naipe
                switch(j % 4){
                    case 0: cartas[posicao+j].setNaipe("♦");
                        break;
                    case 1: cartas[posicao+j].setNaipe("♠");
                        break;
                    case 2: cartas[posicao+j].setNaipe("♥");
                        break;
                    case 3: cartas[posicao+j].setNaipe("♣");
                        break;
                }
            }

        }
    }

    // Métodos
    public void imprimeBaralho(){
        for(int i = 0; i < 52; i++){
            if (i%4 == 0 && i > 0 && i < 52){
                System.out.println();
            }
            if(cartas[i].getNome() != null) {
                System.out.print(cartas[i].getNome() + cartas[i].getNaipe() + " ");
            }
            else{
                System.out.print("❌  ");
            }
        }
    }

    public void embaralha(){
        int rand1, rand2;
        String nome, naipe;
        for(int i = 0; i < 100; i++){
            rand1 = (int)(Math.random() * 51);
            rand2 = (int)(Math.random() * 51);

            nome = cartas[rand1].getNome();
            cartas[rand1].setNome(cartas[rand2].getNome());
            cartas[rand2].setNome(nome);

            naipe = cartas[rand1].getNaipe();
            cartas[rand1].setNaipe(cartas[rand2].getNaipe());
            cartas[rand2].setNaipe(naipe);
        }
    }
    public void retiraPar(int posicao){
        cartas[posicao].setNome(null);
        cartas[posicao].setNaipe(null);
        cartas[posicao+1].setNome(null);
        cartas[posicao+1].setNaipe(null);
    }

    public boolean temCarta(){
        if(cartas[51].getNome() != null){
            return true;
        }
        else{
            return false;
        }
    }

    public void imprimeCartas(int inicio, int nCartas){
        for(int i = inicio; i < nCartas+inicio; i++){
            if(cartas[i].getNome()!=null) {
                System.out.print("|" + cartas[i].getNome() + cartas[i].getNaipe() + "| ");
            }
            else{
                nCartas++;
            }
        }
        System.out.println();
    }

    public double somaApostas(double[] apostas){
        double total = 0;
        for(int i = 0; i < 26; i++){
            total += apostas[i];
        }
        return total;
    }

}
