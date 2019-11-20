在一个长度无限的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该
石子被称作端点石子。每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石
子不再是一颗端点石子。值得注意的是，如果石子像 stones = [1,2,5] 这样，你将无法移动位于位
置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3），该石子都仍然会是端点石子。

当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。

要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：
answer = [minimum_moves, maximum_moves] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/moving-stones-until-consecutive-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int len=stones.length;
        int sum=stones[len-1]-stones[0]+1-len;
        int max=sum-Math.min(stones[len-1]-stones[len-2]-1,stones[1]-stones[0]-1);
        int min=max;
        int start=0;
        for(int end=0;end<len;end++){
            while(stones[end]-stones[start]+1>len){
                start++;
            }
            min=Math.min(min,len-(end-start+1));
            if(end-start+1==len-1&&stones[end]-stones[start]+1==len-1){
                min=2;
            }
        }
        return new int[] {min,max};
    }
}

今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）
会进入书店，所有这些顾客都会在那一分钟结束后离开。在某些时候，书店老板会生气。 如果书店
老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分
钟的顾客就会不满意，不生气则他们是满意的。书店老板知道一个秘密技巧，能抑制自己的情绪，
可以让自己连续 X 分钟不生气，但却只能使用一次。请你返回这一天营业下来，最多有多少客户能
够感到满意的数量。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
法一：
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int max=0;
        for(int j=0;j+X<=customers.length;j++){
            int i=j;
            int sum=0;
            i--;
            while(i>=0){
                sum+=customers[i]*(1^grumpy[i]);  
                 i--; 
            }
            i=j;
            int tmp=j+X;
            while(i<customers.length&&i<tmp){
                sum+=customers[i];
                i++;
            }
            while(i<customers.length){
                 sum+=customers[i]*(1^grumpy[i]);  
                 i++; 
            }
            max=Math.max(max,sum);
        }
        return max;
    }
}
法二：
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum1=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                sum1+=customers[i];
                customers[i]=0;
            }
        }
        int l=0;
        int sum2=0;
        int max=0;
        for(int i=0;i<customers.length;i++){
            if(i<X){
                sum2+=customers[i];
            }else{
                sum2+=customers[i]-customers[i-X];
            }
            max=Math.max(max,sum2);
        }
        return max+sum1;
    }
}

给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 
j - i。

找出 A 中的坡的最大宽度，如果不存在，返回 0 。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-width-ramp
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxWidthRamp(int[] A) {
         int maxramp=0;
         int width=0;
         for(int i=0;i<A.length-1;i++){
             for(int j=A.length-1;j>i;j--){
                 if(A[i]<=A[j]){
                     width=j-i;
                     break;
                 }
                 if(width==A.length){
                     break;
                 }
             }
             maxramp=Math.max(maxramp,width);
         }
         return maxramp;
    }
}