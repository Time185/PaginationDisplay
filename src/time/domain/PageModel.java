package time.domain;

import java.util.List;

public class PageModel {
	private int currentPageNum;  // 存档当前页数
	private int pageSize = 5;   // 每页显示的条数	
	private int totalRecords;  //总记录条数，利用数据库查出来
	private int totalPageNum;  //总记录条数，利用数据库查出来
	private int startIndex;  // 每页开始记录的索引 计算出来
	private int prePageNum;  // 上一页
	private int nextPageNum;  // 下一页
	
	private List records;  // 已经分好页的结果集，该list中只有十条记录
	
	//扩展属性
		//一共每页显示9个页码按钮
	private int startPage;//开始页码
	private int endPage;//结束页码
	
	public PageModel (int currentPageNum,int totalPageRecords, int pageSize) {
		this.currentPageNum = currentPageNum;
		this.totalRecords = totalPageRecords;
		
		// 每页开始的索引
		startIndex = (currentPageNum - 1)*pageSize;
		// 总的页数
		totalPageNum = totalRecords % pageSize == 0 ? (totalRecords / pageSize):(totalRecords % pageSize + 1);
		
		startPage = currentPageNum - 4;
		endPage = currentPageNum + 4;
		// 查看总页数是否够9页
		if(totalPageNum > 9) {
			if(startPage < 1) {
				startPage = 1;
				endPage = startPage + 8;
			}
			if(endPage>totalPageNum){
				endPage = totalPageNum;
				startPage = endPage-8;
			}
		}else {
			// 不够9页
			startPage = 1;
			endPage = totalPageNum;
		}
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPrePageNum() {
		prePageNum = currentPageNum - 1;
		if(prePageNum < 1) {
			prePageNum = 1;
		}
		return prePageNum;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public int getNextPageNum() {
		nextPageNum = currentPageNum + 1;
		if(nextPageNum > totalPageNum) {
			nextPageNum = totalPageNum; 
		}
		return nextPageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public List getRecords() {
		return records;
	}

	public void setRecords(List records) {
		this.records = records;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
	
	
}
