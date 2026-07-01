/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0) return 0;
        // Sort the intervals by starting time
        // Iterate through the list
        // Put each interval into a heap that prioritize minimum end time
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        minHeap.offer(intervals.get(0).end);

        int res = 1;

        for (int i = 1; i < n; i++) {
            int earliestAvalTime = minHeap.peek();
            if (intervals.get(i).start < earliestAvalTime) {
                minHeap.offer(intervals.get(i).end);
                res += 1;
            } else {
                minHeap.poll();
                minHeap.offer(intervals.get(i).end);
            }
        }

        return res;
    }
}
