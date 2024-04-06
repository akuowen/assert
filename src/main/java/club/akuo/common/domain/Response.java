package club.akuo.common.domain;

import java.io.Serializable;

/**
 * @author akuowen
 */
public class Response<T> implements Serializable {
    protected ResponseMessage message;
    protected T data;

    public Response() {
        this((ResponseMessage)null, null);
    }

    public Response(T data) {
        this((ResponseMessage)null, data);
    }

    public Response(ResponseMessage message, T data) {
        this.message = message;
        this.data = data;
    }

    public ResponseMessage getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message=" + message +
                ", data=" + data +
                '}';
    }

    public static Response<Void> ok() {
        return new Response(ResponseMessage.ok(), (Object)null);
    }

    public static Response<Void> error() {
        return new Response(ResponseMessage.error(), (Object)null);
    }

    public static <T> Response<T> error(T data) {
        return new Response(ResponseMessage.error(), data);
    }

    public static <T> Response<T> error(T data, String errorMsg) {
        ResponseMessage responseMessage = ResponseMessage.error();
        responseMessage.setMessage(errorMsg);
        return new Response(responseMessage, data);
    }

    public static <T> Response<T> error(T data, Integer errorCode, String errorMsg) {
        ResponseMessage responseMessage = ResponseMessage.error();
        responseMessage.setCode(errorCode);
        responseMessage.setMessage(errorMsg);
        return new Response(responseMessage, data);
    }

    public static <T> Response<T> ok(T data) {
        return new Response(ResponseMessage.ok(), data);
    }

    public void setMessage(ResponseMessage message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
