package exceptions;

public class StageException extends Exception {

    public StageException(String mensagem) {

        super(mensagem);
    }

    public StageException(String mensagem, Throwable causa) {

        super(mensagem, causa);
    }
}