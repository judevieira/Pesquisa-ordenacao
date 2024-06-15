import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        int nroCandidatos = rand.nextInt(100)+1;
        Candidato[] candidatos = new Candidato[nroCandidatos];

        String nomes[] = {"Lucia","Luiz","Antonio","Felipe","Amanda","Renata","Lucas","Rebeca","Maria","João"};
        String partidos[] = {"MDB", "MOBILIZA","AVANTE","PT","UNIAO","CIDADANIA","NOVO","REPUBLICANOS"};

        for (int i = 0; i <nroCandidatos; i++){

            String nomeCandidato = nomes[rand.nextInt(nomes.length)];
            String partido = partidos[rand.nextInt(partidos.length)];
            int intencoesVotos	= rand.nextInt(100);

            candidatos[i] = new Candidato(nomeCandidato, partido, intencoesVotos);
        }



        Candidato[] NomesOrdenados = ordenaCandidatosPorNome(candidatos);
        /* 
        System.out.println("Seleções ordenadas por nome:");
        imprimirCandidatos(candidatos);
        System.out.println();

        pesquisaBinariaCandidatos(candidatos,"");
        
*/
        ordenaCandidatosPorPartido(candidatos);
        System.out.println("Candidatos ordenados por partido: ");
        imprimirCandidatos(candidatos);
        System.out.println();


/* 
        ordenaCandidatosPorVotos(candidatos);
        System.out.println("Candidatos ordenados por voto: ");
        imprimirCandidatos(candidatos);

*/

        pesquisaCandidato(NomesOrdenados);
    }

    //insercao direta
    public static Candidato[] ordenaCandidatosPorNome(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            Candidato key = candidatos[i]; //armazena atual candidato em key
            int j = i - 1; // 'j' como o índice anterior ao índice 'i'
            
            // Comparar os nomes dos candidatos
            while (j >= 0 && candidatos[j].getNome().compareTo(key.getNome()) > 0) {
                candidatos[j + 1] = candidatos[j]; // Deslocar candidatos maiores para a direita
                j = j - 1; //movimenta j para a esquerda
            }
            
            candidatos[j + 1] = key; // Inserir key na posição correta
        }
        
        return candidatos;
    }
    
    
    //selecao direta
    public static void ordenaCandidatosPorVotos(Candidato[] candidatos){
        for (int i = 0; i < candidatos.length - 1; i++) { //percorre array
            int min = i; //menor elemento é o primeiro
    
            for (int j = i + 1; j < candidatos.length; j++) { //laco para procurar menor indice
                if (candidatos[j].getIntencoesVotos() < candidatos[min].getIntencoesVotos()) {
                    min = j; //atualiza para o menor indice encontrado
                }
            }
    
            // Troca o elemento atual (na posição i) pelo menor elemento encontrado (na posição min)
            Candidato temp = candidatos[i]; //guarda na variavel temporario 
            candidatos[i] = candidatos[min]; //guarda o min na variavel trabalhada
            candidatos[min] = temp; //guarda valor da variavel temp no minimo
        }
        
    }

    //insercao direta
    public static void ordenaCandidatosPorPartido(Candidato[] candidatos){
        for(int i = 1; i < candidatos.length; i++){ //percorre o array
            Candidato key = candidatos[i]; //guarda na key candidato
            int j = i - 1; //pega posicao anterior

            while(j>= 0 && candidatos[j].getPartido().compareTo(key.getPartido())>0){
                candidatos[j+1] = candidatos[j]; //muda posicao
                j = j-1;
            }
            candidatos[j + 1] = key;
        }

    }

    public static void pesquisaCandidato(Candidato[] candidatos){
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual candidato está procurando?");
        String nomePesquisado = scan.nextLine();
        int posicao = pesquisaBinariaCandidatos(candidatos, nomePesquisado);

        if (posicao != -1){
            System.out.println("Seu candidato foi encontrado na posição: " + posicao + " : ");
            System.out.println(candidatos[posicao]);
        }else{
            System.out.println("Seu candidato não foi encontrado, tente novamente!");
        }

        scan.close();
    } 

    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome){
        int inicio = 0;
        int fim = candidatos.length-1;

        while(inicio <= fim){
            int meio = inicio + (fim - inicio) / 2;
            if(candidatos[meio].getNome().equalsIgnoreCase(nome)){ 
                return meio; //se encontrou o nome no meio, retorna o indice do meio
            }
            if(candidatos[meio].getNome().compareToIgnoreCase(nome)<0){ //compara se a posicao do meio é maior ou menor
                inicio = meio + 1; //atualiza pra metade a direira
            } else{
                fim = meio -1 ; //atualiza pra outra metade a esquerda
            }
        }

        return -1; //retorna -1 se candidato nao foi encontrado
    }

    public static void imprimirCandidatos(Candidato[] candidatos) {
        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }
    }
}
