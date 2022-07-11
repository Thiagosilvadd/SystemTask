package dev.thiagod.systemtask.entities.enums;

import com.sun.istack.NotNull;

public enum TaskStatus {
    PENDENTE(1),
    ATRASADA(2),
    CONCLUIDA(3),
    CANCELADA(4);

    private int code;

    private TaskStatus(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static @NotNull TaskStatus valueOf(int code){
        for (TaskStatus value : TaskStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TaskStatus code");
    }
}
