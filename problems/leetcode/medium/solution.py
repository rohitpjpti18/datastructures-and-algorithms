class Solution:
    ## https://leetcode.com/problems/count-primes/
    def getNextPrime(self, nextPrime, isPrime):
        for i in range(nextPrime+1, len(isPrime)):
            if isPrime[i] == True:
                return i
        return -1
    
    def countPrimes(self, n: int) -> int:
        isPrime = [True for i in range(0, n)]
        nextPrime = 1
        while True:
            nextPrime = self.getNextPrime(nextPrime, isPrime)
            if nextPrime == -1:
                break
            nextMul = nextPrime + nextPrime
            while nextMul<n:
                isPrime[nextMul] = False
                nextMul += nextPrime
                
        
        result = 0
        
        for i in range(2, n):
            if isPrime[i]:
                result += 1
        
        return result

    ## https://leetcode.com/problems/next-permutation/
    def nextPermutation(self, nums: List[int]) -> None:
        n = len(nums)
        swapI1 = -1
        itr = n-2
        while itr >= 0 and nums[itr] >= nums[itr+1]:
            itr -= 1
        
        if itr == -1:
            nums.sort()
            return
        else:
            currentMax = 99999999999999999
            for i in range(n-1, itr, -1):
                if nums[i] < currentMax and nums[i] > nums[itr]:
                    swapI1 = i
                    currentMax = nums[i]
            
            temp = nums[swapI1]
            nums[swapI1] = nums[itr]
            nums[itr] = temp
            sorteda = sorted(nums[itr+1:])
            
            for i in range(itr+1, n):
                nums[i] = sorteda[i-(itr+1)]

    ## https://leetcode.com/problems/compare-version-numbers/
    def compareVersion(self, version1: str, version2: str) -> int:
        version1 = list(map(int, version1.split(".")))
        version2 = list(map(int, version2.split(".")))
        
        for v1, v2 in itertools.zip_longest(version1, version2, 0):
            if v1 == v2:
                continue
            
            return -1 if v1 < v2 else 1
        return 0

    ## https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
    def getMaxLen(self, nums: List[int]) -> int:
        n = len(nums)
        current_pos = 0
        current_neg = 0
        result = 0
        for i in nums:
            if i > 0:
                current_pos, current_neg = current_pos + 1, current_neg + 1 if current_neg != 0 else 0
            elif i < 0:
                current_pos, current_neg = current_neg + 1 if current_neg != 0 else 0, current_pos + 1
            else:
                current_pos = current_neg = 0
            result = max(current_pos, result)
            
        return result

    ## https://leetcode.com/problems/best-sightseeing-pair/
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        n = len(values)
        maxVal = values[0] + 0
        ans = 0

        for j in range(1, n):
            score = maxVal + values[j] - j
            ans = max(score, ans)
            maxVal = max(values[j]+j, maxVal)
        
        return ans
            


if __name__ == '__main__':
    sol = Solution()
    print(sol.countPrimes(10))