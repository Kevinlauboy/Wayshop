package com.waybond.wayshop.dao;

import java.util.List;

import com.waybond.wayshop.entity.Area;


/**
* @desc: 区域Dao层
* @author: Kevin
* @createTime: 2019年11月14日 上午10:31:14
* @history:
* @version: v1.0
*/

public interface AreaDao {
	/**
	* 查询区域
	* @param
	* @return List<Area>
	*/
	List<Area> queryArea();
	
	/**
	 * 插入区域
	 * @param area
	 * @return
	 */
	int insertArea(Area area);
	
	
	/**
	 * 更新区域
	 * @param area
	 * @return
	 */
	int updateArea(Area area);
	
	/**
	 * 删除区域
	 * @param areaId
	 * @return
	 */
	int deleteArea(long areaId);

	/**
	 * 删除多区域
	 * @param areaIdList
	 * @return
	 */
	int batchDeleteArea(List<Long> areaIdList);
	
}
