package com;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * 学生服务，根据学生户籍和学籍信息，打印学生基本信息
 * Date:2019/3/17
 * Time:22:21
 */
public class StudentService {

    public BaseInfo getStudentBaseInfo(HouseInfo houseInfo,StudentInfo studentInfo){
        BaseInfo baseInfo = new BaseInfo();
        if(houseInfo == null || studentInfo == null){
            return null;
        }
        Date date = houseInfo.getBirthday();

        int ageTime = (int) ((System.currentTimeMillis() - date.getTime())/(1000 * 60 * 60 * 24)/365);
        baseInfo.setAge(ageTime);
        baseInfo.setStudentId(studentInfo.getStudentId());
        baseInfo.setStudentName(houseInfo.getName());
        baseInfo.setCollege(studentInfo.getCollege());
        baseInfo.setClassName(studentInfo.getClassName());
        return baseInfo;

    }

}
