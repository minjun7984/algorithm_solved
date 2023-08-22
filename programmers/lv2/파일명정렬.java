import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] file1 = detach(o1);
                String[] file2 = detach(o2);

                int head = file1[0].compareTo(file2[0]);
                if (head == 0) {
                    int num1 = Integer.parseInt(file1[1]);
                    int num2 = Integer.parseInt(file2[1]);
                    return num1 - num2;
                } else {
                    return head;
                }
            }
        });
        return files;
    }

    private String[] detach(String str) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder tail = new StringBuilder();

        int idx = 0;
        for (; idx < str.length(); ++idx) {
            char ch = str.charAt(idx);
            if (ch >= '0' && ch <= '9') break;
            head.append(ch);
        }

        for (; idx < str.length(); ++idx) {
            char ch = str.charAt(idx);
            if (!(ch >= '0' && ch <= '9')) break;
            number.append(ch);
        }

        for (; idx < str.length(); ++idx) {
            char ch = str.charAt(idx);
            tail.append(ch);
        }

        String[] file = {head.toString().toLowerCase(), number.toString(), tail.toString()};

        return file;
    }
}