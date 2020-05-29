package com.tgcity.example.demo1.common.model.response;

import lombok.Getter;

/**
 * @author: TGCity
 * @create: 2020/5/28
 * @description 具体的响应信息枚举，主要对外提供响应状态码以及对应的信息
 */
@Getter
public enum Message {

    /**
     * 自定义响应信息枚举
     */

    OK(200, "操作成功"),
    EXPORT_SUCCESS(200, "导出成功"),
    CREATED_SUCCESS(200, "添加成功"),
    DELETED_SUCCESS(200, "删除成功"),
    UPDATE_SUCCESS(200, "更新成功"),

    UPLOADED_IMAGE_FORMAT_ERROR(400, "上传的图片格式不正确"),
    IMAGE_NOT_EXIST(400, "需要压缩的图片不存在"),
    ACCOUNT_EXIST(400, "账号已存在"),
    ID_NUMBER_EXIST(400, "身份证号已存在"),
    PHONE_EXIST(400, "手机号已存在"),

    NOT_LOGGED_IN(401, "未登录"),

    INVALID_USERNAME_OR_PASSWORD(403, "用户名或密码错误"),
    ACCOUNT_VERIFICATION_FAILED(403, "账户验证失败"),
    VERIFICATION_CODE_EXPIRED(403, "验证码已失效"),
    NO_PERMISSION(403, "无权限"),

    USER_NOT_FOUND(404, "该用户不存在"),
    NODE_NOT_FOUND(404, "该监测点不存在"),
    RIVER_NOT_FOUND(404, "该河流不存在"),
    PATROL_NOT_FOUND(404, "巡查记录不存在"),
    AREA_NOT_FOUND(404, "该区域不存在"),
    SEWAGE_NOT_FOUND(404, "该污水厂不存在"),
    MANAGER_NOT_FOUND(404, "该河长不存在"),
    BASE64_NOT_EMPTY(400, "Base64格式图片为空"),
    EXPORT_ERROR(404, "导出失败"),
    IMPORT_ERROR(404, "上传失败"),
    MANAGER_VILLAGE_MATCH_ERROR(404, "河长和村居不匹配"),
    TIME_SCOPE_ERROR(404, "时间范围错误"),

    TWO_PASSWORD_EQUAL(405, "新密码和确认密码不一致"),

    PASSWORD_ERROR(500, "旧密码输入错误"),
    HZZ_MAP_ERROR(500, "映射河长制数据出现错误"),
    UPDATE_FAIL(500, "更新失败"),
    DELETED_FAIL(500, "删除失败"),
    CREATED_FAIL(500, "添加失败"),
    SYSTEM_ERROR(500, "系统异常"),
    ;

    /**
     * 状态码
     */
    int code;

    /**
     * 返回信息
     */
    String message;

    Message(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
