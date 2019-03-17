package com;

import java.time.LocalDate;
import java.util.Date;

/**
 * 户籍信息
 * Date:2019/3/17
 * Time:22:15
 */
public class HouseInfo {
    private String name;
    private String idCard;
    private Date birthday;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
