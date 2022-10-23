package com.example.youtubechannel.utils;

public class StringUtil {

    /**
     * Check field not empty
     *
     * @param input text input
     */
    public static boolean isEmpty(String input) {
        if (input == null || input.isEmpty() || ("").equals(input.trim()))
            return true;
        return false;
    }
}
