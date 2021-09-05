package com.mino.exboard.repository;

import com.mino.exboard.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
    @Modifying
    @Query("delete from Reply r where r.board.bno =:bno ")
    void deleteByBno(@Param("bno") Long bno);
}
