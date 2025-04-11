package site.nansan.en.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import site.nansan.en.entity.SolvedProblem;

public interface SolvedProblemRepository extends MongoRepository<SolvedProblem, String> {


}
