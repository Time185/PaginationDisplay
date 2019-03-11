package time.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import time.domain.Product;
import time.utils.JDBCUtils;

public class ProductDao {

	public int findTotalRecords() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Long num = (Long)qr.query("select count(*) from product", new ScalarHandler());	
		return num.intValue();
	}

	public List findProducts(int startIndex, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from product limit ?,? ";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Product>(Product.class), startIndex,pageSize);
		
	}
	
}
