package volatileTest;
class MyData{
	volatile int number=0;
	public void addTo60(){
		this.number=60;
	}
	public void add(){
		number++;
	}
}
public class volatileDemo {
	public static void main(String[] args) {
		//seekOkByVolatile();
		MyData data=new MyData();
		for(int i=0;i<20;i++){
			new Thread(()->{
				for(int j=0;j<100;j++){
					data.add();
				}
			}).start();;
		}
		while(Thread.activeCount()>2){
			Thread.yield();
		}
		System.out.println(data.number);
	}
	

	public static void seekOkByVolatile() {
		MyData myData=new MyData();
		
		new Thread(() ->{
			System.out.println(Thread.currentThread().getName()+"\t  come in");
			try {
				Thread.currentThread().sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myData.addTo60();
			System.out.println(Thread.currentThread().getName()+"\t update number:"+myData.number);
		},"AAA").start();
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t come in");
			while(myData.number==0){
				
			}
			System.out.println(Thread.currentThread().getName()+"\t get number:"+myData.number);
		},"BBB").start();
	}
}
