class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        table = defaultdict(int)
        for num in nums:
            table[num] += 1

        heap = list()

        #Create heap and leave exactly k elements in the heap
        for num in table.keys():
            heapq.heappush(heap, (table[num], num))
            if len(heap) > k:
                heapq.heappop(heap)

        res = list()
        for i in range(k):
            res.append(heapq.heappop(heap)[1])

        return res