package pipeline;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PipelineLogger {

    private Path path;

    public PipelineLogger(Path path) {

        this.path = path;
    }

    public void save(List<String> logs) throws IOException {

        Files.write(path, logs);
    }
}