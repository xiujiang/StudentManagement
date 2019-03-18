package student;

 /**
 * 学籍信息
 * Date:2019/3/17
 * Time:22:14
 */
public class StudentInfo {
   private String studentId;
   private String idCard;
   private String college;
   private String profession;
   private String className;


  public String getStudentId() {
   return studentId;
  }

  public void setStudentId(String studentId) {
   this.studentId = studentId;
  }

  public String getIdCard() {
   return idCard;
  }

  public void setIdCard(String idCard) {
   this.idCard = idCard;
  }

  public String getCollege() {
   return college;
  }

  public void setCollege(String college) {
   this.college = college;
  }

  public String getProfession() {
   return profession;
  }

  public void setProfession(String profession) {
   this.profession = profession;
  }

  public String getClassName() {
   return className;
  }

  public void setClassName(String className) {
   this.className = className;
  }

  @Override
  public String toString() {
   return "StudentInfo{" +
           "studentId='" + studentId + '\'' +
           ", idCard='" + idCard + '\'' +
           ", college='" + college + '\'' +
           ", profession='" + profession + '\'' +
           ", className='" + className + '\'' +
           '}';
  }
 }
