package com.erep.elucs.model.json.profile;

public enum RanksLevel {
    RECRUIT(1, "Recruit", 0, 15),
    PRIVATE(2, "Private", 15, 45),
    PRIVATE1(3, "Private*", 45, 80),
    PRIVATE2(4, "Private**", 80, 120),
    PRIVATE3(5, "Private***", 120, 170),
    CORPORAL(6, "Corporal", 170, 250),
    CORPORAL1(7, "Corporal*", 250, 350),
    CORPORAL2(8, "Corporal**", 350, 450),
    CORPORAL3(9, "Corporal***", 450, 600),
    SERGEANT(10, "Sergeant", 600, 800),
    SERGEANT1(11, "Sergeant*", 800, 1000),
    SERGEANT2(12, "Sergeant**", 1000, 1400),
    SERGEANT3(13, "Sergeant***", 1400, 1850),
    LIEUTENANT(14, "Lieutenant", 1850, 2350),
    LIEUTENANT1(15, "Lieutenant*", 2350, 3000),
    LIEUTENANT2(16, "Lieutenant**", 3000, 3750),
    LIEUTENANT3(17, "Lieutenant***", 3750, 5000),
    CAPTAIN(18, "Captain", 5000, 6500),
    CAPTAIN1(19, "Captain*", 6500, 9000),
    CAPTAIN2(20, "Captain**", 9000, 12000),
    CAPTAIN3(21, "Captain***", 12000, 15500),
    MAJOR(22, "Major", 15500, 20000),
    MAJOR1(23, "Major*", 20000, 25000),
    MAJOR2(24, "Major**", 25000, 31000),
    MAJOR3(25, "Major***", 31000, 40000),
    COMMANDER(26, "Commander", 40000, 52000),
    COMMANDER1(27, "Commander *", 52000, 67000),
    COMMANDER2(28, "Commander **", 67000, 85000),
    COMMANDER3(29, "Commander ***", 85000, 110000),
    LT_COLONEL(30, "Lt Colonel", 110000, 140000),
    LT_COLONEL1(31, "Lt Colonel*", 140000, 180000),
    LT_COLONEL2(32, "Lt Colonel**", 180000, 225000),
    LT_COLONEL3(33, "Lt Colonel***", 225000, 285000),
    COLONEL(34, "Colonel", 285000, 355000),
    COLONEL1(35, "Colonel*", 355000, 435000),
    COLONEL2(36, "Colonel**", 435000, 540000),
    COLONEL3(37, "Colonel***", 540000, 660000),
    GENERAL(38, "General", 660000, 800000),
    GENERAL1(39, "General*", 800000, 950000),
    GENERAL2(40, "General**", 950000, 1140000),
    GENERAL3(41, "General***", 1140000, 1350000),
    FIELD_MARSHAL(42, "Field Marshal", 1350000, 1600000),
    FIELD_MARSHAL1(43, "Field Marshal*", 1600000, 1875000),
    FIELD_MARSHAL2(44, "Field Marshal**", 1875000, 2185000),
    FIELD_MARSHAL3(45, "Field Marshal***", 2185000, 2550000),
    SUPREME_MARSHAL(46, "Supreme Marshal", 2550000, 3000000),
    SUPREME_MARSHAL1(47, "Supreme Marshal*", 3000000, 3500000),
    SUPREME_MARSHAL2(48, "Supreme Marshal**", 3500000, 4150000),
    SUPREME_MARSHAL3(49, "Supreme Marshal***", 4150000, 4900000),
    NATIONAL_FORCE(50, "National Force", 4900000, 5800000),
    NATIONAL_FORCE1(51, "National Force*", 5800000, 7000000),
    NATIONAL_FORCE2(52, "National Force**", 7000000, 9000000),
    NATIONAL_FORCE3(53, "National Force***", 9000000, 11500000),
    WORLD_CLASS_FORCE(54, "World Class Force", 11500000, 14500000),
    WORLD_CLASS_FORCE1(55, "World Class Force*", 14500000, 18000000),
    WORLD_CLASS_FORCE2(56, "World Class Force**", 18000000, 22000000),
    WORLD_CLASS_FORCE3(57, "World Class Force***", 22000000, 26500000),
    LEGENDARY_FORCE(58, "Legendary Force", 26500000, 31500000),
    LEGENDARY_FORCE1(59, "Legendary Force*", 31500000, 37000000),
    LEGENDARY_FORCE2(60, "Legendary Force**", 37000000, 43000000),
    LEGENDARY_FORCE3(61, "Legendary Force***", 43000000, 50000000),
    GOD_OF_WAR(62, "God of War", 50000000, 100000000),
    GOD_OF_WAR1(63, "God of War*", 100000000, 200000000),
    GOD_OF_WAR2(64, "God of War**", 200000000, 500000000),
    GOD_OF_WAR3(65, "God of War***", 500000000, Integer.MAX_VALUE),;

    private final int level;
    private final String name;
    private final long minExp;
    private final long maxExp;

    RanksLevel(int level, String name, long minExp, long maxExp) {
        this.level = level;
        this.name = name;
        this.minExp = minExp;
        this.maxExp = maxExp;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public long getMinExp() {
        return minExp;
    }

    public long getMaxExp() {
        return maxExp;
    }

    public static long getUntil(Long currentExp, Integer level) {
        if (currentExp != null && level != null) {
            RanksLevel[] values = RanksLevel.values();
            if (level >= 1 && level < values.length) {
                RanksLevel ranksLevel = values[level - 1];
                long total = ranksLevel.maxExp - currentExp;
                return total * 10;
            }
        }
        return 0;
    }

}
