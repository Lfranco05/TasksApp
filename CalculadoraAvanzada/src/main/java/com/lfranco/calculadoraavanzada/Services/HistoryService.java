package com.lfranco.calculadoraavanzada.Services;

import com.lfranco.calculadoraavanzada.Models.OperationLog;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class HistoryService {
    private static final Deque<OperationLog> LOGS = new ArrayDeque<>();
    private static final int MAX = 50;

    public static synchronized void add(OperationLog log) {
        LOGS.addFirst(log);
        while (LOGS.size() > MAX) LOGS.removeLast();
    }

    public static synchronized List<OperationLog> getLast(int n) {
        List<OperationLog> out = new ArrayList<>();
        int i = 0;
        for (OperationLog l : LOGS) {
            if (i++ >= n) break;
            out.add(l);
        }
        return out;
    }
}