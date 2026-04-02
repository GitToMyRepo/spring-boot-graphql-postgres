package com.mywork.springgraphql.postgres.resolver;

import com.mywork.springgraphql.postgres.model.Author;
import com.mywork.springgraphql.postgres.model.Tutorial;
import com.mywork.springgraphql.postgres.repository.AuthorRepository;
import com.mywork.springgraphql.postgres.repository.TutorialRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@DgsComponent
public class TutorialDataFetcher {
    private static final Logger logger = LoggerFactory.getLogger(TutorialDataFetcher.class);

    private final AuthorRepository authorRepository;
    private final TutorialRepository tutorialRepository;

    public TutorialDataFetcher(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
        this.authorRepository = authorRepository;
        this.tutorialRepository = tutorialRepository;
    }

    @DgsQuery
    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @DgsQuery
    public long countAuthors() {
        return authorRepository.count();
    }

    @DgsQuery
    public Iterable<Tutorial> findAllTutorials() {
        logger.info("Finding all tutorials");
        return tutorialRepository.findAll();
    }

    @DgsQuery
    public long countTutorials() {
        return tutorialRepository.count();
    }

    @DgsQuery
    public Iterable<Tutorial> findTutorialsByAuthorName(@InputArgument String authorName) {
        logger.info("Finding tutorials by author: {}", authorName);
        return tutorialRepository.findByAuthor_NameIgnoreCase(authorName);
    }

    @DgsData(parentType = "Tutorial", field = "author")
    public Author author(DgsDataFetchingEnvironment dfe) {
        Tutorial tutorial = dfe.getSource();
        logger.debug("Getting author for {}", tutorial);
        return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow();
    }

    @DgsMutation
    public Author createAuthor(@InputArgument String name, @InputArgument Integer age) {
        Author author = new Author();
        author.setName(name);
        author.setAge(age);
        return authorRepository.save(author);
    }

    @DgsMutation
    public Tutorial createTutorial(@InputArgument String title, @InputArgument String description, @InputArgument Long author) {
        Tutorial tutorial = new Tutorial();
        tutorial.setAuthor(new Author(author));
        tutorial.setTitle(title);
        tutorial.setDescription(description);
        return tutorialRepository.save(tutorial);
    }

    @DgsMutation
    public boolean deleteTutorial(@InputArgument Long id) {
        tutorialRepository.deleteById(id);
        return true;
    }

    @DgsMutation
    public Tutorial updateTutorial(@InputArgument Long id, @InputArgument String title, @InputArgument String description) {
        Optional<Tutorial> optTutorial = tutorialRepository.findById(id);
        if (optTutorial.isPresent()) {
            Tutorial tutorial = optTutorial.get();
            if (title != null) tutorial.setTitle(title);
            if (description != null) tutorial.setDescription(description);
            return tutorialRepository.save(tutorial);
        }
        throw new EntityNotFoundException("Not found Tutorial to update!");
    }
}
