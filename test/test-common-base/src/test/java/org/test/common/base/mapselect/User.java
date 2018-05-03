package org.test.common.base.mapselect;

import java.io.Serializable;

/**
 * 
 * @author zhuyong
 *
 */
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8580169036285844499L;
	private Integer id;
    private Integer groupId;
    private String name;


    public User(Integer id, Integer groupId, String name) {
        this.id = id;
        this.groupId = groupId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
