package club.akuo.common.exceptions;

import club.akuo.common.interfaces.ExceptionEnumInterface;

/**
 * @author akuowen
 */
public class DefaultServerException extends BaseException {
    public DefaultServerException(ExceptionEnumInterface iResponseEnum) {
        super(iResponseEnum);
    }

    public DefaultServerException(ExceptionEnumInterface responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public DefaultServerException(ExceptionEnumInterface responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
