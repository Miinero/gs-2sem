package com.fiap.gs2sem.utils;

public class FieldChecker {

    public static boolean checkName(String name) {
        return !name.isEmpty();
    }

    public static boolean checkDate(String date) {
        return !date.isEmpty();
    }

    public static boolean checkCPF(String cpf) {
        return cpf.length() == 14;
    }

    public static boolean checkDesc(String desc) {
        return !desc.isEmpty();
    }

}
