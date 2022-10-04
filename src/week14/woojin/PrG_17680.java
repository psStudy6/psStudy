package week14.woojin;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PrG_17680 {
    static HashMap<String, Integer> map = new HashMap<>();

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0) {
            answer = 5 * cities.length;
            return answer;
        }
        for (String city : cities) {
            // cache에 아무것도 없으면 추가
            if(map.isEmpty()) {
                answer += 5;
                map.put(city.toUpperCase(Locale.ROOT), 10);
            } else {
                // 캐쉬에 존재하면 사용했으므로 값 증가
                if(map.containsKey(city.toUpperCase(Locale.ROOT))){
                    answer += 1;
                    map.replaceAll((k, v) -> map.get(k) - 1);
                    map.put(city.toUpperCase(Locale.ROOT), 10);
                } else {
                    answer += 5;
                    // 캐쉬 용량 초과 시
                    if(map.size() >= cacheSize) {
                        // 가장 덜 사용한 data 제거
                        map.remove(getLRUKey());
                    }
                    map.replaceAll((k, v) -> map.get(k) - 1);
                    map.put(city.toUpperCase(Locale.ROOT), 10);
                }
            }
        }
        return answer;
    }

    public static String getLRUKey() {
        String minKey = null;
        int minValue = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if(minValue == Integer.MAX_VALUE){
                minKey = stringIntegerEntry.getKey();
                minValue = stringIntegerEntry.getValue();
            }
            if(minValue > stringIntegerEntry.getValue()) {
                minKey = stringIntegerEntry.getKey();
                minValue = stringIntegerEntry.getValue();
            }
        }
        return minKey;
    }
}
