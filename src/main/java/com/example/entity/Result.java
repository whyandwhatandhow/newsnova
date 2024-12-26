package com.example.entity;/**
 * @className: Wnews
 * @description:
 * @author: 彭城江
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@ClassName Result
 *@Description TODO
 *@Author pzl
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {


    private int code;

    private String msg;

    private Object data;

    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }
    public static Result success() {
        return new Result(0, "操作成功", null);
    }

    public static Result error(String message) {
        return new Result(1, message, null);
    }
}
