package club.akuo.common.domain;

import java.io.Serializable;

/**
 * @author akuowen
 */
public class ResponseMessage implements Serializable {
    private int status = 200;
    private int code;
    private String message;
    public static final String SUCCESS_MSG = "success";
    public static final String FAILURE_MSG = "failure";
    public static final int SUCCESS_CODE = 0;
    public static final int FAILURE_CODE = -1;

    public ResponseMessage() {
    }

    public ResponseMessage(int status, int code) {
        this.status = status;
        this.code = code;
    }

    public ResponseMessage(int status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public static ResponseMessage ok() {
        return new ResponseMessage(200, 0, "success");
    }

    public static ResponseMessage error() {
        return new ResponseMessage(200, -1, "failure");
    }

    public static ResponseMessage error(int code, String message) {
        return new ResponseMessage(200, code, message);
    }

    public static ResponseMessage error(int status, int code, String message) {
        return new ResponseMessage(status, code, message);
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "status=" + status +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
