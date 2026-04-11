public class InsertSort {
	public static void main(String[] args){
		int[] a={2,5,8,3,1,4,6,7,10,9};
		int[] b=new int[10];
		int i,idx,j,jdx,key,keydx,n,ndx;
		key=1;
		for(i=1;i<=a.length;i++){
			idx=i-1;
			for(j=i-1;j>=1;j--){
				jdx=j-1;
				key=1;
				if( b[jdx]<=a[idx] ){ 
					key=j+1;
					break;
				}
			}
			keydx=key-1;
			for(n=i;n>key;n--){
				ndx=n-1;
				b[ndx]=b[ndx-1];
			}
			b[keydx]=a[idx];
		}
	}
}
