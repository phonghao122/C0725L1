package ss2.servicers;

public class MergeArray {
    public static void main(String args[]) {
        int[] a = {1,2,3,4,5};
        int[] b = {6,7,8,9,10};
        int[] n = new int[a.length+b.length];
        for(int i=0;i<a.length;i++){
            n[i]=a[i];
        }
        for(int i=0;i<b.length;i++){
            n[i+a.length]=b[i];
        }
        for (int i = 0; i<n.length;i++){
            System.out.print(n[i] + "\t");
        }
    }
}
