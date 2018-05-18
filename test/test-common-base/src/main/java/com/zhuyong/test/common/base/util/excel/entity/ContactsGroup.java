package com.zhuyong.test.common.base.util.excel.entity;


import java.io.Serializable;
import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * 通讯录分组实体
 */
public class ContactsGroup implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4567085445587160760L;

	// 组名
    @Excel(name = "分组")
    private String groupName;

    /**
     * 创建人
     */
    private String createBy;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
