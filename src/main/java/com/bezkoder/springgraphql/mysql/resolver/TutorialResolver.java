package com.bezkoder.springgraphql.mysql.resolver;

import com.bezkoder.springgraphql.mysql.SpringBootGraphqlMysqlApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bezkoder.springgraphql.mysql.model.Author;
import com.bezkoder.springgraphql.mysql.model.Tutorial;
import com.bezkoder.springgraphql.mysql.repository.AuthorRepository;

import graphql.kickstart.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {
	private static final Logger logger = LoggerFactory.getLogger(TutorialResolver.class);
	@Autowired
	private AuthorRepository authorRepository;

	public TutorialResolver(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Author getAuthor(Tutorial tutorial) {
		logger.info("Getting author for " + tutorial);
		return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
	}
}
