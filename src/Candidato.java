public class Candidato {
    private String nome;
    private String partido;
    private int intencoesVotos;

    public Candidato (String nome, String partido, int intencoesVotos){
        this.nome = nome;
        this.partido = partido;
        this.intencoesVotos = intencoesVotos;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setPartido(String partido){
        this.partido = partido;
    }

    public String getPartido(){
        return partido;
    }
    
    public void setIntencoesVotos(int intencoesVotos){
        this.intencoesVotos = intencoesVotos;
    }

    public int getIntencoesVotos(){
        return intencoesVotos;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
            "Partido: " + partido +
            "Intençoes de votos: " + intencoesVotos;
    }
}
