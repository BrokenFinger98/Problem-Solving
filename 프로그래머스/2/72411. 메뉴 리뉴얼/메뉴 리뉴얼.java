import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < course.length; ++i) {
            int r = course[i];
            Map<String, Integer> map = new HashMap<>();

            for (String order : orders) {
                if (order.length() < r) continue;
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                combination(new String(chars), new StringBuilder(r), 0, -1, r, map);
            }

            int max = 0;
            for (int cnt : map.values()) max = Math.max(max, cnt);
            if (max < 2) continue;

            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue() == max) result.add(e.getKey());
            }
        }

        Collections.sort(result);
        return result.toArray(new String[result.size()]);
    }

    public void combination(String order, StringBuilder sb, int depth, int start, int n,
                            Map<String, Integer> map) {
        if (depth == n) {
            String str = sb.toString();
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
        for (int i = start + 1; i < order.length(); ++i) {
            sb.append(order.charAt(i));
            combination(order, sb, depth + 1, i, n, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}