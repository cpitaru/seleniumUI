package bdd;

import bdd.utils.SharedData;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public abstract class StoryMapper extends JUnitStories {
    protected SharedData sharedData = new SharedData();

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(
                        new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                            .withFormats(Format.CONSOLE, Format.HTML)
                            .withRelativeDirectory("jbehave-report")
                );
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()),"**/stories/*.story","");
    }
}
