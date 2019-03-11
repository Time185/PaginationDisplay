package time.service;

import java.sql.SQLException;
import java.util.List;

import time.dao.ProductDao;
import time.domain.PageModel;

public class ProductService {
	
	// 查询当前页数据功能
	public PageModel findProducts(int curNum) throws SQLException {
		ProductDao dao = new ProductDao();
		int totalRecords = dao.findTotalRecords();
		System.out.println(totalRecords);
		PageModel pm = new PageModel(curNum ,totalRecords,5);
		System.out.println(pm.getStartIndex());
		// 查询数据库，获取当前页面的内容
		List list = dao.findProducts(pm.getStartIndex(),pm.getPageSize());
		for (Object object : list) {
			System.out.println(object);
		}
		pm.setRecords(list);
		return pm;
		
	}
	
}
