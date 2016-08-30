package com.systemnews.service;

import com.systemnews.model.Comment;

import java.util.List;

/**
 * Created by RADEK on 2016-08-30.
 */
public interface CustomInterfaceComment {

    Comment  findByNewsId(String id);


}
