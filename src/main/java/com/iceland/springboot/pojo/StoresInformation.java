package com.iceland.springboot.pojo;

import lombok.Data;

@Data
public class StoresInformation {
    private int id;
    private String cityName;
    private String storeName;
    private String storeAddress;
    //营业执照
    private String businessLicense;
    //行业资质
    private String industryQualification;
}
