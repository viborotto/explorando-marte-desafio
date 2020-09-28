package com.viborotto.explorandomarte.repository;

import com.viborotto.explorandomarte.model.Sonda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SondaRepository extends CrudRepository<Sonda, Long> {
}
