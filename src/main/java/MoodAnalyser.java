public class MoodAnalyser implements IMoodAnalyser{

    @Override
    public String analyseMethod(String message) {
        if (message.contains("sad")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}
