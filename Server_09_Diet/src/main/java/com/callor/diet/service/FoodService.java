package com.callor.diet.service;

import java.util.List;

import com.callor.diet.model.FoodDTO;
import com.callor.diet.model.FoodVO;

public interface FoodService {

	// CRUD를 구현한 method 정의(설계)
	
	// 데이터 조회(읽기)
	public List<FoodDTO> selectAll(); 	// 전체를 조회
	public FoodDTO findById(String fd_code); 	// PK를 이용한 조회
	
	public List<FoodDTO> findByFName(String fd_name); 	// 식품명을 이용한 조회
	
	// 데이터 변환(추가, 수정, 삭제)
	public Integer insert(FoodVO foodVO);
	public Integer update(FoodVO foodVO);
	public Integer delete(String fd_code);
	
}
