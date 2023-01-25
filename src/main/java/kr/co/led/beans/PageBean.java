package kr.co.led.beans;


public class PageBean {
	
	// �ּ� ������ ��ȣ
		private int min;
		// �ִ� ������ ��ȣ
		private int max;
		// ���� ��ư�� ������ ��ȣ
		private int prevPage;
		// ���� ��ư�� ������ ��ȣ
		private int nextPage;
		// ��ü ������ ���� > �����ͺ��̽����� select������ ������;��� 
		private int pageCnt; 	
		// ���� ������ ��ȣ(��ġ)
		private int currentPage;
		
		
		public PageBean(int NoticeCnt, int currentPage, int noticePageCnt, int paginationCnt) {
			
			this.currentPage=currentPage;
			
			pageCnt=NoticeCnt/noticePageCnt;
			
			if(NoticeCnt%noticePageCnt > 0) {
				pageCnt++;
			}
			
			
			min = ((currentPage-1)/noticePageCnt)*noticePageCnt+1;
			max = min+paginationCnt-1;
			
			if(max > pageCnt) {
				max=pageCnt;
			}
			
			prevPage=min-1;
			nextPage=max+1;
			
			if(nextPage >pageCnt) {
				nextPage=pageCnt;
			}
			
		}
		
		
		
		
		public int getMin() {
			return min;
		}
		public int getMax() {
			return max;
		}
		public int getPrevPage() {
			return prevPage;
		}
		public int getNextPage() {
			return nextPage;
		}
		public int getPageCnt() {
			return pageCnt;
		}
		public int getCurrentPage() {
			return currentPage;
		}
		
		
		
		
}
