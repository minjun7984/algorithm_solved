import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        //fee 기본시간 기본요금 단위(분) 단위요금
        //시각 차량번호 내
        HashMap<String, String> map = new HashMap<>();
        Map<String, Integer> billMap = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));

        for (int i = 0; i < records.length; i++) {
            String[] s = records[i].split(" ");
            String time = s[0];
            String carNum = s[1];
            String state = s[2];

            if (state.equals("IN")) {
                map.put(carNum, time);
                continue;
            }

            //들어온 차량이 처음 나갈경우 해당 차량의 요금 발행
            //이전에 들어온 차량이 다시 들어와서 나가는 경우에는 이전 요금에 합산한다.
            if (!billMap.containsKey(carNum)) {
                billMap.put(carNum, countTime(map, carNum, time));
                map.remove(carNum);
            } else {
                billMap.put(carNum, billMap.get(carNum) + countTime(map, carNum, time));
                map.remove(carNum);
            }
        }
        if (!map.isEmpty()) {
            for (String carNum : map.keySet()) {
                if (billMap.containsKey(carNum)) {
                    billMap.put(carNum, billMap.get(carNum) + countTime(map, carNum, "23:59"));
                } else {
                    billMap.put(carNum, countTime(map, carNum, "23:59"));
                }
            }
        }

        return charge(billMap, fees);
    }

    //요금 부과 메서드
    private int[] charge(Map<String, Integer> billMap, int[] fees) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (String carNum : billMap.keySet()) {
            int minute = billMap.get(carNum);
            int fee = 0;

            //기본요금
            if (minute <= fees[0]) {
                fee += fees[1];
            } else {
                fee += (((int) Math.ceil(((double) minute - fees[0]) / fees[2])) * fees[3]) + fees[1];
            }
            arr.add(fee);
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

    //총 누적시간 계산
    private int countTime(HashMap<String, String> map, String carNum, String time) {
        int inTime = changeTime(map.get(carNum));
        int outTime = changeTime(time);
        return outTime - inTime;
    }

    //시간을 변환해주는 메서드
    private static int changeTime(String time) {
        String[] s = time.split(":");
        return (Integer.parseInt(s[0]) * 60) + Integer.parseInt(s[1]);
    }
}