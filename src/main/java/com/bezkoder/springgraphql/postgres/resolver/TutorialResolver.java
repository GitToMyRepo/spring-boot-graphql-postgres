package com.bezkoder.springgraphql.postgres.resolver;

import com.bezkoder.springgraphql.postgres.model.Author;
import com.bezkoder.springgraphql.postgres.model.Tutorial;
import com.bezkoder.springgraphql.postgres.repository.AuthorRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {
	private static final Logger logger = LoggerFactory.getLogger(TutorialResolver.class);
	@Autowired
	private AuthorRepository authorRepository;

	public TutorialResolver(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Author getAuthor(Tutorial tutorial) {
		logger.debug("Getting author for " + tutorial);
		return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
	}
}
