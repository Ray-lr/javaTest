package main;

/**
 * @author lirui
 */
public class UnicodeTest {
    public static void main(String [] args){

        String s = "内蒙古世联商贸有限公司";
        System.out.println(s+" --的unicode编码是："+gbEncoding(s));
        System.out.println(s+" --的unicode编码是："+convert(s));
        System.out.println(gbEncoding(s) + " --转换成中文是："+decodeUnicode(gbEncoding(s)));
    }

    /**
     * 中文转unicode编码
     */
    private static String gbEncoding(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        StringBuilder unicodeBytes = new StringBuilder();
        for (char utfByte : utfBytes) {
            String hexB = Integer.toHexString(utfByte);
            /*if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }*/
            unicodeBytes.append(hexB);
        }
        return unicodeBytes.toString();
    }

    /**
     * 简化版 中文转Unicode(去掉\\u和00)
     */
    private static String convert(String name){
        char[] utfBytes = name.toCharArray();
        StringBuilder unicodeBytes = new StringBuilder();
        for (char utfByte : utfBytes) {
            String hexB = Integer.toHexString(utfByte);
            unicodeBytes.append(hexB);
        }
        return unicodeBytes.toString();
    }

    /**
     * unicode编码转中文
     */
    private static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end;
        final StringBuilder buffer = new StringBuilder();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr;
            if (end == -1) {
                charStr = dataStr.substring(start + 2);
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            // 16进制parse整形字符串。
            char letter = (char) Integer.parseInt(charStr, 16);
            buffer.append(Character.toString(letter));
            start = end;
        }
        return buffer.toString();
    }

}
