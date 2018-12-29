package org.java.zpoa.util;

import java.util.List;
import java.util.Map;

public class RoleUtils {

    public static List<Map<String, Object>> findHasPowerRole(Map m) {
        switch (m.get("type").toString()) {
            case "overTime":
                Map<String, Object> data = (Map<String, Object>) m.get("data");
                System.out.println(data);
                break;
            case "leave":
                break;
        }
        return null;
    }

}
