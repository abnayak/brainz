public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(array, 1));
        System.out.println(binarySearch(array, 6));
        System.out.println(binarySearch(array, 3));
        System.out.println(binarySearch(array, 4));
    }

    public static int binarySearch(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
