package convert.numbers;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;


public class ConvertSuffixes {

    private static final NavigableMap <Long, String> suffixes = new TreeMap<>();

    static{
        suffixes.put(1_000L, "k");
        suffixes.put(1_000_000L, "mln");
        suffixes.put(1_000_000_000L, "bil");
    }

    public static String format(long value){

        if(value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1);
        if(value < 0) return "-" + format(-value);
        if(value < 1000) return Long.toString(value);

        Map.Entry<Long, String> e = suffixes.floorEntry(value);
        Long divideBy = e.getKey();
        String suffix = e.getValue();

        long truncated = value / (divideBy / 100);
        boolean hasDecimal = truncated < 1000 && (truncated / 100d) != (truncated / 100);
        return hasDecimal ? (truncated / 100d) + suffix : (truncated / 100) + suffix;

    }
}
