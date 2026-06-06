# Projeto-C06
Prompt usado:
Gere um diagrama UML de classes para um sistema de pipeline de software em Java.

Classes e interfaces:

<<interface>> Executable
+ execute()

<<interface>> Loggable
+ log(msg)

<<abstract>> Stage
# nome : String
# status : String
# logs : List<String>
+ getNome() : String
+ getStatus() : String
+ getLogs() : List<String>
+ execute()
+ log(msg)
# run()

BuildStage
+ run()

TestStage
- forcarFalha : boolean
+ run()

DeployStage
+ run()

Pipeline
- stages : List<Stage>
- logger : PipelineLogger
+ addStage(Stage)
+ runAll()

PipelineLogger
- path : Path
+ save(List<String>)

StageException

Relacionamentos:

- Stage implementa Executable.
- Stage implementa Loggable.
- BuildStage herda de Stage.
- TestStage herda de Stage.
- DeployStage herda de Stage.
- Pipeline possui uma coleção de objetos Stage.
- Pipeline possui uma associação com PipelineLogger.
- StageException herda de Exception.

Regras de representação:

- Utilizar triângulo vazio e linha contínua para herança (generalização).
- Utilizar triângulo vazio e linha tracejada para implementação de interfaces (realização).
- Utilizar losango vazio para agregação quando apropriado.
- Utilizar linha contínua para associações.
- Exibir multiplicidades em todos os relacionamentos relevantes.
- Exibir atributos e métodos com seus respectivos modificadores de acesso (+, -, #).
- Exibir tipos de atributos, parâmetros e retornos.
- Utilizar os estereótipos <<interface>> e <<abstract>>.
- Organizar o diagrama de forma hierárquica e legível, minimizando cruzamento de linhas.
