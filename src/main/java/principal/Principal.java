package principal;

import javax.swing.JOptionPane;
import model.Aluno;

public class Principal {

    public static void main(String[] args) {

        Aluno objetoaluno = new Aluno();

        int opcao = -1;
        while (opcao != 9) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("##Menu do Cadastro de Aluno##\n"
                    + "1 - Criar (Create)\n"
                    + "2 - Recuperação (Retrive)\n"
                    + "3 - Atualizar (Update)\n"
                    + "4 - Apagar (Delete)\n"
                    + "5 - Listar Tudo (List All)\n"
                    + "6 - Classificar (Classify)\n"
                    + "9 - Sair"));

            switch (opcao) {
                case 1:
                    //Declarando o aluno e instanciando
                    Aluno alunonovo = new Aluno();
                    //Preenchendo os atributos do aluno
                    alunonovo.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno")));
                    alunonovo.setNome(JOptionPane.showInputDialog("Digite o nome do aluno"));
                    alunonovo.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno")));
                    alunonovo.setCurso(JOptionPane.showInputDialog("Digite o curso do aluno"));
                    alunonovo.setFase(Integer.parseInt(JOptionPane.showInputDialog("Digite a fase do aluno")));
                    //Adicionando o aluno ao ArrayList
                    objetoaluno.insertAlunoBD(alunonovo);
                    System.out.println("Aluno inserido com sucesso!");
                    break;

                case 2:
                    int chaveProcura = Integer.parseInt(JOptionPane.showInputDialog("Digite o id de um aluno a ser localizado"));
                    int indice = objetoaluno.procuraIndice(chaveProcura);
                    if (indice != -1) {
                        System.out.println("Encontrei!");
                        System.out.println("  Id   :" + objetoaluno.getMinhaLista().get(indice).getId());
                        System.out.println("  Nome :" + objetoaluno.getMinhaLista().get(indice).getNome());
                        System.out.println("  Idade:" + objetoaluno.getMinhaLista().get(indice).getIdade());
                        System.out.println("  Curso:" + objetoaluno.getMinhaLista().get(indice).getCurso());
                        System.out.println("  Fase :" + objetoaluno.getMinhaLista().get(indice).getFase());
                    } else {
                        System.out.println("Não encontrei o aluno com o id:" + chaveProcura);
                    }
                    break;

                case 3:
                    //Declarando o aluno e instanciando
                    Aluno alunoatualizado = new Aluno();
                    //Preenchendo os atributos do aluno a ser atualizado
                    alunoatualizado.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno")));
                    alunoatualizado.setNome(JOptionPane.showInputDialog("Digite o nome do aluno"));
                    alunoatualizado.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno")));
                    alunoatualizado.setCurso(JOptionPane.showInputDialog("Digite o curso do aluno"));
                    alunoatualizado.setFase(Integer.parseInt(JOptionPane.showInputDialog("Digite a fase do aluno")));
                    //Posicao a ser atualizada no DAO
                    int indiceAtualizar = Integer.parseInt(JOptionPane.showInputDialog("Digite a  posicao a ser atualizada"));
                    objetoaluno.updateAlunoBD(indiceAtualizar, alunoatualizado);
                    System.out.println("Aluno atualizado com sucesso!");
                    break;

                case 4:
                    int chaveExclusao = Integer.parseInt(JOptionPane.showInputDialog("Digite o id de um aluno a ser excluído:"));
                    if (objetoaluno.deleteAlunoBD(chaveExclusao)) {
                        System.out.println("Aluno de id " + chaveExclusao + " excluído com sucesso!");
                    } else {
                        System.out.println("Não encontrei o aluno para excluir com o id:" + chaveExclusao);
                    }
                    break;

                case 5:
                    System.out.println("Listagem de alunos");
                    for (int i = 0; i < objetoaluno.getMinhaLista().size(); i++) {
                        System.out.println("i      :" + i);
                        System.out.println("  Id   :" + objetoaluno.getMinhaLista().get(i).getId());
                        System.out.println("  Nome :" + objetoaluno.getMinhaLista().get(i).getNome());
                        System.out.println("  Idade:" + objetoaluno.getMinhaLista().get(i).getIdade());
                        System.out.println("  Curso:" + objetoaluno.getMinhaLista().get(i).getCurso());
                        System.out.println("  Fase :" + objetoaluno.getMinhaLista().get(i).getFase());
                    }
                    break;
                    
                case 6:
                    System.out.println("Classificado os alunos pelo nome");
                    objetoaluno.classificar();                    
                    break;

                case 9:
                    System.out.println("Saindo do sistema");
                    break;
                    
                default:
                    System.out.println("Opção inválida");
                    break;
                    
            }//Fim switch
        }//Fim while
    }//Fim main
}//Fim classe

