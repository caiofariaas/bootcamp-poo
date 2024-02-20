package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;

// A coleção SET não permite repetições, por exemplo, um Dev não pode se inscrever duas vezes em um mesmo bootcamp

    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

// é necessário que ao se inscrever em um bootcamp, todos os conteúdos presentes nele
// automaticamente se direcionem ao Set de conteudosIncritos

    public void inscreverBootcamp(Bootcamp bootcamp){

        // Adicionando ao Set todos os conteúdos presentes no BootCamp

        this.conteudosInscritos.addAll(bootcamp.getConteudos());

        // pegamos o Set<> que possui os devs inscritos no bootcamp e usando o this adicionamos o novo

        bootcamp.getDevsInscritos().add(this);
    }

// Este método é responsável por adicionar um conteúdo concluido ao set de conteúdos concluidos

    public void progredir(){

        // pegamos os conteudos inscritos e com o stream() ganhamos acesso a um método chamado findFirst()
        // que usamos para pegar sempre o primeiro conteúdo, pois, estamos fazendo por ordem!

        // o stream() é um método presente em coleções que te da acesso a muitos outros métodos úteis!
        // como por exemplo .map(), .filter(), .mapToInt(), .findAny(), etc...

        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();

        // caso exista o conteúdo e o colocamos como concluído e removemos das pendentes

        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        }
        else {

            // System.err é o output padrão de erros do sistema

            System.err.println("Você não esta matriculado em nenhum conteúdo!");
        }
    }

    public double calcularXp(){

        // Pegamos os conteúdos concluídos e através do stream API utilizamos o método mapToDouble
        // passando a função que calcula o XP individual por conteúdo, e por fim nós somamos tudo

        return  this.conteudosConcluidos.stream()
                .mapToDouble(conteudo -> conteudo.calcularXp())
                .sum();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

// Equals and HashCode - Estudar

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
