package com.example.analysisshop.common;

import com.example.analysisshop.common.Enum.CommonError;
import com.example.analysisshop.common.exception.ServiceException;

public class AssertUtil {

    public static void validIsNull(Object o) {
        if (o == null) {
            throw new ServiceException(CommonError.OBJECT_IS_NULL);
        }
    }
}
