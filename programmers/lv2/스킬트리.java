class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer =0;

        for(int i=0; i<skill_trees.length;i++){
            int skiIdx=0;
            boolean flag = true;

            for(int j=0; j<skill_trees[i].length();j++){
                for(int k=skiIdx; k<skill.length();k++){
                    if(skill.charAt(k)==skill_trees[i].charAt(j)){
                        if(k!=skiIdx) flag=false;
                        else{
                            skiIdx++;
                        }
                    }
                }
            }
            if(flag)
                answer++;
        }
        return answer;
    }
}