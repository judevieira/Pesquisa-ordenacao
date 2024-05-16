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

            String nomeCandidato = nomes[rand.nextInt(nomes.length)] + " | ";
            String partido = partidos[rand.nextInt(partidos.length)]  + " | ";
            int intencoesVotos	= rand.nextInt(100);

            candidatos[i] = new Candidato(nomeCandidato, partido, intencoesVotos);
        }

        Candidato[] NomesOrdenados = ordenaCandidatosPorNome(candidatos);

        System.out.println("Seleções ordenadas por nome:");
        imprimirCandidatos(candidatos);
        System.out.println();
/* 
        ordenaCandidatosPorPartido(candidatos);
        System.out.println("Candidatos ordenados por partido: ");
        imprimirCandidatos(candidatos);
        System.out.println();

        ordenaCandidatosPorVotos(candidatos);
        System.out.println("Candidatos ordenados por voto: ");
        imprimirCandidatos(candidatos);*/

        pesquisaCandidato(NomesOrdenados);
    }

    

    public static Candidato[] ordenaCandidatosPorNome(Candidato[] candidatos){
        for(int i = 1; i < candidatos.length; i++){
            Candidato key = candidatos[i];
            int j = i -1;
            
            while(j >= 0 && candidatos[j].getNome().compareTo(key.getNome())>0){
                candidatos[j + 1] = candidatos[j];
                j = j-1;
            }

            candidatos[j + 1] = key;
        }
        return candidatos;
    }

    public static void ordenaCandidatosPorVotos(Candidato[] candidatos){
        for (int i = 0; i < candidatos.length - 1; i++) {
            int min = i; 
    
            for (int j = i + 1; j < candidatos.length; j++) {
                if (candidatos[j].getIntencoesVotos() < candidatos[min].getIntencoesVotos()) {
                    min = j;
                }
            }
    
            Candidato temp = candidatos[i];
            candidatos[i] = candidatos[min];
            candidatos[min] = temp;
        }
        
    }

    public static void ordenaCandidatosPorPartido(Candidato[] candidatos){
        for(int i = 1; i < candidatos.length; i++){
            Candidato key = candidatos[i];
            int j = i - 1;

            while(j>= 0 && candidatos[j].getPartido().compareTo(key.getPartido())>0){
                candidatos[j+1] = candidatos[j];
                j = j-1;
            }
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
        int inicio = 1;
        int fim = candidatos.length-1;

        while(inicio <= fim){
            int meio = inicio + (fim - inicio) /2;
            if(candidatos[meio].getNome().equals(nome)){
                return meio;
            }
            if(candidatos[meio].getNome().compareTo(nome)<0){
                inicio = meio + 1;
            } else{
                fim = meio -1 ;
            }
        }

        return -1;
    }

    public static void imprimirCandidatos(Candidato[] candidatos) {
        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }
    }
}
