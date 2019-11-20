给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。

如果符合下列情况之一，则数组 A 就是 锯齿数组：

每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
返回将数组 nums 转换为锯齿数组所需的最小操作次数。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decrease-elements-to-make-array-zigzag
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.length;i+=2){
            if(i==0){
                if(nums[0]>=nums[1]){
                     count1+=(nums[0]-nums[1]+1);
                }    
            }else if(i==nums.length-1&&(nums.length%2!=0)){
                if(nums[i]>=nums[i-1]){
                    count1+=(nums[i]-nums[i-1]+1);
                }
            }else{
                if(nums[i]>=nums[i-1]||nums[i]>=nums[i+1]){
                    count1+=nums[i]-Math.min(nums[i-1],nums[i+1])+1;
                }

            }
            
        }
         for(int i=1;i<nums.length;i+=2){
           if(i==nums.length-1&&(nums.length%2==0)){
                if(nums[i]>=nums[i-1]){
                    count2+=(nums[i]-nums[i-1]+1);
                }
            }else{
                if(nums[i]>=nums[i-1]||nums[i]>=nums[i+1]){
                    count2+=nums[i]-Math.min(nums[i-1],nums[i+1])+1;
                }
            }
            
        }
        return Math.min(count1,count2);
    }
}

