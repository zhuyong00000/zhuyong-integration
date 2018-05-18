package com.zhuyong.test.common.base.util.excel.entity;



import java.io.Serializable;
import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;

/**
 * 通讯录实体 model
 */
public class Contacts implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7980789441314808879L;
	private String id;
    // 电话号码(主键)
    @Excel(name = "电话号码")
    private String phone;
    // 客户姓名
    @Excel(name = "姓名")
    private String name;
    // 所属分组
    @ExcelEntity
    private ContactsGroup group;
    // 备注
    @Excel(name = "备注")
    private String remark;
    // 生日
    @Excel(name = "出生日期", format = "yyyy-MM-dd", width = 20)
    private Date birthday;
    // 创建人
    private String createBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactsGroup getGroup() {
        return group;
    }

    public void setGroup(ContactsGroup group) {
        this.group = group;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
