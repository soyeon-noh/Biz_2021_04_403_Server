package com.callor.todo.service;

import java.util.List;
import java.util.Map;

public interface TodoService {
	
	// 과거엔 vo말고 map으로 많이 했었대. 장단점있으니 둘다 써보자
	public List<Map<String,Object>> selectAll();
	public Map<String,Object> findById(Long seq);
	
	public Integer insert(Map<String,Object> vo);
	public Integer update(Map<String,Object> vo);
	public Integer delete(Long seq);
	
	
}
