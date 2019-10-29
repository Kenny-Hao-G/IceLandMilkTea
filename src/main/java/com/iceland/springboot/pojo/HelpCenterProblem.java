package com.iceland.springboot.pojo;

import lombok.Data;

@Data
public class HelpCenterProblem {
    private int id;
    private String problemName;
    private String info;
    private int parentId;
    private String title;

}
