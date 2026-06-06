package stages;

import exceptions.StageException;

public class BuildStage extends Stage {

    public BuildStage(String nomeDaEtapa) {

        super(nomeDaEtapa);
    }

    @Override
    public void run() throws StageException {

        System.out.println("Iniciando etapa " + getNome());
        System.out.println("Compilando arquivos");

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            throw new StageException(
                    "A compilação foi interrompida devido a um erro: "
                            + e.getMessage()
            );
        }

        System.out.println("Compilação finalizada.\n");
    }
}