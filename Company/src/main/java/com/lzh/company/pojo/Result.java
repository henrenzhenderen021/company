package com.lzh.company.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;
    private T data;//返回数据
    public static <E> Result<E> success(E data){
        return new Result<>(0, data);
    }
    public static Result success(){
        return new Result(0,null);
    }
    public static Result error(int code){
        return new Result(code, null);
    }
}
