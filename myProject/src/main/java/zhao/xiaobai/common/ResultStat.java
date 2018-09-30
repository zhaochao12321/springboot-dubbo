package zhao.xiaobai.common;

import org.apache.http.util.TextUtils;


public enum ResultStat {

    /**
     * if you need new result code, add it here and give it a good name
     */
    OK(200),

    PARAM_ERROR(400),

    FORBIDDEN(403),

    RESOURCE_NOT_EXIST(404),

    SERVER_INTERNAL_ERROR(500),

    MAX(9999);


    public final int responseCode;

    private ResultStat(int code) {
        this.responseCode = code;
    }

    public <T> ResponseTemplate<T> wrap(T data) {
        return wrap(data, null);
    }

    /**
     * wrap the result with a result code and result message
     *
     * @param data result data
     * @param msg  result message
     * @param <T>  result type
     * @return
     */
    public <T> ResponseTemplate<T> wrap(T data, String msg) {
        String message = this.name();
        if (!TextUtils.isBlank(msg)) {
            message = message + ":" + msg;
        }
        return new ResponseTemplate<>(data, this, message);
    }
}
