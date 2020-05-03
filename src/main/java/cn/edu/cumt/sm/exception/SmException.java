package cn.edu.cumt.sm.exception;

/**
 * @author Seeumt
 * @version 1.0
 * @date 2020/5/3 23:47
 */
public class SmException extends RuntimeException {

    private Integer code;

    public SmException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

//    public SmException(SmFlash smFlash) {
//        super(smFlash.getMsg());
//        this.code = smFlash.getCode();
//    }
}
