package assignments.ten;

public class CircleGame {
    public static void main(String[] args) {
        CircleGame game = new CircleGame();
        System.out.println(game.findTheWinner(5, 2) + 1);
    }

    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (findTheWinner(n - 1, k) + k) % n;
    }
}
