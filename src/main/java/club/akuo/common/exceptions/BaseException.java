package club.akuo.common.exceptions;

import club.akuo.common.interfaces.ExceptionEnumInterface;

import java.util.Arrays;

/**
 * @author akuowen
 */
public class BaseException extends RuntimeException {
    protected ExceptionEnumInterface exceptionEnumInterface;
    protected Object[] args;

    public BaseException(ExceptionEnumInterface iResponseEnum) {
        super(iResponseEnum.getMessage());
        this.exceptionEnumInterface = iResponseEnum;
    }

    public BaseException(ExceptionEnumInterface responseEnum, Object[] args, String message) {
        super(message);
        this.exceptionEnumInterface = responseEnum;
        this.args = args;
    }

    public BaseException(ExceptionEnumInterface responseEnum, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.exceptionEnumInterface = responseEnum;
        this.args = args;
    }

    public ExceptionEnumInterface getExceptionEnumInterface() {
        return exceptionEnumInterface;
    }

    public Object[] getArgs() {
        return args;
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "exceptionEnumInterface=" + exceptionEnumInterface +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
