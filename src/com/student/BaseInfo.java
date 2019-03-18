package student;

/**
 * 基本信息
 * Date:2019/3/17
 * Time:22:14
 */
public class BaseInfo {
    private String studentId;
    private String studentName;
    private int age;
    private String college;
    private String className;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", age='" + age + '\'' +
                ", college='" + college + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    public String getInfo(){
        return "学号："+studentId+"\n"+
                "姓名:"+studentName+"\n"+
                "年龄:"+age+"\n"+
                "学院:"+college+"\n"+
                "班级:"+className+"\n"+"\n";
    }
}
