package io.github.canrili;

import java.io.Serializable;

/**
 * a response result for the restful api
 *
 * @author ashley chao
 * @version 1.0
 */
public class ResponseResult<T> implements Serializable {

  private static final long serialVersionUID = -8221259420266462968L;

  private Integer code;

  private String message;

  private T data;

  private ResponseResult() {}

  /**
   * create a response result with ResponseResult.CodeEnum and message and data
   *
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
   *
   * @param message the response message
   * @param data the response data
   * @return the response result
   * @param <T> the response data type
   */
  public static <T> ResponseResult<T> ok(String message, T data) {
    return new ResponseResult<>(CodeEnum.SUCCESS, message, data);
  }

  /**
   * create a success response result
   *
   * @return the response result
   * @param <T> the response data type
   */
  public static <T> ResponseResult<T> ok() {
    return ResponseResult.ok("success", null);
  }

  /**
   * create a failed response result with message
   *
   * @param message the response message
   * @param data the response data
   * @return the response result
   * @param <T> the response data type
   */
  public static <T> ResponseResult<T> error(String message, T data) {
    return new ResponseResult<>(CodeEnum.FAIL, message, data);
  }

  /**
   * create a failed response result
   *
   * @return the response result
   * @param <T> the response data type
   */
  public static <T> ResponseResult<T> error() {
    return ResponseResult.error("fail", null);
  }

  /**
   * set message of a response result
   *
   * @param message the response message
   * @return the response result
   */
  public ResponseResult<T> withMessage(String message) {
    this.message = message;
    return this;
  }

  /**
   * set data of a response result
   *
   * @param data the response data
   * @return the response result
   */
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
