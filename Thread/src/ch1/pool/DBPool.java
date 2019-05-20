package ch1.pool;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @ClassName DBPool
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 12:45
 * @Version 1.0
 */
public class DBPool {
    private  static LinkedList<Connection>  pool=new LinkedList<Connection>();

    public DBPool(int initSize) {
        if(initSize>0){
            for(int i=0;i<initSize;i++){
                pool.addLast(SqlConnectionImpl.fetchConnection());
            }
        }
    }
    public Connection fetchConn(long mills) throws InterruptedException {
        synchronized (pool){
            if(mills<0){
                while(pool.isEmpty()){
                    pool.wait();
                }
            }else{
                long overTime=System.currentTimeMillis()+mills;
                long remain=mills;
                while(pool.isEmpty()&&remain>0){
                    pool.wait(remain);
                    remain=overTime-System.currentTimeMillis();
                }
                Connection result=null;
                if(!pool.isEmpty()){
                    result=pool.removeFirst();
                }
                return result;
            }
        }
        return null;
    }
    public void relaseConn(Connection conn){
        if(conn!=null){
            synchronized (pool){
                pool.addLast(conn);
                pool.notifyAll();
            }
        }
    }
}
