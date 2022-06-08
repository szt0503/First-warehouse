package pojo;

import java.io.Serializable;
import java.util.Date;

public class Address implements Serializable {
    //id主键，唯一标识
    private int id;
    //联系人
    private String contact;
    //具体地址
    private String addressDesc;
    //邮箱
    private String postCode;
    //电话
    private String tel;
    private String createdBy;
    private Date creationDate;
    private int modifyBy;
    private Date modifyDate;
    //外键，关联 users 表
    private int userId;
    //用户信息，一对一的关系，该属性在数据库表中并没有
    private User user;

    public Address() {
    }

    //如果使用 constructor 元素映射有参构造方法，则参数的类型，需要写为封装的类型，否则会报错
    public Address(Integer id, String contact, String addressDesc) {
        this.id = id;
        this.contact = contact;
        this.addressDesc = addressDesc;
    }

    public Address(int id, String contact, String addressDesc, String postCode, String tel, String createBy, Date creationDate, int modifyBy, Date modifyDate, int userId) {
        this.id = id;
        this.contact = contact;
        this.addressDesc = addressDesc;
        this.postCode = postCode;
        this.tel = tel;
        this.createdBy = createBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddressDesc() {
        return addressDesc;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createBy) {
        this.createdBy = createBy;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;

    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", addressDesc='" + addressDesc + '\'' +
                ", postCode='" + postCode + '\'' +
                ", tel='" + tel + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }


}

