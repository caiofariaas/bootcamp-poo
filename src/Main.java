import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Mentoria;

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

        System.out.println(curso1 + "\n");
        System.out.println(curso2 + "\n");
        System.out.println(mentoria + "\n");

// Polimorfismo
//  Tudo que existe em Conteudo existe em Curso
//  Mas nem tudo que existe em Curso existe em Conteudo
//
//        Conteudo conteudo = new Curso();



    }
}
