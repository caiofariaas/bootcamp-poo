import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        Curso curso2 = new Curso();

        curso1.setTitulo("Curso java");
        curso1.setDesc("Descrição curso java");
        curso1.setCargaHoraria(8);

        curso2.setTitulo("Curso js");
        curso2.setDesc("Descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria Java");
        mentoria.setDesc("Desc Mentoria Java");
        mentoria.setData(LocalDate.now());

//        System.out.println(curso1 + "\n");
//        System.out.println(curso2 + "\n");
//        System.out.println(mentoria + "\n");

// Polimorfismo
//  Tudo que existe em Conteudo existe em Curso
//  Mas nem tudo que existe em Curso existe em Conteudo
//
//        Conteudo conteudo = new Curso();


//  Criando um bootcamp e adicionando curoso a ele

        Bootcamp bootcamp1 = new Bootcamp();

        bootcamp1.setNome("Bootcamp Java Dev");
        bootcamp1.setDesc("Desc Bootcamp Java dev");
        bootcamp1.getConteudos().add(curso1);
        bootcamp1.getConteudos().add(curso2);
        bootcamp1.getConteudos().add(mentoria);

//  Criando Dev's

        Dev dev1 = new Dev();
        dev1.setNome("Camila");

        Dev dev2 = new Dev();
        dev2.setNome("joão");

        dev1.inscreverBootcamp(bootcamp1);
        dev2.inscreverBootcamp(bootcamp1);


        dev1.progredir();
        System.out.println(dev1.getConteudosInscritos());
        System.out.println(dev1.getConteudosConcluidos());

        System.out.println();

        dev2.progredir();
        System.out.println(dev2.getConteudosInscritos());
        System.out.println(dev2.getConteudosConcluidos());
    }
}
