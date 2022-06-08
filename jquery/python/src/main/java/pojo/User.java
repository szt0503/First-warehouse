package pojo;

import org.apache.ibatis.type.Alias;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
//@Alias("user")
public class User {
    private int id;
    private int smb_id;
    //用户编号
    private String userCode;
    //用户名
    private String username;
    //用户密码
    private String userpassword;
    //性别
    private int gender1;
    //生日
    private Date birthday;
    //手机号码
    private String phone;
    //家庭住址
    private String address;
    //用户的角色
    private int userRole;
    //创建者
    private int createdBy;
    //创建时间
    private Date creationDate;
    //修改者
    private int modifyBy;
    //修改时间
    private Date modifyDate;
    //无参构造方法
    private List<Address> addressList;

    public User() {
    }

    //全参构造方法
    public User(int id, int smb_id, String userCode, String username, String userpassword, int gender, Date birthday, String phone, String address, int userRole, int createdBy, Date creationDate, int modifyBy, Date modifyDate) {
        this.id = id;
        this.smb_id = smb_id;
        this.userCode = userCode;
        this.username = username;
        this.userpassword = userpassword;
        this.gender1 = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.userRole = userRole;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }
    //生成get set 方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSmb_id() {
        return smb_id;
    }

    public void setSmb_id(int smb_id) {
        this.smb_id = smb_id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public int getGender() {
        return gender1;
    }

    public void setGender(int gender) {
        this.gender1 = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(int modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    //生成toString
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", smb_id=" + smb_id +
                ", userCode='" + userCode + '\'' +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", gender=" + gender1 +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userRole=" + userRole +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", addressList=" + addressList +
                '}';
    }
}
