package springBootDbian1.demo.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private int code;
    private LocalDateTime timxestamp;

}
