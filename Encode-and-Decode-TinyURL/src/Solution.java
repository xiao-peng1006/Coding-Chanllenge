import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Encodes a URL to a shortened URL.
    String codec = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    Map<String, String> map = new HashMap<>();
    String shortUrlhead = "http://tinyurl.com/";

    public String encode(String longUrl) {
        int size = map.size();
        StringBuilder sb = new StringBuilder(shortUrlhead);
        while (size > 0) {
            sb.append(codec.charAt(size % codec.length()));
            size = size/codec.length();
        }
        String str = sb.toString();
        map.put(str, longUrl);
        return str;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));