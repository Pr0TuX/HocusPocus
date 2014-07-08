package com.erep.elucs.util;

import org.pircbotx.Colors;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Util {

    private static final String[] LEVELS = {
            "Recruit",
            "Private",
            "Private*",
            "Private**",
            "Private***",
            "Caporal",
            "Caporal*",
            "Caporal**",
            "Caporal***",
            "Sergeant",
            "Sergeant*",
            "Sergeant**",
            "Sergeant***",
            "Lieutenant",
            "Lieutenant*",
            "Lieutenant**",
            "Lieutenant***",
            "Captain",
            "Captain*",
            "Captain**",
            "Captain***",
            "Major",
            "Major*",
            "Major**",
            "Major***",
            "Commander",
            "Commander*",
            "Commander**",
            "Commander***",
            "Lt Colonel",
            "Lt Colonel*",
            "Lt Colonel**",
            "Lt Colonel***",
            "Colonel",
            "Colonel*",
            "Colonel**",
            "Colonel***",
            "General",
            "General*",
            "General**",
            "General***",
            "Field Mareshal",
            "Field Mareshal*",
            "Field Mareshal**",
            "Field Mareshal***",
            "Supreme Mareshal",
            "Supreme Mareshal*",
            "Supreme Mareshal**",
            "Supreme Mareshal***",
            "National Force",
            "National Force*",
            "National Force**",
            "National Force***",
            "World Class Force",
            "World Class Force*",
            "World Class Force**",
            "World Class Force***",
            "Legendary Force",
            "Legendary Force*",
            "Legendary Force**",
            "Legendary Force***",
            "God of War",
            "God of War*",
            "God of War**",
            "God of War***",
            "Titan",
            "Titan*",
            "Titan**",
            "Titan***",
    };

    private static final Long[] LIMIT = {
            0L,
            15L,
            45L,
            80L,
            120L,
            170L,
            250L,
            350L,
            450L,
            600L,
            800L,
            1000L,
            1400L,
            1850L,
            2350L,
            3000L,
            3750L,
            5000L,
            6500L,
            9000L,
            12000L,
            15500L,
            20000L,
            25000L,
            31000L,
            40000L,
            52000L,
            67000L,
            85000L,
            110000L,
            140000L,
            180000L,
            225000L,
            285000L,
            355000L,
            435000L,
            540000L,
            660000L,
            800000L,
            950000L,
            1140000L,
            1350000L,
            1600000L,
            1875000L,
            2185000L,
            2550000L,
            3000000L,
            3500000L,
            4150000L,
            4900000L,
            5800000L,
            7000000L,
            9000000L,
            11500000L,
            14500000L,
            18000000L,
            22000000L,
            26500000L,
            31500000L,
            37000000L,
            43000000L,
            50000000L,
            100000000L,
            200000000L,
            500000000L,
            1000000000L,
            2000000000L,
            4000000000L,
            10000000000L,
    };

    public static boolean isValidId(String id) {
        if (id != null && id.length() > 1) {
            try {
                Integer.parseInt(id);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
        return false;
    }

    public static String getErepLink(String profileId) {
        return "http://www.erepublik.com/en/citizen/profile/" + profileId;
    }

    public static boolean isValidFF(String ff) {
        if (ff != null && ff.length() > 1) {
            try {
                int ffCount = Integer.parseInt(ff);
                return ffCount > 1 && ffCount < 120;
            } catch (Exception ex) {
                return false;
            }
        }
        return false;
    }

    public static boolean isValidDiv(String div) {
        try {
            int divInt = Integer.parseInt(div);
            return divInt >= 1 && divInt <= 4;
        } catch (Exception ex) {
            return false;
        }
    }

    public static Double toDouble(String value, String format) {
        if (value != null && !"".equals(value)) {
            try {
                DecimalFormat df = new DecimalFormat(format);
                Number parse = df.parse(value);
                return parse.doubleValue();
            } catch (Exception ex) {
                // ignored
                return null;
            }
        } else {
            return null;
        }
    }

    public static Double toDouble(String value) {
        if (value != null && !"".equals(value)) {
            try {
                return Double.parseDouble(value);
            } catch (Exception ex) {
                // ignored
                return null;
            }
        } else {
            return null;
        }
    }

    public static String toString(Object value) {
        return toString(value, "");
    }

    public static Integer toInt(String value) {
        if (value != null && !"".equals(value)) {
            try {
                return Integer.parseInt(value);
            } catch (Exception ex) {
                // ignored
                return null;
            }
        } else {
            return null;
        }
    }

    public static String toYesNo(Boolean value) {
        return value != null ? (value ? "Yes" : "No") : "No";
    }

    public static String toBold(String value) {
        return Colors.BOLD + value + Colors.NORMAL;
    }

    public static long getHit(Double strength, Integer level, int firePower) {
        if (level == null || strength == null) {
            return 0;
        } else {
            double value = 10 * (1 + (strength / 400D)) * (1 + (level / 5D)) * (1 + (firePower / 100D));
            return Math.round(value);
        }
    }

    public static String toString(Object value, String emptyString) {
        return value == null ? emptyString : value.toString();
    }

    public static String getPercent(Double value) {
        return value != null ? String.valueOf(Math.round(value * 100)) : "0";
    }

    public static long getHit(Double strength, Integer level, int firePower, int fights) {
        return fights * getHit(strength, level, firePower);
    }

    public static long getHit(Double strength, Integer level, int firePower, int fights, boolean isNe) {
        long hit = getHit(strength, level, firePower, fights);
        return isNe ? Math.round(hit * 1.1) : hit;
    }

    public static String formatWithThousands(Long number) {
        try {
            DecimalFormat formatter = new DecimalFormat("###,###.#");
            return formatter.format(number);
        } catch (Exception ex) {
            // ignored
        }
        return "";
    }

    public static String formatDecimal(Double number) {
        try {
            DecimalFormat formatter = new DecimalFormat("###,###.00");
            return formatter.format(number);
        } catch (Exception ex) {
            // ignored
        }
        return "";
    }

    public static boolean isEmpty(String arg) {
        return arg != null && arg.trim().length() != 0;
    }

    public static String formatWithComma(Integer damage) {
        try {
            DecimalFormat formatter = new DecimalFormat("###,###");
            return formatter.format(damage);
        } catch (Exception ex) {
            // ignored
        }
        return "";
    }

    public static String formatWithComma(Long damage) {
        try {
            DecimalFormat formatter = new DecimalFormat("###,###");
            return formatter.format(damage);
        } catch (Exception ex) {
            // ignored
        }
        return "";
    }

    public static String getRankName(Long points) {
        if (points != null) {
            int idx = 0;
            for (int i = 1; i < LIMIT.length; i++) {
                if (points >= LIMIT[i - 1] && points < LIMIT[i]) {
                    idx = i;
                    break;
                }
            }
            return LEVELS[idx - 1];
        } else {
            return "NONE";
        }
    }

    public static Double toDoubleUS(String value) {
        if (value != null && !"".equals(value)) {
            try {
                NumberFormat format = NumberFormat.getInstance(Locale.US);

                Number parse = format.parse(value);
                return parse.doubleValue();
            } catch (Exception ex) {
                // ignored
                return null;
            }
        } else {
            return null;
        }
    }

    public static Long toLong(String value) {
        if (value != null && value.length() > 0) {
            try {
                return Long.parseLong(value);
            } catch (Exception ex) {
                // ignored
                return null;
            }
        }
        return null;
    }

    public static Long toLongUS(String value) {
        if (value != null && value.length() > 0) {
            try {
                NumberFormat format = NumberFormat.getInstance(Locale.US);
                Number parse = format.parse(value);
                return parse.longValue();
            } catch (Exception ex) {
                //ignored
            }
        }
        return null;
    }

    public static Integer toIntUS(String value) {
        if (value != null && value.length() > 0) {
            try {
                NumberFormat format = NumberFormat.getInstance(Locale.US);
                Number parse = format.parse(value);
                return parse.intValue();
            } catch (Exception ex) {
                //ignored
            }
        }
        return null;
    }
}