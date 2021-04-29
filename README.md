# [Java-Annotation](https://github.com/happyflyer/Java-Annotation)

- 概念：Java 提供了一种原程序中的元素关联任何信息和任何元数据的途径和方法
- 内容：
  - Java 中的常见注解
  - 注解分类
  - 自定义注解
  - 注解应用实战

## 1. 常见的注解

### 1.1. JDK 中的注解

- `@Override`
- `@Deprecated`
- `@SuppressWarnings("deprecation")`

```java
public interface Person {
    String name();
    int age();
    @Deprecated
    void sing();
}
```

```java
public class Child implements Person {
    @Override
    public String name() {
        return "child";
    }
    @Override
    public int age() {
        return 0;
    }
    @Override
    public void sing() {
        System.out.println("child sing");
    }
}
```

### 1.2. 第三方注解

- Spring
  - `@Autowired`
  - `@Service`
  - `@Repository`
- MyBatis
  - `@InsertProvider`
  - `@UpdateProvider`
  - `@Options`

## 2. 注解的分类

### 2.1. 按照运行机制分

- 源码注解：注解只在源码中存在，编译成 `*.class` 文件就不存在了
- 编译时注解：注解在源码和 `*.class` 文件中都存在
- 运行时注解：在运行阶段还起作用，甚至会影响运行逻辑的注解

### 2.2. 按照来源分

- 来自 JDK 的注解
- 来自第三方的注解
- 我们自定义的注解

## 3. 自定义注解

### 3.1. 定义注解

```java
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String desc();
    String author();
    int age() default 18;
}
```

- 使用 `@interface` 关键字定义注解
- 成员以无参无异常方式声明
- 可以用 `default` 为成员指定一个默认值

### 3.2. 注解成员

- 成员类型是受限的，合法的类型包括原始类型、`String`、`Class`、`Annotation`、`Enumeration`
- 如果注解只有一个成员，则成员名必须取名为 `value()`，在使用时可以忽略成员名和赋值号（`=`）
- 注解类可以没有成员，没有成员的注解称为标识注解

### 3.3. 元注解

#### 3.3.1. Target

- `TYPE`：类、接口
- `FIELD`：字段声明
- `METHOD`：方法声明
- `PARAMETER`：参数声明
- `CONSTRUCTOR`：构造方法声明
- `LOCAL_VARIABLE`：局部变量声明
- `PACKAGE`：包声明

```java
package java.lang.annotation;
public enum ElementType {
    TYPE,
    FIELD,
    METHOD,
    PARAMETER,
    CONSTRUCTOR,
    LOCAL_VARIABLE,
    ANNOTATION_TYPE,
    PACKAGE,
    TYPE_PARAMETER,
    TYPE_USE,
    MODULE
}
```

#### 3.3.2. Retention

- `SOURCE`：只在源码显示，编译时会丢弃
- `CLASS`：编译时会记录到 class 中，运行时忽略
- `RUNTIME`：运行时存在，可以通过反射读取

```java
package java.lang.annotation;
public enum RetentionPolicy {
    SOURCE,
    CLASS,
    RUNTIME
}
```

#### 3.3.3. Inherited

- 允许子类继承

#### 3.3.4. Documented

- 生成 javadoc 时会包含注解

### 3.4. 使用注解

