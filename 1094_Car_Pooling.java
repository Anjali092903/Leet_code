import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Step 1: Sort trips based on start location (index 1)
        Arrays.sort(trips, (a, b) -> a[1] - b[1]); // increasing order sorting

        // Step 2: Min-Heap (PriorityQueue) to store trips based on end location (index 2)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        int currCapacity = 0;

        // Step 3: Process each trip
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i]; // Corrected variable name
            int currStart = trip[1];

            // Remove completed trips (those whose drop-off location ≤ current pick-up location)
            while (!pq.isEmpty() && currStart >= pq.peek()[2]) {
                int[] finishedTrip = pq.poll();
                currCapacity -= finishedTrip[0]; // Remove passengers
            }

            // Step 4: Add current trip if capacity allows
            if (currCapacity + trip[0] <= capacity) {
                pq.add(trip);
                currCapacity += trip[0];
            } else {
                return false; // Not enough capacity for this trip
            }
        }

        return true; // Successfully accommodated all trips
    }
}







1094. Car Pooling
There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
 

Constraints:

1 <= trips.length <= 1000
trips[i].length == 3
1 <= numPassengersi <= 100
0 <= fromi < toi <= 1000
1 <= capacity <= 105




  
