package retrofit2;

public class HttpException extends RuntimeException {
    private final int code;
    private final String message;

    public int code() {
        return this.code;
    }
}