![使用自定义注解](https://cdn.jsdelivr.net/gh/happyflyer/picture-bed@main/2020/使用自定义注解.8z9u5v21grs.jpg)

```java
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description1 {
    String desc();
    String author();
    int age() default 18;
}
```

```java
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description2 {
    String value();
}
```

```java
@Description1(desc = "TestClass with Description1", author = "lifei")
public class TestClass {
    @Description1(desc = "test1 with Description1", author = "lifei")
    public void test1() {
        System.out.println("test1");
    }
    @Description1(desc = "test2 with Description1", author = "lifei")
    @Description2("test2 with Description2")
    public void test2() {
        System.out.println("test2");
    }
}
```

### 3.5. 解析注解

- 概念：通过反射获取类、函数、或成员上的**运行时**注解信息，从而丛台控制程序运行的逻辑。

#### 3.5.1. 解析类注解

```java
public void parseClassAnnotation() throws ClassNotFoundException {
    Class clazz = Class.forName("org.example.java_annotation.custom.TestClass");
    boolean isExist = clazz.isAnnotationPresent(Description1.class);
    if (isExist) {
        Description1 d = (Description1) clazz.getAnnotation(Description1.class);
        System.out.println(d.desc());
    }
}
```

```java
TestClass with Description1
```

#### 3.5.2. 解析方法注解

```java
public void parseMethodAnnotation1() throws ClassNotFoundException {
    Class clazz = Class.forName("org.example.java_annotation.custom.TestClass");
    Method[] methods = clazz.getMethods();
    for (Method method : methods) {
        if (method.isAnnotationPresent(Description1.class)) {
            Description1 d = method.getAnnotation(Description1.class);
            System.out.println(d.desc());
        }
    }
}
```

```java
test1 with Description1
test2 with Description1
```

```java
public void parseMethodAnnotation2() throws ClassNotFoundException {
    Class clazz = Class.forName("org.example.java_annotation.custom.TestClass");
    Method[] methods = clazz.getMethods();
    for (Method method : methods) {
        Annotation[] annotations = method.getAnnotations();
        for (Annotation a : annotations) {
            if (a instanceof Description1) {
                Description1 d = method.getAnnotation(Description1.class);
                System.out.println(d.desc());
            }
            if (a instanceof Description2) {
                Description2 d = method.getAnnotation(Description2.class);
                System.out.println(d.value());
            }
        }
    }
}
```

```java
test1 with Description1
test2 with Description1
test2 with Description2
```

## 4. 注解的继承

- 不继承接口的注解
- 只继承父类的类注解
- 不继承父类的方法注解

### 4.1. 定义注解

```java
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description3 {
    String value();
}
```

### 4.2. 接口和类

```java
@Description3("interface Human with Description3")
public interface Human {
    @Description3("interface Human method name with Description3")
    String name();
    int age();
    @Deprecated
    void sing();
}
```

```java
@Description3("class Adult with Description3")
public class Adult implements Human {
    @Override
    @Description3("class Adult method name with Description3")
    public String name() {
        return "adult";
    }
    @Override
    public int age() {
        return 0;
    }
    @Override
    public void sing() {
        System.out.println("adult sing");
    }
}
```

```java
public class Child implements Human {
    @Override
    public String name() {
        return "child";
    }
    @Override
    public int age() {
        return 0;
    }
    @Override
    public void sing() {
        System.out.println("child sing");
    }
}
```

```java
@Description3("class Man with Description3")
public class Man extends Adult {
    @Override
    public String name() {
        return "man";
    }
}
```

```java
public class Woman extends Adult{
    @Override
    @Description3("class Woman method name with Description3")
    public String name() {
        return "woman";
    }
}
```

### 4.3. 不继承接口的注解

```java
public void parseClassAnnotation1() throws ClassNotFoundException {
    Class clazz = Class.forName("org.example.java_annotation.parse.Adult");
    boolean isExist = clazz.isAnnotationPresent(Description3.class);
    if (isExist) {
        Description3 d = (Description3) clazz.getAnnotation(Description3.class);
        System.out.println(d.value());
    }
}
```

```java
class Adult with Description3
```

```java
public void parseClassAnnotation2() throws ClassNotFoundException {
    Class clazz = Class.forName("org.example.java_annotation.parse.Child");
    boolean isExist = clazz.isAnnotationPresent(Description3.class);
    if (isExist) {
        Description3 d = (Description3) clazz.getAnnotation(Description3.class);
        System.out.println(d.value());
    }
}
```

```java

```

### 4.4. 继承父类的类注解

```java
public void parseClassAnnotation3() throws ClassNotFoundException {
    Class clazz = Class.forName("org.example.java_annotation.parse.Man");
    boolean isExist = clazz.isAnnotationPresent(Description3.class);
    if (isExist) {
        Description3 d = (Description3) clazz.getAnnotation(Description3.class);
        System.out.println(d.value());
    }
}
```

```java
class Man with Description3
```

```java
public void parseClassAnnotation4() throws ClassNotFoundException {
    Class clazz = Class.forName("org.example.java_annotation.parse.Woman");
    boolean isExist = clazz.isAnnotationPresent(Description3.class);
    if (isExist) {
        Description3 d = (Description3) clazz.getAnnotation(Description3.class);
        System.out.println(d.value());
    }
}
```

```java
class Adult with Description3
```

### 4.5. 不继承父类的方法注解

```java
public void parseMethodAnnotation1() throws ClassNotFoundException {
    Class clazz = Class.forName("org.example.java_annotation.parse.Man");
    Method[] methods = clazz.getMethods();
    for (Method method : methods) {
        if (method.isAnnotationPresent(Description3.class)) {
            Description3 d = method.getAnnotation(Description3.class);
            System.out.println(d.value());
        }
    }
}
```

```java

```

```java
public void parseMethodAnnotation2() throws ClassNotFoundException {
    Class clazz = Class.forName("org.example.java_annotation.parse.Woman");
    Method[] methods = clazz.getMethods();
    for (Method method : methods) {
        if (method.isAnnotationPresent(Description3.class)) {
            Description3 d = method.getAnnotation(Description3.class);
            System.out.println(d.value());
        }
    }
}
```

```java
class Woman method name with Description3
```

## 5. 注解实战

### 5.1. 项目说明

- 项目取自一个公司的持久层架构
- 用来代替 Hibernate 的解决方案
- 核心代码就是通过注解来实现的

### 5.2. 需求

- 有一张用户表，字段包括：
  - 用户 ID
  - 用户名
  - 昵称
  - 年龄
  - 性别
  - 所在城市
  - 邮箱
  - 手机号
- 方便对每个字段或字段的组合条件进行检索，并打印出 SQL
- 使用方式要足够简单，见代码示例

### 5.3. 定义注解

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value();
}
```

```java
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String value();
}
```

### 5.4. 用户实体

```java
public abstract class Filter {
}
```

```java
@Table("user")
public class Filter1 extends Filter {
    @Column("id")
    private int id;
    @Column("username")
    private String username;
    @Column("nickname")
    private String nickname;
    @Column("age")
    private int age;
    @Column("city")
    private String city;
    @Column("email")
    private String email;
    @Column("mobile")
    private String mobile;
    // ...
}
```

### 5.5. 工具类

```java
public class FilterUtil {
    public String query(Filter f) {
        StringBuilder sb = new StringBuilder();
        // ...
        return sb.toString();
    }
}
```

```java
// 获取表名
Class clazz = f.getClass();
boolean classExist = clazz.isAnnotationPresent(Table.class);
if (!classExist) {
    return null;
}
Table table = (Table) clazz.getAnnotation(Table.class);
String tableName = table.value();
sb.append("select * from ").append(tableName).append(" where 1=1 ");
```

```java
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
    // sb.append(" and ").append(columnName).append("=").append(fieldValue);
}
```

```java
// 处理null和integer=0的情况
boolean fieldValueEqualsZero = fieldValue instanceof Integer && (int) fieldValue == 0;
if (fieldValue == null || fieldValueEqualsZero) {
    continue;
}
```

```java
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
```

### 5.6. 测试

```java
Filter1 f1 = new Filter1();
f1.setId(10);
String sql1 = filterUtil.query(f1);
System.out.println(sql1);
```

```sql

