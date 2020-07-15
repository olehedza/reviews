package com.olehedza.reviews.repository;

import com.olehedza.reviews.model.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query("select w.id, w.word from Word w" +
            " group by w.word order by count(w.word) desc")
    Page<Word> queryFirst1000(Pageable pageable);
}
