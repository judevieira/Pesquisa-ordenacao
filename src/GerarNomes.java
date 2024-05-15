import java.util.Random;

public class GerarNomes {
    private final String[] nomes = {"Maria","João","Marcelo","Vitor","Lucia","Rebeca","Tales","Luiz"};

    public String GerarNomeAleatorio (){
        Random rand = new Random();
        String nome = nomes[rand.nextInt(nomes.length)];
        return nome;
    }
}