```

```java
Filter1 f1 = new Filter1();
f1.setId(10);
String sql1 = filterUtil.query(f1);
System.out.println(sql1);
```

```sql
select * from user where 1=1  and id=10
```

```java
Filter1 f2 = new Filter1();
f2.setUsername("lucy,andy,tom");
f2.setAge(18);
String sql2 = filterUtil.query(f2);
System.out.println(sql2);
```

```sql
select * from user where 1=1  and (1=0  or username='lucy' or username='andy' or username='tom')  and age=18
```

```java
Filter1 f3 = new Filter1();
f3.setEmail("liu@sina.com,zh@163.com,77777@qq.com");
String sql3 = filterUtil.query(f3);
System.out.println(sql3);
```

```sql
select * from user where 1=1  and (1=0  or email='liu@sina.com' or email='zh@163.com' or email='77777@qq.com')
```

### 5.7. 重用

```java
@Table("department")
public class Filter2 extends Filter {
    @Column("id")
    private int id;
    @Column("name")
    private String name;
    @Column("leader")
    private String leader;
    @Column("amount")
    private int amount;
    // ...
}
```

```java
Filter2 filter2 = new Filter2();
filter2.setAmount(10);
filter2.setName("技术部");
System.out.println(filterUtil.query(filter2));
```

```sql
select * from department where 1=1  and name='技术部' and amount=10
```
