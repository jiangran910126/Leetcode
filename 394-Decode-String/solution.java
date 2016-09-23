public class Solution {
    public String decodeString(String s) {
        if(s.length()==0) return "";
        Stack<Integer> count=new Stack<>();
        Stack<String> res=new Stack<>();
        res.push("");
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                int num=s.charAt(i)-'0';
                while(i+1<s.length()&&s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'){
                    num=num*10+s.charAt(i+1)-'0';
                    i++;
                }
                count.push(num);
            }
            else if(s.charAt(i)=='['){
                res.push("");
            }
            else if(s.charAt(i)==']'){
                StringBuilder sb=new StringBuilder();
                int time=count.pop();
                String tmp=res.pop();
                for(int j=0;j<time;j++)
                    sb.append(tmp);
                res.push(res.pop()+sb.toString());
            }
            else res.push(res.pop()+s.charAt(i));
            i++;
        }
        return res.peek();
    }
}