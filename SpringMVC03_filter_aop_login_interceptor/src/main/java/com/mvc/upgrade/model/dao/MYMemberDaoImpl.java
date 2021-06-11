package com.mvc.upgrade.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MYMemberDto;

@Repository  //Dao면 repository
public class MYMemberDaoImpl implements MYMemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/*
	  @Autowired
		private SqlSessionTemplate sqlSession;
	 applicationContext에 db.properties에 있는 값을 가져와 그 값을 가지고 data source를 만들어서 그
	  만들어진 소스로 sqlSessionfactory를 만들었다.
	  스프링 빈 컨피그레이션엑스엠엘파일에 객체가 만들어져있으니 sql세션 템플릿 가져와서 오토와이어드로 값을 넣어주면된다
	 */
	
	@Override
	public MYMemberDto login(MYMemberDto dto) {
		
		MYMemberDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+ "login", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int insertMember(MYMemberDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insertMember", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
