package com.example.quiz;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class QuizLogic {

    private static final String DB_URL = "jdbc:sqlite:quiz.db";

    // A method to return a list of all questions
    public static List<?> getAllQuestions(String part) throws SQLException {
        return processQueryResults(executeQuery("SELECT * FROM Questions"), part);
    }

    // A method to return a list of random questions
    public static List<Map<String, Object>> getRandomQuestions() throws SQLException {
        return executeQuery("SELECT * FROM Questions ORDER BY RANDOM() LIMIT 6");
    }

    // A method to return a list of all questions of a given difficulty
    public static List<?> getQuestionsByDifficulty(String difficulty, String part) throws SQLException {
        String query = "SELECT question, option_a, option_b, option_c, correct_option FROM Questions WHERE difficulty = ? LIMIT 6";
        return processQueryResults(executeQueryWithParameters(query, difficulty), part);
    }

    // A method to return a list of all questions of a given category
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

    // A method to return a list of all questions of a given category
    private static List<Map<String, Object>> executeQuery(String query) throws SQLException {
        return executeQueryWithParameters(query, null);
    }

    // A method to return a list of all questions of a given category
    private static List<Map<String, Object>> executeQueryWithParameters(String query, String parameter) throws SQLException {
        List<Map<String, Object>> questionsList = new ArrayList<>();
        // Try-with-resources block to automatically close the connection
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection(DB_URL);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                // Set the values
                if (parameter != null) {
                    pstmt.setString(1, parameter);
                }

                // Set the values
                try (ResultSet rs = pstmt.executeQuery()) {
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
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return questionsList;
    }
    
    // A method to return a list of all random questions
    public static List<Map<String, Object>> randomQuestions;

    static {
        try {
            randomQuestions = getRandomQuestions();
        } catch (SQLException e) {
            e.printStackTrace();
            randomQuestions = Collections.emptyList(); 
        }
    }

    // A method to return a list of quickfire questions
    public static List <?> get_questions() {
        return processQueryResults(randomQuestions, "questions");
    }

    // A method to return a list of quickfire options
    public static List <?> get_options() {
        return processQueryResults(randomQuestions, "options");
    }
    
    // A method to return a list of quickfire answers
    public static List <?> get_answers() {
        return processQueryResults(randomQuestions, "answer");
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getQuestionsByDifficulty("NOVICE", "answer"));
    }
}
