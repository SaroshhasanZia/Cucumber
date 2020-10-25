import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\VenD\\IdeaProjects\\CucumberTest\\Features\\login.feature",
        glue= "StepDefinition")



public class TestRunner {

}



