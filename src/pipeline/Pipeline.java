package pipeline;

import exceptions.StageException;
import stages.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pipeline {

    private List<Stage> stages;
    private PipelineLogger logger;

    public Pipeline(PipelineLogger logger) {

        this.logger = logger;
        this.stages = new ArrayList<>();
    }

    public void addStage(Stage stage) {

        stages.add(stage);
    }

    public void runAll() {

        List<String> todosLogs = new ArrayList<>();

        for (Stage stage : stages) {

            try {

                stage.execute();

            } catch (StageException e) {

                stage.log("ERRO: " + e.getMessage());

                System.out.println(e.getMessage());
            }

            todosLogs.addAll(stage.getLogs());
        }

        try {

            logger.save(todosLogs);

        } catch (IOException e) {

            System.out.println("Erro ao salvar logs: " + e.getMessage());
        }
    }
}