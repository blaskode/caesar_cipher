
import java.util.regex.Pattern;
import java.lang.StringBuilder;
/**
 * Write a description of class WordPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordPlay
{
    public static boolean isVowel(char ch){
        String s = "" + ch;
        boolean b = Pattern.matches("[aeiouAEIOU]", s);
        return b;
    }
    
    public static String replaceVowels(String phrase, char ch){
        String s = "" + ch;
        String str = phrase.replaceAll("[aeiouAEIOU]", s);
        return str;
    }
    
    public static String emphasize(String phrase, char ch){
        var sb = new StringBuilder();
        for(int i = 0; i < phrase.length(); i++){
            if( (phrase.charAt(i) == ch) && (i % 2 == 0) ) {
                sb.append('*');
            }else if( (phrase.charAt(i) == ch) && (i % 2 != 0) ) {
                sb.append('+');
            }else{
                sb.append(phrase.charAt(i));
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
    public static String alphaShiftRight(int shift, String alphabet){
        //String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted = alphabet.substring(shift) + alphabet.substring(0, shift);
        //System.out.println(alphabet);
        //System.out.println(shifted);
        return shifted;
    }
    
    public static String alphaShiftLeft(int shift, String alphabet){
        //String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted = alphabet.substring(alphabet.length() - (shift)) 
            + alphabet.substring(0, alphabet.length() - (shift));
        //System.out.println(alphabet);
        //System.out.println(shifted);
        return shifted;
    }
    
    public static String encode(int shift, String msg) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cipher;
        if( shift < 0){
            shift = 0 - shift;
            cipher = alphaShiftLeft(shift, alpha);
        } else {
            cipher = alphaShiftRight(shift, alpha);
        }
        
        var sb = new StringBuilder();
        for (int i = 0; i < msg.length(); i++){
            char c = msg.charAt(i);
            if(Character.isLowerCase(c)){
                c = Character.toUpperCase(c);
                int pos = alpha.indexOf(c);
                char out_char = cipher.charAt(pos);
                sb.append(Character.toLowerCase(out_char));
            } else if(Character.isUpperCase(c)){
                int pos = alpha.indexOf(c);
                char out_char = cipher.charAt(pos);
                sb.append(out_char);
            } else {
                sb.append(c);
            }
        }
        //System.out.println(sb);
        return sb.toString();
    }
 
    public static String double_encode(int key1, int key2, String msg){
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cipher1 = alphaShiftRight(key1, alpha);
        String cipher2 = alphaShiftRight(key2, alpha);
        var sb = new StringBuilder();
        boolean isKey1 = true;
   
        String cipher;
        for (int i = 0; i < msg.length(); i++){
            if(isKey1) {
                cipher = cipher1;
            } else {
                cipher = cipher2;
            }
            char c = msg.charAt(i);
            if(Character.isLowerCase(c)){
                c = Character.toUpperCase(c);
                int pos = alpha.indexOf(c);
                char out_char = cipher.charAt(pos);
                sb.append(Character.toLowerCase(out_char));
            } else if(Character.isUpperCase(c)){
                int pos = alpha.indexOf(c);
                char out_char = cipher.charAt(pos);
                sb.append(out_char);
            } else {
                sb.append(c);
            }
        
            if (isKey1) {
                isKey1 = false;
            } else {
                isKey1 = true;
            }
            
    }
        //System.out.println(sb.toString());
        return sb.toString();
}
    
}
