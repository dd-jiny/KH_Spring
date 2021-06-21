package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.MYBoardDao;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Service
public class MYBoardBizImpl implements MYBoardBiz {

	@Autowired
	private MYBoardDao dao;
	
	@Override
	public List<MYBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MYBoardDto selectOne(int myno) {
		return dao.selectOne(myno);
	}

	@Override
	public int insert(MYBoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MYBoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		return dao.delete(myno);
	}
	//@Transactional
	@Override
	public String test() {
		//두가지 기능을 한 세트로 쓴다 -> 둘 중 하나가 실패하면 모두 되돌린다 
		//여러개의 쿼리를 하나의 작업으로 퉁치겠다는 의미 -> 은행작업 같은거 ! 
		//트랜잭션 어노테이션을 삭제하면 test가 실패하더라도 insert는 성공해서 반영된다 
		dao.insert(new MYBoardDto(0,"test","tracnsaction test","transaction 이 뭐였는지??",null));
		
		String test = dao.test();
		test.length();
		return test;
	}

}
