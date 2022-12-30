package com.dapeng.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author diaopengwei
 * @date 2022/12/30
 * @apiNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple {

    private Integer id;
    private String color;
    private Integer weight;
    private String origin;
}
