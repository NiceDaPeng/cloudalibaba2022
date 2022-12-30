package com.dapeng.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author diaopengwei
 * @date 2022/12/30
 * @apiNote
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book {

    private Long id;  //主键
    private String name;  //书名
    private String category;  //哲学,小说
    private Integer score;  //读者的评分
    private String intro;  //简介
}
