package stages;

import exceptions.StageException;
import interfaces.Executable;
import interfaces.Loggable;

import java.util.ArrayList;
import java.util.List;

public abstract class Stage implements Executable, Loggable {

    protected String nome;
    protected String status;
    protected List<String> logs;

    public Stage(String nome) {

        this.nome = nome;
        this.status = "Pendente";
        this.logs = new ArrayList<>();
    }

    public String getNome() {

        return nome;
    }

    public String getStatus() {

        return status;
    }

    public List<String> getLogs() {

        return logs;
    }

    @Override
    public void execute() throws StageException {

        status = "Executando";

        log("Iniciando etapa: " + nome);

        run();

        status = "Concluída";

        log("Etapa concluída: " + nome);
    }

    @Override
    public void log(String mensagem) {

        logs.add(mensagem);
    }

    protected abstract void run() throws StageException;
}