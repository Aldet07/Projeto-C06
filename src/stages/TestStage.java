package stages;

import exceptions.StageException;

public class TestStage extends Stage {

    private boolean forcarFalha;

    public TestStage(String nomeDaEtapa, boolean forcarFalha) {

        super(nomeDaEtapa);
        this.forcarFalha = forcarFalha;
    }

    @Override
    public void run() throws StageException {

        System.out.println(
                "Iniciando " + getNome() + " (Execução paralela)"
        );

        final RuntimeException[] erroThread = {null};

        Thread testesUnitarios = new Thread(() -> {

            System.out.println("* Executando testes unitários");

            try {

                Thread.sleep(800);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }

            System.out.println("* Testes unitários concluídos");
        });

        Thread testesIntegracao = new Thread(() -> {

            System.out.println("* Executando testes de integração");

            try {

                Thread.sleep(1200);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }

            if (forcarFalha) {

                erroThread[0] =
                        new RuntimeException(
                                "Falha de conexão com o banco de dados"
                        );

                return;
            }

            System.out.println("* Testes de integração concluídos");
        });

        testesUnitarios.start();
        testesIntegracao.start();

        try {

            testesUnitarios.join();
            testesIntegracao.join();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            throw new StageException(
                    "A execução dos testes foi interrompida"
            );
        }

        if (erroThread[0] != null) {

            throw new StageException(
                    "Erro Crítico: " + erroThread[0].getMessage(),
                    erroThread[0]
            );
        }

        System.out.println(
                "Etapa de testes finalizada com sucesso.\n"
        );
    }
}