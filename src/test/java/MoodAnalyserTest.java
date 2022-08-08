import org.hamcrest.CoreMatchers;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class MoodAnalyserTest {

    @Test
    public void testMoodAnalyser() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMethod("This is a sad message");
        assertThat(mood, CoreMatchers.is("SAD"));
    }

    @Test
    public void HappyMoods() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMethod("This is a happy message");
        assertThat(mood, CoreMatchers.is("HAPPY"));
    }
}
