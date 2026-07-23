class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
record Car(int position, int speed) {}

        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }

        // Sort cars by position in ascending order
        Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));

        int fleets = 0;
        double maxTime = 0; // Tracks the arrival time of the fleet directly in front

        // Iterate backwards from the car closest to the target
        for (int i = position.length - 1; i >= 0; i--) {
            // Calculate exact time to reach the target as double
            double timeToTarget = (double) (target - cars[i].position) / cars[i].speed;

            // If this car takes LONGER than the fleet ahead, it can't catch up.
            // It forms a new fleet!
            if (timeToTarget > maxTime) {
                fleets++;
                maxTime = timeToTarget; // This car becomes the new fleet leader for cars behind it
            }
        }

        return fleets;
    }
}
