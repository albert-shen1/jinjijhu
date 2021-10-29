package com.slj.jinjihu.backend.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class MapUtil {
    public static boolean isNotBlankKey(String key, Map<String, String> map) {
        if (map.containsKey(key) && StringUtils.isNotBlank(map.get(key))) {
            return true;
        }
        return false;
    }
}
