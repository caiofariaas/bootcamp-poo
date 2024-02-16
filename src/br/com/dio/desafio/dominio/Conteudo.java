package br.com.dio.desafio.dominio;

// Classes abstratas não podem ser instanciadas
// esta classe foi criada apenas para auxiliar as suas classes filhas e evitar repetções de código

public abstract class Conteudo{

    protected static final double XP_PADRAO = 10d;
    private String titulo;
    private String desc;

    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
