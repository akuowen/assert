package club.akuo.common.defaults;

import club.akuo.common.exceptions.BaseException;
import club.akuo.common.exceptions.DefaultServerException;
import club.akuo.common.interfaces.Assert;
import club.akuo.common.interfaces.ExceptionEnumInterface;

/**
 * @author akuowen
 */
public interface DefaultServerExceptionAssert extends ExceptionEnumInterface, Assert {
    @Override
    default BaseException newException(Object... args) {
        return new DefaultServerException(this, args, this.getMessage());
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        return new DefaultServerException(this, args, this.getMessage(), t);
    }
}
