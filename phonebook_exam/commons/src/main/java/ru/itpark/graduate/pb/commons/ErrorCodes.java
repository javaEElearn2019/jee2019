package ru.itpark.graduate.pb.commons;

public enum ErrorCodes {
    OK(0L, ""),

    BUS_LOGIN_NOSET(1L, "Login is not set"),
    BUS_PASSWORD_NOSET(2L, "Password is not set"),
    BUS_LOGIN_ALREADY_USEING(3L, "Login already using"),
    BUS_RECORD_NOT_FOUND(4L, "Record not found"),
    BUS_RECORD_GUID_NOSET(5L, "Record id is not set"),

    IO_ERROR(898L, "I/O Excepion!"),
    DATABASE_ERROR(899L, "Error while query or connection!"),
    FATAL_ERROR(999L, "Fatal error! See logs for details.");

    Long id;
    String msg;

    ErrorCodes(Long id, String msg){
        this.id = id;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }
}