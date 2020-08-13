package com.uj.study.jbehave;

/**
 * @author aiet
 */
public class GithubUserResponseMediaTypeStoryLiveTest extends AbstractStory {

    @Override
    String storyName() {
        return "jbehave/github_user_response_mediatype.story";
    }

    @Override
    Object stepInstance() {
        return new GithubUserResponseMediaTypeSteps();
    }

}
