package tools;

import model.Course;
import model.Scoresheet;
import model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Print {
    public static void mainScreen() {
        System.out.print("1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1~3）: ");
    }

    public static void inputStudent() {
        System.out.print("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
    }

    public static void inputCorrectStudent() {
        System.out.print("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
    }

    public static void addSuccess(Student student) {
        System.out.println("学生"+student.getName()+"的成绩被添加");
    }

    public static void inputStudentId() {
        System.out.print("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }

    public static void inputCorrectId() {
        System.out.print("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
    }

    public void printScoresheet(Scoresheet scoresheet) {
        List<String> courses = generateCourses(scoresheet.getStudents());
        System.out.println("成绩单\n" + "姓名|" + String.join("|", courses) + "|平均分|总分"
                + "\n========================\n" + generateStudent(scoresheet.getStudents(), courses)
                + "\n========================\n" + "全班总分平均数：" + scoresheet.getSumAverage()
                + "\n全班总分中位数："+ scoresheet.getSumMedian()
        );

    }

    private List<String> generateCourses(List<Student> students) {
        List<Course> courses = students.stream()
                .flatMap(student -> student.getCourses().stream())
                .collect(Collectors.toList());
        return courses.stream().map(Course::getName).distinct().collect(Collectors.toList());
    }

    private String generateStudent(List<Student> students, List<String> coursesList) {
        List<String> printStudents = students.stream().map(student ->
                student.getName() + "|" + generateScore(student, coursesList) + "|" + student.getAverage() + "|" + student.getSum())
                .collect(Collectors.toList());
        return String.join("\n", printStudents);
    }

    private String generateScore(Student student, List<String> coursesList) {
        List<Course> courses = student.getCourses();
        List<String> names = courses.stream().map(Course::getName).collect(Collectors.toList());
        List<Integer> score = courses.stream().map(Course::getScore).collect(Collectors.toList());
        List<String> printScore = coursesList.stream().map(ele -> {
            int index = names.indexOf(ele);
            if (index != -1) {
                return score.get(index) + "";
            }
            return "0";
        }).collect(Collectors.toList());
        return String.join("|", printScore);
    }
}
