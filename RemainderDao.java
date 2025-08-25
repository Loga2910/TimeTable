package com.example.RemainderSystem;

import java.util.List;

public interface RemainderDao {
	public int save(RemainderEntity r);
	public List<RemainderEntity> findall();
	public RemainderEntity findById(int id);
	public int updateById(RemainderEntity r,int id);
	public int deleteById(int id);
}
