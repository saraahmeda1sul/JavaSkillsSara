public class GradeManager {
    public static String[] reverseStudentNames(String[] names) {
        String[] reversed = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            StringBuilder sb = new StringBuilder(names[i]);
            reversed[i] = sb.reverse().toString();}
        return reversed;
    }
    public static char getLetterGrade(int score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    public static String[] findFailingStudents(String[] names, int[] scores) {
        int count = 0;
        for (int score : scores) {
            if (score < 60) {
                count++;
            }
        }
        String[] failing = new String[count];
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failing[index] = names[i];
                index++;
            }
        }
        return failing;
    }
    public static void main(String[] args) {
        String[] students = {"sara", "alaa", "meme", "fatma"};
        int[] scores = {95, 67, 88, 78};

        System.out.println(" Student Names:");
        for (String name : students) {
            System.out.println(name);
        }

        System.out.println("Reversed Names:");
        String[] reversedNames = reverseStudentNames(students);
        for (String name : reversedNames) {
            System.out.println(name);
        }

        System.out.println("Student Grades:");
        for (int i = 0; i < students.length; i++) {
            char grade = getLetterGrade(scores[i]);
            System.out.println(students[i] + ": " + scores[i] + " → Grade " + grade);
        }

        System.out.println("Students Who Need to Retake the Exam:");
        String[] failing = findFailingStudents(students, scores);
        if (failing.length == 0) {
            System.out.println("All students passed.");
        } else {
            for (String name : failing) {
                System.out.println(name);
            }
        }
    }
}

