public class TemperatureAnalyzer {

    public static void analyzeTemperatures(float[][] temperatures) {
        float[] dailyAverages = new float[temperatures.length];
        int hottestDay = -1;
        int coldestDay = -1;
        float maxAvgTemp = -1000.0f;
        float minAvgTemp = 1000.0f;

        for (int day = 0; day < temperatures.length; day++) {
            float dailySum = 0.0f;
            for (int hour = 0; hour < temperatures[day].length; hour++) {
                dailySum += temperatures[day][hour];
            }
            float dailyAvg = dailySum / temperatures[day].length;
            dailyAverages[day] = dailyAvg;

            if (dailyAvg > maxAvgTemp) {
                maxAvgTemp = dailyAvg;
                hottestDay = day + 1;
            }
            if (dailyAvg < minAvgTemp) {
                minAvgTemp = dailyAvg;
                coldestDay = day + 1;
            }
        }
        System.out.println("Hottest day: Day " + hottestDay + " with an average of " + maxAvgTemp + " degrees.");
        System.out.println("Coldest day: Day " + coldestDay + " with an average of " + minAvgTemp + " degrees.");
        System.out.println("Average temperature per day:");
        for (int i = 0; i < dailyAverages.length; i++) {
            System.out.println("Day " + (i + 1) + ": " + dailyAverages[i] + " degrees");
        }
    }
}
