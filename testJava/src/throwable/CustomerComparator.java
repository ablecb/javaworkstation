package throwable;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CustomerComparator implements Comparator<Customer>{
	final int a=0;
	final int b=0;
	public static void main(String[] args) {
		System.out.println("1111111111");
		Object a=new Object();
		Set<Customer>  set=new TreeSet<Customer>(new CustomerComparator());
		Customer customer1=new Customer("Tomer",15);
		Customer customer2=new Customer("Tome",16);
		Customer customer3=new Customer("Tomss",18);
		Customer customer4=new Customer("Tomf",10);
		set.add(customer1);
		set.add(customer2);
		set.add(customer3);
		set.add(customer4);
		System.out.println(set.size());
		Iterator<Customer> iterator=set.iterator();
		while(iterator.hasNext()) {
			Customer customer=iterator.next();
			System.out.println(customer.getString()+"   "+customer.getI());
		}
	}
	@Override
	public int compare(Customer o1, Customer o2) {
		if(o1.getString().compareTo(o2.getString())>0)return 1;
		if(o1.getString().compareTo(o2.getString())<0)return -1;
		return 0;
	}
}
