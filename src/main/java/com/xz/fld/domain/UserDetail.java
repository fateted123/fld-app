package com.xz.fld.domain;

public class UserDetail {
    private String userId;

    private Integer age;

    private String name;

    private String kittyname;

    private String gender;

    private String username;

    private String identityId;

    private Byte identityType;

    private String myInvitId;

    private Integer myInvitNum;

    private String headPicture;

    private String memberNo;

    private String memberClass;

    private String phone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getKittyname() {
        return kittyname;
    }

    public void setKittyname(String kittyname) {
        this.kittyname = kittyname == null ? null : kittyname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId == null ? null : identityId.trim();
    }

    public Byte getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Byte identityType) {
        this.identityType = identityType;
    }

    public String getMyInvitId() {
        return myInvitId;
    }

    public void setMyInvitId(String myInvitId) {
        this.myInvitId = myInvitId == null ? null : myInvitId.trim();
    }

    public Integer getMyInvitNum() {
        return myInvitNum;
    }

    public void setMyInvitNum(Integer myInvitNum) {
        this.myInvitNum = myInvitNum;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture == null ? null : headPicture.trim();
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    public String getMemberClass() {
        return memberClass;
    }

    public void setMemberClass(String memberClass) {
        this.memberClass = memberClass == null ? null : memberClass.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}