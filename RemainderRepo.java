package com.example.RemainderSystem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RemainderRepo implements RemainderDao{
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int save(RemainderEntity r) {
		// TODO Auto-generated method stub
		return jt.update("insert into TimeTable(Title,Start_Date,End_Date,Remainder_Time) values(?,?,?,?)"
				,new Object[] {r.getTitle(),r.getStart_Date(),r.getEnd_Date(),r.getRemainder_Time()});
	}

	@Override
	public List<RemainderEntity> findall() {
		// TODO Auto-generated method stub
		return jt.query("select *from TimeTable", 
				new BeanPropertyRowMapper<RemainderEntity>(RemainderEntity.class));
		}

	@Override
	public RemainderEntity findById(int id) {
		// TODO Auto-generated method stub
		return jt.queryForObject("select *from TimeTable where id=?", 
				new BeanPropertyRowMapper<RemainderEntity>(RemainderEntity.class),id);
	}

	@Override
	public int updateById(RemainderEntity r, int id) {
		// TODO Auto-generated method stub
		return jt.update("update TimeTable set Title=? where id=?",
				new Object[] {r.getTitle(),id});
		
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return jt.update("delete from TimeTable where id=?",id);
	}

	
}
