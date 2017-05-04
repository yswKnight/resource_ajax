package org.wysheng.resource.service;

import java.util.List;

import org.wysheng.resource.domain.Apply;
import org.wysheng.resource.domain.StorageSpaceApply;

public interface StorageSpaceService {

	//查全部
	public List<StorageSpaceApply> findSpaceAll();
	
	//删除
	public void deleteSpace(Integer id);
	
	//添加
	public void Save(StorageSpaceApply space,Apply apply);
	
	//修改
}
