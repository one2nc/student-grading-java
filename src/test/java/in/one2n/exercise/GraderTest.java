package in.one2n.exercise;

import org.junit.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static in.one2n.exercise.Grade.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GraderTest {

    private final Grader grader = new Grader();

    @Test
    //Parse input file into list of students
    public void itShouldParseInputTestDataIntoStudents() {
        String filepath = Paths.get("src", "test", "resources", "grades.csv").toString();

        List<Student> students = grader.parseCSV(filepath);

        assertThat(students.size(), is(30));

        Student firstStudent = new Student("Kaylen", "Johnson", "Duke University",
                52.0d, 47.0d, 35.0d, 38.0d);
        assertThat(students.get(0), is(firstStudent));

        Student lastStudent = new Student("Solomon", "Hunter", "Boston University",
                45.0d, 62.0d, 32.0d, 58.0d);
        assertThat(students.get(29), is(lastStudent));
    }

    @Test
    //Calculate Student Grade and Final score
    public void itShouldCalculateStudentGradeAndFinalScore() {
        String filepath = Paths.get("src", "test", "resources", "grades.csv").toString();
        List<Student> students = grader.parseCSV(filepath);

        List<Student> gradedStudents = grader.calculateGrade(students);

        assertThat(gradedStudents.size(), is(30));
        List<Double> expectedStudentScores = Arrays.asList(43d, 59.25d, 53d, 58.25d, 52.25d, 50.75d, 54.75d, 49.25d, 64.75d, 43.25d, 68.5d, 57.75d, 68.25d, 66.75d, 45.5d, 45.75d, 45.5d, 58d, 56d, 60.25d, 61d, 62.5d, 80.5d, 53d, 30.75d, 57.5d, 70.75d, 48.5d, 60.25d, 49.25d);
        List<Grade> expectedStudentGrades = Arrays.asList(C, B, B, B, B, B, B, C, B, C, B, B, B, B, C, C, C, B, B, B, B, B, A, B, F, B, A, C, B, C);

        for (int i = 0; i < gradedStudents.size(); i++) {
            assertThat(gradedStudents.get(i).getFinalScore(), is(expectedStudentScores.get(i)));
            assertThat(gradedStudents.get(i).getGrade(), is(expectedStudentGrades.get(i)));
        }
    }

    @Test
    //Find out overall topper student
    public void itShouldFindOverallTopperStudent() {
        String filepath = Paths.get("src", "test", "resources", "grades.csv").toString();
        List<Student> students = grader.parseCSV(filepath);
        List<Student> gradedStudents = grader.calculateGrade(students);

        Student topper = grader.findOverallTopper(gradedStudents);

        assertThat(topper, is(new Student("Bernard", "Wilson", "Boston University")));
    }

    @Test
    //Find out topper student for each university
    public void itShouldFindTopperStudentForEachUniversity() {
        String filepath = Paths.get("src", "test", "resources", "grades.csv").toString();
        List<Student> students = grader.parseCSV(filepath);
        List<Student> gradedStudents = grader.calculateGrade(students);

        Map<String, Student> universityTopper = grader.findTopperPerUniversity(gradedStudents);

        assertThat(universityTopper.get("Boston University"), is(new Student("Bernard", "Wilson", "Boston University")));
        assertThat(universityTopper.get("Duke University"), is(new Student("Tamara", "Webb", "Duke University")));
        assertThat(universityTopper.get("Union College"), is(new Student("Izayah", "Hunt", "Union College")));
        assertThat(universityTopper.get("University of California"), is(new Student("Karina", "Shaw", "University of California")));
        assertThat(universityTopper.get("University of Florida"), is(new Student("Nathan", "Gordon", "University of Florida")));
    }
}
