package com.ggs.event.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author lhh
 * @since 2024-07-08
 */
@TableName("car_complain")
@ApiModel(value = "CarComplain对象", description = "")
public class CarComplain implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long code;

    private LocalDate date;

    private String pinpai;

    private String chexi;

    private String problemClass;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPinpai() {
        return pinpai;
    }

    public void setPinpai(String pinpai) {
        this.pinpai = pinpai;
    }

    public String getChexi() {
        return chexi;
    }

    public void setChexi(String chexi) {
        this.chexi = chexi;
    }

    public String getProblemClass() {
        return problemClass;
    }

    public void setProblemClass(String problemClass) {
        this.problemClass = problemClass;
    }

    @Override
    public String toString() {
        return "CarComplain{" +
            "code = " + code +
            ", date = " + date +
            ", pinpai = " + pinpai +
            ", chexi = " + chexi +
            ", problemClass = " + problemClass +
        "}";
    }
}
