package co.edu.eam.sd.votaciones.votingData.exceptions;

public class ExecutionResultException extends BusinessException{

    public ExecutionResultException(String message, String ErrorCode) {

        super(message, ErrorCode);
    }
}
