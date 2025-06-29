package week_11;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_6588_골드바흐의추축_이상훈 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[1000001];
        arr[1] = 1;

        for(int i=2; i<1000001; i++){
            if(arr[i]==0){
                for(int j=i+i; j<1000001; j+=i){
                    arr[j]=1;
                }
            }
        }

        while (true){
            int n = Integer.parseInt(br.readLine());
            if(n==0)
                return;
            boolean flag = false;
            for(int i=2; i<=n/2; i++){
                if(arr[i]==0 && arr[n-i]==0){
                    System.out.println(n + " = " + i + " + " + (n-i));
                    flag = true;
                    break;
                }
            }

            if(!flag){
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}
