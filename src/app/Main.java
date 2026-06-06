package app;

import pipeline.Pipeline;
import pipeline.PipelineLogger;
import stages.BuildStage;
import stages.DeployStage;
import stages.TestStage;

import java.nio.file.Path;

public class Main {

  public static void main(String[] args) {

    PipelineLogger logger =
            new PipelineLogger(Path.of("logs.txt"));

    Pipeline pipeline =
            new Pipeline(logger);

    pipeline.addStage(
            new BuildStage("Build")
    );

    pipeline.addStage(
            new TestStage("Testes", false)
    );

    pipeline.addStage(
            new DeployStage("Deploy")
    );

    pipeline.runAll();
  }
}