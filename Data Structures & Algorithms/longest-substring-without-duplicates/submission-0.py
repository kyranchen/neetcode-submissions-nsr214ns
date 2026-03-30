class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) <= 1:
            return len(s)

        left = 0
        right = 0
        table = defaultdict(int)
        max_len = 0

        while right < len(s):
            # Increment count of the current character
            table[s[right]] += 1
            
            # If there are duplicates in the current window, move the left pointer
            while table[s[right]] > 1:
                table[s[left]] -= 1
                left += 1
            
            # Update max_len after adjusting the left pointer
            max_len = max(max_len, right - left + 1)
            
            # Move the right pointer to expand the window
            right += 1

        return max_len