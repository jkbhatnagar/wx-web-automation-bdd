import io.cucumber.java.After;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import stepdefs.ShopStoreStepDefs;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/features"},
        glue = {"stepdefs"}
)

public class RunCucumberTest {

}