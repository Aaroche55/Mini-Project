public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.err.println(QuizManager.getQuestionsByDifficulty("NOVICE", "questions").get(0));
    }
}
