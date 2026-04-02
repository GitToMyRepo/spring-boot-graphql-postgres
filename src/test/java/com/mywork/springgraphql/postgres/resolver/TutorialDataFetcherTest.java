package com.mywork.springgraphql.postgres.resolver;

import com.mywork.springgraphql.postgres.model.Author;
import com.mywork.springgraphql.postgres.model.Tutorial;
import com.mywork.springgraphql.postgres.repository.AuthorRepository;
import com.mywork.springgraphql.postgres.repository.TutorialRepository;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TutorialDataFetcherTest {

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private TutorialRepository tutorialRepository;

    @Mock
    private DgsDataFetchingEnvironment dfe;

    @InjectMocks
    private TutorialDataFetcher tutorialDataFetcher;

    private Author author;
    private Tutorial tutorial;

    @BeforeEach
    void setUp() {
        author = new Author("George Orwell", 51);
        tutorial = new Tutorial("1984", "Dystopian novel", author);
    }

    @Test
    void findAllTutorials_returnsList() {
        when(tutorialRepository.findAll()).thenReturn(List.of(tutorial));

        Iterable<Tutorial> result = tutorialDataFetcher.findAllTutorials();

        assertThat(result).containsExactly(tutorial);
        verify(tutorialRepository).findAll();
    }

    @Test
    void findTutorialsByAuthorName_returnsMatchingTutorials() {
        when(tutorialRepository.findByAuthor_NameIgnoreCase("George Orwell")).thenReturn(List.of(tutorial));

        Iterable<Tutorial> result = tutorialDataFetcher.findTutorialsByAuthorName("George Orwell");

        assertThat(result).containsExactly(tutorial);
        verify(tutorialRepository).findByAuthor_NameIgnoreCase("George Orwell");
    }

    @Test
    void createTutorial_savesAndReturns() {
        when(tutorialRepository.save(any(Tutorial.class))).thenReturn(tutorial);

        Tutorial result = tutorialDataFetcher.createTutorial("1984", "Dystopian novel", 1L);

        assertThat(result.getTitle()).isEqualTo("1984");
        verify(tutorialRepository).save(any(Tutorial.class));
    }

    @Test
    void updateTutorial_updatesFieldsAndSaves() {
        when(tutorialRepository.findById(1L)).thenReturn(Optional.of(tutorial));
        when(tutorialRepository.save(tutorial)).thenReturn(tutorial);

        Tutorial result = tutorialDataFetcher.updateTutorial(1L, "Animal Farm", null);

        assertThat(result.getTitle()).isEqualTo("Animal Farm");
        assertThat(result.getDescription()).isEqualTo("Dystopian novel");
        verify(tutorialRepository).save(tutorial);
    }

    @Test
    void updateTutorial_throwsWhenNotFound() {
        when(tutorialRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> tutorialDataFetcher.updateTutorial(99L, "Title", null))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("Not found Tutorial to update!");
    }

    @Test
    void deleteTutorial_callsDeleteById() {
        tutorialDataFetcher.deleteTutorial(1L);

        verify(tutorialRepository).deleteById(1L);
    }

    @Test
    void author_resolvesFromRepository() {
        when(dfe.getSource()).thenReturn(tutorial);
        when(authorRepository.findById(any())).thenReturn(Optional.of(author));

        Author result = tutorialDataFetcher.author(dfe);

        assertThat(result.getName()).isEqualTo("George Orwell");
        verify(authorRepository).findById(any());
    }
}
