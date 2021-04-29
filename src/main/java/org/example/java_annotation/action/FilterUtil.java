package org.example.java_annotation.action;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lifei
 */
public class FilterUtil {
    public String query(Filter f) {
        StringBuilder sb = new StringBuilder();
        // 获取表名
        Class clazz = f.getClass();
        boolean classExist = clazz.isAnnotationPresent(Table.class);
        if (!classExist) {
            return null;
        }
        Table table = (Table) clazz.getAnnotation(Table.class);
        String tableName = table.value();
        sb.append("select * from ").append(tableName).append(" where 1=1 ");
        // 依次获取字段名
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            boolean fieldExist = field.isAnnotationPresent(Column.class);
            if (!fieldExist) {
                return null;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            String fieldName = field.getName();
            String fieldGetMethodName = "get"
                    + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);
            Object fieldValue = null;
            try {
                Method method = clazz.getMethod(fieldGetMethodName);
                fieldValue = method.invoke(f);
            } catch (NoSuchMethodException | IllegalAccessException |
                    InvocationTargetException e) {
                e.printStackTrace();
            }
            // 处理null和integer=0的情况
            boolean fieldValueEqualsZero = fieldValue instanceof Integer && (int) fieldValue == 0;
            if (fieldValue == null || fieldValueEqualsZero) {
                continue;
            }
            // 处理字符串的情况
            if (fieldValue instanceof String) {
                // 处理多个值同时匹配
                if (((String) fieldValue).contains(",")) {
                    String[] values = ((String) fieldValue).split(",");
                    sb.append(" and (1=0 ");
                    for (String v : values) {
                        sb.append(" or ").append(columnName).append("='").append(v).append("'");
                    }
                    sb.append(") ");
                } else {
                    sb.append(" and ").append(columnName).append("='").append(fieldValue).append("'");
                }
            } else {
                sb.append(" and ").append(columnName).append("=").append(fieldValue);
            }
        }
        return sb.toString();
    }
}
