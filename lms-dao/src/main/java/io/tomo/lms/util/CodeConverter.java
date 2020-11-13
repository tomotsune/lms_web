package io.tomo.lms.util;


import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.apache.commons.jexl3.internal.Engine;

import java.util.Map;

public class CodeConverter {
    private static JexlEngine jexlEngine = new Engine();
    public static Object convertToCode(String jexlExpression, Map<String, Object> map) {
        JexlExpression expression = jexlEngine.createExpression(jexlExpression);
        JexlContext context = new MapContext();
        if (!map.isEmpty()) {
            map.forEach(context::set);
        }
        return expression.evaluate(context);
    }
}
