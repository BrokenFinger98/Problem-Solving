import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        List<Integer> crew = new ArrayList<>();
        for (String time : timetable) {
            crew.add(changeToInteger(time));
        }

        Collections.sort(crew);

        int shuttleTime = 540;
        int crewIndex = 0;
        int lastTime = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            while (crewIndex < crew.size() && crew.get(crewIndex) <= shuttleTime && count < m) {
                count++;
                lastTime = crew.get(crewIndex);
                crewIndex++;
            }

            if (i == n - 1) {
                if (count < m) {
                    return changeToString(shuttleTime);
                } else {
                    return changeToString(lastTime - 1);
                }
            }

            shuttleTime += t;
        }

        return "";
    }

    public int changeToInteger(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        return hour * 60 + minute;
    }

    public String changeToString(int time) {
        int hour = time / 60;
        int minute = time % 60;
        return String.format("%02d:%02d", hour, minute);
    }
}