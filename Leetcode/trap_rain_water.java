import java.util.Stack;

public class trap_rain_water {
    public int trap(int[] height) {
        Stack stack = new Stack();
        stack.push(height[0]);
        int sum = 0;

        for (int i = 1; i < height.length; i++) {
            int begin = height[i];
            while (i < height.length - 1 && (height[i + 1] < begin || height[i + 1] < stack.top())) {
                stack.push(i);
                i++;
            }
            int max = begin > stack.top() ? begin : stack.top();

            while (!stack.empty()) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = new int[10];
    }
}