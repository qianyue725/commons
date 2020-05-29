package com.qianyue.commons.base;

import java.io.Serializable;

/**
 * 描述:
 *
 * @auther qianyue
 * @date 2020/5/23 7:48
 */
public interface Result extends Serializable {

    boolean success();
    String getErrorMessage();

}