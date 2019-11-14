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
	* 
	* @param
	* @return List<Area>
	*/
	List<Area> queryArea();
	
	/**
	 * 
	 * @param area
	 * @return
	 */
	int insertArea(Area area);
	
	
	/**
	 * 
	 * @param area
	 * @return
	 */
	int updateArea(Area area);
	
	/**
	 * 
	 * @param areaId
	 * @return
	 */
	int deleteArea(long areaId);

	/**
	 * 
	 * @param areaIdList
	 * @return
	 */
	int batchDeleteArea(List<Long> areaIdList);
	
}
