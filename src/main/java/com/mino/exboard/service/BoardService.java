package com.mino.exboard.service;


import com.mino.exboard.dto.BoardDTO;
import com.mino.exboard.dto.PageRequestDTO;
import com.mino.exboard.dto.PageResultDTO;
import com.mino.exboard.entity.Board;
import com.mino.exboard.entity.Member;

public interface BoardService {
    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);//목록처리

    BoardDTO get(Long bno);

    void removeWithReplies(Long bno);//삭제기능

    void modify(BoardDTO boardDTO);

    default Board dtoToEntity(BoardDTO dto) {
        Member member = Member.builder().email(dto.getWriterEmail()).build();

        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return board;
    }

    default BoardDTO entityToDTO(Board board, Member member, Long ReplyCount) {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(ReplyCount.intValue()) //long으로 나오므로 int로 처리
                .build();
        return boardDTO;

    }
}
