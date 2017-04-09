/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/tiny-url
@Language: Java
@Datetime: 16-08-21 05:29
*/

public class TinyUrl {
    /**
     * @param url a long url
     * @return a short url
     */
    private int sequentialID;
    private HashMap<String, Integer> lti;
    private HashMap<Integer, String> itl;
    
    public TinyUrl(){
        sequentialID = 0;
        lti = new HashMap<String, Integer>();
        itl = new HashMap<Integer, String>();
    }
    
    private String IDToShort(int i){
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s = "";
        
        while(i != 0){
            s=chars.charAt(i%62)+s;
            i/=62;
        }
        
        while(s.length() < 6){
            s="0"+s;
        }
        
        s="http://tiny.url/"+s;
        
        return s;
    }
    
    private int toBase62(char c){
        if(c >= '0' && c <= '9'){
            return c - '0';
        }
        else if(c >= 'a' && c <= 'z'){
            return c - 'a' + 10;
        }
        else{
            return c - 'A' + 36;
        }
    }
    
    private int shortToID(String s){
        s = s.substring("http://tiny.url/".length());
        
        int id = 0;
        for(int i=0; i<s.length(); i++){
            id = id * 62 + toBase62(s.charAt(i));
        }
        return id;
    }
    
    public String longToShort(String url) {
        if(lti.containsKey(url)){
            return IDToShort(lti.get(url));
        }
        
        sequentialID++;
        lti.put(url,sequentialID);
        itl.put(sequentialID,url);
        
        return IDToShort(sequentialID);
    }

    public String shortToLong(String url) {
        return itl.get(shortToID(url));
    }
}