//공유집계판 사례에서 synchronized를 사용하지 않아 충돌로 인해 데이터에 오류가 발생한 경우
//해결 : 실행되는 순서는 컴퓨터에 따라 다르지만 결과적으로 동시에 접근하지 않아 200이라는 숫자 도출
package tptty.example09;

public class SynchronizedEx {

	public static void main(String[] args) {
		SharedBoard board = new SharedBoard();
		Thread th1 = new StudentThread("kitae", board);
		Thread th2 = new StudentThread("hyosoo", board);
		th1.start();
		th2.start();

	}

}

class SharedBoard{
	private int sum=0;
	synchronized public void add() { //10씩 증가시킨 값을 sum에 저장
		int n = sum;
		Thread.yield(); //스레드 양보
		n+=10;
		sum=n;
		System.out.println(Thread.currentThread().getName()+":"+sum);
	}
	public int getSum() {
		return sum;
	}
	
}

class StudentThread extends Thread{
	private SharedBoard board;

	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++)
			board.add();
	}
	
	
}
