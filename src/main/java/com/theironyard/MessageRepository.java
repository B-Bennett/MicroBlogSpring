package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by BennettIronYard on 11/10/15.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
