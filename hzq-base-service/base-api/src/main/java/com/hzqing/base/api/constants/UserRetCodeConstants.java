package com.hzqing.base.api.constants;

/**
 * @author hzqing
 * @date 2019-08-10 00:45
 */
public enum UserRetCodeConstants {
    SUCCESS                             ("000000","成功"),

    INVALID_PARAMETER                   ("INVALID_PARAMETER","请求参数缺失！"),


    USERNAMEORPASSWORD_ERRROR           ("001001","用户名或密码不正确"),
    TOKEN_VALID_FAILED                  ("001002","token校验失败"),
    USERNAME_ALREADY_EXISTS             ("001003","用户名已存在"),
    USER_REGISTER_FAILED                ("001004","注册失败，请联系管理员"),
    KAPTCHA_CODE_ERROR                  ("001005","验证码不正确"),

    REQUEST_FORMAT_ILLEGAL              ("001060", "请求数据格式非法"),
    REQUEST_IP_ILLEGAL                  ("001061", "请求IP非法"),
    REQUEST_CHECK_FAILURE               ("001062", "请求数据校验失败"),
    DATA_NOT_EXIST                      ("001070", "数据不存在"),
    DATA_REPEATED                       ("001071", "数据重复"),
    REQUEST_DATA_NOT_EXIST              ("001072", "传入对象不能为空"),
    REQUEST_DATA_ERROR                  ("001074", "必要的参数不正确"),
    REQUISITE_PARAMETER_NOT_EXIST       ("001073", "必要的参数不能为空"),
    PERMISSION_DENIED                   ("001091", "权限不足"),
    DB_EXCEPTION                        ("001097", "数据库异常"),
    SYSTEM_TIMEOUT                      ("001098", "系统超时"),
    SYSTEM_ERROR                        ("001099", "系统错误");


    private String code;

    private String msg;

    UserRetCodeConstants(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
