package itat.zttc.shop.util;

import com.google.common.collect.Maps;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * since 2015/6/10.
 */
public class RequestUtil {

    public static void check(HttpServletRequest req, String key, String value) {
        Map<String, String> errorMap = (Map<String, String>) req.getAttribute("errorMap");
        if (errorMap == null) {
            errorMap = Maps.newHashMap();
            req.setAttribute("errorMap", errorMap);
        }
        errorMap.put(key, value);
    }
}
