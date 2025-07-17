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
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;

        for(int i : piles) {
            if(max < i) {
                max = i;
            }
        }

        while(min < max) {
            int mid = min + (max - min) / 2;
            int time = 0;

            for (int pile : piles) {
                time += (pile + mid - 1) / mid;
            }

            if(time > h) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
