package tools;

public class Print {
    public static void mainScreen() {
        System.out.println("1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1~3）: ");
    }

    public static void inputStudent() {
        System.out.print("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
    }

    public static void inputCorrectStudent() {
        System.out.print("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
    }

    public static void inputStudentId() {
        System.out.print("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }

    public static void inputCorrectId() {
        System.out.print("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }

}
