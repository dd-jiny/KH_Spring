package com.mvc.update.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.update.model.dto.JDBCDto;

@Repository // 아래에서 나오는 예외를 dataAccessException으로 바꿔준다 근데 아래에서 jdbctemplate가 sqlException으로 처리(더 큰개념) 
public class JDBCDaoImpl implements JDBCDao {

	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	
	
	
	@Override
	public List<JDBCDto> selectList() {
		
		List<JDBCDto> list = new ArrayList<JDBCDto>(); 
		list = jdbcTemplate.query(SELECT_LIST_SQL, null, null, new MyMapper());
		

		/*
		 * List<JDBCDto> list = new ArrayList<JDBCDto>(); list =
		 * jdbcTemplate.query(SELECT_LIST_SQL, (rs, rowNUm) -> { return new
		 * JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
		 * rs.getDate(5));
		 * 
		 * });
		 */
		return list;
	}

	
	
	
	/*
	 * public List<JDBCDto> selectList() { List<JDBCDto> list = new
	 * ArrayList<JDBCDto>(); list = jdbcTemplate.query(SELECT_LIST_SQL, null, null,
	 * new RowMapper<JDBCDto>() {
	 * 
	 * @Override public JDBCDto mapRow(ResultSet rs, int rowNum) throws SQLException
	 * { return new
	 * JDBCDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.
	 * getDate(5)); } }); return list; }
	 */
	
	
	
	
	@Override
	public JDBCDto selectOne(int seq) {
		JDBCDto dto = null; 
		
		dto = jdbcTemplate.queryForObject(SELECT_ONE_SQL,new Object[] {seq},new int[] {Types.INTEGER},new MyMapper());
		
		return dto;
	}

	@Override
	public int insert(JDBCDto dto) {
		
		int res=0; 
		res =jdbcTemplate.update(INSERT_SQL, new Object[] {dto.getWriter(),dto.getTitle(),dto.getContent()});
		return res;
	}

	@Override
	public int update(JDBCDto dto) {
		return 0;
	}

	@Override
	public int delete(int seq) {
		return 0;
	}

	//innerclass
	public static final class MyMapper implements RowMapper<JDBCDto>{

		@Override
		public JDBCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new JDBCDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
		}
		
	}
	
}
