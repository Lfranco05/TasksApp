package com.lfranco.calculadoraavanzada.Services;

public class TrigService {
    private static double toRadians(double x, boolean inDegrees) {
        return inDegrees ? Math.toRadians(x) : x;
    }
    public static double sin(double x, boolean inDegrees) {
        return Math.sin(toRadians(x, inDegrees));
    }
    public static double cos(double x, boolean inDegrees) {
        return Math.cos(toRadians(x, inDegrees));
    }
    public static double tan(double x, boolean inDegrees) {
        return Math.tan(toRadians(x, inDegrees));
    }
    public static double cot(double x, boolean inDegrees) {
        double t = tan(x, inDegrees);
        if (t == 0.0) throw new IllegalArgumentException("cot indefinida (tan = 0)");
        return 1.0 / t;
    }
}