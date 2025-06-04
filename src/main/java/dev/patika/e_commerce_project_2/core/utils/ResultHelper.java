package dev.patika.e_commerce_project_2.core.utils;

import dev.patika.e_commerce_project_2.core.result.ResultData;

public class ResultHelper {

    public static <T> ResultData<T> created(T data) {
        return new ResultData<>(true, Msg.CREATED, "201", data);
    }

}
