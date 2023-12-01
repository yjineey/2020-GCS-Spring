package com.example.spring02.model.board.dao;
 
import java.util.List;


import com.example.spring02.model.board.dto.BoardVO;
 
public interface BoardDAO {
	
    // 掲示物一覧
    public List<BoardVO> listAll() throws Exception;
    // 掲示物作成
    public void create(BoardVO vo) throws Exception;
    // 掲示物照会数追加
    public void increaseViewcnt(int bno) throws Exception;
    // 掲示物詳細見る
    public BoardVO read(int bno) throws Exception;
    // 掲示物 修正
    public void update(BoardVO vo) throws Exception;
    // 掲示物の削除
    public void delete(int bno) throws Exception;
    // 掲示物詳細内容照会
    public int existData(int bno) throws Exception;
}
