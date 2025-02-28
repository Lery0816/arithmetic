

public class App {
    public static void main(String[] args) throws Exception {
        //int[] a={3,3,3,4,3,4,2,2,2,5,6,6,6,6};
        
        int[] b={3,3,3,1,1,1,9,9,4,4,4,5,5,5};
        Node head=new Node(b[0]);
        Node last=head;
        for (int i = 1; i < b.length; i++) {
            last.next=new Node(b[i]);
            last=last.next;
        }
        //int[] arr = test1(a);
        //System.out.println("["+arr[0]+","+arr[1]+"]" );
        Node n = test3(head,3);
        while (n!=null) {
            System.out.println(n.value);
            n=n.next;
        }
        
    }

    public static int[] test1(int[] arr){
        int a=0;
        for(int i:arr){
            a^=i;
        }
        int rightone=a&(-a);
        int b=0;
        for (int i : arr) {
            if ((i&rightone)!=0) {
                b^=i;
            }
        }
        return new int[]{a^b,b};
    }
    public static int test2(int[] arr,int n,int m){
        int[] a=new int[32];
        for (int i : arr) {
            for (int j = 0; j <32; j++) {
                a[j]+=((i>>j)&1);
            }
        }
        int ans=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]%m!=0) {
                ans|=(1<<i);
            }
        }
        return ans;
    }

    public static Node test3(Node head,int num){
        while (head!=null) {
            if (head.value!=num) {
                break;
            }
            head=head.next;
        }
        Node last=head;
        Node cur=head.next;
        while (cur!=null) {
            if (cur.value==num) {
                cur=cur.next;
            }else{
                last.next=cur;
                last=last.next;
                cur=cur.next;
            }
        }
        last.next=null;
        return head;

    }
    static class Node{
        int value;
        Node next=null;
        public Node(int value) {
            this.value = value;
        }
        public Node(Node next){
            this.next=next;
        }
    }
}
