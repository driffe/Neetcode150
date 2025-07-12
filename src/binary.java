public class binary {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        return binary(low, high, nums, target);

    }
    public int binary(int low, int high, int[] nums, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] > target) {
                return binary(low, mid-1, nums, target);
            } else if(nums[mid] < target) {
                return binary(mid+1, high, nums, target);
            } else {
                return mid;
            }
        }
        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][matrix[i].length-1] >= target) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    private boolean binarySearch(int[] row, int target) {
        int low = 0;
        int high = row.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(row[mid] == target) {
                return true;
            } else if(row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

}
