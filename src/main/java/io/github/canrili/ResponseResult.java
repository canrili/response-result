package io.github.canrili;

import java.io.Serializable;

/**
 * @author ashley chao
 * @version 1.0
 * @description the response result for restful api
 * @date 2022-06-14
 */
public class ResponseResult<T> implements Serializable {

  private static final long serialVersionUID = -8221259420266462968L;

  private Integer code;

  private String message;

  private T data;

  private ResponseResult() {}

  /**
   * create a response result with ResponseResult.CodeEnum and message and data
   * @param code the response code
   * @param message the response message
   * @param data the response data
   */
  public ResponseResult(CodeEnum code, String message, T data) {
    this.code = code.value();
    this.message = message;
    this.data = data;
  }

  /**
   * create a successful response result with message and data
   * @param message
   * @param data
   * @return
   * @param <T>
   */
  public static <T> ResponseResult<T> ok(String message, T data) {
    return new ResponseResult<>(CodeEnum.SUCCESS, message, data);
  }

  /**
   * create a success response result
   * @return
   * @param <T>
   */
  public static <T> ResponseResult<T> ok() {
    return ResponseResult.ok("success", null);
  }


  public static <T> ResponseResult<T> error(String message, T data) {
    return new ResponseResult<>(CodeEnum.FAIL, message, data);
  }

  public static <T> ResponseResult<T> error() {
    return ResponseResult.error("fail", null);
  }

  public ResponseResult<T> withMessage(String message) {
    this.message = message;
    return this;
  }

  public ResponseResult<T> withData(T data) {
    this.data = data;
    return this;
  }

  public Integer getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public T getData() {
    return data;
  }

  @Override
  public String toString() {
    return "ResponseResult{"
        + "code="
        + code
        + ", message='"
        + message
        + '\''
        + ", data="
        + data
        + '}';
  }

  enum CodeEnum {
    SUCCESS(1),
    FAIL(0);

    /** code */
    private final int code;

    CodeEnum(int code) {
      this.code = code;
    }

    public int value() {
      return code;
    }
  }
}
