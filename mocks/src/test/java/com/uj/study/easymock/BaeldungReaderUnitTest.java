package com.uj.study.easymock;

import org.junit.*;

import java.util.NoSuchElementException;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

/**
 * The four steps mentioned above relate to methods in org.easymock.EasyMock:
 *
 * mock(…): generates a mock of the target class, be it a concrete class or an interface. Once created, a mock is in “recording” mode, meaning that EasyMock will record any action the Mock Object takes, and replay them in the “replay” mode
 * expect(…): with this method, we can set expectations, including calls, results, and exceptions, for associated recording actions
 * replay(…): switches a given mock to “replay” mode. Then, any action triggering previously recorded method calls will replay “recorded results”
 * verify(…): verifies that all expectations were met and that no unexpected call was performed on a mock
 * In the next section, we'll show how these steps work in action, using real-world examples.
 */
public class BaeldungReaderUnitTest {

    private BaeldungReader baeldungReader;

    private ArticleReader mockArticleReader;

    private IArticleWriter mockArticleWriter;

    @Test
    public void givenBaeldungReader_whenReadNext_thenNextArticleRead() {
        mockArticleReader = mock(ArticleReader.class);
        baeldungReader = new BaeldungReader(mockArticleReader);

        expect(mockArticleReader.next()).andReturn(null);
        replay(mockArticleReader);

        BaeldungArticle article = baeldungReader.readNext();
        verify(mockArticleReader);
        assertEquals(null, article);
    }

    @Test
    public void givenBaeldungReader_whenReadNextAndSkimTopics_thenAllAllowed() {
        mockArticleReader = strictMock(ArticleReader.class);
        baeldungReader = new BaeldungReader(mockArticleReader);

        expect(mockArticleReader.next()).andReturn(null);
        expect(mockArticleReader.ofTopic("easymock")).andReturn(null);
        replay(mockArticleReader);

        baeldungReader.readNext();
        baeldungReader.readTopic("easymock");
        verify(mockArticleReader);
    }

    @Test
    public void givenBaeldungReader_whenReadNextAndOthers_thenAllowed() {
        mockArticleReader = niceMock(ArticleReader.class);
        baeldungReader = new BaeldungReader(mockArticleReader);

        expect(mockArticleReader.next()).andReturn(null);
        replay(mockArticleReader);

        baeldungReader.readNext();
        baeldungReader.readTopic("easymock");
        verify(mockArticleReader);
    }

    @Test
    public void givenBaeldungReader_whenWriteMaliciousContent_thenArgumentIllegal() {
        mockArticleWriter = mock(IArticleWriter.class);
        baeldungReader = new BaeldungReader(mockArticleWriter);
        expect(mockArticleWriter.write("easymock", "<body onload=alert('baeldung')>")).andThrow(new IllegalArgumentException());
        replay(mockArticleWriter);

        Exception expectedException = null;
        try {
            baeldungReader.write("easymock", "<body onload=alert('baeldung')>");
        } catch (Exception exception) {
            expectedException = exception;
        }

        verify(mockArticleWriter);
        assertEquals(IllegalArgumentException.class, expectedException.getClass());
    }

    @Test
    public void givenBaeldungReader_whenWrite_thenWriterCalled() {
        mockArticleWriter = mock(IArticleWriter.class);
        baeldungReader = new BaeldungReader(mockArticleWriter);
        expect(mockArticleWriter.write("title", "content")).andReturn(null);
        replay(mockArticleWriter);
        String articleId = baeldungReader.write("title", "content");
        verify(mockArticleWriter);
        assertEquals(null, articleId);
    }

    @Test
    public void givenArticlesInReader_whenReadTillEnd_thenThrowException() {
        ArticleReader mockArticleReader = mock(ArticleReader.class);
        baeldungReader = new BaeldungReader(mockArticleReader);
        expect(mockArticleReader.next())
          .andReturn(null)
          .times(2)
          .andThrow(new NoSuchElementException());
        replay(mockArticleReader);
        try {
            for (int i = 0; i < 3; i++) {
                baeldungReader.readNext();
            }
        } catch (Exception ignored) {
        }
        verify(mockArticleReader);
    }

}