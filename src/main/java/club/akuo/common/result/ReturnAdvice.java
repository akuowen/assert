package club.akuo.common.result;

import club.akuo.common.annotations.IgnoreUnified;
import club.akuo.common.domain.Response;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * @author akuowen
 */
@RestControllerAdvice
public class ReturnAdvice implements ResponseBodyAdvice<Object> {
    private final String API_END_STR;
    private final String EXCEPTION_HANDLRE_END_STR;

    public ReturnAdvice(@Value("${public.return.api:.api}") String apiEnd, @Value("${public.return.handler:.exception.handler}") String handlerEnd) {
        this.API_END_STR = apiEnd;
        this.EXCEPTION_HANDLRE_END_STR = handlerEnd;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        //忽略返回
        IgnoreUnified annotation = returnType.getExecutable().getDeclaredAnnotation(IgnoreUnified.class);
        return (returnType.getContainingClass().getName().equals("com.gemantic.common.result.ExceptionHandler")||returnType.getContainingClass().getPackage().getName().endsWith(API_END_STR) || returnType.getContainingClass().getPackage().getName().endsWith(EXCEPTION_HANDLRE_END_STR)) && Objects.isNull(annotation);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Response) {
            return body;
        }
        if (body instanceof String) {
            return new Gson().toJson(Response.ok(body));
        }
        if (selectedContentType.includes(MediaType.APPLICATION_JSON) || selectedContentType.includes(MediaType.TEXT_HTML) || selectedContentType.includes(MediaType.TEXT_PLAIN)) {
            return Response.ok(body);
        }
        return body;
    }
}
