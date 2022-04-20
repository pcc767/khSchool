package com.kh.practice.token.controller;

import java.util.StringTokenizer;

public class TokenController {
	
	public TokenController() {}

    public String afterToken(String str){
    	
    	StringTokenizer token = new StringTokenizer(str," ");
    	StringBuilder sb = new StringBuilder();
    	while(token.hasMoreTokens()) {
    		String temp = token.nextToken();
    		sb.append(temp);
    	}
    	return sb.toString();
    	
//        String result = str.replaceAll(" ","");
//        return result;
    }

    public String firstCap(String input){
        String str = input.substring(0,1).toUpperCase()+input.substring(1);
//        char chr = input.toUpperCase().charAt(0);
        return str;
    }

    public int findChar(String input, char one) {
        int count = 0;
        int startIndex = 0;

        while (true){
            int result = input.indexOf(one,startIndex);
            if(result < 0){
                break;
            }
            count++;
            startIndex = result+1;
        }
        return count;

    }

}
