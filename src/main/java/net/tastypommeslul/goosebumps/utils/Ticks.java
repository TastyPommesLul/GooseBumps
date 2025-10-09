package net.tastypommeslul.goosebumps.utils;

public final class Ticks {
    private static final int TICKS_PER_SECOND = 20;
    private static final int TICKS_PER_MINUTE = TICKS_PER_SECOND * 60;

    private Ticks() { throw new AssertionError("Cannot instantiate utility class"); }

    public static int fromSeconds(float seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Seconds cannot be negative");
        }
        long result = Math.round(seconds * TICKS_PER_SECOND);
        return (int) result;
    }
    public static int fromMinutes(float minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Minutes cannot be negative");
        }
        long result = Math.round(minutes * TICKS_PER_MINUTE);
        return (int) result;
    }
    public static int fromSeconds(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Seconds cannot be negative");
        }
        return seconds * TICKS_PER_SECOND;
    }
    public static int fromMinutes(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Minutes cannot be negative");
        }
        return minutes * TICKS_PER_MINUTE;
    }
}