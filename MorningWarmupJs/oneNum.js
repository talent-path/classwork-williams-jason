var singleNumber = function(nums) {
    let foundNums = []
    nums.sort();
    let startIndex = 0;
    for(let i=0;i<nums.length-1;i++){
        if(nums[i]===nums[i+1]){
            startIndex = nums[i];
        }
        console.log(startIndex)
    }
    console.log(foundNums)
};