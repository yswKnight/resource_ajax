package org.wysheng.resource.dao;



import java.util.List;

public class Page<T> {

	
		public final static int DEFAULT_PAGE_SIZE = 5;
		public final static int DEFAULT_PAGENO = 1;
	
		// ��ǰҳ
		private int pageNo;
		// ÿһҳ��ʾ��¼����
		private int pageSize;
		// �ܼ�¼����
		private long itemTotal;
		// ��ҳ��
		private long pageTotal;
		
		
		public Page(){
			
			this.pageNo = DEFAULT_PAGENO;
			this.pageSize = DEFAULT_PAGE_SIZE;
		}
		
		
		// ��ǰҳ��Ӧ���ݼ���
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

		// �����ܼ�¼����
		public void setItemTotal(long itemTotal) {
			this.itemTotal = itemTotal;
			
			//   ������ҳ��
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
		
		
		// �����һҳ
		public int getPrePage(){
			// page.prePage
			return this.pageNo > 1 ? this.pageNo - 1:this.pageNo;
		}
		
		// �����һҳ
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
