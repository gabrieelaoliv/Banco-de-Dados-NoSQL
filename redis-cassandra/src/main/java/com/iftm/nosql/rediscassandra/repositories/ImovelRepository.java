package com.iftm.nosql.rediscassandra.repositories;

package com.iftm.nosql.rediscassandra.entities.Imovel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImovelRepository extends CassandraRepository<Imovel, UUID> {
}
