package org.springframework.samples.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.samples.bean.Fault;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

public interface FaultRepository extends ArangoRepository<Fault, String> {
}
