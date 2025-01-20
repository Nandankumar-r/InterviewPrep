package assignments.seven;

//https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/
public class FindAverageSalary {
    public static void main(String[] args) {
        int[] salaries = {1000,2000,3000};
        System.out.println(average(salaries));
    }
    public static double average(int[] salary) {
        double res = 0.0d;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : salary) {
            if (num > max) {
                max = num;
            } if (num < min) {
                min = num;
            }
            sum += num;
        }
        res = (double) (sum - min - max) / (salary.length - 2);
        return res;
    }
}
