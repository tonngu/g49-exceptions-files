package se.lexicon.exception;



import java.time.LocalDateTime;
import java.util.UUID;

public class InsufficientFundsException extends Exception {
    private LocalDateTime localDateTime;
    private String errorCode;

    public InsufficientFundsException(String message){
        super(message);
        this.errorCode = UUID.randomUUID().toString();
        this.localDateTime = LocalDateTime.now();
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String description(){
        return "Message: " + super.getMessage() + ", Error Code: " + errorCode + ", Date time: " + localDateTime;
    }



}
