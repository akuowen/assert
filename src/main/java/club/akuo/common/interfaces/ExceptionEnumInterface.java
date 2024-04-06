package club.akuo.common.interfaces;

/**
 * @author akuowen
 */
public interface ExceptionEnumInterface {
    /**
     * 获取异常编码
     * @return Integer
     */
    Integer getCode();

    /**
     * 获取异常信息
     * @return String
     */
    String getMessage();
}
