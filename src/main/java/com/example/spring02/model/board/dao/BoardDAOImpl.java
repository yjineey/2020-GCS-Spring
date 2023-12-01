package com.example.spring02.model.board.dao;
 
import java.util.List;
 
import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.spring02.model.board.dto.BoardVO;
 
@Repository   
public class BoardDAOImpl implements BoardDAO {
    @Inject
    SqlSession SqlSession;
    
	// 掲示物一覧
    @Override
    public List<BoardVO> listAll() throws Exception {
        return SqlSession.selectList("board.listAll");
    }
    // 掲示物作成
    @Override
    public void create(BoardVO vo) throws Exception {
        SqlSession.insert("board.insert", vo);
    }
    // 掲示物照会数追加
    @Override
    public void increaseViewcnt(int bno) throws Exception {
        SqlSession.update("board.increaseViewcnt", bno);
    }
    // 掲示物詳細見る
    @Override
    public BoardVO read(int bno) throws Exception {
        return SqlSession.selectOne("board.view", bno);
    }
    // 掲示物修正
    @Override
    public void update(BoardVO vo) throws Exception {
        SqlSession.update("board.updateArticle", vo);
    }
    // 掲示物削除
    @Override
    public void delete(int bno) throws Exception {
        SqlSession.delete("board.deleteArticle",bno);
    }
    // 掲示物削除check
    @Override
    public int existData(int bno) throws Exception {
       return SqlSession.selectOne("board.updatecheck", bno);     
    }
}
