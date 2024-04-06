package club.akuo.common.defaults;

/**
 * @author akuowen
 */
public enum DefaultServerExceptionEnum implements DefaultServerExceptionAssert {
    NOT_FOUND(404, "地址找不到"),
    NOT_ALLOW(405, "不允许的访问方式");
    private final Integer code;
    private final String message;

    DefaultServerExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
