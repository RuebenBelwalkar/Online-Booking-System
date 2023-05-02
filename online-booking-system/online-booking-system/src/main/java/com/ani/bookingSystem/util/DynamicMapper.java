package com.ani.bookingSystem.util;
import org.springframework.beans.BeanUtils;

public class DynamicMapper {
    public<T,U> U converter(T entity,U dto){
        BeanUtils.copyProperties(entity,dto);
        return dto;

    }
}


