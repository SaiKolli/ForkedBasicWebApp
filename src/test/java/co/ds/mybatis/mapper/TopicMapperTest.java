package co.ds.mybatis.mapper;

import co.ds.bean.Topic;
import com.google.inject.Inject;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sai.kolli on 8/10/17.
 */
public class TopicMapperTest extends MapperTestBase {

    public static final String SOMETHING_SOMETHING = "Something Something";
    @Inject
    TopicMapper topicMapper;

    @Test
    public void should_list() {
        final List<Topic> topicList = topicMapper.list();
        assertEquals("Topic list should contain 4 records", 4, topicList.size());
    }

    @Test
    public void should_fetch() {
        final List<Topic> topicList = topicMapper.list();
        assertEquals("Topic list should contain 4 records", 4, topicList.size());

        final Topic originalTopic = topicList.get(0);
        final Topic topic = topicMapper.fetch(originalTopic.getId());

        assertEquals("ID should be the same", originalTopic.getId(), topic.getId());
        assertEquals("Name should be the same", originalTopic.getName(), topic.getName());
    }

    @Test
    public void should_update() {

        final List<Topic> originalTopicList = topicMapper.list();
        final Topic originalTopic = originalTopicList.get(0);

        originalTopic.setName(SOMETHING_SOMETHING);
        topicMapper.update(originalTopic);

        final List<Topic> updatedTopicList = topicMapper.list();
        final Topic updatedTopic = updatedTopicList.get(0);
        assertEquals("Original and Updated topic should have the same ID", originalTopic.getId(),
                updatedTopic.getId());
        assertEquals("Unexpected name value for updated topic", SOMETHING_SOMETHING, updatedTopic
                .getName());

    }

}
