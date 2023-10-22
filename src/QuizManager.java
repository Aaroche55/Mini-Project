import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class QuizManager {

    public static List<?> getAllQuestions(String part) throws SQLException {
        return processQueryResults(executeQuery("SELECT * FROM Questions"), part);
    }

    public static List<?> getRandomQuestions(String part) throws SQLException {
        return processQueryResults(executeQuery("SELECT * FROM Questions ORDER BY RANDOM() LIMIT 6"), part);
    }

    public static List<?> getQuestionsByDifficulty(String difficulty, String part) throws SQLException {
        return processQueryResults(executeQuery("SELECT question, option_a, option_b, option_c, correct_option FROM Questions WHERE difficulty = '" + difficulty.toUpperCase() + "' LIMIT 6"), part);
    }

    private static List<?> processQueryResults(List<Map<String, Object>> questions, String part) {
        switch (part) {
            case "questions":
                return questions.stream()
                        .map(q -> q.get("question"))
                        .collect(Collectors.toList());
            case "options":
                return questions.stream()
                        .map(q -> Arrays.asList(q.get("option_a"), q.get("option_b"), q.get("option_c")))
                        .collect(Collectors.toList());
            case "answer":
                return questions.stream()
                        .map(q -> q.get("correct_option"))
                        .collect(Collectors.toList());
            default:
                return null;
        }
    }

    private static List<Map<String, Object>> executeQuery(String query) throws SQLException {
        List<Map<String, Object>> questionsList = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:quizApp.db");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Map<String, Object> question = new LinkedHashMap<>();
                question.put("question", rs.getString("question"));
                question.put("option_a", rs.getString("option_a"));
                question.put("option_b", rs.getString("option_b"));
                question.put("option_c", rs.getString("option_c"));
                question.put("correct_option", rs.getString("correct_option"));
                questionsList.add(question);
            }
        }
        return questionsList;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getAllQuestions("questions").get(0));
        System.out.println(getRandomQuestions("options").get(0));
        System.out.println(getQuestionsByDifficulty("NOVICE", "answer").get(0));

        System.out.println(((List<String>) getRandomQuestions("options").get(0)).get(0));

    }
}
