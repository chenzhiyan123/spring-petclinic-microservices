package org.springframework.samples.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import org.springframework.samples.bean.Fault;
import org.springframework.samples.bean.FaultEdge;

public interface FaultEdgeRepository extends ArangoRepository<FaultEdge, String> {
}
