package stages;

import exceptions.StageException;

public class DeployStage extends Stage {

    public DeployStage(String nomeDaEtapa) {

        super(nomeDaEtapa);
    }

    @Override
    public void run() throws StageException {

        System.out.println("Iniciando: " + getNome());
        System.out.println("Processando");
        System.out.println("Transferindo");

        try {

            Thread.sleep(1500);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            throw new StageException("Processo de deploy abortado");
        }

        System.out.println("Deploy finalizado com sucesso.\n");
    }
}