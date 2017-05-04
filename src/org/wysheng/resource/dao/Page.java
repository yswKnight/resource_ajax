package org.wysheng.resource.dao;



import java.util.List;

public class Page<T> {

	
		public final static int DEFAULT_PAGE_SIZE = 5;
		public final static int DEFAULT_PAGENO = 1;
	
		// 当前页
		private int pageNo;
		// 每一页显示记录条数
		private int pageSize;
		// 总记录条数
		private long itemTotal;
		// 总页数
		private long pageTotal;
		
		
		public Page(){
			
			this.pageNo = DEFAULT_PAGENO;
			this.pageSize = DEFAULT_PAGE_SIZE;
		}
		
		
		// 当前页对应数据集合
		private List<T> result;

		public int getPageNo() {
			return pageNo;
		}

		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public long getItemTotal() {
			return itemTotal;
		}

		// 设置总记录条数
		public void setItemTotal(long itemTotal) {
			this.itemTotal = itemTotal;
			
			//   计算总页数
			if(this.itemTotal % this.pageSize == 0){
				this.pageTotal = this.itemTotal / this.pageSize;
			}else{
				this.pageTotal = (this.itemTotal / this.pageSize) + 1; 
			}
			
		}

		public long getPageTotal() {
			return pageTotal;
		}

		public void setPageTotal(long pageTotal) {
			this.pageTotal = pageTotal;
		}

		public List<T> getResult() {
			return result;
		}

		public void setResult(List<T> result) {
			this.result = result;
		}
		
		
		// 获得上一页
		public int getPrePage(){
			// page.prePage
			return this.pageNo > 1 ? this.pageNo - 1:this.pageNo;
		}
		
		// 获得下一页
		public int getNextPage(){
			
			return this.pageNo >= this.pageTotal? this.pageNo:this.pageNo + 1;
			
		}

		@Override
		public String toString() {
			return "Page [itemTotal=" + itemTotal + ", pageNo=" + pageNo
					+ ", pageSize=" + pageSize + ", pageTotal=" + pageTotal
					+ ", result=" + result + "]";
		}
		
		
		
	
	
	
	
}
