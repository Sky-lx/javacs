package top.lx.exception;

public class zdyException extends Exception{
//    用来存储自定义异常提示信息的字符串
    private String message;

    public zdyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
