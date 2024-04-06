package club.akuo.common.result;

import club.akuo.common.domain.Response;
import club.akuo.common.exceptions.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author akuowen
 */
@RestControllerAdvice
public class ExceptionHandler {

    public static void appendExceptionHandler(Class<? extends Throwable>[] throwables, Function<Throwable, Response<?>> function) {
        for (Class<? extends Throwable> throwable : throwables) {
            THROWABLE_FUNCTION_MAP.put(throwable, function);
        }
    }

    private static final Map<Class<? extends Throwable>, Function<Throwable, Response<?>>> THROWABLE_FUNCTION_MAP = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);


    @org.springframework.web.bind.annotation.ExceptionHandler(Throwable.class)
    public Response dealNo(Throwable throwable) {
        LOGGER.error("当前请求发生错误", throwable);
        return THROWABLE_FUNCTION_MAP.get(throwable.getClass()).apply(throwable);
    }

    public static void main(String[] args) {
        System.out.println(Exception.class.isAssignableFrom(BaseException.class));
    }
}
