import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        line(n);
    }
    public static void line(int n) {
        int count = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (count < n) {
                    System.out.print(j + " ");
                    count++;
            }
        }
        }
    }
}
