package org.test.common.base.mapselect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.zhuyong.test.common.base.util.JSONUtils;

public class TestMap {
	
	
	public static void main(String[] args) {
		List<User> userList=new ArrayList<>();
        userList.add(new User(1,1,"张三"));
        userList.add(new User(2,1,"张四"));
        userList.add(new User(3,1,"张五"));
        userList.add(new User(4,2,"李四"));
        userList.add(new User(5,2,"李五"));
        userList.add(new User(6,3,"赵六"));
        userList.add(new User(7,3,"赵七"));
        transfer(userList);
	}
	
	// Map 的分拣思想
	public static HashMap<Integer, List<User>> transfer(List<User> list) {
		HashMap<Integer, List<User>> infoMap = new HashMap<>();
		for (User user : list) {
			// 判断Map 是否含有此 Key
			if (!infoMap.containsKey(user.getGroupId())) {
				List<User> userList = new ArrayList<>();
				// 创建 Map 容器
				infoMap.put(user.getGroupId(), userList);
			}
		}
		// 使用
		for (User user : list) {
			List<User> list2 = infoMap.get(user.getGroupId());
			list2.add(user);
		}
		System.out.println(JSONUtils.converterToString(infoMap));
		return infoMap;
	}
}
