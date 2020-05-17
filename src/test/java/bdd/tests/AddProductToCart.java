package bdd.tests;

import bdd.StoryMapper;
import bdd.setup.BrowserBasicSteps;
import bdd.steps.LoginSteps;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class AddProductToCart extends StoryMapper {

        @Override
        public InjectableStepsFactory stepsFactory() {
            return new InstanceStepsFactory(configuration(), new BrowserBasicSteps(sharedData),new LoginSteps(sharedData));
        }

        @Override
        protected List<String> storyPath() {
            return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()),"**/stories/Login.story", "");
        }

}
