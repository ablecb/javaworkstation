package Array;

public class TestBinarySearch {
	public static void main(String[] args) {
		int[] arr=new int[] {1,2};
		int begin=0,end=arr.length-1,mid=(begin+end)/2;int target=1;		
		int index=-1;
		while(begin + 1 < end)
		{
			mid = begin + (end - begin) / 2;
			if(arr[mid] == target)
			{
				index = mid;
			}
			else if(arr[mid] < target)
			{
				begin = mid;
			}
			else
			{
				end = mid;
			}
		}
		if(arr[begin] == target)
			index = begin;
		if(arr[end] == target)
			index = end;
		System.out.println("index:"+index);
	}
}
