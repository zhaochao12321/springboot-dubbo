package zhao.xiaobai.common;


public class ResponseTemplate<T> {

    private T result;
    private int resultCode;
    private String resultMsg = "";

    /**
     * @param data
     * @param code
     * @param msg
     */
    ResponseTemplate(T data, ResultStat code, String msg) {
        this.result = data;
        this.resultCode = code.responseCode;
        this.resultMsg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

}
